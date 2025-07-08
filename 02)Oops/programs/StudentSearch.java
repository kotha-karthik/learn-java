class Student2
{
	private int sno;
	private String sname;
	private double fee;
	public void read()
	{
		sno=Integer.parseInt(System.console().readLine());
		sname=System.console().readLine();
		fee=Double.parseDouble(System.console().readLine());
	}
	public void write()
	{
		System.console().printf("%d  %s  %f\n",sno,sname,fee);
	}
	public int getroll()
	{
	    return sno;
	}
}
class program2
{
	public static void main(String args[])
	{
		/* reading and writing a array of  student*/
		Student2 s[];/* used to declare the type of variable(object)*/
		s=new Student2[2];
		for(int i=0;i<s.length;i++)
		{
			s[i]=new Student2();/*creating the instance for all the array of object special in java*/
		}
		for(int i=0;i<s.length;i++)
		{
			s[i].read();
		}
		for(int i=0;i<s.length;i++)
		{
			s[i].write();
		}
		System.out.println("\nEnter the sno for searching the sno:");
		int search=Integer.parseInt(System.console().readLine());
		int i;
		for(i=0;i<s.length;i++)
		{
			if(s[i].getroll()==search)
			{
				s[i].write();
				break;
			}
		}
		if(i==s.length)
		{
			System.out.println("Not Found");
		}
	}
	
}
