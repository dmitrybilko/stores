/**
 * STORES by DMITRY BILKO.
 */

package com.bilko.stores.converter.impl;

import java.util.List;
import java.util.logging.Logger;

import org.bson.Document;

import com.bilko.stores.converter.AbstractDocumentConverter;
import com.bilko.stores.converter.DocumentConverter;
import com.bilko.stores.factory.ModelFactory;
import com.bilko.stores.factory.impl.CategoryFactory;
import com.bilko.stores.model.Category;
import com.bilko.stores.model.Product;

import static com.bilko.stores.util.Constants.MONGO_DB_CATEGORY_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_PRODUCTS_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_TITLE_FIELD;

/**
 * {@link DocumentConverter} implementation is required to manage {@link Category} conversion.
 *
 * @author Dmitry Bilko
 * @see Category
 * @see DocumentConverter
 * @since 1.0
 */
public class CategoryDocumentConverter extends AbstractDocumentConverter<Category> {

    /**
     * Default logger for {@code CategoryDocumentConverter} class.
     */
    private static final Logger LOG = Logger.getLogger(CategoryDocumentConverter.class.getSimpleName());

    /**
     * {@link DocumentConverter} implementation to convert {@link Product}.
     */
    private ProductDocumentConverter productConverter;

    /**
     * {@link ModelFactory} implementation to obtain {@link Category} instance.
     */
    private CategoryFactory categoryFactory;

    /**
     * Constructor for {@code CategoryDocumentConverter}. Instantiate {@link ProductDocumentConverter} and
     * {@link CategoryFactory}.
     */
    public CategoryDocumentConverter() {
        productConverter = new ProductDocumentConverter();
        categoryFactory = new CategoryFactory();
    }

    @Override
    public final Document toDocument(final Category category) {
        return new Document(MONGO_DB_CATEGORY_FIELD, new Document()
            .append(MONGO_DB_TITLE_FIELD, category.getTitle())
            .append(MONGO_DB_PRODUCTS_FIELD, productConverter.toDocuments(category.getProducts())));
    }

    @Override
    public final Category toModel(final Document document) {
        final Document categoryDocument = document.get(MONGO_DB_CATEGORY_FIELD, Document.class);
        final Category category = categoryFactory.get(categoryDocument.get(MONGO_DB_TITLE_FIELD, String.class));
        if (category != null) {
            //noinspection unchecked
            category
                .setProducts(productConverter.toModels((List<Document>) categoryDocument.get(MONGO_DB_PRODUCTS_FIELD)));
        } else {
            LOG.warning("THERE IS NO CATEGORY TO SET PRODUCTS");
        }
        return category;
    }
}
