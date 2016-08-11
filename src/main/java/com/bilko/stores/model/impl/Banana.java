package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Banana extends AbstractProduct {

    public static final String TAG = Banana.class.getSimpleName();

    public Banana() {
        super(TAG, Fruits.class.getSimpleName(), "26.50", Status.AVAILABLE);
    }
}
