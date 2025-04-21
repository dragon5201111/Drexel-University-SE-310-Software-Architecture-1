package Question;

import java.util.ArrayList;
import java.util.List;

public enum QuestionType {
    // Value must be in increasing in increments of one
    TRUE_FALSE(1, "True/False"),
    MULTIPLE_CHOICE(2, "Multiple Choice"),
    SHORT_ANSWER(3, "Short Answer"),
    ESSAY(4, "Essay"),
    VALID_DATE(5, "Valid Date"),
    MATCHING(6, "Matching");

    private final int value;
    private final String displayName;

    QuestionType(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static List<String> getDisplayNames() {
        List<String> displayNames = new ArrayList<>();

        for (QuestionType questionType : QuestionType.values()) {
            displayNames.add(questionType.getDisplayName());
        }

        return displayNames;
    }

    public static QuestionType fromValue(int value) {
        for (QuestionType type : QuestionType.values()) {
            if (type.value == value) {
                return type;
            }
        }

        // Default is to return true false
        return TRUE_FALSE;
    }
}
