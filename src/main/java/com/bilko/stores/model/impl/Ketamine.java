package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Ketamine extends AbstractProduct {

    public Ketamine() {
        super(Ketamine.class.getSimpleName(), Painkillers.class.getSimpleName(), 372.9f, Status.AVAILABLE);
    }
}
