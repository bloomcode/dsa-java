import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/** Chapter 1.3 tests, one class per exercise. */

final class Ch1_3TimingTest {
    private Ch1_3TimingTest() {}

    static int[] descending(int n) {
        int[] d = new int[n];
        for (int i = 0; i < n; i++) d[i] = n - i;
        return d;
    }

    static int[] builtinSorted(int[] x) {
        int[] c = x.clone();
        Arrays.sort(c);
        return c;
    }
}

class Ex1_3_1Test {
    public static void run() {
        Ch1_3Timing.Timed<Long> timed = Ch1_3Timing.timeOnce(() -> IntStream.range(0, 1_000_000).asLongStream().sum());
        Check.eq(timed.result(), 499999500000L);
        Check.yes(timed.seconds() >= 0);
    }
}

class Ex1_3_2Test {
    public static void run() {
        int[] data = IntStream.range(0, 1000).toArray();
        Check.yes(Ch1_3Timing.bench(() -> Arrays.sort(data.clone()), 50, 3) > 0);
    }
}

class Ex1_3_3Test {
    public static void run() {
        int[] desc = Ch1_3TimingTest.descending(10_000);
        Check.yes(Ch1_3Timing.benchSort(Arrays::sort, desc, 5) > 0);
        Check.eq(desc[0], 10_000); // each run sorts a fresh copy
    }
}

class Ex1_3_4Test {
    public static void run() {
        Map<Integer, Double> timings = new LinkedHashMap<>();
        timings.put(1000, 0.01);
        timings.put(2000, 0.04);
        timings.put(4000, 0.16);
        Check.near(Ch1_3Timing.growthExponent(timings), 2.0, 1e-9);
        Map<Integer, Double> linear = new LinkedHashMap<>();
        linear.put(10, 1.0);
        linear.put(100, 10.0);
        linear.put(1000, 100.0);
        Check.near(Ch1_3Timing.growthExponent(linear), 1.0, 1e-9);
    }
}

class Ex1_3_5Test {
    public static void run() {
        int[] desc = Ch1_3TimingTest.descending(10_000);
        Map<String, UnaryOperator<int[]>> sorts = new LinkedHashMap<>();
        sorts.put("builtin", Ch1_3TimingTest::builtinSorted);
        sorts.put("reverseTwice", x -> {
            int[] c = Ch1_3TimingTest.builtinSorted(x);
            return c.clone();
        });
        Check.eq(new HashSet<>(Ch1_3Timing.race(sorts, desc)), new HashSet<>(List.of("builtin", "reverseTwice")));
        sorts.put("broken", x -> x);
        Check.throwsEx(AssertionError.class, () -> Ch1_3Timing.race(sorts, desc));
    }
}

class Ex1_3_6Test {
    public static void run() {
        Check.eq(Ch1_3Timing.quicksortComparisons(IntStream.range(0, 100).toArray()), 4950L);
        int[] shuffled = IntStream.range(0, 100).toArray();
        Random rng = new Random(4);
        for (int i = shuffled.length - 1; i > 0; i--) {
            int j = rng.nextInt(i + 1), t = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = t;
        }
        Check.yes(Ch1_3Timing.quicksortComparisons(shuffled) < 1500);
        Check.eq(Ch1_3Timing.quicksortComparisons(IntStream.range(0, 20_000).toArray()), 199990000L);
    }
}

class Ex1_3_7Test {
    public static void run() {
        Check.eq(Ch1_3Timing.countRuns(new int[]{1, 2, 3, 2, 5, 6, 1}), 3);
        Check.eq(Ch1_3Timing.countRuns(IntStream.range(0, 9).toArray()), 1);
        Check.eq(Ch1_3Timing.countRuns(new int[]{}), 0);
    }
}
