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
