/*
 * SimpleMazeGame.java
 * Copyright (c) 2008, Drexel University.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Drexel University nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY DREXEL UNIVERSITY ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL DREXEL UNIVERSITY BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package maze;

import maze.ui.MazeViewer;
import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * @author Sunny
 * @version 1.0
 * @since 1.0
 */
public class SimpleMazeGame
{
	/**
	 * Creates a small maze.
	 */

	public static Maze createMaze()
	{
		Maze maze = new Maze();

		Room roomOne = new Room(0);
		Room roomTwo = new Room(1);
		Door door = new Door(roomOne, roomTwo);

		roomOne.setSide(Direction.North, new Wall());
		roomOne.setSide(Direction.South, new Wall());
		roomOne.setSide(Direction.East, door);
		roomOne.setSide(Direction.West, new Wall());

		roomTwo.setSide(Direction.North, new Wall());
		roomTwo.setSide(Direction.South, new Wall());
		roomTwo.setSide(Direction.East, new Wall());
		roomTwo.setSide(Direction.West, door);

		maze.setCurrentRoom(roomOne);
		maze.addRoom(roomOne);
		maze.addRoom(roomTwo);

		return maze;
	}

	public static Maze loadMaze(final String path)
	{
		Maze newMaze = new Maze();

		try {
			File mazeFile = new File(path);

			Map<Integer, Room> rooms = new HashMap<>();
			Map<String, Door> doors = new HashMap<>();

			List<String> fileLines = Files.readAllLines(mazeFile.toPath());
			// Create tokens for easier parsing
			List<String[]> tokenizedLines = fileLines
					.stream()
					.map(line -> line.strip().replaceAll("\\s++", " ").split(" "))
					.collect(Collectors.toList());

			// Add rooms first
			for(String[] lineTokens : tokenizedLines){
				String objectName = lineTokens[0];

				if(objectName.equalsIgnoreCase("room")){
					int roomNumber = Integer.parseInt(lineTokens[1]);
					Room newRoom = new Room(roomNumber);

					rooms.put(roomNumber, newRoom);

					newMaze.addRoom(newRoom);
				}
			}

			// Add doors next
			for(String[] lineTokens : tokenizedLines){
				String objectName = lineTokens[0];

				if(objectName.equalsIgnoreCase("door")){
					String doorIdentifier = lineTokens[1];
					int roomOneNumber = Integer.parseInt(lineTokens[2]);
					int roomTwoNumber = Integer.parseInt(lineTokens[3]);

					boolean isOpen = lineTokens[4].equalsIgnoreCase("open");

					Room roomOne = rooms.get(roomOneNumber);
					Room roomTwo = rooms.get(roomTwoNumber);

					Door door = new Door(roomOne, roomTwo);
					door.setOpen(isOpen);

					doors.put(doorIdentifier, door);
				}
			}

			// We now can add sides to rooms now that all doors have been identified & stored in map
			for(String[] lineTokens : tokenizedLines){
				String objectName = lineTokens[0];

				if(objectName.equalsIgnoreCase("room")){
					int roomNumber = Integer.parseInt(lineTokens[1]);
					Room room = rooms.get(roomNumber);

					for(int i = 0; i < 4; i++){
						Direction direction = Direction.values()[i];

						String objectIdentifier = lineTokens[2+i];

						MapSite site;
						if(objectIdentifier.equalsIgnoreCase("wall")){
							site = new Wall();
						}else if(objectIdentifier.startsWith("d")){
							site = doors.get(objectIdentifier);
						}else{
							// Is a room or invalid objectIdentifier
							int doorNumber = Integer.parseInt(objectIdentifier);
							site = rooms.get(doorNumber);
						}

						room.setSide(direction, site);
					}
				}
			}

			// Set current room to the first room in list
			newMaze.setCurrentRoom(rooms.get(0));

		} catch (Exception e) {
            throw new RuntimeException(e);
        }

        return newMaze;
	}

	public static void main(String[] args)
	{
		Maze maze;

		String largeMazePath = "large.maze";
		File largeMazeFile = new File(largeMazePath);
		if(largeMazeFile.exists()){
			maze = loadMaze(largeMazePath);
		}else{
			maze = createMaze();
		}

		MazeViewer viewer = new MazeViewer(maze);
	    viewer.run();
	}
}
