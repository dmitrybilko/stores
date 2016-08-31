package com.bilko.stores.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;

/**
 * Class {@code AbstractDocumentConverter} provides abstract implementation of {@link DocumentConverter}. This class
 * can be extended to implement {@link DocumentConverter#toDocument(Object)} and
 * {@link DocumentConverter#toModel(Document)} methods.
 *
 * @param <T> type of model class to be handled for conversion
 *
 * @author Dmitry Bilko
 * @see Document
 * @see DocumentConverter
 * @since 1.0
 */
public abstract class AbstractDocumentConverter<T> implements DocumentConverter<T> {

    @Override
    public final List<Document> toDocuments(final List<T> models) {
        return models
            .stream()
            .map(this::toDocument)
            .collect(Collectors.toList());
    }

    @Override
    public final List<T> toModels(final List<Document> documents) {
        return documents
            .stream()
            .map(this::toModel)
            .collect(Collectors.toList());
    }
}
