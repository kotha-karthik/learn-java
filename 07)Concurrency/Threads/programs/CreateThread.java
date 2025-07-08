class MyThread extends Thread
{
	public MyThread(String name)
	{
		super(name);
	}

	public void run()
	{
		try{
			for(int i=5;i>=0;i--)
			{
				System.out.println(getName() + ":" + i);
				Thread.sleep(200);
			}
		}catch(Exception ex){}
	}
}
class program
{
	public static void main(String args[])throws InterruptedException
	{
		MyThread	mt=new MyThread("MyThread");
		//mt.setName("MyThread");
		mt.start();// start will call run method.
		MyThread	mt2=new MyThread("MyThread-2");
		mt2.start();
		mt.join();
		mt2.join();
		for(int i=0;i<5;i++)
		{
			System.out.println(Thread.currentThread().getName() + ":" + i);
			Thread.sleep(1);
		}
		System.out.println("Main thread done");
	}		
}
