package com.bilko.stores.factory.impl;

import java.util.logging.Logger;

import com.bilko.stores.factory.Factory;
import com.bilko.stores.model.Product;
import com.bilko.stores.model.impl.Apple;
import com.bilko.stores.model.impl.Aspirin;
import com.bilko.stores.model.impl.Banana;
import com.bilko.stores.model.impl.Cucumber;
import com.bilko.stores.model.impl.Ibuprofen;
import com.bilko.stores.model.impl.Ketamine;
import com.bilko.stores.model.impl.Morphine;
import com.bilko.stores.model.impl.Paracetamol;
import com.bilko.stores.model.impl.Pear;
import com.bilko.stores.model.impl.Pepper;
import com.bilko.stores.model.impl.Tomato;
import com.bilko.stores.model.impl.Vicodin;

public class ProductFactory implements Factory<Product> {

    private static final Logger LOG = Logger.getLogger(ProductFactory.class.getSimpleName());

    @Override
    public Product get(final String title) {
        if (title.equals(Apple.TAG)) {
            return new Apple();
        } else if (title.equals(Aspirin.TAG)) {
            return new Aspirin();
        } else if (title.equals(Banana.TAG)) {
            return new Banana();
        } else if (title.equals(Cucumber.TAG)) {
            return new Cucumber();
        } else if (title.equals(Ibuprofen.TAG)) {
            return new Ibuprofen();
        } else if (title.equals(Ketamine.TAG)) {
            return new Ketamine();
        } else if (title.equals(Morphine.TAG)) {
            return new Morphine();
        } else if (title.equals(Paracetamol.TAG)) {
            return new Paracetamol();
        } else if (title.equals(Pear.TAG)) {
            return new Pear();
        } else if (title.equals(Pepper.TAG)) {
            return new Pepper();
        } else if (title.equals(Tomato.TAG)) {
            return new Tomato();
        } else if (title.equals(Vicodin.TAG)) {
            return new Vicodin();
        } else {
            LOG.warning("INCOMPATIBLE PRODUCT TYPE: " + title);
            return null;
        }
    }
}
