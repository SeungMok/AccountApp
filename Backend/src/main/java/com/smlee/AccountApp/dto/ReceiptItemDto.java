package com.smlee.AccountApp.dto;

public class ReceiptItemDto {

    public ReceiptItemDto() {}

    public ReceiptItemDto(long _id, String _name, double _price, int _quantity, String _categoryName) {
        this.id = _id;
        this.name = _name;
        this.price = _price;
        this.quantity = _quantity;
        this.categoryName = _categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long _id) {
        this.id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double _price) {
        this.price = _price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int _quantity) {
        this.quantity = _quantity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String _categoryName) {
        this.categoryName = _categoryName;
    }

    private long id;
    private String name;
    private double price;
    private int quantity;
    private String categoryName;
}
