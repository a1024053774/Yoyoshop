package com.lanou.yoyoshop.web;

import com.lanou.yoyoshop.bean.Goods;
import com.lanou.yoyoshop.service.IGoodService;
import com.lanou.yoyoshop.service.impl.GoodServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/index/addToCart")
public class AddToCartServlet extends HttpServlet {
    IGoodService goodService = new GoodServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.判断用户是否登录
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        //如果用户未登录
        if (user == null){
            response.getWriter().print("login");
            return;
        }

        //2.根据前端传来商品ID获得商品对象
        Integer goodid = Integer.parseInt(request.getParameter("goodid"));
        Goods goods = goodService.getGoodsByGoodsId(goodid);
    }
}
