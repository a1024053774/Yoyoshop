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

@WebServlet(name = "MyCenterServlet", value = "/index/my")
public class MyCenterServlet extends HttpServlet {
    private ITypeService typeService = new TypeServiceImpl();
    private IUserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/Yoyoshop/index/login");
            return;
        }
        request.setAttribute("flag",4);
        List<Type> typeList = typeService.getAllTypeList();
        request.setAttribute("typeList",typeList);
        request.getRequestDispatcher("/index/my.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1代表更新用户信息，2代表修改密码
        String submitType = request.getParameter("type");
        //获得用户ID
        String userId = request.getParameter("id");

        User user = userService.getUserByUserId(Integer.parseInt(userId));

        if (submitType.equals("1")){
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            user.setName(name);
            user.setPhone(phone);
            user.setAddress(address);

            boolean result = userService.updateUser(user);
            if (result){
                request.setAttribute("msg","用户资料更新成功！");

                HttpSession session = request.getSession();
                session.setAttribute("user",user);


            } else {
                request.setAttribute("msg","用户资料更新失败！");
            }
        } else {
            //Type类型为2
            String password = request.getParameter("password");
            String passwordNew = request.getParameter("passwordNew");

            if (user.getPassword().equals(SafeUtil.encode(password))){
                user.setPassword(SafeUtil.encode(passwordNew));
                boolean passwordResult = userService.updateUser(user);
                if (passwordResult){
                    request.setAttribute("msg","密码修改成功！");
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                } else {
                    request.setAttribute("msg","密码修改失败！");
                }
            } else {
                request.setAttribute("msg","原密码不正确");
            }
        }
        doGet(request,response);

    }
}
