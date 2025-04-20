package Menu.Survey;

import IO.Console.ConsoleOutputDriver;
import Menu.MenuOption;
import Survey.Survey;

public class SurveyDisplayOption extends SurveyActionOption {

    public SurveyDisplayOption(SurveyMenu surveyMenu) {
        super("Display an existing Survey", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.displaySurvey();
    }
}
