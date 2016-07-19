package com.bilko.stores;

abstract class AbstractProduct implements Product {

    private String title;
    private float price;
    private String status;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
