/*
 * UserInterface:
 * Outlines and handles all interactions with user 
 * (receiving input, displaying info etc)
 * 
 * Implemented by CLIManager (Command Line Interface) for testing
 * Implemented by GUIManager (Graphical User Interface) for release
 */

package userInterface;

import java.util.Set;

import javax.swing.Timer;

import entity.Enemy;
import entity.Bullet;
import main.GameController;

public interface UserInterface
{
    Timer initGameTimer();

    // Passes significant references of GameController to UserInterface
    void initReferencesToGameController(GameController gc, Set<Enemy> enems, Set<Bullet> bullets);
}
