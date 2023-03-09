import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Scenă care prezintă medalierea lui Aurel.
 */
public class medalie extends cutsceneintro
{
    /**
     * Constructor for objects of class medalie.
     * 
     */
    public medalie()
    {
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
        //Apariția textului.
        getObjects(Inter.class).get(0).passday2(0);
        Greenfoot.playSound("medals.mp3");
        getObjects(Text.class).get(0).TextFadeIn(0,"Pentru curajul său, Aurel a primit o medalie, ceea ce a fost și \ncheia către viitorul său politic.", 50, Color.WHITE);
        Greenfoot.delay(300);
        getObjects(Text.class).get(0).TextFadeOut(0);
        getObjects(Inter.class).get(0).passday1(0);
        Greenfoot.setWorld(new nofront_harta());
    }
    public void prepare()
    {
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 650);
        text.getImage().setTransparency(0);
    }
}
