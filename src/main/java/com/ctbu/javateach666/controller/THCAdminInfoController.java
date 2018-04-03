package com.ctbu.javateach666.controller;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbu.javateach666.pojo.bo.PageInfoBo;
import com.ctbu.javateach666.pojo.bo.thcbo.THCAccountListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCAccountListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCCourseListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCCourseListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCDictionariesListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCDictionariesListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCIndexImgListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCIndexImgListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCJournalismListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCJournalismListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCProfessionalRanksListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCProfessionalRanksListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCTeaPostListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCTeaPostListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCUpdateAdminInBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCUpdateAdminPassBO;
import com.ctbu.javateach666.pojo.po.thcpo.THCAccountPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCAdminInfoPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCDictionariesPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCIndexImgPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCJournalismPO;
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
		if(is_pub!=null||is_pub != ""){
			indeximg.setIs_pub(Integer.parseInt(is_pub));
		}else{
			indeximg.setIs_pub(0);
		}
		
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
	
	@ResponseBody
	@RequestMapping("/getJoutypeList")
	public List<THCDictionariesListRspBO> getJoutypeList(){
		List<THCDictionariesListRspBO> list = tHCAdminInfoService.getJoutypeList();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/addnews")
	public String addNews(THCJournalismPO tHCJournalismPO){
		Date sTime = new Date();
		Date eTime = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sTime);
		calendar.add(calendar.MONTH, 1); 
		eTime = calendar.getTime(); 
		tHCJournalismPO.setStarttime(sTime);
		tHCJournalismPO.setEndtime(eTime);
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = tHCAdminInfoService.getAdminId(userDetails.getUsername());
		tHCJournalismPO.setPubid(id);
		tHCJournalismPO.setJ_type(1);
		int m = tHCAdminInfoService.addNews(tHCJournalismPO);
		if(m == 1){
			return "OK";
		}else{
			return "NO";
		}
	}
	
	@ResponseBody
	@RequestMapping("/updatenews")
	public String updateNews(THCJournalismPO tHCJournalismPO){
		System.out.println("1111");
		System.out.println(tHCJournalismPO.getId());
		System.out.println("2222");
		int m = tHCAdminInfoService.updateNews(tHCJournalismPO);
		if(m == 1){
			return "OK";
		}else{
			return "NO";
		}
	}
	
	@ResponseBody
	@RequestMapping("/getJoutypeList1")
	public List<THCDictionariesListRspBO> getJoutypeList1(){
		List<THCDictionariesListRspBO> list = tHCAdminInfoService.getJoutypeList1();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/addpubs")
	public String addPubs(THCJournalismPO tHCJournalismPO){
		Date sTime = new Date();
		Date eTime = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sTime);
		calendar.add(calendar.MONTH, 1); 
		eTime = calendar.getTime(); 
		tHCJournalismPO.setStarttime(sTime);
		tHCJournalismPO.setEndtime(eTime);
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = tHCAdminInfoService.getAdminId(userDetails.getUsername());
		tHCJournalismPO.setPubid(id);
		tHCJournalismPO.setJ_type(2);
		int m = tHCAdminInfoService.addNews(tHCJournalismPO);
		if(m == 1){
			return "OK";
		}else{
			return "NO";
		}
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
	
	//学科信息管理
	@RequestMapping("/gocourseinfo")
	public String goCourseInfo(){
		return "thcadmin/courseinfo/courseinfo";
	}
	
	@ResponseBody
	@RequestMapping("/getcourselist")
	public PageInfoBo<THCCourseListRspBO> getCourseList(THCCourseListRepBO tHCCourseListRepBO){
		System.out.println("getcourselist");
		PageInfoBo<THCCourseListRspBO> page = new PageInfoBo<THCCourseListRspBO>();
		page = tHCAdminInfoService.getCourseList(tHCCourseListRepBO);
		return page;
	}
	
	@ResponseBody
	@RequestMapping("/getCtype")
	public List<THCDictionariesPO> getCtypeList(){
		List<THCDictionariesPO> list = tHCAdminInfoService.getCtypeList();
		System.out.println(list);
		return list;
	}
	
	//教师信息管理
	@RequestMapping("/goteaaccount")
	public String goTeaAccount(){
		return "thcadmin/teainfo/teaaccount";
	}
	
	@ResponseBody
	@RequestMapping("/gettealist")
	public PageInfoBo<THCAccountListRspBO> getTeaList(THCAccountListRepBO tHCAccountListRepBO){
		System.out.println("gettealist");
		PageInfoBo<THCAccountListRspBO> page = new PageInfoBo<THCAccountListRspBO>();
		page = tHCAdminInfoService.getTeaList(tHCAccountListRepBO);
		return page;
	}
	
	@RequestMapping("/goteapost")
	public String goTeaPost(){
		return "thcadmin/teainfo/teapost";
	}
	
	@ResponseBody
	@RequestMapping("/getteapostlist")
	public PageInfoBo<THCTeaPostListRspBO> getTeaPostList(THCTeaPostListRepBO tHCTeaPostListRepBO){
		System.out.println("gettealist");
		PageInfoBo<THCTeaPostListRspBO> page = new PageInfoBo<THCTeaPostListRspBO>();
		page = tHCAdminInfoService.getTeaPostList(tHCTeaPostListRepBO);
		return page;
	}
	
	@RequestMapping("/gopostrecord")
	public String goPostRecord(){
		return "thcadmin/teainfo/postapplyrecord";
	}
	
	@ResponseBody
	@RequestMapping("/getpostrecordlist")
	public PageInfoBo<THCProfessionalRanksListRspBO> getPostRecordList(THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO){
		System.out.println("getpostrecordlist");
		PageInfoBo<THCProfessionalRanksListRspBO> page = new PageInfoBo<THCProfessionalRanksListRspBO>();
		page = tHCAdminInfoService.getPostRecordList(tHCProfessionalRanksListRepBO);
		return page;
	}
	
	//学生信息管理
	@RequestMapping("/gostuaccount")
	public String goStuAccount(){
		return "thcadmin/stuinfo/stuaccount";
	}
	
	@ResponseBody
	@RequestMapping("/getstulist")
	public PageInfoBo<THCAccountListRspBO> getStuList(THCAccountListRepBO tHCAccountListRepBO){
		System.out.println("getstulist");
		PageInfoBo<THCAccountListRspBO> page = new PageInfoBo<THCAccountListRspBO>();
		page = tHCAdminInfoService.getStuList(tHCAccountListRepBO);
		return page;
	}
}
