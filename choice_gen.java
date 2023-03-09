import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Scenă de alegere a generalilor atât la început, cât și pe parcursul jocului.
 *  ATENȚIE: Dacă un ministru sau diplomat este dat afară, acesta NU mai poate fi recuperat decât dacă jocul este luat de la capăt.
 */
public class choice_gen extends choices
{
    boolean OKa=false, OKb=false;
    boolean OKc=false;
    public boolean OK=false;
    int nr=0;
    public Actor[] ministru= new Actor[10];
    private Actor[] diplomat= new Actor[4];
    public String[] imagini=new String[] {"PC-RES_Card_Final.png", "PC-MIL_Card_Final.png", "PC-POP_Card_Final.png", "PC-DIPL_Card_Final.png", "PCL-RES_Card_Final.png", "PCL-MIL_Card_Final.png", "PCL-POP_Card_Final.png", "PCL-DIPL_Card_Final.png", "PT-RES_Card_Final.png", "PT-MIL_Card_Final.png", "PT-POP_Card_Final.png", "PT-DIPL_Card_Final.png","PC-RES_Card_Final_Outline.png", "PC-MIL_Card_Final_Outline.png", "PC-POP_Card_Final_Outline.png", "PC-DIPL_Card_Final_Outline.png", "PCL-RES_Card_Final_Outline.png", "PCL-MIL_Card_Final_Outline.png", "PCL-POP_Card_Final_Outline.png", "PCL-DIPL_Card_Final_Outline.png", "PT-RES_Card_Final_Outline.png", "PT-MIL_Card_Final_Outline.png", "PT-POP_Card_Final_Outline.png", "PT-DIPL_Card_Final_Outline.png"};
    public static boolean[] OKim= new boolean[12];
    public static int o[]={0,0,0};
    GreenfootImage image1;
    GreenfootSound backg= new GreenfootSound("choicegen.mp3");
    int s=-1, r=-1;
    /**
     * Constructor for objects of class choice_gen.
     * 
     */
    public choice_gen()
    {
        prepare();
        if((OK==false)&&(panou_control.OKc==false))
        {
            getObjects(Inter.class).get(0).passday1(0);
        }
    }
    public void act()
    {
        //Se verifică dacă panoul de control a fost utilizat pentru a ajunge la această scenă. Dacă OKc este adevărat, înseamnă ca jucătorul a trecut deja prin această scenă și dorește
        //să-și schimbe doar unul dintre miniștrii.
        Actor[] ministru= new Actor[]{getObjects(cres.class).get(0), getObjects(cmil.class).get(0), getObjects(cpop.class).get(0), getObjects(cdipl.class).get(0), getObjects(lres.class).get(0), getObjects(lmil.class).get(0), getObjects(lpop.class).get(0), getObjects(ldipl.class).get(0), getObjects(tres.class).get(0), getObjects(tmil.class).get(0), getObjects(tpop.class).get(0), getObjects(tdipl.class).get(0)};
        if(panou_control.OKc==false)
        {
            if(OK==false)
            {
                getObjects(Inter.class).get(0).passday2(0);
                backg.playLoop();
                getObjects(Text.class).get(1).TextFadeIn(1,"Alege-ți politicienii apăsând pe cardul lor. Poți alege un maxim de 2 politicieni dintr-un partid. Ai grijă!\n Miniștrii îți vor afecta doar resursele de început, în timp ce Diplomatul îți va afecta întregul joc.", 30, Color.WHITE);
                removeObject(getObjects(Inter.class).get(0));
            }
            OK=true;
            if(getObjects(Text.class).get(1).getImage().getTransparency()==255)
            {
                //Proces de așteptare a alegerii utilizatorului.
                     choose();
                     nr=o[0]+o[1]+o[2];
                     if((nr==4)&&(getObjects(sageata.class).get(0).getImage().getTransparency()!=255))
                     {
                       aparitie();
                     }
                     if((getObjects(sageata.class).get(0).getImage().getTransparency()==255)&&(Greenfoot.mouseClicked(getObjects(sageata.class).get(0))))
                     {
                         OKc=true;
                     }
            } 
            if(OKc==true)
            {
                backg.stop();
                Greenfoot.playSound("gen_choose.mp3");
                Inter inter= new Inter();
                addObject(inter, 640, 355);
                getObjects(Inter.class).get(0).getImage().setTransparency(0);
                getObjects(Inter.class).get(0).init();
                disparitie();
                getObjects(Text.class).get(1).TextFadeOut(1);
                getObjects(Inter.class).get(0).passday1(0);
                Text text3=new Text();
                addObject(text3, 640 ,355);
                text3.getImage().setTransparency(0);
                getObjects(Text.class).get(2).TextFadeIn(2,"Acum este momentul ca tu să cârmuiești țara și să refaci România Mare!\n Îți urăm succes, Conducătorule!\n", 30, Color.WHITE);
                Greenfoot.delay(300);
                changeRes();
                getObjects(Text.class).get(2).TextFadeOut(2);
                Greenfoot.setWorld(new mainroom());
            }
        }
        else
        {
            //Proces de schimbare al generalului.
            if(OK==false)
            {
                int i;
                removeObject(getObjects(Inter.class).get(0));
                exit_help exit_help = new exit_help();
                addObject(exit_help,1233,37);
                for(i=0; i<=pupitru_generali_front.cont; i++)
                {
                     ministru[pupitru_generali_front.l[i]].getImage().setTransparency(128);
                }
                for(i=0; i<12; i++)
                {
                    if((OKim[i]==true)&&(i!=pupitru_generali_front.l[pupitru_generali_front.cont]))
                    {
                        ministru[i].setImage(new GreenfootImage(imagini[i+12]));
                    }
                }
                OK=true;
            }
            chooses(pupitru_generali_front.l[pupitru_generali_front.cont]);
            if(OKb==true)
            {
                if(getObjects(sageata.class).get(0).getImage().getTransparency()!=255)
                {
                    aparitie();
                }
                if((getObjects(sageata.class).get(0).getImage().getTransparency()==255)&&(Greenfoot.mouseClicked(getObjects(sageata.class).get(0))))
                {
                    int i;
                    OKim[pupitru_generali_front.l[pupitru_generali_front.cont]]=false;
                    //Dacă un ministru este dat afară, acesta  își va lua cu sine bonusurile oferite, iar dacă un diplomat este dat afară pe timp de război, va fi
                    //pornit scenariul de alegere din nou a alianței.
                    if((pupitru_generali_front.l[pupitru_generali_front.cont]+1)%4!=0)
                    {
                        for(i=0; i<3; i++)
                        {
                            mainroom.reso[i]=mainroom.reso[i]-mainroom.bonusuri[pupitru_generali_front.l[pupitru_generali_front.cont]][i];
                            mainroom.reso[i]=mainroom.reso[i]+mainroom.bonusuri[s][i];
                        }
                    }
                    else
                    {
                        if(mainroom.war==true)
                        {
                            mainroom.OKs=true;
                        }
                        for(i=0;i<3;i++)
                        {
                            mainroom.dip[i]=mainroom.bonusuri[s][i];
                        }
                    }
                    pupitru_generali_front.cont++;
                    panou_control.cd[0]=8;
                    if(panou_control.cd[1]<2)
                    {
                        panou_control.cd[1]=2;
                    }
                    checkNumber();
                    panou_control.OKc=false;
                    Greenfoot.setWorld(new mainroom());
                }
            }
        }
    }
    public void chooses(int b)
    {
        //Aici are loc procesul de schimbare al imaginii unui card, adaugând outline-ul dacă utilizatorul apasă pe acesta. Este verificat dacă numărul de miniștrii dintr-un partid este
        //mai mic de 2 prin vectorul o[].
        Actor[] ministru= new Actor[]{getObjects(cres.class).get(0), getObjects(cmil.class).get(0), getObjects(cpop.class).get(0), getObjects(cdipl.class).get(0), getObjects(lres.class).get(0), getObjects(lmil.class).get(0), getObjects(lpop.class).get(0), getObjects(ldipl.class).get(0), getObjects(tres.class).get(0), getObjects(tmil.class).get(0), getObjects(tpop.class).get(0), getObjects(tdipl.class).get(0)};
        if(b<=3)
        {
            if((o[1]!=2)&&((ministru[b+4]).getImage().getTransparency()==255)&&(Greenfoot.mouseClicked(ministru[b+4])))
            {
                Greenfoot.playSound("card_choice.mp3");
                o[1]++;
                ministru[b+4].setImage(new GreenfootImage(imagini[b+16]));
                OKim[b+4]=true;
                s=b+4;
                r=1;
                OKb=true;
                if(OKim[b+8]==true)
                {
                    ministru[b+8].setImage(new GreenfootImage(imagini[b+8]));
                    OKim[b+8]=false;
                    o[2]--;
                }
            }
            if((o[2]!=2)&&((ministru[b+8]).getImage().getTransparency()==255)&&(Greenfoot.mouseClicked(ministru[b+8])))
            {
                Greenfoot.playSound("card_choice.mp3");
                o[2]++;
                ministru[b+8].setImage(new GreenfootImage(imagini[b+20]));
                OKim[b+8]=true;
                s=b+8;
                r=2;
                OKb=true;
                if(OKim[b+4]==true)
                {
                    ministru[b+4].setImage(new GreenfootImage(imagini[b+4]));
                    OKim[b+4]=false;
                    o[1]--;
                }
            }
        }
        else if(b<=7)
        {
            if((o[0]!=2)&&((ministru[b-4]).getImage().getTransparency()==255)&&(Greenfoot.mouseClicked(ministru[b-4])))
            {
                Greenfoot.playSound("card_choice.mp3");
                o[0]++;
                ministru[b-4].setImage(new GreenfootImage(imagini[b+8]));
                OKim[b-4]=true;
                s=b-4;
                r=0;
                OKb=true;
                if(OKim[b+4]==true)
                {
                    ministru[b+4].setImage(new GreenfootImage(imagini[b+4]));
                    OKim[b+4]=false;
                    o[2]--;
                }
            }
            if((o[2]!=2)&&((ministru[b+4]).getImage().getTransparency()==255)&&(Greenfoot.mouseClicked(ministru[b+4])))
            {
                Greenfoot.playSound("card_choice.mp3");
                o[2]++;
                ministru[b+4].setImage(new GreenfootImage(imagini[b+16]));
                OKim[b+4]=true;
                s=b+4;
                r=2;
                OKb=true;
                if(OKim[b-4]==true)
                {
                    ministru[b-4].setImage(new GreenfootImage(imagini[b-4]));
                    OKim[b-4]=false;
                    o[0]--;
                }
            }
        }
        else
        {
            if((o[0]!=2)&&((ministru[b-8].getImage().getTransparency()==255)&&(Greenfoot.mouseClicked(ministru[b-8]))))
            {
                Greenfoot.playSound("card_choice.mp3");
                o[0]++;
                ministru[b-8].setImage(new GreenfootImage(imagini[b+4]));
                OKim[b-8]=true;
                s=b-8;
                r=0;
                OKb=true;
                if(OKim[b-4]==true)
                {
                    ministru[b-4].setImage(new GreenfootImage(imagini[b-4]));
                    OKim[b-4]=false;
                    o[1]--;
                }
            }
            if((o[1]!=2)&&((ministru[b-4].getImage().getTransparency()==255)&&(Greenfoot.mouseClicked(ministru[b-4]))))
            {
                Greenfoot.playSound("card_choice.mp3");
                o[1]++;
                ministru[b-4].setImage(new GreenfootImage(imagini[b+8]));
                OKim[b-4]=true;
                s=b-4;
                r=1;
                OKb=true;
                if(OKim[b-8]==true)
                {
                    ministru[b-8].setImage(new GreenfootImage(imagini[b-8]));
                    OKim[b-8]=false;
                    o[0]--;
                }
            }
        }
    }
    public void changeRes()
    {
        int i,j;
        //Sunt schimbate resursele în funcție de bonusurile oferite DOAR de către miniștrii. Diplomații nu au efect direct asupra resurselor, ci indirect, prin alegerile realizate de
        //utilizator.
        for(i=0; i<12;i++)
        {
            if(OKim[i]==true)
            {
                if((i!=3)&&(i!=7)&&(i!=11))
                {
                    for(j=0; j<3; j++)
                    {
                        mainroom.reso[j]=mainroom.reso[j]+mainroom.bonusuri[i][j];
                    }
                }
                else
                {
                    for(j=0; j<3; j++)
                    {
                        mainroom.dip[j]=mainroom.bonusuri[i][j];
                    } 
                }
            }
        }
    }
    public void aparitie()
    {
        //Apariția textului. Acesta apare doar atunci când utilizatorul alege un set complet (3 miniștrii și un diplomat).
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
    public void disparitie()
    {
        //Efect în urma apăsării săgeții.
        int i;
        for(i=255; i>=0; i=i-5)
        {
            getObjects(Text.class).get(0).getImage().setTransparency(i);
            getObjects(sageata.class).get(0).getImage().setTransparency(i);
            Greenfoot.delay(1);
        }
    }
    public void choose()
    {
        //Dacă există miniștrii deja aleși și este un nou ministru ales, vor dispărea outline-urile celor care erau aleși.
        int i=-1,j=0, k=0;
        Actor[] ministru= new Actor[]{getObjects(cres.class).get(0), getObjects(cmil.class).get(0), getObjects(cpop.class).get(0), getObjects(cdipl.class).get(0), getObjects(lres.class).get(0), getObjects(lmil.class).get(0), getObjects(lpop.class).get(0), getObjects(ldipl.class).get(0), getObjects(tres.class).get(0), getObjects(tmil.class).get(0), getObjects(tpop.class).get(0), getObjects(tdipl.class).get(0)};
        for(k=0; k<12; k++)
        {
            if(Greenfoot.mouseClicked(ministru[k]))
            {   
                j=k;
                if((k<4)&&(o[0]!=2))
                {
                    o[0]++;
                    i=1;
                }
                if((k>=4)&&(k<8)&&(o[1]!=2))
                {
                    o[1]++;
                    i=2;
                }
                if((k>=8)&&(k<12)&&(o[2]!=2))
                {
                    o[2]++;
                    i=3;
                }
            }
        }  
        if((i>=0)&&(o[i-1]!=3))
        {
            check(i,j);
        }
        if((OKa==true)&&(i>=0)&&(o[i-1]!=3))
        {
            ministru[j].setImage(new GreenfootImage(imagini[j+12]));
            switch(i)
            {
                case 1:
                ministru[j+4].setImage(new GreenfootImage(imagini[j+4]));
                ministru[j+8].setImage(new GreenfootImage(imagini[j+8]));
                break;
                case 2:
                ministru[j-4].setImage(new GreenfootImage(imagini[j-4]));
                ministru[j+4].setImage(new GreenfootImage(imagini[j+4]));
                break;
                case 3:
                ministru[j-4].setImage(new GreenfootImage(imagini[j-4]));
                ministru[j-8].setImage(new GreenfootImage(imagini[j-8]));
                break;
            }
            OKa=false;
        }
    } 
    public void check(int b, int a)
    {
        //Alegerea ministrului determină creșterea numărului de miniștrii dintr-un partid, dar și scăderea numărului de miniștrii deja aleși (dacă există) din alte partide.
        Actor[] ministru= new Actor[]{getObjects(cres.class).get(0), getObjects(cmil.class).get(0), getObjects(cpop.class).get(0), getObjects(cdipl.class).get(0), getObjects(lres.class).get(0), getObjects(lmil.class).get(0), getObjects(lpop.class).get(0), getObjects(ldipl.class).get(0), getObjects(tres.class).get(0), getObjects(tmil.class).get(0), getObjects(tpop.class).get(0), getObjects(tdipl.class).get(0)};
        if(OKim[a]==true)
        {
            OKa=false;
            o[b-1]--;
        }
        else
        {
            OKa=true;
            OKim[a]=true;
            Greenfoot.playSound("card_choice.mp3");
        }
        if(OKa==true)
        {
                switch(b)
                {
                    case 1:
                    if(OKim[a+4]==true)
                    {
                        o[b]--;
                        OKim[a+4]=false;
                    }
                    if(OKim[a+8]==true)
                    {
                        o[b+1]--;
                        OKim[a+8]=false;
                    }
                    break;
                    case 2:
                    if(OKim[a-4]==true)
                    {
                        o[b-2]--;
                        OKim[a-4]=false;
                    }
                    if(OKim[a+4]==true)
                    {
                        o[b]--;
                        OKim[a+4]=false;
                    }
                    break;
                    case 3:
                    if(OKim[a-8]==true)
                    {
                        o[b-3]--;
                        OKim[a-8]=false;
                    }
                    if(OKim[a-4]==true)
                    {
                        o[b-2]--;
                        OKim[a-4]=false;
                    }
                    break;
                }
        }
    }
    public void checkNumber()
    {
        //Se verifică ce ministru a fost dat afară, scăzând numărul de miniștrii activi din partidul în care se află ministrul respectiv și crescând numărul de miniștrii activi din partidul
        //în care se află ministrul ales.
        int i;
        for(i=0; i<3; i++)
        {
            o[i]=0;
        }
        for(i=0; i<12; i++)
        {
            if(OKim[i]==true)
            {
                o[i/4]++;
            }
        }
    }
    public void prepare()
    {
        cres cres = new cres();
        addObject(cres,291,150);
        cpop cpop = new cpop();
        addObject(cpop,691,150);
        cmil cmil = new cmil();
        addObject(cmil,491,150);
        cdipl cdipl = new cdipl();
        addObject(cdipl,891,150);
        lres lres = new lres();
        addObject(lres,291,344);
        lmil lmil = new lmil();
        addObject(lmil,491,344);
        lpop lpop = new lpop();
        addObject(lpop,691,344);
        ldipl ldipl= new ldipl();
        addObject(ldipl, 891, 344);
        tres tres = new tres();
        addObject(tres,291,541);
        tmil tmil = new tmil();
        addObject(tmil,491,541);
        tpop tpop= new tpop();
        addObject(tpop,691,541);
        tdipl tdipl= new tdipl();
        addObject(tdipl, 891, 541);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 650);
        text.getImage().setTransparency(0);
        Text text2=new Text();
        addObject(text2, 640 ,40);
        text2.getImage().setTransparency(0);
        sageata sageata = new sageata();
        addObject(sageata,1146,544);
        sageata.getImage().setTransparency(0);
    }
}
