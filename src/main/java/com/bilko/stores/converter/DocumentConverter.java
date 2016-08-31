package com.bilko.stores.converter;

import java.util.List;

import org.bson.Document;

/**
 * Class {@code DocumentConverter} provides possibility to convert specific model class to {@link Document} and vice
 * verse.
 *
 * @param <T> type of model class to be handled for conversion
 *
 * @author Dmitry Bilko
 * @see Document
 * @since 1.0
 */
public interface DocumentConverter<T> {

    /**
     * Converts specified model class to {@link Document}.
     * @param model class to be converted
     * @return {@link Document} based on given model class
     */
    Document toDocument(T model);

    /**
     * Converts list of specified model classes to list of {@link Document}s.
     * @param models list to be converted
     * @return list of {@link Document} based on list of specified model classes
     */
    List<Document> toDocuments(List<T> models);

    /**
     * Converts specified model class to {@link Document}.
     * @param document to be converted
     * @return specified model class based on given {@link Document}
     */
    T toModel(Document document);

    /**
     * Converts list of {@link Document}s to list of specified model classes.
     * @param documents list to be converted
     * @return list of specified model classes based on given list of {@link Document}s
     */
    List<T> toModels(List<Document> documents);
}
