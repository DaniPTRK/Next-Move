import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este anunțat câștigătorul alegerilor.
 */
public class radiocut extends cutsceneintro
{
    int i;
    public String[] partid={"Conservator ", "Comuniunii Liberale ", "Țărănesc "};
    /**
     * Constructor for objects of class radiocut.
     * 
     */
    public radiocut()
    { 
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
       getObjects(Inter.class).get(0).passday2(0);
       Greenfoot.playSound("radio_static.mp3");
       check();
       getObjects(Text.class).get(0).TextFadeIn(0,"'Anunțăm cu inima plină de bucurie sosirea la conducere a noului nostru\n lider, venerabilul Aurel, ce a făptuit acte de curaj în Marele Război.\n Fie ca el și Partidul "+ partid[i]+"să ne conducă spre un viitor luminos!'", 35, Color.WHITE);
       Greenfoot.delay(480);
       getObjects(Text.class).get(0).TextFadeOut(0);
       getObjects(Inter.class).get(0).passday1(0);
       Greenfoot.setWorld(new alegeri());
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
    public void check()
    {
        //Este verificat ce partid a fost ales de către utilizator în scena precedentă.
        if(choice_par.OKpar[0]==true)
        {
            i=0;
        }
        else if(choice_par.OKpar[1]==true)
        {
            i=1;
        }
        else
        {
            i=2;
        }
    }
}
