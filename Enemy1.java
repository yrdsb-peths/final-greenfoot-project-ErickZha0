import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends OBSTACLES
{
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int movingCounter = 0;
    
    public void act() 
    {
        scrollingMethods(); 
        
        // the Enemy object move from right to left then left to right
        if (movingCounter < 100) {
            setLocation(getX() + 3, getY()); 
        }
        else if (movingCounter < 200) {
            setLocation(getX() - 3, getY());
        }
        else {
            movingCounter = 0;
        }
        movingCounter++; 
    }
    
    public Enemy1()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/6;
        int myNewWidth = (int)myImage.getWidth()/6;
        myImage.scale(myNewWidth, myNewHeight);
        
        
    }
}
