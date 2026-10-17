import java.util.HashMap;

/** Chapter 12 tests, one class per exercise. */
class Ex12_1Test {
    public static void run() {
        Check.eq(Ch12DynamicProgramming.fibNaive(10), 55L);
        Check.eq(Ch12DynamicProgramming.fibMemo(10, new HashMap<>()), 55L);
        Check.eq(Ch12DynamicProgramming.fibBottomUp(10), 55L);
        Check.eq(Ch12DynamicProgramming.fibMemo(80, new HashMap<>()), 23416728348467685L);
        Check.eq(Ch12DynamicProgramming.fibBottomUp(80), 23416728348467685L);
        Check.eq(Ch12DynamicProgramming.fibBottomUp(92), 7540113804746346429L);
        Check.eq(Ch12DynamicProgramming.fibBottomUp(0), 0L);
        Check.eq(Ch12DynamicProgramming.fibBottomUp(1), 1L);
    }
}

class Ex12_2Test {
    public static void run() {
        Check.eq(Ch12DynamicProgramming.maxRecursive(new int[]{1, 2, 3, 4}, 0), 4);
        Check.eq(Ch12DynamicProgramming.maxRecursive(new int[]{9, 2, 3}, 0), 9);
    }
}

class Ex12_3Test {
    public static void run() {
        Check.eq(Ch12DynamicProgramming.staircaseMemo(5), 13L);
        Check.eq(Ch12DynamicProgramming.staircaseMemo(50), 10562230626642L);
    }
}

class Ex12_4Test {
    public static void run() {
        Check.eq(Ch12DynamicProgramming.uniquePathsMemo(3, 7, new HashMap<>()), 28L);
        Check.eq(Ch12DynamicProgramming.uniquePathsMemo(18, 18, new HashMap<>()), 2333606220L);
    }
}

class Ex12_5Test {
    public static void run() {
        Check.eq(Ch12DynamicProgramming.countFibCalls(10), new long[]{177, 19});
    }
}

class Ex12_6Test {
    public static void run() {
        Check.eq(Ch12DynamicProgramming.minCoins(new int[]{1, 5, 10, 25}, 63), 6);
        Check.eq(Ch12DynamicProgramming.minCoins(new int[]{2}, 3), -1);
        Check.eq(Ch12DynamicProgramming.minCoins(new int[]{1, 3, 4}, 6), 2);
        Check.eq(Ch12DynamicProgramming.minCoins(new int[]{1}, 0), 0);
    }
}
