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
import com.ctbu.javateach666.pojo.bo.THCDictionariesListRepBO;
import com.ctbu.javateach666.pojo.bo.THCDictionariesListRspBO;
import com.ctbu.javateach666.pojo.bo.THCIndexImgListRepBO;
import com.ctbu.javateach666.pojo.bo.THCIndexImgListRspBO;
import com.ctbu.javateach666.pojo.bo.THCInsertDicBO;
import com.ctbu.javateach666.pojo.bo.THCJournalismListRepBO;
import com.ctbu.javateach666.pojo.bo.THCJournalismListRspBO;
import com.ctbu.javateach666.pojo.bo.THCUpdateAdminInBO;
import com.ctbu.javateach666.pojo.bo.THCUpdateAdminPassBO;
import com.ctbu.javateach666.pojo.po.THCAccountPO;
import com.ctbu.javateach666.pojo.po.THCAdminInfoPO;
import com.ctbu.javateach666.pojo.po.THCDictionariesPO;
import com.ctbu.javateach666.pojo.po.THCIndexImgPO;
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
}
