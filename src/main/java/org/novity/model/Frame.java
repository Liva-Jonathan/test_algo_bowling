package org.novity.model;

import java.util.List;

public class Frame {
    private List<Throw> frameThrows;
    private Frame nextFrame;

    public Frame(List<Throw> frameThrows, Frame nextFrame) {
        this.frameThrows = frameThrows;
        this.nextFrame = nextFrame;
    }

    public Frame(List<Throw> frameThrows) {
        this.frameThrows = frameThrows;
    }

    public List<Throw> getFrameThrows() {
        return frameThrows;
    }

    public void setFrameThrows(List<Throw> frameThrows) {
        this.frameThrows = frameThrows;
    }

    public Frame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }
}
