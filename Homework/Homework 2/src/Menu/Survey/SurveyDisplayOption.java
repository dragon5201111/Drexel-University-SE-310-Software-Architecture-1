package Menu.Survey;

import IO.Console.ConsoleOutputDriver;
import Menu.MenuOption;
import Survey.Survey;

public class SurveyDisplayOption extends MenuOption {
    private ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
    private SurveyMenu surveyMenu;

    public SurveyDisplayOption(SurveyMenu surveyMenu) {
        super("Display an existing Survey");
        this.surveyMenu = surveyMenu;
    }

    @Override
    public void execute() {
        Survey loadedSurvey = this.surveyMenu.getLoadedSurvey();

        if(loadedSurvey != null) {
            loadedSurvey.displaySurvey();
            return;
        }

        this.consoleOutputDriver.println("You must have a survey loaded in order to display it.");
    }
}
