interface  Iterator
{
	boolean hasnext();
	Object next();
}
class stackinterface implements Iterator
{
	private Object l[];
	private int count;
	public stackinterface()
	{
		l=new Object[5];
		count=0;
	}
	public void push(Object val)
	{
		if(count==l.length)
		{
			System.out.println("The stack is full");
		}
		else
		{
			l[count++]=val;
		}
	}
	public Object pop()
	{
		if(count==0)
		{
			System.out.println("The stack is empty");
			return null;
		}
		
		return l[--count];
		
	}
	public boolean isEmpty()
	{
		return count==0;
	}
	public boolean hasnext()
	{
		return count>0;
	}
	public Object next()
	{
		if(!hasnext())
		{
			return null;
		}
		else
		{
			return l[--count];
		}
	}
	public Iterator iterator()
	{
		count=l.length;
		return this;
	}
}
class queue implements Iterator
{
	private Object q[];
	private int rear,front;
	public queue()
	{
		q=new Object[5];
		front=0;
		rear=0;
	}
	public void enqueue(int val)
	{
		if(rear==q.length)
		{
			System.out.println("The queue is full");
		}
		else
		{
				q[rear++]=val;
		}
	}
	public Object dequeue()
	{
		if(rear==0)
		{
			System.out.println("The queue is empty");
			return -1;
		}
		
		return q[front++];
		
	}
	public boolean isEmpty()
	{
		return q.length==rear;
	}
	public boolean hasnext()
	{
		return front<rear;
	}
	public Object next()
	{
		if(front>=rear)
		{
			return -1;
		}
		else
		{
			return q[front++];
		}
	}
	public Iterator iterator()
	{
		front=0;
		rear=q.length;
		return this;
	}
}
class linkedlist implements Iterator
{
	private class Node {
        Object data;
        Node next;
        Node(Object val) {
            data = val;
            next = null;
        }
    }

    private Node head, tail,front;

    public linkedlist() {
        head = null;
        tail = null;
		front=null;
    }

    public void insert(Object val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail =front= newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
		front=head;
    }

    public Object delete() {
        if (head == null) {
            System.out.println("The linked list is empty");
            return -1;
        } else {
            Object val = head.data;
            head = head.next;
			front=head;
            return val;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
	public boolean hasnext()
	{
		return front!=null;
	}
	public Object next()
	{
		if(front==null)
		{
			return -1;
		}
		Object val = front.data;
        front= front.next;
        return val;
	}
	public Iterator iterator()
	{
		front=head;
		return this;
	}
}
class program1
{
	public static void main(String args[])
	{
		Iterator itr;
		stackinterface s=new stackinterface();
		
		s.push(100);
		s.push(123);
		s.push(789);
		s.push(435);
		s.push(987);
		itr=s.iterator();
		while(itr.hasnext())
		{
			System.out.println(itr.next());
		}	
		queue q=new queue();
		q.enqueue(100);
		q.enqueue(200);
		q.enqueue(300);
		q.enqueue(400);
		q.enqueue(500);
		itr=q.iterator();
		while(itr.hasnext())
		{
			System.out.println(itr.next());
		}
		itr=q.iterator();
		while(itr.hasnext())
		{
			System.out.println(itr.next());
		}
		linkedlist l = new linkedlist();
        l.insert(10);
        l.insert(20);
        l.insert(30);
        l.insert(40);
        l.insert(50);
		itr=l.iterator();
		while (itr.hasnext()) 
		{
			System.out.println(itr.next());
		}
		
		itr=l.iterator();
		System.out.println("This second time:");
		while (itr.hasnext()) 
		{
			System.out.println(itr.next());
		}
		
	}
}
