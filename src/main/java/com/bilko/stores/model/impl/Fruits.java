package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractCategory;

import java.util.Arrays;

public class Fruits extends AbstractCategory {

    public Fruits() {
        super(Fruits.class.getSimpleName(), Arrays.asList(new Banana(), new Apple(), new Pear()));
    }
}
