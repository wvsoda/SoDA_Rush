/*
 * UserInterface:
 * Outlines and handles all interactions with user 
 * (receiving input, displaying info etc)
 * 
 * Implemented by CLIManager (Command Line Interface) for testing
 * Implemented by GUIManager (Graphical User Interface) for release
 */

package userInterface;

import javax.swing.Timer;

public interface UserInterface
{

    Timer initGameTimer();
    // Methods that interface with the user go here
    // eg: int getNumPlayers();
    // eg: void warnLoserPlayer(Player p);
}
