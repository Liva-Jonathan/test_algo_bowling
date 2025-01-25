package org.novity.validator;

import org.novity.exception.InvalidFrameException;
import org.novity.model.Frame;
import org.novity.model.Throw;

import static org.novity.constant.BowlingGameConstant.throwPerFrame;
import static org.novity.strategy.SpareScoreStrategy.spareBonusThrow;
import static org.novity.strategy.StrikeScoreStrategy.strikeBonusThrow;

public class LastFrameValidator implements FrameValidator {
    @Override
    public void validate(Frame frame) throws InvalidFrameException {
        if (frame.getFrameThrows().size() > throwPerFrame + spareBonusThrow)
            throw new InvalidFrameException("Tour invalide : nombre de lancer invalide pour le dernier tour");

        if (frame.getFrameThrows().get(0).isStrike() && frame.getFrameThrows().size() != strikeBonusThrow + 1)
            throw new InvalidFrameException(String.format(
                    "Tour invalide : veuillez considérer %d lancer bonus pour le strike du dernier tour", strikeBonusThrow)
            );

        if (frame.getFrameThrows().get(0).isSpare())
            throw new InvalidFrameException("Tour invalide : un premier lancer ne peut pas être un spare");

        int spareThrowIndex = frame.getFrameThrows().subList(1, throwPerFrame)
                                                                    .stream()
                                                                    .filter(Throw::isSpare)
                                                                    .findFirst()
                                                                    .map(frame.getFrameThrows()::indexOf)
                                                                    .orElse(-1);
        if (spareThrowIndex != -1 && frame.getFrameThrows().size() != spareThrowIndex + spareBonusThrow + 1)
            throw new InvalidFrameException(String.format(
                    "Tour invalide : veuillez considérer %d lancer bonus pour le spare du dernier tour", spareBonusThrow)
            );
    }
}
