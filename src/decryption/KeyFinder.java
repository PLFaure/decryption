package decryption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyFinder {
	
	private HashMap<Character, Float> frenchOccurrenceFrequencies = null;
	
	public class CharacterFitness implements Comparable<CharacterFitness>
	{
		public char character;
		public float fitness;
		
		public CharacterFitness(char c, float f){
			character = c;
			fitness = f;
		}
		
		@Override
		public String toString(){
			return character + "(" + String.format("%.01f", fitness) + ")";
		}
		
		@Override
		public int compareTo(CharacterFitness other) {
			return (int) (fitness * 100 - other.fitness * 100);
		}
	}
	
	public KeyFinder()
	{
		frenchOccurrenceFrequencies = new HashMap<Character, Float>();
		frenchOccurrenceFrequencies.put('a', 7.11f);
		frenchOccurrenceFrequencies.put('e', 12.10f);
		frenchOccurrenceFrequencies.put('i', 6.59f);
		frenchOccurrenceFrequencies.put('k', 0.29f);
		frenchOccurrenceFrequencies.put('n', 6.39f);
		frenchOccurrenceFrequencies.put('r', 6.07f);
		frenchOccurrenceFrequencies.put('s', 6.51f);
		frenchOccurrenceFrequencies.put('w', 0.17f);
		frenchOccurrenceFrequencies.put('x', 0.38f);
		frenchOccurrenceFrequencies.put('z', 0.15f);
	}
	
	/**
	 * Once a possible key length has been found, this method computes the string to find
	 * @param text
	 * @param keyLength
	 * @return
	 */
	public List<List<CharacterFitness>> execute(String text, int keyLength)
	{
		//String probableKey = "";
		List<List<CharacterFitness>> possibleChars = new ArrayList<List<CharacterFitness>>();
		Map<Character, Map<Character, Float>> frequencies;
		List<String> splicedText = DecryptionUtils.textSplicer(text, keyLength);
		for(String splice: splicedText){
			frequencies = slideAndFindFrequencies(splice);
			possibleChars.add(selectMostProbableChar(frequencies));
		}
		
		return possibleChars;
	}
	
	/**
	 * Find the most likely character to be part of the vigenere key, based on a simple heuristics
	 * @param frequencies
	 * @return
	 */
	private List<CharacterFitness> selectMostProbableChar(Map<Character, Map<Character, Float>> frequencies)
	{
		List<CharacterFitness> fitnesses = new ArrayList<CharacterFitness>();
		/*char bestChar = '-';
		float bestFitness = Float.MAX_VALUE;*/
		float fitness;
		Map<Character, Float> tmp;
		
		for (char alphabetChar = 'a'; alphabetChar <= 'z'; alphabetChar++){ // for each letter in the alphabet
			fitness = 0;
			tmp = frequencies.get(alphabetChar); // retrieve the calculated occurrences after sliding text with that letter
			for(char checkChar : tmp.keySet()){ // calculate fitness
				fitness += Math.abs(tmp.get(checkChar) - frenchOccurrenceFrequencies.get(checkChar));
			}
			fitnesses.add(new CharacterFitness(alphabetChar, fitness));
			/*if (fitness < bestFitness){ // if the overall distance to actual frequencies is lower
				bestFitness = fitness; // save it
				bestChar = alphabetChar;
			}*/
		}
		Collections.sort(fitnesses);
		return fitnesses;
	}
	
	/**
	 * For each letter in the alphabet, slide the string according to that letter, and calculate the frequencies of each letter
	 * in the resulting slided string
	 * @param text
	 * @return
	 */
	private Map<Character, Map<Character, Float>> slideAndFindFrequencies(String text)
	{
		HashMap<Character, Map<Character, Float>> frequencies = new HashMap<Character, Map<Character, Float>>();
		String tmp;
		
		for (int i = 0; i < 26; i++) {
			tmp = DecryptionUtils.slideString(text, 26-i); // slide string the other way because we are decrypting
			frequencies.put((char)('a'+i), calculateFrequencies(tmp));
		}
		return frequencies;
	}
	
	/**
	 * Calculate the frequencies of each character in a string
	 * @param text
	 * @return
	 */
	private Map<Character, Float> calculateFrequencies(String text)
	{
		HashMap<Character, Float> frequencies = new HashMap<Character, Float>();
		frequencies.put('e', 0f);
		frequencies.put('a', 0f);
		frequencies.put('i', 0f);
		frequencies.put('s', 0f);
		frequencies.put('n', 0f);
		frequencies.put('r', 0f);
		frequencies.put('x', 0f);
		frequencies.put('k', 0f);
		frequencies.put('w', 0f);
		frequencies.put('z', 0f);
		int occurrences;
		float f;
		
		for(char c : frequencies.keySet()){
			occurrences = 0;
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == c)
					occurrences++;
			}
			f = (float)occurrences/text.length()*100;
			frequencies.put(c, f);
		}
		return frequencies;
	}
	
}
