package Menu.Survey;

public interface Menu {
    void start();
    void addMenuOption(int position, SurveyMenuOption menuOption);
    SurveyMenuOption getMenuOption(int position);
}
