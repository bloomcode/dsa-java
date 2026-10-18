/** Chapter 3.3 tests, one class per exercise. */

class Ex3_3_1Test {
    public static void run() {
        Check.eq(Ch3_3LinearSorts.countingSort(new int[] {3, 0, 2, 3, 1}, 3), new int[] {0, 1, 2, 3, 3});
        Check.eq(Ch3_3LinearSorts.countingSort(new int[0], 5), new int[0]);
        Check.eq(Ch3_3LinearSorts.countingSort(new int[] {4, 4, 4}, 4), new int[] {4, 4, 4});
        Check.eq(Ch3_3LinearSorts.countingSort(new int[] {9, 0, 5, 0}, 9), new int[] {0, 0, 5, 9});
    }
}

class Ex3_3_2Test {
    public static void run() {
        Check.eq(Ch3_3LinearSorts.sortByOrder(new int[] {2, 0, 1, 2, 0}, new int[] {2, 0, 1}), new int[] {2, 2, 0, 0, 1});
        Check.eq(Ch3_3LinearSorts.sortByOrder(new int[0], new int[] {1, 2}), new int[0]);
        Check.eq(Ch3_3LinearSorts.sortByOrder(new int[] {5, 5, 7}, new int[] {7, 5, 9}), new int[] {7, 5, 5});
        Check.eq(Ch3_3LinearSorts.sortByOrder(new int[] {3, 1, 3}, new int[] {1, 3}), new int[] {1, 3, 3});
    }
}

class Ex3_3_3Test {
    public static void run() {
        Check.eq(Ch3_3LinearSorts.radixSort(new int[] {329, 57, 640, 4, 1000, 72}), new int[] {4, 57, 72, 329, 640, 1000});
        Check.eq(Ch3_3LinearSorts.radixSort(new int[0]), new int[0]);
        Check.eq(Ch3_3LinearSorts.radixSort(new int[] {0, 0, 1}), new int[] {0, 0, 1});
        Check.eq(Ch3_3LinearSorts.radixSort(new int[] {21, 12, 11, 22}), new int[] {11, 12, 21, 22});
    }
}

class Ex3_3_4Test {
    public static void run() {
        Check.eq(Ch3_3LinearSorts.bucketSort(new double[] {0.42, 0.07, 0.93, 0.5, 0.31}), new double[] {0.07, 0.31, 0.42, 0.5, 0.93});
        Check.eq(Ch3_3LinearSorts.bucketSort(new double[0]), new double[0]);
        Check.eq(Ch3_3LinearSorts.bucketSort(new double[] {0.25, 0.2, 0.21, 0.0}), new double[] {0.0, 0.2, 0.21, 0.25});
        Check.eq(Ch3_3LinearSorts.bucketSort(new double[] {0.99}), new double[] {0.99});
    }
}
