
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.net.*;


class TCPServer 
{

private String hostname;
private String ip;
private String port;
private String TTL;
private String time;


public String getHostname()
{ 
return hostname;
}

public String getServerIP()
{ 
return ip;
}

public String getServerPort()
{ 
return port;
}

public String getServerTTL()
{ 
return TTL;
}

public String getServerTime()
{ 
return time;
}

public static void main(String argv[]) throws Exception 
{

String clientSentence;
String hostname;
String capitalizedSentence;
String sendBack;
InetAddress ip;
String hostIP;

ServerSocket welcomeSocket = new ServerSocket(47974);

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

else if (clientSentence.equalsIgnoreCase("what is server ipv4"))
	{
	sendBack = hostIP;
	}

else if (clientSentence.equalsIgnoreCase("what is server port"))
	{
	sendBack = "31618";
	}

else if (clientSentence.equalsIgnoreCase("what is TTL"))
	{
	sendBack = "Unlimited!";
	}
	
else if (clientSentence.equalsIgnoreCase("what is time"))
	{
	sendBack = "tbd";
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

