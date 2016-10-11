package decryption;

import java.util.*;

public class PatternFinder {
	private final String text="futptnheovduhdjstcgeiltpauhttrgiqltstcgeidtctmdnsehegaxtfuxlcypiiajcjnherrttfuxstvtnvetnherrtttnherrtttnuaxtvldigeaehejlfuxsjrkiiajstcgeiehtaerotugldrhqjeaekicectgeaeherrtthogtjngobacddiitduyojrhcdniecigucstcgeiptuieirtqjeaaregtxtjdtehttlaeaeherrttsehldnvutsuiseaiiehlpmdrictstcgeiqjippeagtxecdgaptduiltmdnseeegsdncecevagdtucstcgeicdmbejntnuactaakaaejrsuctgehogrtsxdtdpnhsdnherrttjnherrttcemihttqjehiaehtrocnjdtqjeaqjucpdugqjesebejrtltstcgeinduhtpigocsyuhqjajsxltnreaeherrttseaesuraiidngehisesacsaegehptcidtltltvtltstcgeidjsjcrehehtsouftnhegltpauhggacdcobbgeeohsxbaesevecstsiucfdufuxrtvtltahauebmtctqjiavtuigprsegstcgeitduiegekeaaiidnsucstcgeiehtaauajttqjesereauxqjiaarocfxeaeherrttsegejshigctsidttgepdgoxtcocdttgejtxltojtaebocdtajnherrttsehigdttdncegltspuirtsaarocfxacctecsditsiltpgebitrherrttsuhurctsaeherrttseaagejshiiepvtcjntnuactrehtseceeaheirtstseagecthltstcgeidjsjcrehntsippsrocnjqjeserejxfuxndnippsgejshi";
	private List<Pattern> patternList;
	
	public PatternFinder()
	{
		this.patternList = new ArrayList<Pattern>();
	}
	
	public int indexOfWord(String word)
	{
		int i = -1;
		boolean present = false;
		int n = this.patternList.size();
		while(i<n && !present) {
			if(this.patternList.get(i).word == word) {
				present = true;
			}
			i++;
		}
		return i;
	}
	
	public boolean isPresentWord(String word)
	{
		int i = 0;
		boolean present = false;
		int n = this.patternList.size();
		while(i<n && !present) {
			if(this.patternList.get(i).word == word) {
				present = true;
			}
			i++;
		}
		return present;
	}
	
	public List<Pattern> getPatternsList()
	{
		return this.patternList;
	}
	
	public void cleanList()
	{
		for(int i=0;i<this.patternList.size();i++) {
			if(this.patternList.get(i).occurrence == 1) {
				this.patternList.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * 
	 * @param size int size of the patterns to find
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
			String word = this.text.substring(first, last-1);
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
