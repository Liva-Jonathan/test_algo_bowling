package org.novity.service;

import org.novity.checker.FrameTypeChecker;
import org.novity.model.BowlingGame;
import org.novity.model.Frame;
import org.novity.strategy.NormalScoreStrategy;
import org.novity.strategy.SpareScoreStrategy;
import org.novity.strategy.StrikeScoreStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class BowlingGameManager {
    FrameTypeChecker strikeFrameChecker;
    FrameTypeChecker spareFrameChecker;

    public BowlingGameManager(FrameTypeChecker strikeFrameChecker, FrameTypeChecker spareFrameChecker) {
        this.strikeFrameChecker = strikeFrameChecker;
        this.spareFrameChecker = spareFrameChecker;
    }

    public int calculateFrameScore(Frame frame) {
        FrameScoreCalculator calculator = new FrameScoreCalculator(new NormalScoreStrategy());

        if (strikeFrameChecker.matches(frame)) {
            calculator.setScoreStrategy(new StrikeScoreStrategy());
        } else if (spareFrameChecker.matches(frame)) {
            calculator.setScoreStrategy(new SpareScoreStrategy());
        }

        return calculator.calculateFrameScore(frame);
    }

    public List<Integer> calculateScores(BowlingGame bowlingGame) {
        return bowlingGame.getFrames().stream().map(this::calculateFrameScore).collect(Collectors.toList());
    }
}
