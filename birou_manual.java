import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Loc de învățare.
 */
public class birou_manual extends scene_birou
{
    public Actor[] pages;
    int i=0, aj=-1;
    /**
     * Constructor for objects of class birou_manual.
     * 
     */
    public birou_manual()
    {
        prepare();
    }
    public void act()
    {
        pages=new Actor[]{getObjects(manual_inch.class).get(0), getObjects(manual_des.class).get(0), getObjects(cup.class).get(0), getObjects(page1.class).get(0),getObjects(page2.class).get(0),getObjects(page3.class).get(0),getObjects(page4.class).get(0),getObjects(page5.class).get(0)};
        if((i==0)&&(Greenfoot.mouseClicked(getObjects(openman.class).get(0)))||((i>0)&&(i<pages.length-1)&&(Greenfoot.mouseClicked(getObjects(drpt.class).get(0)))))
        {
            turnpages(1, i+1);
            i++;
        }
        if((i==1)&&(Greenfoot.mouseClicked(getObjects(closeman.class).get(0)))||((i>1)&&(Greenfoot.mouseClicked(getObjects(stg.class).get(0)))))
        {
            turnpages(2, i-1);
            i--;
        }
    }
    public void turnpages(int caz,int j)
    {
        //Prin apăsarea săgeților de la manual de război, sunt schimbate paginile, dar și săgețile în funcție de pagina unde se află utilizatorul.
        Greenfoot.playSound("turnpage.mp3");
        if(caz==1)
        {
            pages[j].getImage().setTransparency(255);
            pages[j-1].getImage().setTransparency(0);
        }
        else
        {
            pages[j+1].getImage().setTransparency(0);
            pages[j].getImage().setTransparency(255);
        }
        if(j==0)
        {
            openman openman = new openman();
            addObject(openman,1125,554);
            removeObject(getObjects(closeman.class).get(0));
            removeObject(getObjects(drpt.class).get(0));
        }
        else if(j==1)
        {
            if(aj<2)
            {
                drpt drpt = new drpt();
                addObject(drpt,1127,584);
                closeman closeman = new closeman();
                addObject(closeman,130,554);
                removeObject(getObjects(openman.class).get(0));
            }
            if(aj==2)
            {
                closeman closeman = new closeman();
                addObject(closeman,130,554);
                removeObject(getObjects(stg.class).get(0));
            }
        }
        else if(j==2)
        {
            if(aj<3)
            {
                stg stg= new stg();
                addObject(stg,130,584);
                removeObject(getObjects(closeman.class).get(0));
            }
        }
        if(j==pages.length-1)
        {
            removeObject(getObjects(drpt.class).get(0));
        }
        if((aj==pages.length-1)&&(j<aj))
        {
           drpt drpt = new drpt();
           addObject(drpt,1127,584);
        }
        aj=j;
    }
    private void prepare()
    {
        manual_inch manual_inch = new manual_inch();
        addObject(manual_inch,920,368);
        manual_des manual_des = new manual_des();
        manual_des.getImage().setTransparency(0);
        addObject(manual_des,631,365);
        cup cup=new cup();
        addObject(cup,631,365);
        cup.getImage().setTransparency(0);
        page1 page1=new page1();
        addObject(page1,631,365);
        page1.getImage().setTransparency(0);
        page2 page2=new page2();
        addObject(page2,631,365);
        page2.getImage().setTransparency(0);
        page3 page3=new page3();
        addObject(page3,631,365);
        page3.getImage().setTransparency(0);
        page4 page4=new page4();
        addObject(page4,631,365);
        page4.getImage().setTransparency(0);
        page5 page5=new page5();
        addObject(page5,631,365);
        page5.getImage().setTransparency(0);
        exit_help exit_help = new exit_help();
        addObject(exit_help,1233,37);
        openman openman = new openman();
        addObject(openman,1125,554);
    }
}
