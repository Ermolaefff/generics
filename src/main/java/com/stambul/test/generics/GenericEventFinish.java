package com.stambul.test.generics;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class GenericEventFinish<T> implements ResolvableTypeProvider {
    private final Class<T> type;

    public GenericEventFinish(Class<T> type) {
        this.type = type;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(
                getClass(), ResolvableType.forClass(type)
        );
    }
}