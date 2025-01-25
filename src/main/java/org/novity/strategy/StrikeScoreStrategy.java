package org.novity.strategy;

import org.novity.constant.BowlingGameConstant;
import org.novity.model.Frame;

public class StrikeScoreStrategy extends BonusScoreStrategy {
    public static final int strikeBonusThrow = 3;

    @Override
    public int calculateScore(Frame frame) {
        return BowlingGameConstant.totalPins + this.calculateBonusScore(frame, strikeBonusThrow);
    }
}
