package com.bilko.stores.factory;

public interface Factory<T> {

    T get(String type);
}
