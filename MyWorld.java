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


        Ground1 ground1F = new Ground1();
        addObject(ground1F,823,673);



        Crate crate = new Crate();
        addObject(crate,467,565);
        crate.setLocation(473,568);
        Crate crate2 = new Crate();
        addObject(crate2,466,482);
        crate2.setLocation(469,495);
        Crate crate3 = new Crate();
        addObject(crate3,350,556);
        crate3.setLocation(392,571);
    }

}


