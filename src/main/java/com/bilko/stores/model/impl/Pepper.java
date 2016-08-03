package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Pepper extends AbstractProduct {

    public Pepper() {
        super(Pepper.class.getSimpleName(), 60f, Status.AVAILABLE);
    }
}
