import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    Label titleLabel = new Label("SUPER BARIO", 80);
    GreenfootSound backgroundMusic = new GreenfootSound("Music1.mp3");
    public Menu() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        Greenfoot.start();
        backgroundMusic.playLoop();
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
        
    }

    public void act() {
        // Starts game if user presses the space bar
        if(Greenfoot.isKeyDown("space")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
          
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        titleLabel.setLocation(300,60);

        Label label = new Label("Use \u2190 \u2191 \u2192 to Move", 50);
        addObject(label,700,400);

        Label label2 = new Label("Press <space> use BOMB", 50);
        addObject(label2,700,500);
        
        titleLabel.setLocation(500,100);



        PlayerImage playerImage = new PlayerImage();
        addObject(playerImage,264,369);
    }
}