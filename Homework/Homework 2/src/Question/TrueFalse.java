package Question;

import java.io.Serial;
import java.io.Serializable;

public class TrueFalse extends Question implements Serializable {
    @Serial
    private final static long serialVersionUID = 9L;

    private final String TRUE = "T";
    private final String FALSE = "F";

    public TrueFalse(String prompt) {
        super(prompt);
    }

    @Override
    public void displayQuestion() {
        this.consoleOutputDriver.println(this.getPrompt());
    }

    @Override
    public void answerQuestionBody() {
        while(true){
            String response = consoleInputDriver.getStringInput(TRUE + "/" + FALSE + ": ");

            if(isTrueOrFalse(response)){
                this.addResponse(response);
                break;
            }

            consoleOutputDriver.println("Invalid answer. Must be " + TRUE + "/" + FALSE + ".");
        }
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
