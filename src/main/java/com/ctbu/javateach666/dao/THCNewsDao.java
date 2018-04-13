package com.ctbu.javateach666.dao;

import java.util.List;

import com.ctbu.javateach666.common.dao.BaseDao;
import com.ctbu.javateach666.pojo.bo.thcbo.THCDictionariesListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCJournalismListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCJournalismListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCJournalismRepBO;
import com.ctbu.javateach666.pojo.po.thcpo.THCJournalismPO;

public interface THCNewsDao extends BaseDao<THCJournalismPO>{
	//新闻公告管理
	public List<THCJournalismListRspBO> getJourbyPage(THCJournalismListRepBO tHCJournalismListRepBO);
	public int getJourTotal(THCJournalismListRepBO tHCJournalismListRepBO);
	public List<THCDictionariesListRspBO> getJoutypeList(String dtype);
	public int getAdminId(String username);
}
