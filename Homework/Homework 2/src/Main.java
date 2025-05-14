import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Menu.Survey.*;

public class Main {
    public static void main(String[] args) {
        ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
        ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

        while(true){
            Menu menu = new SurveyMenu();

            int menuSelection = consoleInputDriver.getIntegerInput("1) Survey\n2) Test\n3) Quit\n", 3);

            if(menuSelection == 2){
                menu = new TestMenuDecorator(menu);
            } else if (menuSelection == 3) {
                break;
            }

            consoleOutputDriver.println();

            menu.start();
        }

    }
}
