package desing.pattern.simplefactory.sample02;

public class Administrator extends User
{
	public Administrator()
	{
		System.out.println("Administrator");
	}
	
	public void diffOperation() {
		System.out.println("diffOperation");
	}
}