import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scroller extends Actor
{
    public static int scrollX; //The variable used when scrolling.

    public Scroller()
    {
        scrollX = 0; 
    }

    public void setLocation()
    {
        setLocation(getX() + scrollX, getY()); //Whatever direction the sprite is moves, the screen will scroll in that direction
    }

    public void checkKeyPress(int amount)
    {
        //This method makes the screen scroll when a movement key is pressed
        if(Greenfoot.isKeyDown("a") &! Greenfoot.isKeyDown("d"))
        {
            scrollX = amount;
        }
        else if(Greenfoot.isKeyDown("d") &! Greenfoot.isKeyDown("a"))
        {
            scrollX = -amount;
        }
        else
        {
            stopScroll(); //Calls the stopScroll() method
        }
    }

    public void scrollingMethods()
    {
        checkKeyPress(3); //Calls the checkKeyPress() method with an amount of 3
        setLocation(); //Calls the setLocation() method
    }

    public static void stopScroll()
    {
        scrollX = 0; //Sets the scrollX variable to 0
    }
}
