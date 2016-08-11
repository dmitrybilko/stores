package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Pepper extends AbstractProduct {

    public static final String TAG = Pepper.class.getSimpleName();

    public Pepper() {
        super(TAG, Vegetables.class.getSimpleName(), "60", Status.AVAILABLE);
    }
}
