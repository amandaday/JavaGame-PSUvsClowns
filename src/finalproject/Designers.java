import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Designers extends JPanel implements ActionListener
{
	JLabel jl3, jl4, jl5, jl6;
        JButton mainMenu, b1, b2;
        JPanel Welcome;
        
	public Designers()
	{
		super();
                setLayout(null);
		setBackground(Color.white);
                jl3 = new JLabel("Designed by Amanda Day and Mitch Galarneau");
                jl3.setBounds(15,75,300,100);
		add(jl3);
                
                jl4 = new JLabel("Music by Amanda Day");
                jl4.setBounds(410,300,300,100);
		add(jl4);
                
                ImageIcon imageDesigner1 = new ImageIcon("images/designers.jpg");
                jl5 = new JLabel("Image 1");
                jl5.setBounds(320,0,320,240);
		add(jl5);
                jl5.setIcon(imageDesigner1);
                ImageIcon imageDesigner2 = new ImageIcon("images/designers2.jpg");
                jl6 = new JLabel("Image 2");
                jl6.setBounds(0,240,320,240);
                add(jl6);
                jl6.setIcon(imageDesigner2);
                mainMenu = new JButton("Main Menu");
                mainMenu.addActionListener(this);
                mainMenu.setBounds(500,390,100,60);
                add(mainMenu);
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
