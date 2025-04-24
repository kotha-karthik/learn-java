// print linkedlist using the forEach. loop we need to implement the iterator,iterable interfaces.
import java.util.*;
class linkedlistforEach<T> implements Iterable<T>,Iterator<T>
{
	private T data;
	private linkedlistforEach<T> next,prev,first,head,nw; 
	public void insert(T val)
	{
		linkedlistforEach<T> nw=new linkedlistforEach<T>();
		nw.data=val;
		if(head==null)
		{
			head=nw;
			first=nw;
		}
		else
		{
			prev.next=nw;
		}
		prev=nw;
	}
	public T delete() {
        if (head== null) {
            System.out.println("The linked list is empty");
            return null;
        } else {
            T val = head.data;
            head = head.next;
            return val;
        }
    }
	public boolean isEmpty() {
        return head == null;
    }
	public boolean hasNext()
	{
		return head!=null;
	}
	public T next()
	{
		if(!hasNext())
		{
			return null;
		}
		T val = head.data;
        head= head.next;
        return val;
	}
	public Iterator<T> iterator()
	{
		head=first;
		return (Iterator<T>)this;
	}
}
class program
{
	public static void main(String args[])
	{
		linkedlistforEach<Integer> li= new linkedlistforEach<Integer>();
		li.insert(10);
		li.insert(20);
		li.insert(30);
		li.insert(40);
		li.insert(50);
		
		for(Integer i:li)
		{
			System.out.println(i);
		}
		
	}
}
