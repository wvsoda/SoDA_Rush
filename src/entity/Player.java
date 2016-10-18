
package entity;

public class Player extends Entity
{
    char rotationDirection;
    
    public Player(int x, int y)
    {
        super(300, 300);
    }
    
    public void sendRotationDirection(char d)
    {
        rotationDirection = d;
    }
    
    public void move()
    {
        switch(rotationDirection)
        {
            case 'a':
                this.angle += 2.0;
                break;
            case 'd':
                this.angle -= 2.0;
                break;          
                
        }
    }
}
