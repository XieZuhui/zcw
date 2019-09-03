package cn.zcw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zcw.bean.AJAXResult;
import cn.zcw.bean.Permission;
import cn.zcw.service.PermissionService;

@Controller
@RequestMapping("/managers/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@ResponseBody
	@RequestMapping("/loadDatas.do")
	public Object loadDatas() {
		AJAXResult<Permission> result = new AJAXResult<Permission>();
		try {
			//第一种：递归查询许可数据(需查询多遍，浪费时间，可能造成栈溢出)
//			Permission parent = new Permission();
//			parent.setId(0);
//			queryChildPermissions(parent);
			
			//第二种：查询一遍数据库，在内存中整合关系(数据越大，循环次数越多)
			List<Permission> roots = new ArrayList<Permission>();
			List<Permission> permissions = permissionService.queryAll();
			//采用嵌套for循环
			//查找父节点和子节点
		/*	for (Permission permission : permissions) {
				if (permission.getPid() == 0) {
					roots.add(permission);
				} else {
					//子节点
					Permission child = permission;
					for (Permission innerPermission : permissions) {
						if (child.getPid() == innerPermission.getId()) {
							//父节点
							Permission parent = innerPermission;
							//组合父子节点的关系
							parent.getChildren().add(child);
							break;
						}
					}
				}
			}*/
			
			//第三种：采用map集合的处理方式整合父子节点
			Map<Integer, Permission> permissionMap = new HashMap<Integer,Permission>();
			for (Permission permission : permissions) {
				permissionMap.put(permission.getId(), permission);
			}//把数据放在map中
			for (Permission permission : permissions) {
				if (permission.getPid() == 0) {
					roots.add(permission);
				} else {
					//子节点
					Permission child = permission;
					//父节点
					Permission parent = permissionMap.get(child.getPid());
					//组合父子节点关系
					parent.getChildren().add(child);
				}
			}
			//查询数据
			result.setData(roots);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
	/***
	 * 查询子节点
	 * 递归算法
	 * 1.自己调自己
	 * 2.算法应该具有跳出的逻辑
	 * 3.算法的参数传递之间应该有关系
	 */
	private void queryChildPermissions(Permission parent) {
		//查询子节点集合
		List<Permission> childPermissions = permissionService.queryChildPermissions(parent.getId());
		for (Permission child : childPermissions) {
			queryChildPermissions(child);
		}
		//组合父子节点的关系
		parent.setChildren(childPermissions);
	}
	
	//异步查询被勾选的数据
	@ResponseBody
	@RequestMapping("/loadAsyncCheckedDatas.do")
	public Object loadAsyncCheckedDatas(Integer roleid) {
		List<Permission> roots = new ArrayList<Permission>();
		List<Permission> permissions = permissionService.queryAll();
		//获取角色许可的关系数据
		List<Integer> permissionIds = permissionService.queryPermissionIdsByRoleid(roleid);
		
		Map<Integer, Permission> permissionMap = new HashMap<Integer,Permission>();
		for (Permission permission : permissions) {
			//判断当前许可是否在关系数据中
			if (permissionIds.contains(permission.getId())) {
				permission.setChecked(true);
			}
			permissionMap.put(permission.getId(), permission);
		}//把数据放在map中
		for (Permission permission : permissions) {
			if (permission.getPid() == 0) {
				roots.add(permission);
			} else {
				//子节点
				Permission child = permission;
				//父节点
				Permission parent = permissionMap.get(child.getPid());
				//组合父子节点关系
				parent.getChildren().add(child);
			}
		}
		return roots;
	}
	
	//异步查询数据
	@ResponseBody
	@RequestMapping("/loadAsyncDatas.do")
	public Object loadAsyncDatas() {
		List<Permission> roots = new ArrayList<Permission>();
		List<Permission> permissions = permissionService.queryAll();
		Map<Integer, Permission> permissionMap = new HashMap<Integer,Permission>();
		for (Permission permission : permissions) {
			permissionMap.put(permission.getId(), permission);
		}//把数据放在map中
		for (Permission permission : permissions) {
			if (permission.getPid() == 0) {
				roots.add(permission);
			} else {
				//子节点
				Permission child = permission;
				//父节点
				Permission parent = permissionMap.get(child.getPid());
				//组合父子节点关系
				parent.getChildren().add(child);
			}
		}
		return roots;
	}
	
	@RequestMapping("/add.do")
	public String add() {
		return "/managers/permission/add.jsp";
	}
	
	//许可添加
	@ResponseBody
	@RequestMapping("/insert.do")
	public Object addPermission(Permission permission) {
		AJAXResult<Permission> result = new AJAXResult<Permission>();
		try {
			int num = permissionService.insert(permission);
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
    	Permission permission = permissionService.queryById(id);
    	model.addAttribute("permission", permission);
    	return "/managers/permission/edit.jsp";
    }
    
  //许可修改
  	@ResponseBody
  	@RequestMapping("/update.do")
  	public Object updatePermission(Permission permission) {
  		AJAXResult<Permission> result = new AJAXResult<Permission>();
  		try {
  			int num = permissionService.update(permission);
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
  	
  //许可删除
  	@ResponseBody
  	@RequestMapping("/delete.do")
  	public Object deletePermission(Integer id) {
  		AJAXResult<Permission> result = new AJAXResult<Permission>();
  		try {
  			int num = permissionService.delete(id);
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
}
