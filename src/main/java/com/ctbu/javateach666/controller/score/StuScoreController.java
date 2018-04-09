package com.ctbu.javateach666.controller.score;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ctbu.javateach666.pojo.po.kingother.Account;
import com.ctbu.javateach666.pojo.po.kingother.StuCourse;
import com.ctbu.javateach666.service.interfac.exam.AchievementService;
import com.ctbu.javateach666.service.interfac.kingother.AccountService;
import com.ctbu.javateach666.service.interfac.kingother.StuCourseService;
import com.ctbu.javateach666.util.CollectionUtils;
import com.ctbu.javateach666.util.UserMessageUtils;

/**
 * 学生考试成绩control
 * @author king
 *
 */
@Controller
@RequestMapping("/stuscore")
public class StuScoreController {
	
	@Autowired
	private StuCourseService StuCourseService;
	
	@Autowired
	private AccountService AccountService;
	
	/**
	 * 初始化到学生成绩页面
	 * @return
	 */
	@RequestMapping("/initStuScore")
	public String initStuScore() {
		return "score/stuscore";
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
		// 获取当前用户的id
        String userName = UserMessageUtils.getNowUserName();
        Account account = new Account();
        account.setUsername(userName);
        List<Account> accountlist = AccountService.findList(account);
        if(CollectionUtils.isNotBlank(accountlist)) {
        	account = accountlist.get(0);
        }
        
        String couyear = request.getParameter("couyear");
        String semester = request.getParameter("semester");
        
        String json = "";
        
        StuCourse stuCourse = new StuCourse();
        stuCourse.setStuid(account.getUserdetailid());
        if(couyear != null && !"".equals(couyear) && semester != null && !"".equals(semester)) {
        	stuCourse.setCouyear(Integer.valueOf(couyear));
        	stuCourse.setSemester(Integer.valueOf(semester));
        	List<StuCourse> findList = StuCourseService.findList(stuCourse);
        	json = JSON.toJSONString(findList);
        }
		return json;
	}
}
