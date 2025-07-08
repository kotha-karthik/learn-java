// the folder and file both are same the folder is nothing but it conatins the information of the files. the operating system see the files and folders both as files only
import java.io.*;

class ListFilesFolders
{
	public static void main(String args[])
	{
		String[]	files_folders;
		File		file=new File("d:\\java_class");
		files_folders=file.list();
		for(String ff : files_folders)
		{
			System.out.println(ff);
		}
	}
}
