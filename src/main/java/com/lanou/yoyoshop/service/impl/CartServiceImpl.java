package com.lanou.yoyoshop.service.impl;

import com.lanou.yoyoshop.bean.Cart;
import com.lanou.yoyoshop.bean.Goods;
import com.lanou.yoyoshop.bean.Item;
import com.lanou.yoyoshop.service.ICartService;
import java.util.List;

public class CartServiceImpl implements ICartService {
    @Override
    public boolean addToCart(Cart cart, Goods goods) {
        //
        if (goods.getStock() <= 0){
            return false;
        }
        //1.先检查商品是否存在购物车，若存在，则让商品的购买项数量+1，购物车总件数+1
        List<Item> itemList = cart.getItemList();
        boolean isExist = false;
        for (Item item : itemList){
            //通过商品id对比，发现如果列表中已存在
            if (item.getGoodId().equals(goods.getId())){
                if (item.getAmount() >= goods.getStock()){
                    return false;
                }
                item.setAmount(item.getAmount() + 1);
                cart.setAmount(cart.getAmount() + 1);
                cart.setTotal(cart.getTotal() + item.getPrice());
                isExist = true;
                break;
            }
        }


        //如果不存在

        if (!isExist){
            Item item = new Item();
            item.setPrice(goods.getPrice());
            item.setAmount(1);
            item.setGoods(goods);
            item.setGoodId(goods.getId());

            itemList.add(item);
            cart.setAmount(cart.getAmount() + 1);
            cart.setTotal(cart.getTotal() + goods.getPrice());

        }

        return true;
    }

    @Override
    public boolean lessenFromCart(Cart cart, Integer goodId) {
        List<Item> itemList = cart.getItemList();
        for(Item item : itemList){
            if(item.getGoodId().equals(goodId)){
                item.setAmount(item.getAmount() - 1);
                cart.setAmount(cart.getAmount() - 1);
                cart.setTotal(cart.getTotal() - item.getPrice());
                if(item.getAmount() == 0){
                    itemList.remove(item);
                }
                break;
            }
        }
        if(itemList.isEmpty()){
            return true;
        }
            return false;

    }
}
