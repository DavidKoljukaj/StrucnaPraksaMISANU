package task2;
import java.io.Serializable;

public class Link implements Serializable{
	
	/**
	 * 	Serijalizacija predstavlja proces konvertovanja Javinih objekata 
		(kombinacije koda i podataka predstavljenih unutar regije za skladištenje podataka)
		u seriju bajtova, koji pamte stanje objekta u formatu koji je jednostavan za transmisiju.
		U ovakvom serijalizovanom formatu, podaci se mogu isporučiti bazi podataka, aplikaciji 
		ili na neko drugo odredište.
		Za složene objekte, kao što su oni koji u velikoj meri koriste reference, ovaj proces
		nije jednostavan, jer serijalizacija objektno orijentisanih objekata ne uključuje nijednu
		od njihovih referenciranih metoda.
		
		Obrnuti proces, tj. stvaranje objekta iz serije bajtova, naziva se deserijalizacija. 
		Proces deserijalizacije rekonstruiše objekat i time omogućava lakše čitanje i modifikovanje
		podataka kao izvornih struktura u programskom jeziku.  
		
		Objekat je moguće serijalizovati ukoliko njegova klasa ili neka od roditeljskih klasa 
		implementira java.io.Serializable ili java.io.Externalizable interfejs.
		
		SerialVersionUID predstavlja jedinstveni identifikator za svaku Serializable klasu. Prilikom
		deserijalizacije ovaj identifikator omogućava JVM-u da učita odgovarajuću verziju klase.
	 */
	private static final long serialVersionUID = 1L;
	private String commons;
	private int favorites;
	
	public Link(String commons,int favorites) {
		this.commons=commons;
		this.favorites=favorites;
	}
	
	public void printLink() {
		System.out.println("Link: " + this.commons);
	}
}


