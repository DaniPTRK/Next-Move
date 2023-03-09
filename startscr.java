import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Aici are loc inițializarea lumii de început, unde vor apărea 3 butoane: play, help și exit.
 * ATENȚIE! Acest joc este realizat cu ajutorul unor variabile statice fără de care jocul nu poate funcționa corespunzător.
 * Este NECESAR ca utilizatorul să apese pe butonul de PLAY pentru ca jocul să funcționeze normal.
 */
public class startscr extends introducere
{
    boolean OK=false;
    /**
     *
     * 
     */
    public startscr()
    {    
        prepare();
    }
    public void act()
    {
        getObjects(exit.class).get(0).music.stop();
    }
    private void prepare()
    {
        exit exit = new exit();
        help help = new help();
        play play = new play();
        addObject(exit,672,603);
        addObject(help,792,489);
        addObject(play,548,470);
    }
}
