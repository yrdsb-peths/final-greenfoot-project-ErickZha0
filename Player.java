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
    GreenfootImage[] idleRight= new GreenfootImage[9];
    GreenfootImage[] idleLeft= new GreenfootImage[9];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Player()
    {
        for(int i = 0; i < 9; i++)
        {
            idleRight[i] = new GreenfootImage("images/freeknight/png/Idle0"  + i +  ".png");
            idleRight[i].scale(150, 150);
            
        }
        
        for(int i = 0; i < idleLeft.length; i ++)
        {
            idleLeft[i] = new GreenfootImage("images/freeknight/png/Idle0" + i + ".png");    
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(150, 150);   
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
        
    }
    int imageIndex = 0;
    public void animateElephant()
    {
        //elephant animations
        if(animationTimer.millisElapsed() < 300)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;    
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex= (imageIndex + 1) % idleLeft.length;
        }
        
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "left";
        } 
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
            
        }
        
        animateElephant();
    }    
}
