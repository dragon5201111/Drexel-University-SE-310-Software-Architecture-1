package Survey;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;
import Question.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Survey implements Serializable{
    private final static long serialVersionUID = 11L;

    protected final ConsoleOutputDriver consoleOutputDriver;
    protected final ConsoleInputDriver consoleInputDriver;
    protected final List<Question> questions;

    protected String title;

    public Survey(String title) {
        this.title = title;
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

    protected void removeQuestion(int questionIndex){
        this.questions.remove(questionIndex);
    }


    protected void setTitle(String title){
        this.title = title;
    }

    private void modifyQuestions(){
        while(true){
            if(this.questions.isEmpty()){
                consoleOutputDriver.println("No survey questions to modify.");
                break;
            }

            this.display();

            int questionIndex = consoleInputDriver.getIntegerInput("What question do you wish to modify (enter a number)? ", questions.size()) - 1;
            Question correspondingQuestion = this.getQuestion(questionIndex);

            if(consoleInputDriver.userWantsToModify("delete", "question")){
                this.removeQuestion(questionIndex);
                consoleOutputDriver.println("Question deleted.");
            }else{
                correspondingQuestion.modifyQuestion();
            }

            if(!this.consoleInputDriver.userWantsToModify("Do you wish to continue modifying?", "questions")){
                break;
            }
        }
    }

    public void modify(){
        if(!this.consoleInputDriver.userWantsToModify("modify","survey")){
            return;
        }

        if(this.consoleInputDriver.userWantsToModify("modify", "survey title")){
            this.displayTitle();
            this.setTitle(this.consoleInputDriver.getStringInput("Enter survey title: "));
        }

        if(this.consoleInputDriver.userWantsToModify("modify", "questions")) {
            this.modifyQuestions();
        }

        consoleOutputDriver.println();
    }

    public void take(){
        process(Question::answerQuestion);
    }

    public void displayTabulated(){
        for(Question question : this.questions){
            question.displayQuestion();

            for(String line : question.tabulateResponses()){
                this.consoleOutputDriver.println(line);
            }

            this.consoleOutputDriver.println();
        }
    }

    public void display(){
        process(question -> {
            question.displayQuestion();
            question.displayResponse();
        });
    }

    private void process(QuestionAction questionAction) {
        this.displayTitle();

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

    public List<Question> getQuestions() {
        return this.questions;
    }

    public String getTitle() {
        return title;
    }

    public void clearResponses(){
        for(Question question : this.questions){
            question.removeResponses();
        }
    }

    public void displayTitle(){
        this.consoleOutputDriver.println("Survey Name: " + this.getTitle());
    }
}
