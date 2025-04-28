package Menu.Survey;
import Survey.Survey;

public class SurveyModifyOption extends SurveyMenuOption {

    public SurveyModifyOption(SurveyMenu surveyMenu) {
        super("Modifying the current Survey", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.modify();
    }
}
