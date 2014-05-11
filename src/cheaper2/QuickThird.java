package cheaper2;

import stdlib.StdRandom;

/*
 * 三向切分的快速排序
 * Dijkstra
 */
@SuppressWarnings("rawtypes")
public class QuickThird extends Example {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	@SuppressWarnings("unchecked")
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo;
		int i = lo + 1;
		int gt = hi;
		Comparable v = a[lo];
		while (i <= gt) {
			int cmp = v.compareTo(a[i]);

			if (cmp > 0) {
				exch(a, lt++, i++);
			} else if (cmp < 0) {
				exch(a, i, gt--);
			} else {
				i++;
			}
		}

		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}

}
