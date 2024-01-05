package com.lanou.yoyoshop.service;

import com.lanou.yoyoshop.bean.Cart;
import com.lanou.yoyoshop.bean.Goods;

public interface ICartService {
    /**
     * 添加商品到购物车
     * @param cart
     * @param goods
     * @return
     */
    boolean addToCart(Cart cart, Goods goods);

    /**
     * 从购物车减少商品
     * @param cart
     * @param goodId
     * @return
     */

    boolean lessenFromCart(Cart cart,Integer goodId);

    /**
     * 从购物车删除商品
     * @param cart
     * @param goodId
     * @return
     */
    boolean deleteFromCart(Cart cart,Integer goodId);
}




