import java.util.Arrays;
import java.util.Random;

/** Chapter 4 tests, one class per exercise. */
final class Ch04BubbleSortTest {
    private Ch04BubbleSortTest() {}

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

class Ex4_1Test {
    public static void run() {
        Check.eq(Ch04BubbleSort.bubbleSort(new int[]{4, 2, 7, 1, 3}), new int[]{1, 2, 3, 4, 7});
        int[] data = Ch04BubbleSortTest.randomData(1);
        Check.eq(Ch04BubbleSort.bubbleSort(data.clone()), Ch04BubbleSortTest.sortedCopy(data));
        Check.eq(Ch04BubbleSort.bubbleSort(new int[]{}), new int[]{});
    }
}

class Ex4_2Test {
    public static void run() {
        Check.eq(Ch04BubbleSort.bubbleSortOptimized(new int[]{1, 2, 3, 4}), 1);
        int[] rev = {4, 3, 2, 1};
        Check.eq(Ch04BubbleSort.bubbleSortOptimized(rev), 3);
        Check.eq(rev, new int[]{1, 2, 3, 4});
        int[] data = Ch04BubbleSortTest.randomData(2), copy = data.clone();
        Ch04BubbleSort.bubbleSortOptimized(copy);
        Check.eq(copy, Ch04BubbleSortTest.sortedCopy(data));
    }
}

class Ex4_3Test {
    public static void run() {
        Check.yes(Ch04BubbleSort.hasDuplicateQuadratic(new int[]{1, 5, 3, 9, 1, 4}));
        Check.no(Ch04BubbleSort.hasDuplicateQuadratic(new int[]{1, 2, 3}));
    }
}

class Ex4_4Test {
    public static void run() {
        Check.yes(Ch04BubbleSort.hasDuplicateLinear(new int[]{1, 5, 3, 9, 1, 4}));
        Check.no(Ch04BubbleSort.hasDuplicateLinear(new int[]{1, 2, 3}));
    }
}

class Ex4_5Test {
    public static void run() {
        Check.eq(Ch04BubbleSort.greatestQuadratic(new int[]{3, 9, 2, 7}), 9);
        Check.eq(Ch04BubbleSort.greatestLinear(new int[]{3, 9, 2, 7}), 9);
        Check.eq(Ch04BubbleSort.greatestQuadratic(new int[]{-4}), -4);
        Check.eq(Ch04BubbleSort.greatestLinear(new int[]{}), null);
    }
}

class Ex4_6Test {
    public static void run() {
        Check.yes(Ch04BubbleSort.isSorted(new int[]{1, 2, 2, 5}));
        Check.no(Ch04BubbleSort.isSorted(new int[]{1, 3, 2}));
        Check.yes(Ch04BubbleSort.isSorted(new int[]{}));
    }
}
