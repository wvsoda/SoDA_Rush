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
import entity.Bullet;
import entity.CollisionDetection;
import userInterface.GUIManager;
import userInterface.UserInterface;

public class GameController
{
    private UserInterface userInterface;

    private Player player;
    private Set<Enemy> enemies;
    private Set<Bullet> bullets;

    public GameController()
    {
        userInterface = new GUIManager();
        enemies = new HashSet<Enemy>();
        bullets = new HashSet<Bullet>();

        userInterface.initReferencesToGameController(this, enemies);

        player = new Player(300, 300);

        Timer gameTimer = userInterface.initGameTimer();
        gameTimer.start();

        enemies.add(new MCEnemy());
        enemies.add(new MCEnemy());
        enemies.add(new MCEnemy());
        enemies.add(new MCEnemy());
        bullets.add(new Bullet(player.getAngle()));
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
                System.out.println("end game");
            }
        }
        for (Bullet bullet : bullets)
        {
            bullet.move();
            for (Enemy enemy : enemies)
            {
                if(bulletCollisionWithEnemy(enemy, bullet))
                {
                    //TODO kill the enemy and the bullet
                    System.out.println("kill enemy");
                }
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
        return CollisionDetection.entitiesAreColliding(player, enemy);
    }

    private boolean bulletCollisionWithEnemy(Enemy enemy, Bullet bullet)
    {
        return CollisionDetection.entitiesAreColliding(enemy, bullet);
    }
    
    public void shootBullet(){
        bullets.add(new Bullet(player.getAngle()));
    }
}