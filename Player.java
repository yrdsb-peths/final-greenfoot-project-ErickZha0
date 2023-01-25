

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class Player here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
    public class Player extends Actor
    {   
        private static final int gravtiy = 2; 
        GreenfootImage[] idleRight= new GreenfootImage[8];
        GreenfootImage[] idleLeft= new GreenfootImage[8];
        String facing = "right";
        SimpleTimer animationTimer = new SimpleTimer();
        private boolean touchingObstacles; //To check if the player is touching an enemy or obstacle
        private Scroller scroll;
        private int speed = 1; //Speed of player movement
        private int vSpeed = 0; //Fall speed of player
        private int acceleration = 1; //Acceleration of the fall speed of the player
        private int jumpStrength = 19; //How high the player can jump
        private boolean jumping; //To check if the player is jumping
        private boolean facingRight; //To check if the player is facing right
        private boolean isKeyPressed; //To check if the user is pressing a key
        private boolean spaceDown; //To check if the user is pressing the space key

        
        /**
         * Act - do whatever the Player wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        
        public void act()
        {
            
            checkFall(); 
            platformAbove();
            checkRightWalls(); 
            checkObstacles(); 
            levelCompletedScreen(); 
            if(Greenfoot.isKeyDown("a"))
            {
                move(-2);
                facing = "left";
                animatePlayer();
            } 
            else if(Greenfoot.isKeyDown("d"))
            {
                move(2);
                facing = "right";
                animatePlayer();
            }
            else if(Greenfoot.isKeyDown("a") & Greenfoot.isKeyDown("d"))
            {
                move(0);
                stopWalking();
            }
            checkKeys(); 
        }

        
        public Player()
        {
           for(int i = 0; i < 8; i++)
            {
                idleRight[i] = new GreenfootImage("images/freeknight/png/Run0" + i + ".png");    
                idleRight[i].scale(160, 160);
             }
       
           for(int i = 0; i < idleLeft.length; i ++)
            {
                idleLeft[i] = new GreenfootImage("images/freeknight/png/Run0" + i + ".png");    
                idleLeft[i].mirrorHorizontally();
                idleLeft[i].scale(160, 160);   
            }
        
           animationTimer.mark();
           setImage(idleRight[0]);
            
        }
        int imageIndex = 0;
        public void animatePlayer()
        {
            // animations
            if(animationTimer.millisElapsed() < 50)
            {
                return;
            }
            animationTimer.mark();
            if(facing.equals("right"))
            {
                setImage(idleRight[imageIndex]);
                imageIndex = (imageIndex + 1) % idleRight.length;    
            }
            else
            {
                setImage(idleLeft[imageIndex]);
                imageIndex = (imageIndex + 1) % idleLeft.length;    
            }
            
        }
        
       public int getHeight()
        {
            return getImage().getHeight();
        }
    
        public void stopWalking()
        {
            speed= 0;
            setLocation(getX(), getY());
        }
        
        private void checkKeys()
        {

            //The checkKeys() method makes they controls for the game functional
            isKeyPressed = false;
            if (Greenfoot.isKeyDown("a")&&(Greenfoot.isKeyDown("d"))) //When both "a" and "d" keys are pressed at the same time then stop sprite from moving.
            {
                stopWalking();
            }
            else if (Greenfoot.isKeyDown("d")) //If the "d" key is pressed then move the player to the right
            {
                moveRight(); 
                isKeyPressed = true;
                facingRight = true; 
            }
            else if (Greenfoot.isKeyDown("a")) //If the "a" key is pressed then move the player to the left
            {
                moveLeft(); //Calls the moveLeft() method to make the player move left and to animate the player movement
                isKeyPressed = true;
                facingRight = false; //facingRight will be false because the player will be facing left when the "a" key is pressed
            }
            if(Greenfoot.isKeyDown("w")&& jumping == false) //If the player is not jumping and the "w" key is pressed then make the player jump
            {
                isKeyPressed = true;
                jump(); //Calls the jump() method to make the player jump
            }
            if(!spaceDown && Greenfoot.isKeyDown("space")) //If they space key is pressed and spaceDown is false then shoot a bomb
            {
                spaceDown = true;
                shruikenRight right = new shruikenRight(); //The shruikenRight() class is called
                shruikenLeft left = new shruikenLeft(); //The shruikenLeft() class is called
                if(facingRight == true) //If the sprite is facing right then shoot the bomb to the right
                {
                    getWorld().addObject(right, getX(), getY()); //Adds the bomb star object and shoots it to the right
                }
                if(facingRight == false) //If the player is facing left then shoot the bomb to the left 
                {
                    getWorld().addObject(left, getX(), getY()); //Adds the bomb object and shoots it to the left
                }
            }
            if(spaceDown && !Greenfoot.isKeyDown("space")) 
            {
                spaceDown = false;
            }
            if (!isKeyPressed) //If no key is pressed then make the player stop walking
            {
                stopWalking(); 
            }
        }
        
        public void jump() 
        {
            //The jump() method allows the player to jump and once the player jumps it will move back to the ground
            vSpeed = vSpeed - jumpStrength; 
            fall(); 
        }
        
        public void moveRight()
        {
            
            setLocation(getX() + speed, getY()); 
            
        }
        
        public void moveLeft()
        {
            setLocation(getX() - speed, getY());
    
        }
        
        private void fall()
        {
            setLocation(getX(), getY() + vSpeed);
            if (vSpeed <=9)
            {
                vSpeed = vSpeed + acceleration; 
            }
            jumping = true;
        }
        
        private void checkFall()
        {
            //This method is to check if the player is falling or on the ground
            

            if(onGround())
            {
                vSpeed = 0;
            }
            else
            {
                fall();
            }
        }  
        
        public boolean onGround()
        {
            //This method explains to the player() class what the ground is
            int spriteHeight = getImage().getHeight();
            int yDistance = (int)(spriteHeight / 2 + 5);
            
            Actor ground = getOneObjectAtOffset(0, getHeight()/2, Ground1.class);
            Actor ground2 = getOneObjectAtOffset(0, getHeight()/2, Platform1.class);
            if(ground == null)
            {
                return false;
            }
            else
            {
                moveToGround(ground);
                return true;
            }
        }
        
        public void moveToGround(Actor ground)
        {
            //This method moves the player to the ground
            int groundHeight = ground.getImage().getHeight();
            int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
            setLocation(getX(), newY);
            jumping = false;
        }
        
        public boolean platformAbove()
        {
            //This method explains to the player() class what a platform above it is
            int spriteHeight = getImage().getHeight();
            int yDistance = (int)(spriteHeight / -2);
            
            Actor ceiling = getOneObjectAtOffset(0, yDistance, Ground1.class);
            if(ceiling != null)
            {
                vSpeed = 1;
                bopHead(ceiling);
                return true;
            }
            else
            {
                return false;
            }
        }
        
        public void bopHead(Actor ceiling)
        {
            //This method stops the player from travelling through a platform that is above it
            int ceilingHeight = ceiling.getImage().getHeight();
            int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
            setLocation(getX(), newY);
        }
        
        public boolean checkRightWalls()
        {

            int spriteWidth = getImage().getHeight();
            int xDistance = (int)(spriteWidth/2);
            Actor rightWall = getOneObjectAtOffset(xDistance, 0, Ground1.class);
            if(rightWall == null)
            {
                return false;
            }
            else
            {
                stopByRightWall(rightWall);
            
                return true;
            }
        }
        
        public void stopByRightWall(Actor rightWall)
        {
            //stops the player from travelling through the side of a block
            int wallWidth = rightWall.getImage().getWidth();
            int newX = rightWall.getX() - (wallWidth + getImage().getWidth())/2;
            setLocation(newX -5, getY());
  
        }
        
        public boolean canSee(Class clss){
            Actor actor = getOneIntersectingObject(clss);
            return actor != null;     
        }
        
        public void checkObstacles()
        {
            
            
            Actor obstacles = getOneIntersectingObject(OBSTACLES.class);
            if (obstacles != null)
            {
                if(touchingObstacles == false)
                {
                    //If the player is touching an enemy or an obstacle then subtract the lives counter by one
                    setLocation(25,0); //Makes the player respawn after losing a life
                    touchingObstacles = true;
                }
            } 
            else
            {
                touchingObstacles = false;
            }
        }
        
        public void levelCompletedScreen()
        {
            
            if (isTouching(portal.class))
            {
                ((MyWorld)getWorld()).levelCompleted();
            }
        }
        
    }


    
