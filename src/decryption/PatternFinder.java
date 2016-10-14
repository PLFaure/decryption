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
	 * Finds all patterns between size <code>maxSize</code> and <code>minSize</code> that appear at least twice in the text.
	 * Also find a probable key length for each of them.
	 * @param text the text to find patterns in
	 * @param maxSize the max size of the patterns to look for
	 * @param minSize the min size of the patterns to look for
	 * @return a list of patterns sorted by number of occurrences
	 */
	public List<Pattern> execute(String text, int maxSize, int minSize)
	{
		List<Pattern> patternList = new ArrayList<Pattern>();
		List<Pattern> tmp;
		for (int size = maxSize; size >= minSize; size--) {
			tmp = findPatterns(text, size);
			cleanList(tmp);
			patternList.addAll(tmp);
		}
		combinePatterns(patternList);
		orderList(patternList);
		guessKeyLengths(patternList);
		return patternList;
		
	}
	
	/**
	 * Runs through the array and remove patterns of different lengths that probably come from the same place in the text.
	 * This is based on the idea that two similar patterns with the exact same number of occurrences
	 * probably come from the same place
	 * @param patternList
	 */
	private void combinePatterns(List<Pattern> patternList){
		Pattern pattern;
		for(int i = 0; i < patternList.size(); i++){ // for each pattern
			pattern = patternList.get(i);
			for (int j = i+1; j < patternList.size(); j++){ // check all following patterns
				if (pattern.word.indexOf(patternList.get(j).word) != -1){ // if the words match
					if (pattern.occurrence == patternList.get(j).occurrence){ // if it's the same number of occurrences
						patternList.remove(j); // they're very likely the same occurrence; remove it.
						j--;
					}
				}
			}
		}
	}

	
	/**
	 * Find all the patterns in the text for one given size.
	 * 
	 * @param size int The size of the patterns to find
	 * 
	 * @throws Exception 
	 */
	private List<Pattern> findPatterns(String text, int size) throws InvalidParameterException
	{
		List<Pattern> patternList = new ArrayList<Pattern>();
		int textLength = text.length();
		boolean found;
		if(size>= textLength) {
			throw new InvalidParameterException("Size of the pattern out of range.");
		}
		int first = 0;
		int last = size;
		while(last<textLength) { // run through each character in the text
			String word = text.substring(first, last);
			found = false;
			for(int i = 0; i < patternList.size(); i++) { // run through the existing patterns
				if (patternList.get(i).word.equals(word)){ // if the current word already exists in the list
					patternList.get(i).positions.add(first);
					patternList.get(i).occurrence++;
					found = true;
					break;
				}
			}
			if (!found) { // if it didn't exist
				patternList.add(new Pattern(word, first));
			}
			first++;
			last++;
		}
		return patternList;
	}
	
	/**
	 * calculates the distance between each occurence of the pattern, then calculates the gcd of all of these distances.
	 * This is a naive way of approximating a key length
	 * @param pattern
	 * @return a probable key lenght
	 */
	private void guessKeyLengths(List<Pattern> patternList){
		for (Pattern pattern : patternList){
			ArrayList<Integer> positionOffset = new ArrayList<Integer>(pattern.positions);
			for(int i=0; i<positionOffset.size()-1; i++) {
				int p = positionOffset.get(i+1) - positionOffset.get(i);
				positionOffset.set(i, p);
			}
			positionOffset.remove(positionOffset.size()-1);
			int gcd = positionOffset.get(0);
			for (int i : positionOffset){
				gcd = gcd(gcd, i);
			}
			pattern.keyLength = gcd;
		}
	}
	
	private int gcd(int m, int n)
	{
		int mod = 0;
		while(n!=0) {
			mod = m%n;
			m = n;
			n = mod;
		}
		return m;
	}
	
	/**
	 * Clean the elements of the lists where the occurrence is less than 2.
	 */
	private void cleanList(List<Pattern> patternList)
	{
		for(int i=0;i<patternList.size();i++) {
			if(patternList.get(i).occurrence == 1) {
				patternList.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * Order list in order of occurrences
	 * @param patternList
	 */
	private void orderList(List<Pattern> patternList)
	{
		Collections.sort(patternList, Collections.reverseOrder());
	}
}
