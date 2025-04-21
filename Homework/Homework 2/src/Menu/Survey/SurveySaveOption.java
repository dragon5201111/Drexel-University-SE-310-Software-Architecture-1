package Menu.Survey;

import Serialization.ObjectSerializer;
import Survey.Survey;

public class SurveySaveOption extends SurveyActionOption{

    public SurveySaveOption(SurveyMenu surveyMenu) {
        super("Save the current Survey", surveyMenu);
    }


    @Override
    protected void performAction(Survey survey) {
        String surveyTitle = survey.getSurveyTitle();
        this.objectSerializer.serialize(survey, surveyTitle);
        survey.displaySurvey();
        this.consoleOutputDriver.println("Success! Saved survey as: " + surveyTitle);
    }
}
