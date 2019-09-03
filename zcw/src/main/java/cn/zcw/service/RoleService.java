package cn.zcw.service;

import java.util.List;
import java.util.Map;

import cn.zcw.bean.Datas;
import cn.zcw.bean.Role;
import cn.zcw.util.PageBean;

public interface RoleService {

	List<Role> queryAll();

	PageBean<Role> getRoleList(String querytext, Integer selectPageno, Integer pageSize);

	int insert(Role role);

	Role queryById(Integer id);

	int update(Role role);

	int delete(Integer id);

	int deletes(Datas ds);

	List<Integer> queryPermissionidsByRoleid(Integer id);

	int insertRolePermissions(Map<String, Object> maps);

	

	
}
