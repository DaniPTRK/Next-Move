import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Scenă cu dublă utilizare, primul caz fiind cel legat de intro, iar al doilea legat de final.
 */
public class alegeri extends cutscene
{
    public Actor[] vill= new Actor[20];
    public alegeri()
    {
        prepare();
        getObjects(Inter.class).get(0).passday1(0);
    }
    public void act()
    {
        if(mainroom.countdays==1)
        {
            getObjects(Text.class).get(0).TextFadeIn(0,"Apariția lui Aurel la conducere a fost pozitiv primită de către populație,\ncu toții așteptând cu sufletul la gură unirea României Mari.", 35, Color.WHITE);
            Greenfoot.delay(390);
            getObjects(Text.class).get(0).TextFadeOut(0);
            getObjects(Inter.class).get(0).passday2(0);
            appearance();
            Greenfoot.playSound("cheer.mp3");
            cheer();
            getObjects(Inter.class).get(0).passday1(0);
            getObjects(Text.class).get(0).TextFadeIn(0,"Mai înainte ca Aurel să își înceapă propriu-zis mandatul,\n acesta a trebuit să-și aleagă Miniștrii și Diplomatul...\n", 35, Color.WHITE);
            Greenfoot.delay(480);
            getObjects(Text.class).get(0).TextFadeOut(0);
            Greenfoot.setWorld(new choice_gen());
        }
        else
        {
            //Se verifică formatul țării, format ce provoacă consecințe felurite.
            if(nowar_harta.OKman[20]==true)
            {
                getObjects(Text.class).get(0).TextFadeIn(0,"Văzând faptele mari ale lui Aurel, populația i-a promis Conducătorului\n și următorul mandat.", 40, Color.WHITE);
            }
            else if(nowar_harta.OKman[19]==true)
            {
                getObjects(Text.class).get(0).TextFadeIn(0,"Văzând faptele mari ale lui Aurel, populația i-a promis Conducătorului\n și următorul mandat, sperându-se că, sub conducerea sa, România va obține și ultimele pământuri.", 40, Color.WHITE);
            }
            else if(nowar_harta.OKman[18]==true)
            {
                 getObjects(Text.class).get(0).TextFadeIn(0,"Populația a fost mulțumită de înfăptuirile lui Aurel,\n dar obținerea ultimului mandat de către acesta stă sub semnul întrebării.", 40, Color.WHITE);
            }
            else if(nowar_harta.OKman[17]==true)
            {
                getObjects(Text.class).get(0).TextFadeIn(0,"Populația a fost mulțumită de înfăptuirile lui Aurel,\n dar obținerea ultimului mandat de către acesta stă sub semnul întrebării.", 40, Color.WHITE);
            }
            else
            {
                getObjects(Text.class).get(0).TextFadeIn(0,"Populația a fost nemulțumită de acțiunile lui Aurel din timpul războiului,\n fiind privit de acum înainte ca un simplu demagog.", 40, Color.WHITE);
            }
            Greenfoot.delay(390);
            getObjects(Text.class).get(0).TextFadeOut(0);
            getObjects(Inter.class).get(0).passday2(0);
            appearance();
            if(nowar_harta.OKman[16]!=true)
            {
                Greenfoot.playSound("cheer.mp3");
                cheer();
            }
            else
            {
                Greenfoot.playSound("jeer2.mp3");
                cheer();
            }
            getObjects(Inter.class).get(0).passday1(0);
            Greenfoot.setWorld(new credits());
        }
    } 
    private void prepare()
    {
        Conducator conducator = new Conducator();
        addObject(conducator,640,73);
        conducator.getImage().setTransparency(0);
        over1 over1 = new over1();
        addObject(over1,640,125);
        v10 v10 = new v10();
        addObject(v10,484,520);
        v11 v11 = new v11();
        addObject(v11,158,518);
        v2 v2 = new v2();
        addObject(v2,230,620);
        v4 v4 = new v4();
        addObject(v4,309,505);
        v3 v3 = new v3();
        addObject(v3,361,646);
        v5 v5 = new v5();
        addObject(v5,927,473);
        v6 v6 = new v6();
        addObject(v6,1136,555);
        v7 v7 = new v7();
        addObject(v7,1063,632);
        v8 v8 = new v8();
        addObject(v8,810,496);
        v9 v9 = new v9();
        addObject(v9,100,635);
        v1 v1 = new v1();
        addObject(v1,872,628);
        Inter inter= new Inter();
        addObject(inter, 640, 355);
        getObjects(Inter.class).get(0).init();
        Text text=new Text();
        addObject(text, 640, 355);
        text.getImage().setTransparency(0);
        Text text2=new Text();
        addObject(text2, 640, 355);
        text2.getImage().setTransparency(0);
    }
    //Animație a sătenilor.
    private void cheer()
    {
        Actor[] vill= new Actor[]{getObjects(v1.class).get(0), getObjects(v2.class).get(0),getObjects(v3.class).get(0),getObjects(v4.class).get(0),getObjects(v5.class).get(0),getObjects(v6.class).get(0),getObjects(v7.class).get(0),getObjects(v8.class).get(0),getObjects(v9.class).get(0),getObjects(v10.class).get(0),getObjects(v11.class).get(0)};
        int i,j=0;
        for(i=0; i<=70; i++)
        {
            j=Greenfoot.getRandomNumber(11);
            vill[j].setLocation(vill[j].getX(), vill[j].getY()-50);
            Greenfoot.delay(3);
            vill[j].setLocation(vill[j].getX(), vill[j].getY()+50);
            Greenfoot.delay(3);
        }
    }
    private void appearance()
    {
        getObjects(Conducator.class).get(0).setLocation(640,59);
        int i;
        for(i=0; i<=255; i=i+15)
        {
            getObjects(Conducator.class).get(0).getImage().setTransparency(i);
            if(getObjects(Conducator.class).get(0).getY()!=73)
            {
                getObjects(Conducator.class).get(0).setLocation(getObjects(Conducator.class).get(0).getX(),getObjects(Conducator.class).get(0).getY()+1);
            }
            Greenfoot.delay(3);
        }
    }
}
