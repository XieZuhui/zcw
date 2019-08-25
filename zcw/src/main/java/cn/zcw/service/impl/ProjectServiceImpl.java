package cn.zcw.service.impl;

import cn.zcw.bean.*;
import cn.zcw.mapper.*;
import cn.zcw.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private Project_typeMapper project_typeMapper;
    @Autowired
    private Project_tagMapper project_tagMapper;
    @Autowired
    private Project_memberMapper project_memberMapper;

    public List<Type> getProjectTypeAll(){
        TypeExample typeExample = new TypeExample();
        List<Type> types = typeMapper.selectByExample(typeExample);
        return types;
    }

    public List<Tag> getProjectTagAll(){
        TagExample tagExample = new TagExample();
        List<Tag> tags = tagMapper.selectByExample(tagExample);
        return tags;
    }

    public String saveProject(Map<String, String> map){
        String str = null;
        try{
        if(map != null) {
            // 如果有新的要添加的标签 则 添加标签数据
            //添加项目数据  生成新的项目id
            int pid=addProject(map);
            System.out.println("PID:"+pid);
            if(pid!=0) {
                //根据添加新的项目id 添加两个中间表数据 t_project_tag、t_project_type
                int num=addProjectTagType(map,pid);
                //根据添加新的项目id 添加项目和会员 关联表数据 t_project_menber
                num += addProjectMenber(map,pid);
                if(num>=3) {
                   str = "success";
                }else {
                    str = "error";
                }
            }else {
                str = "error";
            }
        }else {
            str = "error";
        }
    }catch(Exception e) {
        e.printStackTrace();
    }
        return  str;
    }

    private int addProject(Map<String, String> map) {
        String prjname = map.get("prjname");
        String remark = map.get("remark");
        String money = map.get("money");
        String day = map.get("day");
        //上传的图片地址 保存
        String iconpath = map.get("iconpath");
        String imgpath = map.get("imgpath");
        System.out.println(day);
        //TODO 保存之前 按照规则进行验证
        Double money1 = Double.parseDouble(money);//筹资金额不能低于100元,不能高于1000000000元
        int day1 = Integer.parseInt(day);//般10-90天，建议30天
        Project project = new Project(prjname, remark, money1, day1);
        project.setIconpath(iconpath);
        project.setImgpath(imgpath);

        int num = projectMapper.insertSelective(project);
        if(num>=1) {
            return project.getId();
        }
        return 0;
    }

    private int addProjectTagType(Map<String, String> map,int pid) {
        int num=0;
        //保存项目和类别 中间表信息
        String typeid = map.get("typeid");
        if(typeid!=null && !"".equals(typeid)) {
            int tid  = Integer.parseInt(typeid);
            Project_type ptv = new Project_type(pid,tid);
            num += project_typeMapper.insertSelective(ptv);
        }
        //保存项目和标签 中间表信息
        //拆分 tag的id
        String tagIds = map.get("tagIds");
        String[] ids = tagIds.split(",");
        for (int i = 0; i < ids.length; i++) {
            if(!"".equals(ids[i])) {
                int tid  = Integer.parseInt(ids[i]);
                Project_tag ptv = new  Project_tag(pid,tid);
                num += project_tagMapper.insertSelective(ptv);
            }
        }
        return num;
    }

    /**
     * 根据添加新的项目id 添加项目和会员 关联表数据
     * @param
     * @return
     */
    private int addProjectMenber(Map<String, String> map,int projectid) {
        String introduce = map.get("introduce");
        String particulars = map.get("particulars");
        String contactTel = map.get("contactTel");
        String customerTel = map.get("customerTel");
        int memberid = 1;//TODO 从session中保存的用户对象中获取用户id
        Project_member pm = new Project_member(projectid, memberid, introduce, particulars, contactTel, customerTel);
        return project_memberMapper.insertSelective(pm);
    }
}
