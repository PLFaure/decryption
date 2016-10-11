package decryption;

import java.util.*;

public class Pattern {
	public String word;
	public int occurrence;
	public List<Integer> positions;
	
	public Pattern(String word, int position)
	{
		this.word = word;
		this.occurrence = 1;
		this.positions = new ArrayList<Integer>();
		this.positions.add(position);
	}
	
	public boolean increment(int position)
	{
		this.occurrence++;
		return this.positions.add(position);
	}
	
	@Override
	public String toString()
	{
		return "Word: " + this.word + " ; occurrence: " + this.occurrence + " ; Positions: " + this.positions.toString() + "\n";
	}
}
