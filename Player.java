

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class Player here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
    public class Player extends Actor
    {   
        private static final int speed = 7; // running speed (sideways)
        private int vSpeed = 0; 
        private static final int gravtiy = 2; 
        GreenfootImage[] idleRight= new GreenfootImage[8];
        GreenfootImage[] idleLeft= new GreenfootImage[8];
        String facing = "right";
        SimpleTimer animationTimer = new SimpleTimer();
        
        /**
         * Act - do whatever the Player wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        
        public void act()
        {
            checkCelling();
            if(Greenfoot.isKeyDown("left"))
            {
                move(-10);
                facing = "left";
                animateElephant();
            } 
            else if(Greenfoot.isKeyDown("right"))
            {
                move(10);
                facing = "right";
                animateElephant();
            }
            checkFall();
            jumpingPlayer();
           
        
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
        public void animateElephant()
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
        
        public void jumpingPlayer()
        {
            if (Greenfoot.isKeyDown("space") )
            {
                if (onGround())
                jump();
            }
        }
        
        
        private void jump()
        {
            setVSpeed(-25);
            fall();
        }
        
        public void fall()
        {
            setLocation ( getX(), getY() + vSpeed);
            
            vSpeed = vSpeed + gravtiy;
        }
        
        public void setVSpeed(int speed)
        {
            vSpeed = speed;
        }
        
        
        public boolean onGround()
        {
            int spriteHeight= getImage().getHeight();
            int lookForGround = spriteHeight/2;
            
            Actor Ground1 = getOneObjectAtOffset(0, lookForGround , null);
            if(Ground1 == null)
            return false;
            else
            {
                moveToGround(Ground1);
                return true;
            }
        }
        
        public void moveToGround(Actor ground)
        {
            int groundHeight = ground.getImage().getHeight();
            int newY = ground.getY() - (groundHeight + getImage().getHeight()) /2;
            setLocation(getX(), newY);
        }
        

        private void checkFall()
        {
            if (onGround())
            {
                setVSpeed(0);
            }
            else 
            {
                fall();
            }
        }
        
        
        
        public boolean checkCelling()
        {
            int spriteHeight= getImage().getHeight();
            int lookForCelling = spriteHeight/2;
            
            Actor celling = getOneObjectAtOffset(0, -lookForCelling , null);
            if(celling != null)
            {
                bopHead(celling);
                return true;
            }
            else
            {

                return false;
            }
        }
        
        public void bopHead(Actor celling)
        {
            int cellingHeight = celling.getImage().getHeight();
            int newY = celling.getY() + (cellingHeight + getImage().getHeight()) /2;
            setLocation(getX(), newY);
            vSpeed = 2;
        }
        
    }


    
