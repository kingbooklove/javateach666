package com.ctbu.javateach666.dao;

import java.util.List;

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
import com.ctbu.javateach666.pojo.po.thcpo.THCAccountPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCAdminInfoPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCDictionariesPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCIndexImgPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCJournalismPO;

public interface THCAdminInfoDao{
	//个人信息管理
	public THCAdminInfoPO initAdminInfo(String username);
	public THCAdminInfoPO getAdminInfoByAdminno(String adminno);
	public int updateAdminInfo(THCAdminInfoPO adinfo);
	public THCAccountPO getAdminPass(String username);
	public int updateAdminPass(THCAccountPO adaccount);
	
	//首页图片管理
	public List<THCIndexImgListRspBO> getIndexImgbyPage(THCIndexImgListRepBO tHCIndexImgListRepBO);
	public int getTotal(THCIndexImgListRepBO tHCIndexImgListRepBO);
	public List<THCIndexImgListRspBO> getIndexImgbySearch(THCIndexImgListRepBO tHCIndexImgListRepBO);
	public int deleteIndexImg(String imgno);
	public THCIndexImgPO addIndexImg(THCIndexImgPO tHCIndexImgPO);
	
	//新闻公告管理
	public List<THCJournalismListRspBO> getJourbyPage(THCJournalismListRepBO tHCJournalismListRepBO);
	public int getJourTotal(THCJournalismListRepBO tHCJournalismListRepBO);
	public List<THCJournalismListRspBO> getJourbySearch(THCJournalismListRepBO tHCJournalismListRepBO);
	public int deleteJour(String jourtitle);
	public List<THCDictionariesListRspBO> getJoutypeList();
	public int getAdminId(String username);
	public int addNews(THCJournalismPO tHCJournalismPO);
	public int updateNews(THCJournalismPO tHCJournalismPO);
	public List<THCDictionariesListRspBO> getJoutypeList1();
	public int addPubs(THCJournalismPO tHCJournalismPO);
	
	//数据字典管理
	public List<THCDictionariesListRspBO> getDicListbyPage(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public int getDicTotal(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public List<THCDictionariesListRspBO> getDicbySearch(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public int deleteDic(String dicname);
	public List<THCDictionariesListRspBO> getDicNameList();
	public int addDic(THCInsertDicBO tHCInsertDicBO);
	
	//学科信息管理
	public List<THCCourseListRspBO> getCoursebyPage(THCCourseListRepBO tHCCourseListRepBO);
	public int getCourseTotal(THCCourseListRepBO tHCCourseListRepBO);
	public List<THCCourseListRspBO> getCoursebySearch(THCCourseListRepBO tHCCourseListRepBO);
	public List<THCDictionariesPO> getCtypeList();
	
	//教师信息管理
	public List<THCAccountListRspBO> getTeaListbyPage(THCAccountListRepBO tHCAccountListRepBO);
	public int getTeaTotal(THCAccountListRepBO tHCAccountListRepBO);
	public List<THCAccountListRspBO> getTeabySearch(THCAccountListRepBO tHCAccountListRepBO);
	
	public List<THCTeaPostListRspBO> getTeaPostListbyPage(THCTeaPostListRepBO tHCTeaPostListRepBO);
	public int getTeaPostListTotal(THCTeaPostListRepBO tHCTeaPostListRepBO);
	public List<THCTeaPostListRspBO> getTeaPostbySearch(THCTeaPostListRepBO tHCTeaPostListRepBO);
	
	public List<THCProfessionalRanksListRspBO> getPostRecordListbyPage(THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO);
	public int getPostRecordListTotal(THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO);
	public List<THCProfessionalRanksListRspBO> getPostRecordbySearch(THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO);
	
	
	//学生信息管理
	public List<THCAccountListRspBO> getStuListbyPage(THCAccountListRepBO tHCAccountListRepBO);
	public int getStuTotal(THCAccountListRepBO tHCAccountListRepBO);
	public List<THCAccountListRspBO> getStubySearch(THCAccountListRepBO tHCAccountListRepBO);
}
