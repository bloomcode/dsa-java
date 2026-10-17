import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Chapter 6 tests, one class per exercise. */
class Ex6_1Test {
    public static void run() {
        Check.eq(Ch06InsertionSort.insertionSort(new int[]{4, 2, 7, 1, 3}), new int[]{1, 2, 3, 4, 7});
        int[] data = Ch04BubbleSortTest.randomData(4);
        Check.eq(Ch06InsertionSort.insertionSort(data.clone()), Ch04BubbleSortTest.sortedCopy(data));
        Check.eq(Ch06InsertionSort.insertionSort(new int[]{}), new int[]{});
    }
}

class Ex6_2Test {
    public static void run() {
        int[] up = new int[100], down = new int[100];
        for (int i = 0; i < 100; i++) {
            up[i] = i;
            down[i] = 100 - i;
        }
        Check.eq(Ch06InsertionSort.insertionSortSteps(up), 99L);
        Check.eq(Ch06InsertionSort.insertionSortSteps(down), 9900L);
        int[] shuffled = up.clone();
        Random rng = new Random(2);
        for (int i = shuffled.length - 1; i > 0; i--) {
            int j = rng.nextInt(i + 1), t = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = t;
        }
        long mid = Ch06InsertionSort.insertionSortSteps(shuffled);
        Check.yes(99 < mid && mid < 9900);
    }
}

class Ex6_3Test {
    public static void run() {
        Check.eq(Ch06InsertionSort.intersectionNested(new int[]{3, 1, 4, 2}, new int[]{4, 5, 3, 6}), List.of(3, 4));
        Check.eq(Ch06InsertionSort.intersectionNested(new int[]{1, 2}, new int[]{3}), List.of());
    }
}

class Ex6_4Test {
    public static void run() {
        Check.eq(Ch06InsertionSort.insertSorted(new ArrayList<>(List.of(1, 4, 9)), 5), List.of(1, 4, 5, 9));
        Check.eq(Ch06InsertionSort.insertSorted(new ArrayList<>(List.of(1, 4, 9)), 0), List.of(0, 1, 4, 9));
        Check.eq(Ch06InsertionSort.insertSorted(new ArrayList<>(), 5), List.of(5));
    }
}

class Ex6_5Test {
    public static void run() {
        Check.eq(Ch06InsertionSort.mergeSorted(new int[]{1, 4, 7}, new int[]{2, 3, 9}), new int[]{1, 2, 3, 4, 7, 9});
        Check.eq(Ch06InsertionSort.mergeSorted(new int[]{}, new int[]{1}), new int[]{1});
    }
}
