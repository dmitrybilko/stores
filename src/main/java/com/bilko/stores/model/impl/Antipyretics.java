package com.bilko.stores.model.impl;

import java.util.Arrays;

import com.bilko.stores.model.AbstractCategory;

public class Antipyretics extends AbstractCategory {

    public Antipyretics() {
        super(Antipyretics.class.getSimpleName(), Arrays.asList(new Paracetamol(), new Ibuprofen(), new Aspirin()));
    }
}
