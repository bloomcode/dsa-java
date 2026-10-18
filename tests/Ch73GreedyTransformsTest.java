import java.util.List;

/** Chapter 73 tests, one class per exercise. */

class Ex73_1Test {
    public static void run() {
        Check.yes(Ch73GreedyTransforms.hasPairWithDifference(new int[]{1, 8, 4, 11}, 3));
        Check.no(Ch73GreedyTransforms.hasPairWithDifference(new int[]{1, 5}, 3));
        Check.yes(Ch73GreedyTransforms.hasPairWithDifference(new int[]{3, 3}, 0));
        Check.no(Ch73GreedyTransforms.hasPairWithDifference(new int[]{3}, 0));
        Check.yes(Ch73GreedyTransforms.hasPairWithDifference(new int[]{10, -2}, 12));
    }
}

class Ex73_2Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.windowWithSum(new int[]{2, 4, 3, 5, 1}, 8), new int[]{2, 3});
        Check.eq(Ch73GreedyTransforms.windowWithSum(new int[]{1, 2}, 7), null);
        Check.eq(Ch73GreedyTransforms.windowWithSum(new int[]{5}, 5), new int[]{0, 0});
        Check.eq(Ch73GreedyTransforms.windowWithSum(new int[]{1, 2, 3}, 6), new int[]{0, 2});
    }
}

class Ex73_3Test {
    public static void run() {
        Check.yes(Ch73GreedyTransforms.canReachEnd(new int[]{2, 3, 1, 1, 4}));
        Check.no(Ch73GreedyTransforms.canReachEnd(new int[]{3, 2, 1, 0, 4}));
        Check.yes(Ch73GreedyTransforms.canReachEnd(new int[]{0}));
        Check.no(Ch73GreedyTransforms.canReachEnd(new int[]{0, 1}));
    }
}

class Ex73_4Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.roomsNeeded(new int[][]{{9, 11}, {10, 12}, {11, 13}, {9, 10}}), 2);
        Check.eq(Ch73GreedyTransforms.roomsNeeded(new int[][]{}), 0);
        Check.eq(Ch73GreedyTransforms.roomsNeeded(new int[][]{{1, 5}, {2, 6}, {3, 7}}), 3);
        Check.eq(Ch73GreedyTransforms.roomsNeeded(new int[][]{{1, 2}, {2, 3}}), 1);
    }
}

class Ex73_5Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.maxMeetings(new int[][]{{1, 4}, {3, 5}, {0, 6}, {5, 7}, {8, 9}, {5, 9}}), 3);
        Check.eq(Ch73GreedyTransforms.maxMeetings(new int[][]{}), 0);
        Check.eq(Ch73GreedyTransforms.maxMeetings(new int[][]{{1, 10}, {2, 3}, {3, 4}, {4, 5}}), 3);
        Check.eq(Ch73GreedyTransforms.maxMeetings(new int[][]{{1, 2}, {1, 2}}), 1);
    }
}

class Ex73_6Test {
    public static void run() {
        Ch73GreedyTransforms.RangeSum r = new Ch73GreedyTransforms.RangeSum(new int[]{3, 1, 4, 1, 5});
        Check.eq(r.total(1, 3), 6L);
        Check.eq(r.total(0, 4), 14L);
        Check.eq(r.total(2, 2), 4L);
        Check.eq(new Ch73GreedyTransforms.RangeSum(new int[]{-2, 2}).total(0, 1), 0L);
    }
}

class Ex73_7Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.topKFrequent(new String[]{"b", "a", "b", "c", "a", "b"}, 2), List.of("b", "a"));
        Check.eq(Ch73GreedyTransforms.topKFrequent(new String[]{"x", "y", "z"}, 2), List.of("x", "y"));
        Check.eq(Ch73GreedyTransforms.topKFrequent(new String[]{"q"}, 5), List.of("q"));
        Check.eq(Ch73GreedyTransforms.topKFrequent(new String[]{"m", "n", "n", "m", "o"}, 3), List.of("m", "n", "o"));
    }
}

class Ex73_8Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.loneValue(new int[]{4, 1, 2, 1, 2}), 4);
        Check.eq(Ch73GreedyTransforms.loneValue(new int[]{7}), 7);
        Check.eq(Ch73GreedyTransforms.loneValue(new int[]{0, 9, 9}), 0);
        Check.eq(Ch73GreedyTransforms.loneValue(new int[]{-3, 5, 5}), -3);
    }
}

class Ex73_9Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.longestUniqueRun("abcadbe"), 5);
        Check.eq(Ch73GreedyTransforms.longestUniqueRun("aaaa"), 1);
        Check.eq(Ch73GreedyTransforms.longestUniqueRun(""), 0);
        Check.eq(Ch73GreedyTransforms.longestUniqueRun("abba"), 2);
        Check.eq(Ch73GreedyTransforms.longestUniqueRun("tmmzuxt"), 5);
    }
}

class Ex73_10Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.leastTotalWaiting(new int[] {3, 2, 1, 2, 6}), 17L);
        Check.eq(Ch73GreedyTransforms.leastTotalWaiting(new int[0]), 0L);
        Check.eq(Ch73GreedyTransforms.leastTotalWaiting(new int[] {5}), 0L);
        Check.eq(Ch73GreedyTransforms.leastTotalWaiting(new int[] {4, 1}), 1L);
        Check.eq(Ch73GreedyTransforms.leastTotalWaiting(new int[] {2, 2, 2}), 6L);
    }
}

class Ex73_11Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.pairFinishTime(new int[] {5, 2, 1, 6, 4, 4}), 8);
        Check.eq(Ch73GreedyTransforms.pairFinishTime(new int[] {1, 2}), 3);
        Check.eq(Ch73GreedyTransforms.pairFinishTime(new int[] {3, 3, 3, 3}), 6);
        Check.eq(Ch73GreedyTransforms.pairFinishTime(new int[] {1, 9, 2, 8}), 10);
    }
}

class Ex73_12Test {
    public static void run() {
        Check.yes(Ch73GreedyTransforms.canTakePhoto(new int[] {5, 8, 1, 3, 4}, new int[] {6, 9, 2, 4, 5}));
        Check.no(Ch73GreedyTransforms.canTakePhoto(new int[] {1, 2}, new int[] {1, 3}));
        Check.no(Ch73GreedyTransforms.canTakePhoto(new int[] {3}, new int[] {3}));
        Check.yes(Ch73GreedyTransforms.canTakePhoto(new int[] {6, 5}, new int[] {4, 4}));
        Check.no(Ch73GreedyTransforms.canTakePhoto(new int[] {1, 9}, new int[] {5, 5}));
    }
}

class Ex73_13Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.tandemTotal(new int[] {5, 5, 3, 9, 2}, new int[] {3, 6, 7, 2, 1}, true), 32);
        Check.eq(Ch73GreedyTransforms.tandemTotal(new int[] {5, 5, 3, 9, 2}, new int[] {3, 6, 7, 2, 1}, false), 25);
        Check.eq(Ch73GreedyTransforms.tandemTotal(new int[] {1}, new int[] {1}, true), 1);
        Check.eq(Ch73GreedyTransforms.tandemTotal(new int[] {1, 4}, new int[] {5, 2}, true), 9);
        Check.eq(Ch73GreedyTransforms.tandemTotal(new int[] {1, 4}, new int[] {5, 2}, false), 7);
    }
}

class Ex73_14Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.loopStart(new int[] {1, 5, 3, 3, 1}, new int[] {3, 2, 4, 1, 1}), 1);
        Check.eq(Ch73GreedyTransforms.loopStart(new int[] {2, 2}, new int[] {3, 3}), -1);
        Check.eq(Ch73GreedyTransforms.loopStart(new int[] {3}, new int[] {2}), 0);
        Check.eq(Ch73GreedyTransforms.loopStart(new int[] {1, 2, 3}, new int[] {2, 3, 1}), 2);
    }
}

class Ex73_15Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.fewestRewards(new int[] {4, 2, 6, 3, 3, 1}), 9);
        Check.eq(Ch73GreedyTransforms.fewestRewards(new int[0]), 0);
        Check.eq(Ch73GreedyTransforms.fewestRewards(new int[] {5}), 1);
        Check.eq(Ch73GreedyTransforms.fewestRewards(new int[] {1, 2, 3}), 6);
        Check.eq(Ch73GreedyTransforms.fewestRewards(new int[] {3, 3, 3}), 3);
        Check.eq(Ch73GreedyTransforms.fewestRewards(new int[] {1, 3, 2}), 4);
        Check.eq(Ch73GreedyTransforms.fewestRewards(new int[] {5, 4, 3, 2, 1}), 15);
    }
}

class Ex73_16Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.bestScheduleProfit(new int[][] {{2, 50}, {1, 10}, {2, 40}, {1, 30}, {3, 20}}), 110);
        Check.eq(Ch73GreedyTransforms.bestScheduleProfit(new int[0][]), 0);
        Check.eq(Ch73GreedyTransforms.bestScheduleProfit(new int[][] {{1, 5}, {1, 9}}), 9);
        Check.eq(Ch73GreedyTransforms.bestScheduleProfit(new int[][] {{3, 1}, {3, 2}, {3, 3}, {3, 4}}), 9);
    }
}

class Ex73_17Test {
    public static void run() {
        Check.eq(Ch73GreedyTransforms.stableMatching(new int[][] {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}}, new int[][] {{1, 0, 2}, {0, 1, 2}, {0, 1, 2}}), new int[] {1, 0, 2});
        Check.eq(Ch73GreedyTransforms.stableMatching(new int[][] {{0}}, new int[][] {{0}}), new int[] {0});
        Check.eq(Ch73GreedyTransforms.stableMatching(new int[][] {{0, 1}, {0, 1}}, new int[][] {{1, 0}, {1, 0}}), new int[] {1, 0});
    }
}
