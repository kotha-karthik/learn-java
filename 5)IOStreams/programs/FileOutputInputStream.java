import java.io.*;
class FileOutputInputStream 
{
	public static void main(String[] args) throws IOException
	{
		FileOutputStream fout=new FileOutputStream("new.txt");
		fout.write(65);// writing a single character into the file
		fout.write(66);
		fout.write(67);
		byte[] data=new byte[]{97,98,99,100};// write with byte array
		fout.write(data,0,data.length);
		fout.write(data);// writes the entire data into the file
		String str=new String("Innovative software solutions");
		fout.write(str.getBytes());
		FileInputStream fin=new FileInputStream("new.txt");
		int x;
		/*while((x=fin.read())!=-1)
		{
			System.out.println((char)x);
		}*/
		int byteread=0;
		data=new byte[3];
		/*while((byteread=fin.read(data))!=-1)
		{
			/*for(int i=0;i<data.length;i++)
			{
				System.out.print((char)data[i]+" ");
			}
			String str1=new String(data,0,byteread);
			System.out.println(str1);
		}*/
		data=new byte[1024];
		while((byteread=fin.read(data))!=-1)
		{
			/*for(int i=0;i<data.length;i++)
			{
				System.out.print((char)data[i]+" ");
			}*/
			String str1=new String(data,0,byteread);
			System.out.println(str1);
		}
		fout.close();
		fin.close();
	}
}
