import java.awt.*;
	import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.event.MouseMotionListener;
	import java.util.Random;


public class SlotsGraphics extends JFrame implements ActionListener {
	
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
	int r1,r2,r3,r4,r5,r0;
	   String payoutval;
	   int [] values;
	   		   int payout=0;

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
					   r0= values[0];
				       r1= values[1];
				       r2= values[2];
				       r3= values[3];
				       r4= values[4];
				      
				        System.out.println(""+r1+""+r2+""+""+r3+r4);
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
	
	public SlotsGraphics() {
		
		// frame
		setSize(800,500);
		setTitle("Tay slots");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		// backpanel
		
		BackPanel= new JLayeredPane();
		BackPanel.setBounds(0,0,getWidth(),472);
		BackPanel.setBorder(BorderFactory.createLineBorder(new Color(255,102,0), 6, true));
		ImageIcon p1=  new ImageIcon("src/Background.png");
		
		titlelabel= new JLabel();
		titlelabel.setIcon(p1);
		titlelabel.setBounds(0, 0, 800, 500);
		titlelabel.setOpaque(false);
		
		
		Layout= new GridLayout(1,5);
		Layout.setHgap(30);
		l2= new GridLayout(1,5);
		l2.setHgap(20);
		l3= new GridLayout(1,5);
		l3.setHgap(58);
		
		superiorpanel= new JPanel();
		superiorpanel.setBounds(33,15,750,195);
		superiorpanel.setLayout(Layout);
		superiorpanel.setBackground(getForeground());
		superiorpanel.setOpaque(false);
		superiorpanel.setBorder(BorderFactory.createBevelBorder(25, new Color(204,204,204), Color.GRAY, Color.GRAY, Color.GRAY));
	
		panel1 = new JPanel();
		panel1.setBackground(Color.BLACK);
		panel1.setOpaque(true);
		panel1.setBorder(BorderFactory.createLineBorder(new Color(255,204,51), 5, true));
		p1l= new JLabel();
		
		p1l.setFont(new Font("BOLD", Font.BOLD,35));
		p1l.setText("?");
		p1l.setForeground(Color.RED);
		panel1.add(p1l,BorderLayout.CENTER);

		panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);
		panel2.setOpaque(true);
		panel2.setBorder(BorderFactory.createLineBorder(new Color(255,204,51), 5, true));
		p2l= new JLabel();
		p2l.setText("?");
		p2l.setFont(new Font("BOLD", Font.BOLD,35));
		p2l.setForeground(Color.RED);
		panel2.add(p2l,BorderLayout.CENTER);

		panel3 = new JPanel();
		panel3.setBackground(Color.BLACK);
		panel3.setOpaque(true);
		panel3.setBorder(BorderFactory.createLineBorder(new Color(255,204,51), 5, true));
		p3l= new JLabel();
		p3l.setText("?");
		p3l.setFont(new Font("BOLD", Font.BOLD,35));
		p3l.setForeground(Color.RED);
		panel3.add(p3l,BorderLayout.CENTER);

		panel4 = new JPanel();
		panel4.setBackground(Color.BLACK);
		panel4.setOpaque(true);
		panel4.setBorder(BorderFactory.createLineBorder(new Color(255,204,54), 5, true));
		p4l= new JLabel();
		p4l.setText("?");
		p4l.setFont(new Font("BOLD", Font.BOLD,35));
		p4l.setForeground(Color.RED);
		panel4.add(p4l,BorderLayout.CENTER);

		panel5 = new JPanel();
		panel5.setBackground(Color.BLACK);
		panel5.setOpaque(true);
		panel5.setBorder(BorderFactory.createLineBorder(new Color(255,204,51), 5, true));
		p5l= new JLabel();
		p5l.setText("?");
		//p5l.setIcon(p6);
		p5l.setFont(new Font("BOLD", Font.BOLD,35));
		p5l.setForeground(Color.RED);
		panel5.add(p5l,BorderLayout.CENTER);
		
		award = new JPanel();
		award.setBackground(Color.BLACK);
		award.setBorder(BorderFactory.createLineBorder(new Color(255,204,51), 5, true));
		award.setBounds(207, 225, 410, 45);
		awardlble= new JLabel();
		awardlble.setText("Congrats  ");
		awardlble.setFont(new Font("BOLD", Font.BOLD,20));
		awardlble.setForeground(Color.GREEN);
		award.add(awardlble);
		
		
		b1= BorderFactory.createBevelBorder(10);
		b2= BorderFactory.createBevelBorder(10);

		slotbutton = new JButton();
		slotbutton.addActionListener (this);
		slotbutton.setText("Spin");
		slotbutton.setBorder(BorderFactory.createCompoundBorder(b1, b2));
		slotbutton.setFont(new java.awt.Font("Cambria", 6, 30));
		slotbutton.setBounds(45,415,340,40);
		slotbutton.setBackground(Color.RED);
		slotbutton.setOpaque(true);
		
		
		
		
		Reset = new JButton();
		Reset.setText("RESET");
		Reset.setFont(new Font("Italic", Font.ITALIC,25));
		Reset.setForeground(Color.RED);
		Reset.setBorder(BorderFactory.createBevelBorder(3));
		Reset.setBackground(new Color(204,204,204));
		Reset.setOpaque(true);
		Reset.addActionListener(this);
		
		holdbuttons = new JPanel();
		holdbuttons.setLayout(l2);
		holdbuttons.setBounds(500,415,285,40);
		holdbuttons.add(Reset);
		holdbuttons.setOpaque(false);

		// TODO Auto-generated constructor stub
		
		superiorpanel.add(panel1);
		superiorpanel.add(panel2);
		superiorpanel.add(panel3);
		superiorpanel.add(panel4);
		superiorpanel.add(panel5);
		
		
		host= new JPanel();
		host.setBounds(235,300,350,80);
		host.setLayout(l3);
		host.setBackground(getForeground());
		host.setOpaque(false);
		
		b3 = BorderFactory.createLineBorder(new Color(255,204,51),3);
		b4 = BorderFactory.createLineBorder(Color.BLACK,7);

		spinsnum= new JPanel();
		spinsnum.setBackground(Color.WHITE);
		spinsnum.setOpaque(true);
		spinsnum.setBorder(BorderFactory.createCompoundBorder(b3, b4));
		numofspins= new JLabel();
		numofspins.setForeground(Color.RED);
		numofspins.setText("X");
		numofspins.setFont(new Font("BOLD", Font.BOLD,45));
		spinsnum.add(numofspins,BorderLayout.CENTER);
		
		blnce = new JPanel();
		blnce.setBackground(Color.WHITE);
		blnce.setOpaque(true);
		blnce.setBorder(BorderFactory.createCompoundBorder(b3, b4));
		balance= new JLabel();
		balance.setText("X");
		balance.setForeground(Color.RED);
		balance.setFont(new Font("BOLD", Font.BOLD,45));
		blnce.add(balance,BorderLayout.CENTER);

		earned = new JPanel();
		earned.setBackground(Color.WHITE);
		earned.setOpaque(true);
		earned.setBorder(BorderFactory.createCompoundBorder(b3, b4));
		amountwon= new JLabel();
		amountwon.setText("X");
		amountwon.setForeground(Color.RED);
		amountwon.setFont(new Font("BOLD", Font.BOLD,45));
		earned.add(amountwon,BorderLayout.CENTER);
		
		host.add(spinsnum);
		host.add(blnce);
		host.add(earned);

		
		BackPanel.add(host);
		BackPanel.add(holdbuttons);
		BackPanel.add(slotbutton);
		BackPanel.add(award);
		BackPanel.add(superiorpanel);
		//BackPanel.add(titlelabel);
		
		add(BackPanel);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(r0);
		payoutval= (String.valueOf(payout));
		v1=(String.valueOf(r0));
        v2=(String.valueOf(r1));
        v3=(String.valueOf(r2));
        v4=(String.valueOf(r3));
        v5=(String.valueOf(r4));
		if(e.getSource()==slotbutton)
			{

			BetterSlot s2= new BetterSlot();

			values= s2.pullTheLever();
			s2.payOff(values);
			awardlble.setText("Congrats  you won :"+payout+"$$");
			p1l.setText(v1);
			p2l.setText(v2);
			p3l.setText(v3);
			p4l.setText(v4);
			p5l.setText(v5);


			}
		else if((e.getSource()==Reset))
		{
			p1l.setText("?");
			p2l.setText("?");
			p3l.setText("?");
			p4l.setText("?");
			p5l.setText("?");
			awardlble.setText("");
			
		};}
		
		 public static void main(String[] args) {

				SlotsGraphics s1= new SlotsGraphics();
		   }
	
}