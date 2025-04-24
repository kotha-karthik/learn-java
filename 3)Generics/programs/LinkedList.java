class linkedlist1<T> 
{
	private T data;
	private linkedlist1<T> next,prev,first,nw; 
	public void insert(T val)
	{
		linkedlist1<T> nw=new linkedlist1<T>();
		nw.data=val;
		if(first==null)
		{
			first=nw;
		}
		else
		{
			prev.next=nw;
		}
		prev=nw;
	}
	public T delete() {
        if (first == null) {
            System.out.println("The linked list is empty");
            return null;
        } else {
            T val = first.data;
            first = first.next;
            return val;
        }
    }
	public boolean isEmpty() {
        return first == null;
    }
}
class prog
{
	public static void main(String args[])
	{
		linkedlist1<Integer> l = new linkedlist1<Integer>();
		l.insert(10);
		l.insert(20);
		l.insert(30);
		l.insert(40);
		l.insert(50);
		while (!l.isEmpty()) 
		{
			System.out.println(l.delete());
		}
	}
}
