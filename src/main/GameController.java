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
    private int timer;
    private int diff;
    private int score;

    
    public GameController()
    {
        score = 0;
        userInterface = new GUIManager();
        enemies = new HashSet<Enemy>();
        bullets = new HashSet<Bullet>();

        userInterface.initReferencesToGameController(this, enemies, bullets);

        player = new Player(300, 300);

        Timer gameTimer = userInterface.initGameTimer();
        gameTimer.start();

        enemies.add(new MCEnemy());
        enemies.add(new MCEnemy());
        enemies.add(new MCEnemy());
        enemies.add(new MCEnemy());
        timer = 0;
        diff = 100;
        //bullets.add(new Bullet(player.getAngle()));
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
                //System.out.println("end game");
                
                userInterface.getThis().setVisible(false);
                userInterface.getThis().dispose();
                userInterface.endGame(score);
                System.exit(1);
                
            }
        }
        for (Bullet bullet : bullets)
        {
            bullet.move();
            for (Enemy enemy : enemies)
            {
                if(bulletCollisionWithEnemy(enemy, bullet))
                {
                    enemy.kill();
                    bullet.kill();
                    //System.out.println("kill enemy");
                }
            }
            bulletsOffScreen(bullet);
            
        }
        
        removeKilled();
        if(timer!=0 && timer%diff==0)
        {
            enemies.add(new MCEnemy());
        }
        timer++;
        if(timer!=0 && timer%200==0 && diff>10){
            diff -= 10;
        }
        System.out.println("Score: " +score);
    }
    
    public void removeKilled()
    {
        for(Enemy e : enemies)
        {
            if(e.isKilled())
            {
                enemies.remove(e);
                score++;
            }
        }
        for(Bullet b : bullets)
        {
            if(b.isKilled())
                bullets.remove(b);
        }
    }
    
    public void bulletsOffScreen(Bullet b)
    {
        if (
                b.getX()<0 || 
                b.getX()>600 ||
                b.getY()<0 ||
                b.getY()>600
                
                )
            b.kill();
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
        return CollisionDetection.entitiesAreColliding(bullet, enemy);
    }
    
    public void shootBullet(){
        bullets.add(new Bullet(player.getAngle()));
    }
    
}