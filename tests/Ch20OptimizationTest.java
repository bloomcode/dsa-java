/** Chapter 20 tests, one class per exercise. */
class Ex20_1Test {
    public static void run() {
        Check.yes(Ch20Optimization.hasTwoSum(new int[]{2, 0, 4, 1, 7, 9}, 10));
        Check.no(Ch20Optimization.hasTwoSum(new int[]{2, 0, 4, 1, 7, 9}, 100));
        Check.no(Ch20Optimization.hasTwoSum(new int[]{5}, 10));
    }
}

class Ex20_2Test {
    public static void run() {
        Check.eq(Ch20Optimization.sumSwap(new int[]{5, 3, 2, 9, 1}, new int[]{1, 12, 5}), new int[]{2, 0});
        Check.eq(Ch20Optimization.sumSwap(new int[]{1}, new int[]{2}), null);
    }
}

class Ex20_3Test {
    public static void run() {
        Check.eq(Ch20Optimization.maxSubarraySum(new int[]{3, -4, 4, -3, 5, -9}), 6L);
        Check.eq(Ch20Optimization.maxSubarraySum(new int[]{-3, -1, -2}), -1L);
    }
}

class Ex20_4Test {
    public static void run() {
        Check.yes(Ch20Optimization.hasIncreasingTriplet(new double[]{22, 25, 21, 18, 19.6, 17, 16, 20.5}));
        Check.no(Ch20Optimization.hasIncreasingTriplet(new double[]{5, 4, 3}));
    }
}

class Ex20_5Test {
    public static void run() {
        Check.eq(Ch20Optimization.maxProfit(new int[]{10, 7, 5, 8, 11, 2, 6}), 6);
        Check.eq(Ch20Optimization.maxProfit(new int[]{5, 4, 3}), 0);
    }
}

class Ex20_6Test {
    public static void run() {
        Check.yes(Ch20Optimization.areAnagrams("listen", "silent"));
        Check.no(Ch20Optimization.areAnagrams("listen", "silenc"));
        Check.no(Ch20Optimization.areAnagrams("aab", "abb"));
    }
}

class Ex20_7Test {
    public static void run() {
        Check.eq(Ch20Optimization.sortTemperatures(new double[]{98.6, 98.0, 97.1, 99.0, 98.9, 97.8, 98.5, 98.2, 98.0, 97.1}),
                new double[]{97.1, 97.1, 97.8, 98.0, 98.0, 98.2, 98.5, 98.6, 98.9, 99.0});
    }
}

class Ex20_8Test {
    public static void run() {
        Check.eq(Ch20Optimization.missingNumber(new int[]{5, 2, 4, 1, 0}), 3L);
    }
}

class Ex20_9Test {
    public static void run() {
        Check.eq(Ch20Optimization.longestConsecutive(new int[]{10, 5, 12, 3, 55, 30, 4, 11, 2}), 4);
        Check.eq(Ch20Optimization.longestConsecutive(new int[]{}), 0);
    }
}
