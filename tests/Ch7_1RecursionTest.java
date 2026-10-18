import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Chapter 7.1 tests, one class per exercise. */

class Ex7_1_1Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.digitCount(12345), 5);
        Check.eq(Ch7_1Recursion.digitCount(0), 1);
        Check.eq(Ch7_1Recursion.digitCount(9), 1);
        Check.eq(Ch7_1Recursion.digitCount(10), 2);
        Check.eq(Ch7_1Recursion.digitCount(Long.MAX_VALUE), 19);
    }
}

class Ex7_1_2Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.factorial(5), 120L);
        Check.eq(Ch7_1Recursion.factorial(0), 1L);
        Check.eq(Ch7_1Recursion.factorial(20), 2432902008176640000L);
    }
}

class Ex7_1_3Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.sumRecursive(new int[]{1, 2, 3, 4}, 0), 10L);
        Check.eq(Ch7_1Recursion.sumRecursive(new int[]{}, 0), 0L);
    }
}

class Ex7_1_4Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.maxDepth(List.of(1, List.of(2, List.of(3)), 4)), 3);
        Check.eq(Ch7_1Recursion.maxDepth(List.of()), 1);
        Check.eq(Ch7_1Recursion.maxDepth(List.of(1, 2)), 1);
        Check.eq(Ch7_1Recursion.maxDepth(List.of(List.of(List.of(List.of())), List.of(1))), 4);
    }
}

class Ex7_1_5Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.power(2, 10), 1024L);
        Check.eq(Ch7_1Recursion.power(3, 0), 1L);
        Check.eq(Ch7_1Recursion.power(5, 3), 125L);
    }
}

class Ex7_1_6Test {
    public static void run() {
        Ch7_1Recursion.Person di = new Ch7_1Recursion.Person("di", List.of());
        Ch7_1Recursion.Person ana = new Ch7_1Recursion.Person("ana", List.of(
                new Ch7_1Recursion.Person("bo", List.of()), new Ch7_1Recursion.Person("cy", List.of(di))));
        Check.eq(Ch7_1Recursion.headcount(ana), 4);
        Check.eq(Ch7_1Recursion.headcount(di), 1);
    }
}

class Ex7_1_7Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.toBinary(5), "101");
        Check.eq(Ch7_1Recursion.toBinary(0), "0");
        Check.eq(Ch7_1Recursion.toBinary(8), "1000");
        Check.eq(Ch7_1Recursion.toBinary(255), "11111111");
    }
}

class Ex7_1_8Test {
    public static void run() {
        int[] data = {1, 2, 3, 4};
        Check.yes(Ch7_1Recursion.runningTotals(data, 1) == data);
        Check.eq(data, new int[]{1, 3, 6, 10});
        Check.eq(Ch7_1Recursion.runningTotals(new int[]{}, 1), new int[]{});
        Check.eq(Ch7_1Recursion.runningTotals(new int[]{2, -2, 2}, 1), new int[]{2, 0, 2});
    }
}

class Ex7_1_9Test {
    public static void run() {
        for (String s : new String[]{"level", "", "x", "abba"}) Check.yes(Ch7_1Recursion.isPalindromeRec(s, 0, s.length() - 1));
        for (String s : new String[]{"levels", "abca"}) Check.no(Ch7_1Recursion.isPalindromeRec(s, 0, s.length() - 1));
    }
}

class Ex7_1_10Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.digitSum(9045), 18);
        Check.eq(Ch7_1Recursion.digitSum(0), 0);
        Check.eq(Ch7_1Recursion.digitSum(7), 7);
        Check.eq(Ch7_1Recursion.digitSum(99999), 45);
    }
}

class Ex7_1_11Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.longestWord(new String[]{"go", "java", "py", "rust"}, 0), "java");
        Check.eq(Ch7_1Recursion.longestWord(new String[]{}, 0), "");
        Check.eq(Ch7_1Recursion.longestWord(new String[]{"a", "bb", "cc"}, 0), "bb");
    }
}

class Ex7_1_12Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.collapseRuns(new int[]{1, 1, 2, 2, 2, 3, 1}, 0), List.of(1, 2, 3, 1));
        Check.eq(Ch7_1Recursion.collapseRuns(new int[]{}, 0), List.of());
        Check.eq(Ch7_1Recursion.collapseRuns(new int[]{4, 4, 4}, 0), List.of(4));
        Check.eq(Ch7_1Recursion.collapseRuns(new int[]{1, 2, 1}, 0), List.of(1, 2, 1));
    }
}

class Ex7_1_13Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.collatzSteps(6), 8);
        Check.eq(Ch7_1Recursion.collatzSteps(1), 0);
        Check.eq(Ch7_1Recursion.collatzSteps(2), 1);
        Check.eq(Ch7_1Recursion.collatzSteps(27), 111);
    }
}

class Ex7_1_14Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.gcd(48, 18), 6L);
        Check.eq(Ch7_1Recursion.gcd(7, 0), 7L);
        Check.eq(Ch7_1Recursion.gcd(0, 5), 5L);
        Check.eq(Ch7_1Recursion.gcd(17, 5), 1L);
        Check.eq(Ch7_1Recursion.gcd(270, 192), 6L);
    }
}

class Ex7_1_15Test {
    public static void run() {
        long[] first = new long[8];
        for (int n = 0; n < 8; n++) first[n] = Ch7_1Recursion.tilings(n);
        Check.eq(first, new long[]{1, 1, 1, 2, 3, 4, 6, 9});
        Check.eq(Ch7_1Recursion.tilings(10), 28L);
    }
}

class Ex7_1_16Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.parenStrings(2), List.of("(())", "()()"));
        Check.eq(Ch7_1Recursion.parenStrings(0), List.of(""));
        Check.eq(Ch7_1Recursion.parenStrings(3), List.of("((()))", "(()())", "(())()", "()(())", "()()()"));
        Check.eq(Ch7_1Recursion.parenStrings(5).size(), 42);
    }
}

class Ex7_1_17Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.diceWays(2, 7), 6L);
        Check.eq(Ch7_1Recursion.diceWays(1, 7), 0L);
        Check.eq(Ch7_1Recursion.diceWays(0, 0), 1L);
        Check.eq(Ch7_1Recursion.diceWays(3, 10), 27L);
        Check.eq(Ch7_1Recursion.diceWays(2, 13), 0L);
    }
}

class Ex7_1_18Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.subsets(List.of(1, 2)), List.of(List.of(), List.of(2), List.of(1), List.of(1, 2)));
        Check.eq(Ch7_1Recursion.subsets(List.of(1, 2, 3, 4)).size(), 16);
    }
}

class Ex7_1_19Test {
    public static void run() {
        Check.eq(Ch7_1Recursion.lastStanding(5, 2), 3);
        Check.eq(Ch7_1Recursion.lastStanding(1, 3), 1);
        Check.eq(Ch7_1Recursion.lastStanding(7, 3), 4);
        Check.eq(Ch7_1Recursion.lastStanding(6, 1), 6);
        Check.eq(Ch7_1Recursion.lastStanding(10, 2), 5);
        Check.eq(Ch7_1Recursion.lastStanding(2, 2), 1);
    }
}
