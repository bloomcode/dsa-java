import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/** Chapter 21 tests, one class per exercise. */
final class Ch21MergesortTest {
    private Ch21MergesortTest() {}

    static int[][] randomArrays(long seed) {
        Random rnd = new Random(seed);
        int[][] out = new int[200][];
        for (int t = 0; t < out.length; t++) {
            out[t] = new int[rnd.nextInt(40)];
            for (int i = 0; i < out[t].length; i++) out[t][i] = rnd.nextInt(12) - 6;
        }
        return out;
    }

    static int[] sorted(int[] a) {
        int[] s = a.clone();
        Arrays.sort(s);
        return s;
    }
}

class Ex21_1Test {
    public static void run() {
        Check.eq(Ch21Mergesort.merge(new int[]{1, 4, 9}, new int[]{2, 3, 10, 11}), new int[]{1, 2, 3, 4, 9, 10, 11});
        Check.eq(Ch21Mergesort.merge(new int[]{}, new int[]{1}), new int[]{1});
        Check.eq(Ch21Mergesort.merge(new int[]{}, new int[]{}), new int[]{});
    }
}

class Ex21_2Test {
    public static void run() {
        Check.eq(Ch21Mergesort.mergeComparisons(new int[]{1, 2, 3}, new int[]{4, 5, 6}), 3);
        Check.eq(Ch21Mergesort.mergeComparisons(new int[]{1, 3, 5}, new int[]{2, 4, 6}), 5);
    }
}

class Ex21_3Test {
    public static void run() {
        Check.eq(Ch21Mergesort.mergesort(new int[]{38, 27, 43, 3, 9, 82, 10}), new int[]{3, 9, 10, 27, 38, 43, 82});
        for (int[] r : Ch21MergesortTest.randomArrays(1)) Check.eq(Ch21Mergesort.mergesort(r), Ch21MergesortTest.sorted(r));
    }
}

class Ex21_4Test {
    public static void run() {
        int[] a = {5, 2, 4, 6, 1, 3};
        Ch21Mergesort.mergesortInPlace(a);
        Check.eq(a, new int[]{1, 2, 3, 4, 5, 6});
        for (int[] r : Ch21MergesortTest.randomArrays(2)) Check.eq(Ch21Mergesort.mergesortInPlace(r.clone()), Ch21MergesortTest.sorted(r));
    }
}

class Ex21_5Test {
    public static void run() {
        Check.eq(Ch21Mergesort.mergesortBottomUp(new int[]{5, 1, 4, 2, 8, 0, 2}), new int[]{0, 1, 2, 2, 4, 5, 8});
        for (int[] r : Ch21MergesortTest.randomArrays(3)) Check.eq(Ch21Mergesort.mergesortBottomUp(r), Ch21MergesortTest.sorted(r));
    }
}

class Ex21_6Test {
    public static void run() {
        Check.eq(Ch21Mergesort.countInversions(new int[]{2, 4, 1, 3, 5}), 3L);
        Check.eq(Ch21Mergesort.countInversions(new int[]{5, 4, 3, 2, 1}), 10L);
        for (int[] r : Ch21MergesortTest.randomArrays(4)) {
            long inv = 0;
            for (int i = 0; i < r.length; i++) for (int j = i + 1; j < r.length; j++) if (r[i] > r[j]) inv++;
            Check.eq(Ch21Mergesort.countInversions(r), inv);
        }
    }
}

class Ex21_7Test {
    record Rec(String name, int n) {}

    public static void run() {
        List<Rec> recs = List.of(new Rec("ann", 3), new Rec("bo", 1), new Rec("cy", 3), new Rec("di", 1));
        Check.eq(Ch21Mergesort.mergesortBy(recs, Rec::n).stream().map(Rec::name).toList(), List.of("bo", "di", "ann", "cy"));
    }
}

class Ex21_8Test {
    public static void run() {
        Check.eq(Ch21Mergesort.hybridSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, 4), IntStream.range(0, 10).toArray());
        for (int[] r : Ch21MergesortTest.randomArrays(5)) Check.eq(Ch21Mergesort.hybridSort(r, 5), Ch21MergesortTest.sorted(r));
    }
}
