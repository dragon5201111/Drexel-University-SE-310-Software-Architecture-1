import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Menu.Survey.*;

public class Main {
    public static void main(String[] args) {
        ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

        while(true){
            Menu menu;

            int menuSelection = consoleInputDriver.getIntegerInput("1) Survey\n2) Test\n3) Quit\n", 3);

            switch(menuSelection){
                case 2:
                    menu = new TestMenu();
                    break;
                case 3:
                    return;
                default:
                    menu = new SurveyMenu();
            }

            consoleOutputDriver.println();

            menu.start();
        }

    }
}
