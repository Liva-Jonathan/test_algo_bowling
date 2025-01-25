package org.novity.factory;

import org.novity.exception.BowlingGameException;
import org.novity.model.BowlingGame;
import org.novity.model.Frame;

import java.util.ArrayList;
import java.util.List;

import static org.novity.constant.BowlingGameConstant.frameSeparator;
import static org.novity.constant.BowlingGameConstant.gameFrame;

public class BowlingGameCreator {

    FrameCreator frameCreator = new FrameCreator();

    public BowlingGame createBowlingGame(String gameInput) throws BowlingGameException {
        String[] frameInputs = gameInput.split(frameSeparator);
        if (frameInputs.length != gameFrame) {
            throw new BowlingGameException("Nombre de tour du jeu invalide");
        }

        List<Frame> frames = new ArrayList<>(gameFrame);
        for (int i = 0; i < frameInputs.length; i++) {
            frames.add(frameCreator.createFrame(frameInputs[i], i == frameInputs.length - 1));
        }

        for (int i = 0; i < frames.size() - 1; i++) {
            frames.get(i).setNextFrame(frames.get(i+1));
        }

        return new BowlingGame(frames);
    }

}
