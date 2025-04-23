class product
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
	public String toString()
	{
		return pid+" "+pname+" "+price;
	}
}
class employee
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
	public String toString()
	{
		return eid+" "+ename+" "+salary;
	}

}
class list
{
	private Object l[];
	private int count;
	public list()
	{
		l=new Object[4];
	}
	public void add(Object obj) 
	{
            l[count++] = obj;
    }
	public Object get()
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
		l.add(100);
		l.add(67.98);
		System.out.println("This is output of the Object class:");
		for(int i=0;i<4;i++)
		{
			Object obj = l.get();
			System.out.println(obj);
			
		}
	}
}
/*output:
This is output of the Object class:
67.98
100
1124 aasri 123.432
1105 karthik 1234.543*/
