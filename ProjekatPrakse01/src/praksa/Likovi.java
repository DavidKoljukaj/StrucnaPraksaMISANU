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
	
	public static ArrayList<String> characterMood(String name, List<String> msgs) {
		ArrayList<String> happyOrSad = new ArrayList<>();
		int happy = 0;
		int sad = 0;
		String raspolozenje = new String();
		for (String poruke : msgs) {
			if (poruke.matches(("(.*)🙂(.*)")) || poruke.matches("(.*)😍(.*)") || poruke.matches("(.*)😄(.*)")) {
				happy++;
			} else if (poruke.matches("(.*)😢(.*)") || poruke.matches("(.*)😭(.*)") || poruke.matches("(.*)🤬(.*)")
					|| poruke.matches("(.*)👿(.*)")) {
				sad++;
			}
		}
		int dispozicija = happy - sad;
		if (dispozicija > 0) {
			raspolozenje = name + " je uglavnom dobre volje.";
			happyOrSad.add(raspolozenje);
			happyOrSad.add(""+dispozicija);
			
		}
		if (dispozicija == 0) {
			raspolozenje = name + " ume da bude i dobre i loše volje.";
			happyOrSad.add(raspolozenje);
			happyOrSad.add(""+dispozicija);
		}
		if (dispozicija < 0) {
			raspolozenje = name + " je uglavnom loše volje.";
			happyOrSad.add(raspolozenje);
			happyOrSad.add(""+dispozicija);
		}
		return happyOrSad;

	}
	
	public static String disposition() {
		String s = FileHelper.loadMetaData();
		Likovi got = new Likovi(s);
		List<String> porukeDany = readMsgs(got.daenerys.get(2));
		List<String> porukeJon = readMsgs(got.jon.get(2));
		List<String> porukeTyrion = readMsgs(got.tyrion.get(2));
		List<String> porukeCersei = readMsgs(got.cersei.get(2));
		
		ArrayList<String> danyMood = characterMood(got.daenerys.get(0),porukeDany);
		ArrayList<String> jonMood = characterMood(got.jon.get(0),porukeJon);
		ArrayList<String> tyrionMood = characterMood(got.tyrion.get(0),porukeTyrion);
		ArrayList<String> cerseiMood = characterMood(got.cersei.get(0),porukeCersei);
		
		int d = Integer.parseInt(danyMood.get(1));
		int j = Integer.parseInt(jonMood.get(1));
		int t = Integer.parseInt(tyrionMood.get(1));
		int c = Integer.parseInt(cerseiMood.get(1));
		
		int[] mood = new int[4];
		mood[0]=d;
		mood[1]=j;
		mood[2]=t;
		mood[3]=c;
		
		Arrays.sort(mood);
		
		StringBuilder sb = new StringBuilder();
		if(mood[0]==d)
			sb.append(got.daenerys.get(0)+" je najtužnija,");
		else if(mood[0]==j)
			sb.append(got.jon.get(0)+" je najtužniji,");
		else if(mood[0]==t)
			sb.append(got.tyrion.get(0)+" je najtužniji,");
		else if(mood[0]==c)
			sb.append(got.cersei.get(0)+" je najtužnija,");
		
		if(mood[3]==d)
			sb.append(" a "+got.daenerys.get(0)+" je najsrećnija.");
		else if(mood[3]==j)
			sb.append(" a "+got.jon.get(0)+" je najsrećniji.");
		else if(mood[3]==t)
			sb.append(" a "+got.tyrion.get(0)+" je najsrećniji.");
		else if(mood[3]==c)
			sb.append(" a "+got.cersei.get(0)+" je najsrećnija.");
		
		return sb.toString();
		
	}
	
	public static int inLove(List<String> msgs) {
		int counter = 0;
		for(String poruka : msgs) {
			if(poruka.matches(("(.*)😘(.*)"))||poruka.matches("(.*)😍(.*)")){
				counter++;
			}
		}
		return counter;
	}
	
	public static String moreInLove(String nameFirst,String nameSecond,List<String> msgsFirst, List<String> msgsSecond) {
		if(inLove(msgsFirst)>inLove(msgsSecond))
			return nameFirst+" više voli " + nameSecond+"-a nego on nju.";
		else
			return nameSecond+" više voli " +nameFirst+" nego ona njega.";
	}
}
