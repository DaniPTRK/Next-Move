import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class helpsc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class helpsc extends introducere
{
    /**
     * Constructor for objects of class helpsc.
     * 
     */
    public helpsc()
    {    
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        exit_help exit_help = new exit_help();
        addObject(exit_help,1023,146);
    }
}
