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
	public int keyLenght;
	
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
		this.keyLenght = 0;
	}
	
	/**
	 * If the word is a part of the current word, or vice versa.
	 * 
	 * @param str The word to test
	 * @return boolean True if one of the words is a part of the other
	 */
	public boolean isPartOf(String str)
	{
		if(this.word.length() > str.length()) {
			return (this.word.indexOf(str) != -1);
		} else {
			return (str.indexOf(this.word) != -1);
		}
	}
	
	
	@Override
	public String toString()
	{
		return "\"" + this.word + "\" occurrences: " + this.occurrence + " - probable key lenght: " + this.keyLenght;
	}

	@Override
	public int compareTo(Pattern o) {
		// TODO Auto-generated method stub
		return this.occurrence - o.occurrence;
	}
}
