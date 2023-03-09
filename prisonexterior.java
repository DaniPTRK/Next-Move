import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Exteriorul pușcăriei care prezintă conducerea lui Aurel (în cazul unei dictaturi militare sau al unei anarhii) în interiorul ei.
 */
public class prisonexterior extends upmil
{
    int count;
    /**
     * Constructor for objects of class prisonexterior.
     * 
     */
    public prisonexterior()
    {    
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
        getObjects(Text.class).get(0).TextFadeIn(0,"Ca și rezultat, Aurel\n a fost trimis la închisoare drept prizonier politic.",50, Color.WHITE);
        Greenfoot.delay(290);
        getObjects(Text.class).get(0).TextFadeOut(0);
        getObjects(Inter.class).get(0).passday2(0);
        walk();
        getObjects(Inter.class).get(0).passday1(0);
        Greenfoot.setWorld(new prisoninterior());
    }
    //Animație de mișcare.
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
        for(i=255; i>=0; i=i-5)
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
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Conducator conducator = new Conducator();
        addObject(conducator,639,667);
        conducator.getImage().setTransparency(0);
        rosold rosold = new rosold();
        addObject(rosold,722,666);
        rosold.getImage().setTransparency(0);
        rosold rosold2 = new rosold();
        addObject(rosold2,556,667);
        rosold2.getImage().setTransparency(0);
        over2 over2 = new over2();
        addObject(over2,639,476);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 355);
        text.getImage().setTransparency(0);
    }
}
