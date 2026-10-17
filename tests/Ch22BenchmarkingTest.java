import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/** Chapter 22 tests, one class per exercise. */
final class Ch22BenchmarkingTest {
    private Ch22BenchmarkingTest() {}

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

class Ex22_1Test {
    public static void run() {
        Ch22Benchmarking.Timed<Long> timed = Ch22Benchmarking.timeOnce(() -> IntStream.range(0, 1_000_000).asLongStream().sum());
        Check.eq(timed.result(), 499999500000L);
        Check.yes(timed.seconds() >= 0);
    }
}

class Ex22_2Test {
    public static void run() {
        int[] data = IntStream.range(0, 1000).toArray();
        Check.yes(Ch22Benchmarking.bench(() -> Arrays.sort(data.clone()), 50, 3) > 0);
    }
}

class Ex22_3Test {
    public static void run() {
        int[] desc = Ch22BenchmarkingTest.descending(10_000);
        Check.yes(Ch22Benchmarking.benchSort(Arrays::sort, desc, 5) > 0);
        Check.eq(desc[0], 10_000); // each run sorts a fresh copy
    }
}

class Ex22_4Test {
    public static void run() {
        Map<Integer, Double> timings = new LinkedHashMap<>();
        timings.put(1000, 0.01);
        timings.put(2000, 0.04);
        timings.put(4000, 0.16);
        Check.near(Ch22Benchmarking.growthExponent(timings), 2.0, 1e-9);
        Map<Integer, Double> linear = new LinkedHashMap<>();
        linear.put(10, 1.0);
        linear.put(100, 10.0);
        linear.put(1000, 100.0);
        Check.near(Ch22Benchmarking.growthExponent(linear), 1.0, 1e-9);
    }
}

class Ex22_5Test {
    public static void run() {
        int[] desc = Ch22BenchmarkingTest.descending(10_000);
        Map<String, UnaryOperator<int[]>> sorts = new LinkedHashMap<>();
        sorts.put("builtin", Ch22BenchmarkingTest::builtinSorted);
        sorts.put("reverseTwice", x -> {
            int[] c = Ch22BenchmarkingTest.builtinSorted(x);
            return c.clone();
        });
        Check.eq(new HashSet<>(Ch22Benchmarking.race(sorts, desc)), new HashSet<>(List.of("builtin", "reverseTwice")));
        sorts.put("broken", x -> x);
        Check.throwsEx(AssertionError.class, () -> Ch22Benchmarking.race(sorts, desc));
    }
}

class Ex22_6Test {
    public static void run() {
        Check.eq(Ch22Benchmarking.quicksortComparisons(IntStream.range(0, 100).toArray()), 4950L);
        int[] shuffled = IntStream.range(0, 100).toArray();
        Random rng = new Random(4);
        for (int i = shuffled.length - 1; i > 0; i--) {
            int j = rng.nextInt(i + 1), t = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = t;
        }
        Check.yes(Ch22Benchmarking.quicksortComparisons(shuffled) < 1500);
        Check.eq(Ch22Benchmarking.quicksortComparisons(IntStream.range(0, 20_000).toArray()), 199990000L);
    }
}

class Ex22_7Test {
    public static void run() {
        Check.eq(Ch22Benchmarking.countRuns(new int[]{1, 2, 3, 2, 5, 6, 1}), 3);
        Check.eq(Ch22Benchmarking.countRuns(IntStream.range(0, 9).toArray()), 1);
        Check.eq(Ch22Benchmarking.countRuns(new int[]{}), 0);
    }
}
