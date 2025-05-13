package Question;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ValidDate extends Question implements Serializable {
    private final static long serialVersionUID = 10L;

    private final String DATE_FORMAT = "MM/dd/yyyy";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    private int responseLimit;

    public ValidDate(String prompt, int responseLimit) {
        super(prompt);
        this.simpleDateFormat.setLenient(false);
        this.responseLimit = responseLimit;
    }

    @Override
    public void displayQuestion() {
        consoleOutputDriver.println(this.getPrompt() + " Please give " + this.responseLimit + " date(s).");
    }


    @Override
    public List<String> tabulateResponses() {
        return this.getResponseFrequenciesList();
    }

    private List<String> collectValidDates() {
        List<String> validDates = new ArrayList<>();

        for (int i = 0; i < this.responseLimit; i++) {
            while (true) {
                String input = consoleInputDriver.getStringInput("(" + (i + 1) + ") Enter a valid date (" + DATE_FORMAT + "): ");
                try {
                    simpleDateFormat.parse(input);
                    validDates.add(input);
                    break;
                } catch (ParseException e) {
                    consoleOutputDriver.println("Invalid date entered. Try again: " + input);
                }
            }
        }

        return validDates;
    }


    @Override
    public void answerQuestionBody() {
        List<String> dates = collectValidDates();
        for (String date : dates) {
            this.addResponse(date);
        }
    }


    @Override
    public List<String> getCorrectAnswers() {
        return collectValidDates();
    }

    @Override
    public void modifyQuestionParameters() {
        this.responseLimit = this.consoleInputDriver.getIntegerInput("Enter the number of max responses to this question: ");
    }

    @Override
    public void displayResponse() {
        List<String> responseList = this.getResponseList();
        this.consoleOutputDriver.printNumberedLines(responseList, responseList.size());
    }
}
