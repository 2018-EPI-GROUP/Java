package com.chanshy.SSM.domain;

public class Item {
    private String id; // 主键，自增长
    private String itemName; // 商品名称
    private double itemPrice; // 商品价格
    private int itemSales; // 商品销量
    private String itemComment; // 商品评价
    private String itemDetail; //商品详情

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemSales() {
        return itemSales;
    }

    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
    }

    public String getItemComment() {
        return itemComment;
    }

    public void setItemComment(String itemComment) {
        this.itemComment = itemComment;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemSales=" + itemSales +
                ", itemComment='" + itemComment + '\'' +
                ", itemDetail='" + itemDetail + '\'' +
                '}';
    }
}
