/*
 * CLIManager:
 * Defines Command Line Interface interactions with user
 * Implements all methods in UserInterface
 */

package userInterface;

import javax.swing.Timer;

import main.GameController;

public class CLIManager implements UserInterface
{
    public CLIManager()
    {
        System.out.println("initializing CLI Manager");
    }

    @Override
    public Timer initGameTimer()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void initGameControllerFromInstance(GameController gc)
    {
        // TODO Auto-generated method stub

    }
}
