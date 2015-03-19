package Assinment;
//Name:Rizwan Ahmad
//Class:BSCS2-B
//Registration Number:00073
public class Assinment1 {
	public void fastestway( int a[][], int t[][], int e[], int x[], int n)
    {//a11 1st line firsst station
        int[] ll1= new int[n];//lines for station1	
        int[] ll2= new int[n];//lines for station2	
        int[] ff1 = new int[n];//station1
        int[] ff2 = new int[n];//station12        
        int f,l;
        
        ff1[0]= e[0] + a[0][0];
        ff2[0]= e[1] + a[1][0];
        
        for(int j=1; j<n; j++)//algo by sir implemented
        {
        
            if(ff1[j-1] + a[0][j] <= ff2[j-1] + t[1][j-1] + a[0][j])
            {
                ff1[j]= ff1[j-1] + a[0][j];
            
                ll1[j]=1;
                System.out.println("Station1: line is " +ll1[j] + " And time taken is "+ ff1[j]);
                
            }
            else
            {
                ff1[j]= ff2[j-1] + t[1][j-1] + a[0][j];
                ll1[j]=2;
                System.out.println("Station1: line is " +ll1[j] + " And time taken is "+ ff1[j]);
            }
            
            if(ff2[j-1] + a[1][j] <= ff1[j-1] + t[0][j-1] + a[1][j])
            {
                    ff2[j] = ff2[j-1]+a[1][j];
                    ll2[j] = 2;
                    System.out.println("Station2: line is " +ll1[j] + " And time taken is "+ ff1[j]);

            }
            else 
            {
                ff2[j] = ff1[j-1] + t[0][j-1] + a[1][j];
                ll2[j] =1;
                System.out.println("Station2: line is " +ll1[j] + " And time taken is "+ ff1[j]);
            }
            
           }
        
         if (ff1[n-1] + x[0] <= ff2[n-1] + x[1])
            { 
               
        	 f = ff1[n-1] + x[0];//Shortest time taken
                
        	 l = 1;
            }
            else
            {
                
                f = ff2[n-1] + x[1];//Shortest time taken
                l = 2;
            }
         System.out.println("The Shortest time taken is " +f);
        
    }
	public static void main(String []args){
		Assinment1 myAssinment = new Assinment1();
		int ee[] = new int[] {5,5,4 };///entry time at line i
		int xx[] = new int[] {1,2,3};///exit time at line i
		int [][] aa = new int[3][3] ;
		int low=2;
		int high=30;
		System.out.println("Assignment with random values " );
	    aa[0][0] = (low+((int)(high*Math.random())));//generating random numbers
	    aa[0][1] = (low+((int)(high*Math.random())));
	    aa[0][2] = (low+((int)(high*Math.random())));
	    aa[1][0] = (low+((int)(high*Math.random())));
	    aa[1][1] = (low+((int)(high*Math.random())));
	    aa[1][2] = (low+((int)(high*Math.random())));
	    aa[2][0] = (low+((int)(high*Math.random())));
	    aa[2][1] = (low+((int)(high*Math.random())));
	    aa[2][2] = (low+((int)(high*Math.random())));
		int bx=(low+((int)(high*Math.random())));
		//System.out.println("Random value is " +bx);
		int [][] bb=new int[3][3] ;
		 bb[0][0] =(low+((int)(high*Math.random())));
		    bb[0][1] = (low+((int)(high*Math.random())));
		    bb[0][2] = (low+((int)(high*Math.random())));
		    bb[1][0] = (low+((int)(high*Math.random())));
		    bb[1][1] = (low+((int)(high*Math.random())));
		    bb[1][2] = (low+((int)(high*Math.random())));
		    bb[2][0] = (low+((int)(high*Math.random())));
		    bb[2][1] = (low+((int)(high*Math.random())));
		    bb[2][2] = (low+((int)(high*Math.random())));
		int N=3;
		myAssinment.fastestway(aa, bb, ee, xx, N);
		//(int)(Math.random())
	}
}