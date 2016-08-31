package com.bilko.stores.model;

/**
 * Class {@code Product} specifies appropriate entity which can be in one of statuses defined in {@code Status}
 * enumeration.
 *
 * @author Dmitry Bilko
 * @see Store
 * @see Category
 * @since 1.0
 */
public interface Product {

    /**
     * Enumeration of possible {@code Product} statuses.
     */
    enum Status {

        /**
         * Available status.
         */
        AVAILABLE("Available"),

        /**
         * Absent status.
         */
        ABSENT("Absent"),

        /**
         * Expected status.
         */
        EXPECTED("Expected");

        /**
         * String value of current {@code Status} element.
         */
        private final String value;

        /**
         * Constructor for {@code Status} enumeration.
         * @param status of {@code Product} as string
         */
        Status(final String status) {
            this.value = status;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Returns title of considered {@code Product} instance.
     * @return title as string
     */
    String getTitle();

    /**
     * Returns title of {@link Category} related to considered {@code Product} instance.
     * @return title of {@link Category} as string
     */
    String getType();

    /**
     * Returns price of considered {@code Product} instance.
     * @return price as string
     */
    String getPrice();

    /**
     * Sets given price of considered {@link Product} instance.
     * @param price of {@link Product} to be set
     */
    void setPrice(final String price);

    /**
     * Returns {@code Status} of considered {@code Product} instance.
     * @return {@code Status} as string
     */
    String getStatus();

    /**
     * Sets given {@code Status} of considered {@link Product} instance.
     * @param status of {@link Product} to be set
     */
    void setStatus(final Status status);
}
