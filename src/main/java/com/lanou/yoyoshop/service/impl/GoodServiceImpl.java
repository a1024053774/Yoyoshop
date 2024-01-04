package com.lanou.yoyoshop.service.impl;

import com.lanou.yoyoshop.bean.Goods;
import com.lanou.yoyoshop.bean.Type;
import com.lanou.yoyoshop.dao.IGoodsDao;
import com.lanou.yoyoshop.dao.ITypeDao;
import com.lanou.yoyoshop.dao.impl.GoodsDaoImpl;
import com.lanou.yoyoshop.dao.impl.TypeDaoImpl;
import com.lanou.yoyoshop.service.IGoodService;
import com.lanou.yoyoshop.util.DBUtils;

import java.util.List;

public class GoodServiceImpl implements IGoodService {
    IGoodsDao goodsDao=new GoodsDaoImpl();
    ITypeDao typeDao=new TypeDaoImpl();
    @Override
    public List<Goods> getGoodsListByTopTypeId(Integer topTypeId) {
        List<Goods> goodsList = goodsDao.selectGoodsListByTopTypeId(topTypeId);
        for (Goods goods: goodsList){
            Integer typeId= goods.getTypeId();
            Type type=typeDao.selectTypeByTypeId(typeId);
            goods.setType(type);
        }
        return goodsList;
    }

    @Override
    public List<Goods> getGoodsListByTopTypeIdPageQuery(Integer topTypeId, int page, int size) {
        List<Goods> goodsList = goodsDao.selectGoodsListByTopTypeIdPageQuery(topTypeId, page, size);
        for (Goods goods : goodsList){
            Integer typeId = goods.getTypeId();
            Type type = typeDao.selectTypeByTypeId(typeId);
            goods.setType(type);
        }
        return goodsList;
    }

    @Override
    public List<Goods> getGoodsListByTypeId(Integer typeId) {
        List<Goods> goodsList = goodsDao.selectGoodsListByTypeId(typeId);
        return goodsList;
    }

    @Override
    public List<Goods> getGoodsListByTypeIdPageQuery(Integer typeId, int page, int size) {
        return goodsDao.selectGoodsListByTypeIdPageQuery(typeId,page,size);
    }

    @Override
    public Long getGoodsCountByTypeId(Integer typeId) {
        return goodsDao.selectGoodsCountByTypeId(typeId);
    }

    @Override
    public Long getGoodsCountByTopTypeId(Integer topTypeId) {
        return goodsDao.selectGoodsCountByTopTypeId(topTypeId);
    }

    @Override
    public List<Goods> getGoodsListByKeywordPageQuery(String keyword, int page, int size) {
        return goodsDao.selectGoodsListByKeywordPageQuery(keyword, page, size);
    }

    @Override
    public Long getGoodsCountByKeyWord(String keyword) {
        return goodsDao.selectGoodsCountByKeyword(keyword);
    }

    @Override
    public Goods getGoodsByGoodsId(Integer goodId) {
        Goods good = goodsDao.selectGoodsByGoodsId(goodId);
        int typeId = good.getTypeId();
        Type type = typeDao.selectTypeByTypeId(typeId);
        good.setType(type);
        return good;
    }


}
