package practice;

import java.util.Random;

import cheaper2.Example;

@SuppressWarnings("rawtypes")
public class Practice extends Example {
	public static void insertionSort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
			}
		}
	}

	public static void selectionSort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i; j < a.length; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a, min, i);
		}
	}

	public static void shellSort(Comparable[] a) {
		int h = 1;
		while (h < a.length / 3) {
			h = 3 * h + 1;
		}
		while (h > 0) {
			for (int i = h; i < a.length; i++) {
				for (int j = i; j >= h ; j -= h) {
					if (less(a[j], a[j-h]))
						exch(a, j, j-h);;
				}
			}
			h /= 3;
		}
	}

	public static void main(String[] args) {
		int N = 20;
		Random r = new Random();
		Integer[] it = new Integer[N];
		for (int i = 0; i < it.length; i++) {
			it[i] = r.nextInt(100);
		}
		Integer[] a = new Integer[N];// StdIn.readAllStrings();
		System.arraycopy(it, 0, a, 0, a.length);
		Integer[] a1 = a.clone();
		Integer[] a2 = a.clone();
		Integer[] a3 = a.clone();

		insertionSort(a1);
		selectionSort(a2);
		shellSort(a3);

		assert isSorted(a1);
		assert isSorted(a2);
		assert isSorted(a3);

		show(a1);
		show(a2);
		show(a3);
	}
}
