package org.novity.model;

public class Throw {
    private int nbKnockedDownPins;
    private boolean isStrike;
    private boolean isSpare;

    public Throw(int nbKnockedDownPins, boolean isStrike, boolean isSpare) {
        this.nbKnockedDownPins = nbKnockedDownPins;
        this.isStrike = isStrike;
        this.isSpare = isSpare;
    }

    public int getNbKnockedDownPins() {
        return nbKnockedDownPins;
    }

    public void setNbKnockedDownPins(int nbKnockedDownPins) {
        this.nbKnockedDownPins = nbKnockedDownPins;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public void setSpare(boolean spare) {
        isSpare = spare;
    }
}
