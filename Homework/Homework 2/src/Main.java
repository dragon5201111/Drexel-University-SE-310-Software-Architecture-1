import IO.Console.ConsoleInputDriver;
import Menu.Survey.*;
import Question.TrueFalse;


public class Main {
    public static void main(String[] args) {
        Menu menu = new SurveyMenu();
        ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();

        int menuSelection = consoleInputDriver.getIntegerInput("1) Survey\n2) Test\n", 2);

        if(menuSelection == 2){
            menu = new TestMenuDecorator(menu);
        }

        menu.start();

    }
}
