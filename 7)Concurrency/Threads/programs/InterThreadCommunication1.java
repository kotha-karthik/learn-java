//Interthread communication.

class Counter
{
	private int 	count;
	private boolean	isValueSet;	
	
	Counter(){
		count=0;
		isValueSet=false;
	}

	public synchronized boolean getIsValueSet()
	{
		return isValueSet;
	}
	
	public synchronized void set(int value)
	{
		count=value;	
		isValueSet=true;
		
	}
	
	public synchronized int get()
	{
		isValueSet=false;
		return count;
	}
}

class Producer extends Thread
{
	private Counter		counter;
	private int		i;

	public Producer(Counter counter)
	{
		this.counter=counter;
		i=0;
	}

	public void run()
	{
		try{
			while(i<10)
			{
				synchronized (counter)
				{
					if(!counter.getIsValueSet())
					{
						counter.set(i);
						System.out.println("Producer set: " + i);
						i++;
						counter.notify();
					}
					else{
						System.out.println("Producer is waiting");
						counter.wait();	
					}
				}
			}
		}catch(Exception ex)
		{
			System.out.println("Producer error:"+ex);
		}
	}
}

class Consumer extends Thread
{
	private Counter		counter;
	private int		i;

	public Consumer(Counter	counter)
	{
		this.counter=counter;
		i=0;
	}

	public void run()
	{
		try{
			while(i<10)
			{
				synchronized (counter)
				{
					if(counter.getIsValueSet())
					{
						System.out.println("Consumer:"+counter.get());
						i++;
						counter.notify();
					}	
					else
					{
						System.out.println("Consumer waiting for producer to set value");
						counter.wait();
					}
					
				}
			}
		}catch(Exception ex)
		{
			System.out.println("Consumer error :"+ ex);
		}
	}
}


class program
{
	public static void main(String args[])
	{
		Counter		counter=new Counter();
		Producer	p=new Producer(counter);
		Consumer	c=new Consumer(counter);
		
		c.start();
		p.start();
		try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            
        }
		
	}
}
