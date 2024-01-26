package com.stambul.test.generics;

import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class GenericEventStart<T> implements ResolvableTypeProvider {
    private final Class<T> type;

    public GenericEventStart(Class<T> type) {
        this.type = type;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(
                getClass(), ResolvableType.forClass(type)
        );
    }
}



