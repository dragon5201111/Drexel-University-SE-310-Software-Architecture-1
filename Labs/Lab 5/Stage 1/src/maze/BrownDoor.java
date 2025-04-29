package maze;

import java.awt.*;

public class BrownDoor extends Door {
    public BrownDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public Color getColor() {
        return new Color(75, 55, 29);
    }
}
