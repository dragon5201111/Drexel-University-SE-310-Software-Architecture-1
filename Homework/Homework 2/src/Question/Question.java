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

    private final List<Response> responses;
    private String prompt;

    protected final ConsoleInputDriver consoleInputDriver = new ConsoleInputDriver();
    protected final ConsoleOutputDriver consoleOutputDriver = new ConsoleOutputDriver();

    public Question(String prompt) {
        this.prompt = prompt;
        this.responses = new ArrayList<>();
    }

    public abstract void modifyQuestionParameters();
    public abstract void displayResponse();

    public abstract void displayQuestion();
    public abstract void answerQuestionBody();

    // Template method
    public void answerQuestion() {
        this.displayQuestion();
        this.responses.add(new Response());
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

    public List<Response> getAllResponses() {
        return this.responses;
    }

    public List<String> getResponseFrequenciesList(){
        Map<String, Integer> frequencyMap = new HashMap<>();

        for(Response response : this.getAllResponses()){
            for (String value : response.getResponseList()) {
                if(value.equals(response.getResponseDefault())){
                    continue;
                }

                frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
            }
        }


        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            result.add(String.format("%s: %d", entry.getKey(), entry.getValue()));
        }

        return result;
    }


    public abstract List<String> tabulateResponses();
    public abstract List<String> getCorrectAnswers();

    private Response getMostRecentResponse(){
        return this.responses.get(this.responses.size() - 1);
    }

    public void addResponse(String response){
        this.getMostRecentResponse().addResponse(response);
    }


    public List<String> getResponseList(){
        if(this.responses.isEmpty()){
            return new ArrayList<>();
        }
        return this.getMostRecentResponse().getResponseList();
    }

    public String getFirstResponse(){
        if(this.responses.isEmpty()){
            return "";
        }
        return this.getMostRecentResponse().getFirstResponse();
    }

    public boolean grade(List<String> answers){
        return this.getMostRecentResponse().compare(answers);
    }

    public boolean grade(int index, List<String> answers){
        return this.responses.get(index).compare(answers);
    }

}
