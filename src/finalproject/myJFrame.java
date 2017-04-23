import java.awt.*;
import javax.swing.*;

public class myJFrame extends JFrame
{
	public myJFrame ()
	{
		super ("Sonification Program");
		
  	 	myJPanel mjp = new myJPanel();
    
		getContentPane().add(mjp,"Center");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (640, 480);
		setVisible(true);
	}

}

