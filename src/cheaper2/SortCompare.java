package cheaper2;

import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.Stopwatch;

public class SortCompare {
	@SuppressWarnings("rawtypes")
	public static double time(String alg, Comparable[] a){
		Stopwatch timer = new Stopwatch();
		if (alg.equals('I')) Insertion.sort(a);
		if (alg.equals("Se")) Selection.sort(a);
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String alg, int N, int T){
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++){
			for (int i = 0; i < N; i++)
				a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String[] args) {
		String[] args1 = new String[4];
		args1[0] = "I";
		args1[1] = "Se";
		args1[2] = "1000";
		args1[3] = "5000";
		String alg1 = args1[0];
		String alg2 = args1[1];
		int N = Integer.parseInt(args1[2]);
		int T = Integer.parseInt(args1[3]);
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
	}
}
