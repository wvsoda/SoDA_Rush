
package entity;

public class Enemy extends Entity
{
    int type;
    public Enemy()
    {
        type = (int)(Math.random()*3);
        int barrier = (int) (Math.random() * 4);
        int r = (int) (Math.random() * 600);

        switch (barrier)
        {
            case 0:
                xCoord = r;
                yCoord = 0;
                break;
            case 1:
                xCoord = 600;
                yCoord = r;
                break;
            case 2:
                xCoord = r;
                yCoord = 600;
                break;
            case 3:
                xCoord = 0;
                yCoord = r;
                break;
        }
        
        
        angle = Math.atan2((250 - yCoord), (250 - xCoord));
    }

    public void move()
    {
        yCoord += Math.sin(angle) * 1;
        xCoord += Math.cos(angle) * 1;
    }
    
    public int getImage()
    {
       return type;
    }

}
