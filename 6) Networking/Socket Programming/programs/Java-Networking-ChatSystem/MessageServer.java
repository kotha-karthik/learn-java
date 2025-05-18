import java.net.*;
import java.io.*;
import java.util.*;
class MyThread extends Thread
{
	private Map<Integer,Socket> ClientMap;
	public MyThread(Map<Integer,Socket> ClientMap)
	{
		this.ClientMap=ClientMap;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				for(Integer sender: ClientMap.keySet())
				{
					Socket sendersoc=ClientMap.get(sender);
					InputStream in=sendersoc.getInputStream();
					if(in.available()>0)
					{
						byte[] data=new byte[in.available()];
						in.read(data,0,data.length);
						String str=new String(data,0,data.length);
						String[] parts=str.split(":",2);
						int key=Integer.parseInt(parts[0].trim());
						String value=parts[1].trim();
						Socket TargetSocket=ClientMap.get(key);
						OutputStream os=TargetSocket.getOutputStream();
						os.write((value).getBytes());
						
					}
				}
				Thread.sleep(100);
			}
			catch(Exception e){}
		}
	}
}
class MessageServer
{
	public static void main(String args[])throws Exception
	{
		Map<Integer,Socket> Client=new HashMap<>();
		int key=1;
		ServerSocket sc=new ServerSocket(3050);
		System.out.println("Waiting for the clients....");
		MyThread mt=new MyThread(Client);
		mt.start();
		while(true)
		{
			Socket soc=sc.accept();
			Client.put(key,soc);
			System.out.println("Client Connected with id:: "+ key);
			key++;
			
		}

		

		
	}
}
