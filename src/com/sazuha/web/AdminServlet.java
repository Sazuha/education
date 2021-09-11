package com.sazuha.web;

import com.google.gson.Gson;
import com.sazuha.dao.impl.BaseDao;
import com.sazuha.pojo.*;
import com.sazuha.service.AdminService;
import com.sazuha.service.TeacherService;
import com.sazuha.service.impl.AdminServiceImpl;
import com.sazuha.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ASUS
 */
public class AdminServlet extends BaseServlet {
    private AdminService adminService = new AdminServiceImpl();
    private TeacherService teacherService = new TeacherServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");

        Admin loginUser = adminService.adminLogin(new Admin(id,password));
        System.out.println(loginUser);
        if(loginUser==null){
            System.out.println("用户名或密码错误");
            resp.setCharacterEncoding("GBK");
            resp.getWriter().print("<script>alert('用户名或密码错误');window.location.href='/project/pages/user/login.html'</script>");
        }else {
            System.out.println("管理员登录成功");
            req.getSession().setAttribute("user",loginUser);
            resp.setCharacterEncoding("GBK");
            resp.getWriter().print("<script>alert('登录成功');window.location.href='/project/pages/user/admin/admin.html'</script>");
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.setCharacterEncoding("GBK");
        resp.getWriter().print("<script>alert('已注销');window.location.href='/project/pages/user/login.html'</script>");
    }

    protected void changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = (Admin) req.getSession().getAttribute("user");
        AdminService adminService = new AdminServiceImpl();

        adminService.changePassword(admin.getId(),req.getParameter("password"),req.getParameter("newPassword"));
        resp.sendRedirect("/project/pages/user/admin/admin.html");
    };

    protected void listTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<Teacher> teachers = adminService.listTeacher();
        Gson gson = new Gson();
        String json = gson.toJson(teachers);
        resp.getWriter().print(json);
    }

    protected void delTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        adminService.delTeacher(id);
        resp.sendRedirect("/project/pages/user/admin/teacherManagement.html");
    }

    protected void addTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        adminService.addTeacher(new Teacher(null,name,password));

        resp.sendRedirect("/project/pages/user/admin/teacherManagement.html");
    }

    protected void listClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<Class_> classes = adminService.listClass();
        System.out.println(classes);
        Gson gson = new Gson();
        String json = gson.toJson(classes);
        resp.getWriter().print(json);
    }

    protected void intoClass(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        int classId = Integer.parseInt(req.getParameter("id"));
        req.getSession().setAttribute("classId",classId);
        resp.sendRedirect("/project/pages/user/admin/studentManagement.html");
    }

    protected void delClass(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        adminService.delClass(id);
        resp.sendRedirect("/project/pages/user/admin/classManagement.html");
    }

    protected void addClass(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        adminService.addClass(new Class_(null,name));
        resp.sendRedirect("/project/pages/user/admin/classManagement.html");
    }

    protected void listStudent(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        String classId = req.getSession().getAttribute("classId").toString();
        List<Students> students = adminService.listStudentByClass(Integer.parseInt(classId));
        System.out.println(students);
        Gson gson = new Gson();
        String json = gson.toJson(students);
        resp.getWriter().print(json);
    }

    protected void addStudent(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=UTF-8");
        String classId = req.getSession().getAttribute("classId").toString();
        adminService.addStudent(new Students(null,name,password,0,0,Integer.parseInt(classId)));

        resp.sendRedirect("/project/pages/user/admin/studentManagement.html");
    }

    protected void delStudent(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        adminService.delStudent(id);
        resp.sendRedirect("/project/pages/user/admin/studentManagement.html");
    }
}
