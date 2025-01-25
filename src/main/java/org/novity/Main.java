package org.novity;

import org.novity.checker.SpareFrameTypeChecker;
import org.novity.checker.StrikeFrameTypeChecker;
import org.novity.display.ConsoleDisplayManager;
import org.novity.display.DisplayManager;
import org.novity.exception.BowlingGameException;
import org.novity.factory.BowlingGameCreator;
import org.novity.model.BowlingGame;
import org.novity.service.BowlingGameManager;

import java.util.List;

import static org.novity.constant.BowlingGameConstant.frameSeparator;

public class Main {
    public static void main(String[] args) {
        DisplayManager displayManager = new ConsoleDisplayManager();
        displayManager.displayMessage("Entrer les résultats des lancers du bowling : ");
        String bowlingGameInput = displayManager.getUserInput();

        try {
            BowlingGame bowlingGame = new BowlingGameCreator().createBowlingGame(bowlingGameInput);
            BowlingGameManager bowlingGameManager = new BowlingGameManager(new StrikeFrameTypeChecker(), new SpareFrameTypeChecker());
            List<Integer> framesScores = bowlingGameManager.calculateScores(bowlingGame);
            displayManager.displayOutput(framesScores, frameSeparator);
        } catch (BowlingGameException e) {
            displayManager.displayMessage(e.getMessage());
        }
    }
}
