import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelComplete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelComplete extends OBJECTS
{
    /**
     * Act - do whatever the LevelComplete wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public LevelComplete()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/2;
        int myNewWidth = (int)myImage.getWidth()/2;
        myImage.scale(myNewWidth, myNewHeight);
    }
}
