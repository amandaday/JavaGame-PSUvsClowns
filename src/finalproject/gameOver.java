import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class gameOver extends JPanel implements ActionListener
{
    XML_240 x2;
    JLabel jl1, jl22;
    JButton jb1;
    TextField tf1;
    JPanel HighScores;
    
    HighScores p1;
    String name,difficulty;
    int diff;
    int score;
    String name1,name2,name3;
    String diff1,diff2,diff3;
    int score1,score2,score3;
    Graphics g;
    
    public gameOver(int o1, int highScore)
            {
                super();
                setLayout(null);
                setBackground(Color.black);
                diff  = o1;
                score = highScore;
                if (diff == 1)
                {
                    difficulty = "Easy";
                }
                if (diff == 2)
                {
                    difficulty = "Medium";
                }
                if (diff == 3)
                {
                    difficulty = "Hard";
                }
                
                x2 = new XML_240();
                
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
                
                jl22 = new JLabel("Game over");
                jl22.setBounds(200,50,260,185);
                add(jl22);
                
                ImageIcon imageEnd = new ImageIcon("images/gameover.png");
                jl22.setIcon(imageEnd);


                tf1 = new TextField("");
                tf1.setBounds(230,270,200,50);
                tf1.addActionListener(this);
                add(tf1);
                
                jb1 = new JButton("Continue");
                jb1.setBounds(500, 390, 100, 50);
                jb1.addActionListener(this);
                add(jb1);
                
                x2 = new XML_240();
                //open an xml file, write 3 lines in the file, close it
                //open the xml file outside Netbeans and check the contents
            }
    
    public void paintComponent(Graphics g) 
{
   super.paintComponent(g);
   g.setColor(Color.white);
   g.drawString("Enter your name:", 275,250);
}

    public void actionPerformed(ActionEvent event)
        {     
            Object obj = event.getSource();
            if (obj == jb1) 
            {
               if (score > score1)
               {
                    name = tf1.getText();
                    x2.openWriterXML("XML_test.xml");
                    x2.writeObject(name);
                    x2.writeObject(difficulty);
                    x2.writeObject(score);
                    x2.writeObject(name1);
                    x2.writeObject(diff1);
                    x2.writeObject(score1);
                    x2.writeObject(name2);
                    x2.writeObject(diff2);
                    x2.writeObject(score2);
                    x2.closeWriterXML(); 
               } 
               else if (score > score2)
               {
                   name = tf1.getText();
                    x2.openWriterXML("XML_test.xml");
                    x2.writeObject(name1);
                    x2.writeObject(diff1);
                    x2.writeObject(score1);
                    x2.writeObject(name);
                    x2.writeObject(difficulty);
                    x2.writeObject(score);
                    x2.writeObject(name2);
                    x2.writeObject(diff2);
                    x2.writeObject(score2);
                    x2.closeWriterXML(); 
               }
               else if (score > score3)
               {
                   name = tf1.getText();
                    x2.openWriterXML("XML_test.xml");
                    x2.writeObject(name1);
                    x2.writeObject(diff1);
                    x2.writeObject(score1);
                    x2.writeObject(name2);
                    x2.writeObject(diff2);
                    x2.writeObject(score2);
                    x2.writeObject(name);
                    x2.writeObject(difficulty);
                    x2.writeObject(score);
                    x2.closeWriterXML(); 
               }
                
                
               removeAll();
               setLayout(new GridLayout(1,1));
               HighScores = new HighScores();
               add(HighScores);
               validate();
               repaint();
            }
            
        } 
}
