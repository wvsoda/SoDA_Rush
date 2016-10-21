/*
 *  GameController: 
 *  Directs the entire game logic
 *  Interfaces with the User via UserInterface
 */

package main;

import java.util.HashSet;
import java.util.Set;

import javax.swing.Timer;

import entity.Enemy;
import entity.MCEnemy;
import entity.Player;
import userInterface.GUIManager;
import userInterface.UserInterface;

public class GameController
{
    private UserInterface userInterface;

    private Player player;
    private Set<Enemy> enemies;

    public GameController()
    {
        userInterface = new GUIManager();
        enemies = new HashSet<Enemy>();

        userInterface.initReferencesToGameController(this, enemies);

        player = new Player(300, 300);

        Timer gameTimer = userInterface.initGameTimer();
        gameTimer.start();

        enemies.add(new MCEnemy());
        enemies.add(new MCEnemy());
        enemies.add(new MCEnemy());
        enemies.add(new MCEnemy());
    }

    // Called continuously by the GamePane (keeps track of timing)
    public void play()
    {
        for (Enemy enemy : enemies)
        {
            enemy.move();
            if(enemyCollisionWithPlayer(enemy))
            {
                // TODO end game
            }
        }
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

    private boolean enemyCollisionWithPlayer(Enemy enemy)
    {
        // TODO make collision detection
        return false;
    }
}