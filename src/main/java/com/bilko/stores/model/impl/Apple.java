package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Apple extends AbstractProduct {

    public Apple() {
        super(Apple.class.getSimpleName(), Fruits.class.getSimpleName(), 17f, Status.AVAILABLE);
    }
}
