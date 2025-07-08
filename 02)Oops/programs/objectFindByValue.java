class product1
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
	public int getpid()
	{
		return pid;
	}
	public boolean equals(Object obj) {
		
			return obj.equals(pid);
		
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
	public int geteid()
	{
		return eid;
	}
	public boolean equals(Object obj) {
		return obj.equals(eid);
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
	public Object find(int val)
	{
		for(int i=0;i<l.length;i++)
		{
			if(l[i].equals(val))
			{
				return l[i];
		    }
		
	    }
		return null;
    }
}
class pro1
{
	public static void main(String args[])
	{
		product1 p=new product1();
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
		System.out.print(l.find(1105).toString());
	}
}
/*
output
1105
karthik
1234.432
1124
aasri
1234.54
This is output of the Object class:
67.98
100
1124 aasri 1234.54
1105 karthik 1234.432
1105 karthik 1234.432*/
