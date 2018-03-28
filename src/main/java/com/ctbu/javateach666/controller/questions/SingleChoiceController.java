package com.ctbu.javateach666.controller.questions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbu.javateach666.pojo.po.THCCoursePO;
import com.ctbu.javateach666.pojo.po.questions.SingleChoice;
import com.ctbu.javateach666.service.interfac.questions.SingleChoiceService;
import com.ctbu.javateach666.util.PageUtil;

/**
 * 单选题control
 * @author king
 *
 */
@Controller
@RequestMapping("/single")
public class SingleChoiceController {
	
	@Autowired
	private SingleChoiceService SingleChoiceService;
	
	/**
	 * 转发到选择题页面
	 * @return
	 */
	@RequestMapping("/singlechoice")
	public String Choice() {
		return "questions/choice";
	}
	
	/**
	 * 加载选择题题目
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/single")
	public String listSingleChoice(HttpServletRequest request,HttpServletResponse response) {
		// 获取传入当前页和每页显示数
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer rows = Integer.valueOf(request.getParameter("rows"));
        
        SingleChoice singleChoice = new SingleChoice();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        // 查询参数
        String couseId = request.getParameter("couseId");
        String degree = request.getParameter("degree");
        String bTime = request.getParameter("bTime");
        String eTime = request.getParameter("eTime");
        if(couseId != null && !"".equals(couseId)) {
        	THCCoursePO course = new THCCoursePO();
        	course.setId(Integer.valueOf(couseId));
        	singleChoice.setCourse(course);
        }
        if(degree != null && !"".equals(degree)) {
        	singleChoice.setDegree(degree);
        }
        if(bTime != null && !"".equals(bTime)) {
        	try {
				singleChoice.setbTime(format.parse(bTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        if(eTime != null && !"".equals(eTime)) {
        	try {
        		singleChoice.seteTime(format.parse(eTime));
        	} catch (ParseException e) {
        		e.printStackTrace();
        	}
        }
        
        
        List<SingleChoice> list = SingleChoiceService.findList(singleChoice);
		String json = PageUtil.findPage(page, rows, list);
		return json;
	}
	
	
	/**
	 * 逻辑删除单选题
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/deleteSingleChoice")
	public String deleteSingleChoice(HttpServletRequest request,HttpServletResponse response) {
		String ids = request.getParameter("choiceids");
		String[] idarr = ids.split(",");
		for(String id : idarr) {
			SingleChoice singleChoice = new SingleChoice();
			singleChoice.setId(Integer.valueOf(id));
			SingleChoiceService.deleteByLogic(singleChoice);
		}
		return "OK";
	}
	
	/**
	 * 添加信息
	 * @param singleChoice
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addSingleChoice")
	public String addSingleChoice(SingleChoice singleChoice) {
		singleChoice.setCreateTime(new Date());
		int row = SingleChoiceService.insert(singleChoice);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
	/**
	 * 修改信息
	 * @param singleChoice
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateSingleChoice")
	public String updateSingleChoice(SingleChoice singleChoice) {
		singleChoice.setCreateTime(new Date());
		int row = SingleChoiceService.update(singleChoice);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
}
