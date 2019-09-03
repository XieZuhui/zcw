package cn.zcw.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zcw.bean.AJAXResult;
import cn.zcw.bean.Datas;
import cn.zcw.bean.Role;
import cn.zcw.service.RoleService;
import cn.zcw.util.PageBean;

@Controller
@RequestMapping("/managers/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	//分页查询、模糊查询
	@ResponseBody
	@RequestMapping("/RolepageQuery.do")
	public Object pageQuery(String querytext,Integer pageno, Integer pageSize) {
		AJAXResult<Role> result = new AJAXResult<>();
		PageBean<Role> pb = new PageBean<>();
		Integer selectPageno = (pageno-1)*pageSize;
		pb = roleService.getRoleList(querytext,selectPageno,pageSize);
		result.setSuccess(true);
		result.setPageBean(pb);
		return result;
	}
	
	//角色添加
    @ResponseBody
	@RequestMapping("/insert.do")
	public Object addRole(Role role) {
		AJAXResult<Role> result = new AJAXResult<>();
		try {
			int num = roleService.insert(role);
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
    	Role role = roleService.queryById(id);
    	model.addAttribute("role", role);
    	return "/managers/role/editrole.jsp";
    }
    
    //修改角色
    @ResponseBody
	@RequestMapping("/update.do")
	public Object updateRole(Role role) {
		AJAXResult<Role> result = new AJAXResult<>();
		try {
			int num = roleService.update(role);
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
    
    //删除角色
    @ResponseBody
	@RequestMapping("/delete.do")
	public Object deleteRole(Integer id) {
		AJAXResult<Role> result = new AJAXResult<>();
		try {
			int num = roleService.delete(id);
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
    
    //批量删除角色
    @ResponseBody
	@RequestMapping("/deletes.do")
	public Object deletesRole(Datas ds) {
		AJAXResult<Role> result = new AJAXResult<>();
		try {
			int num = roleService.deletes(ds);
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
	
  //查询t_role_permission表
    @RequestMapping("/assign.do")
    public String assign(Integer id, Model model) {
    	//根据主键查询角色信息
    	Role role = roleService.queryById(id);
    	model.addAttribute("role", role);
    	
    	return "/managers/role/assignPermission.jsp";
    }
    
    //向t_role_permission添加数据
    @ResponseBody
	@RequestMapping("/assignPermission.do")
	public Object assignPermission(Integer roleid, Datas ds) {
		AJAXResult<Role> result = new AJAXResult<>();
		try {
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("roleid", roleid);
			maps.put("permissionids", ds.getIds());
			int num = roleService.insertRolePermissions(maps);
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
