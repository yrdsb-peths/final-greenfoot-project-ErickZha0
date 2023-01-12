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
        private static final int acceleration = 2; 
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
            if(Greenfoot.isKeyDown("left"))
            {
                move(-3);
                facing = "left";
                animateElephant();
            } 
            else if(Greenfoot.isKeyDown("right"))
            {
                move(3);
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
                idleRight[i].scale(100, 100);
             }
       
           for(int i = 0; i < idleLeft.length; i ++)
            {
                idleLeft[i] = new GreenfootImage("images/freeknight/png/Run0" + i + ".png");    
                idleLeft[i].mirrorHorizontally();
                idleLeft[i].scale(100, 100);   
            }
        
           animationTimer.mark();
           setImage(idleRight[0]);
            
        }
        int imageIndex = 0;
        public void animateElephant()
        {
            //elephant animations
            if(animationTimer.millisElapsed() < 300)
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
            setVSpeed(-16);
            fall();
        }
        
        public void fall()
        {
            setLocation ( getX(), getY() + vSpeed);
            
            vSpeed = vSpeed + acceleration;
        }
        
        public void setVSpeed(int speed)
        {
            vSpeed = speed;
        }
        
        public boolean onGround()
        {
            Object under = getOneObjectAtOffset(0, getImage().getHeight()/2-8 , null);
            return under != null;
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
        
        
    }


    
