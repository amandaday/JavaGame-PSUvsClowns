import java.awt.*;
import javax.swing.*;

public class myJPanel extends JPanel
{
	public myJPanel()
	{
		super();
		setBackground(Color.gray);
		
		setLayout(new GridLayout());

		//myJPanel1 p1 = new myJPanel1();
		//myJPanel2 p2 = new myJPanel2(p1);
                Welcome p1 = new Welcome();
                //StartGame p2 = new StartGame();
                //StoryLine p3 = new StoryLine();
                //HighScores p4 = new HighScores();
                //SetUp p5 = new SetUp();
                //Designers p6 = new Designers();
		
		add(p1);
		//add(p2);		
		
	}

}