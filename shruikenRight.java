import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shruikenRight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shruikenRight extends Actor
{
    /**
     * Act - do whatever the shruikenRight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int SPEED = 15;
    public void act() 
    {
       move(SPEED);

       if (isTouching(Enemy2.class))
       {
           removeTouching(Enemy2.class);
           getWorld().removeObject(this);
       }
       else if (isTouching(Enemy1.class))
       {
           removeTouching(Enemy1.class);
           getWorld().removeObject(this);
       }
       else if (isAtEdge())
       {
           getWorld().removeObject(this); 
       }
       else if (isTouching(Platform2.class))
       {
           getWorld().removeObject(this);
       }
    }  
}
