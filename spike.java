import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class spike extends OBSTACLES
{
    public spike()
    {
        //This method makes the spike image smaller
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/4;
        int myNewWidth = (int)myImage.getWidth()/4;
        myImage.scale(myNewWidth, myNewHeight);
    }
    
    public void act() 
    {
        scrollingMethods(); //Calls the scrollingMethods() method
    }
}
