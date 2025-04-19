package Menu;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    private final List<MenuOption> menuOptions;

    public Menu() {
        this.menuOptions = new ArrayList<MenuOption>();
        // Adds corresponding menu options
        this.initializeOptions();
    }

    public abstract void displayMainMenu();
    public abstract void start();
    public abstract void initializeOptions();

    public void addMenuOption(MenuOption menuOption) {
        this.menuOptions.add(menuOption);
    }

    public MenuOption getMenuOption(int index) {
        return this.menuOptions.get(index);
    }

    public int getMenuOptionSize(){
        return this.menuOptions.size();
    }

    public List<MenuOption> getMenuOptions() {
        return this.menuOptions;
    }

}
