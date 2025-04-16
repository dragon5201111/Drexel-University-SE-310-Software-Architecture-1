import java.io.Serializable;

public class Essay extends Question implements Serializable {
    private static final long serialVersionUID = 1L;
    private int responseLimit;

    public Essay(String prompt, int responseLimit) {
        super(prompt);
        this.responseLimit = responseLimit;
    }


    @Override
    public void displayQuestion() {
        this.consoleOutputDriver.println(this.getPrompt());
    }

    @Override
    public void answerQuestion() {
        this.displayQuestion();

        for(int i = 1; i <= this.responseLimit; i++){
            String response = this.consoleInputDriver.getStringInput(i + ": ");
            this.addResponse(response);
        }
    }

    @Override
    public void modifyQuestionParameters() {
        this.responseLimit = consoleInputDriver.getIntegerInput("Enter new response limit: ");
    }

    @Override
    public void displayResponse() {
        for(String response: this.getResponseList()){
            this.consoleOutputDriver.println(response);
        }
    }

    public int getResponseLimit(){
        return this.responseLimit;
    }
}
