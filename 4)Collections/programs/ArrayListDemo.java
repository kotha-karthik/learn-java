import java.util.*;

class program
{
	public static void main(String args[])
	{
		ArrayList<Integer>	al;
		al=new ArrayList<Integer>();
		
		al.add(100);
		al.add(200);
		
		al.add(300);

		al.add(2,250);
		
		System.out.println(al.get(2));

		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}

		Iterator<Integer>	itr;
		itr=al.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

		al.remove(2);	//index

		al.remove(Integer.valueOf(100));

		//for each loop
		for(Integer item : al)
		{
			System.out.println(item);
		}

		System.out.println(al.indexOf(250));

		Object []arr=al.toArray();
		
		for(Object item : arr)
		{
			System.out.println(item instanceof Integer);
			System.out.println(item.toString());
		}
		
	}
}
