package org.novity.validator;

import org.novity.exception.InvalidFrameException;
import org.novity.model.Frame;

public interface FrameValidator {
    void validate(Frame frame) throws InvalidFrameException;
}
