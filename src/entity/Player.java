
package entity;

public class Player extends Entity
{
    char rotationDirection;

    public Player(int x, int y)
    {
        xCoord = 250;
        yCoord = 250;
        hitBoxRadius = 30;
    }

    public void setRotationDirection(char d) // import rotation direction
                                             // variable from GameController
    {
        rotationDirection = d;
    }

    public void move()
    {
        switch (rotationDirection)
        {
            case 'a':
                this.angle -= 0.2;
                break;
            case 'd':
                this.angle += 0.2;
                break;

        }
    }
}
