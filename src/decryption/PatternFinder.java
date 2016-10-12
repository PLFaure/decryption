package decryption;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * Pattern finder class.
 * 
 * @author Pierre-Louis
 *
 */
public class PatternFinder {
	
	/**
	 * Pattern finder initialization.
	 */
	public PatternFinder()
	{
		
	}
	
	/**
	 * Find all the patterns in the text.
	 * 
	 * @param size int The size of the patterns to find
	 * 
	 * @throws Exception 
	 */
	public List<Pattern> findPatterns(String text, int size) throws InvalidParameterException
	{
		List<Pattern> patternList = new ArrayList<Pattern>();
		int textLength = text.length();
		if(size>= textLength) {
			throw new InvalidParameterException("Size of the pattern out of range.");
		}
		int first = 0;
		int last = size;
		while(last<textLength) {
			String word = text.substring(first, last);
			if(this.isPresentWord(patternList, word)) {
				int index = this.indexOfWord(patternList, word);
				patternList.get(index).increment(first);
			} else {
				Pattern pattern = new Pattern(word, first);
				patternList.add(pattern);
			}
			first++;
			last++;
		}
		return patternList;
	}
	
	/**
	 * Gives the index of the pattern in the list.
	 * 
	 * @param word The pattern
	 * 
	 * @return int The position of the pattern
	 */
	public int indexOfWord(List<Pattern> patternList, String word)
	{
		int i = 0;
		boolean present = false;
		int n = patternList.size();
		while(i<n && !present) {
			if(patternList.get(i).word.equals(word)) {
				present = true;
			}
			i++;
		}
		if(!present) {
			i = -1;
		}
		return i;
	}
	
	/**
	 * If the pattern is present into the list.
	 * 
	 * @param word The pattern
	 * 
	 * @return boolean True if the pattern is present, false otherwise
	 */
	public boolean isPresentWord(List<Pattern> patternList, String word)
	{
		int i = 0;
		boolean present = false;
		int n = patternList.size();
		while(i<n && !present) {
			if(patternList.get(i).word.equals(word)) {
				present = true;
			}
			i++;
		}
		return present;
	}

	
	/**
	 * Clean the elements of the lists where the occurrence is less than 2.
	 */
	public void cleanList(List<Pattern> patternList)
	{
		for(int i=0;i<patternList.size();i++) {
			if(patternList.get(i).occurrence == 1) {
				patternList.remove(i);
				i--;
			}
		}
	}
	
	public void orderList(List<Pattern> patternList)
	{
		Collections.sort(patternList, Collections.reverseOrder());
	}
}
