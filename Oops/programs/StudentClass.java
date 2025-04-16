class Student
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
class program
{
	public static void main(String args[])
	{
		/* reading and writing a single student*/
		Student s;/* used to declare the type of variable(object)*/
		s=new Student();/* new keyword is used to allocate the memory and to create the instance inside the memory*/
		s.read();
		s.write();
	}
	
}
