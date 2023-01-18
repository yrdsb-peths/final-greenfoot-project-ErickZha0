import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scroller extends Actor
{
    public static int scrollX; 

    public Scroller()
    {
        scrollX = 0; 
    }

    public void setLocation()
    {
        setLocation(getX() + scrollX, getY()); 
    }

    public void checkKeyPress(int amount)
    {
        //This method makes the screen scroll when a movement key is pressed
        if(Greenfoot.isKeyDown("left") &! Greenfoot.isKeyDown("right"))
        {
            scrollX = amount;
        }
        else if(Greenfoot.isKeyDown("right") &! Greenfoot.isKeyDown("left"))
        {
            scrollX = -amount;
        }
        else
        {
            stopScroll(); 
        }
    }

    public void scrollingMethods()
    {
        checkKeyPress(10); 
        setLocation(); 
    }

    public static void stopScroll()
    {
        scrollX = 0; 
    }
}
