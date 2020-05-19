package com.bhuwan.services;

import com.bhuwan.storage.InMemoryStorage;
import com.bhuwan.storage.InMemoryStorageHolder;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class StorageService<E> {

    private Class<E> persistentClass;

    private InMemoryStorage storage;

    protected StorageService() {
        persistentClass = (Class<E>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        storage = InMemoryStorageHolder.get();
        if (storage == null) {
            storage = InMemoryStorage.getInstance();
        }
    }

    protected List<E> getAllForEntity(String entityType) {
//        return storage.getEntityStorage().get(entityType)
//                .stream()
//                .map(value -> persistentClass.cast(value))
//                .collect(Collectors.toList());
        return (List<E>) storage.getEntityStorage().get(entityType);
    }

    protected void updateEntityWithValues(String entityType, List<E> values) {
        storage.getEntityStorage().put(entityType, (List<Object>) values);
    }

}
