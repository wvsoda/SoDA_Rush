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
import main.GameController;

public interface UserInterface
{

    // Methods that interface with the user go here
    // eg: int getNumPlayers();
    // eg: void warnLoserPlayer(Player p);

    // Init Methods
    Timer initGameTimer();

    void initGameControllerFromInstance(GameController gc, Set<Enemy> enems);

    void updateEnemyGraphics(Set<Enemy> enemies);
}
