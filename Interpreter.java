package lab2;
import java.io.*;
import java.util.Scanner;
public class Interpreter {
	
	private static BufferedReader inner = null;
	private static int xx = 0;
	private static int yy = 0;
	private static int max = 10;
	public static void main(String []args) throws IOException{
		int lineNumber=1;    
		int lineNum = 0;
		String lets="letss";

        int row=0;

        try {//origional functionality here
        	//if(lineNumber==1){
        	inner = new BufferedReader(new FileReader("file.txt"));
			String line[] =  new String[max]; ;
	        while((line[lineNum] = inner.readLine()) !=null) {//split(String regex, int limit)limit = how many string to be returned
	        // String [] tokens = line.split(",");//token inner different index for each number
	        	System.out.println(line[lineNum]);
	        	//upto three limit,4 values
	        	
	        	String [] tokens=tokens=line[lineNum].split(" ");
	        	if(tokens[0].matches("let")){
	        		
	        		System.out.println("Processing line number"+(lineNum+1));
	        		if(tokens[2].matches("=")){
	        			if(lineNum==0){//for 1st line
	        				
	        				xx=Integer.parseInt(tokens[3],16);
	        				System.out.println("The value of "+tokens[1]+" variable is "+xx);
	        			}
	        			else if(lineNum==1){//for 2nd line
	        				yy=Integer.parseInt(tokens[3],16);
		        			System.out.println("The value of "+tokens[1]+" variable is "+yy);
		        			/*yy=xx+1;
	        				System.out.println("The Answer after solving the equation below = " +yy);*/
	        				
	        			}
	        			
	        		
	        		}
	        	}

	        	else if(lineNum==2){
    				
    				if(tokens[0].matches("y")){
    					yy=xx+1;
        				System.out.println("The result is " +yy);
        		
    					
    					
    				}
    				else if(tokens[0].matches("x")){
    					xx=yy+1;
        				System.out.println("The result is " +xx);
    					
    					
    				}
    				
    				
    			}
	        	
	        	lineNum++;
	            }//for while loop
        	//for line nuber 1
        	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//read this file
        finally {
            if (inner!=null) inner.close();
        }
        
       
       
}
}
