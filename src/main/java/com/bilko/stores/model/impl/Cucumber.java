package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;

public class Cucumber extends AbstractProduct {

    public Cucumber() {
        super(Cucumber.class.getSimpleName(), 17f, Status.AVAILABLE);
    }
}
