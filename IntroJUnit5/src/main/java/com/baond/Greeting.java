package com.baond;


/**
 * Created by BaoND on 2025-03-19
 */
public class Greeting {

    private static final String HELLO = "Hello";
    private static final String WORLD = "World";

    public String helloWorld() {
        return HELLO + " " + WORLD;
    }

    public String helloWorld(String name) {
        return HELLO + " " + name;
    }

}
