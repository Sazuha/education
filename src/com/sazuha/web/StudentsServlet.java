package com.sazuha.web;

import com.google.gson.Gson;
import com.sazuha.pojo.Course;
import com.sazuha.pojo.Students;
import com.sazuha.pojo.Teacher;
import com.sazuha.service.CourseService;
import com.sazuha.service.StudentService;
import com.sazuha.service.impl.CourseServiceImpl;
import com.sazuha.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sazuha
 */

public class StudentsServlet extends BaseServlet {
    private StudentService studentService = new StudentServiceImpl();
    private CourseService courseService = new CourseServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");
        int usertype = Integer.parseInt(req.getParameter("usertype"));

        switch (usertype){
            case 0:Students loginUser = studentService.studentLogin(new Students(id,null,password,0,0,0));
                if(loginUser==null){
                    System.out.println("用户名或密码错误");
                    resp.setCharacterEncoding("GBK");
                    resp.getWriter().print("<script>alert('用户名或密码错误');window.location.href='/project/pages/user/login.html'</script>");
                }else {
                    System.out.println("学生登录成功");
                    req.getSession().setAttribute("user",loginUser);
                    resp.setCharacterEncoding("GBK");
                    resp.getWriter().print("<script>alert('登录成功');window.location.href='/project/pages/user/student.html'</script>");
                }break;
            case 1:req.getRequestDispatcher("/teacherServlet?action=login").forward(req,resp);break;
            case 2:break;
        }

    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.setCharacterEncoding("GBK");
        resp.getWriter().print("<script>alert('已注销');window.location.href='/project/pages/user/login.html'</script>");
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students student = (Students)req.getSession().getAttribute("user");
        List<Course> courses = new ArrayList<>();
        if((student.getCou1()!=0)&&(courseService.searchCourseById(student.getCou1()))!=null){
            courses.add(courseService.searchCourseById(student.getCou1()));
        }
        if((student.getCou2()!=0)&&(courseService.searchCourseById(student.getCou2()))!=null){
            courses.add(courseService.searchCourseById(student.getCou2()));
        }

        Gson gson = new Gson();
        String json = gson.toJson(courses);
        resp.getWriter().print(json);
    }

    protected void doNotChooseCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students student = (Students) req.getSession().getAttribute("user");
        StudentService studentService = new StudentServiceImpl();

        int id = Integer.parseInt(req.getParameter("id"));
        Course course = courseService.searchCourseById(id);
        if(course.getStunum()>0){
            if(studentService.studentDoNotChooseCourse(student.getId(),id)==-1){
                System.out.println("失败");
            }else{
                courseService.doNotChooseCourse(id);
                req.getSession().setAttribute("user",studentService.studentLogin(new Students(student.getId(),null,student.getPassword(),0,0,student.getClassid())));
            }
        }else{
            System.out.println("失败");
        }
        resp.sendRedirect("/project/pages/user/student.html");

    }

    protected void changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students student = (Students) req.getSession().getAttribute("user");
        StudentService studentService = new StudentServiceImpl();

        studentService.changePassword(student.getId(),req.getParameter("password"),req.getParameter("newPassword"));
        resp.sendRedirect("/project/pages/user/student.html");
        };

}
