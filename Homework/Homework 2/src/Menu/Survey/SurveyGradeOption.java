package Menu.Survey;
import Survey.Survey;

public class SurveyGradeOption extends SurveyMenuOption{
    public SurveyGradeOption(SurveyMenu surveyMenu) {
        super("Grade", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        this.consoleOutputDriver.println("Not implemented yet.");
    }
}
