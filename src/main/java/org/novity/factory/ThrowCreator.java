package org.novity.factory;

import org.novity.exception.InvalidThrowException;
import org.novity.model.Throw;

import static org.novity.constant.BowlingGameConstant.spareSymbol;
import static org.novity.constant.BowlingGameConstant.strikeSymbol;

public class ThrowCreator {
    Throw createThrow(String throwInput) throws InvalidThrowException {
        Throw t = new Throw();
        if (throwInput.equals(strikeSymbol)) {
            t.setStrike(true);
        } else if (throwInput.equals(spareSymbol)) {
            t.setSpare(true);
        } else {
            try {
                t.setNbKnockedDownPins(Integer.parseInt(throwInput));
            } catch (NumberFormatException e) {
                throw new InvalidThrowException("Veuillez ajouter un lancer valide");
            }
        }
        return t;
    }
}
