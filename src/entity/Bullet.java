package entity;

public class Bullet extends Entity
{

    public Bullet(double playerAngle)
    {
        xCoord = 300;
        yCoord = 300;
        angle = playerAngle;
    }

    public void move()
    {
        yCoord += Math.sin(angle) * 1;
        xCoord += Math.cos(angle) * 1;
    }

}
