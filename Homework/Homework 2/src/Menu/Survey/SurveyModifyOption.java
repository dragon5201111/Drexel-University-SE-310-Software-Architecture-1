package Menu.Survey;
import Survey.Survey;

public class SurveyModifyOption extends SurveyMenuOption {

    public SurveyModifyOption(SurveyMenu surveyMenu) {
        super("Modify", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.modify();
        this.consoleOutputDriver.println("Modified. Save to keep changes.");
    }
}
