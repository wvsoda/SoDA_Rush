package entity;

public class Bullet extends Entity
{

    public Bullet(double playerAngle)
    {
        xCoord = 300;
        yCoord = 300;
        angle = playerAngle - 1.5708; //to make it so that pencils come out of claws
        hitBoxRadius = 40; //Not sure that hitBoxRadius is in pixels, but if it is then this would be correct.
    }

    public void move()
    {
        yCoord += Math.sin(angle) * 6;
        xCoord += Math.cos(angle) * 6;
    }

}
