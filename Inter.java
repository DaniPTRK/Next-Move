import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Obiect utilizat pentru tranziții.
 */
public class Inter extends Actor
{
    /**
     * Act - do whatever the Inter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    public void init()
    {
        getImage().setTransparency(0);
    }
    public void passday1(int j)
    {
        //Apariția obiectului.
       int i;
       for(i=0; i<256; i=i+5)
       {
           getWorld().getObjects(Inter.class).get(j).getImage().setTransparency(i);
           Greenfoot.delay(1);
       }
    }
    public void passday2(int j)
    {
        //Dispariția acestuia.
       {
           int i;
           for(i=255; i>=0; i=i-5)
           {
               getWorld().getObjects(Inter.class).get(j).getImage().setTransparency(i);
               Greenfoot.delay(1);
           }
       }
    }
}
