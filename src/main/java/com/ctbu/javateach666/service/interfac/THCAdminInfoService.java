package com.ctbu.javateach666.service.interfac;

import java.util.List;

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
import com.ctbu.javateach666.pojo.po.THCIndexImgPO;

public interface THCAdminInfoService {
	public THCAdminInfoPO initAdminInfo(String username);
	public THCUpdateAdminInBO updateAdminInfo(String adminno, String adminphone, String adminemail);
	public THCAccountPO getAdminPass(String username);
	public THCUpdateAdminPassBO updateAdminPass(String username, String password);
	
	public PageInfoBo<THCIndexImgListRspBO> getImgList(THCIndexImgListRepBO tHCIndexImgListRepBO);
	public List<THCIndexImgListRspBO> getImgBySearch(THCIndexImgListRepBO tHCIndexImgListRepBO);
	public int deleteIndexImg(String imgno);
	public THCIndexImgPO addIndexImg(THCIndexImgPO tHCIndexImgPO);
	
	public PageInfoBo<THCJournalismListRspBO> getJourList(THCJournalismListRepBO tHCJournalismListRepBO);
	public List<THCJournalismListRspBO> getJourBySearch(THCJournalismListRepBO tHCJournalismListRepBO);
	public int deleteJour(String jourtitle);
	
	public PageInfoBo<THCDictionariesListRspBO> getDicList(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public List<THCDictionariesListRspBO> getDicBySearch(THCDictionariesListRepBO tHCDictionariesListRepBO);
	public int deleteDic(String dicname);
	public List<THCDictionariesListRspBO> getDicNameList();
	public THCInsertDicBO addDic(THCInsertDicBO tHCInsertDicBO);
}
