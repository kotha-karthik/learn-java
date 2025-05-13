import java.net.*;
import java.io.*;
class Client
{
	public static void main(String args[])throws Exception
	{
		String str;
		Socket	 serversocket=new Socket("192.168.0.121",3050);
		OutputStream	out=serversocket.getOutputStream();
		while(true)
		{
			System.out.print("Enter message:");
			str=System.console().readLine();

			byte[] data=str.getBytes();
			
			out.write(data,0,data.length);

			if(str.equals("exit"))
			{
				break;
			}
		}
	}
}
