import java.io.*;
class FileCopy
{
	public static void main(String args[]) throws IOException
	{
		FileInputStream fin=new FileInputStream("new.txt");
		FileOutputStream fout=new FileOutputStream("copy.txt");
		//copy character by character
		int x,nbytes;
		/*while((x=fin.read())!=-1)
		{
			fout.write(x);
		}*/
		//copy of array of character's
		byte[] data;
		/*data=new byte[3];
		while((nbytes=fin.read(data))!=-1)
		{
			String str=new String(data,0,nbytes);
			fout.write(str.getBytes());
		}*/
		// copy entire file data
		data=new byte[1024];
		while((nbytes=fin.read(data))!=-1)
		{
			String str=new String(data,0,nbytes);
			fout.write(str.getBytes());
		}
		
	}
}
