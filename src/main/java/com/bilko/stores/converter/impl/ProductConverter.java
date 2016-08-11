package com.bilko.stores.converter.impl;

import org.bson.Document;

import com.bilko.stores.converter.AbstractConverter;
import com.bilko.stores.factory.impl.ProductFactory;
import com.bilko.stores.model.Product;
import com.bilko.stores.model.Product.Status;

import static com.bilko.stores.util.Constants.MONGO_DB_PRICE_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_PRODUCT_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_STATUS_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_TITLE_FIELD;

public class ProductConverter extends AbstractConverter<Product> {

    private ProductFactory productFactory;

    public ProductConverter() {
        productFactory = new ProductFactory();
    }

    @Override
    public Document toDocument(final Product product) {
        return new Document(MONGO_DB_PRODUCT_FIELD, new Document()
            .append(MONGO_DB_TITLE_FIELD, product.getTitle())
            .append(MONGO_DB_PRICE_FIELD, product.getPrice())
            .append(MONGO_DB_STATUS_FIELD, product.getStatus()));
    }

    @Override
    public Product toModel(final Document document) {
        final Document productDocument = document.get(MONGO_DB_PRODUCT_FIELD, Document.class);
        final Product product = productFactory.get(productDocument.get(MONGO_DB_TITLE_FIELD, String.class));
        product.setPrice(productDocument.get(MONGO_DB_PRICE_FIELD, String.class));
        product.setStatus(toStatus(productDocument));
        return product;
    }

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
