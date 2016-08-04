package com.bilko.stores.model;

public abstract class AbstractProduct implements Product {

    private String title;
    private String type;
    private float price;
    private String status;

    public AbstractProduct(final String title, final String type, final float price, final Status status) {
        this.title = title;
        this.type = type;
        this.price = price;
        this.status = status.toString();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice(final float price) {
        this.price = price;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(final Status status) {
        this.status = status.toString();
    }
}
