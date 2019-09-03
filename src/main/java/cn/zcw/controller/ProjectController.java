package cn.zcw.controller;

import cn.zcw.bean.*;
import cn.zcw.service.ProjectService;
import cn.zcw.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 加载项目类别初始数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/loadTypeData.do")
    public List loadProjectTypeData() {
        List<Type> types = projectService.getProjectTypeAll();
        System.out.println(types);
        System.out.println("/loadTypeData.do");
        return types;
    }

    @ResponseBody
    @RequestMapping("/loadTagData.do")
    public List loadProjectTagData(){
        List<Tag> tags = projectService.getProjectTagAll();
        return tags;
    }

    @ResponseBody
    @RequestMapping("/savaProject.do")
    public Object saveProject(HttpServletRequest request){
        System.out.println("/savaProject.do");
        AJAXResult result = new AJAXResult();
        Map<String, String> map = UploadUtil.upload2(request);
        String flag = projectService.saveProject(map);
        if(flag == "success"){
            result.setSuccess(true);
        }else {result.setSuccess(false);}
        return result;
    }
}
