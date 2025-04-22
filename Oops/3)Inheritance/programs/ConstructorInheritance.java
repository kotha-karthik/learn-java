class parent
{
	public parent()
	{
		System.out.println("This is parent constructor");
	}
}
class child extends parent
{
	public child()
	{
		System.out.println("This is child constructor");
	}
}
class pro
{
	public static void main(String[] args)
	{
		parent p;
		child c;
		p=new parent();
		c=new child();
	}
}
//output
//This is parent constructor
//This is parent constructor
//This is child constructor
