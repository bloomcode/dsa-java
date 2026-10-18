import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/** Chapter 3.2 tests, one class per exercise. */

final class Ch3_2DivideConquerTest {
    private Ch3_2DivideConquerTest() {}

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

    static int[][] randomSignedArrays(long seed) {
        Random rnd = new Random(seed);
        int[][] out = new int[200][];
        for (int t = 0; t < out.length; t++) {
            out[t] = new int[rnd.nextInt(40)];
            for (int i = 0; i < out[t].length; i++) out[t][i] = rnd.nextInt(12) - 6;
        }
        return out;
    }

}

class Ex3_2_1Test {
    public static void run() {
        int[] p = {0, 5, 2, 1, 6, 3};
        Check.eq(Ch3_2DivideConquer.partition(p, 0, 5), 3);
        Check.eq(p[3], 3);
        for (int i = 0; i < 3; i++) Check.yes(p[i] < 3);
        for (int i = 4; i < 6; i++) Check.yes(p[i] > 3);
    }
}

class Ex3_2_2Test {
    public static void run() {
        Check.eq(Ch3_2DivideConquer.quicksort(new int[]{0, 5, 2, 1, 6, 3}), new int[]{0, 1, 2, 3, 5, 6});
        Check.eq(Ch3_2DivideConquer.quicksort(new int[]{3, 3, 1, 3, 2, 2}), new int[]{1, 2, 2, 3, 3, 3});
        Check.eq(Ch3_2DivideConquer.quicksort(new int[]{}), new int[]{});
        for (int[] r : Ch3_2DivideConquerTest.randomArrays(7)) Check.eq(Ch3_2DivideConquer.quicksort(r.clone()), Ch3_2DivideConquerTest.sorted(r));
    }
}

class Ex3_2_3Test {
    public static void run() {
        int[] qs = {0, 50, 20, 10, 60, 30};
        Check.eq(Ch3_2DivideConquer.quickselect(qs, 1), 10);
        Check.eq(qs, new int[]{0, 50, 20, 10, 60, 30});
        for (int k = 0; k < 6; k++) Check.eq(Ch3_2DivideConquer.quickselect(qs, k), new int[]{0, 10, 20, 30, 50, 60}[k]);
        Random rnd = new Random(8);
        for (int[] r : Ch3_2DivideConquerTest.randomArrays(9)) {
            if (r.length == 0) continue;
            int k = rnd.nextInt(r.length);
            Check.eq(Ch3_2DivideConquer.quickselect(r, k), Ch3_2DivideConquerTest.sorted(r)[k]);
        }
    }
}

class Ex3_2_4Test {
    public static void run() {
        int[] data = {10, 4, 15, 7};
        Check.eq(Ch3_2DivideConquer.closestGapSorted(data), 3);
        Check.eq(data, new int[]{10, 4, 15, 7});
        Check.eq(Ch3_2DivideConquer.closestGapSorted(new int[]{1, 100}), 99);
        Check.eq(Ch3_2DivideConquer.closestGapSorted(new int[]{5, 5, 9}), 0);
        Check.eq(Ch3_2DivideConquer.closestGapSorted(new int[]{-3, 8, -1}), 2);
    }
}

class Ex3_2_5Test {
    public static void run() {
        Check.yes(Ch3_2DivideConquer.anyOverlap(new int[][]{{9, 11}, {13, 15}, {10, 12}}));
        Check.no(Ch3_2DivideConquer.anyOverlap(new int[][]{{9, 10}, {10, 11}}));
        Check.no(Ch3_2DivideConquer.anyOverlap(new int[][]{}));
        Check.no(Ch3_2DivideConquer.anyOverlap(new int[][]{{1, 5}}));
        Check.yes(Ch3_2DivideConquer.anyOverlap(new int[][]{{1, 10}, {2, 3}, {11, 12}}));
    }
}

class Ex3_2_6Test {
    public static void run() {
        Check.eq(Ch3_2DivideConquer.countDistinctSorted(new int[]{5, 9, 3, 5, 9, 9}), 3);
        Check.eq(Ch3_2DivideConquer.countDistinctSorted(new int[]{}), 0);
        Check.eq(Ch3_2DivideConquer.countDistinctSorted(new int[]{7, 7, 7}), 1);
        Check.eq(Ch3_2DivideConquer.countDistinctSorted(new int[]{3, -3, 0}), 3);
    }
}

class Ex3_2_7Test {
    public static void run() {
        Check.eq(Ch3_2DivideConquer.median(new int[]{7, 1, 3}), 3.0);
        Check.eq(Ch3_2DivideConquer.median(new int[]{4, 1, 3, 2}), 2.5);
    }
}

class Ex3_2_8Test {
    public static void run() {
        int[] data = {3, 1, 3, 2, 3, 1};
        Check.yes(Ch3_2DivideConquer.quicksort3(data) == data);
        Check.eq(data, new int[]{1, 1, 2, 3, 3, 3});
        int[] many = new int[500];
        for (int i = 0; i < many.length; i++) many[i] = (i * 7919) % 5;
        Check.eq(Ch3_2DivideConquer.quicksort3(many.clone()), Ch3_2DivideConquerTest.sorted(many));
        Check.eq(Ch3_2DivideConquer.quicksort3(new int[]{}), new int[]{});
        for (int[] r : Ch3_2DivideConquerTest.randomArrays(11)) Check.eq(Ch3_2DivideConquer.quicksort3(r.clone()), Ch3_2DivideConquerTest.sorted(r));
    }
}

class Ex3_2_9Test {
    public static void run() {
        Check.eq(Ch3_2DivideConquer.merge(new int[]{1, 4, 9}, new int[]{2, 3, 10, 11}), new int[]{1, 2, 3, 4, 9, 10, 11});
        Check.eq(Ch3_2DivideConquer.merge(new int[]{}, new int[]{1}), new int[]{1});
        Check.eq(Ch3_2DivideConquer.merge(new int[]{}, new int[]{}), new int[]{});
    }
}

class Ex3_2_10Test {
    public static void run() {
        Check.eq(Ch3_2DivideConquer.mergeComparisons(new int[]{1, 2, 3}, new int[]{4, 5, 6}), 3);
        Check.eq(Ch3_2DivideConquer.mergeComparisons(new int[]{1, 3, 5}, new int[]{2, 4, 6}), 5);
    }
}

class Ex3_2_11Test {
    public static void run() {
        Check.eq(Ch3_2DivideConquer.mergesort(new int[]{38, 27, 43, 3, 9, 82, 10}), new int[]{3, 9, 10, 27, 38, 43, 82});
        for (int[] r : Ch3_2DivideConquerTest.randomSignedArrays(1)) Check.eq(Ch3_2DivideConquer.mergesort(r), Ch3_2DivideConquerTest.sorted(r));
    }
}

class Ex3_2_12Test {
    public static void run() {
        int[] a = {5, 2, 4, 6, 1, 3};
        Ch3_2DivideConquer.mergesortInPlace(a);
        Check.eq(a, new int[]{1, 2, 3, 4, 5, 6});
        for (int[] r : Ch3_2DivideConquerTest.randomSignedArrays(2)) Check.eq(Ch3_2DivideConquer.mergesortInPlace(r.clone()), Ch3_2DivideConquerTest.sorted(r));
    }
}

class Ex3_2_13Test {
    public static void run() {
        Check.eq(Ch3_2DivideConquer.mergesortBottomUp(new int[]{5, 1, 4, 2, 8, 0, 2}), new int[]{0, 1, 2, 2, 4, 5, 8});
        for (int[] r : Ch3_2DivideConquerTest.randomSignedArrays(3)) Check.eq(Ch3_2DivideConquer.mergesortBottomUp(r), Ch3_2DivideConquerTest.sorted(r));
    }
}

class Ex3_2_14Test {
    public static void run() {
        Check.eq(Ch3_2DivideConquer.countInversions(new int[]{2, 4, 1, 3, 5}), 3L);
        Check.eq(Ch3_2DivideConquer.countInversions(new int[]{5, 4, 3, 2, 1}), 10L);
        for (int[] r : Ch3_2DivideConquerTest.randomSignedArrays(4)) {
            long inv = 0;
            for (int i = 0; i < r.length; i++) for (int j = i + 1; j < r.length; j++) if (r[i] > r[j]) inv++;
            Check.eq(Ch3_2DivideConquer.countInversions(r), inv);
        }
    }
}

class Ex3_2_15Test {
    record Rec(String name, int n) {}

    public static void run() {
        List<Rec> recs = List.of(new Rec("ann", 3), new Rec("bo", 1), new Rec("cy", 3), new Rec("di", 1));
        Check.eq(Ch3_2DivideConquer.mergesortBy(recs, Rec::n).stream().map(Rec::name).toList(), List.of("bo", "di", "ann", "cy"));
    }
}

class Ex3_2_16Test {
    public static void run() {
        Check.eq(Ch3_2DivideConquer.hybridSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, 4), IntStream.range(0, 10).toArray());
        for (int[] r : Ch3_2DivideConquerTest.randomSignedArrays(5)) Check.eq(Ch3_2DivideConquer.hybridSort(r, 5), Ch3_2DivideConquerTest.sorted(r));
    }
}
