package decryption;

import java.util.ArrayList;
import java.util.List;

/**
 * Decrypter class.
 * 
 * @author Pierre-Louis
 *
 */
public class Decrypter {
	
	public static void main(String[] args) {
		
		String text= getText();
		
		PatternFinder patternFinder = new PatternFinder();
		KeyFinder keyFinder = new KeyFinder();
		List<Pattern> patternList = new ArrayList<Pattern>();
		patternList = keyFinder.processPatterns(text, 8, 4);//patternFinder.findPatterns(text, 6);
		/*patternFinder.cleanList(patternList);
		patternFinder.orderList(patternList);*/
		int p;
		for(Pattern pattern: patternList) {
			for(int i=0; i<pattern.positions.size()-1; i++) {
				p = pattern.positions.get(i+1) - pattern.positions.get(i);
				pattern.positions.set(i, p);
			}
			pattern.positions.remove(pattern.positions.size()-1);
			if(pattern.occurrence>10) {
			System.out.println(pattern);}
		}
		
		//TODO try Pattern.isPartOf()
		//TODO try KeyFinder.concatList()
		//TODO try KeyFinder.addDistance()
		//TODO try KeyFinder.calcDistances()
	}
	
	public static String getText()
	{
		return "futptnheovduhdjstcgeiltpauhttrgiqltstcgeidtctmdnsehegaxt"
				+ "fuxlcypiiajcjnherrttfuxstvtnvetnherrtttnherrtttnuaxtvldige"
				+ "aehejlfuxsjrkiiajstcgeiehtaerotugldrhqjeaekicectgeaeherrtt"
				+ "hogtjngobacddiitduyojrhcdniecigucstcgeiptuieirtqjeaaregtxt"
				+ "jdtehttlaeaeherrttsehldnvutsuiseaiiehlpmdrictstcgeiqjippea"
				+ "gtxecdgaptduiltmdnseeegsdncecevagdtucstcgeicdmbejntnuactaa"
				+ "kaaejrsuctgehogrtsxdtdpnhsdnherrttjnherrttcemihttqjehiaeht"
				+ "rocnjdtqjeaqjucpdugqjesebejrtltstcgeinduhtpigocsyuhqjajsxl"
				+ "tnreaeherrttseaesuraiidngehisesacsaegehptcidtltltvtltstcge"
				+ "idjsjcrehehtsouftnhegltpauhggacdcobbgeeohsxbaesevecstsiucf"
				+ "dufuxrtvtltahauebmtctqjiavtuigprsegstcgeitduiegekeaaiidnsu"
				+ "cstcgeiehtaauajttqjesereauxqjiaarocfxeaeherrttsegejshigcts"
				+ "idttgepdgoxtcocdttgejtxltojtaebocdtajnherrttsehigdttdncegl"
				+ "tspuirtsaarocfxacctecsditsiltpgebitrherrttsuhurctsaeherrtt"
				+ "seaagejshiiepvtcjntnuactrehtseceeaheirtstseagecthltstcgeid"
				+ "jsjcrehntsippsrocnjqjeserejxfuxndnippsgejshi";
	}
}
