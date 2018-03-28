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
import com.ctbu.javateach666.pojo.po.questions.Subjective;
import com.ctbu.javateach666.service.interfac.questions.SubjectiveService;
import com.ctbu.javateach666.util.PageUtil;

/**
 * 单选题control
 * @author king
 *
 */
@Controller
@RequestMapping("/subjective")
public class SubjectiveController {
	
	@Autowired
	private SubjectiveService subjectiveService;
	
	/**
	 * 转发到选择题页面
	 * @return
	 */
	@RequestMapping("/subjective")
	public String subjective() {
		return "questions/subjective";
	}
	
	/**
	 * 加载选择题题目
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/subjectives")
	public String listSubjective(HttpServletRequest request,HttpServletResponse response) {
		// 获取传入当前页和每页显示数
        Integer page = Integer.valueOf(request.getParameter("page"));
        Integer rows = Integer.valueOf(request.getParameter("rows"));
        
        Subjective subjective = new Subjective();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        // 查询参数
        String couseId = request.getParameter("couseId");
        String degree = request.getParameter("degree");
        String bTime = request.getParameter("bTime");
        String eTime = request.getParameter("eTime");
        if(couseId != null && !"".equals(couseId)) {
        	THCCoursePO course = new THCCoursePO();
        	course.setId(Integer.valueOf(couseId));
        	subjective.setCourse(course);
        }
        if(degree != null && !"".equals(degree)) {
        	subjective.setDegree(degree);
        }
        if(bTime != null && !"".equals(bTime)) {
        	try {
				subjective.setbTime(format.parse(bTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        if(eTime != null && !"".equals(eTime)) {
        	try {
        		subjective.seteTime(format.parse(eTime));
        	} catch (ParseException e) {
        		e.printStackTrace();
        	}
        }
        
        
        List<Subjective> list = subjectiveService.findList(subjective);
		String json = PageUtil.findPage(page, rows, list);
		return json;
	}
	
	
	/**
	 * 逻辑删除单选题
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/deleteSubjective")
	public String deleteSubjective(HttpServletRequest request,HttpServletResponse response) {
		String ids = request.getParameter("subjectiveids");
		String[] idarr = ids.split(",");
		for(String id : idarr) {
			Subjective subjective = new Subjective();
			subjective.setId(Integer.valueOf(id));
			subjectiveService.deleteByLogic(subjective);
		}
		return "OK";
	}
	
	/**
	 * 添加信息
	 * @param subjective
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addSubjective")
	public String addSubjective(Subjective subjective) {
		subjective.setCreateTime(new Date());
		int row = subjectiveService.insert(subjective);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
	/**
	 * 修改信息
	 * @param subjective
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateSubjective")
	public String updateSubjective(Subjective subjective) {
		subjective.setCreateTime(new Date());
		int row = subjectiveService.update(subjective);
		if(row == 1) {
			return "OK";
		} else {
			return "NO";
		}
	}
	
}
