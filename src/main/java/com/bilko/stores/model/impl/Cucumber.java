package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Cucumber extends AbstractProduct {

    public static final String TAG = Cucumber.class.getSimpleName();

    public Cucumber() {
        super(TAG, Vegetables.class.getSimpleName(), "17", Status.AVAILABLE);
    }
}
