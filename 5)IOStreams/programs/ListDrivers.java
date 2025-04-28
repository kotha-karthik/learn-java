import java.io.*;

class ListDrives
{
	public static void main(String args[])
	{
		File	[]drives;

		drives=File.listRoots();
		for(File drive : drives)
		{
			System.out.println(drive.getPath() + "," + drive.getTotalSpace());
		}
	}
}
