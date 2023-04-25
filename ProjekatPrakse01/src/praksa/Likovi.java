package praksa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Likovi {
	List<String> daenerys;
	List<String> jon;
	List<String> tyrion;
	List<String> cersei;

	public Likovi(String metaData) {
		this.daenerys = loadLine(metaData,"(Daenerys.*)");
		this.jon = loadLine(metaData,"(Jon.*)");
		this.tyrion = loadLine(metaData,"(Tyrion.*)");
		this.cersei = loadLine(metaData,"(Cersei.*)");
		
	}
	
	public static String regEx(String s, String pattern ) {
		Pattern p = Pattern.compile(pattern,Pattern.UNICODE_CHARACTER_CLASS);
		Matcher m = p.matcher(s);
		StringBuilder b = new StringBuilder();
		while(m.find()) {
			b.append(m.group(1) +"\n");
		}
		return b.toString();
	}
	
	public static List<String> loadLine(String meta, String regex){
		String lineMeta = regEx(meta,regex);
		List<String> singleLine = Arrays.asList(lineMeta.split(", "));
		return singleLine;
	}
	
	public static List<String> readMsgs(String msgsFile){
		String trim = msgsFile.strip();
		List<String> characterMsgs = new ArrayList<>();
		characterMsgs=FileHelper.loadMessages(trim);
		return characterMsgs;
	}
	
	public static int countMsgs(List<String> msgs) {
		int counter = -1;/* Prvi red u messages.txt file-u je ime osobe */
		for (String s : msgs) {
			if (s.isBlank() || s.isEmpty()) {
				/* Neki od likova imaju prazne poruke. */} else {
				counter++;
			}
		}
		return counter;
	}
	
	public static String printMsgs(List<String> msgs) {
		StringBuilder sb = new StringBuilder();
		for (String poruka : msgs) {
			sb.append(poruka + "\n");
		}
		return sb.toString();
	}
	
	public static String characterMood(String name,List<String> msgs) {
		int happy = 0;
		int sad = 0;
		for (String poruke : msgs) {
			if (poruke.matches(("(.*)🙂(.*)")) || poruke.matches("(.*)😍(.*)") || poruke.matches("(.*)😄(.*)")) {
				happy++;
			} else if (poruke.matches("(.*)😢(.*)") || poruke.matches("(.*)😭(.*)") || poruke.matches("(.*)🤬(.*)")||poruke.matches("(.*)👿(.*)")) {
				sad++;
			}
		}
		int dispozicija = happy - sad;
		if (dispozicija > 0)
			return name +" je uglavnom dobre volje." ;
		if (dispozicija == 0)
			return name +" ume da bude i dobre i loše volje.";
		if (dispozicija < 0)
			return name +" je uglavnom loše volje.";
		else
			return "";
		
	}
}
