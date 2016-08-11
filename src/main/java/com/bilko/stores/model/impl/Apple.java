package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Apple extends AbstractProduct {

    public static final String TAG = Apple.class.getSimpleName();

    public Apple() {
        super(TAG, Fruits.class.getSimpleName(), "17", Status.AVAILABLE);
    }
}
