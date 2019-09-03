package cn.zcw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zcw.bean.AJAXResult;
import cn.zcw.bean.Datas;
import cn.zcw.bean.Type;
import cn.zcw.service.ProTypeService;
import cn.zcw.util.PageBean;

@Controller
@RequestMapping("/managers/proType")
public class ProTypeController {

	@Autowired
	private ProTypeService proTypeService;
	
	//分页查询、模糊查询
	@ResponseBody
	@RequestMapping("/TypepageQuery.do")
	public Object pageQuery(String querytext,Integer pageno, Integer pageSize) {
		AJAXResult<Type> result = new AJAXResult<>();
		PageBean<Type> pb = new PageBean<>();
		Integer selectPageno = (pageno-1)*pageSize;
		pb = proTypeService.getTypeList(querytext,selectPageno,pageSize);
		result.setSuccess(true);
		result.setPageBean(pb);
		return result;
	}
			
	//角色添加
	@ResponseBody
	@RequestMapping("/insert.do")
	public Object addType(Type type) {
		AJAXResult<Type> result = new AJAXResult<>();
		try {
			int num = proTypeService.insert(type);
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
		    
	//根据id获得修改id的所有信息
	@RequestMapping("/edit.do")
	public String edit(Integer id, Model model) {
		Type type = proTypeService.queryById(id);
		model.addAttribute("type", type);
		return "/managers/proType/edit.jsp";
	}
		    
	//修改角色
	@ResponseBody
	@RequestMapping("/update.do")
	public Object updateType(Type type) {
		AJAXResult<Type> result = new AJAXResult<>();
		try {
			int num = proTypeService.update(type);
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
		    
	//删除角色
	@ResponseBody
	@RequestMapping("/delete.do")
	public Object deleteType(Integer id) {
		AJAXResult<Type> result = new AJAXResult<>();
		try {
			int num = proTypeService.delete(id);
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
		    
	//批量删除角色
	@ResponseBody
	@RequestMapping("/deletes.do")
	public Object deletesType(Datas ds) {
		AJAXResult<Type> result = new AJAXResult<>();
		try {
			int num = proTypeService.deletes(ds);
			if (num == ds.getIds().size()) {
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
