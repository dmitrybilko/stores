package com.bilko.stores.converter;

import java.util.List;

import org.bson.Document;

public interface Converter<T> {

    Document toDocument(T model);

    List<Document> toDocuments(List<T> models);

    T toModel(Document document);
}
