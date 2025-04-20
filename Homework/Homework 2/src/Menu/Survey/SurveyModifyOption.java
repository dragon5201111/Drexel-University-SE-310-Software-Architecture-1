package Menu.Survey;

import IO.Console.ConsoleOutputDriver;
import Menu.MenuOption;
import Survey.Survey;

public class SurveyModifyOption extends SurveyActionOption {

    public SurveyModifyOption(SurveyMenu surveyMenu) {
        super("Modifying the current Survey", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.modifySurvey();
    }
}
