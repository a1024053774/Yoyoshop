package com.lanou.yoyoshop.bean;

import java.util.List;

public class Cart {
    //购物车中商品总价
    private Double total;

    //商品总件数
    private Integer amount;

    //存商品的购买项
    List<Item> itemList;

    @Override
    public String toString() {
        return "Cart{" +
                "total=" + total +
                ", amount=" + amount +
                ", itemList=" + itemList +
                '}';
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
