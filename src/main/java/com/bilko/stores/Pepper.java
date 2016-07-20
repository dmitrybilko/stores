package com.bilko.stores;

class Pepper extends AbstractProduct {

    Pepper() {
        super(Pepper.class.getSimpleName(), 60f, Status.AVAILABLE);
    }
}
