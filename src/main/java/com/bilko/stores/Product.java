package com.bilko.stores;

class Product {

    private enum Status {

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

    private String title;
    private float price;
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(final float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status.toString();
    }
}
