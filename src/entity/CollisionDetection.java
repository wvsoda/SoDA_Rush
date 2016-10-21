/*
 *  CollisionDetection:
 *  Static class that performs collision calculations w/ various entities
 */

package entity;

public class CollisionDetection
{
    // Private constructor ensures that this class can't be instantiated
    private CollisionDetection() {}
    
    // Detects if 2 entities are colliding (Using circular hitboxes)
    public static boolean entitiesAreColliding(Entity e1, Entity e2)
    {
        double radius1 = e1.getHitBoxRadius();
        double radius2 = e2.getHitBoxRadius();

        double xDif = e1.getX() - e2.getX();
        double yDif = e1.getY() - e2.getY();
        double distanceSquared = xDif * xDif + yDif * yDif;

        return distanceSquared < (radius1 + radius2) * (radius1 + radius2);
    }
}