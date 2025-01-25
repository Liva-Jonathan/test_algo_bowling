package org.novity.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.novity.exception.BowlingGameException;
import org.novity.exception.InvalidFrameException;
import org.novity.model.Frame;

import static org.junit.jupiter.api.Assertions.*;

class FrameCreatorTest {

    FrameCreator frameCreator;

    @BeforeEach
    void setUp() {
        frameCreator = new FrameCreator();
    }

    @Test
    void createFrame() throws BowlingGameException {
        Frame frame = frameCreator.createFrame("3,10,1", false);
        assertEquals(3, frame.getFrameThrows().size());
        assertEquals(10, frame.getFrameThrows().get(1).getNbKnockedDownPins());
    }

    @Test
    void createFrame_strike() throws BowlingGameException {
        Frame frame = frameCreator.createFrame("X", false);
        assertEquals(1, frame.getFrameThrows().size());
        assertTrue(frame.getFrameThrows().get(0).isStrike());
    }

    @Test
    void createFrame_spare() throws BowlingGameException {
        Frame frame = frameCreator.createFrame("5,3,/", false);
        assertEquals(3, frame.getFrameThrows().size());
        assertTrue(frame.getFrameThrows().get(2).isSpare());
        assertEquals(7, frame.getFrameThrows().get(2).getNbKnockedDownPins());
    }

    @Test
    void createFrame_invalidFrame() {
        assertThrows(InvalidFrameException.class, () -> frameCreator.createFrame("5,X", false));
    }

    @Test
    void createFrame_lastFrame() throws BowlingGameException {
        Frame frame = frameCreator.createFrame("2,5,/,3,4", true);
        assertEquals(3, frame.getFrameThrows().size());
        assertEquals(2, frame.getNextFrame().getFrameThrows().size());
        assertTrue(frame.getFrameThrows().get(2).isSpare());
        assertEquals(8, frame.getFrameThrows().get(2).getNbKnockedDownPins());
    }

    @Test
    void createFrame_lastFrameStrike() throws BowlingGameException {
        Frame frame = frameCreator.createFrame("X,X,X,X", true);
        assertEquals(1, frame.getFrameThrows().size());
        assertEquals(3, frame.getNextFrame().getFrameThrows().size());
        assertEquals(15, frame.getNextFrame().getFrameThrows().get(2).getNbKnockedDownPins());
    }
}