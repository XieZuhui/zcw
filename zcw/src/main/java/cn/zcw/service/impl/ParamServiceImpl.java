package cn.zcw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zcw.bean.Param;
import cn.zcw.bean.ParamExample;
import cn.zcw.mapper.ParamMapper;
import cn.zcw.service.ParamService;
import cn.zcw.util.PageBean;

@Service
public class ParamServiceImpl implements ParamService {

	@Autowired
	private ParamMapper paramMapper;

	@Override
	public PageBean<Param> getParamList(String querytext, Integer selectPageno, Integer pageSize) {
		ParamExample example = new ParamExample();
        PageBean<Param> pb = new PageBean<>();
        pb.setPageno(selectPageno);
        pb.setPagesize(pageSize);
        if (querytext!=null && querytext.trim()!=""){
           example.createCriteria().andNameLike(querytext.trim());
        }
        example.setLeftLimit(pb.getPageno());
        example.setLimitSize(pb.getPagesize());
        pb.setTotalsize(paramMapper.countByExample(example));
        pb.setDatas(paramMapper.selectByExample(example));
        return pb;
	}

	@Override
	public Param queryById(Integer id) {
		return paramMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Param param) {
		return paramMapper.updateByPrimaryKeySelective(param);
	}
	
}
