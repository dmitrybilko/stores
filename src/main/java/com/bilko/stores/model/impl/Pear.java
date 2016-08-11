package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Pear extends AbstractProduct {

    public static final String TAG = Pear.class.getSimpleName();

    public Pear() {
        super(TAG, Fruits.class.getSimpleName(), "64.49", Status.AVAILABLE);
    }
}
