class stack
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
}
class queue
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
}
class linkedlist
{
	private class Node {
        int data;
        Node next;
        Node(int val) {
            data = val;
            next = null;
        }
    }

    private Node head, tail;

    public linkedlist() {
        head = null;
        tail = null;
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int delete() {
        if (head == null) {
            System.out.println("The linked list is empty");
            return -1;
        } else {
            int val = head.data;
            head = head.next;
            return val;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
class program
{
	public static void main(String args[])
	{
		/*stack s=new stack();
		s.push(100);
		s.push(123);
		s.push(789);
		s.push(435);
		s.push(987);
		for(int i=0;i<5;i++)
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
		for(int i=0;i<5;i++)
		{
			System.out.println(q.dequeue());
		}*/
		linkedlist l = new linkedlist();
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
