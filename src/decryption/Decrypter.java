package decryption;

import java.util.List;

/**
 * Decrypter class.
 * 
 * @author Pierre-Louis
 *
 */
public class Decrypter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatternFinder pf = new PatternFinder();
		try {
			pf.findPatterns(6);
		} catch(Exception e) {
			e.printStackTrace();
		}
		pf.cleanList();
		pf.orderList();
		List<Pattern> l = pf.getPatternsList();
		for(Pattern p: l) {
			System.out.println(p);
		}
		
		//TODO try Pattern.isPartOf()
		//TODO try KeyFinder.concatList()
		//TODO try KeyFinder.addDistance()
		//TODO try KeyFinder.calcDistances()
		//TODO try KeyFinder.gcd()
		//TODO try KeyFinder.minDIstance()
		//TODO try KeyFinder.key()
	}
}
