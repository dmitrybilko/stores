package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Aspirin extends AbstractProduct {

    public static final String TAG = Aspirin.class.getSimpleName();

    public Aspirin() {
        super(TAG, Antipyretics.class.getSimpleName(), "232.44", Status.AVAILABLE);
    }
}
