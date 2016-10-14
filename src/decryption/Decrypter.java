package decryption;

import java.util.ArrayList;
import java.util.List;

import decryption.KeyFinder.CharacterFitness;

/**
 * Decrypter class.
 * 
 * @author Pierre-Louis
 *
 */
public class Decrypter {
	
	public static void main(String[] args) {
		
		int keyLength = 2; // MANUALLY CHANGE THIS VALUE TO FIND KEY
		String key = "pa"; // MANUALLY CHANGE THIS VALUE TO DECRYPT TEXT
		
		// Initialize
		String text= getText();
		PatternFinder patternFinder = new PatternFinder();
		KeyFinder keyFinder = new KeyFinder();
		List<PatternFinder.Pattern> patternList = new ArrayList<PatternFinder.Pattern>();
		List<List<CharacterFitness>> possibleChars = new ArrayList<List<CharacterFitness>>();
		
		// Find the patterns
		patternList = patternFinder.execute(text, 8, 4);
		System.out.println("Most common patterns found: ");
		for (int i = 0; i < 10; i++){
			System.out.println(patternList.get(i));
		}
		
		// Find the key
		possibleChars = keyFinder.execute(text, keyLength);
		System.out.println("\nMost likely character at each position for key length " + keyLength + ": (The lower the value, the better)");
		for (int i = 0; i < keyLength; i++) {
			System.out.print("Letter " + (i+1) + ": ");
			for (int j = 0; j < 3; j++) {
				System.out.print(possibleChars.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
		// Decrypt the text
		System.out.println("\nDecrypted text with key \"" + key + "\":\n" + DecryptionUtils.decrypt(text, key));
		
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
	
	public static String getAnotherText(){
		return "nlcacadholsmkxuxhllbuziexlsmtpsvcaulgzteczonulsigjebuzuxflltfvmxuaivcaihpkuvjhtlc"
				+ "bvtilmtotiygyevcynbxvrxfllthhmbnsewgzfxnpdxuplxualnpkelryigepptweagktanzkevqtp"
				+ "tiuixgachowtxcbjhwydawpuggjigsbagvhiggkekcjelfpfygyegvlskgjogpbelrhregziguaage"
				+ "lswgjekvpfbehtbqudtpzdxpvmutluqrhylnlcacaegvyewcusegjawtldxnhlxipsecaihpzuknls"
				+ "vcynbxvrxukofgztbsbelcsiguaakfbcaklnxvkuywyemgzsxpaixnsefgutmgyrbvvrbcslxeoamg"
				+ "ztnpwrxfhtxwydxrltbvlsitvixujofollxuyogilukuvuegzobulanzseleoamuvnmfpvxtzelxvc"
				+ "tnpstvpogukogvseltvnkqunxolnmuselopannlmxpasegzfxwsefgutlqblxunrhiuefgutldpegs"
				+ "bieujofobnbsbegvwrbpjiicsefguticydxuwolkaihpzftepaegzemevriqyeenlsxvkelroekqto"
				+ "ggzsxnvnegzrxublmcaswgartxhuqolnxulnxvsevjhtwqtelvpqnglsmwuelqbsxuwevgkuvjhtlc"
				+ "bvtilfxnpslksvxuarbupslwkageltkgzairhrmguagvhltuvulgzpxeldneoamuhuocnewcmrbsbe"
				+ "ygsiluplogztkkzlrdpctnlsitlmbgyelfvmxuaivcaihpzanthixpaennpenksytchnlcbnxqsimj"
				+ "pqngkagusevtviluhnmhlrmksexrvqngjoktlsiqudtpaanflbnvkeecjuevbrxflcxtlaegzemcse"
				+ "giyagilmxpadxtlsxtcelubsvgwtbdselfltkghtmcxuxgzpttkeltvnzgbrlnlcacadxxlntpaaeq"
				+ "ysiqbrejvmfgbntweiekhikgbtbnlsxryéttpaaeckofgztbehtbquthwadtdvrwxlnxtlpttselgn"
				+ "yivpeguplywadbcioekzexplukqwetwtorguazgltggyemtvuoczelnltmtlswguounlslgxutwevb"
				+ "kpelklceglntupeegjhtvyelvlsrpvnroldxeoageldxtpcagzsxqbdxnvnzgcimgjeygsigcsabuz"
				+ "elquefryebpaewcusecjuevbrxrvpnnhikgltttailvpqngaagvhumthvxtzdxzwrxuzihpzphrblt"
				+ "kyelsbewgyeitlsxpaamkvnlfpvxtzelcbsxkudxnhlbvaekcaukgkeecwebpaukgvuxpjokgkeect"
				+ "ulkxux";
	}
}
