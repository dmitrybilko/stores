package com.bilko.stores;

interface Product {

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

    float getPrice();

    String getStatus();
}
