package cheaper2;

import java.io.IOException;

import stdlib.In;


public class Selection extends Example{
	public static void sort(Comparable[] a){
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;// 后方成员最小的
			for (int j = i+1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}
	public static void main(String[] args) throws IOException {
		 String[] a = In.readStrings();
		 sort(a);
		 assert isSorted(a);
		 show(a);
	}
}