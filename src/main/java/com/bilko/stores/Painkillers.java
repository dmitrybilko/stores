package com.bilko.stores;

import java.util.Arrays;

class Painkillers extends AbstractCategory {

    Painkillers() {
        super(Arrays.asList(new Vicodin(), new Morphine(), new Ketamine()));
    }
}
