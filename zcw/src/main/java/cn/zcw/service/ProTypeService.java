package cn.zcw.service;

import cn.zcw.bean.Datas;
import cn.zcw.bean.Type;
import cn.zcw.util.PageBean;

public interface ProTypeService {

	PageBean<Type> getTypeList(String querytext, Integer selectPageno, Integer pageSize);

	int insert(Type type);

	Type queryById(Integer id);

	int update(Type type);

	int delete(Integer id);

	int deletes(Datas ds);

}
