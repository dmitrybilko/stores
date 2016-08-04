package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Aspirin extends AbstractProduct {

    public Aspirin() {
        super(Aspirin.class.getSimpleName(), Antipyretics.class.getSimpleName(), 232.44f, Status.AVAILABLE);
    }
}
