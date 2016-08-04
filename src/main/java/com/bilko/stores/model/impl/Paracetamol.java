package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Paracetamol extends AbstractProduct {

    public Paracetamol() {
        super(Paracetamol.class.getSimpleName(), Antipyretics.class.getSimpleName(), 8.19f, Status.AVAILABLE);
    }
}
