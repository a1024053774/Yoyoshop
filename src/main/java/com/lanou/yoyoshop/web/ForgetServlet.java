package com.lanou.yoyoshop.web;

import com.lanou.yoyoshop.bean.User;
import com.lanou.yoyoshop.service.IUserService;
import com.lanou.yoyoshop.service.impl.UserServiceImpl;
import com.lanou.yoyoshop.util.SafeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ForgetServlet", value = "/index/forget")
public class ForgetServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index/forget.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");

        User user = userService.getUserByUsernameAndPhone(username,phone);
        if (user == null){
            request.setAttribute("msg","用户不存在或者填写错误！");
            request.getRequestDispatcher("/index/forget.jsp").forward(request,response);
        } else {
            user.setPassword(SafeUtil.encode("123456"));
            boolean forgetResult = userService.updateUser(user);
            if (forgetResult){
                request.setAttribute("msg","密码重置成功为123456");
            } else {
                request.setAttribute("msg","密码重置失败");
            }
        }
        request.getRequestDispatcher("/index/forget.jsp").forward(request,response);
    }
}
