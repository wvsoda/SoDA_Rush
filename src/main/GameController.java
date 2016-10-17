/*
 *  GameController: 
 *  Directs the entire game logic
 *  Interfaces with the User via UserInterface
 */

package main;

import userInterface.*;

public class GameController
{
    private static UserInterface userInterface;

    public void play()
    {
        userInterface = new GUIManager();
    }

    // TODO: Add game turn methods
}
