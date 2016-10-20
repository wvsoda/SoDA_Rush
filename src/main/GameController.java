/*
 *  GameController: 
 *  Directs the entire game logic
 *  Interfaces with the User via UserInterface
 */

package main;

import javax.swing.Timer;

import entity.Player;
import userInterface.GUIManager;
import userInterface.UserInterface;

public class GameController
{
    private UserInterface userInterface;

    private Player player;

    public GameController()
    {
        userInterface = new GUIManager();
        userInterface.initGameControllerFromInstance(this);

        player = new Player(300, 300);

        Timer gameTimer = userInterface.initGameTimer();
        gameTimer.start();
    }

    // Called continuously by the GamePane (keeps track of timing)
    public void play()
    {

    }

    public double getPlayerAngle()
    {
        return player.getAngle();
    }

    public void updatePlayerDirection(char direction)
    {
        player.setRotationDirection(direction);
        player.move();
    }
}