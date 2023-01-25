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
        for (int x = 61; x <= 12000; x += 127)
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
        addObject(crate,750,571);

        Crate crate2 = new Crate();
        addObject(crate2,674,570);

        Crate crate3 = new Crate();
        addObject(crate3,750,494);

        Platform1 platform1 = new Platform1();
        addObject(platform1,992,339);

        Platform2 platform2 = new Platform2();
        addObject(platform2,1120,340);

        Platform3 platform3 = new Platform3();
        addObject(platform3,1248,340);


        spike spike4 = new spike();
        addObject(spike4,1204,592);

        spike spike5 = new spike();
        addObject(spike5,1322,592);

        Enemy1 enemy1 = new Enemy1();
        addObject(enemy1,984,257);


        Enemy1 enemy2 = new Enemy1();
        addObject(enemy2,1700,571);
        
        Enemy1 enemy3 = new Enemy1();
        addObject(enemy3,2900,571);

        Crate Crate123 = new Crate();
        addObject(Crate123,1650,340);

        Platform1 platform4 = new Platform1();
        addObject(platform4,2000,339);

        Platform2 platform5 = new Platform2();
        addObject(platform5,2128,340);

        Platform3 platform6 = new Platform3();
        addObject(platform6,2256,340);

        spike spike7 = new spike();
        addObject(spike7,2600,592);
        
        Crate crate4 = new Crate();
        addObject(crate4,3400,571);

        Crate crate5 = new Crate();
        addObject(crate5,3475,570);

        Crate crate6 = new Crate();
        addObject(crate6,3475,494);
        
        Platform1 platformc = new Platform1();
        addObject(platformc,3700,339);

        Platform2 platforms = new Platform2();
        addObject(platforms,3828,340);

        Platform2 platforma = new Platform2();
        addObject(platforma,3956,340); 
        
        Platform2 platformS = new Platform2();
        addObject(platformS,4084,340);
        
        Platform2 platformD = new Platform2();
        addObject(platformD,4212,340);
                
        Platform3 platformE= new Platform3();
        addObject(platformE,4340,340);
        
        spike spikeS = new spike();
        addObject(spikeS,4020,280);
        
        Enemy1 enemy12 = new Enemy1();
        addObject(enemy12,3956,571);
        
        spike spikeSA = new spike();
        addObject(spikeSA,5000,592);
        
        Crate crateE = new Crate();
        addObject(crateE,4900,571);
        
        spike spikeSB = new spike();
        addObject(spikeSB,5200,592);
        
        spike spike123 = new spike();
        addObject(spike123,5400,592);
        
        spike spike1234 = new spike();
        addObject(spike1234,5600,592);
        
        spike spike12345 = new spike();
        addObject(spike12345,5800,592);
        
        spike spikez = new spike();
        addObject(spikez,6000,592);
              
        spike spikex = new spike();
        addObject(spikex,6200,592);
        
        spike spikey = new spike();
        addObject(spikey,6400,592);
        
        spike spikek = new spike();
        addObject(spikek,6600,592);
        
        spike spikep = new spike();
        addObject(spikep,6800,592);
        
        spike spikea = new spike();
        addObject(spikea,7000,592);
        
        Crate crateg = new Crate();
        addObject(crateg,5200,400);
        
        Crate spike1232 = new Crate();
        addObject(spike1232,5600,450);
        
        Platform1 platform10 = new Platform1();
        addObject(platform10,6000,340);

        Platform2 platform11 = new Platform2();
        addObject(platform11,6128,340);

        Platform3 platform12 = new Platform3();
        addObject(platform12,6256,340);
        
        
        Platform1 platformA = new Platform1();
        addObject(platformA,6700,340);

        Platform2 platformB = new Platform2();
        addObject(platformB,6828,340);

        Platform2 platformC = new Platform2();
        addObject(platformC,6956,340);
        
        Platform3 platformDD = new Platform3();
        addObject(platformDD,7084,340);
          

        
        Platform1 platform20 = new Platform1();
        addObject(platform20,7400,300);

        Platform2 platform21 = new Platform2();
        addObject(platform21,7528,300);

        Platform3 platform22 = new Platform3();
        addObject(platform22,7656,300);
        
        Enemy1 enemy10 = new Enemy1();
        addObject(enemy10,7400,230);

        Crate crate12 = new Crate();
        addObject(crate12,8000,571);

        Crate crate21= new Crate();
        addObject(crate21,8080,570);

        Crate crate32 = new Crate();
        addObject(crate32,8080,494);

        Platform1 platform113 = new Platform1();
        addObject(platform113,8400,339);

        Platform2 platform222 = new Platform2();
        addObject(platform222,8520,340);

        Platform3 platform333 = new Platform3();
        addObject(platform333,8640,340);   
        
        spike spike44 = new spike();
        addObject(spike44,8740,592);
        
        Crate crate221= new Crate();
        addObject(crate221,9600,400);
        
        Crate crate231= new Crate();
        addObject(crate231,9700,400);
        
        Crate crate421= new Crate();
        addObject(crate421,9800,400);
        
        Crate crate521= new Crate();
        addObject(crate521,9900,400);
        
        Enemy1 enemy122 = new Enemy1();
        addObject(enemy122,9600,592);
        
        Platform1 platformA2 = new Platform1();
        addObject(platformA2,11000,340);

        Platform2 platformB2 = new Platform2();
        addObject(platformB2,11128,340);

        Platform2 platformC2 = new Platform2();
        addObject(platformC2,11256,340);
        
        Platform3 platformDD2 = new Platform3();
        addObject(platformDD2,11384,340);
          
        Crate crate123 = new Crate();
        addObject(crate123,10500,571);

        Crate crate213= new Crate();
        addObject(crate213,10580,570);

        Crate crate323 = new Crate();
        addObject(crate323,10580,494);
        
        portal portal= new portal();
        addObject(portal,12000,250);
 
    }
}