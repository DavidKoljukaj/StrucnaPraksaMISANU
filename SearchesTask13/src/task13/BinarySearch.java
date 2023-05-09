package task13;

public class BinarySearch {
	
	public static int binarySearch(int[] array, int target) {
		int firstEl = 0;
		int lastEl = array.length-1;
		
		while(firstEl<=lastEl) {
			int middleEl = (firstEl + lastEl) / 2;
			int middleValue = array[middleEl];
			if(target == middleValue) {
				return middleEl;
			}
			if(target<middleValue) {
				lastEl = middleEl - 1;
			}
			else {
				firstEl = middleEl +1;
			}
		}
		return -1;
	}
	
	public static String inArray(int [] array,int target) {
		int bS = binarySearch(array,target);
		if(bS != -1) {
			return "Traženi element se nalazi u nizu i ima indeks: " + bS;
		}
		else {
			return "Traženi element nije u nizu.";
		}
	}

	public static void main(String[] args) {
		
		int [] nizCifara = new int [1000];
		
		for(int i =0;i<nizCifara.length;i++) {
			nizCifara[i]=(int)(Math.random()*1000);
		}
		
		MergeSort.mergeSort(nizCifara);	
		System.out.println(inArray(nizCifara,65));

	}

}
