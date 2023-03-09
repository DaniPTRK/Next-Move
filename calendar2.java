import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Codul este similar cu cel de la primul calendar, având doar o apariție de text.
 */
public class calendar2 extends cutsceneintro
{

        /**
         * Constructor for objects of class calendar2.
         * 
         */
        public calendar2()
        {
            prepare();
            getObjects(Inter.class).get(0).passday1(0);
        }
        public void act()
        {
           getObjects(Inter.class).get(0).passday2(0);
           Greenfoot.playSound("cal2.mp3");
           getObjects(Text.class).get(0).TextFadeIn(0,"În anul 1939, a fost ales conducătorul României, Aurel câștigând detașat.", 40, Color.WHITE);
           Greenfoot.delay(240);
           getObjects(Text.class).get(0).TextFadeOut(0);
           getObjects(Inter.class).get(0).passday1(0);
           Greenfoot.setWorld(new radiocut());
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

