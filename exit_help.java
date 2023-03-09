import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *   Buton utilizat pentru ieșirea din diferite lumi.
 */
public class exit_help extends ButonHelp
{
    /**
     * Acest buton acționează în funcție de lumea în care se află, el fiind utilizat în principal pentru a ieși din lumea respectivă, dar având tosuși și alte însușiri.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(getWorld().getObjects(exit_help.class).get(0)))
        {
            if(getWorld() instanceof helpsc)
            {
                Greenfoot.setWorld(new startscr());
                Greenfoot.playSound("helpsc_sound.mp3");
            }
            if(getWorld() instanceof scene_birou)
            {
                if(getWorld() instanceof panou_control)
                {
                    Greenfoot.playSound("closepanel.mp3");
                }
                if(getWorld() instanceof pupitru_generali_front)
                {
                    Greenfoot.playSound("closecards.mp3");
                }
                if(getWorld() instanceof nowar_harta)
                {
                    Greenfoot.playSound("map.mp3");
                }
                if(getWorld() instanceof birou_manual)
                {
                    Greenfoot.playSound("closebook.mp3");
                }
                if(getWorld() instanceof birou_foaie)
                {
                    Greenfoot.playSound("outchair.mp3");
                }
                Greenfoot.setWorld(new mainroom());                
            }
            if(getWorld() instanceof choice_gen)
            {
                Greenfoot.setWorld(new mainroom());
                if((((choice_gen) getWorld()).s!=-1)&&(((choice_gen) getWorld()).r!=-1))
                {
                    choice_gen.OKim[((choice_gen) getWorld()).s]=false;
                    choice_gen.o[((choice_gen) getWorld()).r]--;
                }
                Greenfoot.playSound("closecards.mp3");
            }
            if(getWorld() instanceof mainroom)
            {
                Greenfoot.playSound("openhelp.mp3");
                ((mainroom) getWorld()).a=0;
                getWorld().getObjects(helpin.class).get(0).getImage().setTransparency(0);
                if((((mainroom) getWorld()).ihelp>=1)&&((mainroom) getWorld()).ihelp<(((mainroom) getWorld()).helppag.length-1))
                {
                    getWorld().removeObject(getWorld().getObjects(drhelp.class).get(0));
                    getWorld().removeObject(getWorld().getObjects(stghelp.class).get(0));
                }
                else if(((mainroom) getWorld()).ihelp==0)
                {
                    getWorld().removeObject(getWorld().getObjects(drhelp.class).get(0));
                }
                else if(((mainroom) getWorld()).ihelp==((mainroom) getWorld()).helppag.length-1)
                {
                    getWorld().removeObject(getWorld().getObjects(stghelp.class).get(0));
                }
                ((mainroom) getWorld()).ihelp=0;
                ((mainroom) getWorld()).ij=-1;
                getWorld().removeObject(getWorld().getObjects(exit_help.class).get(0));
            }
            if(getWorld() instanceof credits)
            {
                int i;
                for(i=0; i<=255; i=i+5)
                {
                    getWorld().getObjects(Inter.class).get(0).getImage().setTransparency(i);
                    getWorld().getObjects(exit_help.class).get(0).getImage().setTransparency(255-i);
                    Greenfoot.delay(3);
                }
                ((credits) getWorld()).music.stop();
                Greenfoot.setWorld(new startscr());
            }
        }
    }    
}
