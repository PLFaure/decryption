package decryption;

public class Distance {
	public int value;
	public int occurrence;
	
	public Distance(int value)
	{
		this.value = value;
		this.occurrence = 1;
	}
	
	public void increment()
	{
		this.occurrence++;
	}
}
