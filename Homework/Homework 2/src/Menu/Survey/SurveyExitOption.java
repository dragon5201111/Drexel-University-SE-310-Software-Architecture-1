package Menu.Survey;
import Survey.Survey;

public class SurveyExitOption extends SurveyActionOption {

    public SurveyExitOption() {
        super("Quit", null);
    }

    @Override
    public void execute(){
        this.performAction(null);
    }

    @Override
    protected void performAction(Survey survey) {
        System.exit(0);
    }
}
