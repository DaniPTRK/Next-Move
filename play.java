import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Apăsarea acestui buton determină începerea acțiunii, precum și inițializarea a mai multor variabile statice fără de care jocul nu poate funcționa.
 * Este esențial ca jucătorul să apese pe play, astfel că, în caz contrar, variabilele nu se vor inițializa, iar jocul nu va merge corespunzător.
 */
public class play extends ButoaneStart
{
    /**
     * Act - do whatever the play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(getWorld().getObjects(play.class).get(0)))
        {
            mainroom.countdays=1;
            mainroom.reso=new int[]{5, 5, 5};
            mainroom.bonusuri=new int[][]{{1,1,-1},{0,2,-1},{0,1,0},{0,1,-1},
                                           {2,-1,0},{1,0,0},{1,-1,1},{1,-1,0},
                                           {0,0,1},{-1,1,1},{-1,0,2},{-1,0,1}};
            choice_par.OKpar=new boolean[]{false, false, false};
            mainroom.OKdecis=new boolean[]{false, false, true};
            mainroom.change=true;
            mainroom.dip=new int[]{0,0,0};
            mainroom.px=0;
            mainroom.py=0;
            panou_control.cd=new int[]{0,0,0};
            panou_control.OKc=false;
            pupitru_generali_front.l=new int[20];
            pupitru_generali_front.cont=0;
            choice_gen.o=new int[]{0,0,0};
            choice_gen.OKim=new boolean[22];
            mainroom.OKRU=new boolean[]{false, false};
            mainroom.OKAU=new boolean[]{false, false};
            mainroom.war=false;
            mainroom.OKRUdet=false;
            mainroom.OKAUdet=false;
            mainroom.alliance=new boolean[]{false,false};
            mainroom.OKter=new boolean[]{false,false};
            mainroom.sg=0;
            mainroom.so=new GreenfootSound[7];
            mainroom.win=0;
            birou_foaie.ch=-1;
            birou_foaie.st=-1;
            birou_foaie.ant=0;
            mainroom.OKs=false;
            mainroom.changes=new int[]{0,0,0};
            birou_foaie.scenariu=new String[]{"S1.png","S2.png","S3.png","S4.png","S5.png","S6.png","S7.png","S8.png","S9.png","S10.png","S11.png","S12.png","S13.png","S14.png","S15.png","S16.png","S17.png","S18.png","S19.png","S20.png","S21.png","S22.png","S23.png","S24.png","S25.png","S26.png","S27.png","S28.png","S29.png","S30.png","S31.png","S32.png","S33.png","S34.png","S35.png","S36.png","S37.png","S38.png","S39.png","M1.png","M2.png","M3.png","M4.png","M7.png","M6.png","M5.png","AtRU.png","AtAU.png","ApRU.png","ApAU.png"};
            birou_foaie.cons=new String[][]{{"SD1.png","SN1.png"},{"SD2.png","SN2.png"},{"SD3.png","SN3.png"},{"SD4.png","SN4.png"},{"SD5.png","SN5.png"},{"SD6.png","SN6.png"},{"SD7.png","SN7.png"},{"SD8.png","SN8.png"},{"SD9.png","SN9.png"},{"SD10.png","SN10.png"},{"SD11.png","SN11.png"},{"SD12.png","SN12.png"},{"SD13.png","SN13.png"},{"SD14.png","SN14.png"},{"SD15.png","SN15.png"},{"SD16.png","SN16.png"},{"SD17.png","SN17.png"},{"SD18.png","SN18.png"},{"SD19.png","SN19.png"},{"SD20.png","SN20.png"},{"SD21.png","SN21.png"},{"SD22.png","SN22.png"},{"SD23.png","SN23.png"},{"SD24.png","SN24.png"},{"SD25.png","SN25.png"},{"SD26.png","SN26.png"},{"SD27.png","SN27.png"},{"SD28.png","SN28.png"},{"SD29.png","SN29.png"},{"SD30.png","SN30.png"},{"SD31.png","SN31.png"},{"SD32.png","SN32.png"},{"SD33.png","SN33.png"},{"SD34.png","SN34.png"},{"SD35.png","SN35.png"},{"SD36.png","SN36.png"},{"SD37.png","SN37.png"},{"SD38.png","SN38.png"},{"SD39.png","SN39.png"},{"MD1.png","MN1.png"},{"MD2.png","MN2.png"},{"MD3.png","MN3.png"},{"MD4.png","MN4.png"},{"MD7.png","MN7.png"},{"MD6.png","MN6.png"},{"MD5.png","MN5.png"}};
            birou_foaie.ress=new int[][]{{0,0,-1,0,0,0},{-1,2,-1,0,0,1},{0,0,1,-1,1,0},{-1,1,0,0,0,0},{2,0,-1,0,0,0},{0,-1,2,-1,0,-1},{-1,2,-1,-1,0,2},{0,1,1,0,-1,-1},{-2,1,0,0,0,0},{0,2,-2,0,-2,2},{2,0,0,0,0,0},{-1,0,1,0,0,-1},{-2,0,4,0,0,-3},{0,0,-1,-1,0,0},{0,1,0,0,-1,0},{0,-1,1,0,1,-1},{0,0,-3,0,0,1},{0,-1,0,0,0,1},{1,-1,0,0,0,0},{2,-1,0,0,0,0},{-1,0,2,0,0,-1},{-1,1,0,0,-1,0},{-1,0,1,0,0,-1},{-2,0,0,0,0,0},{1,0,0,0,0,0},{-1,0,0,0,0,0},{1,0,0,0,0,0},{0,0,-1,0,0,-1},{0,0,1,0,0,-1},{-1,-1,0,0,1,0},{0,0,-1,0,0,0},{-2,1,0,0,-1,0},{-1,1,0,0,-1,0},{-1,0,0,0,-1,0},{-2,1,0,0,0,0},{0,0,1,0,0,0},{0,1,-1,0,-1,1},{0,0,-2,0,0,-1},{0,1,0,0,-1,0},{-1,0,0,0,0,0},{0,-1,0,0,0,0},{0,1,0,0,0,0},{1,0,0,0,0,0},{0,1,-1,0,-1,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
            panou_control.hasr=new boolean[]{true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
            panou_control.ansc=new boolean[][]{{true,false,false},{false,false,true},{false,false,true},{false,true,false},{false,false,true},{true,false,false},{false,false,true},{false,true,false},{true,false,false},{false,true,false},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{false,false,true},{false,true,false},{false,false,true},{true,false,false},{false,true,false},{true,false,false},{true,false,false},{false,false,true},{false,true,false},{false,true,false},{false,false,true},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{false,true,false},{true,false,false},{false,true,false},{false,false,true},{false,true,false},{true,false,false},{false,false,true},{false,true,false},{true,false,false},{false,false,true},{true,false,false},{false,false,true},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{true,false,false},{true,false,false},{false,true,false},{false,true,false}};
            birou_foaie.today=new String[6];
            birou_foaie.transp=new int[]{128,128};
            mainroom.helpc=0;
            mainroom.helpd=0;
            birou_foaie.resinf=0;
            Inter inter= new Inter();
            getWorld().addObject(inter, 640, 355);
            initOKim();
            Text text=new Text();
            getWorld().addObject(text,640,355);
            text.getImage().setTransparency(0);
            getWorld().getObjects(Inter.class).get(0).init();
            Greenfoot.playSound("startsc.mp3");
            getWorld().getObjects(Inter.class).get(0).passday1(0);
            disclaimer();
            Greenfoot.setWorld(new calendar());
        }
    }    
        public void initOKim()
    {
        //Inițializarea a mai multor vectori.
        int i;
        for(i=0; i<12; i++)
        {
            choice_gen.OKim[i]=false;
        }
        for(i=0; i<16; i++)
        {
            nowar_harta.OKman[i]=false;
        }
        for(i=0; i<46; i++)
        {
            birou_foaie.wass[i]=true;
        }
        nowar_harta.OKman[0]=true;
    }
   public void disclaimer()
   {
       //Apariția disclaimer-ului de la începutul jocului.
       int i;
       getWorld().getObjects(Text.class).get(0).setImage(new GreenfootImage("Disclaimer: Denumirile și faptele din joc sunt pur ficționale, \n având în schimb surse de inspirație din realitate.", 50, Color.WHITE, new Color(0,0,0,0)));
       for(i=0; i<256; i=i+5)
       {
          getWorld().getObjects(Text.class).get(0).getImage().setTransparency(i);
          Greenfoot.delay(1);
       }
       Greenfoot.delay(180);
       for(i=255; i>=0; i=i-5)
       {
           getWorld().getObjects(Text.class).get(0).getImage().setTransparency(i);
           Greenfoot.delay(1);
       }
   }
}
