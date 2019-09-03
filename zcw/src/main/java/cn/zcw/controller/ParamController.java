package cn.zcw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zcw.bean.AJAXResult;
import cn.zcw.bean.Param;
import cn.zcw.service.ParamService;
import cn.zcw.util.PageBean;

@Controller
@RequestMapping("/managers/param")
public class ParamController {

	@Autowired
	private ParamService paramService;
	
	//分页查询、模糊查询
	@ResponseBody
	@RequestMapping("/ParampageQuery.do")
	public Object pageQuery(String querytext,Integer pageno, Integer pageSize) {
		AJAXResult<Param> result = new AJAXResult<>();
		PageBean<Param> pb = new PageBean<>();
		Integer selectPageno = (pageno-1)*pageSize;
		pb = paramService.getParamList(querytext,selectPageno,pageSize);
		result.setSuccess(true);
		result.setPageBean(pb);
		return result;
	}
	
	//根据id获得修改id的所有信息
	@RequestMapping("/edit.do")
	public String edit(Integer id, Model model) {
		Param param  = paramService.queryById(id);
		model.addAttribute("param", param);
		return "/managers/param/edit.jsp";
	}
			    
	//修改角色
	@ResponseBody
	@RequestMapping("/update.do")
	public Object updateParam(Param param) {
		AJAXResult<Param> result = new AJAXResult<>();
		try {
			int num = paramService.update(param);
			if (num >= 1) {
				result.setSuccess(true);
			}else {
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
}	
