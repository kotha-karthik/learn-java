class MyException extends RuntimeException
{
	private String msg;
	public MyException(String msg)
	{
		this.msg=msg;
	}
	public String getMessage()
	{
		return msg;
	}
}
class Array
{
	private int x[];
	private int i;
	public Array()
	{
		x=new int[3];
		i=0;
	}
	public void add(int n)throws MyException
	{
		if(i>=x.length)
		{
			MyException me=new MyException("Array is Full");
			throw me;
		}else{
			x[i]=n;
			i++;
		}
	}
	public int get()throws MyException
	{
		if(i<=0)
		{
			MyException me=new MyException("Array is Empty");
			throw me;
		}
		return x[--i];
	}
	
}
class UnCheckedDemo
{
	public static void main(String args[])
	{
		Array a=new Array();
		try{
			a.add(100);
			a.add(200);
			a.add(300);
			a.add(400);
		}catch(MyException ex)
		{
			System.out.println(ex.getMessage());
		}
		try{
			for(int j=0;j<5;j++)
			{
				System.out.println(a.get());
			}
		}catch(MyException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
