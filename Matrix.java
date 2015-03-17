package lab;
import java.util.Scanner;
import java.io.*;
/* 
*
*  
* 
*/

public class Matrix
{
	public static int r;
	public static int c;
	public static int row;
	public static int column;
	private static int rows = 0;
    private static int columns = 0;
    int cc,dd,kk;
    int sum=0;
    private static int [][] matrix = null;
	//public static int scores[ ][ ];//make global arrays
	public static void main(String[] args) {//main function
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns of matrix respectively");
	      r = in.nextInt();
	      c  = in.nextInt();
	      
		  int scores[][] = new int[r][c];//first matrix
                
            
		
		int matrix2[ ][ ] = new int[r][c];//3rd matrix
		int result[ ][ ] = new int[r][c];//result matrix
		//r1withc2 for matrix multiplication
		
		System.out.println("Enter values for first Matrix");
		for ( row = 0; row < r; row ++ ){
			for ( column = 0; column < c; column++)
		    	 
		   {
		    	 scores [ row ] [ column ] = in.nextInt();
		                                                                                                      
		     }
		}
		System.out.println("Enter the number of rows and columns of matrix respectively");
	      int r2 = in.nextInt();
	      int c2  = in.nextInt();
	      int matrix1[ ][ ] = new int[r2][c2];//second matrix
		System.out.println("Enter values for second Matrix");
		for ( row = 0; row < r2; row ++ ){
			for ( column = 0; column < c2; column++)
		    	 
		   {
		    	 matrix1 [ row ] [ column ] = in.nextInt();
		                                                                                                      
		     }
		}
		int mul_result[ ][ ] = new int[r][c2];//result for multiplication
		/*System.out.println("Enter values for 3rd Matrix");
		for ( row = 0; row < r; row ++ ){
			for ( column = 0; column < c; column++)
		    	 
		   {
		    	 matrix2[row][column] = in.nextInt();
		                                                                                                      
		     }
		}*/
		if(r==r2){
			if(c==c2){
		for ( row = 0 ; row < r ; row++ ){//addition function
	         for ( column = 0 ; column < c ; column++ ){
	             result[row][column] = scores[row][column] + matrix1[row][column];  //function to add,also can be used for subtraction just use '-''
	}
		}
		//now function to print result
		System.out.println("Sum of entered matrices:-");
		 
		 for (int i=0; i < r; i++) {//print matrix
	         for(int j=0; j < c; j++){
	             System.out.print(result[i][j]+"\t");
	         
	         
	     }
	         System.out.println("");
	       
	       
	    }
		}
			else{
				System.out.println("Matrices Cant be added.");
			}
		}
		else{
			 System.out.println("Matrices Cant be added.");
		 }
	
	
	 if(r==r2){
			if(c==c2){
		for ( row = 0 ; row < r ; row++ ){//subtraction function
	         for ( column = 0 ; column < c ; column++ ){
	             result[row][column] = scores[row][column] - matrix1[row][column];  //function to add,also can be used for subtraction just use '-''
	}
		}
		   System.out.println("Subtracted Matix is:-");
		    for (int i=0; i < r; i++) {//print matrix
		        for(int j=0; j < c; j++){
		            System.out.print(result[i][j]+"\t");
		        
		        
		    }
		        System.out.println("");
		      
		      
		   }
		}
			else{
				System.out.println("Matrices Cant be subtracted");
			}
		}
	 else{
		 System.out.println("Matrices Cant be subtracted");
	 }
 
    //multiply matrices here eg m,n,p,q are rows and column respectivly taken
    if ( c != r2 ){
        System.out.println("Matrices with entered orders can't be multiplied with each other.");
        }
    else{
    	 for(int ii = 0; ii < r; ii++){
    	        for(int jj = 0; jj < c2; jj++){
    	            for(int kk = 0; kk < c; kk++){
    	            	mul_result[ii][jj] += scores[ii][kk] * matrix1[kk][jj];
    	            }
    	        }
    	    }
    	    System.out.println("Multiplied matrices are equivalent to:-");
    		 
    		 for (int i=0; i < r; i++) {//print matrix
    	        for(int j=0; j < c2; j++){
    	            System.out.print(mul_result[i][j]+"\t");
    	        
    	        
    	    }
    	        System.out.println("");
    	      
    	      
    	   }
    	
    }
   
  
    
	}
	
	
	//just example functions below
	public static void printOne() {
		System.out.println("Hello World\n");
	}

	
}