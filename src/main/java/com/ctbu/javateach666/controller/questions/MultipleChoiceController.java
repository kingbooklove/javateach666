package com.ctbu.javateach666.controller.questions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbu.javateach666.pojo.po.questions.MultipleChoice;
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
        List<MultipleChoice> list = MultipleChoiceService.findList(multipleChoice);
		String json = PageUtil.findPage(page, rows, list);
		return json;
	}
	
	
}
