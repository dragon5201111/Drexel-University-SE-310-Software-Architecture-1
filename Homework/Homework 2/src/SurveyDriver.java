public class SurveyDriver {
    public static void main(String[] args) {
        System.out.println("Question Test:");
        Question question = new ShortAnswer("Enter two letter word.", 2);

        System.out.println("Displaying:");
        question.displayQuestion();
        System.out.println();

        System.out.println("Modifying:");
        question.modifyQuestion();
        System.out.println();

        System.out.println("Answering:");
        question.answerQuestion();
        System.out.println();

        System.out.println("Displaying Response:");
        question.displayResponse();
        System.out.println();

    }
}
