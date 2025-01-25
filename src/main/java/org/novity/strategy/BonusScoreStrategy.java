package org.novity.strategy;

import org.novity.model.Frame;
import org.novity.model.Throw;

public abstract class BonusScoreStrategy implements ScoreStrategy {
    protected int calculateBonusScore(Frame frame, int requiredBonusThrow) {
        // Take bonus score from next frames until having the required throws

        int bonusScore = 0;
        Frame currentFrame = frame.getNextFrame();

        while (requiredBonusThrow > 0 && currentFrame != null) {
            int throwsToTake = Math.min(requiredBonusThrow, currentFrame.getFrameThrows().size());
            bonusScore += currentFrame.getFrameThrows().stream()
                                                        .limit(throwsToTake)
                                                        .mapToInt(Throw::getNbKnockedDownPins)
                                                        .sum();
            requiredBonusThrow -= throwsToTake;
            currentFrame = currentFrame.getNextFrame();
        }

        return bonusScore;
    }
}
