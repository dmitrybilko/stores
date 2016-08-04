package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Morphine extends AbstractProduct {

    public Morphine() {
        super(Morphine.class.getSimpleName(), Painkillers.class.getSimpleName(), 358.23f, Status.AVAILABLE);
    }
}
