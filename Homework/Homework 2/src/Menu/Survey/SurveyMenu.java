package Menu.Survey;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Menu.Menu;
import Question.Essay;
import Survey.Survey;

import java.util.List;
import java.util.stream.Collectors;

public class SurveyMenu extends Menu {
    private Survey loadedSurvey = null;
    private final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    private final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public SurveyMenu() {
        super();
    }


    @Override
    public void displayMainMenu() {
        List<String> menuOptionLabels = this.getMenuOptions()
                .stream()
                .map(option -> option.getOptionLabel())
                .collect(Collectors.toList());
        this.consoleOutputDriver.printNumberedLines(menuOptionLabels, this.getMenuOptionSize());
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
        this.addMenuOption(new SurveyExitOption());
    }

    public void setLoadedSurvey(Survey loadedSurvey) {
        this.loadedSurvey = loadedSurvey;
    }

    public Survey getLoadedSurvey() {
        return this.loadedSurvey;
    }

}
