import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shruikenLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shruikenLeft extends Actor
{
    private int frame = 1;
    int SPEED = -15;
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
    
    

