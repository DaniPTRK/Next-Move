import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Butonul exit determină oprirea jocului.
 */
public class exit extends ButoaneStart
{
    public GreenfootSound music= new GreenfootSound("exit.mp3");
    /**
     * Act - do whatever the exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
           if(Greenfoot.mouseClicked(getWorld().getObjects(exit.class).get(0)))
           {
               music.play();
               Greenfoot.stop();
           }
    }    
}
