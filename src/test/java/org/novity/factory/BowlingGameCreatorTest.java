package org.novity.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.novity.exception.BowlingGameException;
import org.novity.model.BowlingGame;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameCreatorTest {

    BowlingGameCreator bowlingGameCreator;

    @BeforeEach
    void setUp() {
        bowlingGameCreator = new BowlingGameCreator();
    }

    @Test
    void createBowlingGame() throws BowlingGameException {
        BowlingGame bowlingGame = bowlingGameCreator.createBowlingGame("X 2,/ X X X,-,-,-");
        assertEquals(5, bowlingGame.getFrames().size());
        assertEquals(13, bowlingGame.getFrames().get(1).getFrameThrows().get(1).getNbKnockedDownPins());
    }

    @Test
    void createBowlingGame_outOfRange() {
        assertThrows(BowlingGameException.class, () -> bowlingGameCreator.createBowlingGame("X 2,/ X X X X,-,-,-"));
    }
}