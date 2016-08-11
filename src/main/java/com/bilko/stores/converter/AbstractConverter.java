package com.bilko.stores.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;

public abstract class AbstractConverter<T> implements Converter<T> {

    @Override
    public List<Document> toDocuments(final List<T> models) {
        return models
            .stream()
            .map(this::toDocument)
            .collect(Collectors.toList());
    }

    @Override
    public List<T> toModels(final List<Document> documents) {
        return documents
            .stream()
            .map(this::toModel)
            .collect(Collectors.toList());
    }
}
