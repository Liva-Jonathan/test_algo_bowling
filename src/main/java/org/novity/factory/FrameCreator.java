package org.novity.factory;

import org.novity.exception.BowlingGameException;
import org.novity.exception.InvalidThrowException;
import org.novity.model.Frame;
import org.novity.model.Throw;
import org.novity.validator.LastFrameValidator;
import org.novity.validator.NormalFrameValidator;

import java.util.ArrayList;
import java.util.List;

import static org.novity.constant.BowlingGameConstant.*;

public class FrameCreator {

    ThrowCreator throwCreator = new ThrowCreator();

    public Frame createFrame(String frameInput, boolean isLastFrame) throws BowlingGameException {
        Frame frame = new Frame(constructThrowList(frameInput));
        if (isLastFrame) {
            new LastFrameValidator().validate(frame);
            arrangeLastFrame(frame);
        }
        new NormalFrameValidator().validate(frame);
        completeSpareData(frame);
        completeStrikeData(frame);
        return frame;
    }

    private List<Throw> constructThrowList(String frameInput) throws InvalidThrowException {
        String[] throwInputs = frameInput.split(throwSeparator);
        List<Throw> frameThrows = new ArrayList<>();
        for (String throwInput : throwInputs) {
            frameThrows.add(throwCreator.createThrow(throwInput));
        }
        return frameThrows;
    }

    private void arrangeLastFrame(Frame frame) {
        List<Throw> realFrameThrows = new ArrayList<>();
        for (int i = 0; i < frame.getFrameThrows().size(); i++) {
            realFrameThrows.add(frame.getFrameThrows().get(i));
            if (frame.getFrameThrows().get(i).isStrike() || frame.getFrameThrows().get(i).isSpare() || i == throwPerFrame - 1)
                break;
        }
        List<Throw> bonusFrameThrows = frame.getFrameThrows().subList(realFrameThrows.size(), frame.getFrameThrows().size());
        frame.setFrameThrows(realFrameThrows);
        frame.setNextFrame(new Frame(bonusFrameThrows));

        completeSpareData(frame.getNextFrame());
        completeStrikeData(frame.getNextFrame());
    }

    private void completeSpareData(Frame frame) {
        int sum = 0;
        int spareIndex = -1;
        for (int i = 0; i < frame.getFrameThrows().size(); i++) {
            if (frame.getFrameThrows().get(i).isSpare()) {
                spareIndex = i;
            }
            sum += frame.getFrameThrows().get(i).getNbKnockedDownPins();
        }
        if (spareIndex != -1)
            frame.getFrameThrows().get(spareIndex).setNbKnockedDownPins(totalPins - sum);
    }

    private void completeStrikeData(Frame frame) {
        for (int i = 0; i < frame.getFrameThrows().size(); i++) {
            if (frame.getFrameThrows().get(i).isStrike()) {
                frame.getFrameThrows().get(i).setNbKnockedDownPins(totalPins);
            }
        }
    }
}
