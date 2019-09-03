package cn.zcw.controller;

import cn.zcw.bean.AJAXResult;
import cn.zcw.bean.Datas;
import cn.zcw.bean.Member;
import cn.zcw.bean.Permission;
import cn.zcw.bean.Role;
import cn.zcw.bean.User;
import cn.zcw.service.RoleService;
import cn.zcw.service.UserService;
import cn.zcw.util.MD5Util;
import cn.zcw.util.PageBean;
import cn.zcw.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/managers")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/reg.do")
    public String doRegist(Member member,Model model){
        userService.regist(member);
        model.addAttribute("msg","请快去邮箱激活账号");
        model.addAttribute("isSuccess","success");
        return "/managers/success.jsp";
    }

    @RequestMapping("/newValidateCode.do")
    public String newValidateCode(String validateCode,Model model){
        userService.registMore(validateCode);
        model.addAttribute("msg","邮件已重新发送，请快去邮箱激活账号");
        model.addAttribute("isSuccess","success");
        return "/managers/success.jsp";
    }

    @RequestMapping("/validate.do")
    public String validate(String validateCode, Model model){
        int flag = userService.validate(validateCode);
        if(flag==1){
            System.out.println("激活成功");
            model.addAttribute("msg","恭喜您激活成功");
            model.addAttribute("isSuccess","success");
            return "/managers/success.jsp";
        }
        if (flag==2){
            System.out.println("已经激活了呀");
            model.addAttribute("msg","您已经激活了呀");
            model.addAttribute("isSuccess","success");
            return "/managers/success.jsp";
        }
        System.out.println("激活失败了");
        model.addAttribute("msg","激活失败了，请重试");
        model.addAttribute("isSuccess","fail");
        return "/managers/success.jsp";
    }

    @ResponseBody
    @RequestMapping("/regSelect.do")
    public Object regSelect(String loginacct){
        System.out.println("/regSelect.do");
        AJAXResult result = new AJAXResult();
        int flag = userService.regSelect(loginacct);
        if(flag!=1){
            //不等于1说明查询到有账号为loginacct的用户存在，则返回success，提醒重新输入进行注册
            result.setSuccess(true);
            return  result;
        }else
        result.setSuccess(false);
        return result;
    }

   /* @RequestMapping("/login.do")
    public String doLogin(User user){
        int flag = userService.doLogin(user);
        if(flag==-1){
            return "/managers/login.jsp";
        }else {
        return "";
        }
    }*/

    /**
     * 在main页面显示当前登录的用户用户名的ajax方法(main1.html中运用)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUsername.do")
   public Object getUsername(HttpServletRequest request){
        HttpSession session = request.getSession();
       AJAXResult result = new AJAXResult();
       String name = (String)session.getAttribute("loginedUser");
       //System.out.println("2222username:"+name);
        if (name != null) {
            result.setUsername(name);
            result.setSuccess(true);
            return result;
        }
        result.setSuccess(false);
        return result;
   }

   @ResponseBody
   @RequestMapping("/userlogin.do")
   public Object doUserLogin(User user, HttpServletRequest request){
       HttpSession session = request.getSession(true);
       user.setUserpswd(MD5Util.digest(user.getUserpswd()));
       AJAXResult result = new AJAXResult();
       try {
           List<User> userList = userService.doUserLogin(user);
           if(userList.isEmpty()){
               result.setSuccess(false);
           }else {
               //保存登录用户信息
               session.setAttribute("loginedUser",userList.get(0).getUsername());
               
               //保存用户的权限菜单（许可）信息
               List<Permission> permissions = userService.queryPermissionsByUserid(userList.get(0).getId());
               
               //组合父子菜单的关系
               Permission root = null;
               Map<Integer, Permission> permissionMap = new HashMap<Integer,Permission>();
       		   for (Permission permission : permissions) {
       			   //判断当前许可是否在关系数据中
       			   permissionMap.put(permission.getId(), permission);
       		   }//把数据放在map中
       		   for (Permission permission : permissions) {
       			   if (permission.getPid() == 0) {
       				   root = permission;
       			   } else {
       				   //子菜单
       				   Permission child = permission;
       				   //父菜单
       				   Permission parent = permissionMap.get(child.getPid());
       				   //组合父子菜单关系
       				   parent.getChildren().add(child);
       			   }
       		   }
       		   session.setAttribute("rootPermission", root);
               result.setSuccess(true);
           }
       }catch (Exception e){
           e.printStackTrace();
           result.setSuccess(false);
       }
       return result;
   }

    @ResponseBody
    @RequestMapping("/memberlogin.do")
    public Object doMemberLogin(Member member, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        member.setUserpswd(MD5Util.digest(member.getUserpswd()));
        AJAXResult result = new AJAXResult();
        try {
            List<Member> memberList = userService.doMemberLogin(member);
            if(memberList.isEmpty()){
                result.setSuccess(false);
            }else {
                result.setSuccess(true);
                //result.setUsername(userList.get(0).getUsername());
                session.setAttribute("loginedUser",memberList.get(0).getUsername());
                //System.out.println("1111username:"+userList.get(0).getUsername());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

   @ResponseBody
   @RequestMapping("/UserpageQuery.do")
   public Object pageQuery(String querytext,Integer pageno, Integer pageSize) {
        System.out.println("http://localhost/UserpageQuery.do");
        AJAXResult<User> result = new AJAXResult<>();
        PageBean<User> pb = new PageBean<>();
        Integer selectPageno = (pageno-1)*pageSize;
            pb = userService.getUserList(querytext,selectPageno,pageSize);
            result.setSuccess(true);
            result.setPageBean(pb);

        System.out.println("给点？："+pb.getDatas().toString());
        return result;
   }

    @RequestMapping("/gotoEdit.do")
   public String gotoEdit( HttpServletRequest request)throws Exception{
        //AJAXResult<User> result = new AJAXResult<>();
        System.out.println("gogoggogogogogogg111111");
        //System.out.println(user.getUsername());
        return "redirect:/managers/edit2.html";
    }

    @ResponseBody
    @RequestMapping("/getBackSendMail.do")
    public  Object getBackSendMail(String loginacct){
        AJAXResult ajaxResult = new AJAXResult();
        int flag = userService.getBackSendMail(loginacct);
        if(flag == 1){
            ajaxResult.setSuccess(true);
        }else {
            ajaxResult.setSuccess(false);
        }
        return ajaxResult;
    }

    @RequestMapping("/getBackPwd.do")
    public String getBackPwd(String validateCode,Model model){
        Member member = userService.getMemberByValidateCode(validateCode);
        if(member!=null){
            model.addAttribute("memberid",member.getId());
            model.addAttribute("username",member.getUsername());
            return "/managers/getBackPwd.jsp";
        }
        return "/error.jsp";
    }

    @ResponseBody
    @RequestMapping("/updataMemberPwd.do")
    public Object updataMemberPwd(Member member){
        AJAXResult ajaxResult = new AJAXResult();
        member.setUserpswd(MD5Util.digest(member.getUserpswd()));
        int flag = userService.updateMemberPwd(member);
        if(flag==1){
            ajaxResult.setSuccess(true);
            return ajaxResult;
            //return "redirect:/managers/login.html";
        }
        ajaxResult.setSuccess(false);
        return ajaxResult;
        //return "error.jsp";
    }

    //用户登出
    @RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		//清除用户信息
		session.invalidate();
		return "redirect:/managers/login.html";
	}
    
    //用户添加
    @ResponseBody
	@RequestMapping("/insert.do")
	public Object addUser(User user) {
		AJAXResult<User> result = new AJAXResult<>();
		try {
			user.setUserpswd(MD5Util.digest("123456"));
			user.setCreatetime(StringUtil.getSystemTime());
			int num = userService.insert(user);
			if (num >= 1) {
				result.setSuccess(true);
			}else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
    
    //根据id获得修改id的所有信息
    @RequestMapping("/edit.do")
    public String edit(Integer id, Model model) {
    	User user = userService.queryById(id);
    	model.addAttribute("user", user);
    	return "/managers/user/edituser.jsp";
    }
    
    //修改用户
    @ResponseBody
	@RequestMapping("/update.do")
	public Object updateUser(User user) {
		AJAXResult<User> result = new AJAXResult<>();
		try {
			int num = userService.update(user);
			if (num >= 1) {
				result.setSuccess(true);
			}else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
    
    //删除用户
    @ResponseBody
	@RequestMapping("/delete.do")
	public Object deleteUser(Integer id) {
		AJAXResult<User> result = new AJAXResult<>();
		try {
			int num = userService.delete(id);
			if (num >= 1) {
				result.setSuccess(true);
			}else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
    
    //批量删除用户
    @ResponseBody
	@RequestMapping("/deletes.do")
	public Object deletesUser(Datas ds) {
		AJAXResult<User> result = new AJAXResult<>();
		try {
			int num = userService.deletes(ds);
			if (num == ds.getIds().size()) {
				result.setSuccess(true);
			}else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
    
    //查询t_user_role表
    @RequestMapping("/assign.do")
    public String assign(Integer id, Model model) {
    	User user = userService.queryById(id);
    	model.addAttribute("user", user);
    	//查询所有的角色数据
    	List<Role> roles = roleService.queryAll();
    	//获取当前用户所分配的roleid集合
    	List<Integer> roleIds = userService.queryRoleidsByUserid(id);
    	//未分配角色列表
    	List<Role> unassignList = new ArrayList<Role>();
    	//已分配角色列表
    	List<Role> assignList = new ArrayList<Role>();
    	//循环遍历集合  根据当前用户的roleid集合中是否有roleid来判断存放在哪里
    	for (Role role : roles) {
			if (roleIds.contains(role.getId())) {
				assignList.add(role);
			} else {
				unassignList.add(role);
			}
		}
    	model.addAttribute("unassignList", unassignList);
    	model.addAttribute("assignList", assignList);
    	return "/managers/user/assignRole.jsp";
    }
    
    //向t_user_role添加数据（左--》右）
    @ResponseBody
	@RequestMapping("/assignRole.do")
	public Object assignRole(Integer userid, Datas ds) {
		AJAXResult<User> result = new AJAXResult<>();
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("userid", userid);
			maps.put("roleids", ds.getIds());
			int num = userService.insertUserRoles(maps);
			if (num == ds.getIds().size()) {
				result.setSuccess(true);
			}else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
    
    //从t_user_role删除数据（右--》左）
    @ResponseBody
	@RequestMapping("/unassignRole.do")
	public Object unassignRole(Integer userid, Datas ds) {
		AJAXResult<User> result = new AJAXResult<>();
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("userid", userid);
			maps.put("roleids", ds.getIds());
			int num = userService.deleteUserRoles(maps);
			if (num == ds.getIds().size()) {
				result.setSuccess(true);
			}else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
}
