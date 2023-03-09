import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Aceasta este scena care prezintă lupta dintre Aurel și dușmanii săi
 */
public class front extends cutsceneintro
{
    /**
     * 
     * 
     */
    public front()
    {
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
           getObjects(Inter.class).get(0).passday2(0);
           Greenfoot.playSound("front.mp3");
           appearance();
           getObjects(Text.class).get(0).TextFadeIn(0,"Viitorul cârmuitor al țării și-a condus cu vitejie armata\n în lupta decisivă contra Imperiului Austro-Ungar\n care s-a încheiat cu...", 40, Color.WHITE);
           Greenfoot.delay(240);
           combine();
        Greenfoot.setWorld(new zoomfront());
    }
    public void appearance()
    {
        //Este setată concomitent transparența la 255(opacitate maximă) a trupelor conduse de Aurel și cele formate din soldați austro-ungari.
        int i=0;
        while(i!=256)
        {
            getObjects(mars.class).get(0).getImage().setTransparency(i);
            getObjects(mars.class).get(0).setLocation(i, getObjects(mars.class).get(0).getY());
            getObjects(mars_inamic.class).get(0).getImage().setTransparency(i);
            getObjects(mars_inamic.class).get(0).setLocation(getWidth()-i, getObjects(mars.class).get(0).getY());
            i++;
            Greenfoot.delay(1);
        }
    }
    public void combine()
    {
          //Îndreptarea celor două trupe una spre cealaltă și întunecarea cadrului.
          int i;
          for(i=0; i<256; i=i+5)
          {
              getObjects(Text.class).get(0).getImage().setTransparency(255-i);
              getObjects(Inter.class).get(0).getImage().setTransparency(i);
              getObjects(mars.class).get(0).setLocation(getObjects(mars.class).get(0).getX()+2, getObjects(mars.class).get(0).getY());
              getObjects(mars_inamic.class).get(0).setLocation(getObjects(mars_inamic.class).get(0).getX()-2, getObjects(mars_inamic.class).get(0).getY());
              getObjects(mars.class).get(0).getImage().setTransparency(255-i);
              getObjects(mars_inamic.class).get(0).getImage().setTransparency(255-i);
              Greenfoot.delay(1);
          }
    }
    public void prepare()
    {
        mars mars = new mars();
        addObject(mars,248,317);
        mars.getImage().setTransparency(0);
        mars_inamic mars_inamic = new mars_inamic();
        addObject(mars_inamic,1016,320);
        mars_inamic.getImage().setTransparency(0);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 650);
        text.getImage().setTransparency(0);
    }
}
