import java.net.*;
import java.io.*;

class Server
{
	public static void main(String args[])throws Exception
	{
		ServerSocket	serversocket=new ServerSocket(3050);
		
		System.out.println("Server started,Waiting for client");
		Socket clientsocket=serversocket.accept();
		System.out.println("Client connected");

		InputStream in=clientsocket.getInputStream();

		while(true)
		{
			if(in.available()>0)
			{
				byte[] data=new byte[in.available()];
				in.read(data,0,data.length);
				String str=new String(data,0,data.length);
				if(str.equals("exit"))
				{
					break;
				}
				System.out.println(str);
			}
		}
	}
}
