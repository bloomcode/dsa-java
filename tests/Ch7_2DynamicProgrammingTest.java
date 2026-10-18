import java.util.HashMap;

/** Chapter 7.2 tests, one class per exercise. */

class Ex7_2_1Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.fibNaive(10), 55L);
        Check.eq(Ch7_2DynamicProgramming.fibMemo(10, new HashMap<>()), 55L);
        Check.eq(Ch7_2DynamicProgramming.fibBottomUp(10), 55L);
        Check.eq(Ch7_2DynamicProgramming.fibMemo(80, new HashMap<>()), 23416728348467685L);
        Check.eq(Ch7_2DynamicProgramming.fibBottomUp(80), 23416728348467685L);
        Check.eq(Ch7_2DynamicProgramming.fibBottomUp(92), 7540113804746346429L);
        Check.eq(Ch7_2DynamicProgramming.fibBottomUp(0), 0L);
        Check.eq(Ch7_2DynamicProgramming.fibBottomUp(1), 1L);
    }
}

class Ex7_2_2Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.minMax(new int[]{4, -2, 9, 0}, 0), new int[]{-2, 9});
        Check.eq(Ch7_2DynamicProgramming.minMax(new int[]{7}, 0), new int[]{7, 7});
        int[] big = new int[60];
        for (int i = 0; i < big.length; i++) big[i] = i;
        Check.eq(Ch7_2DynamicProgramming.minMax(big, 0), new int[]{0, 59});
    }
}

class Ex7_2_3Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.tilingsMemo(10, new HashMap<>()), 28L);
        Check.eq(Ch7_2DynamicProgramming.tilingsMemo(60, new HashMap<>()), 5582216355L);
        Check.eq(Ch7_2DynamicProgramming.tilingsMemo(90, new HashMap<>()), 533352837917926L);
    }
}

class Ex7_2_4Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.diceWaysMemo(2, 7, new HashMap<>()), 6L);
        Check.eq(Ch7_2DynamicProgramming.diceWaysMemo(3, 10, new HashMap<>()), 27L);
        Check.eq(Ch7_2DynamicProgramming.diceWaysMemo(20, 70, new HashMap<>()), 189456975899496L);
        Check.eq(Ch7_2DynamicProgramming.diceWaysMemo(10, 35, new HashMap<>()), 4395456L);
    }
}

class Ex7_2_5Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.countFibCalls(10), new long[]{177, 19});
    }
}

class Ex7_2_6Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.minCoins(new int[]{1, 5, 10, 25}, 63), 6);
        Check.eq(Ch7_2DynamicProgramming.minCoins(new int[]{2}, 3), -1);
        Check.eq(Ch7_2DynamicProgramming.minCoins(new int[]{1, 3, 4}, 6), 2);
        Check.eq(Ch7_2DynamicProgramming.minCoins(new int[]{1}, 0), 0);
    }
}

class Ex7_2_7Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.bestWithoutNeighbours(new int[] {5, 1, 2, 9, 3}), 14);
        Check.eq(Ch7_2DynamicProgramming.bestWithoutNeighbours(new int[0]), 0);
        Check.eq(Ch7_2DynamicProgramming.bestWithoutNeighbours(new int[] {4}), 4);
        Check.eq(Ch7_2DynamicProgramming.bestWithoutNeighbours(new int[] {2, 7, 9, 3, 1}), 12);
        Check.eq(Ch7_2DynamicProgramming.bestWithoutNeighbours(new int[] {3, 1, 1, 3}), 6);
    }
}

class Ex7_2_8Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.changeWays(new int[] {2, 3, 5}, 10), 4L);
        Check.eq(Ch7_2DynamicProgramming.changeWays(new int[] {2, 3, 5}, 0), 1L);
        Check.eq(Ch7_2DynamicProgramming.changeWays(new int[] {3}, 7), 0L);
        Check.eq(Ch7_2DynamicProgramming.changeWays(new int[] {1}, 4), 1L);
        Check.eq(Ch7_2DynamicProgramming.changeWays(new int[] {1, 2}, 4), 3L);
    }
}

class Ex7_2_9Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.decodeWays("1213"), 5);
        Check.eq(Ch7_2DynamicProgramming.decodeWays(""), 1);
        Check.eq(Ch7_2DynamicProgramming.decodeWays("06"), 0);
        Check.eq(Ch7_2DynamicProgramming.decodeWays("10"), 1);
        Check.eq(Ch7_2DynamicProgramming.decodeWays("27"), 1);
        Check.eq(Ch7_2DynamicProgramming.decodeWays("101"), 1);
        Check.eq(Ch7_2DynamicProgramming.decodeWays("0"), 0);
        Check.eq(Ch7_2DynamicProgramming.decodeWays("2626"), 4);
    }
}

class Ex7_2_10Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.bestStreak(new int[] {3, -4, 5, -1, 2, -6, 4}), 6);
        Check.eq(Ch7_2DynamicProgramming.bestStreak(new int[] {-3, -1, -2}), -1);
        Check.eq(Ch7_2DynamicProgramming.bestStreak(new int[] {1}), 1);
        Check.eq(Ch7_2DynamicProgramming.bestStreak(new int[] {2, 3, -1, 4}), 8);
    }
}

class Ex7_2_11Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.gridPaths(new String[] {"...", ".#.", "..."}), 2L);
        Check.eq(Ch7_2DynamicProgramming.gridPaths(new String[] {"#"}), 0L);
        Check.eq(Ch7_2DynamicProgramming.gridPaths(new String[] {"."}), 1L);
        Check.eq(Ch7_2DynamicProgramming.gridPaths(new String[] {"..", ".."}), 2L);
        Check.eq(Ch7_2DynamicProgramming.gridPaths(new String[] {"...", "...", "..."}), 6L);
        Check.eq(Ch7_2DynamicProgramming.gridPaths(new String[] {".#", "#."}), 0L);
        Check.eq(Ch7_2DynamicProgramming.gridPaths(new String[] {"..#", "..."}), 2L);
    }
}

class Ex7_2_12Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.editDistance("garden", "pardon"), 2);
        Check.eq(Ch7_2DynamicProgramming.editDistance("", "abc"), 3);
        Check.eq(Ch7_2DynamicProgramming.editDistance("abc", "abc"), 0);
        Check.eq(Ch7_2DynamicProgramming.editDistance("abc", "yabd"), 2);
        Check.eq(Ch7_2DynamicProgramming.editDistance("flour", "floor"), 1);
        Check.eq(Ch7_2DynamicProgramming.editDistance("abc", ""), 3);
    }
}

class Ex7_2_13Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.commonSubsequenceLength("stone", "longest"), 3);
        Check.eq(Ch7_2DynamicProgramming.commonSubsequenceLength("abc", "def"), 0);
        Check.eq(Ch7_2DynamicProgramming.commonSubsequenceLength("", "a"), 0);
        Check.eq(Ch7_2DynamicProgramming.commonSubsequenceLength("abcde", "ace"), 3);
        Check.eq(Ch7_2DynamicProgramming.commonSubsequenceLength("aaaa", "aa"), 2);
    }
}

class Ex7_2_14Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.longestIncreasingLength(new int[] {4, 1, 3, 2, 8, 5, 6}), 4);
        Check.eq(Ch7_2DynamicProgramming.longestIncreasingLength(new int[0]), 0);
        Check.eq(Ch7_2DynamicProgramming.longestIncreasingLength(new int[] {5, 5, 5}), 1);
        Check.eq(Ch7_2DynamicProgramming.longestIncreasingLength(new int[] {1, 2, 3}), 3);
        Check.eq(Ch7_2DynamicProgramming.longestIncreasingLength(new int[] {3, 2, 1}), 1);
        Check.eq(Ch7_2DynamicProgramming.longestIncreasingLength(new int[] {2, 9, 3, 10, 4, 5}), 4);
    }
}

class Ex7_2_15Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.knapsack(new int[] {3, 4, 2, 6}, new int[] {30, 50, 15, 60}, 8), 80);
        Check.eq(Ch7_2DynamicProgramming.knapsack(new int[] {3, 4, 2, 6}, new int[] {30, 50, 15, 60}, 0), 0);
        Check.eq(Ch7_2DynamicProgramming.knapsack(new int[] {3, 4, 2, 6}, new int[] {30, 50, 15, 60}, 10), 110);
        Check.eq(Ch7_2DynamicProgramming.knapsack(new int[] {3, 4, 2, 6}, new int[] {30, 50, 15, 60}, 2), 15);
        Check.eq(Ch7_2DynamicProgramming.knapsack(new int[] {3, 4, 2, 6}, new int[] {30, 50, 15, 60}, 1), 0);
        Check.eq(Ch7_2DynamicProgramming.knapsack(new int[0], new int[0], 5), 0);
    }
}

class Ex7_2_16Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.fewestJumps(new int[] {3, 1, 2, 1, 1, 4}), 3);
        Check.eq(Ch7_2DynamicProgramming.fewestJumps(new int[] {0}), 0);
        Check.eq(Ch7_2DynamicProgramming.fewestJumps(new int[] {1, 0, 2}), -1);
        Check.eq(Ch7_2DynamicProgramming.fewestJumps(new int[] {5, 1, 1}), 1);
        Check.eq(Ch7_2DynamicProgramming.fewestJumps(new int[] {1, 1, 1}), 2);
        Check.eq(Ch7_2DynamicProgramming.fewestJumps(new int[] {2, 0, 0}), 1);
    }
}

class Ex7_2_17Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.largestSquare(new String[] {"0111", "1111", "0111"}), 9);
        Check.eq(Ch7_2DynamicProgramming.largestSquare(new String[] {"0"}), 0);
        Check.eq(Ch7_2DynamicProgramming.largestSquare(new String[] {"1"}), 1);
        Check.eq(Ch7_2DynamicProgramming.largestSquare(new String[] {"11", "10"}), 1);
        Check.eq(Ch7_2DynamicProgramming.largestSquare(new String[] {"110", "111", "011"}), 4);
        Check.eq(Ch7_2DynamicProgramming.largestSquare(new String[0]), 0);
    }
}

class Ex7_2_18Test {
    public static void run() {
        String[] words = {"sun", "flower", "field", "sunflow", "er"};
        Check.yes(Ch7_2DynamicProgramming.canSplit("sunflowerfield", words));
        Check.no(Ch7_2DynamicProgramming.canSplit("sunfield", new String[] {"sun", "flower"}));
        Check.yes(Ch7_2DynamicProgramming.canSplit("", new String[0]));
        Check.yes(Ch7_2DynamicProgramming.canSplit("erersun", words));
        Check.no(Ch7_2DynamicProgramming.canSplit("sunflowe", words));
    }
}

class Ex7_2_19Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.minPalindromeCuts("noonabbad"), 2);
        Check.eq(Ch7_2DynamicProgramming.minPalindromeCuts("racecarx"), 1);
        Check.eq(Ch7_2DynamicProgramming.minPalindromeCuts("abcb"), 1);
        Check.eq(Ch7_2DynamicProgramming.minPalindromeCuts("abc"), 2);
        Check.eq(Ch7_2DynamicProgramming.minPalindromeCuts(""), 0);
        Check.eq(Ch7_2DynamicProgramming.minPalindromeCuts("aaaa"), 0);
        Check.eq(Ch7_2DynamicProgramming.minPalindromeCuts("ab"), 1);
    }
}

class Ex7_2_20Test {
    public static void run() {
        Check.eq(Ch7_2DynamicProgramming.maxProfitK(new int[] {3, 8, 2, 6, 1, 9}, 2), 13);
        Check.eq(Ch7_2DynamicProgramming.maxProfitK(new int[] {3, 8, 2, 6, 1, 9}, 1), 8);
        Check.eq(Ch7_2DynamicProgramming.maxProfitK(new int[] {3, 8, 2, 6, 1, 9}, 3), 17);
        Check.eq(Ch7_2DynamicProgramming.maxProfitK(new int[] {3, 8, 2, 6, 1, 9}, 0), 0);
        Check.eq(Ch7_2DynamicProgramming.maxProfitK(new int[0], 2), 0);
        Check.eq(Ch7_2DynamicProgramming.maxProfitK(new int[] {5, 4, 3}, 2), 0);
    }
}
