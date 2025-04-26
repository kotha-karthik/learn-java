// creating a PhoneBook using the hashtable
import java.util.*;
class PhoneBook
{
	private String name,phonenumber;
	public PhoneBook(String name,String phonenumber)
	{
		this.name=name;
		this.phonenumber=phonenumber;
	}
	public Character getFirstChar()
	{
		return name.charAt(0);
	}
	public String getName()
	{
		return name;
	}
	public String getPhonenumber()
	{
		return phonenumber;
	}
	
}
class List
{
	public static void main(String[] args)
	{
		
		Hashtable<Character,LinkedList<PhoneBook>> li=new Hashtable<Character,LinkedList<PhoneBook>>();
		String name,number;
		int val=-1;
		while(val!=0)
		{
			System.out.println("Enter 1 to add the number");
			System.out.println("Enter 2 to display the hashtable");
			System.out.println("Enter 0 to exit");
			val=Integer.parseInt(System.console().readLine());
			if(val==1)
			{
				name=System.console().readLine();
				number=System.console().readLine();
				PhoneBook pb=new PhoneBook(name,number);
				Character firstChar = pb.getFirstChar();
                if(!li.containsKey(firstChar)) 
				{
                    li.put(firstChar, new LinkedList<PhoneBook>());
                }
                li.get(firstChar).add(pb);
            }
			else if(val==2)
			{
				for(Character c:li.keySet())
				{
					System.out.println(c);
					LinkedList<PhoneBook> contact = li.get(c);
					for (PhoneBook con : contact) {
						System.out.println(con.getName() + ": " + con.getPhonenumber());
					}
				}
			}    
        }	
	}	
}
