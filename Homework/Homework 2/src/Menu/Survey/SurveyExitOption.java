package Menu.Survey;

import Menu.MenuOption;

public class SurveyExitOption extends MenuOption {
    public SurveyExitOption() {
        super("Exit");
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
