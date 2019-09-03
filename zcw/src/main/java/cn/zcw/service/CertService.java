package cn.zcw.service;

import cn.zcw.bean.Cert;
import cn.zcw.bean.Datas;
import cn.zcw.util.PageBean;

public interface CertService {

	PageBean<Cert> getCertList(String querytext, Integer selectPageno, Integer pageSize);

	int insert(Cert cert);

	Cert queryById(Integer id);

	int update(Cert cert);

	int delete(Integer id);

	int deletes(Datas ds);

}
