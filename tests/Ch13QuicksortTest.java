import java.util.Arrays;
import java.util.Random;

/** Chapter 13 tests, one class per exercise. */
final class Ch13QuicksortTest {
    private Ch13QuicksortTest() {}

    static int[][] randomArrays(long seed) {
        Random rnd = new Random(seed);
        int[][] out = new int[200][];
        for (int t = 0; t < out.length; t++) {
            out[t] = new int[rnd.nextInt(30)];
            for (int i = 0; i < out[t].length; i++) out[t][i] = rnd.nextInt(10);
        }
        return out;
    }

    static int[] sorted(int[] a) {
        int[] s = a.clone();
        Arrays.sort(s);
        return s;
    }
}

class Ex13_1Test {
    public static void run() {
        int[] p = {0, 5, 2, 1, 6, 3};
        Check.eq(Ch13Quicksort.partition(p, 0, 5), 3);
        Check.eq(p[3], 3);
        for (int i = 0; i < 3; i++) Check.yes(p[i] < 3);
        for (int i = 4; i < 6; i++) Check.yes(p[i] > 3);
    }
}

class Ex13_2Test {
    public static void run() {
        Check.eq(Ch13Quicksort.quicksort(new int[]{0, 5, 2, 1, 6, 3}), new int[]{0, 1, 2, 3, 5, 6});
        Check.eq(Ch13Quicksort.quicksort(new int[]{3, 3, 1, 3, 2, 2}), new int[]{1, 2, 2, 3, 3, 3});
        Check.eq(Ch13Quicksort.quicksort(new int[]{}), new int[]{});
        for (int[] r : Ch13QuicksortTest.randomArrays(7)) Check.eq(Ch13Quicksort.quicksort(r.clone()), Ch13QuicksortTest.sorted(r));
    }
}

class Ex13_3Test {
    public static void run() {
        int[] qs = {0, 50, 20, 10, 60, 30};
        Check.eq(Ch13Quicksort.quickselect(qs, 1), 10);
        Check.eq(qs, new int[]{0, 50, 20, 10, 60, 30});
        for (int k = 0; k < 6; k++) Check.eq(Ch13Quicksort.quickselect(qs, k), new int[]{0, 10, 20, 30, 50, 60}[k]);
        Random rnd = new Random(8);
        for (int[] r : Ch13QuicksortTest.randomArrays(9)) {
            if (r.length == 0) continue;
            int k = rnd.nextInt(r.length);
            Check.eq(Ch13Quicksort.quickselect(r, k), Ch13QuicksortTest.sorted(r)[k]);
        }
    }
}

class Ex13_4Test {
    public static void run() {
        Check.yes(Ch13Quicksort.hasDuplicatesSorted(new int[]{5, 9, 3, 2, 4, 5, 6}));
        Check.no(Ch13Quicksort.hasDuplicatesSorted(new int[]{5, 9, 3}));
    }
}

class Ex13_5Test {
    public static void run() {
        Check.eq(Ch13Quicksort.maxProductOfThree(new int[]{1, 10, 2, 6, 5, 3}), 300L);
        Check.eq(Ch13Quicksort.maxProductOfThree(new int[]{-10, -10, 1, 3, 2}), 300L);
    }
}

class Ex13_6Test {
    public static void run() {
        Check.eq(Ch13Quicksort.missingNumberSorted(new int[]{5, 2, 4, 1, 0}), 3);
        Check.eq(Ch13Quicksort.missingNumberSorted(new int[]{0, 1, 2}), 3);
    }
}

class Ex13_7Test {
    public static void run() {
        Check.eq(Ch13Quicksort.median(new int[]{7, 1, 3}), 3.0);
        Check.eq(Ch13Quicksort.median(new int[]{4, 1, 3, 2}), 2.5);
    }
}

class Ex13_8Test {
    public static void run() {
        Check.eq(Ch13Quicksort.mergeSort(new int[]{38, 27, 43, 3, 9, 82, 10}), new int[]{3, 9, 10, 27, 38, 43, 82});
        for (int[] r : Ch13QuicksortTest.randomArrays(10)) Check.eq(Ch13Quicksort.mergeSort(r), Ch13QuicksortTest.sorted(r));
    }
}
