package com.bilko.stores.model;

/**
 * Class {@code AbstractProduct} provides abstract implementation of {@link Product}. This class can be extended by
 * calling public constructor.
 *
 * @author Dmitry Bilko
 * @see Product
 * @since 1.0
 */
public abstract class AbstractProduct implements Product {

    /**
     * Current {@link Product} instance's title value.
     */
    private String title;

    /**
     * Current {@link Product} instance's type value.
     */
    private String type;

    /**
     * Current {@link Product} instance's price value.
     */
    private String price;

    /**
     * Current {@link Product} instance's status value.
     */
    private String status;

    /**
     * Constructor for {@code AbstractStore}.
     * @param pTitle of {@link Product} to be instantiate
     * @param pType of {@link Product} to be instantiate
     * @param pPrice of {@link Product} to be instantiate
     * @param pStatus of {@link Product} to be instantiate
     */
    public AbstractProduct(final String pTitle, final String pType, final String pPrice, final Status pStatus) {
        this.title = pTitle;
        this.type = pType;
        this.price = pPrice;
        this.status = pStatus.toString();
    }

    @Override
    public final String getTitle() {
        return title;
    }

    @Override
    public final String getType() {
        return type;
    }

    @Override
    public final String getPrice() {
        return price;
    }

    @Override
    public final void setPrice(final String pPrice) {
        this.price = pPrice;
    }

    @Override
    public final String getStatus() {
        return status;
    }

    @Override
    public final void setStatus(final Status pStatus) {
        this.status = pStatus.toString();
    }
}
