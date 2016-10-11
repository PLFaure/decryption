package decryption;

import java.util.*;

/**
 * Pattern finder class.
 * 
 * @author Pierre-Louis
 *
 */
public class PatternFinder {
	protected final String text="futptnheovduhdjstcgeiltpauhttrgiqltstcgeidtctmdnsehegaxtfuxlcypiiajcjnherrttfuxstvtnvetnherrtttnherrtttnuaxtvldigeaehejlfuxsjrkiiajstcgeiehtaerotugldrhqjeaekicectgeaeherrtthogtjngobacddiitduyojrhcdniecigucstcgeiptuieirtqjeaaregtxtjdtehttlaeaeherrttsehldnvutsuiseaiiehlpmdrictstcgeiqjippeagtxecdgaptduiltmdnseeegsdncecevagdtucstcgeicdmbejntnuactaakaaejrsuctgehogrtsxdtdpnhsdnherrttjnherrttcemihttqjehiaehtrocnjdtqjeaqjucpdugqjesebejrtltstcgeinduhtpigocsyuhqjajsxltnreaeherrttseaesuraiidngehisesacsaegehptcidtltltvtltstcgeidjsjcrehehtsouftnhegltpauhggacdcobbgeeohsxbaesevecstsiucfdufuxrtvtltahauebmtctqjiavtuigprsegstcgeitduiegekeaaiidnsucstcgeiehtaauajttqjesereauxqjiaarocfxeaeherrttsegejshigctsidttgepdgoxtcocdttgejtxltojtaebocdtajnherrttsehigdttdncegltspuirtsaarocfxacctecsditsiltpgebitrherrttsuhurctsaeherrttseaagejshiiepvtcjntnuactrehtseceeaheirtstseagecthltstcgeidjsjcrehntsippsrocnjqjeserejxfuxndnippsgejshi";
	protected List<Pattern> patternList;
	
	/**
	 * Pattern finder initialization.
	 */
	public PatternFinder()
	{
		this.patternList = new ArrayList<Pattern>();
	}
	
	/**
	 * Gives the index of the pattern in the list.
	 * 
	 * @param word The pattern
	 * 
	 * @return int The position of the pattern
	 */
	public int indexOfWord(String word)
	{
		int i = 0;
		boolean present = false;
		int n = this.patternList.size();
		while(i<n && !present) {
			if(this.patternList.get(i).word.equals(word)) {
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
	public boolean isPresentWord(String word)
	{
		int i = 0;
		boolean present = false;
		int n = this.patternList.size();
		while(i<n && !present) {
			if(this.patternList.get(i).word.equals(word)) {
				present = true;
			}
			i++;
		}
		return present;
	}
	
	/**
	 * Gives the patterns list.
	 * 
	 * @return List The patterns list
	 */
	public List<Pattern> getPatternsList()
	{
		return this.patternList;
	}
	
	/**
	 * Clean the elements of the lists where the occurrence is less than 2.
	 */
	public void cleanList()
	{
		for(int i=0;i<this.patternList.size();i++) {
			if(this.patternList.get(i).occurrence == 1) {
				this.patternList.remove(i);
				i--;
			}
		}
	}
	
	public void orderList()
	{
		Collections.sort(this.patternList, Collections.reverseOrder());
	}
	
	/**
	 * Find all the patterns in the text.
	 * 
	 * @param size int The size of the patterns to find
	 * 
	 * @throws Exception 
	 */
	public void findPatterns(int size) throws Exception
	{
		int textLength = this.text.length();
		if(size>= textLength) {
			throw new Exception("Size of the pattern out of range.");
		}
		int first = 0;
		int last = size;
		while(last<textLength) {
			String word = this.text.substring(first, last);
			if(this.isPresentWord(word)) {
				int index = this.indexOfWord(word);
				this.patternList.get(index).increment(first);
			} else {
				Pattern pattern = new Pattern(word, first);
				this.patternList.add(pattern);
			}
			first++;
			last++;
		}
	}
}
