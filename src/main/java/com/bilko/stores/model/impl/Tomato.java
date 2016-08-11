package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Tomato extends AbstractProduct {

    public static final String TAG = Tomato.class.getSimpleName();

    public Tomato() {
        super(TAG, Vegetables.class.getSimpleName(), "30.95", Status.AVAILABLE);
    }
}
