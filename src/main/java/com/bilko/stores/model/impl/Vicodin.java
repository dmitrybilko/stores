package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Vicodin extends AbstractProduct {

    public Vicodin() {
        super(Vicodin.class.getSimpleName(), Painkillers.class.getSimpleName(), 340.58f, Status.AVAILABLE);
    }
}
