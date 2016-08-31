package com.bilko.stores.converter.impl;

import java.util.List;
import java.util.logging.Logger;

import org.bson.Document;

import com.bilko.stores.converter.AbstractDocumentConverter;
import com.bilko.stores.converter.DocumentConverter;
import com.bilko.stores.factory.ModelFactory;
import com.bilko.stores.factory.impl.StoreFactory;
import com.bilko.stores.model.Category;
import com.bilko.stores.model.Store;

import static com.bilko.stores.util.Constants.MONGO_DB_CATEGORIES_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_ID_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_TITLE_FIELD;

/**
 * {@link DocumentConverter} implementation is required to manage {@link Store} conversion.
 *
 * @author Dmitry Bilko
 * @see DocumentConverter
 * @see Store
 * @since 1.0
 */
public class StoreDocumentConverter extends AbstractDocumentConverter<Store> {

    /**
     * Default logger for {@code StoreDocumentConverter} class.
     */
    private static final Logger LOG = Logger.getLogger(StoreDocumentConverter.class.getSimpleName());

    /**
     * {@link DocumentConverter} implementation to convert {@link Category}.
     */
    private CategoryDocumentConverter categoryConverter;

    /**
     * {@link ModelFactory} implementation to obtain {@link Store} instance.
     */
    private StoreFactory storeFactory;

    /**
     * Constructor for {@code CategoryDocumentConverter}. Instantiate {@link ProductDocumentConverter} and
     * {@link StoreFactory}.
     */
    public StoreDocumentConverter() {
        categoryConverter = new CategoryDocumentConverter();
        storeFactory = new StoreFactory();
    }

    @Override
    public final Document toDocument(final Store store) {
        return new Document()
            .append(MONGO_DB_ID_FIELD, store.getId())
            .append(MONGO_DB_TITLE_FIELD, store.getTitle())
            .append(MONGO_DB_CATEGORIES_FIELD, categoryConverter.toDocuments(store.getCategories()));
    }

    @Override
    public final Store toModel(final Document document) {
        final Store store = storeFactory.get(document.get(MONGO_DB_TITLE_FIELD, String.class));
        if (store != null) {
            //noinspection unchecked
            store.setCategories(categoryConverter.toModels((List<Document>) document.get(MONGO_DB_CATEGORIES_FIELD)));
        } else {
            LOG.warning("THERE IS NO STORE TO SET CATEGORIES");
        }
        return store;
    }
}
