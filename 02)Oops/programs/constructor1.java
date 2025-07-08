class constructor
{
	public constructor()// constructor without parameter's
	{
		System.out.println("Welcome to Constructor");
	}
}
class prog
{
	public static void main(String [] args)
	{
		constructor c ;//this null object. when we create an object,the constructor is not invoked. only object is created.
		c=new constructor();// the instance is created when the constructor is properly invoked.
		// the constructor are invoked when the instance of an object is created.
		// if we wont write any constructor,the default constructor are invoked by the complier.
	}
}
//output::
//Welcome to Constructor
