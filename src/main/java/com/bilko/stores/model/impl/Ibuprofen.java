package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Ibuprofen extends AbstractProduct {

    public Ibuprofen() {
        super(Ibuprofen.class.getSimpleName(), Antipyretics.class.getSimpleName(), 232.94f, Status.AVAILABLE);
    }
}
