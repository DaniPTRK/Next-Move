import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class radio_militar_front here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class radio_militar_front extends scene_birou
{

    /**
     * Constructor for objects of class radio_militar_front.
     * 
     */
    public radio_militar_front()
    {
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        no no = new no();
        addObject(no,668,444);
        yes yes = new yes();
        addObject(yes,515,444);
    }
}
