package org.novity.checker;

import org.novity.model.Frame;

public class StrikeFrameTypeChecker implements FrameTypeChecker {
    @Override
    public boolean matches(Frame frame) {
        return frame.getFrameThrows().get(0).isStrike();
    }
}
