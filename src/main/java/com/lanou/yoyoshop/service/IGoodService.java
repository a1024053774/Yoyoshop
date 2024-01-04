package com.lanou.yoyoshop.service;

import com.lanou.yoyoshop.bean.Goods;

import java.util.List;

public interface IGoodService {
    /**
     * 根据不同的topTypeId获得首页商品列表(首页1代表精品推荐，2代表热销推荐，3代表新品推荐)
     * @param topTypeId
     * @return
     */
    List<Goods> getGoodsListByTopTypeId(Integer topTypeId);


    /**
     * 根据不同的topTypeId分页查询获得首页商品列表(2代表热销推荐，3代表新品推荐)
     * @param topTypeId
     * @param page
     * @param size
     * @return
     */
    List<Goods> getGoodsListByTopTypeIdPageQuery(Integer topTypeId, int page, int size);

    List<Goods> getGoodsListByTypeId(Integer typeId);

    /**
     * 根据商品类型Id分页查询获得该类型下所有的商品
     * @param typeId
     * @param page
     * @param size
     * @return
     */
    List<Goods> getGoodsListByTypeIdPageQuery(Integer typeId,int page,int size);

    /**
     * 根据typeId 获得该类型下的商品总数
     * @param typeId
     * @return
     */
    Long getGoodsCountByTypeId(Integer typeId);

    /**
     * 获取热销或者新品的商品总数
     * @param topTypeId
     * @return
     */

    Long getGoodsCountByTopTypeId(Integer topTypeId);

    /**
     * 根据关键词获得商品列表
     * @param keyword
     * @return
     */
    List<Goods> getGoodsListByKeywordPageQuery(String keyword, int page, int size);


    /**
     * 获取通过关键字搜索的商品总数
     * @param keyword
     * @return
     */
    Long getGoodsCountByKeyWord(String keyword);

    /**
     * 根据商品Id获取商品对象
     * @param goodId
     * @return
     */
    Goods getGoodsByGoodsId(Integer goodId);


}
