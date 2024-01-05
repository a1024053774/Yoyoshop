package com.lanou.yoyoshop.web;

import com.lanou.yoyoshop.bean.Cart;
import com.lanou.yoyoshop.bean.Goods;
import com.lanou.yoyoshop.bean.Item;
import com.lanou.yoyoshop.bean.User;
import com.lanou.yoyoshop.service.ICartService;
import com.lanou.yoyoshop.service.IGoodService;
import com.lanou.yoyoshop.service.impl.CartServiceImpl;
import com.lanou.yoyoshop.service.impl.GoodServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCartServlet", value = "/index/addToCart")
public class AddToCartServlet extends HttpServlet {
    IGoodService goodService = new GoodServiceImpl();
    ICartService cartService = new CartServiceImpl();
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

        //3.检查session中是否有购物车，如果没有，新建一个
        Object obj = session.getAttribute("cart");
        if (obj == null){
        Cart cart = new Cart();
        cart.setTotal(0.0);
        cart.setAmount(0);
        cart.setUserId(((User)user).getId());
        List<Item> itemList = new ArrayList<>();
        cart.setItemList(itemList);
        session.setAttribute("cart",cart);
        obj = session.getAttribute("cart");
        }
        boolean result = cartService.addToCart((Cart)obj,goods);
        if(result){
            response.getWriter().print("ok");
        } else {
            response.getWriter().print("empty");
        }

    }
}
