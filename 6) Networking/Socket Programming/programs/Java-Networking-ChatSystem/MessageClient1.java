import java.net.*;
import java.io.*;
class ReadThread1 extends Thread
{
	private Socket socket;
	public ReadThread1(Socket socket)
	{
		this.socket=socket;
	}
	public void run()
	{
		try
		{
			InputStream in=socket.getInputStream();
			while(true)
			{
				if(in.available()>0)
				{
					byte[] data=new byte[in.available()];
					in.read(data,0,data.length);
					String msg=new String(data,0,data.length);
					System.out.println(msg);
				}
			}
		}
		catch(Exception e){}
	}
}
class MessageClient1
{
	public static void main(String args[])throws Exception
	{
		Socket soc=new Socket("localhost",3050);
		System.out.println("Connected to Server");
		ReadThread1 rt=new ReadThread1(soc);
		rt.start();
		OutputStream os=soc.getOutputStream();
		while(true)
		{
			System.out.print("Enter the message:");
			String str=System.console().readLine();
			if(str.equals("exit"))
			{
				break;
			}
			os.write((str).getBytes());
			
		}
	}
}
