import javax.swing.*;

class Defender extends JButton 
{
    JPanel SetUp, StartGame;
    String type;
    JButton jb3;
    //JButton d11,d12,d13,d14,d15,d21,d22,d23,d24,d25,d31,d32,d33,d34,d35,d41,d42,d43,d44,d45,d51,d52,d53,d54,d55;
    int o1,o2,o3;
    //int setPosX,setPosY;
    public int posX, posY;
    public boolean activated;
    
    Defender(String a, int setPosX, int setPosY, boolean isActivated)
    {
       super();
       type = a;
       posX = setPosX;
       posY = setPosY;
       activated = isActivated;
    }
    /*int posX()
    {
        return posX;
    }
    int posY()
    {
        return posY;
    }*/
    //boolean activated()
    //{
    //    activated = true;
    //    return activated;
    //}
   
    //faulty...
//    String getDefender()
//    {
//        if (o2 == 1)
//                {
//                    ImageIcon imageLion = new ImageIcon("images/nl1a.png");
//                    d11.setIcon(imageLion);
//                    d12.setIcon(imageLion);
//                    d13.setIcon(imageLion);
//                    d14.setIcon(imageLion);
//                    d15.setIcon(imageLion);
//                    d21.setIcon(imageLion);
//                    d22.setIcon(imageLion);
//                    d23.setIcon(imageLion);
//                    d24.setIcon(imageLion);
//                    d25.setIcon(imageLion);
//                    d31.setIcon(imageLion);
//                    d32.setIcon(imageLion);
//                    d33.setIcon(imageLion);
//                    d34.setIcon(imageLion);
//                    d35.setIcon(imageLion);
//                    d41.setIcon(imageLion);
//                    d42.setIcon(imageLion);
//                    d43.setIcon(imageLion);
//                    d44.setIcon(imageLion);
//                    d45.setIcon(imageLion);
//                    d51.setIcon(imageLion);
//                    d52.setIcon(imageLion);
//                    d53.setIcon(imageLion);
//                    d54.setIcon(imageLion);
//                    d55.setIcon(imageLion);
//   
//                }
//        return "Generic Defender";
//    }

    
    int buyDefender()
    {
        return 50;
    }
            
}
