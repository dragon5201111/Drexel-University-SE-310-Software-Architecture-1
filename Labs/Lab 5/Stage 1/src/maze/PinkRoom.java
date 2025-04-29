package maze;

import java.awt.*;

public class PinkRoom extends Room {
    public PinkRoom(int num) {
        super(num);
    }

    @Override
    public Color getColor() {
        return new Color(228, 71, 171);
    }
}
