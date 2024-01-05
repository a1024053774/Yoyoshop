package com.lanou.yoyoshop.service;

import com.lanou.yoyoshop.bean.Cart;
import com.lanou.yoyoshop.bean.Goods;

public interface ICartService {
    boolean addToCart(Cart cart, Goods goods);

    boolean lessenFromCart(Cart cart,Integer goodId);
}




