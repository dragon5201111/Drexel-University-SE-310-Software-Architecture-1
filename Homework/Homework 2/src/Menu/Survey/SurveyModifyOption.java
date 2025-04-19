package Menu.Survey;

import IO.Console.ConsoleOutputDriver;
import Menu.MenuOption;
import Survey.Survey;

public class SurveyModifyOption extends MenuOption {
    private ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();
    private SurveyMenu surveyMenu;

    public SurveyModifyOption(SurveyMenu surveyMenu) {
        super("Modifying the current Survey");
        this.surveyMenu = surveyMenu;
    }
    @Override
    public void execute() {
        Survey loadedSurvey = this.surveyMenu.getLoadedSurvey();

        if(loadedSurvey != null) {
            loadedSurvey.modifySurvey();
            return;
        }

        this.consoleOutputDriver.println("You must have a survey loaded in order to modify it.");
    }
}
