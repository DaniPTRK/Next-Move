import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Prima scenă a jocului.
 */
public class calendar extends cutsceneintro
{
    /**
     * Constructor for objects of class calendar.
     * 
     */
    public calendar()
    {
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
       //Linii de cod pentru apariția textului
       getObjects(Inter.class).get(0).passday2(0);
       getObjects(Text.class).get(0).TextFadeIn(0,"Anul 1918 a reprezentat un mare succes atât pentru România,\ncât și pentru eroul nostru,", 40, Color.WHITE);
       Greenfoot.playSound("play_sound.mp3");
       Greenfoot.delay(200);
       getObjects(Text.class).get(1).TextFadeIn(1, "Aurel", 40, Color.WHITE);
       Greenfoot.delay(200);
       getObjects(Text.class).get(0).TextFadeOut(0);
       getObjects(Text.class).get(1).TextFadeOut(1);
       getObjects(Inter.class).get(0).passday1(0);
       Greenfoot.setWorld(new front());
    }
    public void prepare()
    {
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 650);
        text.getImage().setTransparency(0);
        Text text2=new Text();
        addObject(text2, 885 ,670);
        text2.getImage().setTransparency(0);
    }
}
