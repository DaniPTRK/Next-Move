import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Apăsarea acestui buton determină apariția unui ghid care indică controalele esențiale ale
 * jocului.
 */
public class help extends ButoaneStart
{
    /**
     * Act - do whatever the help wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(getWorld().getObjects(help.class).get(0)))
        {
            Greenfoot.playSound("helpsc_sound.mp3");
            Greenfoot.setWorld(new helpsc());
        }
    }    
}
