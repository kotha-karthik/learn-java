abstract class Iterator
{
	public abstract boolean hasnext();
	public abstract int next();
}
class stack extends Iterator
{
	private int l[];
	private int count;
	public stack()
	{
		l=new int[5];
		count=0;
	}
	public void push(int val)
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
	public int pop()
	{
		if(count==0)
		{
			System.out.println("The stack is empty");
			return -1;
		}
		
		return l[--count];
		
	}
	public boolean isEmpty()
	{
		return l.length==count;
	}
	public boolean hasnext()
	{
		return count>0;
	}
	public int next()
	{
		if(count==0)
		{
			return -1;
		}
		else
		{
			return l[--count];
		}
	}
}
class queue extends Iterator
{
	private int q[];
	private int rear,front;
	public queue()
	{
		q=new int[5];
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
	public int dequeue()
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
	public int next()
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
}
class linkedlist extends Iterator
{
	private class Node {
        int data;
        Node next;
        Node(int val) {
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

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail =front= newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
		front=head;
    }

    public int delete() {
        if (head == null) {
            System.out.println("The linked list is empty");
            return -1;
        } else {
            int val = head.data;
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
	public int next()
	{
		if(front==null)
		{
			return -1;
		}
		int val = front.data;
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
		stack s=new stack();
		Iterator itr;
		//itr=s;
		/*s.push(100);
		s.push(123);
		s.push(789);
		s.push(435);
		s.push(987);
		while(itr.hasnext())
		{
			System.out.println(itr.next());
		}*/
		/*for(int i=0;i<5;i++)
		{
			System.out.println(s.pop());
		}
		System.out.println(s.isEmpty());*/
		
		/*queue q=new queue();
		q.enqueue(100);
		q.enqueue(200);
		q.enqueue(300);
		q.enqueue(400);
		q.enqueue(500);
		itr=q;
		while(itr.hasnext())
		{
			System.out.println(itr.next());
		}*/
		/*for(int i=0;i<5;i++)
		{
			System.out.println(q.dequeue());
		}*/
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
		
        /*while (!l.isEmpty()) 
		{
            System.out.println(l.delete());
        }*/
	}
}
