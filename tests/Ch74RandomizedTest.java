import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/** Chapter 74 tests, one class per exercise. */

final class Ch74RandomizedTest {
    private Ch74RandomizedTest() {}

    static int[] shuffled(int n, long seed) {
        int[] a = IntStream.range(0, n).toArray();
        Random rng = new Random(seed);
        for (int i = n - 1; i > 0; i--) {
            int j = rng.nextInt(i + 1), t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        return a;
    }
}

class Ex74_1Test {
    public static void run() {
        List<Integer> ten = new ArrayList<>();
        for (int i = 0; i < 10; i++) ten.add(i);
        Check.eq(Ch74Randomized.randomQuicksort(ten, new Random(1)), ten);
        Check.eq(Ch74Randomized.randomQuicksort(List.of(3, 1, 3, 2, 2, 9, 0), new Random(2)), List.of(0, 1, 2, 2, 3, 3, 9));
        Check.eq(Ch74Randomized.randomQuicksort(List.of(), new Random(3)), List.of());
    }
}

class Ex74_2Test {
    public static void run() {
        List<Integer> pop = new ArrayList<>();
        for (int i = 0; i < 100; i++) pop.add(i);
        List<Integer> s1 = Ch74Randomized.sampleWithSeed(42, pop, 3);
        Check.eq(s1, Ch74Randomized.sampleWithSeed(42, pop, 3));
        Check.eq(new HashSet<>(s1).size(), 3);
    }
}

class Ex74_3Test {
    public static void run() {
        Ch74Randomized.Lcg g = new Ch74Randomized.Lcg(1, 5, 3, 16);
        Check.eq(new long[]{g.next(), g.next(), g.next()}, new long[]{8, 11, 10});
        Check.eq(Ch74Randomized.lcgPeriod(1, 5, 3, 16), 16);
        Ch74Randomized.Lcg big = new Ch74Randomized.Lcg(7);
        long prev = -1;
        for (int i = 0; i < 1000; i++) {
            long x = big.next();
            Check.yes(x >= 0 && x < (1L << 31) && x != prev);
            prev = x;
        }
    }
}

class Ex74_4Test {
    public static void run() {
        int[] fy1 = Ch74Randomized.fisherYates(new int[]{1, 2, 3, 4, 5}, new Random(7));
        int[] fy2 = Ch74Randomized.fisherYates(new int[]{1, 2, 3, 4, 5}, new Random(7));
        Check.eq(fy1, fy2);
        int[] sorted = fy1.clone();
        Arrays.sort(sorted);
        Check.eq(sorted, new int[]{1, 2, 3, 4, 5});
    }
}

class Ex74_5Test {
    public static void run() {
        Check.eq(Ch74Randomized.naiveDistribution(3).toString(), "{012=4, 021=5, 102=5, 120=5, 201=4, 210=4}");
        Map<String, Integer> fyd = Ch74Randomized.fisherYatesDistribution(3);
        Check.eq(fyd.size(), 6);
        Check.eq(new HashSet<>(fyd.values()), new HashSet<>(List.of(1)));
        Check.eq(Ch74Randomized.fisherYatesDistribution(4).size(), 24);
    }
}

class Ex74_6Test {
    public static void run() {
        Check.eq(Ch74Randomized.bstHeight(IntStream.range(0, 200).toArray()), 200);
        int h = Ch74Randomized.bstHeight(Ch74RandomizedTest.shuffled(200, 3));
        Check.yes(h >= 10 && h <= 25);
        Check.eq(Ch74Randomized.bstHeight(IntStream.range(0, 100_000).toArray()), 100_000);
    }
}

class Ex74_7Test {
    public static void run() {
        int[] res = Ch74Randomized.reservoir(IntStream.range(0, 1_000_000).iterator(), 3, new Random(0));
        Check.eq(res.length, 3);
        Check.eq(new HashSet<>(List.of(res[0], res[1], res[2])).size(), 3);
        Check.eq(Ch74Randomized.reservoir(IntStream.range(0, 2).iterator(), 5, new Random(0)), new int[]{0, 1});
        int[] firstPick = new int[10];
        Random rr = new Random(9);
        for (int t = 0; t < 20_000; t++) firstPick[Ch74Randomized.reservoir(IntStream.range(0, 10).iterator(), 1, rr)[0]]++;
        for (int c : firstPick) Check.yes(c > 1700 && c < 2300);
    }
}

class Ex74_8Test {
    public static void run() {
        int one = Ch74Randomized.maxLoadRandom(10_000, 1_000, new Random(5));
        int two = Ch74Randomized.maxLoadTwoChoices(10_000, 1_000, new Random(5));
        Check.yes(two < one);
        Check.yes(two <= 14);
    }
}

class Ex74_9Test {
    public static void run() {
        IntSupplier pick = Ch74Randomized.makeWeightedPicker(new double[]{1, 3, 6}, new Random(8));
        int[] counts = new int[3];
        for (int i = 0; i < 10_000; i++) counts[pick.getAsInt()]++;
        Check.yes(Math.abs(counts[2] - 6000) < 300 && Math.abs(counts[0] - 1000) < 200);
    }
}

class Ex74_10Test {
    public static void run() {
        Check.near(Ch74Randomized.estimatePi(100_000, new Random(0)), Math.PI, 0.02);
    }
}

class Ex74_11Test {
    public static void run() {
        int[] big = new int[1_000_000];
        Random rd = new Random(4);
        for (int i = 0; i < big.length; i++) big[i] = 50 + rd.nextInt(101);
        double exact = Ch74Randomized.exactMean(big);
        Check.yes(Math.abs(Ch74Randomized.sampledMean(big, 2000, new Random(1)) - exact) / exact < 0.02);
        Check.near(Ch74Randomized.exactMean(new int[]{1, 2, 3, 6}), 3.0, 1e-12);
    }
}

class Ex74_12Test {
    public static void run() {
        int[] half = new int[1000];
        for (int i = 0; i < 1000; i += 2) half[i] = 1;
        Random rf = new Random(3);
        Check.eq(half[Ch74Randomized.lasVegasFindOne(half, rf)], 1);
        int mc = Ch74Randomized.monteCarloFindOne(half, rf, 20);
        Check.yes(mc >= 0 && half[mc] == 1);
        Check.eq(Ch74Randomized.monteCarloFindOne(new int[10], rf, 20), -1);
    }
}

class Ex74_13Test {
    public static void run() {
        Check.yes(Ch74Randomized.isPrimeTrial(999_999_000_001L));
        Check.no(Ch74Randomized.isPrimeTrial(999_999_000_003L));
        Check.no(Ch74Randomized.isPrimeTrial(1));
        Check.yes(Ch74Randomized.isPrimeTrial(2));
    }
}

class Ex74_14Test {
    public static void run() {
        Check.yes(Ch74Randomized.fermatWitness(2, 15));
        Check.no(Ch74Randomized.fermatWitness(2, 13));
        Check.no(Ch74Randomized.fermatWitness(2, 561));
        for (long a = 2; a < 561; a++)
            if (BigInteger.valueOf(a).gcd(BigInteger.valueOf(561)).equals(BigInteger.ONE)) Check.no(Ch74Randomized.fermatWitness(a, 561));
        Random rm = new Random(13);
        for (int i = 0; i < 300; i++) {
            long a = rm.nextLong() >>> 1, e = rm.nextLong() >>> 1, n = 1 + (rm.nextLong() >>> 1);
            Check.eq(Ch74Randomized.powMod(a, e, n), BigInteger.valueOf(a).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n)).longValue());
        }
    }
}

class Ex74_15Test {
    public static void run() {
        Random rp = new Random(9);
        Check.yes(Ch74Randomized.fermatTest(1_000_000_007, 20, rp));
        Check.no(Ch74Randomized.fermatTest(1_000_000_007L * 998_244_353, 20, rp));
    }
}

class Ex74_16Test {
    public static void run() {
        Check.no(Ch74Randomized.millerRabin(561));
        Check.yes(Ch74Randomized.millerRabin((1L << 61) - 1));
        Check.no(Ch74Randomized.millerRabin(1_000_000_007L * 998_244_353));
        Check.yes(Ch74Randomized.millerRabin(Long.MAX_VALUE - 24)); // 2^63 - 25 is prime
        Check.no(Ch74Randomized.millerRabin(1));
        Random rm = new Random(12);
        for (int i = 0; i < 2000; i++) {
            long n = i < 1000 ? 1 + rm.nextInt(100_000) : 1 + (rm.nextLong() >>> 1);
            Check.eq(Ch74Randomized.millerRabin(n), BigInteger.valueOf(n).isProbablePrime(50));
        }
        for (long c : new long[]{561, 1105, 1729, 2465, 2821, 6601}) Check.no(Ch74Randomized.millerRabin(c));
    }
}

class Ex74_17Test {
    public static void run() {
        double be = Ch74Randomized.birthdayExact(23);
        Check.near(be, 0.5072972343, 1e-9);
        Check.near(Ch74Randomized.birthdaySimulation(23, 20_000, new Random(2)), 0.5072972343, 0.02);
    }
}
