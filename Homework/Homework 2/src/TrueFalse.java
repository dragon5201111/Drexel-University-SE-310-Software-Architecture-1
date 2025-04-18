import java.io.Serializable;

public class TrueFalse extends Question implements Serializable {
    private final String TRUE = "T";
    private final String FALSE = "F";

    private static final long serialVersionUID = 1L;

    public TrueFalse(String prompt) {
        super(prompt);
    }

    @Override
    public void displayQuestion() {
        this.consoleOutputDriver.println(this.getPrompt());
    }

    private boolean isTrueOrFalse(String string){
        return string.equalsIgnoreCase(TRUE) || string.equalsIgnoreCase(FALSE);
    }

    @Override
    public void answerQuestion() {
        this.displayQuestion();

        while(true){
            String response = consoleInputDriver.getStringInput(TRUE + "/" + FALSE + ": ");

            if(isTrueOrFalse(response)){
                this.addResponse(response);
                break;
            }

            consoleOutputDriver.println("Invalid answer. Must be " + TRUE + "/" + FALSE + ".");
        }
    }

    @Override
    public void modifyQuestionParameters() {
    }

    @Override
    public void displayResponse() {
        this.consoleOutputDriver.println(this.getFirstResponse());
    }
}
