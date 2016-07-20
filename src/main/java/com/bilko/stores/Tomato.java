package com.bilko.stores;

class Tomato extends AbstractProduct {

    Tomato() {
        super(Tomato.class.getSimpleName(), 30.95f, Status.AVAILABLE);
    }
}
