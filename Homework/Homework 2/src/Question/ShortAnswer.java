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
    public void displayResponse() {
        this.consoleOutputDriver.println(this.getFirstResponse());
    }


    @Override
    public boolean responseIsValid(String response){
        return response.length() <= this.getResponseLimit() && !response.isEmpty();
    }

    private String collectSingleResponse(String prompt) {
        while (true) {
            String response = this.consoleInputDriver.getStringInput(prompt);

            if (this.responseIsValid(response)) {
                return response;
            }

            this.consoleOutputDriver.println("Invalid response. Response exceeds the limit of " + this.getResponseLimit() + " characters or is empty.");
        }
    }

    @Override
    public List<String> getCorrectAnswers() {
        List<String> correctAnswers = new ArrayList<>();
        String answer = this.collectSingleResponse("Enter Correct Answer: ");
        correctAnswers.add(answer);
        return correctAnswers;
    }


    @Override
    public void answerQuestionBody() {
        String response = this.collectSingleResponse("- ");
        this.addResponse(response);
    }
}
