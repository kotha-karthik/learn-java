class parent1
{
	public parent1(int val)
	{
		System.out.println("This is parent constructor "+val);
	}
	public parent1()
	{
		System.out.println("This is parent constructor ");
	}
}
class child extends parent1
{
	public child(int val)
	{
		super(100);
		System.out.println("This is child constructor "+val);
	}
}
class pro
{
	public static void main(String[] args)
	{
		parent1 p;
		child c;
		p=new parent1(100);
		c=new child(50);// passing without default construtor in the parent gives us the error. in parent we must and shld have the defalut constructor which is invoked when the child construcotr is called. if we to use the parameter constructor we need to use the super keyword for it.
	}
}
/*In Java, when a child class constructor is called, the parent class constructor is automatically called before the child’s constructor body executes.
This is to make sure the base class is properly initialized before the subclass adds its own behavior.*/
/*If the parent class doesn't have a default (no-arg) constructor, and you don't explicitly call super(...), Java will try to insert super() by default.
If that default constructor doesn't exist, you'll get a compilation error.*/
