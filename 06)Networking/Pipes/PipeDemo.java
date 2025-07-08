import java.io.*;
class PipeThread extends Thread
{
	private PipedWriter pw;
	public PipeThread(PipedWriter pw)
	{
		this.pw=pw;
	}
	public void run()
	{
		try
		{
			String str="Hello welcome to pipes";
			pw.write(str);
			
		}
		catch(Exception e){}
	}
}
class PipeDemo
{
	public static void main(String args[]) throws Exception
	{
		PipedWriter pw=new PipedWriter();
		PipedReader pr=new PipedReader(pw);// passing the connection 
		// pw.connect(pr); making the connection
		PipeThread pt=new PipeThread(pw);
		pt.start();
		int data;
		try{
		while((data=pr.read())!=-1)
		{
			System.out.print((char)data);
		}
		}
		catch(Exception e){}
	}
}
