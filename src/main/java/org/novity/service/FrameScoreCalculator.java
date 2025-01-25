package org.novity.service;

import org.novity.model.Frame;
import org.novity.strategy.ScoreStrategy;

public class FrameScoreCalculator {
    ScoreStrategy scoreStrategy;

    public FrameScoreCalculator(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }

    int calculateFrameScore(Frame frame) {
        return this.getScoreStrategy().calculateScore(frame);
    }

    public ScoreStrategy getScoreStrategy() {
        return scoreStrategy;
    }

    public void setScoreStrategy(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }
}
