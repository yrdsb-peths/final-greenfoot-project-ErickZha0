

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
        private boolean touchingObstacles; //To check if the sprite is touching an enemy or obstacle
        private Scroller scroll;
        private int speed = 1; //Speed of sprite movement
        private int vSpeed = 0; //Fall speed of sprite
        private int acceleration = 1; //Acceleration of the fall speed of the sprite
        private int jumpStrength = 19; //How high the sprite can jump
        private boolean jumping; //To check if the sprite is jumping
        private boolean facingRight; //To check if the sprite is facing right
        private boolean isKeyPressed; //To check if the user is pressing a key
        private boolean spaceDown; //To check if the user is pressing the space key

        
        /**
         * Act - do whatever the Player wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        
        public void act()
        {
            checkKeys(); //Calls checkKeys() method
            checkFall(); //Calls checkFall() method
            platformAbove(); //Calls platformAbove() method
            checkRightWalls(); //Calls checkRightWalls() method
            checkObstacles(); //Calls checkObstacles() method
            levelCompletedScreen(); //Calls levelCompletedScreen() method
            if(Greenfoot.isKeyDown("a"))
            {
                move(-3);
                facing = "left";
                animatePlayer();
            } 
            else if(Greenfoot.isKeyDown("d"))
            {
                move(3);
                facing = "right";
                animatePlayer();
            }
            else if(Greenfoot.isKeyDown("a") & Greenfoot.isKeyDown("d"))
            {
                stopWalking();
            }
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
            //elephant animations
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
            else if (Greenfoot.isKeyDown("d")) //If the "d" key is pressed then move the sprite to the right
            {
                moveRight(); //Calls the moveRight() method to make the sprite move right and to animate the sprite movement
                isKeyPressed = true;
                facingRight = true; //Since the sprite will be facing right when the "d" key is pressed the facingRight variable will change to True
            }
            else if (Greenfoot.isKeyDown("a")) //If the "a" key is pressed then move the sprite to the left
            {
                moveLeft(); //Calls the moveLeft() method to make the sprite move left and to animate the sprite movement
                isKeyPressed = true;
                facingRight = false; //facingRight will be false because the sprite will be facing left when the "a" key is pressed
            }
            if(Greenfoot.isKeyDown("w")&& jumping == false) //If the sprite is not jumping and the "w" key is pressed then make the sprite jump
            {
                isKeyPressed = true;
                jump(); //Calls the jump() method to make the sprite jump
            }
            if(!spaceDown && Greenfoot.isKeyDown("space")) //If they space key is pressed and spaceDown is false then shoot a ninja star
            {
                spaceDown = true;
                shruikenRight right = new shruikenRight(); //The shruikenRight() class is called
                shruikenLeft left = new shruikenLeft(); //The shruikenLeft() class is called
                if(facingRight == true) //If the sprite is facing right then shoot the ninja star to the right
                {
                    getWorld().addObject(right, getX(), getY()); //Adds the ninja star object and shoots it to the right
                }
                if(facingRight == false) //If the sprite is facing left then shoot the ninja star to the left 
                {
                    getWorld().addObject(left, getX(), getY()); //Adds the ninja star object and shoots it to the left
                }
            }
            if(spaceDown && !Greenfoot.isKeyDown("space")) //If spaceDown is true and the space key is not pressed then change spaceDown to false
            {
                spaceDown = false;
            }
            if (!isKeyPressed) //If no key is pressed then make the sprite stop walking
            {
                stopWalking(); //Calls the stopWalking() method which makes the sprite stop walking
            }
        }
        
        public void jump() 
        {
            //The jump() method allows the sprite to jump and once the sprite jumps it will move back to the ground
            vSpeed = vSpeed - jumpStrength; //vSpeed which is short for velocity speed is equal to vSpeed subtracted by jumpStrength
            fall(); //Calls the fall() method which makes the sprite return back to the ground
        }
        
        public void moveRight()
        {
            //The method allows the sprite to move to the right and it animates the sprite movement
            setLocation(getX() + speed, getY()); //Makes the sprite to the right by adding the X position for the sprite by the speed variable
            
        }
        
        public void moveLeft()
        {
            //This method allows the sprite to move to the right and it animates the sprite movement
            setLocation(getX() - speed, getY()); //Makes the sprite move to the left by subtracting the X position for the sprite by the speed variable
    
        }
        
        private void fall()
        {
            //If vSpeed is less than or equal to 9 then add the vSpeed variable with the acceleration variable
            setLocation(getX(), getY() + vSpeed);
            if (vSpeed <=9)
            {
                vSpeed = vSpeed + acceleration; 
            }
            jumping = true;
        }
        
        private void checkFall()
        {
            //This method is to check if the sprite is falling or on the ground
            
            //If the sprite is on the ground then set vSpeed to 0 other than that call the fall() method
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
            //This method explains to the sprite() class what the ground is
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
            //This method moves the sprite to the ground
            int groundHeight = ground.getImage().getHeight();
            int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
            setLocation(getX(), newY);
            jumping = false;
        }
        
        public boolean platformAbove()
        {
            //This method explains to the sprite() class what a platform above it is
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
            //This method stops the sprite from travelling through a platform that is above it
            int ceilingHeight = ceiling.getImage().getHeight();
            int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
            setLocation(getX(), newY);
        }
        
        public boolean checkRightWalls()
        {
            //This method explains to the sprite() class what the side of block is
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
            //This method stops the sprite from travelling through the side of a block
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
            //This method checks if the sprite is touching an enemy or an obstacle
            
            Actor obstacles = getOneIntersectingObject(OBSTACLES.class);
            if (obstacles != null)
            {
                if(touchingObstacles == false)
                {
                    //If the sprite is touching an enemy or an obstacle then subtract the lives counter by one
                    ((MyWorld)getWorld()).getLives().subtractLives();
                    setLocation(25,0); //Makes the sprite respawn after losing a life
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
            //If the sprite is touching the portal object then call the levelCompleted() method from the MyWorld() class
            if (isTouching(portal.class))
            {
                ((MyWorld)getWorld()).levelCompleted();
            }
        }
        
    }


    
