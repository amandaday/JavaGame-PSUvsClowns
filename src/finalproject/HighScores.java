import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HighScores extends JPanel implements ActionListener
{
        XML_240 x2;
	JLabel jl4;
        JButton mainMenu;
        JButton nameB, diffB, scoreB;
        JButton b1stn,b1std,b1sts,b2ndn,b2ndd,b2nds,b3rdn,b3rdd,b3rds;
        JPanel Welcome;
        Graphics g;
        gameOver p1;
        SetUp p2;
        TextField tf1;
        String name1,name2,name3;
        String diff1,diff2,diff3;
        int score1,score2,score3;
        
	public HighScores()
	{
		super();
		setLayout(null);
                setBackground(Color.yellow);
		jl4 = new JLabel("High scores");
                jl4.setBounds(270,10,100,20);
		add(jl4);
                
                x2 = new XML_240();
                
		String s1 = ""; 
                String s2 = "";
                int num = 0;
                x2.openReaderXML("XML_test.xml");
                name1 = (String)x2.ReadObject();
                diff1 = (String)x2.ReadObject();
                score1 = (Integer)x2.ReadObject();
                name2 = (String)x2.ReadObject();
                diff2 = (String)x2.ReadObject();
                score2 = (Integer)x2.ReadObject();
                name3 = (String)x2.ReadObject();
                diff3 = (String)x2.ReadObject();
                score3 = (Integer)x2.ReadObject();
                x2.closeReaderXML(); 
                
                //open an xml file, read 3 lines in the file, then close it
                //it is reading the XML file
                
                nameB = new JButton("Name:");
                nameB.setBounds(20,30,200,60);
                add(nameB);
                diffB = new JButton("Difficulty:");
                diffB.setBounds(230,30,150,60);
                add(diffB);
                scoreB = new JButton("Clowns Defeated:");
                scoreB.setBounds(390,30,200,60);
                add(scoreB);
                
                b1stn = new JButton(name1);
                b1stn.setBounds(20,100,200,60);
                add(b1stn);
                b1std = new JButton(diff1);
                b1std.setBounds(230,100,150,60);
                add(b1std);
                b1sts = new JButton(""+score1);
                b1sts.setBounds(390,100,200,60);
                add(b1sts);
                
                b2ndn = new JButton(name2);
                b2ndn.setBounds(20,170,200,60);
                add(b2ndn);
                b2ndd = new JButton(diff2);
                b2ndd.setBounds(230,170,150,60);
                add(b2ndd);
                b2nds = new JButton(""+score2);
                b2nds.setBounds(390,170,200,60);
                add(b2nds);
                
                b3rdn = new JButton(name3);
                b3rdn.setBounds(20,240,200,60);
                add(b3rdn);
                b3rdd = new JButton(diff3);
                b3rdd.setBounds(230,240,150,60);
                add(b3rdd);
                b3rds = new JButton(""+score3);
                b3rds.setBounds(390,240,200,60);
                add(b3rds);
                
                mainMenu = new JButton("Main Menu");
                mainMenu.addActionListener(this);
                mainMenu.setBounds(500,350,100,60);
                add(mainMenu);
		}
        
        public void paintComponent(Graphics g) 
	{
                        super.paintComponent(g); 
                        Image myImage = Toolkit.getDefaultToolkit().getImage("images/nittanylion1.jpg");
                        g.drawImage(myImage, 0, 0, this);
        }
        
        public void actionPerformed(ActionEvent event)
        {     
            Object obj = event.getSource();
            if (obj == mainMenu) 
            {
               removeAll();
               setLayout(new GridLayout(1,1));
               Welcome = new Welcome();
               add(Welcome);
               validate();
               repaint();
            }
            
        }
		
}
