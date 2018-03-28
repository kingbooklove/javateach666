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
import com.ctbu.javateach666.pojo.po.questions.MultipleChoice;
import com.ctbu.javateach666.pojo.po.questions.SingleChoice;
import com.ctbu.javateach666.service.interfac.questions.MultipleChoiceService;
import com.ctbu.javateach666.util.PageUtil;

/**
 * 多选题control
 * @author king
 *
 */
@Controller
@RequestMapping("/multiple")
public class MultipleChoiceController {
	
	@Autowired
	private MultipleChoiceService MultipleChoiceService;
	
	/**
	 * 转发到选择题页面
	 * @return
	 */
	@RequestMapping("/multiplechoice")
	public String multiplechoice() {
		return "questions/multiplechoice";
	}
	
	/**
	 * 加载选择题题目
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/multiple")
	public String listMultipleChoice(HttpServletRequest request,HttpServletResponse response) {
		// 获取传入当前页和每页显示数
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer rows = Integer.valueOf(request.getParameter("rows"));

        MultipleChoice multipleChoice = new MultipleChoice();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        // 查询参数
        String couseId = request.getParameter("couseId");
        String degree = request.getParameter("degree");
        String bTime = request.getParameter("bTime");
        String eTime = request.getParameter("eTime");
        if(couseId != null && !"".equals(couseId)) {
        	THCCoursePO course = new THCCoursePO();
        	course.setId(Integer.valueOf(couseId));
        	multipleChoice.setCourse(course);
        }
        if(degree != null && !"".equals(degree)) {
        	multipleChoice.setDegree(degree);
        }
        if(bTime != null && !"".equals(bTime)) {
        	try {
        		multipleChoice.setbTime(format.parse(bTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        if(eTime != null && !"".equals(eTime)) {
        	try {
        		multipleChoice.seteTime(format.parse(eTime));
        	} catch (ParseException e) {
        		e.printStackTrace();
        	}
        }
        
        List<MultipleChoice> list = MultipleChoiceService.findList(multipleChoice);
		String json = PageUtil.findPage(page, rows, list);
		return json;
	}
	
	/**
	 * 逻辑删除多选题
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/deleteMultipleChoice")
	public String deleteMultipleChoice(HttpServletRequest request,HttpServletResponse response) {
		String ids = request.getParameter("choiceids");
		String[] idarr = ids.split(",");
		for(String id : idarr) {
			MultipleChoice multipleChoice = new MultipleChoice();
			multipleChoice.setId(Integer.valueOf(id));
			MultipleChoiceService.deleteByLogic(multipleChoice);
		}
		return "OK";
	}
	
	/**
	 * 添加信息
	 * @param singleChoice
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addMultipleChoice")
	public String addMultipleChoice(MultipleChoice multipleChoice) {
		multipleChoice.setCreateTime(new Date());
		int row = MultipleChoiceService.insert(multipleChoice);
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
	@RequestMapping("/updateMultipleChoice")
	public String updateMultipleChoice(MultipleChoice multipleChoice) {
		multipleChoice.setCreateTime(new Date());
		int row = MultipleChoiceService.update(multipleChoice);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
}
