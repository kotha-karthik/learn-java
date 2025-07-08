//Hashtable: is a collection of key and values pairs. key can be anything , value can be anything ( any object which override hascode method).

import java.util.*;

class program
{
	public static void main(String args[])
	{
		Hashtable<Integer,String>	ht;
		ht=new Hashtable<Integer,String>();
		ht.put(1,"One");
		ht.put(2,"Two");
		ht.put(3,"Three");
		
		System.out.println(ht.get(2));

		Enumeration<Integer>	e;
		e=ht.keys();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}

		Collection<String>	 c=ht.values();
		Iterator<String>	itr=c.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

		String str="Karthik";
		System.out.println(str.charAt(0));
	
		System.out.println(ht.containsKey(2));
		
	}
}
