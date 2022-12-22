import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] run = new GreenfootImage[10];
    
    public Player()
    {
        for(int i = 1; i < 10; i++)
        {
            run[i] = new GreenfootImage("images/freeknight/png/Run" + "(" + i + ")" + ".png");
            
        }
        setImage(run[0]);
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            
        } 
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            
        }
        
        
    }    
}
