package Menu.Survey;
import Survey.Survey;

public class SurveyExitOption extends SurveyMenuOption {

    public SurveyExitOption(SurveyMenu menu) {
        super("Return to previous menu", menu);
    }

    @Override
    public void execute(){
        this.performAction(null);
    }

    @Override
    protected void performAction(Survey survey) {
        this.surveyMenu.stop = true;
    }
}
