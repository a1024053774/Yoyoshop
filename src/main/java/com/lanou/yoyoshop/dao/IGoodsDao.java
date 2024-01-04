package com.lanou.yoyoshop.dao;

import com.lanou.yoyoshop.bean.Goods;

import java.util.List;

public interface IGoodsDao {
    /**
     * 根据不同的topTypeId获得商品列表(1代表精品推荐，2代表热销推荐，3代表新品推荐)
     * @param topTypeId
     * @return
     */
    List<Goods> selectGoodsListByTopTypeId(Integer topTypeId);
    /**
     * 根据不同的topTypeId获得商品列表(2代表热销推荐，3代表新品推荐)
     * @param topTypeId
     * @return
     */
    List<Goods> selectGoodsListByTopTypeIdPageQuery(Integer topTypeId, int page, int size);

    List<Goods> selectGoodsListByTypeId(Integer typeId);

    /**
     * 根据商品类型Id分页查询获得该类型下所有的商品
     * @param typeId
     * @param page
     * @param size
     * @return
     */
    List<Goods> selectGoodsListByTypeIdPageQuery(Integer typeId,int page,int size);

    /**
     * 根据typeId 获得该类型下的商品总数
     * @param typeId
     * @return
     */
    Long selectGoodsCountByTypeId(Integer typeId);

    /**
     * 获取热销或新品商品总数
     * @param topTypeId
     * @return
     */
    Long selectGoodsCountByTopTypeId(Integer topTypeId);
    /**
     * 根据关键词获得商品列表
     * @param keyword
     * @return
     */
    List<Goods> selectGoodsListByKeywordPageQuery(String keyword,int page ,int size);


    /**
     * 通过关键字获取商品总数
     */
    Long selectGoodsCountByKeyword(String keyword);

    /**
     * 根据商品id获得商品对象
     */
    Goods selectGoodsByGoodsId(Integer goodId);
}
