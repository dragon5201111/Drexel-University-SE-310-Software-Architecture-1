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
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
		return new Maze();
	}

	public static void main(String[] args)
	{
		Maze maze = createMaze();
	    MazeViewer viewer = new MazeViewer(maze);
	    viewer.run();
	}
}
