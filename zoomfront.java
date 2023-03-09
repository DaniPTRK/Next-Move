import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Scenă care prezintă momentul ocupării Transilvaniei de către trupele române în 1918 prin ridicare drapelului.
 */
public class zoomfront extends cutsceneintro
{
    public zoomfront()
    {
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
        getObjects(Inter.class).get(0).passday2(0);
        setDown();
        getObjects(Text.class).get(0).TextFadeIn(0,"...victoria trupelor române, bineînțeles.", 50, Color.WHITE);
        Greenfoot.playSound("trumpet.mp3");
        setUp();
        getObjects(Text.class).get(0).TextFadeOut(0);
        getObjects(Inter.class).get(0).passday1(0);
        Greenfoot.setWorld(new medalie());
    }
    public void setDown()
    {
        //Este dat jos steagul Austro-Ungariei.
        while(getObjects(steag_AUN.class).get(0).getY()!=709)
        {
            getObjects(steag_AUN.class).get(0).setLocation(getObjects(steag_AUN.class).get(0).getX(), getObjects(steag_AUN.class).get(0).getY()+2);
            if(709-getObjects(steag_AUN.class).get(0).getY()<=255)
            {
                getObjects(steag_AUN.class).get(0).getImage().setTransparency(709-getObjects(steag_AUN.class).get(0).getY());
            }
            Greenfoot.delay(1);
        }
    }
    public void setUp()
    {
        //Este pus sus steagul României.
        while(getObjects(steag_RO.class).get(0).getY()>328)
        {
           getObjects(steag_RO.class).get(0).setLocation(getObjects(steag_RO.class).get(0).getX(), getObjects(steag_RO.class).get(0).getY()-2);
           if(709-getObjects(steag_RO.class).get(0).getY()<=225)
           {
                getObjects(steag_RO.class).get(0).getImage().setTransparency(709-getObjects(steag_RO.class).get(0).getY());
           }
           Greenfoot.delay(1);
        }
    }
    public void prepare()
    {
        steag_AUN steag_AUN = new steag_AUN();
        addObject(steag_AUN,786,329);
        steag_RO steag_RO = new steag_RO();
        addObject(steag_RO,786,710);
        steag_RO.getImage().setTransparency(0);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 650);
        text.getImage().setTransparency(0);
    }
}
