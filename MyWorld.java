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

        prepare();


    }


    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ground1 ground1 = new Ground1();
        addObject(ground1,61,673);

        Ground1 ground1A = new Ground1();
        addObject(ground1A,188,673);

        Ground1 ground1B = new Ground1();
        addObject(ground1B,315,673);

        Ground1 ground1C = new Ground1();
        addObject(ground1C,442,673);

        Ground1 ground1D = new Ground1();
        addObject(ground1D,569,673);

        Ground1 ground1G = new Ground1();
        addObject(ground1G,950,673);
        

        

    }
    

}


