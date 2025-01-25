package org.novity.factory;

import org.novity.exception.InvalidThrowException;
import org.novity.model.Throw;

import static org.novity.constant.BowlingGameConstant.*;

public class ThrowCreator {
    public Throw createThrow(String throwInput) throws InvalidThrowException {
        Throw t = new Throw();
        switch (throwInput) {
            case strikeSymbol:
                t.setStrike(true);
                break;
            case spareSymbol:
                t.setSpare(true);
                break;
            case missSymbol:
                t.setNbKnockedDownPins(0);
                break;
            default:
                try {
                    int throwNumber = Integer.parseInt(throwInput);
                    if (throwNumber >= totalPins)
                        throw new InvalidThrowException("Lancer invalide : nombre de quilles renversées invalide");

                    t.setNbKnockedDownPins(throwNumber);
                } catch (NumberFormatException e) {
                    throw new InvalidThrowException("Veuillez ajouter un lancer valide");
                }
                break;
        }
        return t;
    }
}
