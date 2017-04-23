import javax.swing.*;

public class orb extends JButton
{
    String name;
    public int currentPos;
    public int orbPosy;
    
    orb(String a)
    {
        super();
        name = a;
    }
    
    int spawnOrbx(int horz)
    {
        currentPos = horz;
        return currentPos;
    }
    int spawnOrby(int vert)
    {
        orbPosy = vert;
        return orbPosy;
    }
    
    int moveOrb()
    {
       currentPos = currentPos +40;
       return currentPos; 
    }
}
