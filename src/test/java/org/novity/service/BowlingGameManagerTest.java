package org.novity.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.novity.checker.SpareFrameTypeChecker;
import org.novity.checker.StrikeFrameTypeChecker;
import org.novity.exception.BowlingGameException;
import org.novity.factory.BowlingGameCreator;
import org.novity.model.BowlingGame;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameManagerTest {

    BowlingGameManager bowlingGameManager;
    BowlingGameCreator bowlingGameCreator;

    @BeforeEach
    void setUp() {
        bowlingGameManager = new BowlingGameManager(new StrikeFrameTypeChecker(), new SpareFrameTypeChecker());
        bowlingGameCreator = new BowlingGameCreator();
    }

    @Test
    void calculateScores_fullStrike() throws BowlingGameException {
        BowlingGame bowlingGame = bowlingGameCreator.createBowlingGame("X X X X X,X,X,X");
        List<Integer> scores = bowlingGameManager.calculateScores(bowlingGame);
        assertEquals(300, scores.stream().mapToInt(Integer::intValue).sum());
    }

    @Test
    void calculateScores_strikeSpareLastFrame() throws BowlingGameException {
        BowlingGame bowlingGame = bowlingGameCreator.createBowlingGame("2,5,3 10,2,2 X 8,/ 7,/,X,5");
        List<Integer> scores = bowlingGameManager.calculateScores(bowlingGame);
        assertEquals(5, scores.size());
        assertEquals(Arrays.asList(10,14,37,30,35), scores);
    }

    @Test
    void calculateScores_normal() throws BowlingGameException {
        BowlingGame bowlingGame = bowlingGameCreator.createBowlingGame("X 8,1,2 1,2,/ 6,4,- X,8,2,3");
        List<Integer> scores = bowlingGameManager.calculateScores(bowlingGame);
        assertEquals(5, scores.size());
        assertEquals(Arrays.asList(26,11,25,10,28), scores);
    }
}