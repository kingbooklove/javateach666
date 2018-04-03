package com.ctbu.javateach666.dao;

import java.util.List;

import com.ctbu.javateach666.pojo.bo.THCDictionariesListRepBO;
import com.ctbu.javateach666.pojo.bo.THCDictionariesListRspBO;
import com.ctbu.javateach666.pojo.bo.THCIndexImgListRepBO;
import com.ctbu.javateach666.pojo.bo.THCIndexImgListRspBO;
import com.ctbu.javateach666.pojo.bo.THCInsertDicBO;
import com.ctbu.javateach666.pojo.bo.THCJournalismListRepBO;
import com.ctbu.javateach666.pojo.bo.THCJournalismListRspBO;
import com.ctbu.javateach666.pojo.po.THCAccountPO;
import com.ctbu.javateach666.pojo.po.THCAdminInfoPO;
import com.ctbu.javateach666.pojo.po.THCIndexImgPO;

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
	
	//数据字典管理
	public List<THCDictionariesListRspBO> getDicListbyPage(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public int getDicTotal(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public List<THCDictionariesListRspBO> getDicbySearch(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public int deleteDic(String dicname);
	public List<THCDictionariesListRspBO> getDicNameList();
	public int addDic(THCInsertDicBO tHCInsertDicBO);
}
