import java.math.BigInteger;
import java.util.Random;

/** Chapter 29 tests, one class per exercise. */
class Ex29_1Test {
    public static void run() {
        Check.near(Ch29MonteCarlo.estimatePi(100_000, new Random(0)), Math.PI, 0.02);
    }
}

class Ex29_2Test {
    public static void run() {
        int[] big = new int[1_000_000];
        Random rd = new Random(4);
        for (int i = 0; i < big.length; i++) big[i] = 50 + rd.nextInt(101);
        double exact = Ch29MonteCarlo.exactMean(big);
        Check.yes(Math.abs(Ch29MonteCarlo.sampledMean(big, 2000, new Random(1)) - exact) / exact < 0.02);
        Check.near(Ch29MonteCarlo.exactMean(new int[]{1, 2, 3, 6}), 3.0, 1e-12);
    }
}

class Ex29_3Test {
    public static void run() {
        int[] half = new int[1000];
        for (int i = 0; i < 1000; i += 2) half[i] = 1;
        Random rf = new Random(3);
        Check.eq(half[Ch29MonteCarlo.lasVegasFindOne(half, rf)], 1);
        int mc = Ch29MonteCarlo.monteCarloFindOne(half, rf, 20);
        Check.yes(mc >= 0 && half[mc] == 1);
        Check.eq(Ch29MonteCarlo.monteCarloFindOne(new int[10], rf, 20), -1);
    }
}

class Ex29_4Test {
    public static void run() {
        Check.yes(Ch29MonteCarlo.isPrimeTrial(999_999_000_001L));
        Check.no(Ch29MonteCarlo.isPrimeTrial(999_999_000_003L));
        Check.no(Ch29MonteCarlo.isPrimeTrial(1));
        Check.yes(Ch29MonteCarlo.isPrimeTrial(2));
    }
}

class Ex29_5Test {
    public static void run() {
        Check.yes(Ch29MonteCarlo.fermatWitness(2, 15));
        Check.no(Ch29MonteCarlo.fermatWitness(2, 13));
        Check.no(Ch29MonteCarlo.fermatWitness(2, 561));
        for (long a = 2; a < 561; a++)
            if (BigInteger.valueOf(a).gcd(BigInteger.valueOf(561)).equals(BigInteger.ONE)) Check.no(Ch29MonteCarlo.fermatWitness(a, 561));
        Random rm = new Random(13);
        for (int i = 0; i < 300; i++) {
            long a = rm.nextLong() >>> 1, e = rm.nextLong() >>> 1, n = 1 + (rm.nextLong() >>> 1);
            Check.eq(Ch29MonteCarlo.powMod(a, e, n), BigInteger.valueOf(a).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n)).longValue());
        }
    }
}

class Ex29_6Test {
    public static void run() {
        Random rp = new Random(9);
        Check.yes(Ch29MonteCarlo.fermatTest(1_000_000_007, 20, rp));
        Check.no(Ch29MonteCarlo.fermatTest(1_000_000_007L * 998_244_353, 20, rp));
    }
}

class Ex29_7Test {
    public static void run() {
        Check.no(Ch29MonteCarlo.millerRabin(561));
        Check.yes(Ch29MonteCarlo.millerRabin((1L << 61) - 1));
        Check.no(Ch29MonteCarlo.millerRabin(1_000_000_007L * 998_244_353));
        Check.yes(Ch29MonteCarlo.millerRabin(Long.MAX_VALUE - 24)); // 2^63 - 25 is prime
        Check.no(Ch29MonteCarlo.millerRabin(1));
        Random rm = new Random(12);
        for (int i = 0; i < 2000; i++) {
            long n = i < 1000 ? 1 + rm.nextInt(100_000) : 1 + (rm.nextLong() >>> 1);
            Check.eq(Ch29MonteCarlo.millerRabin(n), BigInteger.valueOf(n).isProbablePrime(50));
        }
        for (long c : new long[]{561, 1105, 1729, 2465, 2821, 6601}) Check.no(Ch29MonteCarlo.millerRabin(c));
    }
}

class Ex29_8Test {
    public static void run() {
        double be = Ch29MonteCarlo.birthdayExact(23);
        Check.near(be, 0.5072972343, 1e-9);
        Check.near(Ch29MonteCarlo.birthdaySimulation(23, 20_000, new Random(2)), 0.5072972343, 0.02);
    }
}
