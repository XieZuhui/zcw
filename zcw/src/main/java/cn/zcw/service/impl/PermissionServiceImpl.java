package cn.zcw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zcw.bean.Permission;
import cn.zcw.bean.PermissionExample;
import cn.zcw.mapper.PermissionMapper;
import cn.zcw.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> queryAll() {
		PermissionExample example = new PermissionExample();
		return permissionMapper.selectByExample(example);
	}

	@Override
	public List<Permission> queryChildPermissions(Integer id) {
		return permissionMapper.queryChildPermissions(id);
	}

	@Override
	public int insert(Permission permission) {
		return permissionMapper.insertSelective(permission);
	}

	@Override
	public Permission queryById(Integer id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Permission permission) {
		return permissionMapper.updateByPrimaryKeySelective(permission);
	}

	@Override
	public int delete(Integer id) {
		return permissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Integer> queryPermissionIdsByRoleid(Integer roleid) {
		return permissionMapper.queryPermissionIdsByRoleid(roleid);
	}

	
}
