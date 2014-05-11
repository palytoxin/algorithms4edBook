package cheaper2;

import stdlib.StdIn;

@SuppressWarnings("rawtypes")
public class Insertion extends Example {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++){
			for (int j = i; j>0 && less(a[j], a[j-1]); j--){
				exch(a, j, j-1);
			}
		}
	}

	public static void sort(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i < hi; i++){
			for (int j = i; j>lo && less(a[j], a[j-1]); j--){
				exch(a, j, j-1);
			}
		}
	}
	
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
