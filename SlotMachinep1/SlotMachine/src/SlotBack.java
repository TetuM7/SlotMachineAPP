/**
 * 
 */

/**
 * @author Tetu Mbah
 * Computer Sceince Major @Georgetown Univeristy 
 * 
 *This class is responsible for generating slot machine numbers and thier corresponding payouts.
 */
import java.util.Random;



public class SlotBack {
int ocount=0;
	int bookmark=0;
	boolean isfullhouse=false;
	boolean isPSquare=false;
	boolean isPoweroftwo=false;
	boolean isfourtwo=false;
   int payout=0;
   int [] values;
   String[] charvalues;
   String payoutstring;
   /* Generates 5 random values and returns an array of 5 digits 
	betweeen 1-50*/
	
   public static void main(String[] args) {

		BetterSlot betterslot = new BetterSlot();

		int[] values = betterslot.pullTheLever();
		betterslot.payOff(values);

	public int[] pullThelever()
	{
				int[] values= new int[]{1,0,1,1,1};
				/*int [] values= new int[5];
			  charvalues= new String[5];
				Random slots = new Random();
		        for (int i = 0; i< values.length; i++){
		          int slotnum = slots.nextInt(50);
		         values[i] = slotnum;
		         charvalues[i]=(String.valueOf(values[i]));
		        };*/
return values;
	}
	
	//determines the amount that should be payed out to users
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
			if(isPoweroftwo(values))
				payout+=3;
			if(isfourtwo(values))
				payout+=2;	
			
                		
		}		 System.out.println(payout)	;	
		return payout;	
	}

		//Counts the number of occurances of a number within the random vlaues
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
  	  ocount=1;
         
        for(int m = i+1; m < values.length; m++){  
            
      	  if(values[i] == values[m]&& values[i] != bookmark){  
                ocount++;   
      	  }
      	  } 
      	 
      	  
        if (ocount==2) {
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

public static void main(String[] args) {
	SlotBack back=new SlotBack();
	int[] values = back.pullThelever();
	back.payOff(values);}	// TODO Auto-generated method stub
	
}

	

