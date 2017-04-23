import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SetUp extends JPanel implements ActionListener  
{
	JLabel jl6, jl61, jl62, jl63, jl64;
        JButton mainMenu,easy,medium,hard,ch1,ch2,ch3,l1,l2,l3,play;
        JPanel Welcome, StartGame;
        myJPanel mjp;
        Graphics g;
        int o1 = 0;
        int o2 = 0;
        int o3 = 0;
        Welcome p1;
        
	public SetUp()
	{
		super();
                setLayout(new GridLayout(4,4));
		setBackground(Color.yellow);
		jl6 = new JLabel("Ready? ");
                jl61 = new JLabel("Difficulty: ");
                jl62 = new JLabel ("Defender: ");
                jl63 = new JLabel("Location: ");
                jl64 = new JLabel();
                mainMenu = new JButton("Main Menu");
                mainMenu.addActionListener(this);
                easy = new JButton("Easy");
                easy.addActionListener(this);
                medium = new JButton("Medium");
                medium.addActionListener(this);
                hard = new JButton("Hard");
                hard.addActionListener(this);
                
                ImageIcon imageLion = new ImageIcon("images/nl11.jpg");
                ch1 = new JButton("Nittany Lion");
                ch1.addActionListener(this);
                ch1.setIcon(imageLion);
                
                ImageIcon imageJoey = new ImageIcon("images/jj1.png");
                ch2 = new JButton("Joey Julius ");
                ch2.addActionListener(this);
                ch2.setIcon(imageJoey);
                
                ImageIcon imageMajor = new ImageIcon("images/dm2.jpg");
                ch3 = new JButton("Drum Major ");
                ch3.addActionListener(this);
                ch3.setIcon(imageMajor);
                
                
                ImageIcon imageLawn2 = new ImageIcon("images/oldmain.jpg");
                l1 = new JButton("Old Main");
                l1.addActionListener(this);
                l1.setIcon(imageLawn2);
                
                
                ImageIcon imageStreet2 = new ImageIcon("images/collegeave2.jpg");
                l2 = new JButton("College Ave");
                l2.addActionListener(this);
                l2.setIcon(imageStreet2);
                
                
                ImageIcon imageField2 = new ImageIcon("images/beaverstadium2.jpg");
                l3 = new JButton("Beaver Stadium");
                l3.addActionListener(this);
                l3.setIcon(imageField2);
                
                play = new JButton("Play!");
                play.addActionListener(this);
                play.setEnabled(false);
                add(jl61);
                add(easy);
                add(medium);
                add(hard);
                add(jl62);
                add(ch1);
                add(ch2);
                add(ch3);
                add(jl63);
                add(l1);
                add(l2);
                add(l3);
                add(jl6);
                add(mainMenu);
                add(jl64);
                add(play);
		}
        
        public void actionPerformed(ActionEvent event)
        {     
            Object obj = event.getSource();
            if (obj == easy)
            {
                o1 = 1;
                jl61.setText("Difficulty: Easy");
            }
            if (obj == medium)
            {
                o1 = 2;
                jl61.setText("Difficulty: Medium");
            }
            if (obj == hard)
            {
                o1 = 3;
                jl61.setText("Difficulty: Hard");
            }
            if (obj == ch1)
            {
                o2 = 1;
                jl62.setText("Defender: Nittany Lion");
            }
            if (obj == ch2)
            {
                o2 = 2;
                jl62.setText("Defender: Joey Julius");
            }
            if (obj == ch3)
            {
                o2 = 3;
                jl62.setText("Defender: Drum Major");
            }
            if (obj == l1)
            {
                o3 = 1;
                jl63.setText("Location: Old Main");
            }
            
            if (obj == l2)
            {
                o3 = 2;
                jl63.setText("Location: College Ave");
            }
            if (obj == l3)
            {
                o3 = 3;
                jl63.setText("Location: Beaver Stadium");
                
                
            }
            if (obj == mainMenu) 
            {
               removeAll();
               setLayout(new GridLayout(1,1));
               Welcome = new Welcome();
               add(Welcome);
               validate();
               repaint();
            }
            
            
            if (o1 > 0 && o2 > 0 && o3>0)
            {
                play.setEnabled(true);
            } //user can continue only if three values are selected
            
            if (obj == play) 
            {
               removeAll();
               setLayout(new GridLayout(1,1));
               StartGame = new StartGame(o1,o2,o3);
               add(StartGame);
               validate();
               repaint();
            }
        }
		
}


