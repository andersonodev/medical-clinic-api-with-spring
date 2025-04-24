package dev.anderson.med.voll.api.controller;

import org.junit.jupiter.api.Test;

import dev.anderson.med.voll.api.controller.HelloController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {

    @Test
    public void testHello() {
        assertEquals("Hello, World!", new HelloController().hello());
    }
}