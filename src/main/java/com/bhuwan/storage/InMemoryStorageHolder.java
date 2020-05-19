package com.bhuwan.storage;

public class InMemoryStorageHolder {

    private static final ThreadLocal<InMemoryStorage> tLocal = new ThreadLocal<>();

    public static void set(InMemoryStorage securityContext) {
        tLocal.set(securityContext);
    }

    public static InMemoryStorage get() {
        return tLocal.get();
    }

    public static void remove() {
        tLocal.remove();
    }

}
