package cn.zcw.service;



import cn.zcw.bean.Tag;
import cn.zcw.bean.Type;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    List<Type> getProjectTypeAll();

    List<Tag> getProjectTagAll();

    String saveProject(Map<String, String> map);
}
