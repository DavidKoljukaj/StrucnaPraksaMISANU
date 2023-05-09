package task13;

public class FibonacciSearch {
	
	public static int fibonacciSearch(int[] array, int target) {
		int x0=0, x1=1, xn=x0+x1, i;
		while(xn<array.length) {
			x0=x1;
			x1=xn;
			xn=x0+x1;
		}
		int offset = -1;
		while(xn>1) {
			i=Math.min(offset+x0, array.length-1);
			if(array[i]<target) {
				xn = x1;
				x1 = x0;
				x0 = xn - x1;
				offset = i;
			}
			else if(array[i] > target) {
				xn = x0;
				x1 = x1 - x0;
				x0 = xn - x1;
			}
			else {
				return i;
			}
		}
		if(x1 !=0 && array[offset+1]==target) {
			return offset;
		}
		return -1;
	}
	
	public static String inArray(int [] array,int target) {
		int fS = fibonacciSearch(array,target);
		if(fS != -1) {
			return "Traženi element se nalazi u nizu i ima indeks: " + fS;
		}
		else {
			return "Traženi element nije u nizu.";
		}
	}

	public static void main(String[] args) {
		int [] nizCifara = new int [100];
		
		for(int i =0;i<nizCifara.length;i++) {
			nizCifara[i]=(int)(Math.random()*100);
		}
		
		MergeSort.mergeSort(nizCifara);	
		
		for(int cifra : nizCifara) {
			System.out.println(cifra);
		}
		System.out.println(inArray(nizCifara,66));
		
	}

}
