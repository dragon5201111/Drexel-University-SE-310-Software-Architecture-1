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

    // Template steps
    public abstract void displayQuestion();
    public abstract void answerQuestion();
    public abstract void modifyQuestionParameters();

    public abstract void displayResponse();

    private boolean userWantsToModify(String what) {
        String input = consoleInputDriver.getStringInput("Do you wish to modify the " + what + "? Yes or No: ");
        return input.equalsIgnoreCase("yes");
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
        if(!userWantsToModify("question")){
            return;
        }

        if(userWantsToModify("prompt")){
            this.setPrompt();
        }

        if(userWantsToModify("question parameters")){
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
