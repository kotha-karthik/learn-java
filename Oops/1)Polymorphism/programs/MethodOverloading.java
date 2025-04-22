/*Polymorphism method overloading*/
class Math
{
	public int sum(int x,int y)
	{
		return x+y;
	}
	public float sum(float x, float y)
	{
		return x+y;
	}
	public double sum(double x,double y)
	{
		return x+y;
	}
	public int sum(int x,int y,int z)
	{
		return x+y+z;
	}
	public int sum(int x,String y)
	{
		return (x+Integer.parseInt(y));
	}
	public int sum(String x,int y)
	{
		return (Integer.parseInt(x)+y);
	}
	public String sum(String x,String y)
	{
		return x+y;
	}
}
class driver
{
	public static void main(String[] args)
	{
		Math m= new Math();
		System.out.println("Math method with int parameters: "+m.sum(100,200));
		System.out.println("Math method with float parameters: "+m.sum(10.890f,20.34f));
		System.out.println("Math method with double parameters: "+m.sum(100.789,200.12345));
		System.out.println("Math method with String parameters: "+m.sum("100","200"));
		System.out.println("Math method with string ,int parameters: "+m.sum("100",200));
		System.out.println("Math method with int,string parameters: "+m.sum(100,"200"));
		System.out.println("Math method with three int parameters: "+m.sum(100,200,500));
	}
}
