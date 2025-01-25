package org.novity.display;

import java.util.List;

public interface DisplayManager {
    String getUserInput();
    void displayOutput(List<Integer> outputs, String separator);

    void displayMessage(String message);
}
