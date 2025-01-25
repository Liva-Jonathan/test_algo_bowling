package org.novity.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.novity.model.Frame;
import org.novity.model.Throw;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SpareScoreStrategyTest {

    private SpareScoreStrategy spareScoreStrategy;

    @BeforeEach
    void setUp() {
        spareScoreStrategy = new SpareScoreStrategy();
    }

    @Test
    void calculateScore() {
        Frame frame = new Frame(Arrays.asList(
                new Throw(3, false, false),
                new Throw(0, false, true)
        ));
        Frame nextFrame = new Frame(Arrays.asList(
                new Throw(4, false, false),
                new Throw(2, false, false),
                new Throw(6, false, false)
        ));
        frame.setNextFrame(nextFrame);

        assertEquals(21, spareScoreStrategy.calculateScore(frame));
    }

    @Test
    void calculateScore_nextFrameIsStrike() {
        Frame frame1 = new Frame(Arrays.asList(
                new Throw(5, false, false),
                new Throw(10, false, true)
        ));
        Frame frame2 = new Frame(Collections.singletonList(
                new Throw(15, true, false)
        ));
        Frame frame3 = new Frame(Arrays.asList(
                new Throw(4, false, false),
                new Throw(2, false, false),
                new Throw(3, false, false)
        ));
        frame1.setNextFrame(frame2);
        frame2.setNextFrame(frame3);

        assertEquals(34, spareScoreStrategy.calculateScore(frame1));
    }
}