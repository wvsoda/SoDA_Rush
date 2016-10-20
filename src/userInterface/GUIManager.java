/*
 * GUIManager:
 * Defines Graphical User Interface interactions with user
 * Implements all methods in UserInterface
 */

package userInterface;

import java.util.Set;

import javax.swing.Timer;

import entity.Enemy;
import gui.GamePane;
import main.GameController;

public class GUIManager implements UserInterface
{
    GamePane gamePane;

    public GUIManager()
    {
        gamePane = new GamePane();
    }

    ////////////////////////////////////////////////////////////
    // Init Methods
    ////////////////////////////////////////////////////////////

    @Override
    public Timer initGameTimer()
    {
        return new Timer(50, gamePane);
    }

    @Override
    public void initReferencesToGameController(GameController gc, Set<Enemy> enems)
    {
        gamePane.initReferencesToGameController(gc, enems);
    }
}