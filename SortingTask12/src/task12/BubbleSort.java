package task12;

import java.util.List;

public class BubbleSort {

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
		/*Deklaracija boolean promenljive*/
		boolean zamenjenElement;
		/*Korišćenje metode nanoTime() za merenje vremena potrebnog za sortiranje*/
		long bubbleStart = System.nanoTime();
		do {
			/*Uslov potreban za izlaženje iz while petlje: */
			zamenjenElement=false;
			/*Prolaženje kroz listu elemenata od prvog do pretposlednjeg elementa:*/
			for (int i = 0; i < brojevi.size() - 1; i++) {
				/*Poređenje trenutnog i narednog elementa: */
				if (brojevi.get(i) > brojevi.get(i + 1)) {
					/*Dokle god je uslov ispunjen, prolazi se kroz while petlju.*/
					zamenjenElement=true;
					/*Zamena redosleda elemenata u listi:*/
					int temp = brojevi.get(i);
					brojevi.set(i, brojevi.get(i + 1));
					brojevi.set(i + 1, temp);
				}
			} 
			
		}while (zamenjenElement);
		long bubbleEnd = System.nanoTime();
		
		System.out.println("Nakon sortiranja:");
		for(int number : brojevi) {
			System.out.println(number);
		}
				
		float time = bubbleEnd-bubbleStart;
		System.out.println("Ukupno vreme sortiranja: "+time+"ns");
		
	}

}
