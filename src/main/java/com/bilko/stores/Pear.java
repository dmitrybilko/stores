package com.bilko.stores;

class Pear extends AbstractProduct {

    Pear() {
        super(Pear.class.getSimpleName(), 64.49f, Status.AVAILABLE);
    }
}
