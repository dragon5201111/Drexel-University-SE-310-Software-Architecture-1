package Question;

import IO.Console.ConsoleInputDriver;
import IO.Console.ConsoleOutputDriver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Question implements Serializable {
    private final static long serialVersionUID = 6L;

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
        this.removeResponses();
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

    public List<String> getResponseFrequenciesList(){
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String response : this.getResponseList()) {
            frequencyMap.put(response, frequencyMap.getOrDefault(response, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            result.add(entry.getKey() + ": " + entry.getValue());
        }

        return result;
    }

    public abstract List<String> tabulateResponses();

    public void addResponse(String response){
        this.response.addResponse(response);
    }

    public void removeResponses(){
        this.response.clearResponseList();
    }

    public List<String> getResponseList(){
        return this.response.getResponseList();
    }

    public String getFirstResponse(){
        return this.response.getFirstResponse();
    }

    public boolean grade(List<String> answers){
        return this.response.compare(answers);
    }

}
