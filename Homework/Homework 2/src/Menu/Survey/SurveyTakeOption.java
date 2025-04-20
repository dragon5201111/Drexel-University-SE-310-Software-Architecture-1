package Menu.Survey;

import IO.Console.ConsoleOutputDriver;
import Menu.MenuOption;
import Survey.Survey;

public class SurveyTakeOption extends SurveyActionOption {

    public SurveyTakeOption(SurveyMenu surveyMenu) {
        super("Take the current Survey", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.takeSurvey();
    }
}
