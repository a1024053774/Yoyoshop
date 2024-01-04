package com.lanou.yoyoshop.web;

import com.lanou.yoyoshop.bean.Goods;
import com.lanou.yoyoshop.bean.Type;
import com.lanou.yoyoshop.service.IGoodService;
import com.lanou.yoyoshop.service.ITypeService;
import com.lanou.yoyoshop.service.impl.GoodServiceImpl;
import com.lanou.yoyoshop.service.impl.TypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet", value = "/index/detail")
public class DetailServlet extends HttpServlet {
    ITypeService typeService = new TypeServiceImpl();
    IGoodService goodService = new GoodServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int goodId = Integer.parseInt(request.getParameter("goodid"));
        Goods good = goodService.getGoodsByGoodsId(goodId);
        request.setAttribute("good",good);


        List<Type> typeList = typeService.getAllTypeList();
        request.setAttribute("typeList",typeList);
        request.getRequestDispatcher("/index/detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
