package com.ctbu.javateach666.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ctbu.javateach666.pojo.bo.PageInfoBo;
import com.ctbu.javateach666.pojo.bo.THCDictionariesListRepBO;
import com.ctbu.javateach666.pojo.bo.THCDictionariesListRspBO;
import com.ctbu.javateach666.pojo.bo.THCIndexImgListRepBO;
import com.ctbu.javateach666.pojo.bo.THCIndexImgListRspBO;
import com.ctbu.javateach666.pojo.bo.THCJournalismListRepBO;
import com.ctbu.javateach666.pojo.bo.THCJournalismListRspBO;
import com.ctbu.javateach666.pojo.bo.THCUpdateAdminInBO;
import com.ctbu.javateach666.pojo.bo.THCUpdateAdminPassBO;
import com.ctbu.javateach666.pojo.po.THCAccountPO;
import com.ctbu.javateach666.pojo.po.THCAdminInfoPO;
import com.ctbu.javateach666.pojo.po.THCIndexImgPO;
import com.ctbu.javateach666.service.interfac.THCAdminInfoService;

@Controller
public class THCAdminInfoController {
	
	@Autowired
	private THCAdminInfoService tHCAdminInfoService;
	
	@RequestMapping("/admininfo")
	public String goAdminInfo(){
		return "thcadmin/personinfo/admininfo";
	}
	
	//个人设置模块
	@ResponseBody
	@RequestMapping("/initadmininfo")
	public THCAdminInfoPO initStuInfo(){
		System.out.println("initAdminInfo");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(userDetails.getUsername());
		return tHCAdminInfoService.initAdminInfo(userDetails.getUsername());
	}
	
	@ResponseBody
	@RequestMapping("/updateadmininfo")
	public THCUpdateAdminInBO updateAdminInfo(@RequestBody THCAdminInfoPO adinfo){
		System.out.println("update"+ adinfo);
		System.out.println(adinfo.getAdminno());
		return tHCAdminInfoService.updateAdminInfo(adinfo.getAdminno(), adinfo.getAdminphone(), adinfo.getAdminemail());
	}

	@RequestMapping("/adminsetpass")
	public String goAdminSetPass(){
		return "thcadmin/personinfo/adminsetpass";
	}
	
	@ResponseBody
	@RequestMapping("/getadminpass")
	public THCAccountPO getAdminPass(){
		System.out.println("getAdminPass");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(userDetails.getUsername());
		return tHCAdminInfoService.getAdminPass(userDetails.getUsername());
	}
	
	@ResponseBody
	@RequestMapping("/updateadminpass")
	public THCUpdateAdminPassBO updateAdminPass(@RequestBody THCAccountPO adaccount){
		return tHCAdminInfoService.updateAdminPass(adaccount.getUsername(), adaccount.getPassword());
	}
	
	//首页管理模块
	@RequestMapping("/indeximg")
	public String goIndexImg(){
		return "thcadmin/indexinfo/indeximg";
	}
	
	@ResponseBody
	@RequestMapping("/getindeximglist")
	public PageInfoBo<THCIndexImgListRspBO> getIndexImgList(THCIndexImgListRepBO tHCIndexImgListRepBO){
		System.out.println("getindeximglist");
		PageInfoBo<THCIndexImgListRspBO> page = new PageInfoBo<THCIndexImgListRspBO>();
		page = tHCAdminInfoService.getImgList(tHCIndexImgListRepBO);
		return page;
	}
	
	@ResponseBody
	@RequestMapping("/deleteIndexImg")
	public int deleteIndexImg(String imgno){
		System.out.println("111"+imgno);
		return tHCAdminInfoService.deleteIndexImg(imgno);
	}
	
	@RequestMapping("/goaddindeximg")
	public String goAddIndexImg(){
		return "thcadmin/indexinfo/addindeximg";
	}
	
	
	@ResponseBody
	@RequestMapping("/addindeximg")
	public String addIndexImg(HttpServletRequest request, HttpServletResponse response){
		String path = request.getServletContext().getRealPath("/")+"src/main/webapp/static/file";
		System.out.println(path);
		String imgno = "";
		String imgname = "";
		String imgurl = "";
		String is_pub = "";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");//处理文件名中文乱码
		try {
			List<FileItem> items = upload.parseRequest(request);
			System.out.println("123"+items);
			Iterator<FileItem> it = items.iterator();
			System.out.println("124"+it);
			while(it.hasNext()){
				FileItem item = it.next();
				if(item.isFormField()){ //普通表单域(获取属性name和value的值)
					String name = item.getFieldName();
					String value = item.getString("utf-8");//处理请求的中文乱码
					
					if(name.equals("imgno")){
						imgno = value;
					}
					
					if(name.equals("imgname")){
						imgname = value;
					}
					if(name.equals("is_pub")){
						is_pub = value;
					}
				}else{ //上传文件域
					String fileName = item.getName(); //文件名称
					imgurl =path+fileName;
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1,fileName.length());
					String path1 = path + "src/main/webapp/static/file"+ fileName;
					File file = new File(path1);
					item.write(file);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("111112"+imgno);
		THCIndexImgPO indeximg = new THCIndexImgPO();
		indeximg.setImgno(imgno);
		indeximg.setImgname(imgname);
		indeximg.setImgurl(imgurl);
		indeximg.setIs_pub(Integer.parseInt(is_pub));
		
		tHCAdminInfoService.addIndexImg(indeximg);
		return null;
	}
	
	//新闻管理模块
	@RequestMapping("/gonewsinfo")
	public String goNewsInfo(){
		return "thcadmin/indexinfo/newsinfo";
	}
	
	@ResponseBody
	@RequestMapping("/getnewslist")
	public PageInfoBo<THCJournalismListRspBO> getNewsList(THCJournalismListRepBO tHCJournalismListRepBO){
		System.out.println("getNewsList");
		PageInfoBo<THCJournalismListRspBO> page = new PageInfoBo<THCJournalismListRspBO>();
		tHCJournalismListRepBO.setJ_type(1);//1-新闻  2-公告
		page = tHCAdminInfoService.getJourList(tHCJournalismListRepBO);
		return page;
	}
	
	@RequestMapping("/gopubinfo")
	public String goNoticeInfo(){
		return "thcadmin/indexinfo/pubinfo";
	}
	
	@ResponseBody
	@RequestMapping("/getpublist")
	public PageInfoBo<THCJournalismListRspBO> getPubList(THCJournalismListRepBO tHCJournalismListRepBO){
		System.out.println("getPubList");
		PageInfoBo<THCJournalismListRspBO> page = new PageInfoBo<THCJournalismListRspBO>();
		tHCJournalismListRepBO.setJ_type(2);//1-新闻  2-公告
		page = tHCAdminInfoService.getJourList(tHCJournalismListRepBO);
		return page;
	}
	
	//数据字典管理
	@RequestMapping("/godiclist")
	public String goDic(){
		return "thcadmin/dictionaries/diclist";
	}
	
	@ResponseBody
	@RequestMapping("/getdiclist")
	public PageInfoBo<THCDictionariesListRspBO> getDicList(THCDictionariesListRepBO tHCDictionariesListRepBO){
		System.out.println("getdiclist");
		PageInfoBo<THCDictionariesListRspBO> page = new PageInfoBo<THCDictionariesListRspBO>();
		page = tHCAdminInfoService.getDicList(tHCDictionariesListRepBO);
		return page;
	}
	
	@ResponseBody
	@RequestMapping("/deleteDic")
	public int deleteDic(String dicname){
		System.out.println("111"+dicname);
		int aaa = tHCAdminInfoService.deleteDic(dicname);
		return aaa;
	}
	
	@ResponseBody
	@RequestMapping("/getDicNameList")
	public List<THCDictionariesListRspBO> getDicNameList(){
		List<THCDictionariesListRspBO> list = tHCAdminInfoService.getDicNameList();
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/goadddic")
	public String goAddDic(){
		return "thcadmin/dictionaries/adddic";
	}
}
