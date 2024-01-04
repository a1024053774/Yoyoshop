package com.lanou.yoyoshop.web;

import com.lanou.yoyoshop.bean.Type;
import com.lanou.yoyoshop.bean.User;
import com.lanou.yoyoshop.service.ITypeService;
import com.lanou.yoyoshop.service.IUserService;
import com.lanou.yoyoshop.service.impl.TypeServiceImpl;
import com.lanou.yoyoshop.service.impl.UserServiceImpl;
import com.lanou.yoyoshop.util.SafeUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/index/login")
public class LoginServlet extends HttpServlet {
    private ITypeService typeService = new TypeServiceImpl();
    private IUserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Type> typeList = typeService.getAllTypeList();
        request.setAttribute("typeList",typeList);
        request.setAttribute("flag",6);
        request.getRequestDispatcher("/index/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUserByUsernameAndPassword(username, SafeUtil.encode(password));
        if (user == null){
            request.setAttribute("msg","用户名不存在或密码不正确！");
            request.getRequestDispatcher("/index/login.jsp").forward(request,response);
        } else {
            //把用户信息存入session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/Yoyoshop/index/index");
        }
    }
}
