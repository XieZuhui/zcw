package cn.zcw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zcw.bean.Cert;
import cn.zcw.bean.CertExample;
import cn.zcw.bean.Datas;
import cn.zcw.mapper.CertMapper;
import cn.zcw.service.CertService;
import cn.zcw.util.PageBean;

@Service
public class CertServiceImpl implements CertService {

	@Autowired
	private CertMapper certMapper;

	@Override
	public PageBean<Cert> getCertList(String querytext, Integer selectPageno, Integer pageSize) {
		CertExample example = new CertExample();
        PageBean<Cert> pb = new PageBean<>();
        pb.setPageno(selectPageno);
        pb.setPagesize(pageSize);
        if (querytext!=null && querytext.trim()!=""){
           example.createCriteria().andNameLike(querytext.trim());
        }
        example.setLeftLimit(pb.getPageno());
        example.setLimitSize(pb.getPagesize());
        pb.setTotalsize(certMapper.countByExample(example));
        pb.setDatas(certMapper.selectByExample(example));
        return pb;
	}

	@Override
	public int insert(Cert cert) {
		return certMapper.insert(cert);
	}

	@Override
	public Cert queryById(Integer id) {
		return certMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Cert cert) {
		return certMapper.updateByPrimaryKeySelective(cert);
	}

	@Override
	public int delete(Integer id) {
		return certMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deletes(Datas ds) {
		return certMapper.deletes(ds);
	}
	
}
