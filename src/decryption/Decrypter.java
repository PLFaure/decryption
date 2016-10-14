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
		List<Pattern> patternList = new ArrayList<Pattern>();
		
		patternList = patternFinder.execute(text, 8, 4);
		for (int i = 0; i < 10; i++){
			System.out.println(patternList.get(i));
		}
		
		//TODO try Pattern.isPartOf()
		//TODO try KeyFinder.concatList()
		//TODO try KeyFinder.addDistance()
		//TODO try KeyFinder.calcDistances()
	}
	
	public static String getText()
	{
		return    "futptnheovduhdjstcgeiltpauhttrgiqltstcgeidtctmdnsehegaxt"
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
