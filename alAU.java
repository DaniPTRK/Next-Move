import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Scena pierderii războiului sau a dictaturii militare
 */
public class alAU extends cutscene
{
    public String al="În timpul războiului,\n România nu a reușit să facă față ofensivelor Austro-Ungariei.";
    public String[] animat=new String[]{"aud.png", "aus.png"};
    int count=0;
    /**
     * Constructor for objects of class alau.
     * 
     */
    public alAU()
    {
        prepare();
        //În funcție de caz, sunt schimbate imaginile soldaților și textul.
        if(mainroom.win==-1)
        {
            setBackground("RU.jpg");
            int i;
            for(i=0; i<15; i++)
            {
                getObjects(ausold.class).get(i).setImage("rusold.png");
                if(i>=13)
                {
                    getObjects(ausold.class).get(i).setImage("rufront.png");
                }
            }
            animat=new String[]{"rud.png", "rus.png"};
            al="În timpul războiului,\n România nu a reușit să facă față ofensivelor Rusiei.";
        }
        else if(mainroom.win==-3)
        {
            setBackground("Alegeriopen.jpg");
            int i;
            for(i=0; i<15; i++)
            {
                getObjects(ausold.class).get(i).setImage("rosold.png");
                if(i>=13)
                {
                    getObjects(ausold.class).get(i).setImage("rofront.png");
                }
            }
            animat=new String[]{"rod.png", "ros.png"};
            al="În timpul războiului, România a suferit\n o puternică lovitură de stat inițiată de soldați.";
        }
        getObjects(ausold.class).get(13).getImage().setTransparency(0);
        getObjects(ausold.class).get(14).getImage().setTransparency(0);
        getObjects(Inter.class).get(0).passday1(0);
    }
    //În funcție de situație, Aurel fie este împușcat (înfrângere), fie întemnițat (dictatură militară).
    public void act()
    {
        getObjects(Text.class).get(0).TextFadeIn(0,al,50, Color.WHITE);
        Greenfoot.delay(300);
        Greenfoot.playSound("incom.mp3");
        getObjects(Text.class).get(0).TextFadeOut(0);
        getObjects(Inter.class).get(0).passday2(0);
        walk();
        getObjects(Inter.class).get(0).passday1(0);
        if(mainroom.win==-3)
        {
            Greenfoot.playSound("sumup.mp3");
            Greenfoot.setWorld(new prisonexterior());
        }
        else
        {
            Greenfoot.playSound("gunshot.mp3"); 
            Greenfoot.delay(100);
            Greenfoot.setWorld(new mormant());
        }
    }
    public void walk()
    {
        int i;
        for(i=0; i<=255; i=i+15)
        {
            getObjects(Conducator.class).get(0).setLocation(getObjects(Conducator.class).get(0).getX(),getObjects(Conducator.class).get(0).getY()+5);
            getObjects(ausold.class).get(13).setLocation(getObjects(ausold.class).get(13).getX()+5,getObjects(ausold.class).get(13).getY()+5);
            getObjects(ausold.class).get(14).setLocation(getObjects(ausold.class).get(14).getX()-5,getObjects(ausold.class).get(14).getY()+5);
            if(count%50>25)
            {
                getObjects(Conducator.class).get(0).setImage("fatamers2.png");
                getObjects(ausold.class).get(13).setImage(animat[0]);
                getObjects(ausold.class).get(14).setImage(animat[0]);
            }
            else
            {
                getObjects(Conducator.class).get(0).setImage("fatamers1.png");
                getObjects(ausold.class).get(13).setImage(animat[1]);
                getObjects(ausold.class).get(14).setImage(animat[1]);
            }
            getObjects(Conducator.class).get(0).getImage().setTransparency(i);
            getObjects(ausold.class).get(13).getImage().setTransparency(i);
            getObjects(ausold.class).get(14).getImage().setTransparency(i);
            count++;
            Greenfoot.delay(3);
        }
        for(i=255; i>=0; i=i-5)
        {
            getObjects(Conducator.class).get(0).setLocation(getObjects(Conducator.class).get(0).getX(),getObjects(Conducator.class).get(0).getY()+4);
            getObjects(ausold.class).get(13).setLocation(getObjects(ausold.class).get(13).getX(),getObjects(ausold.class).get(13).getY()+4);
            getObjects(ausold.class).get(14).setLocation(getObjects(ausold.class).get(14).getX(),getObjects(ausold.class).get(14).getY()+4);
            if(count%50>25)
            {
                getObjects(Conducator.class).get(0).setImage("fatamers2.png");
                getObjects(ausold.class).get(13).setImage(animat[0]);
                getObjects(ausold.class).get(14).setImage(animat[0]);
            }
            else
            {
                getObjects(Conducator.class).get(0).setImage("fatamers1.png");
                getObjects(ausold.class).get(13).setImage(animat[1]);
                getObjects(ausold.class).get(14).setImage(animat[1]);
            }
            getObjects(Conducator.class).get(0).getImage().setTransparency(i);
            getObjects(ausold.class).get(13).getImage().setTransparency(i);
            getObjects(ausold.class).get(14).getImage().setTransparency(i);
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
        ausold ausold = new ausold();
        addObject(ausold,419,565);
        ausold ausold2 = new ausold();
        addObject(ausold2,875,568);
        ausold ausold3 = new ausold();
        addObject(ausold3,984,637);
        ausold ausold4 = new ausold();
        addObject(ausold4,1108,549);
        ausold ausold5 = new ausold();
        addObject(ausold5,291,508);
        ausold ausold6 = new ausold();
        addObject(ausold6,273,637);
        ausold ausold7 = new ausold();
        addObject(ausold7,148,526);
        ausold ausold8 = new ausold();
        addObject(ausold8,1236,520);
        ausold ausold9 = new ausold();
        addObject(ausold9,1096,645);
        ausold ausold10 = new ausold();
        addObject(ausold10,96,644);
        ausold ausold11 = new ausold();
        addObject(ausold11,973,490);
        ausold ausold12 = new ausold();
        addObject(ausold12,35,476);
        ausold ausold13 = new ausold();
        addObject(ausold13,376,660);
        Conducator conducator = new Conducator();
        addObject(conducator,640,405);
        conducator.getImage().setTransparency(0);
        ausold ausold14 = new ausold();
        addObject(ausold14,640,405);
        ausold14.setImage("aufront.png");
        ausold ausold15 = new ausold();
        addObject(ausold15,640,405);
        ausold15.setImage("aufront.png");
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 355);
        text.getImage().setTransparency(0);
    }
}
