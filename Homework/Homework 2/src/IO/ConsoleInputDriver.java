package IO;

import java.util.Scanner;

public class ConsoleInputDriver extends InputDriver{
    public final char CHAR_BASE = 'A';
    private final Scanner scanner = new Scanner(System.in);

    public boolean userWantsToModify(String verb, String subject) {
        String input = this.getStringInput("Do you wish to " + verb + " the " + subject + "? yes or no: ");
        return input.equalsIgnoreCase("yes");
    }

    @Override
    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public int getIntegerInput(String prompt) {
        return this.getIntegerInput(prompt, Integer.MAX_VALUE - 1);
    }

    @Override
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
