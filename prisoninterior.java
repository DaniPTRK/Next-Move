import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Interiorul pușcăriei în care este condus Aurel (în cazul dictaturii militare sau al unei anarhii).
 */
public class prisoninterior extends upmil
{
    int count;
    /**
     * Constructor for objects of class prisoninterior.
     * 
     */
    public prisoninterior()
    {    
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
        getObjects(Inter.class).get(0).passday2(0);
        walk();
        Greenfoot.playSound("lock.mp3");
        getObjects(Inter.class).get(0).passday1(0);
        if(mainroom.win==-3)
        {
            getObjects(Text.class).get(0).TextFadeIn(0,"Acesta a fost sfârșitul carierei lui Aurel,\n România rămânând de acum în mâinile armatei.\n",50, Color.WHITE);   
        }
        else
        {
            getObjects(Text.class).get(0).TextFadeIn(0,"Acesta a fost sfârșitul carierei lui Aurel,\n România rămânând de acum în mâinile reformiștilor.\n",50, Color.WHITE);
        }
        Greenfoot.delay(290);
        getObjects(Text.class).get(0).TextFadeOut(0);
        Greenfoot.setWorld(new credits());
    }
    //Animație de mers.
    public void walk()
    {
        int i;
        for(i=0; i<=255; i=i+5)
        {
            getObjects(Conducator.class).get(0).setLocation(getObjects(Conducator.class).get(0).getX(),getObjects(Conducator.class).get(0).getY()-5);
            getObjects(rosold.class).get(0).setLocation(getObjects(rosold.class).get(0).getX(),getObjects(rosold.class).get(0).getY()-5);
            getObjects(rosold.class).get(1).setLocation(getObjects(rosold.class).get(1).getX(),getObjects(rosold.class).get(1).getY()-5);
            if(count%50>25)
            {
                getObjects(Conducator.class).get(0).setImage("spatemers1.png");
                getObjects(rosold.class).get(0).setImage("rodw.png");
                getObjects(rosold.class).get(1).setImage("rodw.png");
            }
            else
            {
                getObjects(Conducator.class).get(0).setImage("spatemers2.png");
                getObjects(rosold.class).get(0).setImage("rosw.png");
                getObjects(rosold.class).get(1).setImage("rosw.png");
            }
            getObjects(Conducator.class).get(0).getImage().setTransparency(i);
            getObjects(rosold.class).get(0).getImage().setTransparency(i);
            getObjects(rosold.class).get(1).getImage().setTransparency(i);
            count++;
            Greenfoot.delay(3);
        }
        while(getObjects(Conducator.class).get(0).getY()>140)
        {
            getObjects(Conducator.class).get(0).setLocation(getObjects(Conducator.class).get(0).getX(),getObjects(Conducator.class).get(0).getY()-5);
            if(getObjects(rosold.class).get(0).getY()>210)
            {
               getObjects(rosold.class).get(0).setLocation(getObjects(rosold.class).get(0).getX(),getObjects(rosold.class).get(0).getY()-5);
               getObjects(rosold.class).get(1).setLocation(getObjects(rosold.class).get(1).getX(),getObjects(rosold.class).get(1).getY()-5);
            }
            else
            {
                getObjects(rosold.class).get(0).setImage("rofront.png");
                getObjects(rosold.class).get(1).setImage("rofront.png");
            }
            if(count%50>25)
            {
                getObjects(Conducator.class).get(0).setImage("spatemers1.png");
                if(getObjects(rosold.class).get(0).getY()>210)
                {
                    getObjects(rosold.class).get(0).setImage("rodw.png");
                    getObjects(rosold.class).get(1).setImage("rodw.png");
                }
            }
            else
            {
                getObjects(Conducator.class).get(0).setImage("spatemers2.png");
                if(getObjects(rosold.class).get(0).getY()>210)
                {
                    getObjects(rosold.class).get(0).setImage("rosw.png");
                    getObjects(rosold.class).get(1).setImage("rosw.png");
                }
            }
            count++;
            Greenfoot.delay(3);
        }
        getObjects(Conducator.class).get(0).setImage("fata.png");
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Conducator conducator = new Conducator();
        addObject(conducator,627,664);
        conducator.getImage().setTransparency(0);
        rosold rosold = new rosold();
        addObject(rosold,706,664);
        rosold.getImage().setTransparency(0);
        rosold rosold2 = new rosold();
        addObject(rosold2,548,664);
        rosold2.getImage().setTransparency(0);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 355);
        text.getImage().setTransparency(0);
    }
}
