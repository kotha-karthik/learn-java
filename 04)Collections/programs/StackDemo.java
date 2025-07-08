import java.util.*;

class program
{
	public static void main(String args[])
	{
		Stack<String>	stk=new Stack<String>();
		
		stk.push("one");
		stk.push("two");
		stk.push("three");
		
		while(!stk.empty())
		{
			System.out.println(stk.pop());
		}
	}
}
