package com.bilko.stores;

class Banana extends AbstractProduct {

    Banana() {
        super(Banana.class.getSimpleName(), 26.50f, Status.AVAILABLE);
    }
}
