import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class portal extends OBJECTS
{
    public void act() 
    {
        scrollingMethods(); //Calls the scrollingMethods() method
    }
    
    public portal() 
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/4;
        int myNewWidth = (int)myImage.getWidth()/4;
        myImage.scale(myNewWidth, myNewHeight);
        
    }
}
