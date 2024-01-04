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

@WebServlet(name = "RegisterServlet", value = "/index/register")
public class RegisterServlet extends HttpServlet {
    private ITypeService typeService = new TypeServiceImpl();
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("flag",5);

        List<Type> typeList = typeService.getAllTypeList();
        request.setAttribute("typeList",typeList);
        request.getRequestDispatcher("/index/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");


        //先检查注册名是否已经存在
        User user = userService.getUserByUsername(username);
        if (user == null){
            user = new User();
            user.setUsername(username);
            user.setPassword(SafeUtil.encode(password));
            user.setName(name);
            user.setPhone(phone);
            user.setAddress(address);
            boolean result = userService.addUser(user);
            if(result){
                request.setAttribute("msg","注册成功，请前往页面登录！");
            } else {
                request.setAttribute("msg","注册失败！");
            }
        } else {
            request.setAttribute("msg","用户名已存在，请更换用户名！");
        }
        //解决typelist没有以及跳回注册页
        doGet(request,response);
    }
}
