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

@WebServlet(name = "GoodsListServlet", value = "/index/goods")
public class GoodsListServlet extends HttpServlet {
    ITypeService typeService=new TypeServiceImpl();
    IGoodService goodService=new GoodServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int typeId =Integer.parseInt(request.getParameter("typeid"));
        int page=request.getParameter("page")==null? 1:Integer.parseInt(request.getParameter("page"));
        int size=request.getParameter("size")==null? 4:Integer.parseInt(request.getParameter("size"));
        Type type = typeService.getTypeByTypeId(typeId);
        List<Type> typeList = typeService.getAllTypeList();
        List<Goods> goodsList = goodService.getGoodsListByTypeIdPageQuery(typeId,page,size);
        request.setAttribute("goodList",goodsList);
        request.setAttribute("typeList",typeList);
        request.setAttribute("type",type);
        request.setAttribute("flag",2);
        Long count = goodService.getGoodsCountByTypeId(typeId);
        String pageTool = PageUtil.getPageTool(request, count, page, size);
        request.setAttribute("pageTool",pageTool);
        request.getRequestDispatcher("/index/goods.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
