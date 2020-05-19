package com.bhuwan.storage;

public class MockInMemoryStorageHolder {

    private static final ThreadLocal<MockInMemoryStorage> tLocal = new ThreadLocal<>();

    public static void set(MockInMemoryStorage securityContext) {
        tLocal.set(securityContext);
    }

    public static MockInMemoryStorage get() {
        return tLocal.get();
    }

    public static void remove() {
        tLocal.remove();
    }

}
