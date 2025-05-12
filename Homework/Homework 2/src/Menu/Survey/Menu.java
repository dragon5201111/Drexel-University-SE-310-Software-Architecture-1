package Menu.Survey;

public interface Menu {
    void start();
    void addMenuOption(int position, SurveyMenuOption menuOption);
    void setMenuOption(int position, SurveyMenuOption menuOption);
}
