package lab3;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
public class client {
	public static void main (String [] args ) throws IOException {
		int filesize=1022386; 
		int bytesRead;
		int currentTot = 0;
		Socket socket = new Socket("127.0.0.1",16126); 
		byte [] Bytes = new byte [filesize];
		InputStream inp_Stream = socket.getInputStream(); 
		FileOutputStream fos = new FileOutputStream("copy.doc");
		BufferedOutputStream bos = new BufferedOutputStream(fos); 
		bytesRead = inp_Stream.read(Bytes,0,Bytes.length); 
		currentTot = bytesRead;
		do { bytesRead = inp_Stream.read(Bytes, currentTot, (Bytes.length-currentTot));
		if(bytesRead >= 0) currentTot += bytesRead;
		} while(bytesRead > -1); 
		bos.write(Bytes, 0 , currentTot);
		bos.flush();
		bos.close();
		socket.close(); } } 

	