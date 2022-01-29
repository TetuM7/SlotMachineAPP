
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import java.lang.System;



import javax.imageio.ImageIO;
import java.lang.ClassNotFoundException;
import java.util.Random;
import java.awt.geom.Line2D;
import java.lang.Thread;

public class SlotAPP implements ActionListener{

	JLayeredPane BackPanel;
	Border frameborder;
	JLabel titlelabel;
	JLabel CoinLabel;
	JLabel Dice,Dice2, p1l,p2l, p3l;
	JLabel p4l,p5l;
	JLabel awardlble;

	JPanel panel1,panel2, panel3,panel4, panel5;
	 JPanel award,superiorpanel;
	
	GridLayout Layout, l2,l3;
	JButton slotbutton;
	JButton Reset;
	JPanel holdbuttons,host,spinsnum,blnce,earned;
	JLabel numofspins,balance,amountwon;
	Border b1,b2,b3,b4;
	String v1,v2,v3,v4,v5;
SlotPane work;
   int payout=0;
boolean started =false;
boolean spin= true;

//runbutton buttons;
Dimension screenSize;
Timer timer;
BetterSlot s2;
int [] values;


    public SlotAPP() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	screenSize = new Dimension(800, 600);


            	work=new SlotPane();
            	//buttons= new runbutton();
            	
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
               frame.setSize(800,500);
               frame.setResizable(true);
               frame.setBackground(Color.BLACK);
              
               frame.setPreferredSize(screenSize);
               frame.setMinimumSize(screenSize);
               frame.setBackground(Color.BLACK);
               frame.setMaximumSize(screenSize);
       		//frame.setResizable(false);

                frame.pack();
                frame.setLocationRelativeTo(null);
                BackPanel= new JLayeredPane();
                BackPanel.setSize(800,500);
        		BackPanel.setBounds(0,0,frame.getWidth(),472);
                BackPanel.setBackground(Color.BLACK);
        		BackPanel.setOpaque(true);
        		
        		BackPanel.add(work);
        		award = new JPanel();
        		award.setBackground(Color.WHITE);
        		award.setBorder(BorderFactory.createLineBorder(new Color(255,204,51), 5, true));
        		award.setBounds(200, 265, 460, 45);
        		awardlble= new JLabel();
        		awardlble.setText("Congrats  ");
        		awardlble.setFont(new Font("BOLD", Font.BOLD,20));
        		awardlble.setForeground(Color.GREEN);
        		award.add(awardlble);
        		BackPanel.setBorder(BorderFactory.createLineBorder(new Color(251,204,0), 9, true));
        		BackPanel.add(award);
        		host= new JPanel();
        		host.setBounds(235,340,350,80);
        		host.setLayout(l3);
        		host.setOpaque(false);
        		
        		b3 = BorderFactory.createLineBorder(new Color(255,204,51),3);
        		b4 = BorderFactory.createLineBorder(Color.BLACK,7);

        		spinsnum= new JPanel();
        		spinsnum.setBackground(new Color(255,204,51));
        		spinsnum.setOpaque(true);
        		spinsnum.setBorder(BorderFactory.createCompoundBorder(b3, b4));
        		numofspins= new JLabel();
        		numofspins.setForeground(Color.GREEN);
        		numofspins.setText("$");
        		numofspins.setFont(new Font("BOLD", Font.BOLD,45));
        		spinsnum.add(numofspins,BorderLayout.CENTER);
        		
        		blnce = new JPanel();
        		blnce.setBackground(new Color(255,204,51));
        		blnce.setOpaque(true);
        		blnce.setBorder(BorderFactory.createCompoundBorder(b3, b4));
        		balance= new JLabel();
        		balance.setText("$");
        		balance.setForeground(Color.GREEN);
        		balance.setFont(new Font("BOLD", Font.BOLD,45));
        		blnce.add(balance,BorderLayout.CENTER);

        		earned = new JPanel();
        		earned.setBackground(new Color(255,204,51));
        		earned.setOpaque(true);
        		earned.setBorder(BorderFactory.createCompoundBorder(b3, b4));
        		amountwon= new JLabel();
        		amountwon.setText("$");
        		amountwon.setForeground(Color.GREEN);
        		amountwon.setFont(new Font("BOLD", Font.BOLD,45));
        		earned.add(amountwon,BorderLayout.CENTER);
        		
        		host.add(spinsnum);
        		host.add(blnce);
        		host.add(earned);

        		
        		BackPanel.add(host);

            	b1= BorderFactory.createBevelBorder(10);
        		b2= BorderFactory.createBevelBorder(10);

        		slotbutton = new JButton();
        		slotbutton.addActionListener (new ActionListener() {

        		    @Override
        		    public void actionPerformed(ActionEvent e) {        
        		    	
        		    		if(started==false) {
        		    		started=true;
        		    		s2= new BetterSlot();
        		    		timer.start();
        		    		values= s2.pullTheLever();
        					s2.payOff(values);
        					awardlble.setText("Congrats  you won :"+payout+"$$");
        		    		}
        		    		else {
        		    		started=false;
        		    		timer.stop();
        		    		
        		    		
        		    		
        				 
        				 
        		    	
        		    		}}
        		    });
        		
        		slotbutton.setText("Spin");
        		slotbutton.setBorder(BorderFactory.createCompoundBorder(b1, b2));
        		slotbutton.setFont(new java.awt.Font("Cambria", 6, 30));
        		slotbutton.setBounds(45,455,340,70);
        		slotbutton.setBackground(new Color(255,204,51));
        		slotbutton.setOpaque(true);
        		
        		
        		
        		
        		Reset = new JButton();
        		Reset.addActionListener (new ActionListener() {

        		    @Override
        		    public void actionPerformed(ActionEvent e) {        
        		    	System.out.println("l");
        		    } 
        		    });
        		Reset.setText("RESET");
        		Reset.setFont(new Font("Italic", Font.ITALIC,25));
        		Reset.setForeground(Color.RED);
        		Reset.setBorder(BorderFactory.createBevelBorder(3));
        		Reset.setBounds(430,455,320,70);

        		Reset.setBackground(new Color(255,204,51));
        		Reset.setOpaque(true);
        		
        		slotbutton.setText("Spin");
        		

        		BackPanel.add(slotbutton);
        		BackPanel.add(Reset);
        		
        		
        		frame.add(BackPanel);
        		frame.setVisible(true);
        		
        		//BackPanel.add(titlelabel);

            }
        });}
        
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
            
    
    public class SlotPane extends JPanel {

        private BufferedImage p1;
        private BufferedImage p2;
        private BufferedImage p3;
        private BufferedImage p4;
        private BufferedImage p5;
        private BufferedImage p6;
        private BufferedImage frame;
        private BufferedImage photo;
        private BufferedImage photo2;
        private boolean opened = true;
        int slotnum;
        int Yvelocity=15;
        int y = 17;

        public SlotPane() {
        	Layout= new GridLayout(1,5);
    		Layout.setHgap(30);
    		l2= new GridLayout(1,5);
    		l2.setHgap(20);
    		l3= new GridLayout(1,5);
    		l3.setHgap(58);
    		

    		setBounds(28,15,750,200);
    		setLayout(Layout);
    		setBackground(new Color(255,255,204));
    		setOpaque(true);
    		setBorder(BorderFactory.createLineBorder(new Color(255,204,51), 10));
            try {
                p1 = ImageIO.read(new File("/Users/bigtay/Desktop/SlotMachinep1/SlotMachine/src/Lakers.png"));
                p2 = ImageIO.read(new File("/Users/bigtay/Desktop/SlotMachinep1/SlotMachine/src/Warriors.png"));
                p3 = ImageIO.read(new File("/Users/bigtay/Desktop/SlotMachinep1/SlotMachine/src/Knicks.png"));
                p4 = ImageIO.read(new File("/Users/bigtay/Desktop/SlotMachinep1/SlotMachine/src/Cavs.png"));
                p5 = ImageIO.read(new File("/Users/bigtay/Desktop/SlotMachinep1/SlotMachine/src/Nets.png"));
                p6 = ImageIO.read(new File("/Users/bigtay/Desktop/SlotMachinep1/SlotMachine/src/Mavs.png"));
                
                
                frame = p1;
            } catch (IOException exp) {
                exp.printStackTrace();
                
            }

            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	Random slots = new Random();
			        int slotnum = ((slots.nextInt(8)% 10));
			        if(slotnum==0)
			        	{photo= p1;
			        	photo2= p4;}
			        	else if (slotnum==1)
			        	{photo= p2;
			        	photo2= p5;}

			        	else if (slotnum==2)
			        	{photo= p1;
			        	photo2= p5;}
			        	else if (slotnum==3)
			        	{photo= p6;
			        	photo2= p3;}
			        	else
			        	{photo=p1;
			        	photo2=p2;}
			        
                	opened = !opened;
                    frame = opened ? photo : photo2;
                    repaint();
                }

			
            });
            timer.setRepeats(true);
			 timer.setCoalesce(true);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 500);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if ((frame != null)&& spin) {
               
                g2d.drawImage(frame, 30, y, this);
                g2d.drawImage(frame, 180, y, this);
                g2d.drawImage(frame, 320, y, this);
                g2d.drawImage(frame, 480,y , this);
                g2d.drawImage(frame, 620, y, this);
                g2d.drawImage(frame, 30, y+255, this);
                g2d.drawImage(frame, 180, y+255, this);
                g2d.drawImage(frame, 320, y+255, this);
                g2d.drawImage(frame, 480,y+255 , this);
                g2d.drawImage(frame, 620, y+255, this);
                y=y-Yvelocity;
                if(y<-180)
                	{y=17;}
           g2d.setColor(new Color(255,204,51));
            g2d.setStroke(new BasicStroke(5));
            g2d.draw(new Line2D.Float(160, 13, 160, 200));
            g2d.draw(new Line2D.Float(180+130, 13, 180+130, 200));
            g2d.draw(new Line2D.Float(150+300, 13, 150+300, 200));
            g2d.draw(new Line2D.Float(170+430, 13, 170+430, 200));
            g2d.draw(new Line2D.Float(0, y+220, 790, y+220));

        }
            else if (!spin)
            {if (payout==5)
    			
    			{
                	g2d.drawImage(p1, 30, y, this);
                    g2d.drawImage(p1, 180, y, this);
                    g2d.drawImage(p1, 320, y, this);
                    g2d.drawImage(p1, 480,y , this);
                    g2d.drawImage(p1, 620, y, this);
                    
                    g2d.setColor(new Color(255,204,51));
                    g2d.setStroke(new BasicStroke(5));
                    g2d.draw(new Line2D.Float(160, 13, 160, 200));
                    g2d.draw(new Line2D.Float(180+130, 13, 180+130, 200));
                    g2d.draw(new Line2D.Float(150+300, 13, 150+300, 200));
                    g2d.draw(new Line2D.Float(170+430, 13, 170+430, 200));
                    g2d.draw(new Line2D.Float(0, y+220, 790, y+220));
    			}
    			            else if (payout==4)
    			            {
    			            	g2d.drawImage(p2, 30, y, this);
    			            g2d.drawImage(p2, 180, y, this);
    			            g2d.drawImage(p2, 320, y, this);
    			            g2d.drawImage(p2, 480,y , this);
    			            g2d.drawImage(p1, 620, y, this);
    			            
    			            g2d.setColor(new Color(255,204,51));
    			            g2d.setStroke(new BasicStroke(5));
    			            g2d.draw(new Line2D.Float(160, 13, 160, 200));
    			            g2d.draw(new Line2D.Float(180+130, 13, 180+130, 200));
    			            g2d.draw(new Line2D.Float(150+300, 13, 150+300, 200));
    			            g2d.draw(new Line2D.Float(170+430, 13, 170+430, 200));
    			            g2d.draw(new Line2D.Float(0, y+220, 790, y+220));}
    			            
            					else if (payout==3)
            					{
            					g2d.drawImage(p5, 30, y, this);
            		            g2d.drawImage(p2, 180, y, this);
            		            g2d.drawImage(p2, 320, y, this);
            		            g2d.drawImage(p2, 480,y , this);
            		            g2d.drawImage(p4, 620, y, this);
            		            
            		            g2d.setColor(new Color(255,204,51));
            		            g2d.setStroke(new BasicStroke(5));
            		            g2d.draw(new Line2D.Float(160, 13, 160, 200));
            		            g2d.draw(new Line2D.Float(180+130, 13, 180+130, 200));
            		            g2d.draw(new Line2D.Float(150+300, 13, 150+300, 200));
            		            g2d.draw(new Line2D.Float(170+430, 13, 170+430, 200));
            		            g2d.draw(new Line2D.Float(0, y+220, 790, y+220));}
            					
                        else if (payout==2)
                        {
                        	g2d.drawImage(p6, 30, y, this);
                            g2d.drawImage(p4, 180, y, this);
                            g2d.drawImage(p5, 320, y, this);
                            g2d.drawImage(p2, 480,y , this);
                            g2d.drawImage(p1, 620, y, this);
                            
                            g2d.setColor(new Color(255,204,51));
                            g2d.setStroke(new BasicStroke(5));
                            g2d.draw(new Line2D.Float(160, 13, 160, 200));
                            g2d.draw(new Line2D.Float(180+130, 13, 180+130, 200));
                            g2d.draw(new Line2D.Float(150+300, 13, 150+300, 200));
                            g2d.draw(new Line2D.Float(170+430, 13, 170+430, 200));
                            g2d.draw(new Line2D.Float(0, y+220, 790, y+220));
                        
                        }
                        
                            else if (payout==1)
                            {
                            	g2d.drawImage(p2, 30, y, this);
                                g2d.drawImage(p3, 180, y, this);
                                g2d.drawImage(p5, 320, y, this);
                                g2d.drawImage(p6, 480,y , this);
                                g2d.drawImage(p1, 620, y, this);
                                
                                g2d.setColor(new Color(255,204,51));
                                g2d.setStroke(new BasicStroke(5));
                                g2d.draw(new Line2D.Float(160, 13, 160, 200));
                                g2d.draw(new Line2D.Float(180+130, 13, 180+130, 200));
                                g2d.draw(new Line2D.Float(150+300, 13, 150+300, 200));
                                g2d.draw(new Line2D.Float(170+430, 13, 170+430, 200));
                                g2d.draw(new Line2D.Float(0, y+220, 790, y+220));
                            }
                            
                            	else if (payout==0)
                            	{
                            		
                            		g2d.drawImage(p1, 30, y, this);
                                    g2d.drawImage(p3, 180, y, this);
                                    g2d.drawImage(p4, 320, y, this);
                                    g2d.drawImage(p5, 480,y , this);
                                    g2d.drawImage(p6, 620, y, this);
                                    
                                    g2d.setColor(new Color(255,204,51));
                                    g2d.setStroke(new BasicStroke(5));
                                    g2d.draw(new Line2D.Float(160, 13, 160, 200));
                                    g2d.draw(new Line2D.Float(180+130, 13, 180+130, 200));
                                    g2d.draw(new Line2D.Float(150+300, 13, 150+300, 200));
                                    g2d.draw(new Line2D.Float(170+430, 13, 170+430, 200));
                                    g2d.draw(new Line2D.Float(0, y+220, 790, y+220));
                            	}
                
             }    
                g2d.dispose();
           }}
    class  BetterSlot  {
		int ocount=0;
		int bookmark=0;
		boolean isfullhouse=false;
		boolean isPSquare=false;
		boolean isPoweroftwo=false;
		boolean isfourtwo=false;
	   
	  
		public int[] pullTheLever()
		{
			
			
			//int [] values= new int[]{1,1,0,1,1};
			 values= new int[5];
			 
		      Random slots = new Random();
			        for (int i = 0; i< values.length; i++){
			          int slotnum = slots.nextInt(50);
			          values[i] = slotnum;
			          
			         
			        }
				 
			      
	return values;
		}
		
		
		public int payOff(int[] values)
		{
			switch(occurancecounter(values))
			
			{
			
			case 5:
				payout=100000;
			case 4:
				payout=10000;
			case 3:
				payout =100;
				ispair(values);
			case 2:
				payout=10;
			case 1:
				payout=0;
				
				
				if(isPSquare(values))
					payout+=7;
				else if(isPoweroftwo(values))
					payout+=3;
				else if(isfourtwo(values))
					payout+=2;	
				
			}
			System.out.println(payout);
		return payout;
	}
		public int occurancecounter(int[] values){
			  
		      int Maxfreq=0; 
		      for(int i = 0; i < values.length; i++){  
		    	  ocount=1;
		           
		          for(int m = i+1; m < values.length; m++){  
		              
		        	  if(values[i] == values[m]){  
		                  ocount++; 
		                  bookmark=values[i];
		        	  }
		        	  } 
		        	 
		        	  if(Maxfreq<ocount){
		        		  Maxfreq=ocount;
		        		  
		        		  }}
		      
		  System.out.println(Maxfreq);    
		return Maxfreq;			
		
			
	}
	public boolean ispair(int[] values)
	{
		 int Maxfreq=0;
	     
	    for(int i = 0; i < values.length; i++){  
	  	  ocount=0;
	         
	        for(int m = i+1; m < values.length; m++){  
	            
	      	  if(values[i] == values[m]&& values[i] != bookmark){  
	                ocount++;   
	      	  }
	      	  } 
	      	 
	      	  if(Maxfreq<ocount){
	      		  Maxfreq=ocount;}
	        if (Maxfreq==2) {
	        	isfullhouse= true;
	        }
	    }  
	   return isfullhouse; 
	}
	public boolean isPoweroftwo(int[] values)
	{
		for (int i =0; i < values.length;i++)
		{
							if (values[i]== 2||values[i]==4
									||values[i]==8
									||values[i]==16||values[i]==32)
								
							{ 
								isPoweroftwo=true;
				
						}
		
	}return isPoweroftwo;
	}
	public boolean isPSquare(int[] values)
	{
		for (int i =0; i < values.length;i++)
		{
							if (values[i]== 4||values[i]==9
									||values[i]==16||values[i]==25||values[i]==36||values[i]==49)
								
							{ 
	isPSquare=true;					}
							
						}
		return isPSquare;
		
	}
	public boolean isfourtwo(int[] values)
	{
		
		for (int i =0; i < values.length;i++)
		{
							if (values[i]== 42)
								
							{ 
							  isfourtwo=true;
							}
							
						}
		return isfourtwo;
		
	}
	

	

	

}

   }

