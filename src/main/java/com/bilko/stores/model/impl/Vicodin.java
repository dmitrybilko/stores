package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Vicodin extends AbstractProduct {

    public static final String TAG = Vicodin.class.getSimpleName();

    public Vicodin() {
        super(TAG, Painkillers.class.getSimpleName(), "340.58", Status.AVAILABLE);
    }
}
