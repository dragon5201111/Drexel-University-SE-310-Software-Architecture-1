package IO.Console;

import java.io.Serializable;
import java.util.Scanner;

public class ConsoleInputDriver implements Serializable {
    private final static long serialVersionUID = 1L;

    public final char CHAR_BASE = 'A';
    private static final Scanner scanner = new Scanner(System.in);

    public boolean userWantsToModify(String verb, String subject) {
        String input = this.getStringInput("Do you wish to " + verb + " the " + subject + "? yes or no: ");
        return input.equalsIgnoreCase("yes");
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getIntegerInput(String prompt) {
        return this.getIntegerInput(prompt, Integer.MAX_VALUE - 1);
    }

    public int getIntegerInput(String prompt, int max) {
        int input;

        while(true){
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());

                if(input < 1 || input > max){
                    throw new NumberFormatException();
                }

                break;
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid integer input. Out of range.");
            }
        }

        return input;
    }
}
