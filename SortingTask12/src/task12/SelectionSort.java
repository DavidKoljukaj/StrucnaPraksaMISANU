package task12;

import java.util.List;

public class SelectionSort {
	
	public static void selectionSort(List<Integer> numbers) {
		/*Prolaženje kroz listu elemenata od prvog do pretposlednjeg elementa:*/
		for(int i=0;i<numbers.size()-1;i++) {
			/*Čuvanje vrednosti trenutnog indeksa u promenljivoj minIndex:*/
			int minIndex = i;
			/*Prolaženje kroz listu elemenata u ugnježdenoj for petlji
			 * od narednog do poslednjeg elementa:*/
			for(int j=i+1;j<numbers.size();j++) {
				/*Korišćenje compareTo() metode za poređenje vrednosti narednog
				 * i trenutnog elementa(vraća -1 ukoliko je vrednost manja)*/
				if(numbers.get(j).compareTo(numbers.get(minIndex))<0) {
					/*Ukoliko vrednost jeste manja, promenljiva minIndex
					 *uzima vrednost indeksa datog elementa */
					minIndex=j;
				}
			}
			/*Vrednost elementa sa trenutnim indeksom se smešta u promenljivu temp:*/
			int temp = numbers.get(i);
			/*Vrednost elementa sa trenutnim indeksom menja mesto sa elementom
			 *čija je vrednost trenutno najmanja(u slučaju rastućeg poretka)*/
			numbers.set(i, numbers.get(minIndex));
			numbers.set(minIndex, temp);
		}
	}

	public static void main(String[] args) {
		/*Instancijalizacija klase RandomNumbers*/
		RandomNumbers rN = new RandomNumbers();
		/*Dodeljivanje nasumičnih vrednosti novoj listi celih brojeva: */
		List<Integer> brojevi = rN.random;
		
		/*Štampanje elemenata liste: */
		System.out.println("Pre sortiranja:");
		for(int number : brojevi) {
			System.out.println(number);
		}
		
		long selectionStart = System.nanoTime();
		/*pozivanje metode selectionSort()*/
		selectionSort(brojevi);
		long selectionEnd = System.nanoTime();
		
		System.out.println("Nakon sortiranja:");
		for(int number : brojevi) {
			System.out.println(number);
		}
		
		float time = selectionEnd - selectionStart;
		System.out.println("Ukupno vreme sortiranja: "+time+"ns");
	}

}
