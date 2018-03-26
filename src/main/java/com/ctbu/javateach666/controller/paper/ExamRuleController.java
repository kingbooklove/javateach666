package com.ctbu.javateach666.controller.paper;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ctbu.javateach666.pojo.po.exam.ExamRule;
import com.ctbu.javateach666.service.interfac.paper.ExamRuleService;
import com.ctbu.javateach666.util.PageUtil;

/**
 * 试卷规则control
 * @author king
 *
 */
@Controller
@RequestMapping("/examrule")
public class ExamRuleController {
	
	@Autowired
	private ExamRuleService ExamRuleService;
	
	/**
	 * 转发到试卷规则页面
	 * @return
	 */
	@RequestMapping("/examrule")
	public String examrule() {
		return "paper/listRules";
	}
	
	/**
	 * 加载试卷规则列表
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/examrules")
	public String listExamRule(HttpServletRequest request,HttpServletResponse response) {
		// 获取传入当前页和每页显示数
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer rows = Integer.valueOf(request.getParameter("rows"));
        
        ExamRule examRule = new ExamRule();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        // 查询参数
//        String couseId = request.getParameter("couseId");
//        String degree = request.getParameter("degree");
//        String bTime = request.getParameter("bTime");
//        String eTime = request.getParameter("eTime");
//        if(couseId != null && !"".equals(couseId)) {
//        	examRule.setCouseId(couseId);
//        }
//        if(degree != null && !"".equals(degree)) {
//        	examRule.setDegree(degree);
//        }
//        if(bTime != null && !"".equals(bTime)) {
//        	try {
//				examRule.setbTime(format.parse(bTime));
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//        }
//        if(eTime != null && !"".equals(eTime)) {
//        	try {
//        		examRule.seteTime(format.parse(eTime));
//        	} catch (ParseException e) {
//        		e.printStackTrace();
//        	}
//        }
        
        
        List<ExamRule> list = ExamRuleService.findList(examRule);
		String json = PageUtil.findPage(page, rows, list);
		return json;
	}
	
	
	/**
	 * 逻辑删除规则
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/deleteExamRule")
	public String deleteExamRule(HttpServletRequest request,HttpServletResponse response) {
		String ids = request.getParameter("examruleids");
		String[] idarr = ids.split(",");
		for(String id : idarr) {
			ExamRule examRule = new ExamRule();
			examRule.setId(Integer.valueOf(id));
			ExamRuleService.deleteByLogic(examRule);
		}
		return "OK";
	}
	
	/**
	 * 添加信息
	 * @param examRule
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addExamRule")
	public String addExamRule(ExamRule examRule) {
		int row = ExamRuleService.insert(examRule);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
	/**
	 * 修改信息
	 * @param examRule
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateExamRule")
	public String updateExamRule(ExamRule examRule) {
		int row = ExamRuleService.update(examRule);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
	/**
	 * 根据规则id获取规则对象
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getExamRuleById")
	public String getExamRuleById(HttpServletRequest request) {
		String id = request.getParameter("ruleId");
		ExamRule examRule = ExamRuleService.get(Integer.valueOf(id));
		String jsonString = "";
		if(examRule != null) {
			jsonString = JSON.toJSONString(examRule);
		} 
		return jsonString;
	}
}
