import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Scena principală în care se desfășoară majoritatea activităților.
 */
public class mainroom extends World
{
    public static int countdays=1;
    public static int[] reso=new int[]{5, 5, 5};
    public static int[][] bonusuri={{1,1,-1},{0,2,-1},{0,1,0},{0,1,-1},
                                           {2,-1,0},{1,0,0},{1,-1,1},{1,-1,0},
                                           {0,0,1},{-1,1,1},{-1,0,2},{-1,0,1}};
    public static boolean change=true;
    public static boolean dayo=true;
    public static boolean[] OKdecis =new boolean[]{false, false, true};
    public static int[] dip={0,0,0};
    public static int px=0,py=0;
    public static boolean[] OKRU=new boolean[]{false, false};
    public static boolean[] OKAU=new boolean[]{false,false};
    public static boolean OKRUdet=false, OKAUdet=false;
    public static boolean war=false;
    public static boolean[] alliance=new boolean[]{false,false};
    public static boolean[] OKter=new boolean[]{false,false};
    public String[] bacg=new String[]{"pokf.mp3", "kaf.mp3", "manf.mp3", "berf.mp3", "sigf.mp3", "wasf.mp3", "berf.mp3"};
    public String[] helppag=new String[]{"helpin.png", "helpin2.png", "helpin3.png", "helpin4.png", "helpin5.png"};
    public static GreenfootSound[] so=new GreenfootSound[7];
    public static int win=0;
    public static boolean OKs=false;
    public static int[] changes=new int[]{0,0,0};
    int r=0;
    public int a=0;
    public static int sg=0;
    public static int helpc=0, helpd=0;
    public Actor sold[]=new Actor[2]; 
    int ihelp=0, ij=-1;
    /**
     * Constructor for objects of class mainroom.
     * 
     */
    public mainroom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 710, 1); 
        prepare();
        if(change==true)
        {
            initS();
        }
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
       if(change==true)
       {
           //Dacă change este adevărat, adică dacă utilizatorul abia a intrat în birou, acesta este întâmpinat de o hârtie cu un tutorial extins. De asemenea, sunt inițializate resurse
           //și evenimente.
           refreshday(3);
           exit_help exit_help = new exit_help();
           addObject(exit_help,999,112);
           ihelp=0;
           a=1;
           Greenfoot.playSound("openhelp.mp3");
           getObjects(helpin.class).get(0).setImage(new GreenfootImage("helpin.png"));
           getObjects(helpin.class).get(0).getImage().setTransparency(255);
           drhelp drhelp = new drhelp();
           addObject(drhelp,967,596);
            change=false;
       }
       checkS();
       if((OKdecis[1]==false)&&(r==0))
       {
           //O metodă de inițializare a opacității ecranului negru la 0 atunci când se intră în scenă după utilizarea unui obiect din birou.
            getObjects(Inter.class).get(0).getImage().setTransparency(0);
            r++;
       }
       if((getObjects(Inter.class).get(0).getImage().getTransparency()==0)&&(a==0)&&(Greenfoot.isKeyDown("h")))
       {
           //Apariția hârtiei cu tutorial extins prin apăsarea tastei H.
           exit_help exit_help = new exit_help();
           addObject(exit_help,999,112);
           ihelp=0;
           a=1;
           Greenfoot.playSound("openhelp.mp3");
           getObjects(helpin.class).get(0).setImage(new GreenfootImage("helpin.png"));
           getObjects(helpin.class).get(0).getImage().setTransparency(255);
           drhelp drhelp = new drhelp();
           addObject(drhelp,967,596);
       }
       if(a==1)
       {
           //Dacă tutorialul extins este deschis, aceste două metode vor intra în uz.
            if((ihelp<helppag.length-1)&&(Greenfoot.mouseClicked(getObjects(drhelp.class).get(0))))
            {
                turn(1, ihelp+1);
                ihelp++;
            }
            if((ihelp>0)&&(Greenfoot.mouseClicked(getObjects(stghelp.class).get(0))))
            {
                turn(2, ihelp-1);
                ihelp--;
            }
       }
    }
    public void turn(int caz,int i)
    {
        //Prin apăsarea săgeților de la tutorialul extins, sunt schimbate paginile, dar și săgețile în funcție de pagina unde se află utilizatorul.
        Greenfoot.playSound("helpsc_sound.mp3");
        if(caz==1)
        {
            getObjects(helpin.class).get(0).setImage(new GreenfootImage(helppag[i]));
        }
        else
        {
            getObjects(helpin.class).get(0).setImage(new GreenfootImage(helppag[i]));
        }
        if(i==0)
        {
            removeObject(getObjects(stghelp.class).get(0));
        }
        else if((i==1)&&(i>ij))
        {
            stghelp stghelp = new stghelp();
            addObject(stghelp,268,596);
        }
        if(i==helppag.length-1)
        {
            removeObject(getObjects(drhelp.class).get(0));
        }
        if((i==helppag.length-2)&&(i<ij))
        {
           drhelp drhelp = new drhelp();
           addObject(drhelp,967,596);
        }
        ij=i;
    }
    public void refreshday(int i)
    {
            //Aici au loc mai multe procese ce apar în timpul trecerii zilei precum poziționarea la ușă a lui Aurel, schimbarea scenariului și aplicare consecințelor scenariului anterior.
            int j;
            mainroom.countdays++;
             checkCase();
             if((win==0)&&(mainroom.countdays!=42))
             {
                 mainroom.OKdecis[0]=false;
                 if(change==false)
                 {
                     getObjects(Inter.class).get(0).passday1(0);
                     Greenfoot.playSound("doorout.mp3");
                 }
                 else
                 {
                     getObjects(Inter.class).get(0).getImage().setTransparency(255);
                 }
                 for(j=0; j<3; j++)
                 {
                     if(panou_control.cd[j]>0)
                     {
                         panou_control.cd[j]--;
                     }
                 }
                 if((panou_control.cd[1]==4)||(panou_control.cd[2]==4))
                 {
                     OKdecis[2]=false;
                 }
                 OKdecis[1]=true;
                 getObjects(Conducator.class).get(0).text(i);
                 getObjects(Conducator.class).get(0).setLocation(632,637);
                 getObjects(Conducator.class).get(0).setImage("fata.png");
                 getObjects(Conducator.class).get(0).removeTxt();
                 Greenfoot.playSound("doorin.mp3");
                 OKdecis[1]=false;
                 getObjects(Conducator.class).get(0).removeTxt();
                 changes[0]=0;
                 changes[1]=0;
                 changes[2]=0;
                 eventday();
                 initRes();
                 birou_foaie.transp[0]=128;
                 birou_foaie.transp[1]=128;
                 getObjects(Conducator.class).get(0).initResources();
                 birou_foaie.st=-1;
                 getObjects(Inter.class).get(0).passday2(0);
             }
    }
    public void eventday()
    {
        //Aici sunt alese scenarii sub formă de poze care sunt incluse în vectorul de Stringuri today[], vector ce are rol de afișare a paginilor la birou.
        int i, l=0;
        i=Greenfoot.getRandomNumber(10);
        if((war==true)&&(OKs!=true)&&(panou_control.cd[2]==0)&&(i==9))
        {
            //În cazul unui război, există o șansă de 10% ca utilizatorul să fie atacat zilnic. Atât timp cât este capabil să se apere și nu-și dă afară diplomatul.
            defend(l);
            if(panou_control.cd[0]<2)
            {
                panou_control.cd[0]=2;
            }
            l++;
        }
        if((OKAU[1]==true)||(OKRU[1]==true))
        {
            //În cazul în care utilizatorul atacă, acesta va primi un scenariu cu atac.
            if(OKAU[1]==true)
            {
                birou_foaie.today[l]=birou_foaie.scenariu[47];
            }
            if(OKRU[1]==true)
            {
                birou_foaie.today[l]=birou_foaie.scenariu[46];
            }
            l++;
        }
        if(birou_foaie.ch!=-1)
        {
            //Aici sunt alese consecințele doar în cazul în care nu ne aflăm în ziua 1, zi fără consecințe.
            if((birou_foaie.ch==44)||(birou_foaie.ch==45))
            {
                if((birou_foaie.st==0)&&(OKter[0]==true))
                {
                    birou_foaie.today[l]="MN5-1.png";
                }
                else if(birou_foaie.st==0)
                {
                    birou_foaie.today[l]=birou_foaie.cons[birou_foaie.ch][birou_foaie.st];
                }
                if((birou_foaie.st==1)&&(OKter[1]==true))
                {
                    birou_foaie.today[l]="MD5-1.png";
                }
                else if(birou_foaie.st==1)
                {
                    birou_foaie.today[l]=birou_foaie.cons[birou_foaie.ch][birou_foaie.st];
                }
                initResoDec(l);
                birou_foaie.ch=100;
            }
            else if(birou_foaie.ch!=100)
            {
                birou_foaie.today[l]=birou_foaie.cons[birou_foaie.ch][birou_foaie.st];
                if(birou_foaie.ch>=36)
                {
                    if(birou_foaie.st==0)
                    {
                        helpd++;
                    }
                }
                initResoDec(l);
            }
            l++;
        }
        if((countdays==11)||(OKs==true))
        {
            //Aici sunt alese scenariile de alegere a alianței dacă începe războiul sau dacă utilizatorul dă afară un diplomat.
            if((OKs==true)&&(war==true))
            {
                birou_foaie.ch=44;
                birou_foaie.today[l]=birou_foaie.scenariu[44];
            }
            else
            {
                birou_foaie.ch=45;
                birou_foaie.today[l]=birou_foaie.scenariu[45];
            }
            if(war==false)
            {
                 Greenfoot.playSound("razboi.mp3");
                 war=true;
            }
            OKs=false;
        }
        else
        {
           //Proces de primire a unui scenariu nou prin obținerea unui număr random.
           if(war==false)
           {
               while(birou_foaie.wass[i]==false)
               {
                   i=Greenfoot.getRandomNumber(36);
               }
           }
           else
           {
               while(birou_foaie.wass[i]==false)
               {
                   i=Greenfoot.getRandomNumber(44);
               }
               if(i>=36)
               {
                   //Aceste scenarii fac parte din categoria scenarii tip-alianță, în funcție de care se va primi sau nu Cadrilaterul cu condiția ca utilizatorul să aibă atât
                   //Transilvania, cât și Basarabia.
                   helpc++;
               }
           }
           birou_foaie.today[l]=birou_foaie.scenariu[i];
           birou_foaie.wass[i]=false;
           birou_foaie.ch=i;
        }
        birou_foaie.ant=l;
    }
    public void initResoDec(int l)
    {
        //Inițializarea resurselor ca urmare a alegerilor realizate.
        int i;
        birou_foaie.resinf=l;
        if((birou_foaie.ch==44)&&((OKter[0]==true)||(OKter[1]==true)))
        {
            if(((OKter[0]==true)&&(alliance[0]==true))||((OKter[1]==true)&&(alliance[1]==true)))
            {
                for(i=0; i<3; i++)
                {
                      if(mainroom.reso[i]-1>=0)
                      {
                          mainroom.reso[i]--;
                      }
                      changes[i]=-1;
                }
            }
        }
        else
        {
            if(birou_foaie.ch!=100)
            {
                for(i=0; i<3; i++)
                {                
                   if(mainroom.reso[i]+birou_foaie.ress[birou_foaie.ch][birou_foaie.st*3+i]>=0)
                   {
                       mainroom.reso[i]=mainroom.reso[i]+birou_foaie.ress[birou_foaie.ch][birou_foaie.st*3+i];
                   }
                   else
                   {
                       mainroom.reso[i]=0;
                    }
                   changes[i]=changes[i]+birou_foaie.ress[birou_foaie.ch][birou_foaie.st*3+i];
                    if((birou_foaie.ress[birou_foaie.ch][birou_foaie.st*3+i]<0)&&(dip[i]<0))
                   {
                       if(mainroom.reso[i]+dip[i]>=0)
                       {
                           mainroom.reso[i]=mainroom.reso[i]+dip[i];
                       }
                       else
                       {
                           mainroom.reso[i]=0;
                       }
                       changes[i]=changes[i]+dip[i];
                   }
                   if((birou_foaie.ress[birou_foaie.ch][birou_foaie.st*3+i]>0)&&(dip[i]>0))
                   {
                       mainroom.reso[i]=mainroom.reso[i]+dip[i];
                       changes[i]=changes[i]+dip[i];
                   }
                }
            }
        }
    }
    public void defend(int l)
    {
        //În cazul unui potențial atac, utilizatorul este informat, harta este updatată iar butonul de apărare este activat.
        if(alliance[0]==true)
        {
            OKAU[0]=true;
            birou_foaie.today[l]=birou_foaie.scenariu[49];
            initM();
            if((OKter[0]==true)&&(OKter[1]==true))
            {
                nowar_harta.OKman[14]=true;
            }
            else if(OKter[0]==true)
            {
                nowar_harta.OKman[11]=true;
            }
            else if(OKter[1]==true)
            {
                nowar_harta.OKman[12]=true;
            }
            else
            {
                nowar_harta.OKman[5]=true;
            }
        }
        else
        {
            OKRU[0]=true;
            birou_foaie.today[l]=birou_foaie.scenariu[48];
            initM();
            if((OKter[0]==true)&&(OKter[1]==true))
            {
                nowar_harta.OKman[15]=true;
            }
            else if(OKter[0]==true)
            {
                nowar_harta.OKman[9]=true;
            }
            else if(OKter[1]==true)
            {
                nowar_harta.OKman[8]=true;
            }
            else
            {
                nowar_harta.OKman[6]=true;
            }
        }
        OKdecis[2]=false;
        panou_control.cd[0]=1;
    }
    public void checkCase()
    {
        //Aici sunt verificate diferite scenarii care pornesc mai multe ending-uri.
        //Dacă win==-1, înseamnă că Rusia a reușit să ocupe România.
        //Dacă win este -2, înseamnă că Austro-Ungaria a reușit să ocupe România.
        //Dacă se ajunge la finalul zilei 40, războiul se sfârșește și se verifică starea actuală a țării, verificare care conduce la endinguri diferite ca și conținut.
        //În cazul în care utilizatorul are prea puține resurse (mai mic sau egal cu 1) din oricare resursă, există o șansă de 33,33% să aibă loc anarhia.
        //În cazul în care utilizatorul are prea mulți militari (peste 15) fără ca acest număr să fie echilibrat de numărul de apreciere publică (peste 9), 
        //există o șansă de 33,33% să aibă loc dictatură militară.
        if(win==-1)
        {
            if((sg!=0)&&(so[sg-1].isPlaying()==true))
            {
                so[sg-1].stop();
            }
            if((sg==0)&&(so[6].isPlaying()==true))
            {
                so[6].stop();
            }
            initM();
            nowar_harta.OKman[21]=true;
            getObjects(usa.class).get(0).setImage("usades.png");
            Greenfoot.playSound("rasturnare.mp3");
            endrus(); 
            Greenfoot.setWorld(new alAU());
        }
        if(win==-2)
        {
            if((sg!=0)&&(so[sg-1].isPlaying()==true))
            {
                so[sg-1].stop();
            }
            if((sg==0)&&(so[6].isPlaying()==true))
            {
                so[6].stop();
            }
            initM();
            nowar_harta.OKman[21]=true;
            getObjects(usa.class).get(0).setImage("usades.png");
            Greenfoot.playSound("rasturnare.mp3");
            endau();
            Greenfoot.setWorld(new alAU());
        }
        if((win==0)&&(countdays==42))
        {
            if((sg!=0)&&(so[sg-1].isPlaying()==true))
            {
                so[sg-1].stop();
            }
            if((sg==0)&&(so[6].isPlaying()==true))
            {
                so[6].stop();
            }
            if((OKter[0]==true)&&(OKter[1]==true))
            {
                initM();
                if(((helpc!=1)&&(helpd>=helpc/2))||((helpc==1)&&(helpd==1)))
                {
                    nowar_harta.OKman[20]=true;
                }
                else
                {
                    nowar_harta.OKman[19]=true;
                }
            }
            else if(OKter[1]==true)
            {
                initM();
                nowar_harta.OKman[17]=true;
            }
            else if(OKter[0]==true)
            {
                initM();
                nowar_harta.OKman[18]=true;
            }
            else
            {
                initM();
                nowar_harta.OKman[16]=true;
            }
            getObjects(Inter.class).get(0).passday1(0);
            Greenfoot.playSound("hoorah.mp3");
            getObjects(Text.class).get(4).TextFadeIn(4,"Felicitări, Conducătorule!\n Ai reușit să-ți conduci țara până la sfârșitul războiului!", 40, Color.WHITE);
            Greenfoot.delay(300);
            getObjects(Text.class).get(4).TextFadeOut(4);
            Greenfoot.setWorld(new nowar_harta());
        }
        if(win==0)
        {
            if((mainroom.reso[2]<=1)||(mainroom.reso[1]<=1)||(mainroom.reso[0]<=1))
            {
                int i;
                i=Greenfoot.getRandomNumber(3);
                if((i==2)||(mainroom.reso[2]==0)||(mainroom.reso[1]==0)||(mainroom.reso[0]==0))
                {
                    if((sg!=0)&&(so[sg-1].isPlaying()==true))
                    {
                        so[sg-1].stop();
                    }
                    if((sg==0)&&(so[6].isPlaying()==true))
                    {
                        so[6].stop();
                    }
                    win=-4;
                    getObjects(usa.class).get(0).setImage("usades.png");
                    Greenfoot.playSound("anarhie.mp3");
                    endro();
                    Greenfoot.setWorld(new anarhie());
                }
            }
            if((mainroom.reso[1]>15)&&(mainroom.reso[2]<10))
            {
                int i;
                i=Greenfoot.getRandomNumber(3);
                if(i==2)
                {
                    if((sg!=0)&&(so[sg-1].isPlaying()==true))
                    {
                        so[sg-1].stop();
                    }
                    if((sg==0)&&(so[6].isPlaying()==true))
                    {
                        so[6].stop();
                    }
                    win=-3;
                    getObjects(usa.class).get(0).setImage("usades.png");
                    Greenfoot.playSound("rasturnare.mp3");
                    endro();
                    Greenfoot.setWorld(new alAU());
                }
            }
        }
    }
    //Aici au loc mai multe inițializări.
    public void endro()
    {
        rosold rosold=new rosold();
        addObject(rosold,635,694);
        rosold rosold2=new rosold();
        addObject(rosold2,635,694);
        Text textru=new Text();
        addObject(textru,635,694);
        rosold.getImage().setTransparency(0);
        rosold2.getImage().setTransparency(0);
        textru.getImage().setTransparency(0);
        sold[0]=rosold;
        sold[1]=rosold2;
        initSol();
    }
    public void endau()
    {
        ausold ausold=new ausold();
        addObject(ausold,635,694);
        ausold ausold2=new ausold();
        addObject(ausold2,635,694);
        Text textru=new Text();
        addObject(textru,635,694);
        ausold.getImage().setTransparency(0);
        ausold2.getImage().setTransparency(0);
        textru.getImage().setTransparency(0);
        sold[0]=ausold;
        sold[1]=ausold2;
        initSol();
    }
    public void endrus()
    {     
        rusold rusold=new rusold();
        addObject(rusold,635,694);
        rusold rusold2=new rusold();
        addObject(rusold2,635,694);
        Text textru=new Text();
        addObject(textru,635,694);
        rusold.getImage().setTransparency(0);
        rusold2.getImage().setTransparency(0);
        textru.getImage().setTransparency(0);
        sold[0]=rusold;
        sold[1]=rusold2;
        initSol();
    }
    public void initSol()
    {
        //Animație atunci când un bad ending este pornit.
        int i;
        for(i=0; i<=255; i=i+17)
        {
            sold[0].getImage().setTransparency(i);
            sold[0].setLocation(sold[0].getX()+5, sold[0].getY()-5);
            sold[1].getImage().setTransparency(i);
            sold[1].setLocation(sold[1].getX()-5, sold[1].getY()-5);
            getObjects(Conducator.class).get(0).setImage("fata.png");
            getObjects(Conducator.class).get(0).setLocation(640,getObjects(Conducator.class).get(0).getY()-10);
            Greenfoot.delay(3);
        }
        getObjects(Text.class).get(5).TextFadeIn(5,"Tu vii cu noi!", 40, Color.RED);
        Greenfoot.delay(60);
        getObjects(Text.class).get(5).TextFadeOut(5);
        for(i=0;i<=255; i=i+17)
        {
           getObjects(Conducator.class).get(0).setLocation(getObjects(Conducator.class).get(0).getX(),getObjects(Conducator.class).get(0).getY()+10);
           getObjects(Conducator.class).get(0).getImage().setTransparency(255-i);
           sold[0].getImage().setTransparency(255-i);
           sold[1].getImage().setTransparency(255-i);
           getObjects(Inter.class).get(0).getImage().setTransparency(i);
           Greenfoot.delay(3);
        }
    }
    public void initS()
    {
        int i;
        for(i=0; i<7; i++)
        {
            so[i]=new GreenfootSound(bacg[i]);
        }
        for(i=0; i<46; i++)
        {
            birou_foaie.wass[i]=true;
        }
    }
    public void checkS()
    {
        if((sg!=0)&&(so[sg-1].isPlaying()==false)||(sg==0)&&(so[6].isPlaying()==false))
        {
            so[sg].play();
            sg++;
        }
        if(sg==7)
        {
            sg=0;
        }
    }
    public void initM()
    {
        int i;
        for(i=0; i<22; i++)
        {
            nowar_harta.OKman[i]=false;
        }
    }
    public void initRes()
    {
        int i;
        for(i=0; i<10; i++)
        {
            getObjects(Conducator.class).get(0).r_unit[i].getImage().setTransparency(0);
        }
        for(i=0; i<10; i++)
        {
            getObjects(Conducator.class).get(0).m_unit[i].getImage().setTransparency(0);
        }
        for(i=0; i<10; i++)
        {
            getObjects(Conducator.class).get(0).p_unit[i].getImage().setTransparency(0);
        }
        for(i=0;i<3;i++)
        {
            getObjects(Text.class).get(i+1).getImage().setTransparency(0);
        }
    }
    private void prepare()
    {
        harta harta = new harta();
        addObject(harta,49,350);
        radio_militar radio_militar = new radio_militar();
        addObject(radio_militar,210,130);
        manual_razboi manual_razboi = new manual_razboi();
        addObject(manual_razboi,171,628);
        pupitru_generali pupitru_generali = new pupitru_generali();
        addObject(pupitru_generali,1122,614);
        usa usa = new usa();
        addObject(usa,635,694);
        pres pres = new pres();
        addObject(pres,633,652);
        Conducator conducator = new Conducator();
        if(change==true)
        {
            addObject(conducator,632,637);
        }
        else
        {
            addObject(conducator,px,py);
        }
        planta planta = new planta();
        addObject(planta,388,662);
        planta2 planta2 = new planta2();
        addObject(planta2,860,664);
        biblioteca biblioteca = new biblioteca();
        addObject(biblioteca,1175,123);
        patefon patefon = new patefon();
        addObject(patefon,1155,257);
        Text text=new Text();
        addObject(text,978,691);
        text.getImage().setTransparency(0);
        r_sig r_sig = new r_sig();
        addObject(r_sig,100,16);
        p_sig p_sig = new p_sig();
        addObject(p_sig,932,25);
        m_sig m_sig = new m_sig();
        addObject(m_sig,526,25);
        Text textr=new Text();
        addObject(textr,420,21);
        textr.getImage().setTransparency(0);
        Text textm=new Text();
        addObject(textm,840,21);
        textm.getImage().setTransparency(0);
        Text textp=new Text();
        addObject(textp,1239,21);
        textp.getImage().setTransparency(0);
        birou birou = new birou();
        addObject(birou,627,187);
        helpin helpin = new helpin();
        addObject(helpin,616,370);
        helpin.getImage().setTransparency(0);
        int i;
        for(i=0; i<10; i++)
        {
            getObjects(Conducator.class).get(0).r_unit[i]=new r_unit();
            addObject( getObjects(Conducator.class).get(0).r_unit[i], 131+24*i,21);
            getObjects(Conducator.class).get(0).r_unit[i].getImage().setTransparency(0);
        }
        for(i=0; i<10; i++)
        {
            getObjects(Conducator.class).get(0).m_unit[i]=new m_unit();
            addObject( getObjects(Conducator.class).get(0).m_unit[i], 552+24*i, 21);
            getObjects(Conducator.class).get(0).m_unit[i].getImage().setTransparency(0);
        }
        for(i=0; i<10; i++)
        {
            getObjects(Conducator.class).get(0).p_unit[i]=new p_unit();
            addObject( getObjects(Conducator.class).get(0).p_unit[i], 950+24*i, 21);
            getObjects(Conducator.class).get(0).p_unit[i].getImage().setTransparency(0);
        }
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Conducator.class).get(0).initResources();
        getObjects(Inter.class).get(0).init();
        Text text2=new Text();
        addObject(text2,640,355);
        text2.getImage().setTransparency(0);
    }   
}
