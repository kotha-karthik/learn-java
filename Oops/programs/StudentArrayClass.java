class Student1
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
		System.console().printf("%d  %s  %f",sno,sname,fee);
	}
}
class program1
{
	public static void main(String args[])
	{
		/* reading and writing a array of  student*/
		Student1 s[];/* used to declare the type of variable(object)*/
		s=new Student1[2];
		for(int i=0;i<s.length;i++)
		{
			s[i]=new Student1();/*creating the instance for all the array of object special in java*/
		}
		for(int i=0;i<s.length;i++)
		{
			s[i].read();
		}
		for(int i=0;i<s.length;i++)
		{
			s[i].write();
		}
		
	}
	
}
