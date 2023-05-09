package task13;

public class LinearSearch {
	
	public static int linearSearch(int [] array, int target) {
		for(int i = 0; i<array.length;i++) {
			if(array[i]==target) {
				return i;
			}
		}
		return -1;
	}
	
	public static String inArray(int [] array,int target) {
		int lS = linearSearch(array,target);
		if(lS != -1) {
			return "Traženi element se nalazi u nizu i ima indeks: " + lS;
		}
		else {
			return "Traženi element nije u nizu.";
		}
	}

	public static void main(String[] args) {

		/*Linear Search je metod za pronalaženje elementa unutar liste.
		 *Koristi se na malim i srednjim skupovima vrednosti,jer ne zahteva 
		 *prethodno sortiranje, ali nije optimalan za veće liste jer mora
		 *da proveri sve vrednosti.
		 *Linear Search sekvencionalno proverava svaki element iz liste
		 *dok ne pronađe traženu vrednost. Ukoliko algoritam ne pronađe 
		 *zadati element, pretraga se završava neuspešno.*/
		
		int [] nizCifara = {7,9,4,6,5,3};
		System.out.println(inArray(nizCifara,5));
	}

}
