import IO.ConsoleInputDriver;
import IO.ConsoleOutputDriver;

import java.io.Serializable;
import java.util.List;

public abstract class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Response response;
    private String prompt;

    protected final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    protected final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public Question(String prompt) {
        this.prompt = prompt;
        this.response = new Response();
    }

    public abstract void modifyQuestionParameters();
    public abstract void displayResponse();

    public abstract void displayQuestion();
    public abstract void answerQuestionBody();

    // Template method
    public void answerQuestion() {
        this.displayQuestion();
        this.answerQuestionBody();
    }


    public void setPrompt(){
        this.displayQuestion();
        this.prompt = consoleInputDriver.getStringInput("New Prompt: ");
    }

    public String getPrompt(){
        return this.prompt;
    }

    // Template method
    public void modifyQuestion(){
        if(!this.consoleInputDriver.userWantsToModify("modify","question")){
            return;
        }

        if(this.consoleInputDriver.userWantsToModify("modify","prompt")){
            this.setPrompt();
        }

        if(this.consoleInputDriver.userWantsToModify("modify","question parameters")){
            this.modifyQuestionParameters();
        }
    }

    public void addResponse(String response){
        this.response.addResponse(response);
    }

    public List<String> getResponseList(){
        return this.response.getResponseList();
    }

    public String getFirstResponse(){
        return this.response.getFirstResponse();
    }

}
