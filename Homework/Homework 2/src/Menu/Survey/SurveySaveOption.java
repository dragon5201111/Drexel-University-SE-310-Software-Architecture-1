package Menu.Survey;

import Serialization.ObjectSerializer;
import Survey.Survey;

public class SurveySaveOption extends SurveyMenuOption {

    public SurveySaveOption(SurveyMenu surveyMenu) {
        super("Save the current Survey", surveyMenu);
    }


    @Override
    protected void performAction(Survey survey) {
        String surveyTitle = survey.getTitle();
        ObjectSerializer.serialize(survey, surveyTitle);
        survey.display();
        this.consoleOutputDriver.println("Success! Saved as: " + surveyTitle);
    }
}
