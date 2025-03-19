package com.baond;

/**
 * Created by BaoND on 2025-03-19
 */
public class Bank {

    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency);
    }
}
