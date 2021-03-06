package cheaper2;

import java.util.Random;

@SuppressWarnings("rawtypes")
public class Merge extends Example {
	private static Comparable[] aux;

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	// 自顶向下的归并
	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);// 将左半边排序
		sort(a, mid + 1, hi);// 将右半边排序
		merge(a, lo, mid, hi);// 归并排序
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

		sort(a1);

		assert isSorted(a1);

		show(a1);
	}
}
