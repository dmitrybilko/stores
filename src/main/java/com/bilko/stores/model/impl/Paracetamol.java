package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Paracetamol extends AbstractProduct {

    public static final String TAG = Paracetamol.class.getSimpleName();

    public Paracetamol() {
        super(TAG, Antipyretics.class.getSimpleName(), "8.19", Status.AVAILABLE);
    }
}
