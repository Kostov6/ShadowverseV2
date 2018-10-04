package command;

public class Main {

	public static String fu(int a,String b)
	{
		return ""+a+":"+b;
	}
	
	public static void main(String[] args) {
		CommandManager m=new CommandManager();
		
		m.addCommand("a", (String[] ar) -> {
			int a=Integer.parseInt(ar[0]);
			String b=ar[1];
			return fu(a,b);
		} );
		
		System.out.println(m.execute(new String("a 1 asdasda").split(" ")));
	}

}
