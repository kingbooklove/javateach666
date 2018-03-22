package com.ctbu.javateach666.controller.questions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbu.javateach666.pojo.po.questions.Judgment;
import com.ctbu.javateach666.service.interfac.questions.JudgmentService;
import com.ctbu.javateach666.util.PageUtil;

/**
 * 多选题control
 * @author king
 *
 */
@Controller
@RequestMapping("/judgment")
public class JudgmentController {
	
	@Autowired
	private JudgmentService JudgmentService;
	
	/**
	 * 转发到选择题页面
	 * @return
	 */
	@RequestMapping("/judge")
	public String judgment() {
		return "questions/judge";
	}
	
	/**
	 * 加载选择题题目
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/judgement")
	public String listMultipleChoice(HttpServletRequest request,HttpServletResponse response) {
		// 获取传入当前页和每页显示数
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer rows = Integer.valueOf(request.getParameter("rows"));

        Judgment judgment = new Judgment();
        List<Judgment> list = JudgmentService.findList(judgment);
		String json = PageUtil.findPage(page, rows, list);
		return json;
	}
	
	
}
