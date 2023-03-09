import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class panou_control here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class panou_control extends scene_birou
{
    public static int[] cd=new int[]{0,0,0};
    public static boolean OKc=false;
    public boolean[] turns={false,false,false,false};
    public String[] dez=new String[]{"eliminare_dez.png", "atac_dez.png", "aparare_dez.png", "AU_dez.png", "Rusia_dez.png", "lupta_dez.png"};
    public String[] ac=new String[]{"eliminare.png", "atac.png", "aparare.png", "AU.png", "Rusia.png", "lupta.png"};
    public String[] q=new String[]{"Etnogeneza românească a fost un proces:","Ce populație a trăit predominant pe\n teritoriul fostei Dacii?","În urma etgonenezei s-a născut un popor:","Cu care dintre următoarele popoare\n nu ne înrudim:","Între ce secole, per total, a avut loc\n formarea poporului român:","Între ce secole a avut loc\n romanizarea dacilor liberi:","Cât reprezintă substratul traco-dacic\n din limba română:","Cât reprezintă substratul fundemental latin\n din limba română:","Cât reprezintă adstratul slav\n din limba română:","Unde a mai existat, concomitent, o populație daco-romană,\n urmașă a daco-geților și moesilor:","Care dintre următoarele nu este un dialect\n al limbii române:","Ce migratori au avut cele mai puternice influențe,\n până la finalul sec. al VIII-lea, asupra populației:","În ce secol se poate afirma că\n etnogeneza românească s-a încheiat:","Care dintre următoarele elemente reprezintă\n o dovadă a continuității românilor din primul mileniu:","Care dintre următoarele este\n o cultură arheologică:","Care este dintre următoarele reprezintă\n o denumire a strămoșilor noștri:","Începând cu ce secol sunt menționați într-o\n lucrare autohtonii de pe teritoriul actual:","Ce lucrare în care se menționează românii a fost\n scrisă de către Împăratul Mauricius:","Începând cu ce secol se manifestă\n un interes al scriitorilor pentru români:","Care dintre următorii cronicari a scris\n <Letopisețul Țării Moldovei>:","Care dintre următorii cronicari a scris\n <Din neamul moldovenilor>:","Care dintre următorii cronicari a scris <Hungaria>:","În ce an a afirmat cronicarul István Szamosközy\n că românii sunt urmașii coloniștilor romani:","În ce an s-a înfăptuit unirea Țărilor Române\n a lui Mihai Viteazul:","Care dintre următorii cronicari și-a contrazis afirmațiile\n după ce Mihai Viteazul a reușit prima unire?","Cum se numea instituția în care\n activau cărturari de seamă: ","Care dintre următoarele personalități făcea parte\n din Școala Ardeleană:","Începând cu ce secol a fost pusă în evidență\n originea latină a limbii române:","Negarea continuității românilor a început după secolul:","Anul în care contele Teleki a afirmat că românii sunt\n cei mai vechi locuitori ai Transilvaniei:","Care dintre următorii a susținut\n continuitatea românilor:","Cum s-a numit teoria conform căreia\n românii nu au trăit în zona Daciei:","Din ce motive principale a apărut\n o dispută în jurul continuității românilor:","Care dintre următorii istorici\n a combătut teoria imigraționistă:","Cum s-a mai numit teoria imigraționistă:","Câți ani a durat stăpânirea romană în Dacia:","Care dintre următorii este o personalitate\n fruntașă a Școlii Ardelene:","Cum s-a mai numit sec. XX:","Care dintre următoarele nu este\n o ideologie democratică:","Care dintre următoarele nu este o ideologie totalitară:","Care dintre următoarele ideologii are la bază \n<binele public reprezintă binele fiecărui individ>:","Care dintre următoarele ideologii are la bază\n statul minimal:","Care dintre următoarele ideologii are la bază\n <interesul individual promovează binele public>:","Care dintre următoarele ideologii are la bază\n promovarea libertăţii individuale:","Care dintre următoarele ideologii are la bază păstrarea\n tradiţiilor şi a valorilor tradiţionale:","Care dintre următoarele ideologii are la bază\n ierarhia naturală în cadrul societăţii:","Care dintre următoarele ideologii\n are la bază păstrarea ordinii sociale:","O dată cu apariția ideologiilor au apărut:","Baza inițială a poporului român a fost reprezentată de:","Cine a redactat lucrarea\n <O enigmă şi un miracol istoric: poporul român.>:","În ce perioadă s-au reînviat principalele aspecte\n ale teoriei autohtoniste:","Ce știință s-a dezvoltat în urma confrutării\n istoricilor români și maghiari:","Unde a apărut lucrarea <Studii românești>, de Robert Roesler:","Care dintre următorii a dat o definiție conceptului de ideologie:","Care dintre urmatorii a fost un important\n cărturar sas ce a susținut continuitatea românilor:","În ce ordine s-au adăugat dacilor \nurmătoarele populații:"};
    public String[][] a=new String[][]{{"complex și ireversibil","complex și reversibil","facil și ireversibil"},{"Sârbească","Ilirică","Daco-romană"},{"Italic","Tracic","Neo-latin"},{"Portughezii","Englezii","Italienii"},{"II-III","III-VIII","II-VIII"},{"III – VIII","II – III","I – VIII"},{"20%","60%","10%"},{"20%","60%","10%"},{"20%","60%","10%"},{"La Nord de Dunăre","La Sud de Dunăre","La Vest de Dunăre"},{"Limba Moldovenească","Aromână","Megleno-română"},{"Maghiarii","Slavii","Grecii"},{"Sec.VIII","Sec. XV","Sec. IX"},{"Descoperirile arheologice","Scrierile istorice","Descoperirile rupestre"},{"Dridu","Malu","Istria"},{"Ruteni","Blachi","Danubieni"},{"I","IX","VII"},{"Strategikon","Despre administrarea imperiului","Românii"},{"X","VII","XV"},{"Nicolaus Olahus","Grigore Ureche","Miron Costin"},{"Nicolaus Olahus","Grigore Ureche","Miron Costin"},{"Nicolaus Olahus","Martin Schmeitzel","Valentin Frank von Frankenstein"},{"1402","1593","1278"},{"1600","1713","1918"},{"István Szamosközy","Martin Schmeitzel","Valentin Frank von Frankenstein"},{"Școala Transilvăneană","Școala Ungară","Școala Ardeleană"},{"Grigore Ureche","Gheorghe Șincai","Miron Costin"},{"X","XVIII","XX"},{"X","XI","XVIII"},{"1791","1723","1801"},{"Franz Josef Sulzer","Iosif al II-lea","I. C. Eder"},{"Teoria emigraționistă","Teoria neconservativă","Teoria imigraționistă"},{"Politice","Economice","Religioase"},{"F.J. Sulzer","Michael Lebrecht","Bolla Marton"},{"Teorie Maghiară","Teorie Gibboniană","Teorie Roesleriariană"},{"165","120","170"},{"Edward Gibbon","B.P. Hașdeu","Dimitrie Cantemir"},{"Secolul Extremelor","Secolul Ideologiilor","Secolul Războiului"},{"Liberalismul","Național-Socialismul","Socialismul"},{"Marxismul","Fascismul","Conservatorismul"},{"Socialismul","Liberalismul","Conservatorismul"},{"Liberalismul","Conservatorismul","Socialismul"},{"Socialismul","Conservatorismul","Liberalismul"},{"Socialismul","Liberalismul","Conservatorismul"},{"Conservatorismul","Liberalismul","Socialismul"},{"Liberalismul","Socialismul","Conservatorismul"},{"Conservatorismul","Liberalismul","Socialismul"},{"Guvernele","Probleme diplomatice","Partidele politice"},{"Traco-daci","Slavi","Maghiari"},{"Vasile Pârvan","Gheorghe I. Brătianu","Nicolae Densușianu"},{"Perioada Monarhică","Perioada Interbelică","Perioada Comunistă"},{"Arheologia","Gramatica","Literatura"},{"Viena","Budapesta","București"},{"Terence Ball","A.D. Xenopol","C. Giurescu"},{"Benko Jozsef","L. Toppeltinus","Robert Roesler"},{"Slavi, romani","Romani, slavi","Maghiari, slavi"}};
    public static boolean[] hasr=new boolean[]{true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
    public static boolean[][] ansc=new boolean[][]{{true,false,false},{false,false,true},{false,false,true},{false,true,false},{false,false,true},{true,false,false},{false,false,true},{false,true,false},{true,false,false},{false,true,false},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{false,false,true},{false,true,false},{false,false,true},{true,false,false},{false,true,false},{true,false,false},{true,false,false},{false,false,true},{false,true,false},{false,true,false},{false,false,true},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{false,true,false},{true,false,false},{false,true,false},{false,false,true},{false,true,false},{true,false,false},{false,false,true},{false,true,false},{true,false,false},{false,false,true},{true,false,false},{false,false,true},{true,false,false},{false,true,false},{false,false,true},{true,false,false},{true,false,false},{true,false,false},{false,true,false},{false,true,false}};
    public boolean OKl=true, OKt=true;
    public boolean[] OKa=new boolean[]{false,false,false};
    int baraj=0;
    int scor=0, round=0;
    /**
     * Constructor for objects of class panou_control.
     * 
     */
    public panou_control()
    {
        prepare();
        check();
    }
    public void act()
    {
        //Sunt verificate mai multe condiții care activează sau dezactivează butoanele, cum ar fi cooldown-ul (apărut în urma utilizării unui buton), butonul actual folosit, dacă războiul
        //a pornit, dacă atacul se lansează contra unei țări ce nu face parte din aceeași alianță, dacă teritoriul dintr-o țară este ocupat de România, dacă România atacă sau este atacată.
        if(turns[3]==false)
        {
             if((turns[0]==false)&&(birou_foaie.ch!=45)&&(cd[0]==0)&&(Greenfoot.mouseClicked(getObjects(eliminare.class).get(0))))
            {
                OKc=true;
                Greenfoot.playSound("boop.mp3");
                Greenfoot.setWorld(new pupitru_generali_front());
            }
            if(cd[0]!=0)
            {
                OKc=false;
            }
            if(((cd[1]==4)||(cd[2]==4))&&(mainroom.OKdecis[2]==false)&&(Greenfoot.mouseClicked(getObjects(lupta.class).get(0))))
            {
                Greenfoot.playSound("boop.mp3");
                turns[3]=true;
                mainroom.OKdecis[2]=true;
                razboi();
            }
            if((birou_foaie.ch!=44)&&(birou_foaie.ch!=45)&&((mainroom.OKter[0]==false)||(mainroom.OKter[1]==false))&&(((mainroom.alliance[0]==true)&&(mainroom.OKter[1]==false))||((mainroom.OKter[0]==false)&&(mainroom.alliance[1]==true)))&&(turns[0]==false)&&(cd[1]==0)&&(mainroom.OKAU[0]==false)&&(mainroom.OKRU[0]==false)&&(mainroom.war==true)&&(Greenfoot.mouseClicked(getObjects(atac.class).get(0))))
            {
                Greenfoot.playSound("boop.mp3");
                turns[0]=true;
                turns[1]=true;
                turns[2]=false;
                outpanou outpanou = new outpanou();
                addObject(outpanou,887,488);
                Rusia rusia=new Rusia();
                addObject(rusia,872,212);
                if((mainroom.alliance[0]==true)||(mainroom.OKRU[0]==true)||(mainroom.OKter[0]==true))
                {
                    rusia.setImage("Rusia_dez.png");
                }
                else
                {
                    rusia.setImage("Rusia.png");
                }
                Austro_Ungaria AU=new Austro_Ungaria();
                addObject(AU,415,212);
                if((mainroom.alliance[1]==true)||(mainroom.OKAU[0]==true)||(mainroom.OKter[1]==true))
                {
                    AU.setImage("AU_dez.png");
                }
                else
                {
                    AU.setImage("AU.png");
                }
                if(cd[0]!=0)
                {
                    removeObject(getObjects(Text.class).get(0));
                }
                if(cd[2]!=0)
                {
                    removeObject(getObjects(Text.class).get(0));
                }
                removeObject(getObjects(eliminare.class).get(0));
                removeObject(getObjects(atac.class).get(0));
                removeObject(getObjects(aparare.class).get(0));
                removeObject(getObjects(lupta.class).get(0));
            }
            if((turns[0]==true)&&(turns[2]==false)&&(mainroom.OKter[1]==false)&&(mainroom.alliance[1]==false)&&(mainroom.OKAU[0]==false)&&(Greenfoot.mouseClicked(getObjects(Austro_Ungaria.class).get(0))))
            {
                Greenfoot.playSound("attack.mp3");
                mainroom.OKAU[1]=true;
                checkit(1);
                if(panou_control.cd[0]<2)
                {
                    cd[0]=2;
                }
                cd[1]=5;
                cd[2]=3;   
                turns[0]=false;
                turns[1]=false;
                removeObject(getObjects(outpanou.class).get(0));
                removeObject(getObjects(Austro_Ungaria.class).get(0));
                removeObject(getObjects(Rusia.class).get(0));
                eliminare eliminare = new eliminare();
                addObject(eliminare,415,212);
                atac atac = new atac();
                addObject(atac,872,212);
                aparare aparare = new aparare();
                addObject(aparare,415,486);
                lupta lupta = new lupta();
                addObject(lupta,872,486);
                check();
            }
            if((turns[0]==true)&&(turns[2]==false)&&(mainroom.OKter[0]==false)&&(mainroom.alliance[0]==false)&&(mainroom.OKRU[0]==false)&&(Greenfoot.mouseClicked(getObjects(Rusia.class).get(0))))
            {
                Greenfoot.playSound("attack.mp3");
                mainroom.OKRU[1]=true;
                checkit(2);
                if(panou_control.cd[0]<2)
                {
                    panou_control.cd[0]=2;
                }
                cd[1]=5;
                cd[2]=3;
                turns[0]=false;
                turns[1]=false;
                removeObject(getObjects(outpanou.class).get(0));
                removeObject(getObjects(Austro_Ungaria.class).get(0));
                removeObject(getObjects(Rusia.class).get(0));
                eliminare eliminare = new eliminare();
                addObject(eliminare,415,212);
                atac atac = new atac();
                addObject(atac,872,212);
                aparare aparare = new aparare();
                addObject(aparare,415,486);
                lupta lupta = new lupta();
                addObject(lupta,872,486);
                check();
            }
            if((turns[0]==true)&&(turns[2]==true)&&(mainroom.alliance[1]==false)&&(mainroom.OKAU[0]==true)&&(Greenfoot.mouseClicked(getObjects(Austro_Ungaria.class).get(0))))
            {
                Greenfoot.playSound("defend.mp3");
                mainroom.OKdecis[2]=true;
                cd[1]=3;
                cd[2]=5;
                turns[0]=false;
                turns[1]=false;
                turns[2]=false;
                removeObject(getObjects(outpanou.class).get(0));
                removeObject(getObjects(Austro_Ungaria.class).get(0));
                removeObject(getObjects(Rusia.class).get(0));
                eliminare eliminare = new eliminare();
                addObject(eliminare,415,212);
                atac atac = new atac();
                addObject(atac,872,212);
                aparare aparare = new aparare();
                addObject(aparare,415,486);
                lupta lupta = new lupta();
                addObject(lupta,872,486);
                check();
            }
            if((turns[0]==true)&&(turns[2]==true)&&(mainroom.alliance[0]==false)&&(mainroom.OKRU[0]==true)&&(Greenfoot.mouseClicked(getObjects(Rusia.class).get(0))))
            {
                Greenfoot.playSound("defend.mp3");
                mainroom.OKdecis[2]=true;
                cd[1]=3;
                cd[2]=5;
                turns[0]=false;
                turns[1]=false;
                turns[2]=false;
                removeObject(getObjects(outpanou.class).get(0));
                removeObject(getObjects(Austro_Ungaria.class).get(0));
                removeObject(getObjects(Rusia.class).get(0));
                eliminare eliminare = new eliminare();
                addObject(eliminare,415,212);
                atac atac = new atac();
                addObject(atac,872,212);
                aparare aparare = new aparare();
                addObject(aparare,415,486);
                lupta lupta = new lupta();
                addObject(lupta,872,486);
                check();
            }
            if(((mainroom.OKAU[0]==true)||(mainroom.OKRU[0]==true))&&(turns[1]==false)&&(cd[2]==0)&&(mainroom.war==true)&&(Greenfoot.mouseClicked(getObjects(aparare.class).get(0))))
            {
                Greenfoot.playSound("boop.mp3");
                turns[0]=true;
                turns[1]=true;
                turns[2]=true;
                outpanou outpanou = new outpanou();
                addObject(outpanou,887,488);
                Rusia rusia=new Rusia();
                addObject(rusia,872,212);
                if(mainroom.OKRU[0]==false)
                {
                    rusia.setImage("Rusia_dez.png");
                }
                else
                {
                    rusia.setImage("Rusia.png");
                }
                Austro_Ungaria AU=new Austro_Ungaria();
                addObject(AU,415,212);
                if(mainroom.OKAU[0]==false)
                {
                    AU.setImage("AU_dez.png");
                }
                else
                {
                    AU.setImage("AU.png");
                }
                if(cd[0]!=0)
                {
                    removeObject(getObjects(Text.class).get(0));
                }
                if(cd[1]!=0)
                {
                    removeObject(getObjects(Text.class).get(0));
                }
                removeObject(getObjects(eliminare.class).get(0));
                removeObject(getObjects(atac.class).get(0));
                removeObject(getObjects(aparare.class).get(0));
                removeObject(getObjects(lupta.class).get(0));
            }
            if(((turns[0]==true)||(turns[1]==true))&&(Greenfoot.mouseClicked(getObjects(outpanou.class).get(0))))
            {
                Greenfoot.playSound("boop.mp3");
                turns[0]=false;
                turns[1]=false;
                removeObject(getObjects(outpanou.class).get(0));
                removeObject(getObjects(Austro_Ungaria.class).get(0));
                removeObject(getObjects(Rusia.class).get(0));
                eliminare eliminare = new eliminare();
                addObject(eliminare,415,212);
                atac atac = new atac();
                addObject(atac,872,212);
                aparare aparare = new aparare();
                addObject(aparare,415,486);
                lupta lupta = new lupta();
                addObject(lupta,872,486);
                check();
            }
        }
        else
        {
            razboi();
        }
    }
    public void checkit(int i)
    {
        switch(i)
        {
            case 1:
            {
                if(mainroom.OKter[0]==true)
                {
                    init();
                    nowar_harta.OKman[10]=true;
                }
                else
                {
                    init();
                    nowar_harta.OKman[3]=true;
                }
            }
            break;
            case 2:
            {
                if(mainroom.OKter[1]==true)
                {
                    init();
                    nowar_harta.OKman[7]=true;
                }
                else
                {
                    init();
                    nowar_harta.OKman[4]=true;
                }
            }
            break;
        }
    }
    public void init()
    {
        int i;
        for(i=0; i<22; i++)
        {
            nowar_harta.OKman[i]=false;
        }
    }
    public void check()
    {
        //Se verifică dacă un buton trebuie să fie setat ca fiind activat sau nu (ca și imagine) după criteriile menționate anterior.
        if((cd[0]==0)&&(birou_foaie.ch!=45))
        {
            getObjects(eliminare.class).get(0).setImage(ac[0]);
        }
        else
        {
            getObjects(eliminare.class).get(0).setImage(dez[0]);
            Text texte=new Text();
            addObject(texte, 415, 242);
            texte.getImage().setTransparency(0);
            if(cd[0]!=0)
            {
                texte.setImage(new GreenfootImage("ETA: "+cd[0]+" zile", 20, Color.BLACK, new Color(0,0,0,0)));
            }
        }
        if((cd[1]==0)&&(birou_foaie.ch!=44)&&(birou_foaie.ch!=45)&&(mainroom.war==true)&&(mainroom.OKAU[0]==false)&&(mainroom.OKRU[0]==false)&&(((mainroom.alliance[0]==false)&&(mainroom.OKter[0]==false))||((mainroom.alliance[1]==false)&&(mainroom.OKter[1]==false))))
        {
            getObjects(atac.class).get(0).setImage(ac[1]);
        }
        else
        {
            getObjects(atac.class).get(0).setImage(dez[1]);
            if((mainroom.war==true)&&(cd[1]!=0))
            {
                Text texta=new Text();
                addObject(texta, 872, 242);
                texta.setImage(new GreenfootImage("ETA: "+cd[1]+" zile", 20, Color.BLACK, new Color(0,0,0,0)));
            }
        }
        if((cd[2]==0)&&(mainroom.war==true)&&((mainroom.OKAU[0]==true)||(mainroom.OKRU[0]==true)))
        {
            getObjects(aparare.class).get(0).setImage(ac[2]);
        }
        else
        {
            getObjects(aparare.class).get(0).setImage(dez[2]);
            if((mainroom.war==true)&&(cd[2]!=0))
            {
                    Text textd=new Text();
                    addObject(textd, 415, 516);
                    textd.setImage(new GreenfootImage("ETA: "+cd[2]+" zile", 20, Color.BLACK, new Color(0,0,0,0)));
            }
        }
        if(((cd[1]==4)||(cd[2]==4))&&(mainroom.OKdecis[2]==false))
        {
            getObjects(lupta.class).get(0).setImage(ac[5]);
        }
        else
        {
            getObjects(lupta.class).get(0).setImage(dez[5]);
        }
    }
    public void razboi()
    {
        //Această parte este executată atunci când are loc o bătălie.
        if(OKl==true)
        {
            initraz();
            fadein();
            getObjects(Text.class).get(3).TextFadeOut(3);
            fadein2();
            OKl=false;
        }
        if((OKt==true)&&(round<=4))
        {
            startq();
        }
        if(OKt==false)
        {
            int s;
            for(s=0; s<3; s++)
            {
                if(Greenfoot.mouseClicked(getObjects(Text.class).get(s)))
                {
                    if(OKa[s]==true)
                    {
                        scor++;
                    }
                    Greenfoot.playSound("boop.mp3");
                    round++;
                    OKt=true;
                }
            }
        }
        if(round==5)
        {
            fadeout2();
            decide();
            round++;
        }
    }
    //Fade-urile au rol de apariție și dispariție a textului de întâmpinare a utilizatorului.
    public void fadein2()
    {
        int i;
        for(i=17; i<=255; i=i+17)
        {
            getObjects(ab.class).get(0).getImage().setTransparency(i);
            getObjects(ab.class).get(1).getImage().setTransparency(i);
            getObjects(ab.class).get(2).getImage().setTransparency(i);
            Greenfoot.delay(2);
        }
    }
    public void fadeout2()
    {
        int i;
        for(i=255; i>=0; i=i-17)
        {
            getObjects(ab.class).get(0).getImage().setTransparency(i);
            getObjects(Text.class).get(0).getImage().setTransparency(i);
            getObjects(ab.class).get(1).getImage().setTransparency(i);
            getObjects(Text.class).get(1).getImage().setTransparency(i);
            getObjects(ab.class).get(2).getImage().setTransparency(i);
            getObjects(Text.class).get(2).getImage().setTransparency(i);
            Greenfoot.delay(2);
        }
    }
    public void decide()
    {
        //Cod care prezintă utilizatorului rezultatele bătăliei, în funcție de scor și de starea sa actuală (dacă a fost atacat sau a atacat, dacă a câștigat sau a pierdut teritorii).
        exit_help exit_help = new exit_help();
        addObject(exit_help,1233,37);
        int i,j;
        String e, b="r", ex="r";
        j=scor;
        if(scor>=baraj)
        {
            e="Felicitări, Conducătorule! Ai reușit \nsă ";
            if(mainroom.OKAU[1]==true)
            {
                b="recuperezi Transilvania cu un scor de ";
                init();
                nowar_harta.OKman[2]=true;
                mainroom.OKter[1]=true;
                ex="\nși ai obținut o unitate din fiecare resursă.";
                for(i=0; i<3; i++)
                {
                    mainroom.reso[i]++;
                }
                getObjects(Text.class).get(3).TextFadeIn(3,e+b+j+ex, 35, Color.BLACK);
            }
            if(mainroom.OKRU[1]==true)
            {
                b="recuperezi Basarabia cu un scor de ";
                init();
                nowar_harta.OKman[1]=true;
                mainroom.OKter[0]=true;
                ex="\nși ai obținut o unitate din fiecare resursă.";
               for(i=0; i<3; i++)
                {
                    mainroom.reso[i]++;
                }
               getObjects(Text.class).get(3).TextFadeIn(3,e+b+j+ex, 35, Color.BLACK);
            }
            if((mainroom.OKAU[0]==true)||(mainroom.OKRU[0]==true))
            {
                b="îți aperi țara cu un scor de ";
                getObjects(Text.class).get(3).TextFadeIn(3,e+b+j+".", 35, Color.BLACK);
                init();
                mainroom.OKRU[0]=false;
                mainroom.OKAU[0]=false;
            }
            if((mainroom.OKter[0]==true)&&(mainroom.OKter[1]==true))
            {
                init();
                nowar_harta.OKman[13]=true;
            }
            else if(mainroom.OKter[0]==true)
            {
                init();
                nowar_harta.OKman[1]=true;
            }
            else if(mainroom.OKter[1]==true)
            {
                init();
                nowar_harta.OKman[2]=true;
            }
            mainroom.OKAU[1]=false;
            mainroom.OKRU[1]=false;
        }
        else
        {
            e="Din păcate, nu ai reușit \nsă ";
            if(mainroom.OKAU[1]==true)
            {
                mainroom.OKAU[1]=false;
                b="recuperezi Transilvania cu un scor de ";
                for(i=0; i<3; i++)
                {
                    mainroom.reso[i]--;
                }
                if(mainroom.OKter[0]==true)
                {
                    init();
                    nowar_harta.OKman[1]=true;
                }
                else
                {
                    init();
                    nowar_harta.OKman[0]=true;
                }
            }
            if(mainroom.OKRU[1]==true)
            {
                mainroom.OKRU[1]=false;
                b="recuperezi Basarabia cu un scor de ";
                for(i=0; i<3; i++)
                {
                    mainroom.reso[i]--;
                }
                if(mainroom.OKter[1]==true)
                {
                    init();
                    nowar_harta.OKman[2]=true;
                }
                else
                {
                    init();
                    nowar_harta.OKman[0]=true;
                }
            }
            if((mainroom.OKAU[0]==true)||(mainroom.OKRU[0]==true))
            {
                b="îți aperi țara cu un scor de ";
                if((mainroom.OKter[1]==true)&&(mainroom.OKAU[0]==true))
                {
                    mainroom.OKter[1]=false;
                    if(mainroom.OKter[0]==true)
                    {
                        init();
                        nowar_harta.OKman[1]=true;
                    }
                    else
                    {
                        init();
                        nowar_harta.OKman[0]=true;
                    }
                }
                else if(mainroom.OKAU[0]==true)
                {
                    mainroom.win=-2;
                    init();
                    nowar_harta.OKman[21]=true;
                }
                if((mainroom.OKter[0]==true)&&(mainroom.OKRU[0]==true))
                {
                    mainroom.OKter[0]=false;
                    if(mainroom.OKter[1]==true)
                    {
                        init();
                        nowar_harta.OKman[2]=true;
                    }
                    else
                    {
                        init();
                        nowar_harta.OKman[0]=true;
                    }
                }
                else if(mainroom.OKRU[0]==true)
                {
                    mainroom.win=-1;
                    init();
                    nowar_harta.OKman[21]=true;
                }
                for(i=0; i<3; i++)
                {
                    mainroom.reso[i]--;
                }
            }
            if(mainroom.win>-1)
            {
                if(mainroom.OKter[0]==true)
                {
                    init();
                    nowar_harta.OKman[1]=true;
                }
                else if(mainroom.OKter[1]==true)
                {
                    init();
                    nowar_harta.OKman[2]=true;
                }
            }
            ex="\nși ai pierdut o unitate din fiecare resursă.";
            mainroom.OKRU[0]=false;
            mainroom.OKAU[0]=false;
            getObjects(Text.class).get(3).TextFadeIn(3,e+b+j+ex, 35, Color.BLACK);
        }
        mainroom.OKdecis[2]=true;
    }
    public void fadein()
    {
        //Se verifică, în funcție de numărul de militari, câte greșeli își poate permite utilizatorul, barajul reprezentând numărul minim de răspunsuri corecte pe care trebuie să le dea
        //jucătorul pentru a câștiga.
        int i;
        String at="filler";
        for(i=17; i<=255; i=i+17)
        {
            getObjects(qb.class).get(0).getImage().setTransparency(i);
            Greenfoot.delay(2);
        }
        if(mainroom.reso[1]<=0)
        {
            baraj=5;
            at="A sosit momentul să luptăm!\n Răspunde corect la toate întrebările pentru a câștiga!";
        }
        else if((mainroom.reso[1]>0)&&(mainroom.reso[1]<=5))
        {
            baraj=4;
            at="A sosit momentul să luptăm!\n Răspunde corect la cel puțin 4 întrebări pentru a câștiga!";
        }
        else if((mainroom.reso[1]>5)&&(mainroom.reso[1]<=13))
        {
            baraj=3;
            at="A sosit momentul să luptăm!\n Răspunde corect la cel puțin 3 întrebări pentru a câștiga!";
        }
        else if(mainroom.reso[1]>13)
        {
            baraj=2;
            at="A sosit momentul să luptăm!\n Răspunde corect la cel puțin 2 întrebări pentru a câștiga!";
        }
        getObjects(Text.class).get(3).TextFadeIn(3,at, 35, Color.BLACK);
        Greenfoot.delay(250);
    }
    public void startq()
    {
        //Se alege aleatoriu o întrebare, se verifică dacă aceasta a mai fost pusă anterior, iar, în cazul în care nu a apărut înainte, este afișată pe ecran.
        //Răspunsurile sunt, de asemenea, așezate aleatoriu pe cele 3 butoane de pe panoul de control.
        OKt=false;
        int i, j, k;
        i=Greenfoot.getRandomNumber(56);
        if(hasr[i]==true)
        {
            getObjects(Text.class).get(3).setImage(new GreenfootImage(q[i], 30, Color.BLACK, new Color(0,0,0,0)));
            j=Greenfoot.getRandomNumber(3);
            k=Greenfoot.getRandomNumber(2);
            switch(j)
            {
                case 0:
                switch(k)
                {
                    case 0: getObjects(Text.class).get(k+1).setImage(new GreenfootImage(a[i][0], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[k+1]=ansc[i][0];
                    getObjects(Text.class).get(2).setImage(new GreenfootImage(a[i][1], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[2]=ansc[i][1];
                    break;
                    case 1: getObjects(Text.class).get(k+1).setImage(new GreenfootImage(a[i][0], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[k+1]=ansc[i][0];
                    getObjects(Text.class).get(1).setImage(new GreenfootImage(a[i][1], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[1]=ansc[i][1];
                    break;
                }
                getObjects(Text.class).get(j).setImage(new GreenfootImage(a[i][2], 30, Color.BLACK, new Color(0,0,0,0)));
                OKa[j]=ansc[i][2];
                break;
                case 1:
                switch(k)
                {
                    case 0: getObjects(Text.class).get(k).setImage(new GreenfootImage(a[i][0], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[k]=ansc[i][0];
                    getObjects(Text.class).get(2).setImage(new GreenfootImage(a[i][1], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[2]=ansc[i][1];
                    break;
                    case 1: getObjects(Text.class).get(k+1).setImage(new GreenfootImage(a[i][0], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[k+1]=ansc[i][0];
                    getObjects(Text.class).get(0).setImage(new GreenfootImage(a[i][1], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[0]=ansc[i][1];
                    break;
                }
                getObjects(Text.class).get(j).setImage(new GreenfootImage(a[i][2], 30, Color.BLACK, new Color(0,0,0,0)));
                OKa[j]=ansc[i][2];
                break;
                case 2:
                switch(k)
                {
                    case 0: getObjects(Text.class).get(k).setImage(new GreenfootImage(a[i][0], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[k]=ansc[i][0];
                    getObjects(Text.class).get(1).setImage(new GreenfootImage(a[i][1], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[1]=ansc[i][1];
                    break;
                    case 1: getObjects(Text.class).get(k).setImage(new GreenfootImage(a[i][0], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[k]=ansc[i][0];
                    getObjects(Text.class).get(0).setImage(new GreenfootImage(a[i][1], 30, Color.BLACK, new Color(0,0,0,0)));
                    OKa[0]=ansc[i][1];
                    break;
                }
                getObjects(Text.class).get(j).setImage(new GreenfootImage(a[i][2], 30, Color.BLACK, new Color(0,0,0,0)));
                OKa[j]=ansc[i][2];
                break;
            }
            hasr[i]=false;
        }
        else
        {
            OKt=true;
        }
    }
    public void initraz()
    {
        //Inițializarea butoanelor de război.
        qb qb = new qb();
        addObject(qb,641,194);
        qb.getImage().setTransparency(0);
        ab ab = new ab();
        addObject(ab,410, 497);
        ab.getImage().setTransparency(0);
        ab ab2 = new ab();
        addObject(ab2,872,497);
        ab2.getImage().setTransparency(0);
        ab ab3 = new ab();
        addObject(ab3,642,372);
        ab3.getImage().setTransparency(0);
        if(cd[0]!=0)
        {
            removeObject(getObjects(Text.class).get(2));
            removeObject(getObjects(Text.class).get(1));
            removeObject(getObjects(Text.class).get(0));
        }
        else
        {
            removeObject(getObjects(Text.class).get(1));
            removeObject(getObjects(Text.class).get(0));
        }
        Text text2=new Text();
        addObject(text2, 410, 497);
        text2.getImage().setTransparency(0);
        Text text3=new Text();
        addObject(text3, 872, 497);
        text3.getImage().setTransparency(0);
        Text text4=new Text();
        addObject(text4, 642, 372);
        text4.getImage().setTransparency(0);
        Text text=new Text();
        addObject(text,641,194);
        text.getImage().setTransparency(0);
        removeObject(getObjects(lupta.class).get(0));
        removeObject(getObjects(eliminare.class).get(0));
        removeObject(getObjects(exit_help.class).get(0));
        removeObject(getObjects(atac.class).get(0));
        removeObject(getObjects(aparare.class).get(0));
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        exit_help exit_help = new exit_help();
        addObject(exit_help,1233,37);
        eliminare eliminare = new eliminare();
        addObject(eliminare,415,212);
        atac atac = new atac();
        addObject(atac,872,212);
        aparare aparare = new aparare();
        addObject(aparare,415,486);
        lupta lupta = new lupta();
        addObject(lupta,872,486);
    }
}
