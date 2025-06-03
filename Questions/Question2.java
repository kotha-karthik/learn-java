class Test
{
	void msg()
	{
		System.out.println("Hello from class1");
	}
}

class Test2 extends Test
{
	@Override
	void msg()
	{
		System.out.println("Hello from class2");
	}
	public static void main(String args[])
	{
		Test2 abc=new Test2();
		abc.msg();
	}
}
