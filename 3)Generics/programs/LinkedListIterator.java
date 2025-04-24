interface Iterator<T>
{
	boolean hasNext();
	T		next();
}

class linkedlist2<T> implements Iterator<T>
{
	private T data;
	private linkedlist2<T> next,prev,first,head,nw; 
	public void insert(T val)
	{
		linkedlist2<T> nw=new linkedlist2<T>();
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
		return this;
	}
}
class program
{
	public static void main(String args[])
	{
		Iterator<Integer> itr;
		linkedlist2<Integer> li= new linkedlist2<Integer>();
		linkedlist2<String> ls= new linkedlist2<String>();
		li.insert(10);
		li.insert(20);
		li.insert(30);
		li.insert(40);
		li.insert(50);
		itr=li.iterator();
		while (itr.hasNext()) 
		{
			System.out.println(li.next());
		}
		Iterator<String> itr1;
		ls.insert("karthik");
		ls.insert("hima");
		ls.insert("charan");
		ls.insert("esh");
		ls.insert("dh");
		itr1=ls.iterator();
		while (itr1.hasNext()) 
		{
			System.out.println(ls.next());
		}
		
	}
}
