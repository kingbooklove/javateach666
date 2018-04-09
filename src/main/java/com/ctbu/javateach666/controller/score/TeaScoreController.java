package com.ctbu.javateach666.controller.score;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctbu.javateach666.pojo.po.exam.Achievement;
import com.ctbu.javateach666.service.interfac.exam.AchievementService;
import com.ctbu.javateach666.util.PageUtil;

/**
 * 考试成绩control
 * @author king
 *
 */
@Controller
@RequestMapping("/teascore")
public class TeaScoreController {
	
	@Autowired
	private AchievementService AchievementService;
	
	/**
	 * 初始化到教师成绩页面
	 * @return
	 */
	@RequestMapping("/initTeaScore")
	public String initTeaScore() {
		return "score/teascore";
	}
	
	/**
	 * 加载成绩
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getScores")
	@ResponseBody
	public String getScores(HttpServletRequest request, HttpServletResponse response) {
		// 获取	传入当前页和每页显示数
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        Achievement achievement = new Achievement();
        
        String paperId = request.getParameter("paperId");
        String stuName = request.getParameter("stuName");
        String json = "{}";
        if(paperId != null && !"".equals(paperId)) {
        	achievement.setPaperId(Integer.valueOf(paperId));
        	if(stuName != null && !"".equals(stuName)) {
        		achievement.setStuName(stuName);;
        	}
        	List<Achievement> findList = AchievementService.findList(achievement);
        	
        	int size = findList.size();
            int begin = (Integer.parseInt(page) - 1) * Integer.parseInt(rows);
            int end = begin + Integer.parseInt(rows);
            List<Achievement> subList = findList.subList(begin, end > size ? size : end);
        	json = PageUtil.creatDataGritJson(subList, size);
        }
        return json;
	}
}
