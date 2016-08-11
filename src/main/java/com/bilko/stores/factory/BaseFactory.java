package com.bilko.stores.factory;

public interface BaseFactory<T> {

    T get(String type);
}
