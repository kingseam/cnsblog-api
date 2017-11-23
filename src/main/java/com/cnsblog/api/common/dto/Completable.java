package com.cnsblog.api.common.dto;

public interface Completable<T extends Completable<?>> {
    T getComplete();
}
