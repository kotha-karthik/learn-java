import java.io.*;
class ListFileNameSize
{
	public static void main(String args[])
	{
		
		String[]	files;
		File		file=new File("d:\\java_class\\collections");
		files=file.list();
		for(String f:files)
		{
			System.out.println(file.getPath()+"//"+f);
			File file1=new File(file.getPath()+"//"+f);
			if(file1.isFile())
			{
				System.out.println(file1+"    "+file1.length());
			}
			else
			{
				System.out.println("it is not a file");
			}
		}

		
	}
}
