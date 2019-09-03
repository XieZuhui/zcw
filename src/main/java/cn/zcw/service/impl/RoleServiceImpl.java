package cn.zcw.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zcw.bean.Datas;
import cn.zcw.bean.Role;
import cn.zcw.bean.RoleExample;
import cn.zcw.mapper.RoleMapper;
import cn.zcw.service.RoleService;
import cn.zcw.util.PageBean;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> queryAll() {
		RoleExample example = new RoleExample();
		List<Role> list = roleMapper.selectByExample(example);
		return list;
	}

	@Override
	public PageBean<Role> getRoleList(String querytext, Integer selectPageno, Integer pageSize) {
		RoleExample example = new RoleExample();
        PageBean<Role> pb = new PageBean<>();
        pb.setPageno(selectPageno);
        pb.setPagesize(pageSize);
        if (querytext!=null && querytext.trim()!=""){
           example.createCriteria().andNameLike(querytext.trim());
        }
        example.setLeftLimit(pb.getPageno());
        example.setLimitSize(pb.getPagesize());
        pb.setTotalsize(roleMapper.countByExample(example));
        pb.setDatas(roleMapper.selectByExample(example));
        return pb;
	}

	@Override
	public int insert(Role role) {
		return roleMapper.insert(role);
	}

	@Override
	public Role queryById(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Role role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public int delete(Integer id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deletes(Datas ds) {
		return roleMapper.deletes(ds);
	}

	@Override
	public List<Integer> queryPermissionidsByRoleid(Integer id) {
		return roleMapper.queryPermissionidsByRoleid(id);
	}

	@Override
	public int insertRolePermissions(Map<String, Object> maps) {
		// 删除当前角色所有旧的权限信息
		roleMapper.deletePermissionsByRoleid(maps);
		return roleMapper.insertRolePermissions(maps);
	}

}
