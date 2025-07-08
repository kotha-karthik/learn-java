class basefind
{
	public void print()
	{}
	public int getid()
	{
		return 0;
	}
}
class product extends basefind
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
class employee extends basefind
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
class list
{
	private basefind l[];
	private int count;
	public list()
	{
		l=new basefind[2];
	}
	public void add(basefind obj) 
	{
            l[count++] = obj;
    }
	public basefind get()
	{
		return l[--count];
	}
	public basefind find(int val)
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
		l.find(1105).print();
	}
}
//output:
//1105
//karthik
//123.987
//1124
//institute
//234.765894
//This is output :
//1124 institute 234.765894
//1105 karthik 123.987000
//1105 karthik 123.987000
