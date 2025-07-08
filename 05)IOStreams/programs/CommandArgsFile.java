import java.io.*;
class commandargs
{
	public static void main(String args[])
	{
		for(int i=0;i<args.length;i++)
		{
			File file=new File("d:\\java_class\\collections");
			String[] s=file.list();
			for(String str:s)
			{
				if(str.endsWith(args[i]))
				{
					System.out.println(str);
				}
			}
		}
	}
}
