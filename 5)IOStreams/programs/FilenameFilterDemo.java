//fetch files with extension from commandline passing to the implemented class
import java.io.*;

class FilterByExtension implements FilenameFilter
{
	private String ext;
	
	public FilterByExtension(String e)
	{
		ext=e;
	}
        
	public boolean accept(File dir,String name)
	{
		if(name.endsWith(ext))
		{
			return true;
		}

		return false;
	}
	
}

class FilenameFilterDemo
{
	public static void main(String args[])
	{
		File	file=new File(args[0]);

		FilenameFilter filter=new FilterByExtension(args[1]);//input is taken from the command line

		File	[]filesfolders=file.listFiles(filter);// the accept method is called by the listfiles automatically. we no neeed to call the accept method. 
		
		for(File ff : filesfolders)
		{
			if(ff.isFile())
			{
				System.out.println(ff.getName() + ","+ff.length());
			}
		}
	}
}
