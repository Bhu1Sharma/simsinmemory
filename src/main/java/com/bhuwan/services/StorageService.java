package com.bhuwan.services;

import com.bhuwan.storage.InMemoryStorage;
import com.bhuwan.storage.InMemoryStorageHolder;
import com.bhuwan.storage.MockInMemoryStorage;
import com.bhuwan.storage.MockInMemoryStorageHolder;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class StorageService<E> {

    private Class<E> persistentClass;

    private InMemoryStorage storage;

    private boolean mock;

    private MockInMemoryStorage mockStorage;

    protected StorageService() {
        this(false);
    }

    /**
     * @param mock send true or false to mock or not respectively from child class constructor
     */
    protected StorageService(boolean mock) {
        this.mock = mock;
        persistentClass = (Class<E>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (mock) {
            mockStorage = MockInMemoryStorageHolder.get();
            if (mockStorage == null) {
                mockStorage = MockInMemoryStorage.getInstance();
                MockInMemoryStorageHolder.set(mockStorage);
            }
        } else {
            storage = InMemoryStorageHolder.get();
            if (storage == null) {
                storage = InMemoryStorage.getInstance();
                InMemoryStorageHolder.set(storage);
            }
        }
    }

    protected List<E> getAllForEntity(String entityType) {
        List<Object> list = null;
        if (mock) {
            list = mockStorage.getEntityStorage().get(entityType);
        } else {
            list = storage.getEntityStorage().get(entityType);
        }
        if (list == null) {
            return new ArrayList<>();
        }
        return (List<E>) list;
    }

    protected void updateEntityWithValues(String entityType, List<E> values) {
        if (mock) {
            mockStorage.getEntityStorage().put(entityType, (List<Object>) values);
        } else {
            storage.getEntityStorage().put(entityType, (List<Object>) values);
        }
    }

}
