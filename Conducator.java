import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Personajul condus de către utilizator.
 */
public class Conducator extends Personaje
{
    private GreenfootImage image1, image2;
    boolean OKc[]={true, true, true, true};
    boolean OKc2[]={true, true, true, true};
    boolean OKf[]={false, false, false, false};
    boolean OKad[]={false, false, false};
    int countdays=mainroom.countdays;
    int count=0;
    int[] p=new int[]{0,0,0,0};
    r_unit[] r_unit=new r_unit[10];
    m_unit[] m_unit=new m_unit[10];
    p_unit[] p_unit=new p_unit[10];
    int[] exceed={0,0,0};
    int x=0, y=0;
    private int[][] coord_birou= new int[40][2];
    private String[] nume_birou={"radioul militar.", "harta.", "pupitrul generalilor.", "usa.", "manualul de razboi.", "biroul."};
    private Class[] clase_birou={radio_militar.class, harta.class, pupitru_generali.class, usa.class, manual_razboi.class, birou.class, biblioteca.class, patefon.class, planta.class, planta2.class};
    private Actor[] actori_birou= new Actor[20];
    /**
     * Act - do whatever the Conducator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Dacă Aurel se află în mainroom și tutorialul extins nu este deschis, acesta poate fi controlat.
        if((getWorld().getClass()==mainroom.class)&&(((mainroom) getWorld()).a!=1))
        {
            actori_birou=new Actor[] {getWorld().getObjects(radio_militar.class).get(0), getWorld().getObjects(harta.class).get(0), getWorld().getObjects(pupitru_generali.class).get(0), getWorld().getObjects(usa.class).get(0), getWorld().getObjects(manual_razboi.class).get(0), getWorld().getObjects(birou.class).get(0), getWorld().getObjects(biblioteca.class).get(0), getWorld().getObjects(patefon.class).get(0), getWorld().getObjects(planta.class).get(0), getWorld().getObjects(planta2.class).get(0)};
            declarecoord();
            if((getWorld().getClass()==mainroom.class)&&(getWorld().getObjects(Text.class).get(4).getImage().getTransparency()==0))
            {
                walking();
                collidingObject();
                collidingWall();
            }
            if((OKc2[0]==true)&&(OKc2[1]==true)&&(OKc2[2]==true)&&(OKc2[3]==true)&&(!isTouching(harta.class)))
            {
                 removeTxt();
            }
        }
    }
    public void walking()
    {
        //Procesul de controlare al lui Aurel prin tastele WASD.
        if(Greenfoot.isKeyDown("d")&&(OKc[1]==true)&&(OKc2[1]==true))
        {
            image1= new GreenfootImage("dreaptamers1.png");
            image2= new GreenfootImage("dreaptamers2.png");
            setLocation(getX()+4, getY());
            setImage(image1);
            animateWalk();
            setFacing();
            if(OKf[2]!=true)
            {
                setFacing();
                OKf[2]=true;
            }
        }
        else if(Greenfoot.isKeyDown("a")&&(OKc[0]==true)&&(OKc2[0]==true))
        {
            image1= new GreenfootImage("stangamers1.png");
            image2= new GreenfootImage("stangamers2.png");
            setLocation(getX()-4, getY());
            setImage(image1);
            animateWalk();
            if(OKf[1]!=true)
            {
                setFacing();
                OKf[1]=true;
            }
        }
        else if(Greenfoot.isKeyDown("w")&&(OKc[2]==true)&&(OKc2[2]==true))
        {
            image1= new GreenfootImage("spatemers1.png");
            image2= new GreenfootImage("spatemers2.png");
            setLocation(getX(), getY()-4);
            setImage(image1);
            animateWalk();
            if(OKf[0]!=true)
            {
                setFacing();
                OKf[0]=true;
            }
        }
        else if(Greenfoot.isKeyDown("s")&&(OKc[3]==true)&&(OKc2[3]==true))
        {
            image1= new GreenfootImage("fatamers1.png");
            image2= new GreenfootImage("fatamers2.png");
            setLocation(getX(), getY()+4);
            setImage(image2);
            animateWalk();
            if(OKf[3]!=true)
            {
                setFacing();
                OKf[3]=true;
            }
        }
        else
            setIdle();
    }
    public void animateWalk()
    {
        //Animația mersului
        if(count%100>50)
        {
            setImage(image2);
        }
        if(count%100<=50)
        {
            setImage(image1);
        }
        count++;
        if(count>100)
        {
            count=0;
        }
    }
    public void collidingWall()
    {
        //Verificare coliziune cu perete.
        if(this.getX()<125)
        {
            OKc[0]=false;
        }
        else
        {
            OKc[0]=true;
        }
        if(this.getX()>1175)
        {
            OKc[1]=false;
        }
        else
        {
            OKc[1]=true;
        }
        if(this.getY()<95)
        {
            OKc[2]=false;
        }
        else
        {
            OKc[2]=true;
        }
        if(this.getY()>645)
        {
            OKc[3]=false;
        }
        else
        {
            OKc[3]=true;
        }
    }
    public void setFacing()
    {
        OKf[0]=false;
        OKf[1]=false;
        OKf[2]=false;
        OKf[3]=false;
    }
    public void setIdle()
    {
        //Setarea orientării în funcție de facing. 
        if(OKf[0]==true)
        {
            setImage("spate.png");
        }
        else if(OKf[1]==true)
        {
            setImage("stanga.png");
        }
        else if(OKf[2]==true)
        {
            setImage("dreapta.png");
        }
        else
        {
            setImage("fata.png");
        }
    }
    public void interaction(int i)
    {
        //Procese de interacțiune
        if(Greenfoot.isKeyDown("e"))
        {
            mainroom.px=getX()+10*p[1]-10*p[0];
            mainroom.py=getY()-10*p[3]+10*p[2];
            switch(i)
            {
                case 0: Greenfoot.setWorld(new radio_militar_front());
                break;
                case 1: Greenfoot.playSound("map.mp3"); 
                Greenfoot.setWorld(new nowar_harta());
                break;
                case 2: Greenfoot.setWorld(new pupitru_generali_front());
                break;
                case 3:  
                if((mainroom.OKdecis[0]==true)&&(mainroom.OKdecis[2]==true))
                {
                    ((mainroom)getWorld()).refreshday(3);
                }
                break;
                case 4:Greenfoot.playSound("openbook.mp3"); 
                Greenfoot.setWorld(new birou_manual());
                break;
                case 5: Greenfoot.playSound("sit.mp3");
                Greenfoot.setWorld(new birou_foaie());
                break;
            }
        }
    }
    public void collidingObject()
    {
        //În cazul unei coliziuni, se verifică mai multe condiții în funcție de care se alege sau nu interacțiunea lui Aurel cu obiectul cu care se află în contact.
        int i=0;
        for(i=0; i<clase_birou.length; i++)
        {
            if(isTouching(clase_birou[i]))
            {
                if(i!=1)
                {
                    turnCollisionObjectOn(i);
                }
                if(i<6)
                {
                    if((i==3)&&(mainroom.OKdecis[0]==true)&&(mainroom.OKdecis[2]==true))
                    {
                        text(i);
                        interaction(i);
                    }
                    else if(i!=3)
                    {
                        text(i);
                        interaction(i);
                    }
                }
            }
            else if(x==coord_birou[i][0])
            {
                turnCollisionObjectOff();
            }
        }
    }
    public void turnCollisionObjectOn(int i)
    {
        //Se setează coliziunea.
        x=coord_birou[i][0];
        y=coord_birou[i][1];
        if((getX()<x)&&(Greenfoot.isKeyDown("d")&&(OKc2[0]==true)&&(OKc2[2]==true)&&(OKc2[3]==true)))
        {
            OKc2[1]=false;
            p[0]=1;
            p[1]=0;
            p[2]=0;
            p[3]=0;
        }
        if((getX()>x)&&(Greenfoot.isKeyDown("a"))&&(OKc2[1]==true)&&(OKc2[2]==true)&&(OKc2[3]==true))
        {
            OKc2[0]=false;
            p[0]=0;
            p[1]=1;
            p[2]=0;
            p[3]=0;
        }
        if((getY()>y)&&(Greenfoot.isKeyDown("w"))&&(OKc2[1]==true)&&(OKc2[0]==true)&&(OKc2[3]==true))
        {
           OKc2[2]=false;
            p[0]=0;
            p[1]=0;
            p[2]=1;
            p[3]=0;
        }
        if((getY()<y)&&(Greenfoot.isKeyDown("s"))&&(OKc2[0]==true)&&(OKc2[1]==true)&&(OKc2[2]==true))
        {
           OKc2[3]=false;
           p[0]=0;
           p[1]=0;
           p[2]=0;
           p[3]=1;
        }
    }
   public void turnCollisionObjectOff()
   {
       //Se scoate coliziunea.
      OKc2[0]=true;
      OKc2[1]=true;
      OKc2[2]=true;
      OKc2[3]=true;
   }
   //Diferite procese de schimbare a textului si de inițializare.
   public void declarecoord()
   {
       int i;
       for(i=0; i<clase_birou.length; i++)
       {
           coord_birou[i][0]=actori_birou[i].getX();
           coord_birou[i][1]=actori_birou[i].getY();
       }
   }
   public String getNume(int i)
   {
       return nume_birou[i];
   }
    public void text(int i)
   {
      if(mainroom.OKdecis[1]==false)
      {
          getWorld().getObjects(Text.class).get(0).showText(i);
      }
      else
      {
          getWorld().getObjects(Text.class).get(4).TextFadeIn(4,"Day "+ countdays, 100, Color.WHITE);
      }
   }
   public void removeTxt()
   {
      if(mainroom.OKdecis[1]==false)
      {
          getWorld().getObjects(Text.class).get(0).removeText();
      }
      else
      {
          getWorld().getObjects(Text.class).get(4).TextFadeOut(4);
      }
   }
   public void initResources()
   {
       //Inițializarea resurselor.
       int i;
       for(i=0; i<3; i++)
       {
           if(mainroom.reso[i]-10>0)
           {
               exceed[i]=10;
               getWorld().getObjects(Text.class).get(i+1).changeExceedingResources(i, mainroom.reso[i]-exceed[i]);
               getWorld().getObjects(Text.class).get(i+1).getImage().setTransparency(255);
           }
           else
           {
               exceed[i]=mainroom.reso[i];
           }
       }
       for(i=0; i<exceed[0]; i++)
       {
           r_unit[i].getImage().setTransparency(255);
       }
       for(i=0; i<exceed[1]; i++)
       {
           m_unit[i].getImage().setTransparency(255);
       }
       for(i=0; i<exceed[2]; i++)
       {
           p_unit[i].getImage().setTransparency(255);
       }
    }
}

