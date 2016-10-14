package decryption;

import java.util.*;

/**
 * Pattern class.
 * @author Pierre-Louis
 *
 */
public class Pattern implements Comparable<Pattern> {
	/**
	 * The string of the pattern
	 */
	public String word;
	/**
	 * The number of time the pattern appears in the text
	 */
	public int occurrence;
	/**
	 * Each position where the pattern was found in the text
	 */
	public List<Integer> positions;
	/**
	 * The possible key lenght, based on the gcd of the positions
	 */
	public int keyLength;
	
	/**
	 * Pattern initialization.
	 * 
	 * @param word The pattern
	 * @param position The first position where the pattern was found
	 */
	public Pattern(String word, int position)
	{
		this.word = word;
		this.occurrence = 1;
		this.positions = new ArrayList<Integer>();
		this.positions.add(position);
		this.keyLength = 0;
	}
	
	
	@Override
	public String toString()
	{
		return "\"" + this.word + "\" occurrences: " + this.occurrence + " - probable key lenght: " + this.keyLength;
	}

	@Override
	public int compareTo(Pattern o) {
		// TODO Auto-generated method stub
		return this.occurrence - o.occurrence;
	}
}
