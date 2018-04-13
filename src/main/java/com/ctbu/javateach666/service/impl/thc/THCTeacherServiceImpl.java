package com.ctbu.javateach666.service.impl.thc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctbu.javateach666.common.service.BaseService;
import com.ctbu.javateach666.common.service.BaseServiceImpl;
import com.ctbu.javateach666.dao.THCStudentDao;
import com.ctbu.javateach666.dao.THCTeacherDao;
import com.ctbu.javateach666.pojo.bo.PageInfoBo;
import com.ctbu.javateach666.pojo.bo.thcbo.THCAccountListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCAccountListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCProfessionalRanksListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCProfessionalRanksListRspBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCTeaPostListRepBO;
import com.ctbu.javateach666.pojo.bo.thcbo.THCTeaPostListRspBO;
import com.ctbu.javateach666.pojo.po.thcpo.THCAccountPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCAuthoritiesPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCProfessionalRanksPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCTeachersInfoPO;
import com.ctbu.javateach666.service.interfac.thc.THCTeacherService;

@Service
public class THCTeacherServiceImpl extends BaseServiceImpl<THCTeacherDao, THCAccountPO> implements THCTeacherService{

	@Autowired
	private THCTeacherDao tHCTeacherDao;
	
	//教师信息管理
	public PageInfoBo<THCAccountListRspBO> getTeaList(THCAccountListRepBO tHCAccountListRepBO) {
		//定义出参
		PageInfoBo<THCAccountListRspBO> rsp = new PageInfoBo<THCAccountListRspBO>();
		int page = 0;
		page = ((tHCAccountListRepBO).getPage() - 1) * tHCAccountListRepBO.getRows();
		tHCAccountListRepBO.setPage(page);
		int total = tHCTeacherDao.getTeaTotal(tHCAccountListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCAccountListRspBO> list = tHCTeacherDao.getTeaListbyPage(tHCAccountListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}
	
	

	public PageInfoBo<THCTeaPostListRspBO> getTeaPostList(THCTeaPostListRepBO tHCTeaPostListRepBO) {
		//定义出参
		PageInfoBo<THCTeaPostListRspBO> rsp = new PageInfoBo<THCTeaPostListRspBO>();
		int page = 0;
		page = ((tHCTeaPostListRepBO).getPage() - 1) * tHCTeaPostListRepBO.getRows();
		tHCTeaPostListRepBO.setPage(page);
		int total = tHCTeacherDao.getTeaPostListTotal(tHCTeaPostListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCTeaPostListRspBO> list = tHCTeacherDao.getTeaPostListbyPage(tHCTeaPostListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}

	public PageInfoBo<THCProfessionalRanksListRspBO> getPostRecordList(
			THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO) {
		//定义出参
		PageInfoBo<THCProfessionalRanksListRspBO> rsp = new PageInfoBo<THCProfessionalRanksListRspBO>();
		int page = 0;
		page = ((tHCProfessionalRanksListRepBO).getPage() - 1) * tHCProfessionalRanksListRepBO.getRows();
		tHCProfessionalRanksListRepBO.setPage(page);
		int total = tHCTeacherDao.getPostRecordListTotal(tHCProfessionalRanksListRepBO);
		System.out.println("total"+total);
		if(total < 1)
			return rsp;
		List<THCProfessionalRanksListRspBO> list = tHCTeacherDao.getPostRecordListbyPage(tHCProfessionalRanksListRepBO);
		System.out.println(list);
		rsp.setRows(list);
		rsp.setTotal(total);
		return rsp;
	}

	public int inserttea(THCTeachersInfoPO tHCTeachersInfoPO) {
		return tHCTeacherDao.inserttea(tHCTeachersInfoPO);
	}

	public int insertauth(THCAuthoritiesPO tHCAuthoritiesPO) {
		return tHCTeacherDao.insertauth(tHCAuthoritiesPO);
	}

	public THCTeachersInfoPO selectIdbyTeano(THCTeachersInfoPO tHCTeachersInfoPO) {
		return tHCTeacherDao.selectIdbyTeano(tHCTeachersInfoPO);
	}

	public THCAccountPO selectById(THCAccountPO tHCAccountPO) {
		return tHCTeacherDao.selectById(tHCAccountPO);
	}

	public int deleteByLogicTea(THCTeachersInfoPO tHCTeachersInfoPO) {
		return tHCTeacherDao.deleteByLogicTea(tHCTeachersInfoPO);
	}

	public int deleteByLogicAuth(THCAuthoritiesPO tHCAuthoritiesPO) {
		return tHCTeacherDao.deleteByLogicAuth(tHCAuthoritiesPO);
	}

	public int updateTea(THCTeachersInfoPO tHCTeachersInfoPO) {
		return tHCTeacherDao.updateTea(tHCTeachersInfoPO);
	}

	public int updateTeaPost(THCTeachersInfoPO tHCTeachersInfoPO) {
		return tHCTeacherDao.updateTeaPost(tHCTeachersInfoPO);
	}

	public int updatePostRecord(THCProfessionalRanksPO tHCProfessionalRanksPO) {
		return tHCTeacherDao.updatePostRecord(tHCProfessionalRanksPO);
	}

}
