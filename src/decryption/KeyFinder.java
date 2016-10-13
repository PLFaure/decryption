package decryption;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Key finder class.
 * 
 * @author Pierre-Louis
 *
 */
public class KeyFinder extends PatternFinder {
	public List<Distance> distances;
	
	/**
	 * KeyFinder initialization.
	 */
	public KeyFinder()
	{
		super();
		distances = new ArrayList<Distance>();
	}
	
	public List<Pattern> processPatterns(String text, int maxSize, int minSize)
	{
		List<Pattern> patternList = new ArrayList<Pattern>();
		List<Pattern> tmp;
		for (int size = maxSize; size >= minSize; size--) {
			System.out.println("Finding pattern of size " + size);
			tmp = findPatterns(text, size);
			cleanList(tmp);
			concatList(patternList, tmp); // TODO INIFNITE LOOOOOP
		}
		orderList(patternList);
		return patternList;
		
	}
	
	/**
	 * Concatenate the pattern list with another list of patterns.
	 * The current list must have larger patterns than the list to add.
	 * 
	 * @param otherList The list to add
	 * 
	 * @throws Exception If the current list have smaller patterns
	 */
	public void concatList(List<Pattern> patternList, List<Pattern> otherList) //throws InvalidParameterException
	{
		patternList.addAll(otherList);
		/*int j;
		Pattern pattern;
		//We travel the list in parameter
		for(int i=0;i<otherList.size();i++) {
			boolean partOf = false;
			j = 0;
			pattern = otherList.get(i); //The pattern element to add
			//We travel the current list
			while((j<patternList.size()) && !partOf) {
				//If the word of e is larger than the one of the j-th element of the current list
				if(pattern.word.length()>patternList.get(j).word.length()) {
					throw new InvalidParameterException("All the element of the list to add must be smaller than the one of the current list.");
				}
				//We test if the element is a part of an element of the current list
				partOf = patternList.get(j).isPartOf(pattern.word);
				j++;
			}
			//If the element is not a part of the current list
			if(!partOf) {
				//We add the element to the list
				patternList.add(pattern);
			}
		}*/
	}
	
	public boolean isPresentDistance(int value)
	{
		int i = 0;
		int n = this.distances.size();
		boolean present = false;
		while(i<n && !present) {
			if(this.distances.get(i).value == value) {
				present = true;
			}
			i++;
		}
		return present;
	}
	
	public int indexOfDistance(int value)
	{
		int i = 0;
		int n = this.distances.size();
		boolean present = false;
		while(i<n && !present) {
			if(this.distances.get(i).value == value) {
				present = true;
			}
			i++;
		}
		if(!present) {
			i = -1;
		}
		return i;
	}
	
	public void addDistance(int value)
	{
		if(this.isPresentDistance(value)) {
			int index = this.indexOfDistance(value);
			this.distances.get(index).increment();
		} else {
			Distance d = new Distance(value);
			this.distances.add(d);
			//TODO order distances
		}
	}
	
	public void calcDistances(List<Pattern> patternList)
	{
		for(int i=0;i<patternList.size();i++) {
			List<Integer> positions = patternList.get(i).positions;
			int prevPosition = 0;
			for(int j=0;j<positions.size();j++) {
				int currentPosition = positions.get(j);
				this.addDistance(currentPosition-prevPosition);
				prevPosition = currentPosition;
			}
		}
	}
	
	/*
	public int gcd(int m, int n)
	{
		int mod = 0;
		while(n!=0) {
			mod = m%n;
			m = n;
			n = mod;
		}
		return m;
	}
	
	public int minDistance()
	{
		int gcd;
		int result = this.distances.get(0).value;
		int n = this.distances.size();
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				gcd = gcd(this.distances.get(i).value, this.distances.get(j).value);
				result = gcd(gcd, result);
			}
		}
		return result;
	}
	
	public String key()
	{
		return null;
	}
	*/
}
