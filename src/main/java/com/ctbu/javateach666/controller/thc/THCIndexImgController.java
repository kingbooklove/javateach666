package com.ctbu.javateach666.controller.thc;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.ctbu.javateach666.pojo.bo.PageInfoBo;
import com.ctbu.javateach666.pojo.bo.thcbo.THCIndexImgListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCIndexImgListRspBO;
import com.ctbu.javateach666.pojo.po.thcpo.THCCoursePO;
import com.ctbu.javateach666.pojo.po.thcpo.THCIndexImgPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCJournalismPO;
import com.ctbu.javateach666.service.interfac.thc.THCIndexImgService;

@Controller
public class THCIndexImgController {
	
	@Autowired
	private THCIndexImgService tHCIndexImgService;
	
	//首页管理模块
	@RequestMapping("/indeximg")
	public String goIndexImg(){
		return "thcadmin/indexinfo/indeximg";
	}
	/**
	 * 获取图片列表
	 * @param Object
	 */
	@ResponseBody
	@RequestMapping("/getindeximglist")
	public PageInfoBo<THCIndexImgListRspBO> getIndexImgList(THCIndexImgListRepBO tHCIndexImgListRepBO){
		System.out.println("getindeximglist");
		PageInfoBo<THCIndexImgListRspBO> page = new PageInfoBo<THCIndexImgListRspBO>();
		page = tHCIndexImgService.getImgList(tHCIndexImgListRepBO);
		return page;
	}
	
	/**
	 * 逻辑删除图片
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/delimgs")
	public String delNews(HttpServletRequest request,HttpServletResponse response) {
		String ids = request.getParameter("imgsids");
		System.out.println("哈哈哈哈"+ids);
		String[] idarr = ids.split(",");
		for(String id : idarr) {
			THCIndexImgPO tHCIndexImgPO = new THCIndexImgPO();
			tHCIndexImgPO.setId(Integer.valueOf(id));
			tHCIndexImgService.deleteByLogic(tHCIndexImgPO);
		}
		return "OK";
	}
	
	/**
	 * 展示图片
	 * @param Object
	 */
	@ResponseBody
	@RequestMapping("/showimg")
	public String showImg(@RequestBody THCIndexImgPO tHCIndexImgPO){
		int m = tHCIndexImgService.update(tHCIndexImgPO);
		if(m == 1){
			return "OK";
		}else{
			return "NO";
		}
	}
	
	/**
	 * 隐藏图片
	 * @param Object
	 */
	@ResponseBody
	@RequestMapping("/hideimg")
	public String hideImg(@RequestBody THCIndexImgPO tHCIndexImgPO){
		System.out.println(JSON.toJSONString(tHCIndexImgPO));
		int m = tHCIndexImgService.hideimg(tHCIndexImgPO);
		if(m == 1){
			return "OK";
		}else{
			return "NO";
		}
	}
	
	@RequestMapping("/goaddindeximg")
	public String goAddIndexImg(){
		return "thcadmin/indexinfo/addindeximg";
	}
	
	/**
	 * 添加图片
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/addindeximg")
	public String addIndexImg(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request){
		int m = tHCIndexImgService.insertImg(file, request);
		if(m == 1){
			return "OK";
		}else{
			return "NO";
		}
	}
}
