package cheaper2;

import java.io.IOException;

import stdlib.StdIn;

public class Selection extends Example {
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = min; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, min, i);
		}
	}

	public static void main(String[] args) throws IOException {
		// please input Ctrl + z to send an EOF./windows
		// please input Ctrl + d to send an EOF./mac os
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
