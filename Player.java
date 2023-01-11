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
    GreenfootImage[] runRight= new GreenfootImage[9];
    GreenfootImage[] runLeft= new GreenfootImage[9];
    GreenfootImage[] idleRight= new GreenfootImage[9];
    GreenfootImage[] idleLeft= new GreenfootImage[9];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Player()
    {
        for(int i = 0; i < 9; i++)
        {
            runRight[i] = new GreenfootImage("images/freeknight/png/Run0"  + i +  ".png");
            runRight[i].scale(150, 150);
            
        }
        
        for(int i = 0; i < runLeft.length; i ++)
        {
            runLeft[i] = new GreenfootImage("images/freeknight/png/Run0" + i + ".png");    
            runLeft[i].mirrorHorizontally();
            runLeft[i].scale(150, 150);   
        }
        
        
        
        animationTimer.mark();
        
        setImage(runRight[0]);
    }
    
    public void idle()
    {
        
        for(int i = 0; i < 9; i++)
        {
            runRight[i] = new GreenfootImage("images/freeknight/png/Idle0"  + i +  ".png");
            runRight[i].scale(150, 150);
            
        }
        
        for(int i = 0; i < idleLeft.length; i ++)
        {
            runLeft[i] = new GreenfootImage("images/freeknight/png/Idle0" + i + ".png");    
            runLeft[i].mirrorHorizontally();
            runLeft[i].scale(150, 150);   
        }
        
        
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
    
    }
    int imageIndex = 0;
    public void runPlayer()
    {
        //Player animations
        if(animationTimer.millisElapsed() < 40)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(runRight[imageIndex]);
            imageIndex = (imageIndex + 1) % runRight.length;    
        }
        else
        {
            setImage(runLeft[imageIndex]);
            imageIndex= (imageIndex + 1) % runLeft.length;
        }
        
    }
    
    public void idlePlayer()
    {
        //Player animations
        if(animationTimer.millisElapsed() < 40)
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
            move(-4);
            facing = "left";
            runPlayer();            
        } 
        else if(Greenfoot.isKeyDown("right"))
        {
            move(4);
            facing = "right";
            runPlayer();   
            
            
        }
        

        
        
    }    
}
