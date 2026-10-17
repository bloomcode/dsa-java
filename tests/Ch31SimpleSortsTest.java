import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/** Chapter 31 tests, one class per exercise. */

final class Ch31SimpleSortsTest {
    private Ch31SimpleSortsTest() {}

    static int[] randomData(long seed) {
        Random rng = new Random(seed);
        int[] a = new int[60];
        for (int i = 0; i < a.length; i++) a[i] = rng.nextInt(101) - 50;
        return a;
    }

    static int[] sortedCopy(int[] a) {
        int[] s = a.clone();
        Arrays.sort(s);
        return s;
    }
}

class Ex31_1Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.bubbleSort(new int[]{4, 2, 7, 1, 3}), new int[]{1, 2, 3, 4, 7});
        int[] data = Ch31SimpleSortsTest.randomData(1);
        Check.eq(Ch31SimpleSorts.bubbleSort(data.clone()), Ch31SimpleSortsTest.sortedCopy(data));
        Check.eq(Ch31SimpleSorts.bubbleSort(new int[]{}), new int[]{});
    }
}

class Ex31_2Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.bubbleSortOptimized(new int[]{1, 2, 3, 4}), 1);
        int[] rev = {4, 3, 2, 1};
        Check.eq(Ch31SimpleSorts.bubbleSortOptimized(rev), 3);
        Check.eq(rev, new int[]{1, 2, 3, 4});
        int[] data = Ch31SimpleSortsTest.randomData(2), copy = data.clone();
        Ch31SimpleSorts.bubbleSortOptimized(copy);
        Check.eq(copy, Ch31SimpleSortsTest.sortedCopy(data));
    }
}

class Ex31_3Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.equalPairsQuadratic(new int[]{1, 2, 1, 1, 2}), 4);
        Check.eq(Ch31SimpleSorts.equalPairsQuadratic(new int[]{1, 2, 3}), 0);
        Check.eq(Ch31SimpleSorts.equalPairsQuadratic(new int[]{}), 0);
        Check.eq(Ch31SimpleSorts.equalPairsQuadratic(new int[]{5, 5, 5, 5, 5}), 10);
    }
}

class Ex31_4Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.equalPairsLinear(new int[]{1, 2, 1, 1, 2}), 4L);
        Check.eq(Ch31SimpleSorts.equalPairsLinear(new int[]{1, 2, 3}), 0L);
        Check.eq(Ch31SimpleSorts.equalPairsLinear(new int[]{}), 0L);
        int[] same = new int[2000];
        Arrays.fill(same, 7);
        Check.eq(Ch31SimpleSorts.equalPairsLinear(same), 1999000L);
    }
}

class Ex31_5Test {
    public static void run() {
        for (java.util.function.ToIntFunction<int[]> fn : List.<java.util.function.ToIntFunction<int[]>>of(
                Ch31SimpleSorts::largestPairSumQuadratic, Ch31SimpleSorts::largestPairSumLinear)) {
            Check.eq(fn.applyAsInt(new int[]{3, 9, 1, 7}), 16);
            Check.eq(fn.applyAsInt(new int[]{5, 5}), 10);
            Check.eq(fn.applyAsInt(new int[]{-4, -1, -9}), -5);
            Check.eq(fn.applyAsInt(new int[]{9, 1, 9}), 18);
        }
    }
}

class Ex31_6Test {
    public static void run() {
        Check.yes(Ch31SimpleSorts.isSorted(new int[]{1, 2, 2, 5}));
        Check.no(Ch31SimpleSorts.isSorted(new int[]{1, 3, 2}));
        Check.yes(Ch31SimpleSorts.isSorted(new int[]{}));
    }
}

class Ex31_7Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.selectionSort(new int[]{4, 2, 7, 1, 3}), new int[]{1, 2, 3, 4, 7});
        int[] data = Ch31SimpleSortsTest.randomData(3);
        Check.eq(Ch31SimpleSorts.selectionSort(data.clone()), Ch31SimpleSortsTest.sortedCopy(data));
        Check.eq(Ch31SimpleSorts.selectionSort(new int[]{}), new int[]{});
    }
}

class Ex31_8Test {
    public static void run() {
        int[] ten = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Check.eq(Ch31SimpleSorts.bubbleCounts(ten), new long[]{45, 45});
        Check.eq(Ch31SimpleSorts.selectionCounts(ten), new long[]{45, 5});
        Check.eq(ten[0], 10); // both sort a copy
    }
}

class Ex31_9Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.neighbourGaps(new int[]{3, 7, 4, 10}), new int[]{4, -3, 6});
        Check.eq(Ch31SimpleSorts.neighbourGaps(new int[]{5}), new int[]{});
        Check.eq(Ch31SimpleSorts.neighbourGaps(new int[]{}), new int[]{});
        Check.eq(Ch31SimpleSorts.neighbourGaps(new int[]{1, 1}), new int[]{0});
    }
}

class Ex31_10Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.secondLargest(new int[]{5, 1, 9, 7, 9}), 7);
        Check.eq(Ch31SimpleSorts.secondLargest(new int[]{3, 3}), null);
        Check.eq(Ch31SimpleSorts.secondLargest(new int[]{1, 2}), 1);
        Check.eq(Ch31SimpleSorts.secondLargest(new int[]{9, 8, 10}), 9);
    }
}

class Ex31_11Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.kSmallest(new int[]{8, 3, 5, 1, 9}, 2), new int[]{1, 3});
    }
}

class Ex31_12Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.insertionSort(new int[]{4, 2, 7, 1, 3}), new int[]{1, 2, 3, 4, 7});
        int[] data = Ch31SimpleSortsTest.randomData(4);
        Check.eq(Ch31SimpleSorts.insertionSort(data.clone()), Ch31SimpleSortsTest.sortedCopy(data));
        Check.eq(Ch31SimpleSorts.insertionSort(new int[]{}), new int[]{});
    }
}

class Ex31_13Test {
    public static void run() {
        int[] up = new int[100], down = new int[100];
        for (int i = 0; i < 100; i++) {
            up[i] = i;
            down[i] = 100 - i;
        }
        Check.eq(Ch31SimpleSorts.insertionSortSteps(up), 99L);
        Check.eq(Ch31SimpleSorts.insertionSortSteps(down), 9900L);
        int[] shuffled = up.clone();
        Random rng = new Random(2);
        for (int i = shuffled.length - 1; i > 0; i--) {
            int j = rng.nextInt(i + 1), t = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = t;
        }
        long mid = Ch31SimpleSorts.insertionSortSteps(shuffled);
        Check.yes(99 < mid && mid < 9900);
    }
}

class Ex31_14Test {
    public static void run() {
        Check.yes(Ch31SimpleSorts.containsAll(new int[]{4, 8, 15, 16}, new int[]{8, 16}));
        Check.no(Ch31SimpleSorts.containsAll(new int[]{4, 8}, new int[]{8, 5}));
        Check.yes(Ch31SimpleSorts.containsAll(new int[]{1}, new int[]{}));
        Check.no(Ch31SimpleSorts.containsAll(new int[]{}, new int[]{1}));
        Check.yes(Ch31SimpleSorts.containsAll(new int[]{3, 3}, new int[]{3, 3}));
    }
}

class Ex31_15Test {
    public static void run() {
        Check.eq(Ch31SimpleSorts.insertSorted(new ArrayList<>(List.of(1, 4, 9)), 5), List.of(1, 4, 5, 9));
        Check.eq(Ch31SimpleSorts.insertSorted(new ArrayList<>(List.of(1, 4, 9)), 0), List.of(0, 1, 4, 9));
        Check.eq(Ch31SimpleSorts.insertSorted(new ArrayList<>(), 5), List.of(5));
    }
}

class Ex31_16Test {
    public static void run() {
        int[] data = {2, 1, 3, 5, 4};
        Check.yes(Ch31SimpleSorts.sortNearlySorted(data, 1) == data);
        Check.eq(data, new int[]{1, 2, 3, 4, 5});
        Check.eq(Ch31SimpleSorts.sortNearlySorted(new int[]{3, 1, 2, 6, 4, 5}, 2), new int[]{1, 2, 3, 4, 5, 6});
        Check.eq(Ch31SimpleSorts.sortNearlySorted(new int[]{}, 3), new int[]{});
    }
}
