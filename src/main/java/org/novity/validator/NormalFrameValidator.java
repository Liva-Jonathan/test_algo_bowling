package org.novity.validator;

import org.novity.exception.InvalidFrameException;
import org.novity.model.Frame;
import org.novity.model.Throw;

import static org.novity.constant.BowlingGameConstant.throwPerFrame;
import static org.novity.constant.BowlingGameConstant.totalPins;

public class NormalFrameValidator implements FrameValidator {
    @Override
    public void validate(Frame frame) throws InvalidFrameException {
        if (frame.getFrameThrows().size() > throwPerFrame)
            throw new InvalidFrameException(String.format("Tour invalide : (%d lancer par tour au max)", throwPerFrame));

        if (frame.getFrameThrows().get(0).isSpare())
            throw new InvalidFrameException("Tour invalide : un premier lancer ne peut pas être un spare");

        if (frame.getFrameThrows().get(0).isStrike() && frame.getFrameThrows().size() != 1)
            throw new InvalidFrameException("Tour invalide : le tour est terminé quand il y a un strike");

        if (frame.getFrameThrows().subList(1, frame.getFrameThrows().size()).stream().anyMatch(Throw::isStrike))
            throw new InvalidFrameException("Tour invalide : un strike se fait au premier lancer seulement");

        if (frame.getFrameThrows().stream().filter(Throw::isSpare).count() > 1)
            throw new InvalidFrameException("Tour invalide : le tour est terminé quand il y a un spare");

        if (frame.getFrameThrows().size() < throwPerFrame
                && !frame.getFrameThrows().get(frame.getFrameThrows().size() - 1).isSpare()
                && !frame.getFrameThrows().get(0).isStrike())
            throw new InvalidFrameException("Tour invalide : tour incomplète");

        if (frame.getFrameThrows().stream().mapToInt(Throw::getNbKnockedDownPins).sum() >= totalPins)
            throw new InvalidFrameException(
                    String.format("Tour invalide : le score maximum pour un tour sans strike et sans spare est de %d", totalPins - 1)
            );
    }
}
