package cn.zcw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zcw.bean.Datas;
import cn.zcw.bean.Type;
import cn.zcw.bean.TypeExample;
import cn.zcw.mapper.TypeMapper;
import cn.zcw.service.ProTypeService;
import cn.zcw.util.PageBean;

@Service
public class ProTypeServiceImpl implements ProTypeService {

	@Autowired
	private TypeMapper typeMapper;

	@Override
	public PageBean<Type> getTypeList(String querytext, Integer selectPageno, Integer pageSize) {
		TypeExample example = new TypeExample();
        PageBean<Type> pb = new PageBean<>();
        pb.setPageno(selectPageno);
        pb.setPagesize(pageSize);
        if (querytext!=null && querytext.trim()!=""){
           example.createCriteria().andNameLike(querytext.trim());
        }
        example.setLeftLimit(pb.getPageno());
        example.setLimitSize(pb.getPagesize());
        pb.setTotalsize(typeMapper.countByExample(example));
        pb.setDatas(typeMapper.selectByExample(example));
        return pb;
	}

	@Override
	public int insert(Type type) {
		return typeMapper.insert(type);
	}

	@Override
	public Type queryById(Integer id) {
		return typeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Type type) {
		return typeMapper.updateByPrimaryKeySelective(type);
	}

	@Override
	public int delete(Integer id) {
		return typeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deletes(Datas ds) {
		return typeMapper.deletes(ds);
	}
	
	
}
