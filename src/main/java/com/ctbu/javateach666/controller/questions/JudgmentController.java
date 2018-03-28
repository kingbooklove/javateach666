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
import com.ctbu.javateach666.pojo.po.questions.Judgment;
import com.ctbu.javateach666.pojo.po.questions.SingleChoice;
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
	 * 加载判断题题目
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/judgement")
	public String listJudgment(HttpServletRequest request,HttpServletResponse response) {
		// 获取传入当前页和每页显示数
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer rows = Integer.valueOf(request.getParameter("rows"));

        Judgment judgment = new Judgment();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        // 查询参数
        String couseId = request.getParameter("couseId");
        String degree = request.getParameter("degree");
        String bTime = request.getParameter("bTime");
        String eTime = request.getParameter("eTime");
        if(couseId != null && !"".equals(couseId)) {
        	THCCoursePO course = new THCCoursePO();
        	course.setId(Integer.valueOf(couseId));
        	judgment.setCourse(course);
        }
        if(degree != null && !"".equals(degree)) {
        	judgment.setDegree(degree);
        }
        if(bTime != null && !"".equals(bTime)) {
        	try {
				judgment.setbTime(format.parse(bTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        if(eTime != null && !"".equals(eTime)) {
        	try {
        		judgment.seteTime(format.parse(eTime));
        	} catch (ParseException e) {
        		e.printStackTrace();
        	}
        }
        
        
        List<Judgment> list = JudgmentService.findList(judgment);
		String json = PageUtil.findPage(page, rows, list);
		return json;
	}
	/**
	 * 逻辑删除判断题
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/deleteJudgment")
	public String deleteJudgment(HttpServletRequest request,HttpServletResponse response) {
		String ids = request.getParameter("judgeids");
		String[] idarr = ids.split(",");
		for(String id : idarr) {
			Judgment judgment = new Judgment();
			judgment.setId(Integer.valueOf(id));
			JudgmentService.deleteByLogic(judgment);
		}
		return "OK";
	}
	
	/**
	 * 添加信息
	 * @param Judgment
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addJudgment")
	public String addJudgment(Judgment judgment) {
		judgment.setCreateTime(new Date());
		int row = JudgmentService.insert(judgment);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
	/**
	 * 修改信息
	 * @param Judgment
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateJudgment")
	public String updateJudgment(Judgment judgment) {
		judgment.setCreateTime(new Date());
		int row = JudgmentService.update(judgment);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
	
	
}
