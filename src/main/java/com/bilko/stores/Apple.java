package com.bilko.stores;

class Apple extends AbstractProduct {

    Apple() {
        super(Apple.class.getSimpleName(), 17f, Status.AVAILABLE);
    }
}
