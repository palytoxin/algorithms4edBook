package cheaper2;

import java.util.Random;

import stdlib.StdRandom;

@SuppressWarnings("rawtypes")
public class QuickInsertion extends Example{
	public static int M = 5;
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo + M){
			Insertion.sort(a, lo, hi + 1);
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi); //  notice: var j
	}

	// 基本切分办法
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			// 左查
			while (less(a[++i], v))
				if (i == hi)// 冗余判断
					break;
			// 右查
			while (less(v, a[--j]))
				if (j == lo)// 冗余判断
					break;
			// 除非 i/j 合一才去break
			if (i >= j)
				break;
			exch(a, i, j);
		}
		// 交换切分元素，和左侧列表的最右元素
		exch(a, lo, j);

		return j;
	}

	public static void main(String[] args) {
		Random r = new Random();
		Integer[] a = new Integer[20];
		for (int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(20);
		}
		show(a);

		sort(a);
		assert isSorted(a);
		show(a);
	}
}
