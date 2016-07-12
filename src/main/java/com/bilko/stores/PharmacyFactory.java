package com.bilko.stores;

class PharmacyFactory implements StoreFactory {

    @Override
    public Store getStore() {
        return Pharmacy.getInstance();
    }
}
