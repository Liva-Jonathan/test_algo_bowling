package org.novity.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.novity.model.Frame;
import org.novity.model.Throw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StrikeScoreStrategyTest {

    private StrikeScoreStrategy strikeScoreStrategy;

    @BeforeEach
    void setUp() {
        strikeScoreStrategy = new StrikeScoreStrategy();
    }

    @Test
    void calculateScore() {
        Frame frame = new Frame(Collections.singletonList(
                new Throw(15, true, false)
        ));
        Frame nextFrame = new Frame(Arrays.asList(
                new Throw(4, false, false),
                new Throw(2, false, false),
                new Throw(6, false, false)
        ));
        frame.setNextFrame(nextFrame);

        assertEquals(27, strikeScoreStrategy.calculateScore(frame));
    }

    @Test
    void calculateScore_nextFrameIsSpare() {
        Frame frame1 = new Frame(Collections.singletonList(
                new Throw(15, true, false)
        ));
        Frame frame2 = new Frame(Arrays.asList(
                new Throw(2, false, false),
                new Throw(13, false, true)
        ));
        Frame frame3 = new Frame(Arrays.asList(
                new Throw(4, false, false),
                new Throw(2, false, false),
                new Throw(3, false, false)
        ));
        frame1.setNextFrame(frame2);
        frame2.setNextFrame(frame3);

        assertEquals(34, strikeScoreStrategy.calculateScore(frame1));
    }

    @Test
    void calculateScore_nextFrameIsStrike() {
        Frame frame1 = new Frame(Collections.singletonList(
                new Throw(15, true, false)
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

        assertEquals(36, strikeScoreStrategy.calculateScore(frame1));
    }

    @Test
    void calculateScore_2nextFrameIsStrike() {
        Frame frame1 = new Frame(Collections.singletonList(
                new Throw(15, true, false)
        ));
        Frame frame2 = new Frame(Collections.singletonList(
                new Throw(15, true, false)
        ));
        Frame frame3 = new Frame(Collections.singletonList(
                new Throw(15, true, false)
        ));
        Frame frame4 = new Frame(Arrays.asList(
                new Throw(4, false, false),
                new Throw(2, false, false),
                new Throw(3, false, false)
        ));
        frame1.setNextFrame(frame2);
        frame2.setNextFrame(frame3);
        frame3.setNextFrame(frame4);

        assertEquals(49, strikeScoreStrategy.calculateScore(frame1));
    }

}