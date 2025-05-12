package Menu.Survey;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Survey.Survey;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SurveyMenu implements Menu {
    private final List<SurveyMenuOption> menuOptions;
    private Survey loadedSurvey = null;

    private final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    private final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public SurveyMenu() {
        this.menuOptions = new ArrayList<>();
        // Adds corresponding menu options
        this.initializeOptions();
    }


    private void displayMainMenu() {
        this.consoleOutputDriver.printNumberedLines(this.getMenuOptionLabels(), this.getMenuOptionsSize());
    }

    @Override
    public void start() {
        while(true) {
            this.displayMainMenu();
            int selection = this.consoleInputDriver.getIntegerInput("Please select a corresponding option: ", this.getMenuOptionsSize());
            this.consoleOutputDriver.println();
            this.getMenuOption(selection - 1).execute();
            this.consoleOutputDriver.println();
        }
    }

    private void initializeOptions() {
        this.addMenuOption(new SurveyCreateOption(this));
        this.addMenuOption(new SurveyDisplayOption(this));
        this.addMenuOption(new SurveyLoadOption(this));
        this.addMenuOption(new SurveySaveOption(this));
        this.addMenuOption(new SurveyTakeOption(this));
        this.addMenuOption(new SurveyModifyOption(this));
        this.addMenuOption(new SurveyTabulateOption(this));
        this.addMenuOption(new SurveyExitOption());
    }

    public void setLoadedSurvey(Survey loadedSurvey) {
        this.loadedSurvey = loadedSurvey;
    }

    public Survey getLoadedSurvey() {
        return this.loadedSurvey;
    }

    public List<String> getMenuOptionLabels() {
        return this.getMenuOptions()
                .stream()
                .map(SurveyMenuOption::getOptionLabel)
                .collect(Collectors.toList());
    }

    @Override
    public void addMenuOption(int position, SurveyMenuOption menuOption) {
        this.menuOptions.add(position, menuOption);
    }

    @Override
    public void setMenuOption(int position, SurveyMenuOption menuOption) {
        this.menuOptions.set(position, menuOption);
    }

    public void addMenuOption(SurveyMenuOption menuOption) {
        this.addMenuOption(this.menuOptions.size(), menuOption);
    }

    public SurveyMenuOption getMenuOption(int index) {
        return this.menuOptions.get(index);
    }

    public int getMenuOptionsSize(){
        return this.menuOptions.size();
    }

    public List<SurveyMenuOption> getMenuOptions() {
        return this.menuOptions;
    }
}
