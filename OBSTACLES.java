import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class OBSTACLES extends Scroller
{
    public void act() 
    {  
    }    
    
    public boolean byThis(Class clss){
        Actor actor = getOneObjectAtOffset(32, 0, clss);
        return actor != null;     
    }
    
    public boolean byThis2(Class clss){
        Actor actor = getOneObjectAtOffset(-32, 0, clss);
        return actor != null;     
    }
    
    public boolean hitsThis(Class clss){
        Actor actor = getOneIntersectingObject(clss);
        return actor != null;     
    }
}
