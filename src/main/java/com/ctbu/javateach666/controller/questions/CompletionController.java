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

import com.ctbu.javateach666.pojo.po.questions.Completion;
import com.ctbu.javateach666.pojo.po.thcpo.THCCoursePO;
import com.ctbu.javateach666.service.interfac.questions.CompletionService;
import com.ctbu.javateach666.util.PageUtil;

/**
 * 单选题control
 * @author king
 *
 */
@Controller
@RequestMapping("/completion")
public class CompletionController {
	
	@Autowired
	private CompletionService CompletionService;
	
	/**
	 * 转发到填空题页面
	 * @return
	 */
	@RequestMapping("/completion")
	public String completion() {
		return "questions/completion";
	}
	
	/**
	 * 加载填空题题目
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/completions")
	public String listCompletion(HttpServletRequest request,HttpServletResponse response) {
		// 获取传入当前页和每页显示数
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer rows = Integer.valueOf(request.getParameter("rows"));
        
        Completion completion = new Completion();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        // 查询参数
        String couseId = request.getParameter("couseId");
        String degree = request.getParameter("degree");
        String bTime = request.getParameter("bTime");
        String eTime = request.getParameter("eTime");
        if(couseId != null && !"".equals(couseId)) {
        	THCCoursePO course = new THCCoursePO();
        	course.setId(Integer.valueOf(couseId));
        	completion.setCourse(course);
        }
        if(degree != null && !"".equals(degree)) {
        	completion.setDegree(degree);
        }
        if(bTime != null && !"".equals(bTime)) {
        	try {
				completion.setbTime(format.parse(bTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        if(eTime != null && !"".equals(eTime)) {
        	try {
        		completion.seteTime(format.parse(eTime));
        	} catch (ParseException e) {
        		e.printStackTrace();
        	}
        }
        
        
        List<Completion> list = CompletionService.findList(completion);
		String json = PageUtil.findPage(page, rows, list);
		return json;
	}
	
	
	/**
	 * 逻辑删除单选题
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/deleteCompletion")
	public String deleteCompletion(HttpServletRequest request,HttpServletResponse response) {
		String ids = request.getParameter("completionids");
		String[] idarr = ids.split(",");
		for(String id : idarr) {
			Completion completion = new Completion();
			completion.setId(Integer.valueOf(id));
			CompletionService.deleteByLogic(completion);
		}
		return "OK";
	}
	
	/**
	 * 添加信息
	 * @param completion
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addCompletion")
	public String addCompletion(Completion completion) {
		completion.setCreateTime(new Date());
		int row = CompletionService.insert(completion);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
	/**
	 * 修改信息
	 * @param completion
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCompletion")
	public String updateCompletion(Completion completion) {
		completion.setCreateTime(new Date());
		int row = CompletionService.update(completion);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
}
