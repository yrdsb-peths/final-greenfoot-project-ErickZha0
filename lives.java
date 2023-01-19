import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lives extends Actor
{
    private int lives = 3; 

    public lives()
    {
        updateImage(); //Calls the updateImage() method
    }
    
    private void updateImage()
    {
        //This method is to display and update the lives graphic in the game
        setImage(new GreenfootImage("Lives: " + lives, 20, Color.WHITE, Color.BLACK));
    }
    
    public void subtractLives()
    {
        //This method is to decrease the lives and update the graphic in game once the lives has changed
        lives--; //Decrease the lives counter by one
        updateImage(); //Calls the updateImage() method
        //gameOverScreen(); //Calls the gameOverScreen() method
    }
    
    /*public void gameOverScreen()
    {
        //If lives equal to 0 then call the gameOver() method from the MyWorld() class
        if (lives == 0)
        {
            ((MyWorld)getWorld()).gameOver();
        }
    }*/
}

