class parent4
{
	public void print()
	{
		System.out.println("From parent class");
	}
	/*public void print(int val){}*/ 
}
class child extends parent4
{
	public void print()//override's the method
	{
		System.out.println("From child class");
	}
	public void print(int val)//overload's the method
	{
		System.out.println("From child class with parameter "+val);
	}
}
class pro1
{
	public static void main(String args[])
	{
		parent4 p=new parent4();
		p.print();
		p=new child();
		p.print();
		((child)p).print(100);//downcasting
	}
}
//output:
//From parent class
//From child class
//From child class with parameter 100

/*Notes:
Reference Type Determines Accessible Members at Compile Time
➤ Java follows these rules:
The compiler uses the reference type to check what methods/fields are accessible.

The actual method that gets called at runtime depends on the object type (for overridden methods only).*/
