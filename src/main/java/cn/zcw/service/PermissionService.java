package cn.zcw.service;

import java.util.List;

import cn.zcw.bean.Permission;

public interface PermissionService {

	List<Permission> queryAll();

	List<Permission> queryChildPermissions(Integer id);

	int insert(Permission permission);

	Permission queryById(Integer id);

	int update(Permission permission);

	int delete(Integer id);

	List<Integer> queryPermissionIdsByRoleid(Integer roleid);

	
}
