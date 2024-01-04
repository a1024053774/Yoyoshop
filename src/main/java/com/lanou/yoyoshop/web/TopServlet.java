package com.lanou.yoyoshop.web;

import com.lanou.yoyoshop.bean.Goods;
import com.lanou.yoyoshop.bean.Type;
import com.lanou.yoyoshop.service.IGoodService;
import com.lanou.yoyoshop.service.ITypeService;
import com.lanou.yoyoshop.service.impl.GoodServiceImpl;
import com.lanou.yoyoshop.service.impl.TypeServiceImpl;
import com.lanou.yoyoshop.util.PageUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TopServlet", value = "/index/top")
public class TopServlet extends HttpServlet {
    ITypeService typeService = new TypeServiceImpl();
    IGoodService goodService = new GoodServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int topTypeId = Integer.parseInt(request.getParameter("typeid"));
        request.setAttribute("typeid",topTypeId);
        request.setAttribute("flag",topTypeId + 5);
        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        int size = request.getParameter("size") == null ? 4 : Integer.parseInt(request.getParameter("size"));
        List<Goods> goodsList = goodService.getGoodsListByTopTypeIdPageQuery(topTypeId, page, size);
        request.setAttribute("goodList",goodsList);
        Long count = goodService.getGoodsCountByTopTypeId(topTypeId);
        String pageTool = PageUtil.getPageTool(request, count, page, size);
        request.setAttribute("pageTool",pageTool);

        List<Type> typeList = typeService.getAllTypeList();
        request.setAttribute("typeList",typeList);
        request.getRequestDispatcher("/index/goods.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
