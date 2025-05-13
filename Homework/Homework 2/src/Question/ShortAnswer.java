package Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShortAnswer extends Essay implements Serializable {
    private final static long serialVersionUID = 8L;

    public ShortAnswer(String prompt, int wordLimit) {
        super(prompt, wordLimit);
    }

    @Override
    public List<String> tabulateResponses() {
        return this.getResponseFrequenciesList();
    }

    @Override
    public List<String> getCorrectAnswers() {
        List<String> correctAnswers = new ArrayList<>();
        while(true) {
            String answer = this.consoleInputDriver.getStringInput("Enter Correct Answer: ");

            if(this.responseIsValid(answer)) {
                correctAnswers.add(answer);
                break;
            }
        }

        return correctAnswers;
    }

    @Override
    public void displayResponse() {
        this.consoleOutputDriver.println(this.getFirstResponse());
    }


    @Override
    public boolean responseIsValid(String response){
        return response.length() <= this.getResponseLimit() && !response.isEmpty();
    }

    @Override
    public void answerQuestionBody() {
        while(true){
            String response = this.consoleInputDriver.getStringInput("- ");

            if(this.responseIsValid(response)){
                this.addResponse(response);
                break;
            }

            this.consoleOutputDriver.println("Invalid response. Question.Response exceeds the limit of " + this.getResponseLimit() + " characters or is empty.");
        }
    }
}
