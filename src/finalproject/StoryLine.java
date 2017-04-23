import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StoryLine extends JPanel implements ActionListener 
{
	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11, jl12;
        JButton mainMenu, jb1;
        JPanel Welcome;
        Graphics g;
        
	public StoryLine()
	{
		super();
                setLayout(null);
		setBackground(Color.white); 
                
                
                jl1 = new JLabel("Clowns have come to Penn State!");
                add(jl1);
                jl1.setBounds(220,165,280,20);
                
                jl2 = new JLabel("Choose a defender to protect the campus.");
                add(jl2);
                jl2.setBounds(190,185,280,20);
                
                jl3 = new JLabel("You will begin with $100 LionCash.");
                add(jl3);
                jl3.setBounds(205,205,280,20);
                
                jl4 = new JLabel("When a clown appears, click a plot to add");
                add(jl4);
                jl4.setBounds(195,225,280,20);
                
                jl5 = new JLabel("a defender for its corresponding cost.");
                add(jl5);
                jl5.setBounds(205,245,280,20);
                
                jl6 = new JLabel("Your defender will throw footballs");
                add(jl6);
                jl6.setBounds(215,265,280,20);
                
                jl11 = new JLabel("at the clown to defeat him.");
                add(jl11);
                jl11.setBounds(235,285,280,20);
                
                jl7 = new JLabel("When you defeat a clown,");
                add(jl7);
                jl7.setBounds(240,305,280,20);
                
                jl12 = new JLabel("you will receive $25 LionCash.");
                add(jl12);
                jl12.setBounds(225,325,280,20);
                
                jl8 = new JLabel("If a clown reaches the end of your screen,");
                add(jl8);
                jl8.setBounds(195,345,280,20);
                
                jl9 = new JLabel("the game is over!");
                add(jl9);
                jl9.setBounds(265,365,280,20);
                
                jl10 = new JLabel("Defeat as many clowns as you can.");
                add(jl10);
                jl10.setBounds(215,385,280,20);
                                                                      
                
                mainMenu = new JButton("Main Menu");
                mainMenu.addActionListener(this);
                add(mainMenu);
                mainMenu.setBounds(500, 390, 100, 50);
		}
        
        public void paintComponent(Graphics g) 
	{
                        super.paintComponent(g); 
                        Image myImage = Toolkit.getDefaultToolkit().getImage("images/bg2.png");
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
