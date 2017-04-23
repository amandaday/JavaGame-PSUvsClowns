import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StartGame extends JPanel implements ActionListener 
{
	
        JLabel jl2;
        JButton mainMenu, Go, clown, clown2, endGame;
        JPanel Welcome, SetUp, gameOver;
        JLabel LionCash, Score, difficulty, character, location;
        Defender[] def; //defender array
        clown[] cl; //clown array
        int[] horz; //grid x coordinates
        int[] vert; //grid y coordinates
        int[] clownPosx; //clown current position x coordinate
        int[] clownPosy; //clown current position y coordinate
        orb[] o; //orb array
        int[] orbPosx; //orb current position x
        int[] orbPosy; //orb current position y
        int orbCount;
        int lCash, scorePoints;
        Defender d1 = new Defender("x",200,200,false);
        JLabel message = new JLabel("Time: ");
	JButton start, stop;
        lane[] l;
	Timer tim;
	int limit = 0;
	int delay = 0;
	int i = 0;
        int oi = 0;
        int clownStart = 660;
        int o1,o2,o3;
        ImageIcon imageChosen;
        boolean test = true;
        int clownCount = 0;
        int moveSpeed = 10; //controls how fast the clown moves\
        int clownMax = 100;
        int delayTest = 1000;
        int cost1 = 50;
        int cost2 = 75;
        int cost3 = 100;
        int cost4 = 150;
        int cost5 = 150;
        
        myJPanel mjp;
        Graphics g;
        
	public StartGame(int so1, int so2, int so3)
	{
		super();
                o1 = so1;
                o2 = so2;
                o3 = so3;
                setLayout(null);
		setBackground(Color.yellow);

                if (o2 == 1)
                {
                    ImageIcon imageLion = new ImageIcon("images/nl22.jpg");
                    imageChosen = imageLion;
                }
                if (o2 == 2)
                {
                    ImageIcon imageJoey = new ImageIcon("images/jj2.png");
                    imageChosen = imageJoey;
                }
                if (o2 == 3)
                {
                    ImageIcon imageMajor = new ImageIcon("images/dm22.jpg");
                    imageChosen = imageMajor;
                }
              
                add(message);
                message.setBounds(400, 10, 200, 60);
                delay = delayTest; 
  		tim = new Timer(delay, this);
                
                orbCount = 0;
                lCash = 100;
                scorePoints = 0;

                LionCash = new JLabel("LionCash: $" + lCash);
                add(LionCash);
                LionCash.setBounds(140, 10, 200, 60);
                Score = new JLabel("Clowns: " + scorePoints);
                add(Score);
                Score.setBounds(280, 10, 200, 60);
                mainMenu = new JButton("Main Menu");
                mainMenu.addActionListener(this);
                add(mainMenu);
                mainMenu.setBounds(new Rectangle(520,10,100,60));
                
                endGame = new JButton("");
                endGame.setBounds(new Rectangle(0,0,30,480));
                add(endGame);
                endGame.setVisible(false);
                
                difficulty = new JLabel("Difficulty: " + o1);
                add(difficulty);
                difficulty.setBounds(220, 0, 200, 60);
                difficulty.setVisible(false);
                character = new JLabel("Character: " + o2);
                add(character);
                character.setBounds(310, 0, 200, 60);
                character.setVisible(false);
                location = new JLabel("Location: " + o3);
                add(location);
                location.setBounds(220, 20, 200, 60);
                location.setVisible(false);
                
                Go = new JButton("Click to begin");
                Go.addActionListener(this);
                add(Go);
                Go.setBounds(10,10,100,60);
                
                horz = new int[5]; //setting grid coodinates x
                horz[0] = 10;
                horz[1] = 80;
                horz[2] = 150;
                horz[3] = 220;
                horz[4] = 290;
                vert = new int[5]; //setting grid coordinates y
                vert[0] = 80;
                vert[1] = 150;
                vert[2] = 220;
                vert[3] = 290;
                vert[4] = 360;
                
                l = new lane[5];
                for (int k=0;k<5;k++){
                    l[k] = new lane();
                    l[k].setBounds(new Rectangle(0,vert[k],640,60));
                    add(l[k]);
                    l[k].setVisible(false);
                }
                
                def = new Defender[25]; //25 clowns
                cl = new clown[clownMax]; //up to 100 clowns currently
                o = new orb[1000]; //up to 1000 orbs currently, i haven't done the math, but we should be more than ennough if my theory is correct
                
                orbPosx = new int[1000]; //setting all orb default positions
                orbPosy = new int[1000];
                for (int k=0;k<1000;k++){
                    o[k] = new orb("");
                    orbPosx[k] = 550;
                    orbPosy[k] = 80;
                }
                
                clownPosx = new int[clownMax]; //setting all clown default posiitons
                clownPosy = new int[clownMax];
                for (int k=0;k<clownMax;k++){
                    cl[k] = new clown("");
                    ImageIcon imageTwisty = new ImageIcon("images/cl7.png");
                    cl[k].setIcon(imageTwisty);

                    clownPosx[k] = 660;
                    clownPosy[k] = 3000;
                }
                
                int q = 0;
                int w = 0;
                for (int k=0;k<25;k++){    //setting up all the defenders
                    def[k] = new Defender("",horz[q],vert[w],false);
                    def[k].addActionListener(this);
                    add(def[k]);
                    ImageIcon imageDirt1 = new ImageIcon("images/dirt1.jpg");
                    ImageIcon imageDirt2 = new ImageIcon("images/dirt2.jpg");
                    ImageIcon imageDirt3 = new ImageIcon("images/dirt3.jpg");
                    ImageIcon imageDirt4 = new ImageIcon("images/dirt4.jpg");
                    ImageIcon imageDirt5 = new ImageIcon("images/dirt5.jpg");
                    //def[k].setIcon(imageDirt);
                    if (q == 0)
                    {
                        def[k].setIcon(imageDirt5);
                    }
                    if (q == 1)
                    {
                        def[k].setIcon(imageDirt4);
                    }
                    if (q == 2)
                    {
                        def[k].setIcon(imageDirt3);
                    }
                    if (q == 3)
                    {
                        def[k].setIcon(imageDirt2);
                    }
                    if (q == 4)
                    {
                        def[k].setIcon(imageDirt1);
                    }
                    def[k].setBounds(def[k].posX,def[k].posY,60,60);
                    def[k].setEnabled(false);
                    q++;
                    if (q == 5){
                        q=0;
                    }
                    if ((k+1)%5 == 0){
                        w++;
                    }
                }
		}
		
        
        public void paintComponent(Graphics g) 
	{
            if (o3 == 1) 
                    {
                        super.paintComponent(g); 
                        Image myImage = Toolkit.getDefaultToolkit().getImage("images/lawn.jpg");
                        g.drawImage(myImage, 0, 0, this);
                    }
            if (o3 == 2)
                    {
                        super.paintComponent(g); 
                        Image myImage1 = Toolkit.getDefaultToolkit().getImage("images/street.png");
                        g.drawImage(myImage1, 0, 0, this);
                    }
            if (o3 == 3)
                    {
                        super.paintComponent(g);
                        Image myImage2 = Toolkit.getDefaultToolkit().getImage("images/field9.jpg");
                        g.drawImage(myImage2, 0, 0, this);
                    }
        }
       
                
        public void actionPerformed(ActionEvent event)
        {     
            Object obj = event.getSource();
            String choice = event.getActionCommand();
            if (obj == Go)
            {
                for (int k=0;k<25;k++){ //enabling all defenders
                    def[k].setEnabled(true);
                }
                
                if (tim.isRunning() == false)
                {
                   tim.start();
                   Go.setText("Pause");
                   for (int k=0;k<clownMax;k++){ //enables all clowns when unpaused
                   cl[k].setEnabled(true);
                   }
                }
                
                else if (tim.isRunning() == true)  
                {
                    tim.stop();
                    Go.setText("Resume");  
                    for (int k=0;k<25;k++){ //disables all defenders when paused
                    def[k].setEnabled(false);
                    }
                    
                    for (int k=0;k<clownMax;k++){ //disables all clowns when paused
                    cl[k].setEnabled(false);
                    }
                }
               
     
            }
            if (obj == tim)
		{
                    for (int k=0;k<clownMax;k++){ //moves all clowns every second by 10 pixels
                    clownPosx[k] = clownPosx[k]-moveSpeed;    
                    cl[k].setBounds(new Rectangle (clownPosx[k], clownPosy[k], 60,60)); //added "new rectangle ()"
                    }
                   
                   i = i+1;
                   message.setText("Time: "+i);
                   
                   
                   oi = i;
                   
		}
            
            if (o1 == 1) //if difficulty is easy
            {
                //moveSpeed = 10; //clown will move a little more slowly
              if (i == 0)
            {
                
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
            }  
              
             if (i == 35) //clowns will be progressively added at spacious increments
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
             if (i == 75)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
             if (i == 125)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
             if (i == 165)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
            }
            if (o1 == 2) //if difficulty is medium
            {
                if (i == 0)
            {
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
            }
              if (i == 25) //adding clowns in smaller increments
            {
                        
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;         
            }  
              
            if (i == 60)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
            if (i == 90)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
            if (i == 140)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
            
            if (i == 160)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
            }
            
            if (o1 == 3) //if difficulty is hard
            {
              if (i == 0)
            {
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
            }
              if (i == 15) //adding clowns relentlessly
            {
                        
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;  
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
            }  
              
            if (i == 30)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
            if (i == 40)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
            if (i == 50)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        
             }
            if (i == 60) {moveSpeed=moveSpeed*2;}
            if (i == 65)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
            if (i == 85)
             {
                 add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
                        add(cl[clownCount]);
                        clownPosx[clownCount] = 660;
                        clownPosy[clownCount] = cl[clownCount].spawnClown();
                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
                        clownCount++;
             }
//              if (i == 0) //old code
//            {
//                
//                        add(cl[clownCount]);
//                        clownPosx[clownCount] = 660;
//                        clownPosy[clownCount] = cl[clownCount].spawnClown();
//                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
//                        clownCount++;
//            }  
////              if (o[n].getBounds().intersects(cl[k].getBounds()))
////            {
////                
////                        add(cl[0]);
////                        clownPosx[0] = 660;
////                        clownPosy[0] = cl[0].spawnClown();
////                        cl[0].setBounds(new Rectangle(660, clownPosy[0], 60, 60));
////                        
////            } 
//            }
//            if (o1 == 2) //if difficulty is medium
//            {
//              if (i == 0)
//            {
//                        add(cl[clownCount]);
//                        clownPosx[clownCount] = 660;
//                        clownPosy[clownCount] = cl[clownCount].spawnClown();
//                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
//                        clownCount++;
//                        
//                        add(cl[clownCount]);
//                        clownPosx[clownCount] = 660;
//                        clownPosy[clownCount] = cl[clownCount].spawnClown();
//                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
//                        clownCount++;
//                        
//   
//                        
//            }  
//            }
//            if (o1 == 3) //if difficulty is hard
//            {
//              if (i == 0)
//            {
//                        add(cl[clownCount]);
//                        clownPosx[clownCount] = 660;
//                        clownPosy[clownCount] = cl[clownCount].spawnClown();
//                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
//                        clownCount++;
//                        
//                        add(cl[clownCount]);
//                        clownPosx[clownCount] = 660;
//                        clownPosy[clownCount] = cl[clownCount].spawnClown();
//                        cl[clownCount].setBounds(new Rectangle(660, clownPosy[clownCount], 60, 60));
//                        clownCount++;
//            }  
            }
            if (obj == mainMenu) 
            {
               tim.stop();
               removeAll();
               setLayout(new GridLayout(1,1));
               Welcome = new Welcome();
               add(Welcome);
               validate();
               repaint();
            }


            if (obj == def[0])
             { 
                 if (def[0].activated == false)
                 {
            if (lCash >= cost5) //changed from 0 to 25 so user cannot buy a defender with $25 LionCash
                { 
                    def[0].activated = true;
                    def[0].setIcon(imageChosen);
                    lCash = lCash - cost5;
                    LionCash.setText("LionCash: $" + lCash);
                }

                }
             }
            
            if (obj == def[1])
             {  
                 if (def[1].activated == false)
                 {
            if (lCash >= cost4)

                {  
                def[1].activated = true;
                def[1].setIcon(imageChosen);
                lCash = lCash - cost4;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[2])
             {  
                 if (def[2].activated == false)
                 {
            if (lCash >= cost3)
                {
                def[2].activated = true;
                def[2].setIcon(imageChosen);
                lCash = lCash - cost3;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[3])
             {  
                 if (def[3].activated == false)
                 {
            if (lCash >= cost2)
                {  
                def[3].activated = true;
                def[3].setIcon(imageChosen);
                lCash = lCash - cost2;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[4])
             {  
                 if (def[4].activated == false)
                 {
            if (lCash >= cost1)
                {  
                def[4].activated = true;
                def[4].setIcon(imageChosen);
                lCash = lCash - cost1;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[5])
             {  
                 if (def[5].activated == false)
                 {
            if (lCash >= cost5)
                {  
                def[5].activated = true;
                def[5].setIcon(imageChosen);
                lCash = lCash - cost5;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[6])
             {  
                 if (def[6].activated == false)
                 {
            if (lCash >= cost4)
                {  
                def[6].activated = true;
                def[6].setIcon(imageChosen);
                lCash = lCash - cost4;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[7])
             {  
                 if (def[7].activated == false)
                 {
            if (lCash >= cost3)
                {  
                def[7].activated = true;
                def[7].setIcon(imageChosen);
                lCash = lCash - cost3;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[8])
             {  
                 if (def[8].activated == false)
                 {
            if (lCash >= cost2)
                {  
                def[8].activated = true;
                def[8].setIcon(imageChosen);
                lCash = lCash - cost2;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[9])
             {  
                 if (def[9].activated == false)
                 {
            if (lCash >= cost1)
                {  
                def[9].activated = true;
                def[9].setIcon(imageChosen);
                lCash = lCash - cost1;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[10])
             {  
                 if (def[10].activated == false)
                 {
            if (lCash >= cost5)
                {  
                def[10].activated = true;
                def[10].setIcon(imageChosen);
                lCash = lCash - cost5;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[11])
             {  
                 if (def[11].activated == false)
                 {
            if (lCash >= cost4)
                {  
                def[11].activated = true;
                def[11].setIcon(imageChosen);
                lCash = lCash - cost4;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[12])
             {  
                 if (def[12].activated == false)
                 {
            if (lCash >= cost3)
                {  
                def[12].activated = true;
                def[12].setIcon(imageChosen);
                lCash = lCash - cost3;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[13])
             {  
                 if (def[13].activated == false)
                 {
            if (lCash >= cost2)
                {  
                def[13].activated = true;
                def[13].setIcon(imageChosen);
                lCash = lCash - cost2;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[14])
             { 
                 if (def[14].activated == false)
                 {
            if (lCash >= cost1)
                {  
                def[14].activated = true;
                def[14].setIcon(imageChosen);
                lCash = lCash - cost1;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[15])
             {   
                 if (def[15].activated == false)
                 {
            if (lCash >= cost5)
                {  
                def[15].activated = true;
                def[15].setIcon(imageChosen);
                lCash = lCash - cost5;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[16])
             {  
                 if (def[16].activated == false)
                 {
            if (lCash >= cost4)
                {  
                def[16].activated = true;
                def[16].setIcon(imageChosen);
                lCash = lCash - cost4;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[17])
             {  
                 if (def[17].activated == false)
                 {
            if (lCash >= cost3)
                {  
                def[17].activated = true;
                def[17].setIcon(imageChosen);
                lCash = lCash - cost3;
                LionCash.setText("LionCash: $" + lCash);
                }
              }
             }
            if (obj == def[18])
             {  
                 if (def[18].activated == false)
                 {
            if (lCash >= cost2)
                {  
                def[18].activated = true;
                def[18].setIcon(imageChosen);
                lCash = lCash - cost2;
                LionCash.setText("LionCash: $" + lCash);
                }
              }
             }
            if (obj == def[19])
             { 
                 if (def[19].activated == false)
                 {
            if (lCash >= cost1)
                {  
                def[19].activated = true;    
                def[19].setIcon(imageChosen);
                lCash = lCash - cost1;
                LionCash.setText("LionCash: $" + lCash);
                }
              }
             }
            if (obj == def[20])
             {  
                 if (def[20].activated == false)
                 {
            if (lCash >= cost5)
                {  
                def[20].activated = true;
                def[20].setIcon(imageChosen);
                lCash = lCash - cost5;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[21])
             { 
                 if (def[21].activated == false)
                 {
            if (lCash >= cost4)
                {  
                def[21].activated = true;
                def[21].setIcon(imageChosen);
                lCash = lCash - cost4;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[22])
             { 
                 if (def[22].activated == false)
                 {
            if (lCash >= cost3)
                {  
                def[22].activated = true;    
                def[22].setIcon(imageChosen);
                lCash = lCash - cost3;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[23])
             {  
                 if (def[23].activated == false)
                 {
            if (lCash >= cost2)
                {  
                def[23].activated = true;
                def[23].setIcon(imageChosen);
                lCash = lCash - cost2;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == def[24])
             {  
                 if (def[24].activated == false)
                 {
            if (lCash >= cost1)
                {  
                def[24].activated = true;    
                def[24].setIcon(imageChosen);
                lCash = lCash - cost1;
                LionCash.setText("LionCash: $" + lCash);
                }
               }
             }
            if (obj == tim)
            {
                for (int k=0;k<5;k++)
                {
                    for (int j=0;j<clownMax;j++)
                    {
                        if (l[k].getBounds().intersects(cl[j].getBounds()))
                        {
                            for(int n=0;n<5;n++)
                            {
                                int u=((k+1)*5)-(n+1);
                                if (def[u].activated==true)
                                {
                                    if (orbCount == 1000){orbCount = 0;} //keeps track of each new orb
                                    o[orbCount] = new orb("");
                                    o[orbCount].setBounds(o[orbCount].spawnOrbx(def[u].posX+25),o[orbCount].spawnOrby(def[u].posY+25),10,10);
                                    //System.out.println("xy="+o[j].spawnOrbx(def[j].posX+25)+"-"+o[j].spawnOrby(def[j].posY+25));
                                    //o[orbCoun8t].setBounds(o[j].spawnOrbx(def[j].posX+25),300,10,10);
                                    ImageIcon imageOrb = new ImageIcon("images/football.jpg");
                                    o[orbCount].setIcon(imageOrb);

                                    if (i%2==0)
                                    {
                                    o[orbCount].setEnabled(true);
                                    add(o[orbCount]);
                                    orbCount++;//increments through each orb
                                    }
                                }
                            }
                        }
                    }
                }
                                
                
                if (i==90){moveSpeed=moveSpeed*2;}
                if (i==200){moveSpeed=moveSpeed*2;}
                       for (int n=0;n<1000;n++)
                           {
                               o[n].setBounds(o[n].moveOrb(), o[n].orbPosy, 10, 10);
                              //System.out.println("XY="+o[n].moveOrb()+" "+ o[n].orbPosy); //removing this statement is DANGEROUS for some reason.
                        for (int k=0;k<clownMax;k++){ //moves all clowns every second by 30 pixels
                    //clownPosx[k] = clownPosx[k]-10;    
                   // cl[k].setBounds(new Rectangle (clownPosx[k], clownPosy[k], 60,60)); //added "new rectangle ()"
                   // }                               
                               if (o[n].getBounds().intersects(cl[k].getBounds())) //if the orb hits the clown
                                {
                                    LionCash.setText("LionCash: $" + lCash);
                                    
                                    //clownPosy[k] = 3000;
                                    //cl[k].setBounds(new Rectangle(3000, clownPosy[k], 60, 60));
                                    cl[k].clownDamage();
                                    o[n].setBounds(new Rectangle(o[n].spawnOrbx(4000),orbPosy[n],10,10));
                                    
                                    //stop defender throwing orbs? 
                                    //def[j].activated==false? how can they be reactivated when new clown comes down the lane
                                    
                                    if (cl[k].clownHP <= 0)
                                    {
                                        lCash = lCash + 25; //earns $25 for defeating clown
                                        LionCash.setText("LionCash: $" + lCash);
                                        clownPosy[k] = 3000;
                                        cl[k].setBounds(new Rectangle(3000, clownPosy[k], 60, 60));
                                        
                                        if (clownCount == clownMax)
                                        {
                                            clownCount = 0;
                                        }
                                        //replaced clownCount with k
                                        add(cl[k]);
                                        clownPosx[k] = 660;
                                        clownPosy[k] = cl[k].spawnClown();
                                        cl[k].setBounds(new Rectangle(660, clownPosy[k], 60, 60)); 
                                        k++;
                                        scorePoints = scorePoints + 1; //add one point to score count when clown is defeated
                                        Score.setText("Clowns: " + scorePoints);
                                    }
                                }
                               for (int j=0;j<25;j++)
                               {
                               if (def[j].getBounds().intersects(cl[k].getBounds()))
                               {
                                   def[j].setVisible(false);
                                   //def[j].activated = false;
                                   def[j] = new Defender("",3000,220,false);
                                   def[j].setBounds(def[j].posX,def[j].posY,60,60);
                                   remove(def[j]);
                               }
                               }
                           }
                       }    
                       for (int k=0;k<clownMax;k++)
                {
                   if (cl[k].getBounds().intersects(endGame.getBounds()))
                   {
                       tim.stop();
                       removeAll();
                        setLayout(new GridLayout(1,1));
                        gameOver = new gameOver(o1,scorePoints);
                        add(gameOver);
                        validate();
                        repaint();
                        break;
                   }
                }
            }
        }
}