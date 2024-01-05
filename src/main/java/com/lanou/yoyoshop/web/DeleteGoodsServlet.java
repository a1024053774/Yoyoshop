package com.lanou.yoyoshop.web;

import com.lanou.yoyoshop.bean.Cart;
import com.lanou.yoyoshop.service.ICartService;
import com.lanou.yoyoshop.service.impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteGoodsServlet", value = "/index/delete")
public class DeleteGoodsServlet extends HttpServlet {
    ICartService cartService = new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.检查session是否过期
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null){
            response.getWriter().print("login");
            return;
        }

        Integer goodId = Integer.parseInt(request.getParameter("goodid"));
        Object cart = session.getAttribute("cart");
        boolean result = cartService.deleteFromCart((Cart) cart, goodId);
        if(result){
            //清除session中的信息
            session.removeAttribute("cart");
        }
        response.getWriter().print("ok");

    }
}
