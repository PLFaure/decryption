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
		
		String text= getAnotherText();
		PatternFinder patternFinder = new PatternFinder();
		KeyFinder keyFinder = new KeyFinder();
		List<Pattern> patternList = new ArrayList<Pattern>();
		
		patternList = patternFinder.execute(text, 8, 4);
		for (int i = 0; i < 10; i++){
			System.out.println(patternList.get(i));
		}
		
		System.out.println("The most likely key is: " + keyFinder.execute(text, 4));
		
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
