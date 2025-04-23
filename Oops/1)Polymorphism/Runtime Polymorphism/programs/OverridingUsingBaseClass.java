class base
{
	public void print()
	{}
}
class product extends base
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
class employee extends base
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
class list
{
	private base l[];
	private int count;
	public list()
	{
		l=new base[2];
	}
	public void add(base obj) 
	{
            l[count++] = obj;
    }
	public base get()
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
		System.out.println("This is output :");
		for(int i=0;i<2;i++)
		{
			l.get().print();
			
		}
	}
}
This is output :
1124 aasri 1234.432000
1105 karthik 123.432000
