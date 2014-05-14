package cheaper3;

import java.math.BigInteger;

/**
 * Created by yan on 14-5-14.
 */
public class Ferb {
    public static BigInteger fer(BigInteger f) {
        if (f.equals(BigInteger.valueOf(1)) || f.equals(BigInteger.valueOf(2))) {
            return (f);
        } else {
            return fer(f.subtract(BigInteger.valueOf(1))).add(fer(f.subtract(BigInteger.valueOf(2))));
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(fer(BigInteger.valueOf(i)) + " ");
            if (i % 5 == 0) {
                System.out.println("=========="+i);
            }
        }
    }
}
