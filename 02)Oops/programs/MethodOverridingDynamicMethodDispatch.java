class parent3
{
	public void print()
	{
		System.out.println("From parent class");
	}
}
class child extends parent3
{
	public void print()
	{
		System.out.println("From child class");
	}
}
class pro1
{
	public static void main(String args[])
	{
		parent3 p=new parent3();
		p.print();
		p=new child();
		p.print();
	}
}
//output
//From parent class
//From child class
/*Notes:
This program showcases method overriding in Java.

It illustrates how dynamic method dispatch works, where the actual method that gets called is determined at runtime based on the object, not the reference type.

This is a fundamental concept in achieving polymorphism in object-oriented programming*/
