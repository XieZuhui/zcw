package cn.zcw.service;

import cn.zcw.bean.Param;
import cn.zcw.util.PageBean;

public interface ParamService {

	PageBean<Param> getParamList(String querytext, Integer selectPageno, Integer pageSize);

	Param queryById(Integer id);

	int update(Param param);

}
