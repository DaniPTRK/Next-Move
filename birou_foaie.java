import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Loc de verificare al scenariilor.
 */
public class birou_foaie extends scene_birou
{
    public static String[] scenariu=new String[]{"S1.png","S2.png","S3.png","S4.png","S5.png","S6.png","S7.png","S8.png","S9.png","S10.png","S11.png","S12.png","S13.png","S14.png","S15.png","S16.png","S17.png","S18.png","S19.png","S20.png","S21.png","S22.png","S23.png","S24.png","S25.png","S26.png","S27.png","S28.png","S29.png","S30.png","S31.png","S32.png","S33.png","S34.png","S35.png","S36.png","S37.png","S38.png","S39.png","M1.png","M2.png","M3.png","M4.png","M7.png","M6.png","M5.png", "AtRU.png","AtAU.png","ApRU.png","ApAU.png"};
    public static String[][] cons=new String[][]{{"SD1.png","SN1.png"},{"SD2.png","SN2.png"},{"SD3.png","SN3.png"},{"SD4.png","SN4.png"},{"SD5.png","SN5.png"},{"SD6.png","SN6.png"},{"SD7.png","SN7.png"},{"SD8.png","SN8.png"},{"SD9.png","SN9.png"},{"SD10.png","SN10.png"},{"SD11.png","SN11.png"},{"SD12.png","SN12.png"},{"SD13.png","SN13.png"},{"SD14.png","SN14.png"},{"SD15.png","SN15.png"},{"SD16.png","SN16.png"},{"SD17.png","SN17.png"},{"SD18.png","SN18.png"},{"SD19.png","SN19.png"},{"SD20.png","SN20.png"},{"SD21.png","SN21.png"},{"SD22.png","SN22.png"},{"SD23.png","SN23.png"},{"SD24.png","SN24.png"},{"SD25.png","SN25.png"},{"SD26.png","SN26.png"},{"SD27.png","SN27.png"},{"SD28.png","SN28.png"},{"SD29.png","SN29.png"},{"SD30.png","SN30.png"},{"SD31.png","SN31.png"},{"SD32.png","SN32.png"},{"SD33.png","SN33.png"},{"SD34.png","SN34.png"},{"SD35.png","SN35.png"},{"SD36.png","SN36.png"},{"SD37.png","SN37.png"},{"SD38.png","SN38.png"},{"SD39.png","SN39.png"},{"MD1.png","MN1.png"},{"MD2.png","MN2.png"},{"MD3.png","MN3.png"},{"MD4.png","MN4.png"},{"MD7.png","MN7.png"},{"MN6.png","MD6.png"},{"MD5.png","MN5.png"}};
    public static int[][] ress=new int[][]{{0,0,-1,0,0,0},{-1,2,-1,0,0,1},{0,0,1,-1,1,0},{-1,1,0,0,0,0},{2,0,-1,0,0,0},{0,-1,2,-1,0,-1},{-1,2,-1,-1,0,2},{0,1,1,0,-1,-1},{-2,1,0,0,0,0},{0,2,-2,0,-2,2},{2,0,0,0,0,0},{-1,0,1,0,0,-1},{-2,0,4,0,0,-3},{0,0,-1,-1,0,0},{0,1,0,0,-1,0},{0,-1,1,0,1,-1},{0,0,-3,0,0,1},{0,-1,0,0,0,1},{1,-1,0,0,0,0},{2,-1,0,0,0,0},{-1,0,2,0,0,-1},{-1,1,0,0,-1,0},{-1,0,1,0,0,-1},{-2,0,0,0,0,0},{1,0,0,0,0,0},{-1,0,0,0,0,0},{1,0,0,0,0,0},{0,0,-1,0,0,-1},{0,0,1,0,0,-1},{-1,-1,0,0,1,0},{0,0,-1,0,0,0},{-2,1,0,0,-1,0},{-1,1,0,0,-1,0},{-1,0,0,0,-1,0},{-2,1,0,0,0,0},{0,0,1,0,0,0},{0,1,-1,0,-1,1},{0,0,-2,0,0,-1},{0,1,0,0,-1,0},{-1,0,0,0,0,0},{0,-1,0,0,0,0},{0,1,0,0,0,0},{1,0,0,0,0,0},{0,1,-1,0,-1,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
    public static boolean[] wass=new boolean[56];
    public static int ch=-1, ant=0;
    public static int st=-1;
    public static int resinf=0;
    public static String[] today=new String[6];
    public static int[] transp={128,128};
    int i=0, or=0, ij=0;
    int k;
    String n="-";
    Color[] cl={Color.YELLOW, Color.GREEN, Color.BLUE};
    /**
     * Constructor for objects of class birou_foaie.
     * 
     */
    public birou_foaie()
    {
        prepare();
    }
    public void act()
    {
        //Similiar cu codul de la manualul de război, este verificat numărul paginii și puse sau scoase diferite obiecte în funcție de acesta.
        if((i==0)&&(i==ant)&&(or==0))
        {
            da da = new da();
            addObject(da,788,608);
            nu nu = new nu();
            addObject(nu,561,608);
            if((ch==44)||(ch==45))
            {
                getObjects(da.class).get(0).setImage("aliatii.png");
                getObjects(nu.class).get(0).setImage("axa.png");
            }
            getObjects(da.class).get(0).getImage().setTransparency(transp[0]);
            getObjects(nu.class).get(0).getImage().setTransparency(transp[1]);
            or++;
        }
        if(mainroom.countdays!=1)
        {
            if(or==0)
            {
                fdr fdr = new fdr();
                addObject(fdr,864,67);
                if(i==resinf)
                {
                    r_sig r_sig = new r_sig();
                    addObject(r_sig,550,413);
                    p_sig p_sig = new p_sig();
                    addObject(p_sig,815,418);
                    m_sig m_sig = new m_sig();
                    addObject(m_sig,684,418);
                    Text textr=new Text();
                    addObject(textr,550,390);
                    Text textm=new Text();
                    addObject(textm,684,390);
                    Text textp=new Text();
                    addObject(textp,815,390);
                    for(k=0;k<3;k++)
                    {
                        if(mainroom.changes[k]>=0)
                        {
                            n="+";
                        }
                        else
                        {
                            n="";
                        }
                        getObjects(Text.class).get(k).setImage(new GreenfootImage(n+mainroom.changes[k], 40, cl[k], new Color(0,0,0,0)));
                    }
                }
                or++;
            }
            if((i<ant)&&(Greenfoot.mouseClicked(getObjects(fdr.class).get(0))))
            {
                Greenfoot.playSound("openhelp.mp3");
                turn(i+1);
                i++;
            }
            if((i>0)&&(Greenfoot.mouseClicked(getObjects(fst.class).get(0))))
            {
                Greenfoot.playSound("openhelp.mp3");
                turn(i-1);
                i--;
            }
        }
        if(i==ant)
        {
            //Alegerile determină schimbarea unei valori st în 0 sau 1, valoare ce are efect asupra consecinței.
            if(Greenfoot.mouseClicked(getObjects(da.class).get(0)))
            {
                mainroom.OKdecis[0]=true;
                if(st!=0)
                {
                    Greenfoot.playSound("ok.mp3");
                }
                st=0;
                if((ch==44)||(ch==45))
                {
                    mainroom.alliance[0]=true;
                    mainroom.alliance[1]=false;
                }
                transp[0]=255;
                transp[1]=128;
                getObjects(da.class).get(0).getImage().setTransparency(transp[0]);
                getObjects(nu.class).get(0).getImage().setTransparency(transp[1]);
            }
            else if(Greenfoot.mouseClicked(getObjects(nu.class).get(0)))
            {
                mainroom.OKdecis[0]=true;
                if(st!=1)
                {
                    Greenfoot.playSound("no.mp3");
                }
                st=1;
                if((ch==44)||(ch==45))
                {
                    mainroom.alliance[0]=false;
                    mainroom.alliance[1]=true;
                }
                transp[0]=128;
                transp[1]=255;
                getObjects(da.class).get(0).getImage().setTransparency(transp[0]);
                getObjects(nu.class).get(0).getImage().setTransparency(transp[1]);
            }
        }
    }
    public void turn(int i)
    {
        //Procese de schimbare ale paginilor, obiectelor de pe acestea și de verificare a paginii.
        getObjects(foaie.class).get(0).setImage(today[i]);
        if(i==0)
        {
            removeObject(getObjects(fst.class).get(0));
        }
        else if((i==1)&&(i>ij))
        {
            fst fst= new fst();
            addObject(fst,480,65);
        }
        if(i==resinf)
        {
             r_sig r_sig = new r_sig();
             addObject(r_sig,550,413);
             p_sig p_sig = new p_sig();
             addObject(p_sig,815,418);
             m_sig m_sig = new m_sig();
             addObject(m_sig,684,418);
             Text textr=new Text();
             addObject(textr,550,390);
             Text textm=new Text();
             addObject(textm,684,390);
             Text textp=new Text();
             addObject(textp,815,390);
             for(k=0;k<3;k++)
             {
                 if(mainroom.changes[k]>=0)
                 {
                     n="+";
                 }
                 else
                 {
                     n="";
                 }
                 getObjects(Text.class).get(k).setImage(new GreenfootImage(n+mainroom.changes[k], 40, cl[k], new Color(0,0,0,0)));
             }
        }
        else if((i!=resinf)&&(ij==resinf))
        {
            removeObject(getObjects(r_sig.class).get(0));
            removeObject(getObjects(p_sig.class).get(0));
            removeObject(getObjects(m_sig.class).get(0));
            removeObject(getObjects(Text.class).get(2));
            removeObject(getObjects(Text.class).get(1));
            removeObject(getObjects(Text.class).get(0));
        }
        if(i==ant)
        {
            removeObject(getObjects(fdr.class).get(0));
            da da = new da();
            addObject(da,788,608);
            nu nu = new nu();
            addObject(nu,561,608);
            if((ch==44)||(ch==45))
            {
                getObjects(da.class).get(0).setImage("aliatii.png");
                getObjects(nu.class).get(0).setImage("axa.png");
            }
            getObjects(da.class).get(0).getImage().setTransparency(transp[0]);
            getObjects(nu.class).get(0).getImage().setTransparency(transp[1]);
        }
        if((i==ant-1)&&(i<ij))
        {
           fdr fdr= new fdr();
           addObject(fdr,864, 67);
           removeObject(getObjects(da.class).get(0));
           removeObject(getObjects(nu.class).get(0));
        }
        ij=i;
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        foaie foaie = new foaie();
        addObject(foaie,682,369);
        if(today[0]!=null)
        {
            foaie.setImage(today[0]);
        }
        exit_help exit_help = new exit_help();
        addObject(exit_help,1233,37); 
    }
}
