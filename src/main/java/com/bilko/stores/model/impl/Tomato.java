package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Tomato extends AbstractProduct {

    public Tomato() {
        super(Tomato.class.getSimpleName(), 30.95f, Status.AVAILABLE);
    }
}
