
package entity;

import java.util.Random;

public abstract class Enemy extends Entity
{

    public Enemy(int xCoord, int yCoord, String image)
    {
        super(xCoord, yCoord, image);
        Random barrier = new Random(3);
        Random r = new Random(600);
        
        
        if(barrier.nextInt() == 0)
        {
            xCoord = r.nextInt();
            yCoord = 0;
            
        }
        if(barrier.nextInt() == 1)
        {
            xCoord = 600;
            yCoord = r.nextInt();
        }
        if(barrier.nextInt() == 2)
        {
            xCoord = r.nextInt();
            yCoord = 600;
        }
        if(barrier.nextInt() == 3)
        {
            xCoord = 0;
            yCoord = r.nextInt();
        }
        slope = (yCoord - 300) / (xCoord - 300);
        angle = Math.atan(slope);
    }
    
    public void move()
    {
        yCoord += Math.sin(angle) * 10;
        xCoord += Math.cos(angle) * 10;
        
    }
}
