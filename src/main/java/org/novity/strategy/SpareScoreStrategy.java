package org.novity.strategy;

import org.novity.constant.BowlingGameConstant;
import org.novity.model.Frame;

public class SpareScoreStrategy extends BonusScoreStrategy {
    public static final int spareBonusThrow = 2;

    @Override
    public int calculateScore(Frame frame) {
        return BowlingGameConstant.totalPins + this.calculateBonusScore(frame, spareBonusThrow);
    }
}
