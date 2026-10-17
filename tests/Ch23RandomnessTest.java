import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/** Chapter 23 tests, one class per exercise. */
final class Ch23RandomnessTest {
    private Ch23RandomnessTest() {}

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

class Ex23_1Test {
    public static void run() {
        List<Integer> ten = new ArrayList<>();
        for (int i = 0; i < 10; i++) ten.add(i);
        Check.eq(Ch23Randomness.randomQuicksort(ten, new Random(1)), ten);
        Check.eq(Ch23Randomness.randomQuicksort(List.of(3, 1, 3, 2, 2, 9, 0), new Random(2)), List.of(0, 1, 2, 2, 3, 3, 9));
        Check.eq(Ch23Randomness.randomQuicksort(List.of(), new Random(3)), List.of());
    }
}

class Ex23_2Test {
    public static void run() {
        List<Integer> pop = new ArrayList<>();
        for (int i = 0; i < 100; i++) pop.add(i);
        List<Integer> s1 = Ch23Randomness.sampleWithSeed(42, pop, 3);
        Check.eq(s1, Ch23Randomness.sampleWithSeed(42, pop, 3));
        Check.eq(new HashSet<>(s1).size(), 3);
    }
}

class Ex23_3Test {
    public static void run() {
        Ch23Randomness.Lcg g = new Ch23Randomness.Lcg(1, 5, 3, 16);
        Check.eq(new long[]{g.next(), g.next(), g.next()}, new long[]{8, 11, 10});
        Check.eq(Ch23Randomness.lcgPeriod(1, 5, 3, 16), 16);
        Ch23Randomness.Lcg big = new Ch23Randomness.Lcg(7);
        long prev = -1;
        for (int i = 0; i < 1000; i++) {
            long x = big.next();
            Check.yes(x >= 0 && x < (1L << 31) && x != prev);
            prev = x;
        }
    }
}

class Ex23_4Test {
    public static void run() {
        int[] fy1 = Ch23Randomness.fisherYates(new int[]{1, 2, 3, 4, 5}, new Random(7));
        int[] fy2 = Ch23Randomness.fisherYates(new int[]{1, 2, 3, 4, 5}, new Random(7));
        Check.eq(fy1, fy2);
        int[] sorted = fy1.clone();
        Arrays.sort(sorted);
        Check.eq(sorted, new int[]{1, 2, 3, 4, 5});
    }
}

class Ex23_5Test {
    public static void run() {
        Check.eq(Ch23Randomness.naiveDistribution(3).toString(), "{012=4, 021=5, 102=5, 120=5, 201=4, 210=4}");
        Map<String, Integer> fyd = Ch23Randomness.fisherYatesDistribution(3);
        Check.eq(fyd.size(), 6);
        Check.eq(new HashSet<>(fyd.values()), new HashSet<>(List.of(1)));
        Check.eq(Ch23Randomness.fisherYatesDistribution(4).size(), 24);
    }
}

class Ex23_6Test {
    public static void run() {
        Check.eq(Ch23Randomness.bstHeight(IntStream.range(0, 200).toArray()), 200);
        int h = Ch23Randomness.bstHeight(Ch23RandomnessTest.shuffled(200, 3));
        Check.yes(h >= 10 && h <= 25);
        Check.eq(Ch23Randomness.bstHeight(IntStream.range(0, 100_000).toArray()), 100_000);
    }
}

class Ex23_7Test {
    public static void run() {
        int[] res = Ch23Randomness.reservoir(IntStream.range(0, 1_000_000).iterator(), 3, new Random(0));
        Check.eq(res.length, 3);
        Check.eq(new HashSet<>(List.of(res[0], res[1], res[2])).size(), 3);
        Check.eq(Ch23Randomness.reservoir(IntStream.range(0, 2).iterator(), 5, new Random(0)), new int[]{0, 1});
        int[] firstPick = new int[10];
        Random rr = new Random(9);
        for (int t = 0; t < 20_000; t++) firstPick[Ch23Randomness.reservoir(IntStream.range(0, 10).iterator(), 1, rr)[0]]++;
        for (int c : firstPick) Check.yes(c > 1700 && c < 2300);
    }
}

class Ex23_8Test {
    public static void run() {
        int one = Ch23Randomness.maxLoadRandom(10_000, 1_000, new Random(5));
        int two = Ch23Randomness.maxLoadTwoChoices(10_000, 1_000, new Random(5));
        Check.yes(two < one);
        Check.yes(two <= 14);
    }
}

class Ex23_9Test {
    public static void run() {
        IntSupplier pick = Ch23Randomness.makeWeightedPicker(new double[]{1, 3, 6}, new Random(8));
        int[] counts = new int[3];
        for (int i = 0; i < 10_000; i++) counts[pick.getAsInt()]++;
        Check.yes(Math.abs(counts[2] - 6000) < 300 && Math.abs(counts[0] - 1000) < 200);
    }
}
