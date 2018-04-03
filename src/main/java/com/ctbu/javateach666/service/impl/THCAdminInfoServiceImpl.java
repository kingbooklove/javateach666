package com.ctbu.javateach666.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.ctbu.javateach666.constant.Constant;
import com.ctbu.javateach666.dao.THCAdminInfoDao;
import com.ctbu.javateach666.pojo.bo.PageInfoBo;
import com.ctbu.javateach666.pojo.bo.thcbo.THCAccountListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCAccountListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCCourseListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCCourseListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCDictionariesListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCDictionariesListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCIndexImgListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCIndexImgListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCInsertDicBO;
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
import com.ctbu.javateach666.util.RedisUtil;

@Service
public class THCAdminInfoServiceImpl implements THCAdminInfoService{
	
	@Autowired
	private THCAdminInfoDao tHCAdminInfoDao;
	
	@Autowired
	private RedisUtil redisUtil;
	
	//个人信息管理
	public THCAdminInfoPO initAdminInfo(String username) {
		String key = "THCAdminInfoService" + "initAdminInfo" + username;
		//定义出参
		THCAdminInfoPO tp = new THCAdminInfoPO();
		if(redisUtil.exist(key)){
			tp = redisUtil.getData(key);
		}else{
			tp = tHCAdminInfoDao.initAdminInfo(username);
			redisUtil.saveData(key, tp);
		}
		return tp;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public THCUpdateAdminInBO updateAdminInfo(String adminno, String adminphone, String adminemail) {
		System.out.println("tttttt");
		THCAdminInfoPO oldadinfo = tHCAdminInfoDao.getAdminInfoByAdminno(adminno);
		System.out.println(oldadinfo);
		oldadinfo.setAdminphone(adminphone);
		oldadinfo.setAdminemail(adminemail);
		
		THCUpdateAdminInBO rsp = new THCUpdateAdminInBO();
		int count = tHCAdminInfoDao.updateAdminInfo(oldadinfo);
		if(count > 0){
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String key = "THCAdminInfoService" + "updateAdminInfo" + userDetails.getUsername();
			redisUtil.deleteData(key);
			BeanUtils.copyProperties(oldadinfo, rsp);
			rsp.setResponseCode(Constant.RSP_SUCCESS_CODE);
			rsp.setResponseDesc("更新成功！");
			return rsp;
		}else{
			rsp.setResponseCode(Constant.RSP_FALSE_CODE);
			rsp.setResponseDesc("更新失败！");
			return rsp;
		}
	}

	public THCAccountPO getAdminPass(String username) {
		String key = "THCAdminInfoService" + "getAdminPass" + username;
		//定义出参
		THCAccountPO tp = new THCAccountPO();
		if(redisUtil.exist(key)){
			tp = redisUtil.getData(key);
		}else{
			tp = tHCAdminInfoDao.getAdminPass(username);
			redisUtil.saveData(key, tp);
		}
		return tp;
	}

	public THCUpdateAdminPassBO updateAdminPass(String username, String password) {
		System.out.println("tttttt");
		THCAccountPO oldadpass = tHCAdminInfoDao.getAdminPass(username);
		System.out.println(oldadpass);
		oldadpass.setPassword(password);
		
		THCUpdateAdminPassBO rsp = new THCUpdateAdminPassBO();
		int count = tHCAdminInfoDao.updateAdminPass(oldadpass);
		if(count > 0){
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String key = "THCAdminInfoService" + "updateAdminPass" + userDetails.getUsername();
			redisUtil.deleteData(key);
			BeanUtils.copyProperties(oldadpass, rsp);
			rsp.setResponseCode(Constant.RSP_SUCCESS_CODE);
			rsp.setResponseDesc("更新成功！");
			return rsp;
		}else{
			rsp.setResponseCode(Constant.RSP_FALSE_CODE);
			rsp.setResponseDesc("更新失败！");
			return rsp;
		}
	}
	
	//首页图片管理
	public PageInfoBo<THCIndexImgListRspBO> getImgList(THCIndexImgListRepBO tHCIndexImgListRepBO) {
		//定义出参
		PageInfoBo<THCIndexImgListRspBO> rsp = new PageInfoBo<THCIndexImgListRspBO>();
		int page = 0;
		page = ((tHCIndexImgListRepBO).getPage() - 1) * tHCIndexImgListRepBO.getRows();
		tHCIndexImgListRepBO.setPage(page);
		System.out.println("123"+ tHCIndexImgListRepBO);
		int total = tHCAdminInfoDao.getTotal(tHCIndexImgListRepBO);
		if(total < 1)
			return rsp;
		List<THCIndexImgListRspBO> list = tHCAdminInfoDao.getIndexImgbyPage(tHCIndexImgListRepBO);
		rsp.setRows(list);
		rsp.setTotal(total);
		
		return rsp;
	}

	public List<THCIndexImgListRspBO> getImgBySearch(THCIndexImgListRepBO tHCIndexImgListRepBO) {
		return tHCAdminInfoDao.getIndexImgbySearch(tHCIndexImgListRepBO);
	}

	public int deleteIndexImg(String imgno) {
		return tHCAdminInfoDao.deleteIndexImg(imgno);
	}

	public THCIndexImgPO addIndexImg(THCIndexImgPO tHCIndexImgPO) {
		return tHCAdminInfoDao.addIndexImg(tHCIndexImgPO);
	}
	
	//新闻和公告管理
	public PageInfoBo<THCJournalismListRspBO> getJourList(THCJournalismListRepBO tHCJournalismListRepBO) {
		//定义出参
		PageInfoBo<THCJournalismListRspBO> rsp = new PageInfoBo<THCJournalismListRspBO>();
		int page = 0;
		page = ((tHCJournalismListRepBO).getPage() - 1) * tHCJournalismListRepBO.getRows();
		tHCJournalismListRepBO.setPage(page);
		int total = tHCAdminInfoDao.getJourTotal(tHCJournalismListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCJournalismListRspBO> list = tHCAdminInfoDao.getJourbyPage(tHCJournalismListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}

	public List<THCJournalismListRspBO> getJourBySearch(THCJournalismListRepBO tHCJournalismListRepBO) {
		return tHCAdminInfoDao.getJourbySearch(tHCJournalismListRepBO);
	}

	public int deleteJour(String jourtitle) {
		return tHCAdminInfoDao.deleteJour(jourtitle);
	}

	public List<THCDictionariesListRspBO> getJoutypeList() {
		return tHCAdminInfoDao.getJoutypeList();
	}

	public int getAdminId(String username) {
		return tHCAdminInfoDao.getAdminId(username);
	}
	

	public int addNews(THCJournalismPO tHCJournalismPO) {
		return tHCAdminInfoDao.addNews(tHCJournalismPO);
	}
	
	public int updateNews(THCJournalismPO tHCJournalismPO) {
		return tHCAdminInfoDao.updateNews(tHCJournalismPO);
	}

	public List<THCDictionariesListRspBO> getJoutypeList1() {
		return tHCAdminInfoDao.getJoutypeList1();
	}

	public int addPubs(THCJournalismPO tHCJournalismPO) {
		return tHCAdminInfoDao.addPubs(tHCJournalismPO);
	}
	
	
	//数据字典管理
	public PageInfoBo<THCDictionariesListRspBO> getDicList(THCDictionariesListRepBO tHCDictionariesListRepBO) {
		//定义出参
		PageInfoBo<THCDictionariesListRspBO> rsp = new PageInfoBo<THCDictionariesListRspBO>();
		int page = 0;
		page = ((tHCDictionariesListRepBO).getPage() - 1) * tHCDictionariesListRepBO.getRows();
		tHCDictionariesListRepBO.setPage(page);
		if(tHCDictionariesListRepBO.getDtype().equals("--请选择--"));
			tHCDictionariesListRepBO.setDtype("");
		int total = tHCAdminInfoDao.getDicTotal(tHCDictionariesListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCDictionariesListRspBO> list = tHCAdminInfoDao.getDicListbyPage(tHCDictionariesListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}

	public List<THCDictionariesListRspBO> getDicBySearch(THCDictionariesListRepBO tHCDictionariesListRepBO) {
		return tHCAdminInfoDao.getDicbySearch(tHCDictionariesListRepBO);
	}

	public int deleteDic(String dicname) {
		return tHCAdminInfoDao.deleteDic(dicname);
	}

	public List<THCDictionariesListRspBO> getDicNameList() {
		return tHCAdminInfoDao.getDicNameList();
	}

	public THCInsertDicBO addDic(THCInsertDicBO tHCInsertDicBO) {
		System.out.println("tttttt");
		THCInsertDicBO rsp = new THCInsertDicBO();
		int count = tHCAdminInfoDao.addDic(tHCInsertDicBO);
		if(count > 0){
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String key = "THCAdminInfoService" + "addDic" + userDetails.getUsername();
			redisUtil.deleteData(key);
			BeanUtils.copyProperties(tHCInsertDicBO, rsp);
			rsp.setResponseCode(Constant.RSP_SUCCESS_CODE);
			rsp.setResponseDesc("添加成功！");
			return rsp;
		}else{
			rsp.setResponseCode(Constant.RSP_FALSE_CODE);
			rsp.setResponseDesc("添加失败！");
			return rsp;
		}
	}

	//学科信息管理
	public PageInfoBo<THCCourseListRspBO> getCourseList(THCCourseListRepBO tHCCourseListRepBO) {
		//定义出参
		PageInfoBo<THCCourseListRspBO> rsp = new PageInfoBo<THCCourseListRspBO>();
		int page = 0;
		page = ((tHCCourseListRepBO).getPage() - 1) * tHCCourseListRepBO.getRows();
		tHCCourseListRepBO.setPage(page);
		int total = tHCAdminInfoDao.getCourseTotal(tHCCourseListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCCourseListRspBO> list = tHCAdminInfoDao.getCoursebyPage(tHCCourseListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}

	public List<THCCourseListRspBO> getCourseBySearch(THCCourseListRepBO tHCCourseListRepBO) {
		return tHCAdminInfoDao.getCoursebySearch(tHCCourseListRepBO);
	}

	public List<THCDictionariesPO> getCtypeList() {
		return tHCAdminInfoDao.getCtypeList();
	}

	//教师信息管理
	public PageInfoBo<THCAccountListRspBO> getTeaList(THCAccountListRepBO tHCAccountListRepBO) {
		//定义出参
		PageInfoBo<THCAccountListRspBO> rsp = new PageInfoBo<THCAccountListRspBO>();
		int page = 0;
		page = ((tHCAccountListRepBO).getPage() - 1) * tHCAccountListRepBO.getRows();
		tHCAccountListRepBO.setPage(page);
		int total = tHCAdminInfoDao.getTeaTotal(tHCAccountListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCAccountListRspBO> list = tHCAdminInfoDao.getTeaListbyPage(tHCAccountListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}

	public List<THCAccountListRspBO> getTeaBySearch(THCAccountListRepBO tHCAccountListRepBO) {
		return tHCAdminInfoDao.getTeabySearch(tHCAccountListRepBO);
	}
	
	

	public PageInfoBo<THCTeaPostListRspBO> getTeaPostList(THCTeaPostListRepBO tHCTeaPostListRepBO) {
		//定义出参
		PageInfoBo<THCTeaPostListRspBO> rsp = new PageInfoBo<THCTeaPostListRspBO>();
		int page = 0;
		page = ((tHCTeaPostListRepBO).getPage() - 1) * tHCTeaPostListRepBO.getRows();
		tHCTeaPostListRepBO.setPage(page);
		int total = tHCAdminInfoDao.getTeaPostListTotal(tHCTeaPostListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCTeaPostListRspBO> list = tHCAdminInfoDao.getTeaPostListbyPage(tHCTeaPostListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}

	public List<THCTeaPostListRspBO> getTeaPostBySearch(THCTeaPostListRepBO tHCTeaPostListRepBO) {
		return tHCAdminInfoDao.getTeaPostbySearch(tHCTeaPostListRepBO);
	}
	
	

	public PageInfoBo<THCProfessionalRanksListRspBO> getPostRecordList(
			THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO) {
		//定义出参
		PageInfoBo<THCProfessionalRanksListRspBO> rsp = new PageInfoBo<THCProfessionalRanksListRspBO>();
		int page = 0;
		page = ((tHCProfessionalRanksListRepBO).getPage() - 1) * tHCProfessionalRanksListRepBO.getRows();
		tHCProfessionalRanksListRepBO.setPage(page);
		int total = tHCAdminInfoDao.getPostRecordListTotal(tHCProfessionalRanksListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCProfessionalRanksListRspBO> list = tHCAdminInfoDao.getPostRecordListbyPage(tHCProfessionalRanksListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}

	public List<THCProfessionalRanksListRspBO> getPostRecordBySearch(
			THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO) {
		return tHCAdminInfoDao.getPostRecordbySearch(tHCProfessionalRanksListRepBO);
	}

	//学生信息管理
	public PageInfoBo<THCAccountListRspBO> getStuList(THCAccountListRepBO tHCAccountListRepBO) {
		//定义出参
		PageInfoBo<THCAccountListRspBO> rsp = new PageInfoBo<THCAccountListRspBO>();
		int page = 0;
		page = ((tHCAccountListRepBO).getPage() - 1) * tHCAccountListRepBO.getRows();
		tHCAccountListRepBO.setPage(page);
		int total = tHCAdminInfoDao.getStuTotal(tHCAccountListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCAccountListRspBO> list = tHCAdminInfoDao.getStuListbyPage(tHCAccountListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}

	public List<THCAccountListRspBO> getStuBySearch(THCAccountListRepBO tHCAccountListRepBO) {
		return tHCAdminInfoDao.getStubySearch(tHCAccountListRepBO);
	}

}

