import java.util.*;

class program
{
	public static void main(String args[])
	{
		LinkedList<Integer>	list=new LinkedList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.addFirst(50);
		list.addLast(350);
		list.push(400);
		list.push(500);


		System.out.println(list.getFirst());

		Iterator<Integer>	itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

		itr=list.descendingIterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

		while(list.size()>0)
		{
			System.out.println(list.pop());
		}
	}
}
