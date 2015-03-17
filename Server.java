package lab4;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends Thread {

static final String HTML_START =
"<html>" +
"<title>HTTP Serrver in the eclipse java</title>" +
"<body>";

static final String HTML_END =
"</body>" +
"</html>";

Socket connectedClient = null;
BufferedReader inFromClient = null;
DataOutputStream outToClient = null;


public Server(Socket client) {
connectedClient = client;
}

public void run() {

try {

System.out.println( "Thee client "+
  connectedClient.getInetAddress() + ":" + connectedClient.getPort() + " iz conected");

  inFromClient = new BufferedReader(new InputStreamReader (connectedClient.getInputStream()));
  outToClient = new DataOutputStream(connectedClient.getOutputStream());

String requestString = inFromClient.readLine();
  String headerLine = requestString;

  StringTokenizer tokenizer = new StringTokenizer(headerLine);
String httpMethod = tokenizer.nextToken();
String httpQueryString = tokenizer.nextToken();

StringBuffer responseBuffer = new StringBuffer();
responseBuffer.append("<b> Thiss is HTTP Server(page of home). </b><BR>");
  responseBuffer.append("The HTTP Client request is ....<BR>");

  System.out.println("Thee requesst strings oh http iz:");
  while (inFromClient.ready())
  {
    // Read the HTTP complete HTTP Query
    responseBuffer.append(requestString + "<BR>");
System.out.println(requestString);
requestString = inFromClient.readLine();
}

if (httpMethod.equals("GET")) {
if (httpQueryString.equals("/")) {
 // The default home page
sendResponse(200, responseBuffer.toString(), false);
} else {
//This is interpreted as a file name
String fileName = httpQueryString.replaceFirst("/", "");
fileName = URLDecoder.decode(fileName);
if (new File(fileName).isFile()){
sendResponse(200, fileName, true);
}
else {
sendResponse(404, "<b>404 error, file not found</b>", false);
}
}
}
else sendResponse(404, "<b>The error, file not found" +
"Usages are something like : http://127.0.0.1:5000 or http://127.0.0.1:5000/</b>", false);
} catch (Exception e) {
e.printStackTrace();
}
}

public void sendResponse (int statusCode, String responseString, boolean isFile) throws Exception {

String statusLine = null;
String serverdetails = "Server: Java HTTPServer";
String contentLengthLine = null;
String fileName = null;
String contentTypeLine = "Content-Type: text/html" + "\r\n";//display content type
FileInputStream fin = null;

if (statusCode == 200)
statusLine = "HTTP/1.1 200 OK" + "\r\n";//display ok if success
else
statusLine = "HTTP/1.1 404 Not Found" + "\r\n";//display not found if file not in directory

if (isFile) {
fileName = responseString;
fin = new FileInputStream(fileName);
contentLengthLine = "Content-Length: " + Integer.toString(fin.available()) + "\r\n";//display content length
if (!fileName.endsWith(".htm") && !fileName.endsWith(".html"))
contentTypeLine = "Content-Type: \r\n";
}
else {
responseString = Server.HTML_START + responseString + Server.HTML_END;
contentLengthLine = "Content-Length: " + responseString.length() + "\r\n";//display content length
}

outToClient.writeBytes(statusLine);
outToClient.writeBytes(serverdetails);
outToClient.writeBytes(contentTypeLine);
outToClient.writeBytes(contentLengthLine);
outToClient.writeBytes("Connection: close\r\n");
outToClient.writeBytes("\r\n");

if (isFile) sendFile(fin, outToClient);
else outToClient.writeBytes(responseString);

outToClient.close();
}

public void sendFile (FileInputStream fin, DataOutputStream out) throws Exception {
byte[] buffer = new byte[1024] ;
int bytesRead;

while ((bytesRead = fin.read(buffer)) != -1 ) {
out.write(buffer, 0, bytesRead);
}
fin.close();
}

public static void main (String args[]) throws Exception {

ServerSocket Server = new ServerSocket (5000, 10, InetAddress.getByName("127.0.0.1"));
System.out.println ("TCPServer Waiting for client on port 5000");//socket on this port

while(true) {
Socket connected = Server.accept();//accept connections
    (new Server(connected)).start();
}
}
}