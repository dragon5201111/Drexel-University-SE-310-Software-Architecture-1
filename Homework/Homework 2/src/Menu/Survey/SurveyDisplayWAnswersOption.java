package Menu.Survey;

import Survey.Survey;

public class SurveyDisplayWAnswersOption extends SurveyMenuOption{

    public SurveyDisplayWAnswersOption(SurveyMenu surveyMenu) {
        super("Display with correct answers", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        this.consoleOutputDriver.println("Not implemented yet.");
    }
}
