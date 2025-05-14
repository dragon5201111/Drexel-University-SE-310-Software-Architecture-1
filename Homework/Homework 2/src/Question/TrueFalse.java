package Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class TrueFalse extends Question implements Serializable {
    private final static long serialVersionUID = 9L;

    private final String TRUE = "True";
    private final String FALSE = "False";

    public TrueFalse(String prompt) {
        super(prompt);
    }

    @Override
    public void displayQuestion() {
        this.consoleOutputDriver.println(this.getPrompt());
    }

    @Override
    public List<String> tabulateResponses() {
        return this.getResponseFrequenciesList();
    }

    private String collectTrueFalseResponse() {
        while (true) {
            String response = consoleInputDriver.getStringInput(TRUE + "/" + FALSE + ": ");

            if (isTrueOrFalse(response)) {
                return response;
            }

            consoleOutputDriver.println("Invalid answer. Must be " + TRUE + "/" + FALSE + ". This is case sensitive.");
        }
    }

    @Override
    public void answerQuestionBody() {
        this.addResponse(collectTrueFalseResponse());
    }


    @Override
    public List<String> getCorrectAnswers() {
        List<String> correctAnswers = new ArrayList<>();
        correctAnswers.add(collectTrueFalseResponse());
        return correctAnswers;
    }

    private boolean isTrueOrFalse(String string){
        return string.equals(TRUE) || string.equals(FALSE);
    }

    @Override
    public void modifyQuestionParameters() {
    }

    @Override
    public void displayResponse() {
        this.consoleOutputDriver.println(this.getFirstResponse());
    }
}
