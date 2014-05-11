package test;

import java.util.Random;

import stdlib.StdOut;

@SuppressWarnings("rawtypes")
public class CommonMethods {
	@SuppressWarnings("unchecked")
	protected static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}

	protected static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public Comparable[] ran() {
		int N = 100;
		Random r = new Random();
		Integer[] a = new Integer[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(N);
		}
		return a;
	}

}
