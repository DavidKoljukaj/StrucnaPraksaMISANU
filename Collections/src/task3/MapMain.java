package task3;

import java.util.HashMap;

public class MapMain {
	/*	Mape su jedan od članova Java Collections Framework-a i 
	 * 	definisane su java.util.Map interfejsom. 
	 * 	Služe za povezivanje ključeva sa vrednostima. 
	 * 	Ne mogu sadržati duplikate ključeva. 
	 * 	Svaki ključ je povezan sa samo jednom vrednošću. 
	 * 	Postoje tri implementacione klase i to su: HashMap, 
	 * 	LinkedHashMap i TreeMap. 
	 * 	Takođe, Hashtable je u integrisan u JCF implementaciom ovog interfejsa.
	 * 	*/
	

	public static void main(String[] args) {
		
	/*	Prilikom kreiranja HashMap-e moramo odrediti parametre <K, V>.
	 * 	K predstavlja tip ključeva, a V tip vrednosti.
	 * 
	 * 	Povežimo npr. imena korisnika sa nazivima gradova u kojima žive.
	 * 	Pošto su oba ova podatka stringovnog tipa i na mestu ključa
	 * 	i na mestu vrednosti, naći će se String klasa.
	 * 	*/
		HashMap<String, String> korisniciGradovi = new HashMap<>();
		korisniciGradovi.put("Pera Perić", "Beograd");
		korisniciGradovi.put("Mika Mikić", "Kragujevac");
		korisniciGradovi.put("Pera Perić", "Niš");
		korisniciGradovi.put("Jovana Jovanović", "Jagodina");
		korisniciGradovi.put("Seka Sabljić", "Beograd");
		
		/*Ukoliko želimo da dobijemo naziv grada u kojem korisnik
		 * živi, dovoljno je da navedemo naziv objekta tog ključa (ime osobe u ovom primeru).*/
		System.out.println("Seka Sabljić živi u "+korisniciGradovi.get("Seka Sabljić")+"u.");
		
		/*Kao što je gore navedeno, ne mogu postojati duplikati ključeva
		 *(u ovom slučaju imena korisnika). Vrednost korisnika
		 *sa ključem "Pera Perić" nakon upotrebe metode put() za
		 *isti ključ postaje "Niš". */
		System.out.println("Pera Perić živi u "+korisniciGradovi.get("Pera Perić")+"u.");
		/*Da bismo dobili sve vrednosti koje se nalaze u parametru V možemo koristiti
		 * .values() metod.*/
		System.out.println("Vrednosti povezane sa svim ključevima: " + korisniciGradovi.values());
		
		/*Možemo utvrditi da li određeni ključ postoji u mapi korišćenjem
		 *metode containsKey() */
		boolean postoji = korisniciGradovi.containsKey("Mika Mikić");
		if(postoji)
			System.out.println("Traženi ključ se nalazi u mapi.");
		else
			System.out.println("Ne postoji traženi ključ.");
		
		/*Takođe možemo proveriti da li postoji određena vrednost u mapi.*/
		boolean grad = korisniciGradovi.containsValue("Novi Sad");
		if(grad)
			System.out.println("Tražena vrednost postoji u mapi.");
		else
			System.out.println("Takva vrednost ne postoji u mapi.");

	}

}
