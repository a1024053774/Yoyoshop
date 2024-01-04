package com.lanou.yoyoshop.dao.impl;

import com.lanou.yoyoshop.bean.Goods;
import com.lanou.yoyoshop.dao.IGoodsDao;
import com.lanou.yoyoshop.util.DBUtils;

import java.util.List;
import java.util.Map;

public class GoodsDaoImpl implements IGoodsDao {
    @Override
    public List<Goods> selectGoodsListByTopTypeId(Integer topTypeId) {
        List<Goods> goodsList = DBUtils.query("select goods.* from top join goods on goods.id=top.good_id where type=?", Goods.class,topTypeId);
        return goodsList;
    }

    @Override
    public List<Goods> selectGoodsListByTopTypeIdPageQuery(Integer topTypeId, int page, int size) {
        List<Goods> goodsList = DBUtils.query("select goods.* from goods join top on goods.id = top.good_id where type = ? limit ?,?", Goods.class, topTypeId, (page - 1) * size, size);
        return goodsList;
    }

    @Override
    public List<Goods> selectGoodsListByTypeId(Integer typeId) {
        List<Goods> goodsList = DBUtils.query("select * from goods where type_id=?", Goods.class, typeId);
        return goodsList;
    }


    @Override
    public List<Goods> selectGoodsListByTypeIdPageQuery(Integer typeId, int page, int size) {
        List<Goods> goodsList = DBUtils.query("select * from goods where type_id=? limit ?,?", Goods.class, typeId,(page-1)*size,size);
        return goodsList;
    }

    @Override
    public Long selectGoodsCountByTypeId(Integer typeId) {
        Map<String, Object> map = DBUtils.queryOne("select count(*) as count from goods where type_id=?", typeId);
        Long count = (Long) map.get("count");
        return count;
    }

    @Override
    public Long selectGoodsCountByTopTypeId(Integer topTypeId) {
        Map<String, Object> map = DBUtils.queryOne("select count(*) as count from top join goods on top.good_id = goods.id where type = ?", topTypeId);
        Long count = (Long) map.get("count");
        return count;
    }

    @Override
    public List<Goods> selectGoodsListByKeywordPageQuery(String keyword,int page, int size) {
        List<Goods> goodsList = DBUtils.query("select * from goods where name like '%" + keyword + "%' limit ?,?", Goods.class, (page - 1) * size, size);
        return goodsList;
    }

    @Override
    public Long selectGoodsCountByKeyword(String keyword) {
        Map<String, Object> map = DBUtils.queryOne("select count(*) as count from goods where name like '%" + keyword + "%'");
        Long count = (Long) map.get("count");
        return count;
    }

    @Override
    public Goods selectGoodsByGoodsId(Integer goodId) {
        Goods goods = DBUtils.queryOne("select * from goods where id = ?", Goods.class, goodId);
        return goods;
    }


}
