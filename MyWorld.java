import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World
 * 
 * @author (Erick) 
 * @version 12/21/2022)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */


    public MyWorld()
    {    
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1, false);

        
        Player player = new Player();
        addObject(player, 100 ,520);

        groundAndObstcales();


    }
    private void groundAndObstcales()
    {
        for (int x = 61; x <= 4000; x += 127)
        {
            
            {
                addObject( new Ground1(), x, 673);
            
            }
        }
    }
}