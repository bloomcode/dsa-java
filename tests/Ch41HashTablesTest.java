import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/** Chapter 41 tests, one class per exercise. */

class Ex41_1Test {
    public static void run() {
        Ch41HashTables.HashTable<String, String> t = new Ch41HashTables.HashTable<>();
        t.put("bad", "evil");
        Check.eq(t.get("bad"), "evil");
        t.put("bad", "awful");
        Check.eq(t.get("bad"), "awful");
        Check.eq(t.size(), 1);
        Check.throwsEx(NoSuchElementException.class, () -> t.get("good"));
        Ch41HashTables.HashTable<Integer, Integer> big = new Ch41HashTables.HashTable<>(2);
        for (int i = -500; i < 500; i++) big.put(i, i * i);
        Check.eq(big.size(), 1000);
        Check.yes(big.bucketCount() >= 1000 / 0.75);
        Check.eq(big.get(-321), 103041);
        Check.yes(big.delete(-321));
        Check.no(big.delete(-321));
        Check.no(big.containsKey(-321));
        Check.eq(big.size(), 999);
    }
}

class Ex41_2Test {
    public static void run() {
        Check.yes(Ch41HashTables.canBuild("abba", "aabbc"));
        Check.no(Ch41HashTables.canBuild("abc", "ab"));
        Check.yes(Ch41HashTables.canBuild("", "xyz"));
        Check.no(Ch41HashTables.canBuild("aa", "a"));
        Check.yes(Ch41HashTables.canBuild("cab", "bac"));
    }
}

class Ex41_3Test {
    public static void run() {
        Check.eq(Ch41HashTables.inExactlyOne(new int[]{1, 2, 3}, new int[]{2, 3, 4}), List.of(1, 4));
        Check.eq(Ch41HashTables.inExactlyOne(new int[]{5, 5, 1}, new int[]{1}), List.of(5));
        Check.eq(Ch41HashTables.inExactlyOne(new int[]{}, new int[]{2, 2}), List.of(2));
        Check.eq(Ch41HashTables.inExactlyOne(new int[]{1}, new int[]{1}), List.of());
    }
}

class Ex41_4Test {
    public static void run() {
        Check.eq(Ch41HashTables.distinctPerDay(new int[]{1, 1, 1, 2}, new String[]{"ana", "bo", "ana", "ana"}), Map.of(1, 2, 2, 1));
        Check.eq(Ch41HashTables.distinctPerDay(new int[]{}, new String[]{}), Map.of());
        Check.eq(Ch41HashTables.distinctPerDay(new int[]{7, 7}, new String[]{"x", "x"}), Map.of(7, 1));
    }
}

class Ex41_5Test {
    public static void run() {
        Check.yes(Ch41HashTables.samePattern("egg", "add"));
        Check.no(Ch41HashTables.samePattern("foo", "bar"));
        Check.yes(Ch41HashTables.samePattern("paper", "title"));
        Check.no(Ch41HashTables.samePattern("ab", "aa"));
        Check.no(Ch41HashTables.samePattern("aa", "ab"));
        Check.no(Ch41HashTables.samePattern("a", "ab"));
        Check.yes(Ch41HashTables.samePattern("", ""));
    }
}

class Ex41_6Test {
    public static void run() {
        Check.eq(Ch41HashTables.positions(new String[]{"a", "b", "a"}), Map.of("a", List.of(0, 2), "b", List.of(1)));
        Check.eq(Ch41HashTables.positions(new String[]{}), Map.of());
        Check.eq(Ch41HashTables.positions(new String[]{"x", "x", "x"}), Map.of("x", List.of(0, 1, 2)));
    }
}

class Ex41_7Test {
    public static void run() {
        Check.eq(Ch41HashTables.wordCounts("the cat and the hat").toString(), "{the=2, cat=1, and=1, hat=1}");
        Check.eq(Ch41HashTables.mostCommonWord("the cat and the hat"), "the");
    }
}

class Ex41_8Test {
    public static void run() {
        Check.eq(Ch41HashTables.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}),
                List.of(List.of("eat", "tea", "ate"), List.of("tan", "nat"), List.of("bat")));
    }
}

class Ex41_9Test {
    public static void run() {
        Check.eq(Ch41HashTables.twoSumIndices(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        Check.eq(Ch41HashTables.twoSumIndices(new int[]{2, 7}, 4), null);
        Check.eq(Ch41HashTables.twoSumIndices(new int[]{3, 3}, 6), new int[]{0, 1});
    }
}

class Ex41_10Test {
    public static void run() {
        Map<String, Integer> menu = new LinkedHashMap<>();
        menu.put("fries", 2);
        menu.put("soda", 2);
        menu.put("burger", 5);
        Check.eq(Ch41HashTables.invert(menu).toString(), "{2=[fries, soda], 5=[burger]}");
    }
}

class Ex41_11Test {
    public static void run() {
        Check.eq(Ch41HashTables.longestConsecutive(new int[] {10, 4, 20, 1, 3, 2, 11}), 4);
        Check.eq(Ch41HashTables.longestConsecutive(new int[0]), 0);
        Check.eq(Ch41HashTables.longestConsecutive(new int[] {5, 5, 5}), 1);
        Check.eq(Ch41HashTables.longestConsecutive(new int[] {0, -1, 1, 9, 8}), 3);
    }
}

class Ex41_12Test {
    public static void run() {
        Check.yes(Ch41HashTables.hasZeroSumRun(new int[] {4, 2, -3, 1, 6}));
        Check.no(Ch41HashTables.hasZeroSumRun(new int[] {4, 2, 1}));
        Check.yes(Ch41HashTables.hasZeroSumRun(new int[] {0}));
        Check.no(Ch41HashTables.hasZeroSumRun(new int[0]));
        Check.yes(Ch41HashTables.hasZeroSumRun(new int[] {1, -1}));
        Check.yes(Ch41HashTables.hasZeroSumRun(new int[] {3, 5, -8, 2}));
        Check.no(Ch41HashTables.hasZeroSumRun(new int[] {-2, 5}));
    }
}

class Ex41_13Test {
    public static void run() {
        Check.eq(Ch41HashTables.countSumRuns(new int[] {1, 2, 3, -2, 2}, 3), 4);
        Check.eq(Ch41HashTables.countSumRuns(new int[] {1, 1, 1}, 2), 2);
        Check.eq(Ch41HashTables.countSumRuns(new int[0], 0), 0);
        Check.eq(Ch41HashTables.countSumRuns(new int[] {0, 0}, 0), 3);
        Check.eq(Ch41HashTables.countSumRuns(new int[] {5}, -5), 0);
        Check.eq(Ch41HashTables.countSumRuns(new int[] {2, -2, 2}, 2), 3);
    }
}

class Ex41_14Test {
    public static void run() {
        Check.eq(Ch41HashTables.symmetricPairs(new int[][] {{1, 2}, {3, 4}, {5, 6}, {4, 3}, {2, 1}}), new int[][] {{3, 4}, {1, 2}});
        Check.eq(Ch41HashTables.symmetricPairs(new int[0][]), new int[0][]);
        Check.eq(Ch41HashTables.symmetricPairs(new int[][] {{1, 2}, {2, 3}}), new int[0][]);
        Check.eq(Ch41HashTables.symmetricPairs(new int[][] {{7, 8}, {8, 7}, {9, 7}, {7, 9}}), new int[][] {{7, 8}, {9, 7}});
    }
}

class Ex41_15Test {
    public static void run() {
        Check.eq(Ch41HashTables.traceJourney(new String[][] {{"MAA", "BOM"}, {"DEL", "MAA"}, {"BOM", "GOI"}}), List.of("DEL", "MAA", "BOM", "GOI"));
        Check.eq(Ch41HashTables.traceJourney(new String[0][]), List.of());
        Check.eq(Ch41HashTables.traceJourney(new String[][] {{"A", "B"}}), List.of("A", "B"));
        Check.eq(Ch41HashTables.traceJourney(new String[][] {{"C", "D"}, {"B", "C"}, {"D", "E"}, {"A", "B"}}), List.of("A", "B", "C", "D", "E"));
    }
}

class Ex41_16Test {
    public static void run() {
        Check.yes(Ch41HashTables.disjoint(new int[] {1, 5, 9}, new int[] {2, 6}));
        Check.no(Ch41HashTables.disjoint(new int[] {1, 5}, new int[] {5}));
        Check.yes(Ch41HashTables.disjoint(new int[0], new int[] {1}));
        Check.yes(Ch41HashTables.disjoint(new int[0], new int[0]));
        Check.no(Ch41HashTables.disjoint(new int[] {3, 3}, new int[] {4, 3}));
    }
}

class Ex41_17Test {
    public static void run() {
        Check.eq(Ch41HashTables.mostOnALine(new int[][] {{0, 0}, {1, 1}, {2, 2}, {3, 1}, {0, 3}}), 3);
        Check.eq(Ch41HashTables.mostOnALine(new int[0][]), 0);
        Check.eq(Ch41HashTables.mostOnALine(new int[][] {{1, 1}}), 1);
        Check.eq(Ch41HashTables.mostOnALine(new int[][] {{1, 1}, {1, 1}, {2, 3}}), 3);
        Check.eq(Ch41HashTables.mostOnALine(new int[][] {{2, 0}, {2, 5}, {2, -1}, {3, 3}}), 3);
        Check.eq(Ch41HashTables.mostOnALine(new int[][] {{0, 0}, {2, 1}, {4, 2}, {6, 3}, {1, 0}}), 4);
        Check.eq(Ch41HashTables.mostOnALine(new int[][] {{0, 0}, {-2, 1}, {2, -1}}), 3);
    }
}
