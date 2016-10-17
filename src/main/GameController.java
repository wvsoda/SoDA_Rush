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
    private UserInterface userInterface;

    private double playerAngle;

    public void play()
    {
        playerAngle = 0;

        userInterface = new GUIManager();
        userInterface.initGameControllerFromInstance(this);
        Timer gameTimer = userInterface.initGameTimer();
        gameTimer.start();
    }

    public double getPlayerAngle()
    {
        return playerAngle;
    }

    public void updatePlayerAngle(double newAngle)
    {
        playerAngle = newAngle;
    }
}
