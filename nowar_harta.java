import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Loc de verificare al progresului și scenă de final.
 */
public class nowar_harta extends scene_birou
{
    public static boolean[] OKman=new boolean[22];
    public String[] imagini={"harta_normala.jpg", "wBR.jpg", "wTR.jpg", "atAU.jpg", "atRU.jpg", "defAU.jpg", "defRU.jpg", "atRUwTR.jpg", "defRUwTR.jpg", "defRUwBR.jpg", "atAUwBR.png", "defAUwBR.jpg", "defAUwTR.jpg", "Ro_Mare.jpg", "defAUtot.png", "defRUtot.jpg", "RON.png", "TRO.jpg", "BRO.jpg", "NOCAD.jpg", "ROCAD.jpg", "hartacut.jpg"};
    /**
     * Constructor for objects of class nowar_harta.
     * 
     */
    public nowar_harta()
    {
        init();
        prepare();
        if(mainroom.countdays==42)
        {
            getObjects(Inter.class).get(0).passday1(0);
        }
    }
    public void act()
    {
        //Dacă jocul se termină, atunci are loc scena de final.
        if(mainroom.countdays==42)
        {
            Greenfoot.playSound("sumup.mp3");
            if(OKman[20]==true)
            {
                getObjects(Text.class).get(0).TextFadeIn(0,"Datorită contribuțiilor sale în timpul războiului\n Aurel a primit Cadrilaterul, formând astfel România autentică.", 40, Color.WHITE);
            }
            else if(OKman[19]==true)
            {
                getObjects(Text.class).get(0).TextFadeIn(0,"Aurel a reușit să formeze România Mare, lipsindu-i însă Cadrilaterul.\n Imensul succes a acoperit, totuși, acest neajuns.", 40, Color.WHITE);
            }
            else if(OKman[18]==true)
            {
                 getObjects(Text.class).get(0).TextFadeIn(0,"Aurel a reușit să obțină doar Basarabia, lipsindu-i Transilvania și Cadrilaterul.\n Succesul a acoperit, totuși, acest neajuns.", 40, Color.WHITE);
            }
            else if(OKman[17]==true)
            {
                getObjects(Text.class).get(0).TextFadeIn(0,"Aurel a reușit să obțină doar Transilvania, lipsindu-i Basarabia și Cadrilaterul.\n Succesul a acoperit, totuși, acest neajuns.", 40, Color.WHITE);
            }
            else
            {
                getObjects(Text.class).get(0).TextFadeIn(0,"Aurel nu a reușit să obțină niciun teritoriu\n pe timpul războiului. Cu toate acestea, Conducătorul speră\n să obțină teritoriile cu un alt prilej.", 40, Color.WHITE);
            }
            Greenfoot.delay(300);
            getObjects(Text.class).get(0).TextFadeOut(0);
            getObjects(Inter.class).get(0).passday2(0);
            Greenfoot.delay(300);
            getObjects(Inter.class).get(0).passday1(0);
            Greenfoot.setWorld(new alegeri());
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        if(mainroom.countdays!=42)
        {
            exit_help exit_help = new exit_help();
            addObject(exit_help,1233,37); 
        }
        else
        {
            Inter inter= new Inter();
            addObject(inter, 640, 355);
            getObjects(Inter.class).get(0).init();
            Text text=new Text();
            addObject(text,640,355);
        }
    }
    public void init()
    {
        int i;
        for(i=0; i<22; i++)
        {
            if(OKman[i]==true)
            {
                setBackground(new GreenfootImage(imagini[i]));
            }
        }
    }
}
