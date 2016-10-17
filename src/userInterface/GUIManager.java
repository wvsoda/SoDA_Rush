/*
 * GUIManager:
 * Defines Graphical User Interface interactions with user
 * Implements all methods in UserInterface
 */

package userInterface;

import javax.swing.Timer;

import gui.*;

public class GUIManager implements UserInterface
{
    GamePane gamePane;
    
    public GUIManager()
    {
        gamePane = new GamePane();
    }

    @Override
    public Timer initGameTimer()
    {
        return new Timer(50, gamePane);
    }
}