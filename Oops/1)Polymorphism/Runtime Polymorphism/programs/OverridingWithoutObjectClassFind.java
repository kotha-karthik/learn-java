// writting a program without using the object class and using the primitive data type class for the overriding the class. we are implenting the find method for find the int,object inside id with the find method
class baseobj1
{
	public void print()
	{}
	public int getid()
	{
		return 0;
	}
}
class product1 extends baseobj1
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
class employee1 extends baseobj1
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
class MyInteger1 extends baseobj1
{
	private int x;
	public MyInteger1(int val)
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
class MyDouble1 extends baseobj1
{
	private Double x;
	public MyDouble1(double val)
	{
		x=val;
	}
	public void print()
	{
		System.out.println(x);
	}
}
class MyString1 extends baseobj1
{
	private String x;
	public MyString1(String val)
	{
		x=val;
	}
	public void print()
	{
		System.out.println(x);
	}
}
class list1
{
	private baseobj1 l[];
	private int count;
	public list1()
	{
		l=new baseobj1[5];
	}
	public void add(baseobj1 obj) 
	{
            l[count++] = obj;
    }
	public baseobj1 get()
	{
		return l[--count];
	}
	public baseobj1 find(int val)
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
}
class pro2
{
	public static void main(String args[])
	{
		product1 p=new product1();
		list1 l=new list1();
		employee1 e=new employee1();
		p.read();
		e.read();
		l.add(p);
		l.add(e);
		l.add(new MyInteger1(100));
		l.add(new MyDouble1(123.45));
		l.add(new MyString1("Karthik"));
		System.out.println("This is output :");
		for(int i=0;i<5;i++)
		{
			l.get().print();
			
		}
		l.find(100).print();
		l.find(1105).print();
	}
}
//output:
//1105
//karthik
//123.43
//1124
//Institute
//234.543
//This is output :
//Karthik
//123.45
//100
//1124 Institute 234.543000
//1105 karthik 123.430000
//after finding
//100
//1105 karthik 123.430000
