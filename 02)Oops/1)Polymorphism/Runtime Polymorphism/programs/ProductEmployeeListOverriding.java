class product11
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
class employee11 extends product11
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
class list11
{
	private product11 l[];
	private int count;
	public list11()
	{
		l=new product11[2];
	}
	public void add(product11 obj) 
	{
            l[count++] = obj;
    }
	public product11 get()
	{
		return l[--count];
	}
}
class pro3
{
	public static void main(String args[])
	{
		product11 p=new product11();
		list11 l=new list11();
		employee11 e=new employee11();
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
//output1105
//karthik
//123.43
//1124
//aasri
//1234.43
//This is output :
//1124 aasri 1234.430000
//1105 karthik 123.430000
