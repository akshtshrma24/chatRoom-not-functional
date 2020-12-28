import java.util.Scanner;
public class userName 
{
	String userName;
	public userName()
	{
		System.out.print("Enter A UserName ");
		Scanner in = new Scanner(System.in);
		userName = in.nextLine();
	}
	public String getUserName()
	{
		return userName;
	}
}
