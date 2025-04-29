package maze;

import maze.ui.MazeViewer;

import java.io.File;
import java.util.Scanner;

public class MazeGameDriver {
    public static String filePath;

    public static void main(String[] args)
    {
        MazeFactory mazeFactory;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a maze type:\n1.) red\n2.) blue");

        while (true){
            System.out.print("Enter red or blue: ");
            String mazeType = scanner.nextLine();

            if(mazeType.equalsIgnoreCase("red")){
                mazeFactory = new RedMazeFactory();
                break;
            }else if(mazeType.equalsIgnoreCase("blue")){
                mazeFactory = new BlueMazeFactory();
                break;
            }

            System.out.println("Invalid maze type.");
        }

        Maze maze;

        MazeGameDriver.filePath = "large.maze";
        File largeMazeFile = new File(MazeGameDriver.filePath);
        if(largeMazeFile.exists()){
            maze = MazeGameDriver.loadMaze(MazeGameDriver.filePath, mazeFactory);
        }else{
            maze = mazeFactory.createMaze();
        }

        MazeViewer viewer = new MazeViewer(maze);
        viewer.run();
    }

    public static Maze loadMaze(String filename, MazeFactory mazeFactory) {
        return mazeFactory.loadMaze(filename);
    }
}
