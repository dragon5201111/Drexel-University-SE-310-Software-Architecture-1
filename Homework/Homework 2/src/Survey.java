import IO.ConsoleInputDriver;
import IO.ConsoleOutputDriver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Survey implements Serializable {
    private final ConsoleOutputDriver consoleOutputDriver;
    private final ConsoleInputDriver consoleInputDriver;
    private final List<Question> questions;


    private String surveyTitle;
    private static final long serialVersionUID = 1L;

    public Survey(String surveyTitle) {
        this.surveyTitle = surveyTitle;
        this.questions = new ArrayList<>();
        this.consoleOutputDriver = new ConsoleOutputDriver();
        this.consoleInputDriver = new ConsoleInputDriver();
    }

    public void addQuestion(Question question){
        this.questions.add(question);
    }

    private Question getQuestion(int index){
        return this.questions.get(index);
    }

    private void removeQuestion(int questionIndex){
        this.questions.remove(questionIndex);
    }

    private void setSurveyTitle(String surveyTitle){
        this.surveyTitle = surveyTitle;
    }


    private void modifyQuestions(){
        while(true){
            if(this.questions.isEmpty()){
                consoleOutputDriver.println("No survey questions to modify.");
                break;
            }

            this.displaySurvey();

            int questionIndex = consoleInputDriver.getIntegerInput("Enter a corresponding question number to modify: ", questions.size()) - 1;
            Question correspondingQuestion = this.getQuestion(questionIndex);

            if(consoleInputDriver.userWantsToModify("delete", "question")){
                this.removeQuestion(questionIndex);
                consoleOutputDriver.println("Question deleted.");
            }

            correspondingQuestion.modifyQuestion();

            if(!this.consoleInputDriver.userWantsToModify("continue modifying", "questions")){
                break;
            }
        }
    }

    public void modifySurvey(){
        if(!this.consoleInputDriver.userWantsToModify("modify","survey")){
            return;
        }

        if(this.consoleInputDriver.userWantsToModify("modify", "survey title")){
            this.setSurveyTitle(this.consoleInputDriver.getStringInput("Enter survey title: "));
        }

        if(this.consoleInputDriver.userWantsToModify("modify", "questions")) {
            this.modifyQuestions();
        }

        consoleOutputDriver.println();
    }

    public void takeSurvey(){
        processSurvey(Question::answerQuestion);
    }


    public void displaySurvey(){
        processSurvey(question -> {
            question.displayQuestion();
            question.displayResponse();
        });
    }

    private void processSurvey(QuestionAction questionAction) {
        this.displaySurveyTitle();

        int questionNumber = 1;
        for(Question question : questions) {
            this.consoleOutputDriver.print(questionNumber + ") ");

            questionAction.perform(question);

            this.consoleOutputDriver.println();
            questionNumber++;
        }
    }

    @FunctionalInterface
    private interface QuestionAction {
        void perform(Question question);
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void displaySurveyTitle(){
        this.consoleOutputDriver.println("Survey Name: " + this.getSurveyTitle());
    }

}
