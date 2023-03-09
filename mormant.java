import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Prezentare a morții lui Aurel după ocuparea țării de către ruși/austroungari.
 */
public class mormant extends cutscene
{
    public String st;
    /**
     * Constructor for objects of class mormant.
     * 
     */
    public mormant()
    {
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
        getObjects(Inter.class).get(0).passday2(0);
        Greenfoot.playSound("death.mp3");
        //Este verificată care țară a reușit să ocupe România pentru a afișa textul corect.
        if(mainroom.win==-1)
        {
            st="Rusia ";
        }
        else
        {
            st="Austro-Ungaria ";
        }
        getObjects(Text.class).get(0).TextFadeIn(0,"Ocuparea României de către "+st+" a dus la execuția lui Aurel,\n conducerea fiind preluată de către dușmani.", 40, Color.WHITE);
        Greenfoot.delay(360);
        getObjects(Text.class).get(0).TextFadeOut(0);
        Greenfoot.playSound("sumupsh.mp3");
        getObjects(Inter.class).get(0).passday1(0);
        Greenfoot.setWorld(new nofront_harta());
    }
    private void prepare()
    {
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text,640,650);
        text.getImage().setTransparency(0);
    }
}
