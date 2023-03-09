import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Scenă de alegere a partidelor. Această alegere nu are niciun efect asupra gameplay-ului, însă schimbă anunțul dat la radio în legătură cu câștigarea mandatului de către Aurel.
 */
public class choice_par extends choices
{
    public static boolean OKpar[]=new boolean[]{false, false, false};
    public boolean OKr=false;
    boolean OKp=false, OKa=false;
    int coord[][]=new int[6][2];
    int coords[][]=new int[6][2];
    GreenfootSound backg= new GreenfootSound("choice.mp3");
    /**
     * Constructor for objects of class choice_par.
     * 
     */
    public choice_par()
    {
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
        //În funcție de partidul ales, atât ștampila, cât și semnătura vor apărea în poziții diferite.
        if(OKr==false)
        {
            getObjects(Inter.class).get(0).passday2(0);
            OKr=true;
            init();
            removeObject(getObjects(Inter.class).get(0));
            backg.playLoop();
        }
        if(Greenfoot.mouseClicked(getObjects(pc.class).get(0)))
        {
                aparitie(0);
                change(0);
        }
        if(Greenfoot.mouseClicked(getObjects(pcl.class).get(0)))
        {
                aparitie(2);
                change(1);
        }
        if(Greenfoot.mouseClicked(getObjects(pt.class).get(0)))
        {
                aparitie(4);
                change(2);
        }
            if((OKa==false)&&((OKpar[0]==true)||(OKpar[1]==true)||(OKpar[2]==true)))
            {
                aparitieb();
                OKa=true;
        }
        if((getObjects(sageata.class).get(0).getImage().getTransparency()==255)&&(Greenfoot.mouseClicked(getObjects(sageata.class).get(0))))
        {
            backg.stop();
            Greenfoot.playSound("par_chosen.mp3");
             choice();
            OKp=true;
        }
        if(OKp==true)
        {
            OKp=false;
            Inter inter= new Inter();
            addObject(inter, 640, 355);
            getObjects(Inter.class).get(0).getImage().setTransparency(0);
            getObjects(Inter.class).get(0).init();
            disparitie();
            getObjects(Inter.class).get(0).passday1(0);
            Greenfoot.setWorld(new calendar2());
        }
    }
    private void choice()
    {
        int i;
        for(i=0; i<3; i++)
        {
            if(OKpar[i]==true)
            {
                signing(i*2);
            }
        }
    }
    private void change(int j)
    {
        int i, k;
        for(i=0; i<3; i++)
        {
            if(i==j)
            {
                OKpar[i]=true;
            }
            else if(OKpar[i]==true)
            {
                for(k=255; k>=0; k=k-17)
                {
                    getObjects(approved.class).get(i).getImage().setTransparency(k);
                    Greenfoot.delay(1);
                }
            }
            if(i!=j)
            {
                OKpar[i]=false;
            }
        }
    }
    private void aparitieb()
    {
        //Apariție a textului în urma unei alegeri realizate. Utilizatorul poate să-și continue alegerile până când este decis.
        getObjects(Text.class).get(0).setImage(new GreenfootImage ("Când te simți pregătit, apasă pe săgeata pentru a-ți confirma alegerea.", 30, Color.WHITE, new Color(0,0,0,0)));
        getObjects(Text.class).get(0).getImage().setTransparency(0);
        int i;
        for(i=0; i<=255; i=i+5)
        {
            getObjects(Text.class).get(0).getImage().setTransparency(i);
            getObjects(sageata.class).get(0).getImage().setTransparency(i);
            Greenfoot.delay(1);
        }
    }
    private void aparitie(int i)
    {
        //Efectul de ștampilare.
        int j=17;
        getObjects(stampila.class).get(0).setLocation(coord[i][0], coord[i][1]);
        Greenfoot.playSound("stamp.mp3");
        while(getObjects(stampila.class).get(0).getY()<coord[i+1][1])
        {
            if(getObjects(stampila.class).get(0).getX()<coord[i+1][0])
            {
                getObjects(stampila.class).get(0).setLocation(getObjects(stampila.class).get(0).getX()+4,getObjects(stampila.class).get(0).getY()+6);
            }
            else
            {
                getObjects(stampila.class).get(0).setLocation(getObjects(stampila.class).get(0).getX(),getObjects(stampila.class).get(0).getY()+6);
            }
            if(getObjects(stampila.class).get(0).getImage().getTransparency()<255)
            {
                getObjects(stampila.class).get(0).getImage().setTransparency(j);
                j=j+17;
            }
            Greenfoot.delay(2);
        }
        getObjects(approved.class).get(i/2).getImage().setTransparency(255);
        for(j=255; j>=0; j=j-17)
        {
            getObjects(stampila.class).get(0).getImage().setTransparency(j);
            Greenfoot.delay(3);
        }
    }
        public void disparitie()
    {
        //Dispariția textului în urma alegerii realizate.
        int i;
        for(i=255; i>=0; i=i-5)
        {
            getObjects(Text.class).get(0).getImage().setTransparency(i);
            getObjects(sageata.class).get(0).getImage().setTransparency(i);
            Greenfoot.delay(1);
        }
    }
    public void signing(int i)
    {
        //Semnarea actului ales de către utilizator în urma ștampilării.
        int j=51;
        getObjects(stilou.class).get(0).setLocation(coords[i][0], coords[i][1]);
        Greenfoot.playSound("sign_sound.mp3");
        while(getObjects(stilou.class).get(0).getX()<coords[i+1][0])
        {
            getObjects(stilou.class).get(0).setLocation(getObjects(stilou.class).get(0).getX()+2, getObjects(stilou.class).get(0).getY()+Greenfoot.getRandomNumber(3));
            getObjects(stilou.class).get(0).setLocation(getObjects(stilou.class).get(0).getX()+2, getObjects(stilou.class).get(0).getY()-Greenfoot.getRandomNumber(3));
            if(getObjects(stilou.class).get(0).getImage().getTransparency()<255)
            {
                getObjects(stilou.class).get(0).getImage().setTransparency(j);
                getObjects(semnat.class).get(i/2).getImage().setTransparency(j);
                j=j+51;
            }
            Greenfoot.delay(3);
        }
        for(j=255; j>=0; j=j-51)
        {
            getObjects(stilou.class).get(0).getImage().setTransparency(j);
            Greenfoot.delay(3);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        pcl pcl = new pcl();
        addObject(pcl,744,476);
        pt pt = new pt();
        addObject(pt,1066,519);
        pc pc = new pc();
        addObject(pc,468,418);
        approved approved = new approved();
        addObject(approved, 440,493);
        approved.getImage().setTransparency(0);
        approved approved2 = new approved();
        addObject(approved2, 728,560);
        approved2.getImage().setTransparency(0);
        approved approved3 = new approved();
        addObject(approved3, 1055,590);
        approved3.getImage().setTransparency(0);
        stampila stamp=new stampila();
        addObject(stamp,50,50);
        stamp.getImage().setTransparency(0);
        semnat semnat = new semnat();
        semnat.getImage().setTransparency(0);
        addObject(semnat,522,592);
        semnat semnat2 = new semnat();
        addObject(semnat2, 841,628);
        semnat2.getImage().setTransparency(0);
        semnat semnat3 = new semnat();
        addObject(semnat3,1167,657);
        semnat3.getImage().setTransparency(0);
        stilou stilou = new stilou();
        addObject(stilou,1156,612);
        stilou.getImage().setTransparency(0);
        Text text=new Text();
        addObject(text, 640, 20);
        text.getImage().setTransparency(0);
        sageata sageata = new sageata();
        addObject(sageata,1169,89);
        sageata.getImage().setTransparency(0);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
    }
    private void init()
    {
        int i;
        for(i=0; i<6; i=i+2)
        {
            coord[i+1][0]=getObjects(approved.class).get(i/2).getX()-5;
            coord[i+1][1]=getObjects(approved.class).get(i/2).getY()-25;
            coord[i][0]=coord[i+1][0]-39;
            coord[i][1]=coord[i+1][1]-50;
            coords[i+1][0]=getObjects(semnat.class).get(i/2).getX()+66;
            coords[i+1][1]=0;
            coords[i][0]=getObjects(semnat.class).get(i/2).getX()-11;
            coords[i][1]=getObjects(semnat.class).get(i/2).getY()-45;
        }
    }
}
