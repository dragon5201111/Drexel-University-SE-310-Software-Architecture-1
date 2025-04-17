import java.io.Serializable;

public class ShortAnswer extends Essay implements Serializable {
    private static final long serialVersionUID = 1L;

    public ShortAnswer(String prompt, int wordLimit) {
        super(prompt, wordLimit);
    }

    @Override
    public void answerQuestion() {
        this.displayQuestion();

        while(true){
            String response = this.consoleInputDriver.getStringInput(": ");

            if(response.length() <= this.getResponseLimit()){
                this.addResponse(response);
                break;
            }

            this.consoleOutputDriver.println("Response exceeds the limit of " + this.getResponseLimit() + " characters.");
        }
    }

    @Override
    public void displayResponse() {
        this.consoleOutputDriver.println(this.getFirstResponse());
    }
}
