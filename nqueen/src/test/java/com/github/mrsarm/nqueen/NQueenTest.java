package com.github.mrsarm.nqueen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NQueenTest {
    @Test public void testGetMessage() {
        assertEquals("Hello from NQueen", NQueen.hello());
    }
}
