public class Client {
    public static void main(String[] args) {
        EditorHistory history = new EditorHistory();
        Editor editor = new Editor();
        // Observe editor to keep track of history automatically
        editor.registerObserver(history);

        editor.write("Foo ");
        editor.write("Bar");
        editor.write(". I am going to sleep.");

        // Restore to first write
        editor.restoreMemento(history.getMemento(0));
        System.out.println(editor.getContent());

        // Restore to last
        editor.restoreMemento(history.getLastMemento());
        System.out.println(editor.getContent());

        editor.clear();
        history.popMemento();
        editor.restoreMemento(history.popMemento());
        System.out.println(editor.getContent());

    }
}
