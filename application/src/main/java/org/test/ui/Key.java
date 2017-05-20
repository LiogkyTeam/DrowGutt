package org.test.ui;

class Key<Type> {
    Type key;

    public Key(Type key){
        this.key = key;
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
