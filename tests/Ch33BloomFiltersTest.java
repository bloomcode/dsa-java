import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Chapter 33 tests, one class per exercise. */
final class Ch33BloomFiltersTest {
    private Ch33BloomFiltersTest() {}

    /** 5000 distinct items, then 100 repeats of earlier ones. */
    static List<String> stream() {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < 5000; i++) s.add("item-" + i);
        for (int i = 0; i < 100; i++) s.add("item-" + (i * 37));
        return s;
    }
}

class Ex33_1Test {
    public static void run() {
        int[] pos = Ch33BloomFilters.bitPositions("cat", 3, 32);
        Check.eq(pos, Ch33BloomFilters.bitPositions("cat", 3, 32));
        Check.eq(pos.length, 3);
        for (int p : pos) Check.yes(p >= 0 && p < 32);
        for (int i = 0; i < 1000; i++) for (int p : Ch33BloomFilters.bitPositions("w" + i, 7, 1_000_003)) Check.yes(p >= 0 && p < 1_000_003);
    }
}

class Ex33_2Test {
    public static void run() {
        Ch33BloomFilters.BloomFilter bf = new Ch33BloomFilters.BloomFilter(1000, 5);
        bf.add("apple");
        bf.add("pear");
        Check.yes(bf.mightContain("apple"));
        Check.yes(bf.mightContain("pear"));
        Check.no(bf.mightContain("grape"));
        Ch33BloomFilters.BloomFilter bf2 = new Ch33BloomFilters.BloomFilter(5000, 4);
        for (int i = 0; i < 300; i++) bf2.add("w" + i);
        for (int i = 0; i < 300; i++) Check.yes(bf2.mightContain("w" + i));
    }
}

class Ex33_3Test {
    public static void run() {
        Check.near(Ch33BloomFilters.falsePositiveRate(1000, 10_000, 7), 0.0082, 0.0002);
    }
}

class Ex33_4Test {
    public static void run() {
        Check.eq(Ch33BloomFilters.optimalParams(1_000_000, 0.01), new long[]{9585059, 7});
    }
}

class Ex33_5Test {
    public static void run() {
        Check.near(Ch33BloomFilters.measuredFpRate(1000, 10_000, 7, 20_000), 0.0082, 0.005);
    }
}

class Ex33_6Test {
    public static void run() {
        List<String> stream = Ch33BloomFiltersTest.stream();
        List<String> reported = Ch33BloomFilters.streamDuplicates(stream, 64_000, 6);
        Set<String> repSet = new HashSet<>(reported);
        for (int i = 0; i < 100; i++) Check.yes(repSet.contains("item-" + (i * 37)));
        int alarms = Ch33BloomFilters.falseAlarms(stream, 64_000, 6);
        Check.yes(alarms <= 15);
        Check.eq(reported.size(), 100 + alarms);
    }
}

class Ex33_7Test {
    public static void run() {
        Ch33BloomFilters.BloomFilter fx = new Ch33BloomFilters.BloomFilter(500, 4), fy = new Ch33BloomFilters.BloomFilter(500, 4);
        fx.add("x");
        fy.add("y");
        Ch33BloomFilters.BloomFilter fu = fx.union(fy);
        Check.yes(fu.mightContain("x") && fu.mightContain("y"));
        Check.eq(fu.count, 2);
        Check.throwsEx(IllegalArgumentException.class, () -> fx.union(new Ch33BloomFilters.BloomFilter(500, 3)));
    }
}

class Ex33_8Test {
    public static void run() {
        Ch33BloomFilters.CountingBloomFilter cb = new Ch33BloomFilters.CountingBloomFilter(1000, 4);
        cb.add("a");
        cb.add("b");
        Check.yes(cb.remove("a"));
        Check.no(cb.mightContain("a"));
        Check.yes(cb.mightContain("b"));
        Check.no(cb.remove("zzz"));
    }
}
