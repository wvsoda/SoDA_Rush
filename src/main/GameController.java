/*
 *  GameController: 
 *  Directs the entire game logic
 *  Interfaces with the User via UserInterface
 */

package main;

import javax.swing.Timer;

import userInterface.*;

public class GameController
{
    private static UserInterface userInterface;

    public void play()
    {
        userInterface = new GUIManager();
        Timer gameTimer = userInterface.initGameTimer();
        gameTimer.start();
    }

    // TODO: Add game turn methods
}
