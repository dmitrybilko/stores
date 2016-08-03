package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Banana extends AbstractProduct {

    public Banana() {
        super(Banana.class.getSimpleName(), 26.50f, Status.AVAILABLE);
    }
}
