package Menu.Survey;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Survey.Survey;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SurveyMenu{
    private final List<SurveyMenuOption> menuOptions;
    private Survey loadedSurvey = null;

    private final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    private final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public SurveyMenu() {
        this.menuOptions = new ArrayList<>();
        // Adds corresponding menu options
        this.initializeOptions();
    }


    protected void displayMainMenu() {
        this.consoleOutputDriver.printNumberedLines(this.getMenuOptionLabels(), this.getMenuOptionSize());
    }

    public void start() {
        while(true) {
            this.displayMainMenu();
            int selection = this.consoleInputDriver.getIntegerInput("Please select a corresponding option: ", this.getMenuOptionSize());
            this.consoleOutputDriver.println();
            this.getMenuOption(selection - 1).execute();
            this.consoleOutputDriver.println();
        }
    }

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

    protected List<String> getMenuOptionLabels() {
        return this.getMenuOptions()
                .stream()
                .map(SurveyMenuOption::getOptionLabel)
                .collect(Collectors.toList());
    }

    protected void addMenuOption(SurveyMenuOption menuOption) {
        this.menuOptions.add(menuOption);
    }

    protected SurveyMenuOption getMenuOption(int index) {
        return this.menuOptions.get(index);
    }

    protected int getMenuOptionSize(){
        return this.menuOptions.size();
    }

    protected List<SurveyMenuOption> getMenuOptions() {
        return this.menuOptions;
    }
}
