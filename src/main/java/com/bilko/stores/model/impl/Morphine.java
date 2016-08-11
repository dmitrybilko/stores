package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Morphine extends AbstractProduct {

    public static final String TAG = Morphine.class.getSimpleName();

    public Morphine() {
        super(TAG, Painkillers.class.getSimpleName(), "358.23", Status.AVAILABLE);
    }
}
