import java.net.*;
import java.io.*;
class ReadThread extends Thread
{
	private Socket socket;
	public ReadThread(Socket socket)
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
	}/*
	public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Received: " + msg);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Debug message
        }
    }*/
}
class MessageClient
{
	public static void main(String args[])throws Exception
	{
		Socket soc=new Socket("localhost",3050);
		System.out.println("Connected to Server");
		ReadThread rt=new ReadThread(soc);
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
