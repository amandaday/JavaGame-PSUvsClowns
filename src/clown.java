import javax.swing.*;

public class clown extends JButton
{
    String type;
    JButton clown;
    Timer tim;
    int delay = 0;
    int i = 0;
    int cl1 = spawnClown();
    int cl2; 
    public int clownHP = 0;
    int oldHP = 40;
    clown[] cl;
    
    clown(String a)
    {
       super();
       type = a;
    }
    
    int spawnClown()
    {
        clownHP = oldHP+20;
        oldHP = clownHP;
        double t = Math.random();                        
        int y = (int) (t * 5);
                        
           
                        if (y == 0)
                        {
                            return 80;
                        }
                        if (y == 1)
                        {
                            return 150;
                        }
                        if (y == 2)
                        {
                            return 220;
                        }
                        if (y == 3)
                        {
                            return 290;
                        }
                        if (y == 4)
                        {
                            return 360;
                        }
                        else return 7;
    }    
    
    
    int moveClown1()
    {
       return cl1 - 10; 
    }
    
    int moveClown2()
    {
       return cl2 - 10; 
    }
    
    int clownDamage()
    {
        clownHP = clownHP - 10;
        return clownHP;
    }
}


