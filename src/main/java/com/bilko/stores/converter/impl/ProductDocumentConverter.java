package com.bilko.stores.converter.impl;

import java.util.logging.Logger;

import org.bson.Document;

import com.bilko.stores.converter.AbstractDocumentConverter;
import com.bilko.stores.converter.DocumentConverter;
import com.bilko.stores.factory.ModelFactory;
import com.bilko.stores.factory.impl.ProductFactory;
import com.bilko.stores.model.Product;
import com.bilko.stores.model.Product.Status;

import static com.bilko.stores.util.Constants.MONGO_DB_PRICE_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_PRODUCT_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_STATUS_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_TITLE_FIELD;

/**
 * {@link DocumentConverter} implementation is required to manage {@link Product} conversion.
 *
 * @author Dmitry Bilko
 * @see DocumentConverter
 * @see Product
 * @since 1.0
 */
public class ProductDocumentConverter extends AbstractDocumentConverter<Product> {

    /**
     * Default logger for {@code ProductDocumentConverter} class.
     */
    private static final Logger LOG = Logger.getLogger(ProductDocumentConverter.class.getSimpleName());

    /**
     * {@link ModelFactory} implementation to obtain {@link Product} instance.
     */
    private ProductFactory productFactory;

    /**
     * Constructor for {@code ProductDocumentConverter}. Instantiate {@link ProductFactory}.
     */
    public ProductDocumentConverter() {
        productFactory = new ProductFactory();
    }

    @Override
    public final Document toDocument(final Product product) {
        return new Document(MONGO_DB_PRODUCT_FIELD, new Document()
            .append(MONGO_DB_TITLE_FIELD, product.getTitle())
            .append(MONGO_DB_PRICE_FIELD, product.getPrice())
            .append(MONGO_DB_STATUS_FIELD, product.getStatus()));
    }

    @Override
    public final Product toModel(final Document document) {
        final Document productDocument = document.get(MONGO_DB_PRODUCT_FIELD, Document.class);
        final Product product = productFactory.get(productDocument.get(MONGO_DB_TITLE_FIELD, String.class));
        if (product != null) {
            product.setPrice(productDocument.get(MONGO_DB_PRICE_FIELD, String.class));
            product.setStatus(toStatus(productDocument));
        } else {
            LOG.warning("THERE IS NO PRODUCT TO SET PRICE AND STATUS");
        }
        return product;
    }

    /**
     * Returns {@link Status} received from given {@link Document}.
     * @param document from which {@link Status} to be taken
     * @return {@link Product}'s {@link Status}
     */
    private Status toStatus(final Document document) {
        final String status = document.get(MONGO_DB_STATUS_FIELD, String.class);
        if (status.equals(Status.ABSENT.toString())) {
            return Status.ABSENT;
        } else if (status.equals(Status.EXPECTED.toString())) {
            return Status.EXPECTED;
        } else {
            return Status.AVAILABLE;
        }
    }
}
