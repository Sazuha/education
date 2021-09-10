package com.sazuha.web;

import com.google.gson.Gson;
import com.sazuha.dao.CourseDao;
import com.sazuha.pojo.Course;
import com.sazuha.pojo.Students;
import com.sazuha.pojo.Teacher;
import com.sazuha.service.CourseService;
import com.sazuha.service.TeacherService;
import com.sazuha.service.impl.CourseServiceImpl;
import com.sazuha.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ASUS
 */
public class TeacherServlet extends BaseServlet{
    private TeacherService teacherService = new TeacherServiceImpl();
    private CourseService courseService = new CourseServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");

        Teacher loginUser = teacherService.teacherLogin(new Teacher(id,null,password));
        if(loginUser==null){
            System.out.println("用户名或密码错误");
            resp.setCharacterEncoding("GBK");
            resp.getWriter().print("<script>alert('用户名或密码错误');window.location.href='/project/pages/user/login.html'</script>");
        }else {
            System.out.println("教师登录成功");
            req.getSession().setAttribute("user",loginUser);
            resp.setCharacterEncoding("GBK");
            resp.getWriter().print("<script>alert('登录成功');window.location.href='/project/pages/user/teacher/teacher.html'</script>");
        }
    }

    protected void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = (Teacher) req.getSession().getAttribute("user");
        String name = req.getParameter("name");
        int time = Integer.parseInt(req.getParameter("time"));
        int maxstu = Integer.parseInt(req.getParameter("maxstu"));
        String classroom = req.getParameter("classroom");

        if(teacherService.newCourse(new Course(null,name,time,0,maxstu,teacher.getName(),classroom))!=-1){
            System.out.println("成功");
            resp.sendRedirect("/project/pages/user/teacher/teacher.html");
        }else{
            System.out.println("失败");
            resp.sendRedirect("/project/pages/user/teacher/teacherAddCourse.html");
        }

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = (Teacher)req.getSession().getAttribute("user");
        List<Course> courses = courseService.searchCourseByTeacher(teacher.getName());
        Gson gson = new Gson();
        String json = gson.toJson(courses);
        resp.getWriter().print(json);
    }

    protected void delCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        courseService.delCourse(id);
        teacherService.isExistCourse(id);
        resp.sendRedirect("/project/pages/user/teacher/teacher.html");
    }
}
