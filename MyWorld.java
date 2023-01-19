import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World
 * 
 * @author (Erick) 
 * @version 12/21/2022)
 */
public class MyWorld extends World
{

    private Scroller scroll; 
    score score = new score(); 
    lives lives = new lives(); 
    public MyWorld()
    {    

        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1175, 700, 1, false);

        Player player = new Player();
        addObject(player, 100 ,520);

        groundAndObstcales();

        prepare();
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

    public void worldBGScene()
    {
        //This method sets the background of the world to my chosen background image
        GreenfootImage bg = new GreenfootImage ("BG.png");
    }

    public void scrollSpeed(int amount)
    {
        //This method calls a the checkKeyPress() method in the Scroller() class 
        scroll.checkKeyPress(amount);
    }

    public score getScore()
    {
        return score; //Calls the score() class
    }

    public lives getLives()
    {
        return lives; //Calls the lives() class
    }

    /*public void gameOver()
    {
    //This method removes all objects in the game and displays the game over screen
    removeObjects(getObjects(Actor.class));
    setBackground("BlackScreen.jpg");
    addObject(new GameOver(), 650, 430);
    }*/

    public void levelCompleted()
    {
        //This method removes all the objects in the game and displays the level completed screen
        removeObjects(getObjects(Actor.class));
        setBackground("BG.png");
        addObject(new LevelComplete(), 650, 430);
    }

     
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crate crate = new Crate();
        addObject(crate,804,567);
        crate.setLocation(803,564);
        Crate crate2 = new Crate();
        addObject(crate2,881,573);
        Crate crate3 = new Crate();
        addObject(crate3,881,495);
        crate3.setLocation(881,498);
        Platform1 platform1 = new Platform1();
        addObject(platform1,1033,323);
        Platform2 platform2 = new Platform2();
        addObject(platform2,1160,325);
        platform2.setLocation(1160,329);
    }
}