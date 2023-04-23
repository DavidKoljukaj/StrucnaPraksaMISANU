package task3;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListsMain {

	public static void main(String[] args) throws Exception{

		/*	Gotovo sve kolekcije u Javi potiču od java.util.Collection interfejsa.
		 *  Postoje tri tipa kolekcija: ordered lists, maps i sets.
		 *  Ordered list omogućava unos elemenata određenim redosledom i
		 *  čitanje datih elemenata. Osnovni interfejsi za uređene liste 
		 *  su List i Queue.
		 *  Mape čuvaju reference na objekte sa ključem za pristupanje vrednostima objekta.
		 *  Osnovni interfejs za mape je Map.
		 *  Set su neuređene kolekcije, po kojima se može iterirati i koje sadrže svaki
		 *  element samo jednom. Osnovni interfejs za skupove je Set.*/
		
		/*	Gore navedene definicije možemo sačuvati u odvojenim stringovima: */
		String s1 ="Gotovo sve kolekcije u Javi potiču od java.util.Collection interfejsa.";
		String s2 ="Postoje tri tipa kolekcija: ordered lists, maps i sets.";
		String s3 ="Ordered list omogućava unos elemenata određenim redosledom i čitanje datih elemenata. Osnovni interfejsi za uređene liste su List i Queue.";
		String s4 ="Mape čuvaju reference na objekte sa ključem za pristupanje vrednostima objekta. Osnovni interfejs za mape je Map.";
		String s5 ="Set su neuređene kolekcije, po kojima se može iterirati i koje sadrže svaki element samo jednom. Osnovni interfejs za skupove je Set.";
		
		/*	Zatim možemo eksplicitno inicijalizovati niz stringova: */
		String [] nizStringova1 = {s1,s2,s3,s4,s5};
		
		/*	Prilikom deklaracije niza mora se odrediti i njegova dužina.  
		 * 	Broj elemenata koje sadrži određeni niz ne može se naknadno menjati, 
		 * 	tj. ne mogu se dodavati i oduzimati elementi niza. 
		 * 
		 * 	Ukoliko bismo želeli da dodamo nove elemente, morali bismo da napravimo
		 * 	novi niz, koji bi imao dužinu veću od prethodnog niza za ukupan broj
		 * 	novih elemenata. 
		 * 	
		 * 	Sačuvajmo još dva stringa:*/
		String s6 = "Prilikom deklaracije niza mora se odrediti i njegova dužina.";
		String s7 = "Broj elemenata koje sadrži određeni niz ne može se naknadno menjati, tj. ne mogu se dodavati i oduzimati elementi niza.";
		
		/*	Prilikom inicijalizacije novog niza, nakon navođenja tipa podataka,
		 * 	određujemo veličinu niza unošenjem vrednosti unutar uglastih zagrada.*/
		String [] nizStringova2 = new String [7];
		
		/*	Možemo koristiti for petlju da bismo pristupili elementima.*/
		for(int i=0;i<nizStringova1.length;i++) {
			nizStringova2[i]=nizStringova1[i];
		}
		
		/*	Preostala dva elementa možemo direktno uneti,
		 * 	imajući u vidu da indeksiranje ide od 0.*/
		nizStringova2[5]=s6;
		nizStringova2[6]=s7;
		
		/*	Da bismo jednostavnije vršili izmene nad nizovima,
		 * 	možemo koristiti klase ArrayList i LinkedList.
		 * 	ArrayList je klasa iz Collections framework-a koja implementira
		 * 	List interfejs. */
		
		/*	Napravimo novi ArrayList stringova i inicijalizujmo ga koristeći diamond operator <> 
		 * 	Prilikom kreiranja ArrayList-e nije potrebno odrediti veličinu liste, 
		 * 	tačnije ArrayList nema zadatu veličinu , već se može povećati ili smanjiti
		 * 	u zavisnosti od potrebe.*/
		ArrayList<String> definicijeArray = new ArrayList<>();
	
		/*	Koristeći for petlju preselimo elemente iz drugog niza u novu listu.
		 * 	Da bismo dodali elemente u listu, koristićemo add() metodu navedene klase.*/
		for(int i=0;i<nizStringova2.length;i++) {
			definicijeArray.add(nizStringova2[i]);
		}
		
		/*	ArrayList se može i eksplicitno inicijalizovati koristeći asList() metod.
		 * 	Prilikom navođenja tipa podataka ne mogu se koristiti primitivni tipovi,
		 * 	već se koriste njihove klase omotači.*/
		ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(10,20,30,40,50));
		
		/*	Da bismo utvrdili veličinu liste možemo koristiti ugrađeni metod size().
		 * 	Odštampajmo veličinu liste celih brojeva: */
		System.out.println("Ukupan broj elemenata u listi celih brojeva pre izmena: "+intArray.size());
		
		/*	Korišćenjem add() metode jednostavno možemo dodati nove elemente.*/
		intArray.add(60);intArray.add(70);intArray.add(80);
		System.out.println("Ukupan broj elemenata u listi celih brojeva nakon dodavanja elemenata: "+intArray.size());
				
		/*	Uklonimo dva elementa korišćenjem remove() metode.*/
		System.out.println("Lista pre uklanjanja elemenata: " + intArray);
		intArray.remove(6);intArray.remove(6);
		/*	Nakon uklanjanja prvog elementa sa indeksom 6, ArrayList se "skuplja"
		 * 	tako da se element koji je bio sa indeksom 7(broj 80 u ovom primeru)
		 * 	pomera na mesto sa indeksom 6.*/
		System.out.println("Lista nakon uklanjanja elemenata: " + intArray);
		
		/*	Možemo pročitati vrednost elementa korišćenjem metode get().*/
		System.out.println("Vrednost elementa sa indeksom 2 u listi celih brojeva pre izmena: " + intArray.get(2));
		
		/*	Možemo zadati vrednost elementa korišćenjem metode set().*/
		intArray.set(2, 33);
		System.out.println("Vrednost elementa sa indeksom 2 u listi celih brojeva nakon izmena: " + intArray.get(2));
		
		/*	Još jedna klasa iz Collection framework-a koja je našla široku primenu je LinkedList.*/
		List<Integer> intLinked = new LinkedList<>();
		
		/*
		 * 	Glavna razlika između ove dve klase je u njihovoj implementaciji.
		 * 	ArrayList se u pozadini oslanja na niz i prilikom dodavanja ili
		 * 	oduzimanja elemenata kreira se novi niz, slično kao u primeru sa
		 * 	početka.
		 * 	S druge strane LinkedList je spisak elemenata tzv. nodova, koji sadrže
		 * 	reference na sledeće i prethodne elemente u nizu. Prilikom izmena
		 * 	kapaciteta niza potrebno je izmeniti samo reference onih nodova
		 * 	koji su ispred i iza elemenata nad kojima se vrši izmena.*/
		
		
		
		/*	Za konverziju ArrayList-e iskoristićemo ranije kreirani metod convertToLinked():*/
		intLinked =convertToLinked(intArray);
		System.out.println("Elementi nakon premeštanja u LinkedListu: "+intLinked);
		
		/*	ArrayListe imaju tzv. random access, što im omogućava brz pristup
		 * 	vrednostima elemenata nezavisno od indeksa. Iz ovog razloga metode
		 * 	set() i get() najbolje rade nad ArrayList-om.
		 * 	LinkedListe imaju prednost kada su u pitanju metode add() i 
		 * 	remove(), zbog gore pomenutih nodova.*/
		
		/*	Pristupimo elementima liste definicija pomoću iteratora i 
		 * 	sačuvajmo stringove u poseban fajl, da bismo mogli da im 
		 * 	pristupimo iz drugih klasa.*/
		StringBuilder builder = new StringBuilder();
		Iterator<String> iter = definicijeArray.iterator();
		while(iter.hasNext()) {
			builder.append(iter.next() + "\n");
		}
		
		FileOutputStream fos = new FileOutputStream("listaDefinicija.txt");
		fos.write(builder.toString().getBytes());
		fos.close();
		
		
	}
		/*	Generička funkcija za konvertovanje ArrayList-e u LinkedList-u:*/
	public static <T> List<T> convertToLinked(List<T> arrayList){
		
		/*	Kreiranje prazne LinkedList-e*/
		List<T> linkedList = new LinkedList<>();
		
		/*	Iteriranje kroz arrayList i dodavanje elemenata u linkedList korišćenjem unapređene for petlje */
		for(T t : arrayList) {
			linkedList.add(t);
		}
		
		return linkedList;
	}
}
