package org.novity.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.novity.exception.InvalidThrowException;
import org.novity.model.Throw;

import static org.junit.jupiter.api.Assertions.*;

class ThrowCreatorTest {

    ThrowCreator throwCreator;

    @BeforeEach
    void setUp() {
        throwCreator = new ThrowCreator();
    }

    @Test
    void createThrow() throws InvalidThrowException {
        Throw t = throwCreator.createThrow("5");
        assertEquals(5, t.getNbKnockedDownPins());
        assertFalse(t.isSpare());
        assertFalse(t.isStrike());
    }

    @Test
    void createThrow_strike() throws InvalidThrowException {
        Throw t = throwCreator.createThrow("X");
        assertTrue(t.isStrike());
        assertFalse(t.isSpare());
    }

    @Test
    void createThrow_spare() throws InvalidThrowException {
        Throw t = throwCreator.createThrow("/");
        assertTrue(t.isSpare());
        assertFalse(t.isStrike());
    }

    @Test
    void createThrow_notANumber() {
        assertThrows(InvalidThrowException.class, () -> throwCreator.createThrow("a"));
    }
}