package com.bilko.stores.factory;

/**
 * Class {@code ModelFactory} provides instances of model classes based on given type.
 *
 * @param <T> type of model class to be returned
 *
 * @author Dmitry Bilko
 * @since 1.0
 */
public interface ModelFactory<T> {

    /**
     * Factory method is used to return instance of model class.
     * @param type of model class
     * @return instance of model class based on given type
     */
    T get(String type);
}
