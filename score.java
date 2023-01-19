import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class score extends Actor
{
    public int score = 0; //This variable is the score counter
    
    public score()
    {
        updateImage(); //Calls the updateImage() method
    }  
    
    public void updateImage()
    {
        //This method is to display and update the score graphic in the game
        setImage(new GreenfootImage("Score: " + score, 20, Color.WHITE, Color.BLACK));
    }
    
    public void addScore()
    {
        //This method is to increment the score and update the graphic in game once the score has changed
        score++; //Increments the score by one
        updateImage(); //Calls the updateImage() method
    }
}
