package Menu.Survey;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Menu.MenuOption;
import Serialization.ObjectSerializer;
import Survey.Survey;

public abstract class SurveyActionOption extends MenuOption {
    protected final SurveyMenu surveyMenu;
    protected final ConsoleOutputDriver consoleOutputDriver;
    protected final ConsoleInputDriver consoleInputDriver;
    protected final ObjectSerializer objectSerializer;

    public SurveyActionOption(String optionLabel, SurveyMenu surveyMenu) {
        super(optionLabel);
        this.surveyMenu = surveyMenu;
        this.consoleOutputDriver = new ConsoleOutputDriver();
        this.consoleInputDriver = new ConsoleInputDriver();
        this.objectSerializer = new ObjectSerializer();
    }

    @Override
    public void execute() {
        Survey loadedSurvey = this.surveyMenu.getLoadedSurvey();

        if (loadedSurvey != null) {
            performAction(loadedSurvey);
        } else {
            this.consoleOutputDriver.println("You must have a survey loaded in order to perform this action.");
        }
    }

    protected abstract void performAction(Survey survey);

}
