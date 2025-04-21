package Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Menu {
    private final List<MenuOption> menuOptions;

    public Menu() {
        this.menuOptions = new ArrayList<MenuOption>();
        // Adds corresponding menu options
        this.initializeOptions();
    }

    protected abstract void displayMainMenu();
    protected abstract void initializeOptions();
    public abstract void start();

    protected List<String> getMenuOptionLabels() {
        return this.getMenuOptions()
                .stream()
                .map(option -> option.getOptionLabel())
                .collect(Collectors.toList());
    }

    protected void addMenuOption(MenuOption menuOption) {
        this.menuOptions.add(menuOption);
    }

    protected MenuOption getMenuOption(int index) {
        return this.menuOptions.get(index);
    }

    protected int getMenuOptionSize(){
        return this.menuOptions.size();
    }

    protected List<MenuOption> getMenuOptions() {
        return this.menuOptions;
    }

}
