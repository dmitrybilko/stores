package com.bilko.stores;

import java.util.Arrays;

class Fruits extends AbstractCategory {

    Fruits() {
        super(Arrays.asList(new Banana(), new Apple(), new Pear()));
    }
}
