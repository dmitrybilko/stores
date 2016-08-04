package com.bilko.stores.model;

public interface Product {

    enum Status {

        AVAILABLE("Available"),
        ABSENT("Absent"),
        EXPECTED("Expected");

        private final String value;

        Status(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    String getTitle();

    String getType();

    float getPrice();

    void setPrice(final float price);

    String getStatus();

    void setStatus(final Status status);
}
