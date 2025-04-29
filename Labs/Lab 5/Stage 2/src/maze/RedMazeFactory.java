package maze;

public class RedMazeFactory extends MazeFactory {
    @Override
    public Wall makeWall() {
        return new RedWall();
    }

    @Override
    public Door makeDoor(Room roomOne, Room roomTwo) {
        return new Door(roomOne, roomTwo);
    }

    @Override
    public Room makeRoom(int roomNumber) {
        return new PinkRoom(roomNumber);
    }
}
