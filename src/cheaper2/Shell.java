package cheaper2;

import stdlib.StdIn;

public class Shell extends Example {
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a){
		int N = a.length;
		int h = 1;
		while (h < N/3) {
			h = 3*h + 1;//1, 4, 13, 40, 121, 364, 1093
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				// 将a[i] 插入到a[i-h], a[i-2h],a[i-3h] 中  
				for (int j = i; j >= h && less(a[j], a[j-h]) ; j-=h) {
					exch(a, j, j-h);
				}
			}
			h /= 3;
		}
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
