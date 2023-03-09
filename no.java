import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Acest buton este folosit pentru ca utilizatorul să iasă din scena radioului militar.
 */
public class no extends ButoaneRadioMilitar
{
    /**
     * Act - do whatever the no wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if((getWorld().getClass()==radio_militar_front.class)&&(Greenfoot.mouseClicked(getWorld().getObjects(no.class).get(0))))
        {
            Greenfoot.playSound("butonradio.mp3");
            Greenfoot.setWorld(new mainroom());
        }
    }    
}
