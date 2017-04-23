import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class Welcome extends JPanel implements ActionListener
{
    JButton b1, b2, b3, b4, b5, loop, stop, play;
    JPanel StartGame, Designers, HighScores, StoryLine, SetUp;
	java.applet.AudioClip clip;
    //HighScores p1;
    Graphics g;
    
	public Welcome()//HighScores JPanel)
	{
		super();
                setLayout(null);
                //p1 = JPanel;
                
                b1 = new JButton("Start Game");
                b1.addActionListener(this);
                b1.setBounds(15, 380, 120, 50);
                add(b1);
                b2 = new JButton("Designers"); 
                b2.addActionListener(this);
                b2.setBounds(375, 380, 120, 50);
                add(b2);
                b3 = new JButton("High Scores");
                b3.addActionListener(this);
                b3.setBounds(255, 380, 120, 50);
                add(b3);
                b4 = new JButton("Instructions");
                b4.addActionListener(this);
                b4.setBounds(135, 380, 120, 50);
                add(b4);

                
		 	try
		 	{
				clip = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/clowns4.aif"));
		 	}
          catch(Exception xx) {xx.printStackTrace();}		 	
		loop = new JButton("Play Music"); //loops music when clicked
                stop = new JButton("Stop Music"); //stops music when clicked; trying to put these on the same button if possible
		loop.addActionListener(this);
                stop.addActionListener(this);
                loop.setBounds(495, 380, 120, 50);
                stop.setBounds(495, 380, 120, 50);
                add(loop);
		add(stop);
                stop.setVisible(false);
	}
	
        public void paintComponent(Graphics g) 
	{
                        super.paintComponent(g); 
                        Image myImage = Toolkit.getDefaultToolkit().getImage("images/bg1.jpg");
                        g.drawImage(myImage, 0, 0, this);
        }
        
    public void actionPerformed(ActionEvent event)
        {     
            Object obj = event.getSource();
            if (obj == b1) 
            {
               removeAll();
               setLayout(new GridLayout(1,1));
               SetUp = new SetUp();
               add(SetUp);
               validate();
               repaint();
            }
            if (obj == b2) 
            {
               removeAll();
               setLayout(new GridLayout(1,1));
               Designers = new Designers();
               add(Designers);
               validate();
               repaint();
            }
            if (obj == b3) 
            {
               removeAll();
               setLayout(new GridLayout(1,1));
               HighScores = new HighScores();
               add(HighScores);
               validate();
               repaint();
            }
            if (obj == b4) 
            {
               removeAll();
               setLayout(new GridLayout(1,1));
               StoryLine = new StoryLine();
               add(StoryLine);
               validate();
               repaint();
            }
            
//            if (obj == p1.mainMenu)
//            {
//                loop.setVisible(false);
//                stop.setVisible(false);
//            }

            if (obj == loop)
		 {
                     
                     loop.setVisible(false);
                     stop.setVisible(true);
                     //loop.setText("Stop music");
		 	try
		 	{
		 		clip.loop(); //play looped music
		 	}
          catch(Exception xx) {xx.printStackTrace();}		 	
		 	
		 }
            
		 else if (obj == stop)
		 {
                     stop.setVisible(false);
                     loop.setVisible(true);
                     //loop.setText("Play music");
		 	try
		 	{
		 	clip.stop();//stop music
		 	}

          catch(Exception xx) {xx.printStackTrace();}		 	
		 }
        } 
}

