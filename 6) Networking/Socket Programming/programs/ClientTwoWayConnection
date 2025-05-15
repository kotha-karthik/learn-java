import java.net.*;
import java.io.*;
class ClientTemplate
{
	public static void main(String args[])throws Exception
	{
		Socket serversocket=new Socket("",3050);
		ServerSocket socserver=new ServerSocket(3051);
		System.out.println("Client is waiting for Server");
		Socket socclient=socserver.accept();
		System.out.println("Server connected");
		OutputStream out=serversocket.getOutputStream();
		InputStream in=socclient.getInputStream();
		while(true)
		{
			System.out.print("Enter message:");
			String str=System.console().readLine();

			byte[] data=str.getBytes();
			
			out.write(data,0,data.length);
			while(true)
			{
				if(in.available()>0)
				{
					byte[] msg=new byte[in.available()];
					in.read(msg,0,msg.length);
					String s=new String(msg,0,msg.length);
					
					System.out.println(s);
					break;
				}
				
			}
			if(str.equals("exit"))
			{
				break;
			}

		}
		
		
	}
}
