package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Pear extends AbstractProduct {

    public Pear() {
        super(Pear.class.getSimpleName(), 64.49f, Status.AVAILABLE);
    }
}
