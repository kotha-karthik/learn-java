import java.net.*;
import java.io.*;
class ServerTemplate
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket socserver=new ServerSocket(3050);
		System.out.println("Server is waiting for client");
		Socket socclient=socserver.accept();
		System.out.println("client connected");
		Socket serversocket=new Socket("192.168.0.121",3051);
		InputStream in=socclient.getInputStream();
		OutputStream out=serversocket.getOutputStream();
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
				str=str+"from server";
				data=str.getBytes();
				out.write(data,0,data.length);
			}
		}
		
		
	}
}
