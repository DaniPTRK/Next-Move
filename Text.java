import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Cod utilizat pentru obiectele setate cu imagini de tip String.
 */
public class Text extends Actor
{
    int difp=0;
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    public void showText(int i)
    {
        //Acest text apare atunci când Aurel atinge unul dintre obiectele cu care poate interacționa.
        setImage(new GreenfootImage("Apasa E pentru a utiliza "+getWorld().getObjects(Conducator.class).get(0).getNume(i), 25, Color.WHITE, new Color(0,0,0,0)));
    }
    //Apariția textului în funcție de culoare, mărime, numărul obiectului, Stringul cu care este setat.
    public void TextFadeIn(int j, String a, int size, Color cl)
    {
        int i;
        setImage(new GreenfootImage(a, size, cl, new Color(0,0,0,0)));
        getWorld().getObjects(Text.class).get(j).getImage().setTransparency(0);
        for(i=0; i<=255; i=i+5)
        {
            getWorld().getObjects(Text.class).get(j).getImage().setTransparency(i);
            Greenfoot.delay(1);
        }
    }
    public void removeText()
    {
        getWorld().getObjects(Text.class).get(0).getImage().setTransparency(0);
    }
    public void TextFadeOut(int j)
    {
          int i;
          for(i=255; i>=0; i=i-5)
          {
              getWorld().getObjects(Text.class).get(j).getImage().setTransparency(i);
              Greenfoot.delay(1);
          }
    }
    //Setarea textului în cadranul cu resurse în cazul în care avem peste 10 unități la una dintre resurse.
    public void changeExceedingResources(int type, int dif)
    {
            difp=dif;
            switch(type)
            {
                case 0: setImage(new GreenfootImage("+ "+ difp, 40, Color.YELLOW, new Color(0,0,0,0)));
                break;
                case 1: setImage(new GreenfootImage("+ "+ difp, 40, Color.GREEN, new Color(0,0,0,0)));
                break;
                case 2: setImage(new GreenfootImage("+ "+ difp, 40, Color.BLUE, new Color(0,0,0,0)));
                break;
            }
    }
}
