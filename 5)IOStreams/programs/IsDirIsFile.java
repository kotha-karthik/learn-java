import java.io.*;
class IsDir
{
	public static void main(String args[])
	{
		
		String[]	files;
		File		file=new File("d:\\java_class");
		files=file.list();
		for(String f:files)
		{
			File file1=new File(file.getPath()+"//"+f);
			if(file1.isDirectory())
			{
					System.out.println("Dir"+" "+file1+"    "+file1.length());
				
			}
			else{
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
}
