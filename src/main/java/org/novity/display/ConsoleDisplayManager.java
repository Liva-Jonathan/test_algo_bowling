package org.novity.display;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleDisplayManager implements DisplayManager {
    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void displayOutput(List<Integer> outputs, String separator) {
        System.out.println("Score pour chaque frame : ");
        String result = outputs.stream().map(String::valueOf).collect(Collectors.joining(separator));
        System.out.println(result);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
