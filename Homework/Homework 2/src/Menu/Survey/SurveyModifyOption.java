package Menu.Survey;
import Serialization.ObjectSerializer;
import Survey.Survey;

public class SurveyModifyOption extends SurveyMenuOption {

    public SurveyModifyOption(SurveyMenu surveyMenu) {
        super("Modify", surveyMenu);
    }

    @Override
    protected void performAction(Survey survey) {
        survey.modify();
        this.consoleOutputDriver.println("Modification saved");
        ObjectSerializer.serialize(survey, survey.getTitle());
    }
}
