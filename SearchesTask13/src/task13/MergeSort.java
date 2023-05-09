package task13;

public class MergeSort {
	
	public static void mergeSort(int[] numbers) {
		
		int velicinaNiza = numbers.length;
		if(velicinaNiza < 2) {
			/*Ukoliko je metod pozvan, a niz ima samo jedan ili nijedan element */
			return;
		}
		/*Sredina niza:*/
		int iMiddle = velicinaNiza/2;
		/*Niz u kome će biti smešteni elementi od nultog indeksa do sredine liste:*/
		int[] levaStrana = new int[iMiddle];
		/*Za slučaj da niz ima neparan broj elemenata, veličina desne strane
		 *se određuje oduzimanjem sredine(rezultat celobrojnog deljenja) 
		 *od ukupnog broja elemenata*/
		int[] desnaStrana = new int[velicinaNiza - iMiddle];
	
		/*Naseljavanje niza koji predstavlja levu stranu originalnog niza:*/
		for(int i =0;i<iMiddle;i++) {
			levaStrana[i]=numbers[i];
		}
		/*Naseljavanje niza koji predstavlja desnu stranu originalnog niza:*/
		for(int i =iMiddle;i<velicinaNiza;i++) {
			/*Da bismo dobili pravilno indeksiranje desnog niza moramo
			 *oduzeti promenljivu iMiddle od trenutnog indeksa:*/
			desnaStrana[i-iMiddle]=numbers[i];
			
		}
		/*Sortiranje leve i desne strane korišćenjem rekurzije:*/
		mergeSort(levaStrana);
		mergeSort(desnaStrana);
		
		mergeHalves(numbers,levaStrana,desnaStrana);
	}
	
	public static void mergeHalves(int[] numbers,int[] levo,int[] desno) {
		int velicinaLevo = levo.length;
		int velicinaDesno = desno.length;
		/*Tri indeksa potrebna za poređenje elemenata u levom(i), desnom(j) i "merge(k)" nizu*/
		int i=0,j=0,k=0;
		
		/*Dokle god postoje elementi u levom ili desnom nizu, izvršava se kod
		 *u while petlji:*/
		while(i<velicinaLevo && j < velicinaDesno) {
			if(levo[i]<=desno[j]) {
				/*Ukoliko je element u levom nizu manji od elementa u desnom nizu
				 *dodajemo ga u merge niz i povećavamo indeks za 1:*/
				numbers[k]=levo[i];
				i++;
			}
			else {
				/*U suprotnom dodajemo element iz desnog niza u merge niz:*/
				numbers[k]=desno[j];
				j++;
			}
			/*Nakon dodavanja elementa iz jednog od nizova,
			 *inkrementiramo indeks merge niza:*/
			k++;
		}
		/*Ukoliko više nema elemenata za poređenje u desnom nizu, preostale
		 *elemente iz levog niza dodajemo u novoj while petlji:*/
		while(i<velicinaLevo) {
			numbers[k]=levo[i];
			i++;
			k++;
		}
		/*Ukoliko su "potrošeni" elementi iz levog niza, preostale
		 *elemente iz desnog niza dodajemo u merge niz:*/
		while(j<velicinaDesno) {
			numbers[k]=desno[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		
		int[] brojevi = new int [10];
		for(int i = 0;i<brojevi.length;i++) {
			brojevi[i]=(int)(Math.random()*100);
		}
	
		
		/*Štampanje elemenata liste: */
		System.out.println("Pre sortiranja:");
		for(int number : brojevi) {
			System.out.println(number);
		}
		
		long mergeStart = System.nanoTime();
		/*pozivanje metode mergeSort()*/
		mergeSort(brojevi);
		long mergeEnd = System.nanoTime();
		
		System.out.println("Nakon sortiranja:");
		for(int number : brojevi) {
			System.out.println(number);
		}
		
		float time = mergeEnd - mergeStart;
		System.out.println("Ukupno vreme sortiranja: "+time+"ns");
	}

}
