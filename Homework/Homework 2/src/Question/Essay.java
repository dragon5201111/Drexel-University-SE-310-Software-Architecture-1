package Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Essay extends Question implements Serializable {
    private final static long serialVersionUID = 3L;

    private int responseLimit;

    public Essay(String prompt, int responseLimit) {
        super(prompt);
        this.responseLimit = responseLimit;
    }

    @Override
    public void displayQuestion() {
        this.consoleOutputDriver.println(this.getPrompt());
    }


    public boolean responseIsValid(String response){
        return !response.isEmpty();
    }


    @Override
    public void answerQuestionBody() {
        for(int i = 1; i <= this.responseLimit; i++){
          while (true){
              char questionChar = (char) (this.consoleInputDriver.CHAR_BASE + i - 1);
              String questionLetter = questionChar + ") ";
              String response = this.consoleInputDriver.getStringInput(questionLetter);

              if(responseIsValid(response)){
                  this.addResponse(response);
                  break;
              }

              this.consoleOutputDriver.println("Invalid response. Question.Response cannot be empty.");

          }
        }
    }

    @Override
    public List<String> tabulateResponses() {
        List<String> responses = new ArrayList<>();
        for(Response response : this.getAllResponses()){
            responses.addAll(response.getResponseList());
        }
        return responses;
    }

    @Override
    public List<String> getCorrectAnswers() {
        // Essay has no correct answers
        return new ArrayList<>();
    }


    @Override
    public void modifyQuestionParameters() {
        this.responseLimit = consoleInputDriver.getIntegerInput("Enter new response limit: ");
    }

    @Override
    public void displayResponse() {
        consoleOutputDriver.printLines(this.getResponseList());
    }

    public int getResponseLimit(){
        return this.responseLimit;
    }
}
