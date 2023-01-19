import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class OBJECTS extends Scroller
{
    public void act() 
    {
        scrollingMethods();
    }    
    
    public boolean canSee(Class clss)
    {
        Actor actor = getOneIntersectingObject(clss);
        return actor != null;     
    }   
}
