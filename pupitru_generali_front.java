import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Loc de analizare a miniștrilor deținuți actual, dar și loc de alegere a ministrului/diplomatului demis.
 */
public class pupitru_generali_front extends scene_birou
{
    public boolean turn=false;
    public Actor[] positions;
    public boolean[] OKe={false, false, false, false};
    public String[] imagini=new String[] {"PC-RES_Card_Final_Perspectiva.png", "PC-MIL_Card_Final_Perspectiva.png", "PC-POP_Card_Final_Perspectiva.png", "PC-DIPL_Card_Final_Perspectiva.png", "PCL-RES_Card_Final_Perspectiva.png", "PCL-MIL_Card_Final_Perspectiva.png", "PCL-POP_Card_Final_Perspectiva.png", "PCL-DIPL_Card_Final_Perspectiva.png", "PT-RES_Card_Final_Perspectiva.png", "PT-MIL_Card_Final_Perspectiva.png", "PT-POP_Card_Final_Perspectiva.png", "PT-DIPL_Card_Final_Perspectiva.png","PC-RES_Card_Final_Perspectiva_Outline.png", "PC-MIL_Card_Final_Perspectiva_Outline.png", "PC-POP_Card_Final_Perspectiva_Outline.png", "PC-DIPL_Card_Final_Perspectiva_Outline.png", "PCL-RES_Card_Final_Perspectiva_Outline.png", "PCL-MIL_Card_Final_Perspectiva_Outline.png", "PCL-POP_Card_Final_Perspectiva_Outline.png", "PCL-DIPL_Card_Final_Perspectiva_Outline.png", "PT-RES_Card_Final_Perspectiva_Outline.png", "PT-MIL_Card_Final_Perspectiva_Outline.png", "PT-POP_Card_Final_Perspectiva_Outline.png", "PT-DIPL_Card_Final_Perspectiva_Outline.png"};
    public int[] pos=new int[4];
    public static int[] l=new int[20];
    public static int cont=0;
    /**
     * Constructor for objects of class pupitru_generali_front.
     * 
     */
    public pupitru_generali_front()
    {
        prepare();
        init();
        check();
    }
    public void act()
    {
        //În cazul în care panoul de control este utilizat pentru a da afară un ministru/diplomat, această condiție este adevărată, și deci pupitrul devine un element utilizat atât pentru
        //administrare a miniștrilor și diplomatului, cât și de analizare.
        if(panou_control.OKc==true)
        {
            pick();
            if((turn==true)&&(Greenfoot.mouseClicked(getObjects(butonpupitru.class).get(0))))
            {
                getObjects(Text.class).get(0).TextFadeOut(0);                
                Greenfoot.setWorld(new choice_gen());
            }
        }
    }
    public void pick()
    {
        //În funcție de alegerea realizată de utilizator, va apărea un outline în jurul ministrului/diplomatului pe care vrea să-l elimine. Acesta poate elimina UN singur ministru/diplomat.
        int i,j;
        for(i=0; i<4; i++)
        {
            if(Greenfoot.mouseClicked(positions[i]))
            {
                Greenfoot.playSound("card_choice.mp3");
                positions[i].setImage(imagini[pos[i]+12]);
                l[cont]=pos[i];
                for(j=0;j<4;j++)
                {
                    OKe[j]=false;
                }
                OKe[i]=true;
            }
        }
        for(i=0; i<4; i++)
        {
            if(OKe[i]!=true)
            {
                positions[i].setImage(imagini[pos[i]]);
            }
            if((OKe[i]==true)&&(turn==false))
            {
                turn=true;
                butonpupitru butonpupitru = new butonpupitru();
                addObject(butonpupitru,1166,540);
                getObjects(Text.class).get(0).TextFadeIn(0,"Apasă pe săgeată atunci când ai ales Ministrul sau Diplomatul eliminat.", 30, Color.WHITE);
            }
        }
    }
    public void check()
    {
        //Aici sunt setate imaginile la normal în cazul în care utilizatorul își schimbă alegerea.
        int i;
        for(i=0; i<12;i++)
        {
            if(choice_gen.OKim[i]==true)
            {
                if(i<=3)
                {
                    positions[i].setImage(imagini[i]);
                    pos[i]=i;
                }
                else if(i<=7)
                {
                    positions[i-4].setImage(imagini[i]);
                    pos[i-4]=i;
                }
                else if(i<=11)
                {
                    positions[i-8].setImage(imagini[i]);
                    pos[i-8]=i;
                }
            }
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        cdiplp cdiplp = new cdiplp();
        addObject(cdiplp,958,401);
        cmilp cmilp = new cmilp();
        addObject(cmilp,591,401);
        cpopp cpopp = new cpopp();
        addObject(cpopp,774,401);
        cresp cresp = new cresp();
        addObject(cresp,408,401);
        exit_help exit_help = new exit_help();
        addObject(exit_help,1233,37);
        Text text=new Text();
        addObject(text, 640, 210);
        text.getImage().setTransparency(0);
    }

    public void init()
    {
        positions=new Actor[]{getObjects(cresp.class).get(0),getObjects(cmilp.class).get(0),getObjects(cpopp.class).get(0),getObjects(cdiplp.class).get(0)};
    }
}
