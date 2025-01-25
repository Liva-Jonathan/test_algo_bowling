package org.novity.checker;

import org.novity.model.Frame;
import org.novity.model.Throw;

public class SpareFrameTypeChecker implements FrameTypeChecker {
    @Override
    public boolean matches(Frame frame) {
        return frame.getFrameThrows().stream().anyMatch(Throw::isSpare);
    }
}
