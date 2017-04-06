package org.ivanina.dev.shdt.lambda.base;

import java.util.IllegalFormatException;

public interface Lambda1BaseAsArg<T> {
    T fun(T t) throws IllegalFormatException;
}
