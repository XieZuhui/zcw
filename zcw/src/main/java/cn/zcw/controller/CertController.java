package cn.zcw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zcw.bean.AJAXResult;
import cn.zcw.bean.Cert;
import cn.zcw.bean.Datas;
import cn.zcw.service.CertService;
import cn.zcw.util.PageBean;

@Controller
@RequestMapping("/managers/cert")
public class CertController {
	
	@Autowired
	private CertService certService;
	
	//分页查询、模糊查询
		@ResponseBody
		@RequestMapping("/CertpageQuery.do")
		public Object pageQuery(String querytext,Integer pageno, Integer pageSize) {
			AJAXResult<Cert> result = new AJAXResult<>();
			PageBean<Cert> pb = new PageBean<>();
			Integer selectPageno = (pageno-1)*pageSize;
			pb = certService.getCertList(querytext,selectPageno,pageSize);
			result.setSuccess(true);
			result.setPageBean(pb);
			return result;
		}
		
		//角色添加
	    @ResponseBody
		@RequestMapping("/insert.do")
		public Object addCert(Cert cert) {
			AJAXResult<Cert> result = new AJAXResult<>();
			try {
				int num = certService.insert(cert);
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
	    	Cert cert = certService.queryById(id);
	    	model.addAttribute("cert", cert);
	    	return "/managers/cert/edit.jsp";
	    }
	    
	    //修改角色
	    @ResponseBody
		@RequestMapping("/update.do")
		public Object updateCert(Cert cert) {
			AJAXResult<Cert> result = new AJAXResult<>();
			try {
				int num = certService.update(cert);
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
		public Object deleteCert(Integer id) {
			AJAXResult<Cert> result = new AJAXResult<>();
			try {
				int num = certService.delete(id);
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
		public Object deletesCert(Datas ds) {
			AJAXResult<Cert> result = new AJAXResult<>();
			try {
				int num = certService.deletes(ds);
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
