package com.sazuha.web;

import com.google.gson.Gson;
import com.sazuha.pojo.Course;
import com.sazuha.pojo.Students;
import com.sazuha.service.CourseService;
import com.sazuha.service.StudentService;
import com.sazuha.service.impl.CourseServiceImpl;
import com.sazuha.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Sazuha
 */
public class CourseServlet extends BaseServlet{
    private CourseService courseService = new CourseServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<Course> courses = courseService.searchCourse();
        Gson gson = new Gson();
        String json = gson.toJson(courses);
        resp.getWriter().print(json);
    }

    protected void chooseCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students student = (Students) req.getSession().getAttribute("user");
        StudentService studentService = new StudentServiceImpl();
        System.out.println(student);

        int id = Integer.parseInt(req.getParameter("id"));
        Course course = courseService.searchCourseById(id);
        if(course.getStunum()<course.getMaxnum()){
            if(studentService.chooseCourse(student.getId(),id)==-1){
                System.out.println("失败");
            }else{
                courseService.chooseCourse(id);
                req.getSession().setAttribute("user",studentService.studentLogin(new Students(student.getId(),null,student.getPassword(),0,0)));
            }
        }else{
            System.out.println("人数已满");
        }
        resp.sendRedirect("/project/pages/user/student.html");
    }

    protected void doNotChooseCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students student = (Students) req.getSession().getAttribute("user");
        StudentService studentService = new StudentServiceImpl();
        System.out.println(student);

        int id = Integer.parseInt(req.getParameter("id"));
        Course course = courseService.searchCourseById(id);
        if(course.getStunum()>0){
            if(studentService.studentDoNotChooseCourse(student.getId(),id)==-1){
                System.out.println("失败");
            }else{
                courseService.doNotChooseCourse(id);
            }
        }else{
            System.out.println("失败");
        }
        resp.sendRedirect("/project/pages/user/student.html");
    }


}

