package org.novity.model;

import java.util.List;

public class BowlingGame {
    private List<Frame> frames;

    public BowlingGame(List<Frame> frames) {
        this.frames = frames;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }
}
