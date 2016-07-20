package com.bilko.stores;

import java.util.Arrays;

class Vegetables extends AbstractCategory {

    Vegetables() {
        super(Arrays.asList(new Tomato(), new Cucumber(), new Pepper()));
    }
}
