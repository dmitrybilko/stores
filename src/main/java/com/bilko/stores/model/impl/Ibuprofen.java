package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Ibuprofen extends AbstractProduct {

    public static final String TAG = Ibuprofen.class.getSimpleName();

    public Ibuprofen() {
        super(TAG, Antipyretics.class.getSimpleName(), "232.94", Status.AVAILABLE);
    }
}
