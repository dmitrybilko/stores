package com.bilko.stores;

import java.util.Arrays;

class Antipyretics extends AbstractCategory {

    Antipyretics() {
        super(Arrays.asList(new Paracetamol(), new Ibuprofen(), new Aspirin()));
    }
}
