// writting a program without using the object class and using the primitive data type class for the overriding the class.
class baseobj
{
	public void print()
	{}
}
class product extends baseobj
{
	private int pid;
	private String pname;
	private double price;
	public void read()
	{
		pid=Integer.parseInt(System.console().readLine());
		pname=System.console().readLine();
		price=Double.parseDouble(System.console().readLine());
	}
	public void print()
	{
		System.out.printf("%d %s %f\n",pid,pname,price);
	}
}
class employee extends baseobj
{
	private int eid;
	private String ename;
	private double salary;
	public void read()
	{
		eid=Integer.parseInt(System.console().readLine());
		ename=System.console().readLine();
		salary=Double.parseDouble(System.console().readLine());
	}
	
	public void print()
	{
		System.out.printf("%d %s %f\n",eid,ename,salary);
	}
	

}
class MyInteger extends baseobj
{
	private int x;
	public MyInteger(int val)
	{
		x=val;
	}
	public void print()
	{
		System.out.println(x);
	}
}
class MyDouble extends baseobj
{
	private Double x;
	public MyDouble(double val)
	{
		x=val;
	}
	public void print()
	{
		System.out.println(x);
	}
}
class MyString extends baseobj
{
	private String x;
	public MyString(String val)
	{
		x=val;
	}
	public void print()
	{
		System.out.println(x);
	}
}
class list
{
	private baseobj l[];
	private int count;
	public list()
	{
		l=new baseobj[5];
	}
	public void add(baseobj obj) 
	{
            l[count++] = obj;
    }
	public baseobj get()
	{
		return l[--count];
	}
}
class pro
{
	public static void main(String args[])
	{
		product p=new product();
		list l=new list();
		employee e=new employee();
		p.read();
		e.read();
		l.add(p);
		l.add(e);
		l.add(new MyInteger(100));
		l.add(new MyDouble(123.45));
		l.add(new MyString("Karthik"));
		System.out.println("This is output :");
		for(int i=0;i<5;i++)
		{
			l.get().print();
			
		}
	}
}
//output:
//This is output :
//Karthik
//123.45
//100
//1124 Institute 123.430000
//1105 karthik 123.430000
