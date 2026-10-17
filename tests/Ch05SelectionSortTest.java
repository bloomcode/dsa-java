/** Chapter 5 tests, one class per exercise. */
class Ex5_1Test {
    public static void run() {
        Check.eq(Ch05SelectionSort.selectionSort(new int[]{4, 2, 7, 1, 3}), new int[]{1, 2, 3, 4, 7});
        int[] data = Ch04BubbleSortTest.randomData(3);
        Check.eq(Ch05SelectionSort.selectionSort(data.clone()), Ch04BubbleSortTest.sortedCopy(data));
        Check.eq(Ch05SelectionSort.selectionSort(new int[]{}), new int[]{});
    }
}

class Ex5_2Test {
    public static void run() {
        int[] ten = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Check.eq(Ch05SelectionSort.bubbleCounts(ten), new long[]{45, 45});
        Check.eq(Ch05SelectionSort.selectionCounts(ten), new long[]{45, 5});
        Check.eq(ten[0], 10); // both sort a copy
    }
}

class Ex5_3Test {
    public static void run() {
        Check.eq(Ch05SelectionSort.everyOther(new int[]{10, 11, 12, 13, 14}), new int[]{10, 12, 14});
        Check.eq(Ch05SelectionSort.everyOther(new int[]{1, 2}), new int[]{1});
        Check.eq(Ch05SelectionSort.everyOther(new int[]{}), new int[]{});
    }
}

class Ex5_4Test {
    public static void run() {
        Check.eq(Ch05SelectionSort.secondLargest(new int[]{5, 1, 9, 7, 9}), 7);
        Check.eq(Ch05SelectionSort.secondLargest(new int[]{3, 3}), null);
        Check.eq(Ch05SelectionSort.secondLargest(new int[]{1, 2}), 1);
        Check.eq(Ch05SelectionSort.secondLargest(new int[]{9, 8, 10}), 9);
    }
}

class Ex5_5Test {
    public static void run() {
        Check.eq(Ch05SelectionSort.kSmallest(new int[]{8, 3, 5, 1, 9}, 2), new int[]{1, 3});
    }
}
