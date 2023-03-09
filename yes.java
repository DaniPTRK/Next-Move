import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Acest buton este utilizat pentru a deschide panoul de control. Se află pe radioul militar.
 */
public class yes extends ButoaneRadioMilitar
{
    /**
     * Act - do whatever the yes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if((getWorld().getClass()==radio_militar_front.class)&&Greenfoot.mouseClicked(getWorld().getObjects(yes.class).get(0)))
        {
            Greenfoot.playSound("openpanel.mp3");
            Greenfoot.setWorld(new panou_control());
        }
    }    
}
