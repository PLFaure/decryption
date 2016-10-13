package decryption;

import java.util.*;

/**
 * Pattern class.
 * @author Pierre-Louis
 *
 */
public class Pattern implements Comparable<Pattern> {
	public String word;
	public int occurrence;
	public List<Integer> positions;
	
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
		/*boolean partOf = false;
		if(this.word.length() > str.length()) {
			int max = this.word.length()-str.length();
			int i = 0;
			while((i<max) && !partOf) {
				int j = 0;
				while((j<this.word.length()) && !partOf) {
					if(j-i <= 0) {
						System.out.println("N'importe quoi, c'est juste pour mettre un breakpoint.");
					}
					if(this.word.substring(j,i).equals(str)) {
						partOf = true;
					}
					j++;
				}
				i++;
			}
		} else { //this.word.length() <= word.length()
			int max = str.length()-this.word.length();
			int i = 0;
			while((i<max) && !partOf) {
				int j = 0;
				while((j<str.length()) && !partOf) {
					if(str.substring(j,i).equals(this.word)) {
						partOf = true;
					}
					j++;
				}
				i++;
			}
		}
		return partOf;*/
	}
	
	/**
	 * Increment the number of pattern occurrences.
	 * 
	 * @param position The position where the new occurrence was found
	 * 
	 * @return boolean True if the increment worked well, false otherwise
	 */
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

	@Override
	public int compareTo(Pattern o) {
		// TODO Auto-generated method stub
		return this.occurrence - o.occurrence;
	}
}
