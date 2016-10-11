package decryption;

import java.util.List;

public class Decrypter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatternFinder pf = new PatternFinder();
		try {
			pf.findPatterns(6);
		} catch(Exception e) {
			e.printStackTrace();
		}
		//pf.cleanList();
		List<Pattern> l = pf.getPatternsList();
		for(Pattern p: l) {
			System.out.println(p);
		}
		System.out.println("Fini.");
	}
}
