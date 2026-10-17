import java.util.HashMap;

/** Chapter 72 tests, one class per exercise. */

class Ex72_1Test {
    public static void run() {
        Check.eq(Ch72DynamicProgramming.fibNaive(10), 55L);
        Check.eq(Ch72DynamicProgramming.fibMemo(10, new HashMap<>()), 55L);
        Check.eq(Ch72DynamicProgramming.fibBottomUp(10), 55L);
        Check.eq(Ch72DynamicProgramming.fibMemo(80, new HashMap<>()), 23416728348467685L);
        Check.eq(Ch72DynamicProgramming.fibBottomUp(80), 23416728348467685L);
        Check.eq(Ch72DynamicProgramming.fibBottomUp(92), 7540113804746346429L);
        Check.eq(Ch72DynamicProgramming.fibBottomUp(0), 0L);
        Check.eq(Ch72DynamicProgramming.fibBottomUp(1), 1L);
    }
}

class Ex72_2Test {
    public static void run() {
        Check.eq(Ch72DynamicProgramming.minMax(new int[]{4, -2, 9, 0}, 0), new int[]{-2, 9});
        Check.eq(Ch72DynamicProgramming.minMax(new int[]{7}, 0), new int[]{7, 7});
        int[] big = new int[60];
        for (int i = 0; i < big.length; i++) big[i] = i;
        Check.eq(Ch72DynamicProgramming.minMax(big, 0), new int[]{0, 59});
    }
}

class Ex72_3Test {
    public static void run() {
        Check.eq(Ch72DynamicProgramming.tilingsMemo(10, new HashMap<>()), 28L);
        Check.eq(Ch72DynamicProgramming.tilingsMemo(60, new HashMap<>()), 5582216355L);
        Check.eq(Ch72DynamicProgramming.tilingsMemo(90, new HashMap<>()), 533352837917926L);
    }
}

class Ex72_4Test {
    public static void run() {
        Check.eq(Ch72DynamicProgramming.diceWaysMemo(2, 7, new HashMap<>()), 6L);
        Check.eq(Ch72DynamicProgramming.diceWaysMemo(3, 10, new HashMap<>()), 27L);
        Check.eq(Ch72DynamicProgramming.diceWaysMemo(20, 70, new HashMap<>()), 189456975899496L);
        Check.eq(Ch72DynamicProgramming.diceWaysMemo(10, 35, new HashMap<>()), 4395456L);
    }
}

class Ex72_5Test {
    public static void run() {
        Check.eq(Ch72DynamicProgramming.countFibCalls(10), new long[]{177, 19});
    }
}

class Ex72_6Test {
    public static void run() {
        Check.eq(Ch72DynamicProgramming.minCoins(new int[]{1, 5, 10, 25}, 63), 6);
        Check.eq(Ch72DynamicProgramming.minCoins(new int[]{2}, 3), -1);
        Check.eq(Ch72DynamicProgramming.minCoins(new int[]{1, 3, 4}, 6), 2);
        Check.eq(Ch72DynamicProgramming.minCoins(new int[]{1}, 0), 0);
    }
}
