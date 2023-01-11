import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int vSpeed;
    public int gravity = 2;
    
    public boolean jumping;
    public int jumpStrength = 20;
    
    public Player()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() - 425, image.getHeight() - 525);
        setImage(image);    
    }
    
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        
        checkFall();
        checkKeys();
        
        
        
    }
    
    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("z") && jumping == false)
        {
            jump();
        }
        
    }
    
    public void checkFall()
    {
        if(onGround() == true)
        vSpeed= 0;
        else
        fall();
    }
    
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        
        if(vSpeed <=12 ) 
        vSpeed = vSpeed + gravity;  
        
        jumping = true;
    }
        
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int lookForGround = spriteHeight/2;
        
        Actor ground = getOneObjectAtOffset(0, lookForGround, Ground1.class);
        if(ground == null)
        {
            jumping = true;
            return false;
        }
        else    
        {
            moveToGround(ground);
            return true;
        }
    }
    
    public void moveToGround(Actor ground1)
    {
        int ground1Height = ground1.getImage().getHeight();
        int newY = ground1.getY() - (ground1Height + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
        
        jumping = false;
    }
    
    public void jump()
    {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
        
    }
    

}
