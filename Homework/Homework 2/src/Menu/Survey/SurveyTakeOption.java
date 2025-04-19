package Menu.Survey;

import IO.Console.ConsoleOutputDriver;
import Menu.MenuOption;
import Survey.Survey;

public class SurveyTakeOption extends MenuOption {
    private ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
    private SurveyMenu surveyMenu;

    public SurveyTakeOption(SurveyMenu surveyMenu) {
        super("Take the current Survey");
        this.surveyMenu = surveyMenu;
    }

    @Override
    public void execute() {
        Survey loadedSurvey = this.surveyMenu.getLoadedSurvey();

        if(loadedSurvey != null) {
            loadedSurvey.takeSurvey();
            return;
        }

        this.consoleOutputDriver.println("You must have a survey loaded in order to take it.");
    }
}
