/*
 * GUIManager:
 * Defines Graphical User Interface interactions with user
 * Implements all methods in UserInterface
 */

package userInterface;

import gui.*;

public class GUIManager implements UserInterface
{
    GamePane gamePane;
    
    public GUIManager()
    {
        gamePane = new GamePane();
    }
}