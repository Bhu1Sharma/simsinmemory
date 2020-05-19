package com.bhuwan.storage;

import java.util.*;

public class InMemoryStorage {

    private static InMemoryStorage storageInstance;

    private final Map<String, List<Object>> entityStorage;

    private InMemoryStorage() {
        entityStorage = new HashMap<>();
    }

    public static InMemoryStorage getInstance() {
        if (storageInstance == null) {
            storageInstance = new InMemoryStorage();
        }
        return storageInstance;
    }

    public Map<String, List<Object>>  getEntityStorage() {
        return entityStorage;
    }

}
