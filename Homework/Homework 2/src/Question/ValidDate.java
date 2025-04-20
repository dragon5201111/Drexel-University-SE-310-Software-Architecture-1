package Question;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidDate extends Question implements Serializable {
    @Serial
    private final static long serialVersionUID = 10L;

    private final String DATE_FORMAT = "MM/dd/yyyy";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    public ValidDate(String prompt) {
        super(prompt);
        simpleDateFormat.setLenient(false);
    }

    @Override
    public void displayQuestion() {
        consoleOutputDriver.println(this.getPrompt());
    }

    @Override
    public void answerQuestionBody() {
        String validDate;

        while(true){

            validDate = consoleInputDriver.getStringInput("Enter a valid date (" + DATE_FORMAT + "): ");

            try{
                simpleDateFormat.parse(validDate);
                break;
            } catch (ParseException e) {
                consoleOutputDriver.println("Invalid date entered. Try again: " + validDate);
            }
        }

        this.addResponse(validDate);
    }


    @Override
    public void modifyQuestionParameters() {
    }

    @Override
    public void displayResponse() {
        consoleOutputDriver.println(this.getFirstResponse());
    }
}
