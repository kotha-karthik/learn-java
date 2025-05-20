class Factory
{
	private boolean isSet;
	private int count;
	public synchronized void set()
	{
		try{
			if(!isSet)
			{
				count++;
				System.out.println("Value is set");
				notify();
			}
			wait();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public synchronized void get()
	{
		try{
			if(!isSet)
			{
				System.out.println("Value is set: "+count);
				isSet=false;
				notify();
			}
			wait();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class consumer extends Thread
{
	private Factory fact;
	public consumer(Factory fact)
	{
		this.fact=fact;
	}
	public void run()
	{
		while(true)
		{
			this.fact.get();
		}
	}
}
class producer extends Thread
{
	private Factory fact;
	public producer(Factory fact)
	{
		this.fact=fact;
	}
	public void run()
	{
		while(true)
		{
			this.fact.set();
		}
	}
}
class program
{
	public static void main(String args[])
	{
		Factory fact=new Factory();
		consumer c=new consumer(fact);
		producer p=new producer(fact);
		c.start();
		p.start();
	}
}
