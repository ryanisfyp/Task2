
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.net.*;


class TCPServer 
{
public static void main(String argv[]) throws Exception 
{

String clientSentence;
String hostname;
String capitalizedSentence;
String sendBack;
InetAddress ip;
String hostIP;

ServerSocket welcomeSocket = new ServerSocket(31618);

while (true) 
{
Socket connectionSocket = welcomeSocket.accept();

BufferedReader inFromClient = 
 new BufferedReader (new InputStreamReader 
(connectionSocket.getInputStream()));

DataOutputStream outToClient = new 
DataOutputStream(connectionSocket.getOutputStream());

ip = InetAddress.getLocalHost();

hostname = ip.getHostName();
hostIP = ip.getHostAddress();
 

clientSentence = inFromClient.readLine();

if (clientSentence.equalsIgnoreCase("what is server hostname"))
	{
	sendBack = hostname;
	}

else if (clientSentence.equalsIgnoreCase("what is server ip"))
	{
	sendBack = hostIP;
	}

else if (clientSentence.equalsIgnoreCase("what is server port"))
	{
	sendBack = "47974";
	}

else if (clientSentence.equalsIgnoreCase("what is TTL"))
	{
	sendBack = "Unlimited!";
	}	

else
	{
	sendBack = "Invalid Question!";
	}

System.out.println("Client's question : " + clientSentence);
capitalizedSentence = sendBack + "\n";
outToClient.writeBytes(capitalizedSentence);
}

}
}

