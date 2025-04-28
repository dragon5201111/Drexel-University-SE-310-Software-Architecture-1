package Menu.Survey;

import Question.Factory.QuestionFactory;
import Question.Factory.QuestionFactoryCreator;
import Question.Question;
import Question.QuestionType;
import Survey.Survey;

public class SurveyCreateOption extends SurveyMenuOption {
    public SurveyCreateOption(SurveyMenu surveyMenu) {
        super("Create a new Survey", surveyMenu);
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

            QuestionFactory questionFactory = QuestionFactoryCreator.getQuestionFactory(questionType);

            String prompt = this.consoleInputDriver.getStringInput("Enter the prompt for the question: ");
            Question newQuestion = questionFactory.createQuestion(prompt);
            newSurvey.addQuestion(newQuestion);
        }

        this.surveyMenu.setLoadedSurvey(newSurvey);

        this.consoleOutputDriver.println();
        this.consoleOutputDriver.println("'" + surveyTitle + "' has been created and loaded. Please save for future usage.");
    }
}
