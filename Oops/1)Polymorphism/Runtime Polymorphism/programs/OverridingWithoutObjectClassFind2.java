// writting a program without using the object class and using the primitive data type class for the overriding the class. we are implenting the find method for find the int,object inside id with the find method for also double,String also.
class baseobj2
{
	public void print()
	{}
	public int getid()
	{
		return 0;
	}
	public String getString()
	{ 
		return null;
	}
	public double getDouble()
	{
		return 0.0;
	}
}
class product2 extends baseobj2
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
	public int getid()
	{
		return pid;
	}
}
class employee2 extends baseobj2
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
	public int getid()
	{
		return eid;
	}
	

}
class MyInteger2 extends baseobj2
{
	private int x;
	public MyInteger2(int val)
	{
		x=val;
	}
	public void print()
	{
		System.out.println(x);
	}
	public int getid()
	{
		return x;
	}
}
class MyDouble2 extends baseobj2
{
	private Double x;
	public MyDouble2(double val)
	{
		x=val;
	}
	public void print()
	{
		System.out.println(x);
	}
	public double getDouble()
	{
		return x;
	}
}
class MyString2 extends baseobj2
{
	private String x;
	public MyString2(String val)
	{
		x=val;
	}
	public void print()
	{
		System.out.println(x);
	}
	public String getString()
	{
		return x;
	}
}
class list2
{
	private baseobj2 l[];
	private int count;
	public list2()
	{
		l=new baseobj2[5];
	}
	public void add(baseobj2 obj) 
	{
            l[count++] = obj;
    }
	public baseobj2 get()
	{
		return l[--count];
	}
	public baseobj2 find(int val)
	{
		for(int i=0;i<l.length;i++)
		{
			if(l[i].getid()==val)
			{
				return l[i];
			}
		}
		return null;
	}
	public baseobj2 find(double val)
	{
		for(int i=0;i<l.length;i++)
		{
			if(l[i] instanceof MyDouble2)
			{
				if(l[i].getDouble()==val)
				{
					return l[i];
				}
			}
		}
		return null;
	}
	public baseobj2 find(String val)
	{
		for(int i=0;i<l.length;i++)
		{
			if(l[i] instanceof MyString2)
			{
				if(l[i].getString().equalsIgnoreCase(val))
				{
					return l[i];
				}
			}
		}
		return null;
	}
}
class pro3
{
	public static void main(String args[])
	{
		product2 p=new product2();
		list2 l=new list2();
		employee2 e=new employee2();
		p.read();
		e.read();
		l.add(p);
		l.add(e);
		l.add(new MyInteger2(100));
		l.add(new MyDouble2(123.45));
		l.add(new MyString2("Karthik"));
		System.out.println("This is output :");
		for(int i=0;i<5;i++)
		{
			l.get().print();
			
		}
		System.out.println("Finding the int object :");
		l.find(100).print();
		System.out.println("Finding the employee object :");
		l.find(1105).print();
		System.out.println("Finding the String object :");
		l.find("karthik").print();
		System.out.println("Finding the double object :");
		l.find(123.45).print();
	}
}
//output:
/*1105
karthik
123.45
1124
Institute
123.87
This is output :
Karthik
123.45
100
1124 Institute 123.870000
1105 karthik 123.450000
Finding the int object :
100
Finding the employee object :
1105 karthik 123.450000
Finding the String object :
Karthik
Finding the double object :
123.45*/
