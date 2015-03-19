package lab3;

import java.net.*; 
import java.io.*;
public class server { 
	public static void main (String [] args ) throws IOException {
		ServerSocket serverSocket = new ServerSocket(16126);//creating socket
		  Socket socket = serverSocket.accept();
		System.out.println("Accepting the connection  " );
		File transferFile = new File ("hello.txt");///read this file to copy
		byte [] bytearray = new byte [(int)transferFile.length()]; 
		FileInputStream fin = new FileInputStream(transferFile);//file input stream
		BufferedInputStream BIS = new BufferedInputStream(fin); 
		BIS.read(bytearray,0,bytearray.length);
		OutputStream os = socket.getOutputStream(); 
		System.out.println("Now we are sending the filee!!");
		os.write(bytearray,0,bytearray.length); 
		os.flush();
		socket.close();
		System.out.println("Transferring of file done!!"); } } 

