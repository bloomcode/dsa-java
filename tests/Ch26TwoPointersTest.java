import java.util.List;

/** Chapter 26 tests, one class per exercise. */

class Ex26_1Test {
    public static void run() {
        int[] nums = {1, 3, 4, 6, 9};
        Check.eq(Ch26TwoPointers.pairSumSorted(nums, 10), new int[] {0, 4});
        Check.eq(Ch26TwoPointers.pairSumSorted(nums, 13), new int[] {2, 4});
        Check.eq(Ch26TwoPointers.pairSumSorted(nums, 2), new int[0]);
        Check.eq(Ch26TwoPointers.pairSumSorted(new int[0], 0), new int[0]);
    }
}

class Ex26_2Test {
    public static void run() {
        Check.eq(Ch26TwoPointers.sortedSquares(new int[] {-4, -1, 0, 3}), new int[] {0, 1, 9, 16});
        Check.eq(Ch26TwoPointers.sortedSquares(new int[] {-3, -2}), new int[] {4, 9});
        Check.eq(Ch26TwoPointers.sortedSquares(new int[] {2, 5}), new int[] {4, 25});
        Check.eq(Ch26TwoPointers.sortedSquares(new int[0]), new int[0]);
    }
}

class Ex26_3Test {
    public static void run() {
        Check.eq(Ch26TwoPointers.smallestGap(new int[] {5, 19, 31}, new int[] {12, 29, 1}), 2);
        Check.eq(Ch26TwoPointers.smallestGap(new int[] {4}, new int[] {4}), 0);
        Check.eq(Ch26TwoPointers.smallestGap(new int[] {-10, 50}, new int[] {7}), 17);
    }
}

class Ex26_4Test {
    public static void run() {
        int[] nums = {2, 1, 2, 3, 2, 4};
        Check.yes(Ch26TwoPointers.moveToEnd(nums, 2) == nums);
        Check.eq(nums, new int[] {1, 3, 4, 2, 2, 2});
        Check.eq(Ch26TwoPointers.moveToEnd(new int[] {7, 7}, 7), new int[] {7, 7});
        Check.eq(Ch26TwoPointers.moveToEnd(new int[] {1, 2}, 9), new int[] {1, 2});
    }
}

class Ex26_5Test {
    public static void run() {
        Check.yes(Ch26TwoPointers.isMonotonic(new int[] {1, 2, 2, 5}));
        Check.no(Ch26TwoPointers.isMonotonic(new int[] {3, 1, 2}));
        Check.yes(Ch26TwoPointers.isMonotonic(new int[0]));
        Check.yes(Ch26TwoPointers.isMonotonic(new int[] {5, 5, 4, 0}));
        Check.no(Ch26TwoPointers.isMonotonic(new int[] {1, 2, 1}));
    }
}

class Ex26_6Test {
    public static void run() {
        int[][] given = {{6, 8}, {1, 3}, {2, 4}, {8, 9}};
        Check.eq(Ch26TwoPointers.mergeIntervals(given), new int[][] {{1, 4}, {6, 9}});
        Check.eq(given, new int[][] {{6, 8}, {1, 3}, {2, 4}, {8, 9}});
        Check.eq(Ch26TwoPointers.mergeIntervals(new int[0][]), new int[0][]);
        Check.eq(Ch26TwoPointers.mergeIntervals(new int[][] {{1, 10}, {2, 3}}), new int[][] {{1, 10}});
        Check.eq(Ch26TwoPointers.mergeIntervals(new int[][] {{4, 5}, {1, 2}}), new int[][] {{1, 2}, {4, 5}});
    }
}

class Ex26_7Test {
    public static void run() {
        Check.eq(Ch26TwoPointers.triplesToTarget(new int[] {4, -1, 2, 0, -3, 1}, 1), List.of(List.of(-3, 0, 4), List.of(-1, 0, 2)));
        Check.eq(Ch26TwoPointers.triplesToTarget(new int[] {0, 0, 0, 0}, 0), List.of(List.of(0, 0, 0)));
        Check.eq(Ch26TwoPointers.triplesToTarget(new int[] {1, 2}, 3), List.of());
        Check.eq(Ch26TwoPointers.triplesToTarget(new int[] {2, 2, 1, 1, 0}, 4), List.of(List.of(0, 2, 2), List.of(1, 1, 2)));
    }
}

class Ex26_8Test {
    public static void run() {
        Check.eq(Ch26TwoPointers.mostWater(new int[] {2, 7, 3, 6, 1, 5}), 20);
        Check.eq(Ch26TwoPointers.mostWater(new int[] {1, 1}), 1);
        Check.eq(Ch26TwoPointers.mostWater(new int[] {4}), 0);
        Check.eq(Ch26TwoPointers.mostWater(new int[] {3, 1, 1, 3}), 9);
    }
}

class Ex26_9Test {
    public static void run() {
        Check.eq(Ch26TwoPointers.intervalOverlaps(new int[][] {{1, 4}, {6, 9}}, new int[][] {{3, 7}, {9, 12}}), new int[][] {{3, 4}, {6, 7}, {9, 9}});
        Check.eq(Ch26TwoPointers.intervalOverlaps(new int[][] {{1, 2}}, new int[][] {{3, 4}}), new int[0][]);
        Check.eq(Ch26TwoPointers.intervalOverlaps(new int[0][], new int[][] {{1, 5}}), new int[0][]);
        Check.eq(Ch26TwoPointers.intervalOverlaps(new int[][] {{0, 10}}, new int[][] {{1, 2}, {4, 5}}), new int[][] {{1, 2}, {4, 5}});
    }
}

class Ex26_10Test {
    public static void run() {
        Check.eq(Ch26TwoPointers.unsortedStretch(new int[] {1, 3, 7, 5, 6, 9}), new int[] {2, 4});
        Check.eq(Ch26TwoPointers.unsortedStretch(new int[] {1, 2, 3}), new int[] {-1, -1});
        Check.eq(Ch26TwoPointers.unsortedStretch(new int[] {3, 2, 1}), new int[] {0, 2});
        Check.eq(Ch26TwoPointers.unsortedStretch(new int[] {1, 2, 4, 3, 3, 5}), new int[] {2, 4});
        Check.eq(Ch26TwoPointers.unsortedStretch(new int[] {2, 2}), new int[] {-1, -1});
    }
}

class Ex26_11Test {
    public static void run() {
        int[] nums = {3, -1, 4, -5, 9, -2};
        Check.yes(Ch26TwoPointers.negativesFirst(nums) == nums);
        Check.eq(nums, new int[] {-1, -5, -2, 3, 4, 9});
        Check.eq(Ch26TwoPointers.negativesFirst(new int[0]), new int[0]);
        Check.eq(Ch26TwoPointers.negativesFirst(new int[] {1, 2}), new int[] {1, 2});
        Check.eq(Ch26TwoPointers.negativesFirst(new int[] {0, -3, 0, -4, 7}), new int[] {-3, -4, 0, 0, 7});
    }
}

class Ex26_12Test {
    public static void run() {
        int[] nums = {1, 3, 2};
        Check.yes(Ch26TwoPointers.nextArrangement(nums) == nums);
        Check.eq(nums, new int[] {2, 1, 3});
        Check.eq(Ch26TwoPointers.nextArrangement(new int[] {3, 2, 1}), new int[] {1, 2, 3});
        Check.eq(Ch26TwoPointers.nextArrangement(new int[] {1, 1, 5}), new int[] {1, 5, 1});
        Check.eq(Ch26TwoPointers.nextArrangement(new int[] {2, 4, 3, 1}), new int[] {3, 1, 2, 4});
        Check.eq(Ch26TwoPointers.nextArrangement(new int[0]), new int[0]);
    }
}

class Ex26_13Test {
    public static void run() {
        Check.eq(Ch26TwoPointers.quadsToTarget(new int[] {2, -1, 0, 3, -2, 1}, 2),
                List.of(List.of(-2, -1, 2, 3), List.of(-2, 0, 1, 3), List.of(-1, 0, 1, 2)));
        Check.eq(Ch26TwoPointers.quadsToTarget(new int[] {1, 1, 1, 1, 1}, 4), List.of(List.of(1, 1, 1, 1)));
        Check.eq(Ch26TwoPointers.quadsToTarget(new int[] {1, 2, 3}, 6), List.of());
    }
}

class Ex26_14Test {
    public static void run() {
        Check.eq(Ch26TwoPointers.trappedWater(new int[] {3, 0, 2, 0, 4}), 7);
        Check.eq(Ch26TwoPointers.trappedWater(new int[0]), 0);
        Check.eq(Ch26TwoPointers.trappedWater(new int[] {1, 2, 3}), 0);
        Check.eq(Ch26TwoPointers.trappedWater(new int[] {5, 1, 1, 5}), 8);
        Check.eq(Ch26TwoPointers.trappedWater(new int[] {4, 1, 3, 1, 2}), 3);
    }
}
