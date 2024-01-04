package com.lanou.yoyoshop.web;

import com.lanou.yoyoshop.bean.Goods;
import com.lanou.yoyoshop.bean.Type;
import com.lanou.yoyoshop.service.IGoodService;
import com.lanou.yoyoshop.service.ITypeService;
import com.lanou.yoyoshop.service.impl.GoodServiceImpl;
import com.lanou.yoyoshop.service.impl.TypeServiceImpl;
import com.lanou.yoyoshop.util.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet("/index/index")
public class IndexServlet extends HttpServlet {

    ITypeService typeService=new TypeServiceImpl();
    IGoodService goodService=new GoodServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置默认显示页面为首页
        req.setAttribute("flag",1);

        List<Type> typeList=typeService.getAllTypeList();
        req.setAttribute("typeList",typeList);
        //今日精品
        List<Goods> top1GoodsList =  goodService.getGoodsListByTopTypeId(1);
        req.setAttribute("top1List", top1GoodsList);
        //热销商品
        List<Goods> top2GoodsList =goodService.getGoodsListByTopTypeId(2);
        req.setAttribute("top2List", top2GoodsList);
        //最新商品
        List<Goods> top3GoodsList = goodService.getGoodsListByTopTypeId(3);
        req.setAttribute("top3List", top3GoodsList);

        req.getRequestDispatcher("/index/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
