package selenium_java_Concepts;

public class SingletonExample {
	
	private static SingletonExample SingletonObj=null;
	String str;
	
	private SingletonExample()
	{
		str="Singleton class";
	}
	
	
	public static SingletonExample getInstance()
	{
		if(SingletonObj==null)
		{
			SingletonObj=new SingletonExample();
		}
		
		return SingletonObj;
	}

	public static void main(String[] args) {
	
		SingletonExample x=SingletonExample.getInstance();
		SingletonExample y=SingletonExample.getInstance();
		SingletonExample z=SingletonExample.getInstance();
		
		x.str=x.str.toUpperCase();
		
		System.out.println(x.str);
		System.out.println(y.str);
		System.out.println(z.str);
		
		z.str=z.str.toLowerCase();

		System.out.println(x.str);
		System.out.println(y.str);
		System.out.println(z.str);
	}

}
