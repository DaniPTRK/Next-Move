import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Această scenă este similară cu scenele ce apar în urma pornirii dictaturii militare sau a înfrângerii.
 */
public class anarhie extends lowmil
{
    int count;
    /**
     * Constructor for objects of class anarhie.
     * 
     */
    public anarhie()
    {
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
        getObjects(Text.class).get(0).TextFadeIn(0,"În timpul războiului, România a suferit\n o puternică lovitură de stat din partea populației.",50, Color.WHITE);
        Greenfoot.delay(290);
        getObjects(Text.class).get(0).TextFadeOut(0);
        Greenfoot.playSound("jeer.mp3");
        getObjects(Inter.class).get(0).passday2(0);
        walk();
        getObjects(Inter.class).get(0).passday1(0);
        Greenfoot.playSound("sumup.mp3");
        Greenfoot.setWorld(new prisonexterior());
    }
    //Animație de mers.
        public void walk()
    {
        int i;
        for(i=0; i<=255; i=i+15)
        {
            getObjects(Conducator.class).get(0).setLocation(getObjects(Conducator.class).get(0).getX(),getObjects(Conducator.class).get(0).getY()+5);
            getObjects(rosold.class).get(0).setLocation(getObjects(rosold.class).get(0).getX()+5,getObjects(rosold.class).get(0).getY()+5);
            getObjects(rosold.class).get(1).setLocation(getObjects(rosold.class).get(1).getX()-5,getObjects(rosold.class).get(1).getY()+5);
            if(count%50>25)
            {
                getObjects(Conducator.class).get(0).setImage("fatamers2.png");
                getObjects(rosold.class).get(0).setImage("ros.png");
                getObjects(rosold.class).get(1).setImage("ros.png");
            }
            else
            {
                getObjects(Conducator.class).get(0).setImage("fatamers1.png");
                getObjects(rosold.class).get(0).setImage("rod.png");
                getObjects(rosold.class).get(1).setImage("rod.png");
            }
            getObjects(Conducator.class).get(0).getImage().setTransparency(i);
            getObjects(rosold.class).get(0).getImage().setTransparency(i);
            getObjects(rosold.class).get(1).getImage().setTransparency(i);
            count++;
            Greenfoot.delay(3);
        }
        for(i=255; i>=0; i=i-5)
        {
            getObjects(Conducator.class).get(0).setLocation(getObjects(Conducator.class).get(0).getX(),getObjects(Conducator.class).get(0).getY()+4);
            getObjects(rosold.class).get(0).setLocation(getObjects(rosold.class).get(0).getX(),getObjects(rosold.class).get(0).getY()+4);
            getObjects(rosold.class).get(1).setLocation(getObjects(rosold.class).get(1).getX(),getObjects(rosold.class).get(1).getY()+4);
            if(count%50>25)
            {
                getObjects(Conducator.class).get(0).setImage("fatamers2.png");
                getObjects(rosold.class).get(0).setImage("ros.png");
                getObjects(rosold.class).get(1).setImage("ros.png");
            }
            else
            {
                getObjects(Conducator.class).get(0).setImage("fatamers1.png");
                getObjects(rosold.class).get(0).setImage("rod.png");
                getObjects(rosold.class).get(1).setImage("rod.png");
            }
            getObjects(Conducator.class).get(0).getImage().setTransparency(i);
            getObjects(rosold.class).get(0).getImage().setTransparency(i);
            getObjects(rosold.class).get(1).getImage().setTransparency(i);
            count++;
            Greenfoot.delay(3);
        }
    }
    private void prepare()
    {
        v10 v10 = new v10();
        addObject(v10,484,520);
        v11 v11 = new v11();
        addObject(v11,158,518);
        v2 v2 = new v2();
        addObject(v2,230,620);
        v4 v4 = new v4();
        addObject(v4,309,505);
        v3 v3 = new v3();
        addObject(v3,361,646);
        v5 v5 = new v5();
        addObject(v5,927,473);
        v6 v6 = new v6();
        addObject(v6,1136,555);
        v7 v7 = new v7();
        addObject(v7,1063,632);
        v8 v8 = new v8();
        addObject(v8,810,496);
        v9 v9 = new v9();
        addObject(v9,100,635);
        v1 v1 = new v1();
        addObject(v1,872,628);
        rosold rosold= new rosold();
        addObject(rosold,640,405);
        rosold.setImage("rofront.png");
        rosold.getImage().setTransparency(0);
        rosold rosold2 = new rosold();
        addObject(rosold2,640,405);
        rosold2.setImage("rofront.png");
        rosold2.getImage().setTransparency(0);
        Conducator conducator = new Conducator();
        addObject(conducator,640,405);
        conducator.getImage().setTransparency(0);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 355);
        text.getImage().setTransparency(0);
        Text text2=new Text();
        addObject(text2, 640, 355);
        text2.getImage().setTransparency(0);
    }
}
