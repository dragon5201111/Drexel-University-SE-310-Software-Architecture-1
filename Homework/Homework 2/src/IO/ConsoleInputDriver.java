package IO;

import java.util.Scanner;

public class ConsoleInputDriver extends InputDriver{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public int getIntegerInput(String prompt) {
        int input;

        while(true){
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());

                if(input < 1){
                    throw new NumberFormatException();
                }

                break;
            } catch (NumberFormatException ignored) {
                System.out.println("Invalid integer input.");
            }
        }

        return input;
    }
}
