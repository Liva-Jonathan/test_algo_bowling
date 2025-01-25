package org.novity.strategy;

import org.novity.model.Frame;
import org.novity.model.Throw;

public class NormalScoreStrategy implements ScoreStrategy {
    @Override
    public int calculateScore(Frame frame) {
        return frame.getFrameThrows().stream().mapToInt(Throw::getNbKnockedDownPins).sum();
    }
}
