package com.csnblog.api.common.dto;

public interface Completable<T extends Completable<?>> {
    T getComplete();
}
