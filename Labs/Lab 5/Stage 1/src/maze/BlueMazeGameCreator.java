package maze;

public class BlueMazeGameCreator extends MazeGameCreator {
    @Override
    public Wall makeWall(){
        return new BlueWall();
    }

    @Override
    public Door makeDoor(Room roomOne, Room roomTwo){
        return new BrownDoor(roomOne, roomTwo);
    }

    @Override
    public Room makeRoom(int roomNumber){
        return new GreenRoom(roomNumber);
    }
}
