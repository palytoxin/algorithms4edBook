package cheaper2;

import java.util.Random;

@SuppressWarnings("rawtypes")
public class MergeBU extends Example {
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
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += (sz + sz)) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
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

        sort(a1);

        assert isSorted(a1);

        show(a1);
    }

}
