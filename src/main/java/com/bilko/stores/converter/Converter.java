package com.bilko.stores.converter;

import java.util.List;

import org.bson.Document;

public interface Converter<T> {

    Document toDocument(final T model);

    List<Document> toDocuments(final List<T> models);
}
