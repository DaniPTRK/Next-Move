import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Aici este prezentată scăderea treptată a pamânturilor deținute de România.
 * Această scenă apare și atunci când utilizatorul pierde în fața Rusiei sau a Austro-Ungariei.
 */
public class nofront_harta extends cutsceneintro
{
    String[] ani={"1927", "1939"};
    /**
     * Constructor for objects of class nofront_harta.
     * 
     */
    public nofront_harta()
    {
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
        //Această condiție evidențiază dubla utilizare a scenei.
        //Dacă mainroom.win este egal cu 0, vom privi scena când România pierde pământurile.
        //În caz contrar, vom privi scena care prezintă dispariția României de pe hartă ca urmare a înfrângerii.
        if(mainroom.win==0)
        {
            getObjects(Text.class).get(0).TextFadeIn(0,"Din păcate, până la începutul guvernării sale,\n România a suferit schimbări majore...",50, Color.WHITE);
            Greenfoot.delay(300);
            Greenfoot.playSound("pierdereter_sound.mp3");
            getObjects(Text.class).get(0).TextFadeOut(0);
            getObjects(Text.class).get(1).TextFadeIn(1,"1918",50, Color.BLACK);
            getObjects(Inter.class).get(0).passday2(0);
            Greenfoot.delay(60);
            transition(0, getObjects(frontieramare.class).get(0), getObjects(frontieramijlocie.class).get(0),1,2);
            transition(1, getObjects(frontieramijlocie.class).get(0), getObjects(frontieramica.class).get(0),2,1);
            Greenfoot.delay(30);
            getObjects(Inter.class).get(0).passday1(0);
            getObjects(Text.class).get(0).TextFadeIn(0,"Acest fapt, însă, l-a motivat mai mult pe Aurel\n să-și pornească candidatura și să-și conducă partidul cu indârjire.",50, Color.WHITE);
            Greenfoot.delay(300);
            getObjects(Text.class).get(0).TextFadeOut(0);
            Greenfoot.setWorld(new choice_par());
        }
        else
        {
            getObjects(frontieramare.class).get(0).getImage().setTransparency(0);
            getObjects(Text.class).get(0).TextFadeIn(0,"România a dispărut de pe hartă,\n aceasta fiind împărțită între Rusia și Austro-Ungaria.",35, Color.WHITE);
            Greenfoot.delay(300);
            getObjects(Text.class).get(0).TextFadeOut(0);
            getObjects(Inter.class).get(0).passday2(0);
            Greenfoot.delay(300);
            getObjects(Inter.class).get(0).passday1(0);
            Greenfoot.setWorld(new credits());
        }
    }
    public void transition(int r, Actor gout, Actor gin, int o1, int o2)
    {
        //Tranziție de la o frontieră la alta. Actorii gout și gin preiau frontierele, în timp ce o1 și o2 preiau poziții din vectorul de obiecte Text.
        //Numărul întreg r sugerează poziția din vectorul de Stringuri numit "ani".
          int i;
          getObjects(Text.class).get(o2).setImage(new GreenfootImage(ani[r], 50, Color.BLACK, new Color(0,0,0,0)));
          for(i=0; i<256; i=i+5)
          {
              gout.getImage().setTransparency(255-i);
              getObjects(Text.class).get(o1).getImage().setTransparency(255-i);
              getObjects(Text.class).get(o2).getImage().setTransparency(i);
              gin.getImage().setTransparency(i);
              Greenfoot.delay(3);
          }
          Greenfoot.delay(30);
    }
    private void prepare()
    {
        frontieramare frontieramare = new frontieramare();
        addObject(frontieramare,638,352);
        frontieramijlocie frontieramijlocie = new frontieramijlocie();
        addObject(frontieramijlocie,638,352);
        frontieramijlocie.getImage().setTransparency(0);
        frontieramica frontieramica = new frontieramica();
        addObject(frontieramica,638,352);
        frontieramica.getImage().setTransparency(0);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 355);
        text.getImage().setTransparency(0);
        Text text2=new Text();
        addObject(text2, 640, 25);
        text2.getImage().setTransparency(0);
        Text text3=new Text();
        addObject(text3, 640, 25);
        text3.getImage().setTransparency(0);
    }
}
