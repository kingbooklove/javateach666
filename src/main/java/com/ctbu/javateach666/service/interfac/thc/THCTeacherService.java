package com.ctbu.javateach666.service.interfac.thc;

import java.util.List;

import com.ctbu.javateach666.common.service.BaseService;
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
import com.ctbu.javateach666.pojo.po.thcpo.THCStudentInfoPO;
import com.ctbu.javateach666.pojo.po.thcpo.THCTeachersInfoPO;

public interface THCTeacherService extends BaseService<THCTeacherDao, THCAccountPO>{
	//教师信息管理
	public PageInfoBo<THCAccountListRspBO> getTeaList(THCAccountListRepBO tHCAccountListRepBO);
	public int inserttea(THCTeachersInfoPO tHCTeachersInfoPO);
	public int insertauth(THCAuthoritiesPO tHCAuthoritiesPO);
	public THCTeachersInfoPO selectIdbyTeano(THCTeachersInfoPO tHCTeachersInfoPO);
	public THCAccountPO selectById(THCAccountPO tHCAccountPO);
	public int deleteByLogicTea(THCTeachersInfoPO tHCTeachersInfoPO);
	public int deleteByLogicAuth(THCAuthoritiesPO tHCAuthoritiesPO);
	public int updateTea(THCTeachersInfoPO tHCTeachersInfoPO);
	
	public PageInfoBo<THCTeaPostListRspBO> getTeaPostList(THCTeaPostListRepBO tHCTeaPostListRepBO);
	public int updateTeaPost(THCTeachersInfoPO tHCTeachersInfoPO);
	
	public PageInfoBo<THCProfessionalRanksListRspBO> getPostRecordList(THCProfessionalRanksListRepBO tHCProfessionalRanksListRepBO);
	public int updatePostRecord(THCProfessionalRanksPO tHCProfessionalRanksPO);
}
