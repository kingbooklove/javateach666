package com.ctbu.javateach666.controller.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ctbu.javateach666.pojo.po.exam.ReleaseExam;
import com.ctbu.javateach666.service.interfac.exam.ExamService;

/**
 * 考试control
 * @author king
 *
 */
@Controller
@RequestMapping("/exam")
public class ExamController {
	@Autowired
	private ExamService ExamService;
	
	/**
	 * 跳转到安排考试列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/exam")
	public String initExam() {
        return "exam/exam";
    }
	
	/**
	 * 加载安排考试数据
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getExams")
	@ResponseBody
	public String getExams(HttpServletRequest request, HttpServletResponse response) {
        // 获取	传入当前页和每页显示数
        String json = null;

        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String couName = request.getParameter("couName");
        
        ReleaseExam releaseExam = new ReleaseExam();
        //判断姓名是否非空
        if (couName != null && !"".equals(couName)) {
        	releaseExam.setCourseName(couName);
        }
        List<ReleaseExam> exams = ExamService.findList(releaseExam);
//        List<Course> course = adminService.getTypesForPage(Course.class, condition, Integer.valueOf(page), Integer.valueOf(rows));
//        if (CollectionUtils.isNotBlank(course)) {
//            Exam exam = new Exam();
//            for (Course cou : course) {
//                Integer courseId = cou.getCourseId();
//                exam.setCourseID(courseId);
//                List<Exam> select = adminService.getTypeItems(exam);
//                if (CollectionUtils.isNotBlank(select)) {
//                    exams.addAll(select);
//                }
//            }
//        }
        //	获取信息总条数
        int size = exams.size();
        int begin = (Integer.parseInt(page) - 1) * Integer.parseInt(rows);
        int end = begin + Integer.parseInt(rows);
        List<ReleaseExam> subList = exams.subList(begin, end > size ? size : end);
        // 调用方法查询
        Map<String, Object> map = new HashMap<>();
        map.put("rows", subList);
        map.put("total", size);
        json = JSON.toJSONString(map);
        return json;
    }
	
	/**
	 * 根据当前用户获取用户拥有的课程列表
	 * @param request
	 * @param response
	 */
	@RequestMapping("getCourseJson")
	@ResponseBody
	public String getCourseJson(HttpServletRequest request, HttpServletResponse response) {
//        Integer userId = (Integer) request.getSession().getAttribute("userId");
//        User user = new UserServiceImpl().getUserByUserId(userId);
//        List<Map<String, Object>> courseList = new ArrayList<>();
//
//        List<TeacherCourse> teacherCourses = new TeacherServiceImpl().geTeacherCoursesByTeaId(user.getTeaId());
//        if (CollectionUtils.isNotBlank(teacherCourses)) {
//            CourseService courseService = new CourseServiceImpl();
//            for (TeacherCourse teacherCourse : teacherCourses) {
//                Course course = courseService.getCourseByID(teacherCourse.getCourseId());
//                Map<String, Object> map = new HashMap<>();
//                map.put("id", course.getCourseId());
//                map.put("name", course.getCourseName());
//                courseList.add(map);
//            }
//        }
//
//        String json = JSON.toJSONString(courseList);
		
		
		
		String json = "[{\"name\":\"java基础开发\",\"id\":1},{\"name\":\"Oracle数据库\",\"id\":2},{\"name\":\"C#基础开发\",\"id\":3},{\"name\":\"Mysql数据库\",\"id\":4}]";
        return json;
    }
	
	
}
