package com.bilko.stores.model.impl;

import java.util.Arrays;

import com.bilko.stores.model.AbstractCategory;

public class Vegetables extends AbstractCategory {

    public Vegetables() {
        super(Vegetables.class.getSimpleName(), Arrays.asList(new Tomato(), new Cucumber(), new Pepper()));
    }
}
