package task3;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexMain {
	public static String regEx(StringBuilder builder, String pattern ) {
		Pattern p = Pattern.compile(pattern,Pattern.UNICODE_CHARACTER_CLASS);
		Matcher m = p.matcher(builder.toString());
		StringBuilder b = new StringBuilder();
		while(m.find()) {
			b.append(m.group(1) +"\n");
		}
		return b.toString();
	}

	public static void main(String[] args) throws Exception, FileNotFoundException {

		FileInputStream fis = new FileInputStream("listaDefinicija.txt");
		StringBuilder builder = new StringBuilder();
		int ch;
		while((ch = fis.read()) != -1) {
			builder.append((char)ch);
		}
		fis.close();
		/*Star operator * obeležava 0 ili više prethodnih karaktera.
		 *Tačka je operator . koji označava sve karaktere izuzev nove linije.
		 *Ako bismo npr. želeli da označimo sve karaktere koji prethode
		 *određenom stringu, to bismo uz pomoć Regex-a uradili na sledeći način:*/
		String nadjiMapu = "(.*map)";
		System.out.println("Sve ispred reči \"map\" u tekstu: \n"+regEx(builder,nadjiMapu));
		
		/*Pošto je tačka operator u Regex-u, ukoliko želimo da "match-ujemo"
		 *tačke u tekstu, moramo koristiti tzv. escape sequence (\\)*/
		String nadjiTacku = "(...\\.)";
		System.out.println("Poslednja tri karaktera ispred tačke u tekstu: \n"+regEx(builder,nadjiTacku));
		
		/*Zagrade () se koriste da regex koji se u njima nalazi smeste u grupu
		 *i toj grupi dodele numeričku vrednost. U metodi za prepoznavanje paterna 
		 *koristimo ovu numeričku vrednost za dobijanje rezultata pretrage, pa se svi
		 *primeri nalaze unutar zagrada.*/
		String nadjiNiz = "(.*niz.*)";
		System.out.println("Sve ispred i iza reči \"niz\" u tekstu: \n"+regEx(builder,nadjiNiz));
		
		/*Operator | OR se poklapa sa svim paternima pre ili posle ovog simbola.*/
		String nadjiSet = "((s|S)et.*)";
		System.out.println("Sve iza reči \"set\", nezavisno od veličine "
				+ "početnog slova: \n "+regEx(builder,nadjiSet));
		
		String nadjiList = "(.*([l|L]ist).*)";
		System.out.println("Sve o listama: \n"+regEx(builder,nadjiList));
		
		
	}

}
