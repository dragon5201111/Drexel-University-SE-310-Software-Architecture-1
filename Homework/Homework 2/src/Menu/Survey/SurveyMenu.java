package Menu.Survey;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Menu.Menu;
import Survey.Survey;

public class SurveyMenu extends Menu {
    private Survey loadedSurvey = null;
    private String loadedSurveyName = null;

    private final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    private final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public SurveyMenu() {
        super();
    }


    @Override
    public void displayMainMenu() {
        this.consoleOutputDriver.printNumberedLines(this.getMenuOptionLabels(), this.getMenuOptionSize());
    }

    @Override
    public void start() {
        while(true) {
            this.displayMainMenu();
            int selection = this.consoleInputDriver.getIntegerInput("Please select a corresponding option: ", this.getMenuOptionSize());
            this.getMenuOption(selection - 1).execute();
            this.consoleOutputDriver.println();
        }
    }

    @Override
    public void initializeOptions() {
        this.addMenuOption(new SurveyModifyOption(this));
        this.addMenuOption(new SurveyTakeOption(this));
        this.addMenuOption(new SurveyDisplayOption(this));
        this.addMenuOption(new SurveyLoadOption(this));
        this.addMenuOption(new SurveyExitOption());
    }

    public void setLoadedSurvey(Survey loadedSurvey, String loadedSurveyName) {
        this.loadedSurvey = loadedSurvey;
        this.loadedSurveyName = loadedSurveyName;
    }

    public Survey getLoadedSurvey() {
        return this.loadedSurvey;
    }

    public String getLoadedSurveyName() {
        return this.loadedSurveyName;
    }

}
