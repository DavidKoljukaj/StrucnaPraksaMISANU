package praksa;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LikoviMain {
	
	


	public static void main(String[] args) {

		String s = FileHelper.loadMetaData();
		Likovi got = new Likovi(s);
		List<String> zaglavlje = Likovi.loadLine(s, "(CHARACTER.*)");

		System.out.print(zaglavlje.get(0) + "\t\t" + zaglavlje.get(1) + "\t\t" + zaglavlje.get(2));
		System.out.print(got.daenerys.get(0) + "\t" + got.daenerys.get(1) + "\t\t" + got.daenerys.get(2));
		System.out.print(got.jon.get(0) + "\t\t" + got.jon.get(1) + "\t\t" + got.jon.get(2));
		System.out.print(got.tyrion.get(0) + "\t" + got.tyrion.get(1) + "\t\t" + got.tyrion.get(2));
		System.out.print(got.cersei.get(0) + "\t" + got.cersei.get(1) + "\t\t" + got.cersei.get(2)+"\n");


		List<String> porukeDany = Likovi.readMsgs(got.daenerys.get(2));
		List<String> porukeJon = Likovi.readMsgs(got.jon.get(2));
		List<String> porukeTyrion = Likovi.readMsgs(got.tyrion.get(2));
		List<String> porukeCersei = Likovi.readMsgs(got.cersei.get(2));
	
		System.out.println(Likovi.printMsgs(porukeDany));
		
	
		int counterDany = Likovi.countMsgs(porukeDany);
		int counterJon = Likovi.countMsgs(porukeJon);
		int counterTyrion = Likovi.countMsgs(porukeTyrion);
		int counterCersei = Likovi.countMsgs(porukeCersei);
	
		System.out.println("Osoba \t\t\tBrojPoruka");
		System.out.println(got.daenerys.get(0) + "\t" + counterDany);
		System.out.println(got.jon.get(0) + "\t\t" + counterJon);
		System.out.println(got.tyrion.get(0) + "\t" + counterTyrion);
		System.out.println(got.cersei.get(0) + "\t" + counterCersei);

		System.out.println("\n"+Likovi.characterMood(got.daenerys.get(0),porukeDany));
		System.out.println(Likovi.characterMood(got.jon.get(0),porukeJon));
		System.out.println(Likovi.characterMood(got.tyrion.get(0),porukeTyrion));
		System.out.println(Likovi.characterMood(got.cersei.get(0),porukeCersei));
		
		

	}
}
