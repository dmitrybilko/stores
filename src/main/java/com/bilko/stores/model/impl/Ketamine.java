package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Ketamine extends AbstractProduct {

    public static final String TAG = Ketamine.class.getSimpleName();

    public Ketamine() {
        super(TAG, Painkillers.class.getSimpleName(), "372.9", Status.AVAILABLE);
    }
}
