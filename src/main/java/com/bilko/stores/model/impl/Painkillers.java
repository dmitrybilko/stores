package com.bilko.stores.model.impl;

import java.util.Arrays;

import com.bilko.stores.model.AbstractCategory;

public class Painkillers extends AbstractCategory {

    public Painkillers() {
        super(Painkillers.class.getSimpleName(), Arrays.asList(new Vicodin(), new Morphine(), new Ketamine()));
    }
}
