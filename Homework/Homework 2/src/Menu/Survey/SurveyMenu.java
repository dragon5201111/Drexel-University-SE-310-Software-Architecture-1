package Menu.Survey;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Menu.Menu;
import Survey.Survey;

public class SurveyMenu extends Menu {
    private Survey loadedSurvey = null;

    private final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    private final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public SurveyMenu() {
        super();
    }


    @Override
    protected void displayMainMenu() {
        this.consoleOutputDriver.printNumberedLines(this.getMenuOptionLabels(), this.getMenuOptionSize());
    }

    @Override
    public void start() {
        while(true) {
            this.displayMainMenu();
            int selection = this.consoleInputDriver.getIntegerInput("Please select a corresponding option: ", this.getMenuOptionSize());
            this.consoleOutputDriver.println();
            this.getMenuOption(selection - 1).execute();
            this.consoleOutputDriver.println();
        }
    }

    @Override
    protected void initializeOptions() {
        this.addMenuOption(new SurveyCreateOption(this));
        this.addMenuOption(new SurveyDisplayOption(this));
        this.addMenuOption(new SurveyLoadOption(this));
        this.addMenuOption(new SurveySaveOption(this));
        this.addMenuOption(new SurveyTakeOption(this));
        this.addMenuOption(new SurveyModifyOption(this));
        this.addMenuOption(new SurveyExitOption());
    }

    public void setLoadedSurvey(Survey loadedSurvey) {
        this.loadedSurvey = loadedSurvey;
    }

    public Survey getLoadedSurvey() {
        return this.loadedSurvey;
    }


}
