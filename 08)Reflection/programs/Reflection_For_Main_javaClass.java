import java.lang.reflect.*;
import java.util.*;
class Reflection
{
	public static Object parseInput(String input, Class<?> type) 
	{
		if (type == int.class || type == Integer.class) return Integer.parseInt(input);
		if (type == double.class || type == Double.class) return Double.parseDouble(input);
		if (type == float.class || type == Float.class) return Float.parseFloat(input);
		if (type == long.class || type == Long.class) return Long.parseLong(input);
		if (type == boolean.class || type == Boolean.class) return Boolean.parseBoolean(input);
		if (type == char.class || type == Character.class) return input.charAt(0);
		if (type == String.class) return input;
		return null; // unsupported type
	}
	public static void main(String args[])throws Exception
	{
		int choice;
		Scanner scanner=new Scanner(System.in);
		System.out.println("1--> To Get The Info");
		System.out.println("2--> To Get Use Method's");
		System.out.println("3--> Exit");
		while(true)
		{
			choice=Integer.parseInt(System.console().readLine());
			if(choice!=3)
			{
				switch(choice)
				{
					case 1:
						System.out.println("Enter the class name to get the info:");
						String name=System.console().readLine();
						Class<?> clas=Class.forName(name);
						System.out.println("Class Name: " + clas.getName());
						System.out.println("\nFields:");
						System.out.println("-----------------------------------");
						Field[] fields = clas.getDeclaredFields();
						for (Field field : fields) {
							System.out.println("--"+field.getName());
						}
						System.out.println("\nMethods:");
						System.out.println("-----------------------------------");
						Method[] meth = clas.getDeclaredMethods();
						for (Method method : meth) {
							System.out.println("--"+method.getName());
						}
						System.out.println("\nConstructors:");
						System.out.println("-----------------------------------");
						Constructor<?>[] constructors = clas.getDeclaredConstructors();
						for (Constructor<?> constructor : constructors) {
							System.out.println("--"+constructor);
						}
						break;
				    case 2:
						System.out.print("Enter full class name : ");
						String className = System.console().readLine();
						Class<?> cls = Class.forName(className);
						System.out.print("Enter method name: ");
						String methodName = scanner.nextLine();

						Method[] methods = cls.getMethods();
						Method matched=null;
						for (Method m : methods) {
							if (m.getName().equals(methodName)) {
								matched=m;
							}
						}
						Class<?>[] paramTypes = matched.getParameterTypes();
						Object[] paramValues = new Object[paramTypes.length];

						
						for (int i = 0; i < paramTypes.length; i++) {
							System.out.print("Enter value for parameter " + (i + 1) + " (" + paramTypes[i].getSimpleName() + "): ");
							String input = scanner.nextLine();
							paramValues[i] = parseInput(input, paramTypes[i]);
						}
						
						Object obj = cls.newInstance();
						Object result = matched.invoke(obj, paramValues);
						System.out.println("\nOutput: " + result);
						break;
				}
						
			}
			else
			{
				break;
			}
			
		}
	}
}
