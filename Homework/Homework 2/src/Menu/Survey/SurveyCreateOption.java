package Menu.Survey;

import Question.Factory.QuestionFactory;
import Question.Question;
import Question.QuestionType;
import Survey.Survey;
import java.util.List;

public class SurveyCreateOption extends SurveyActionOption{
    private final QuestionFactory questionFactory;

    public SurveyCreateOption(SurveyMenu surveyMenu) {
        super("Create a new Survey", surveyMenu);
        this.questionFactory = new QuestionFactory();
    }

    @Override
    public void execute() {
        Survey loadedSurvey = this.surveyMenu.getLoadedSurvey();

        if(loadedSurvey == null){
            this.performAction(null);
            return;
        }

        this.consoleOutputDriver.println("This action will overwrite the loaded survey.");

        if(this.consoleInputDriver.userWantsToModify("overwrite", "survey")){
            this.consoleOutputDriver.println();
            this.performAction(null);
        }
    }

    private void displayOptions() {
        for(QuestionType questionType : QuestionType.values()){
            this.consoleOutputDriver.println(questionType.getValue() + ") Add a new " + questionType.getDisplayName());
        }
    }

    @Override
    protected void performAction(Survey survey) {
        String surveyTitle = consoleInputDriver.getStringInput("Enter a Survey Title: ");
        Survey newSurvey = new Survey(surveyTitle);

        while (this.consoleInputDriver.userWantsToModify("add a question", "survey")) {

            this.consoleOutputDriver.println();
            this.displayOptions();
            this.consoleOutputDriver.println();

            int choice = this.consoleInputDriver.getIntegerInput("Enter question type (select corresponding number): ");
            this.consoleOutputDriver.println();

            if(!QuestionType.isValidValue(choice)){
                this.consoleOutputDriver.println("Invalid question type. Try again.");
                continue;
            }

            QuestionType questionType = QuestionType.fromValue(choice);
            this.consoleOutputDriver.println("Creating a new question of type " + questionType.getDisplayName() + ".");

            Question newQuestion = questionFactory.createQuestion(questionType);
            newSurvey.addQuestion(newQuestion);
        }

        this.surveyMenu.setLoadedSurvey(newSurvey);

        this.consoleOutputDriver.println();
        this.consoleOutputDriver.println("'" + surveyTitle + "' has been created and loaded. Please save for future usage.");
    }
}
