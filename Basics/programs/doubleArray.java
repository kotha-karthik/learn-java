class doubleArray
{
	public static void main(String args[])
	{
		int x[][],n;
		System.out.print("Enter the size of array:");
		n=Integer.parseInt(System.console().readLine());
		x=new int[n][];
		for(int i=0;i<x.length;i++)
		{
			x[i]=new int[i+1];
			for(int j=0;j<x[i].length;j++)
			{
				x[i][j]=j+1;
			}
		}
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x[i].length;j++)
			{
				System.out.print(x[i][j]+" ");
			}
			System.out.println();
		}
	}
}