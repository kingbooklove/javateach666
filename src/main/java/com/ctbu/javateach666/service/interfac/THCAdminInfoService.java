package com.ctbu.javateach666.service.interfac;

import java.util.List;

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

public interface THCAdminInfoService {
	//个人信息管理
	public THCAdminInfoPO initAdminInfo(String username);
	public THCUpdateAdminInBO updateAdminInfo(String adminno, String adminphone, String adminemail);
	public THCAccountPO getAdminPass(String username);
	public THCUpdateAdminPassBO updateAdminPass(String username, String password);
	
	//首页图片管理
	public PageInfoBo<THCIndexImgListRspBO> getImgList(THCIndexImgListRepBO tHCIndexImgListRepBO);
	public List<THCIndexImgListRspBO> getImgBySearch(THCIndexImgListRepBO tHCIndexImgListRepBO);
	public int deleteIndexImg(String imgno);
	public THCIndexImgPO addIndexImg(THCIndexImgPO tHCIndexImgPO);
	
	//新闻公告管理
	public PageInfoBo<THCJournalismListRspBO> getJourList(THCJournalismListRepBO tHCJournalismListRepBO);
	public List<THCJournalismListRspBO> getJourBySearch(THCJournalismListRepBO tHCJournalismListRepBO);
	public int deleteJour(String jourtitle);
	public List<THCDictionariesListRspBO> getJoutypeList();
	public int getAdminId(String username);
	public int addNews(THCJournalismPO tHCJournalismPO);
	public int updateNews(THCJournalismPO tHCJournalismPO);
	public List<THCDictionariesListRspBO> getJoutypeList1();
	public int addPubs(THCJournalismPO tHCJournalismPO);
	
	//数据字典管理
	public PageInfoBo<THCDictionariesListRspBO> getDicList(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public List<THCDictionariesListRspBO> getDicBySearch(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public int deleteDic(String dicname);
	public List<THCDictionariesListRspBO> getDicNameList();
	public THCInsertDicBO addDic(THCInsertDicBO tHCInsertDicBO);
	
	//学科信息管理
	public PageInfoBo<THCCourseListRspBO> getCourseList(THCCourseListRepBO tHCCourseListRepBO);
	public List<THCCourseListRspBO> getCourseBySearch(THCCourseListRepBO tHCCourseListRepBO);
	public List<THCDictionariesPO> getCtypeList();
	
	//教师信息管理
	public PageInfoBo<THCAccountListRspBO> getTeaList(THCAccountListRepBO tHCAccountListRepBO);
	public List<THCAccountListRspBO> getTeaBySearch(THCAccountListRepBO tHCAccountListRepBO);
	
	public PageInfoBo<THCTeaPostListRspBO> getTeaPostList(THCTeaPostListRepBO tHCTeaPostListRepBO);
	public List<THCTeaPostListRspBO> getTeaPostBySearch(THCTeaPostListRepBO tHCTeaPostListRepBO);
	
	public PageInfoBo<THCProfessionalRanksListRspBO> getPostRecordList(THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO);
	public List<THCProfessionalRanksListRspBO> getPostRecordBySearch(THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO);
	
	//学生信息管理
	public PageInfoBo<THCAccountListRspBO> getStuList(THCAccountListRepBO tHCAccountListRepBO);
	public List<THCAccountListRspBO> getStuBySearch(THCAccountListRepBO tHCAccountListRepBO);
}
