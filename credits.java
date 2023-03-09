import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creditele jocului
 */
public class credits extends scene_ending
{
    int i,j,or=0;
    public GreenfootSound music;
    /**
     * Constructor for objects of class credits.
     * 
     */
    public credits()
    {    
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
        getObjects(Text.class).get(0).setImage(new GreenfootImage("Jocul NEXT MOVE v-a fost oferit de echipa Road To Knowledge:", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(1).setImage(new GreenfootImage("Niță Eduard-Eugen", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(2).setImage(new GreenfootImage("Ion Daniel", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(3).setImage(new GreenfootImage("Programare ", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(4).setImage(new GreenfootImage("Documentare și întrebări", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(5).setImage(new GreenfootImage("Efecte sonore ", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(6).setImage(new GreenfootImage("Scenarii", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(7).setImage(new GreenfootImage("Animații și Background Design", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(8).setImage(new GreenfootImage("Elemente grafice", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(9).setImage(new GreenfootImage("Profesor coordonator: Sorin Bardac", 30, Color.BLACK, new Color(0,0,0,0)));
        getObjects(Text.class).get(10).setImage(new GreenfootImage("Vă mulțumim pentru atenție!", 50, Color.BLACK, new Color(0,0,0,0)));
        for(i=0;i<11;i++)
        {
           getObjects(Text.class).get(i).getImage().setTransparency(0);
        }
    }
    //Apariția gradual a textului.
    public void act()
    {
        if(or==0)
        {
            placeSound();
            getObjects(Inter.class).get(0).passday2(0);
            for(i=0; i<11; i++)
            {
                for(j=0; j<=255; j=j+5)
                {
                    if((i>=1)&&(i<9))
                    {
                        getObjects(Text.class).get(i).getImage().setTransparency(j);
                        getObjects(Text.class).get(i+1).getImage().setTransparency(j);
                    }
                    else
                    {
                        getObjects(Text.class).get(i).getImage().setTransparency(j);
                    }
                    Greenfoot.delay(3);
                }
                if((i>=1)&&(i<9))
                {
                    i=i+1;
                }
            }
            exit_help exit_help = new exit_help();
            addObject(exit_help,1233,37); 
            or++;
        }
    }
    public void placeSound()
    {
        if((mainroom.win==0)&&((nowar_harta.OKman[20]==true)||(nowar_harta.OKman[19]==true)))
        {
            music=new GreenfootSound("Good_ending.mp3");
            music.play();
        }
        else if(mainroom.win<0)
        {
            music=new GreenfootSound("Bad_Ending.mp3");
            music.play();
        }
        else
        {
            music=new GreenfootSound("Neutral_ending.mp3");
            music.play();
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Text text = new Text();
        addObject(text,640,62);
        Text text2 = new Text();
        addObject(text2,850,125);
        Text text3 = new Text();
        addObject(text3,400,125);
        Text text4 = new Text();
        addObject(text4,400,200);
        Text text5 = new Text();
        addObject(text5,850,200);
        Text text6 = new Text();
        addObject(text6,400,275);
        Text text7 = new Text();
        addObject(text7,850,275);
        Text text8 = new Text();
        addObject(text8,400,350);
        Text text9 = new Text();
        addObject(text9, 850,350);
        Text text10 = new Text();
        addObject(text10,640,450);
        Text text11 = new Text();
        addObject(text11,640,559);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
    }
}
