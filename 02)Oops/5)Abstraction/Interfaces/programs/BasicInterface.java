interface Myinterface1
{
	int sum(int x,int y);
}
interface Myinterface2 extends Myinterface1
{
	int sub(int x,int y);
}
interface Myinterface3
{
	int mul(int x,int y);
}
class Math1 implements Myinterface2,Myinterface3
{
	public int sum(int x,int y)
	{
		return (x+y);
	}
	public int sub(int x,int y)
	{
		return (x-y);
	}
	public int mul(int x,int y)
	{
		return (x*y);
	}
	public int div(int x,int y)
	{
		return (x/y);
	}
}
class program
{
	public static void main(String args[])
	{
		Math1 m=new Math1();
		Myinterface1 m1;
		Myinterface2 m2;
		Myinterface3 m3;
		m1=m;
		System.out.println(m1.sum(100,200));
		m2=m;
		System.out.println(m2.sub(200,100));
		System.out.println(m2.sum(200,100));
		m3=m;
		System.out.println(m3.mul(100,200));
		System.out.println(((Math1)m3).div(200,100));
	}
}
