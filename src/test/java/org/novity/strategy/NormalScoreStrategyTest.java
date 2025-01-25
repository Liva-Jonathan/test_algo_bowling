package org.novity.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.novity.model.Frame;
import org.novity.model.Throw;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NormalScoreStrategyTest {

    private NormalScoreStrategy normalScoreStrategy;

    @BeforeEach
    void setUp() {
        normalScoreStrategy = new NormalScoreStrategy();
    }

    @Test
    void calculateScore() {
        List<Throw> throwList = Arrays.asList(
                new Throw(3, false, false),
                new Throw(5, false, false),
                new Throw(1, false, false)
        );
        Frame frame = new Frame(throwList);

        assertEquals(9, normalScoreStrategy.calculateScore(frame));
    }
}