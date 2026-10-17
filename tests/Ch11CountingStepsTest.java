import java.util.List;

/** Chapter 11 tests, one class per exercise. */

class Ex11_1Test {
    public static void run() {
        Check.yes(Ch11CountingSteps.isLeapYear(2024));
        Check.no(Ch11CountingSteps.isLeapYear(1900));
        Check.yes(Ch11CountingSteps.isLeapYear(2000));
        Check.no(Ch11CountingSteps.isLeapYear(2023));
    }
}

class Ex11_2Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.arraySum(new int[]{1, 2, 3, 4}), 10L);
        Check.eq(Ch11CountingSteps.arraySum(new int[]{}), 0L);
    }
}

class Ex11_3Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.halvingSteps(8), 3);
        Check.eq(Ch11CountingSteps.halvingSteps(1024), 10);
        Check.eq(Ch11CountingSteps.halvingSteps(1), 0);
    }
}

class Ex11_4Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.roundsToReach(1), 0);
        Check.eq(Ch11CountingSteps.roundsToReach(2), 1);
        Check.eq(Ch11CountingSteps.roundsToReach(3), 2);
        Check.eq(Ch11CountingSteps.roundsToReach(1000), 10);
        Check.eq(Ch11CountingSteps.roundsToReach(1024), 10);
        Check.eq(Ch11CountingSteps.roundsToReach(1025), 11);
    }
}

class Ex11_5Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.allPairsSteps(4), 16L);
        Check.eq(Ch11CountingSteps.uniquePairsSteps(4), 6L);
    }
}

class Ex11_6Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.finalBalance(new int[]{50, -20, -40, 10}), 40);
        Check.eq(Ch11CountingSteps.finalBalance(new int[]{}), 0);
        Check.eq(Ch11CountingSteps.finalBalance(new int[]{-5}), 0);
        Check.eq(Ch11CountingSteps.finalBalance(new int[]{5, -5, -1}), 0);
    }
}

class Ex11_7Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.pairings(new String[]{"ana", "bo", "cy"}), List.of("ana-bo", "ana-cy", "bo-cy"));
        Check.eq(Ch11CountingSteps.pairings(new String[]{"solo"}), List.of());
        Check.eq(Ch11CountingSteps.pairings(new String[10]).size(), 45);
    }
}

class Ex11_8Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.committees(new String[]{"a", "b", "c", "d"}), List.of("a,b,c", "a,b,d", "a,c,d", "b,c,d"));
        Check.eq(Ch11CountingSteps.committees(new String[]{"a", "b"}), List.of());
        Check.eq(Ch11CountingSteps.committees(new String[10]).size(), 120);
    }
}

class Ex11_9Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.newest(List.of("a", "b", "c", "d"), 2), List.of("c", "d"));
        Check.eq(Ch11CountingSteps.newest(List.of("a"), 5), List.of("a"));
        Check.eq(Ch11CountingSteps.newest(List.of("a", "b"), 0), List.of());
    }
}

class Ex11_10Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.busiestHour(new String[]{"09:15", "10:02", "09:40", "11:00"}), 9);
        Check.eq(Ch11CountingSteps.busiestHour(new String[]{"10:00", "09:00"}), 9);
        Check.eq(Ch11CountingSteps.busiestHour(new String[]{"23:59", "23:00", "00:10"}), 23);
    }
}

class Ex11_11Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.weeklySlots(new String[]{"ana"}),
                List.of("ana Mon", "ana Tue", "ana Wed", "ana Thu", "ana Fri", "ana Sat", "ana Sun"));
        List<String> slots = Ch11CountingSteps.weeklySlots(new String[]{"ana", "bo"});
        Check.eq(slots.size(), 14);
        Check.eq(slots.get(7), "bo Mon");
        Check.eq(Ch11CountingSteps.weeklySlots(new String[]{}), List.of());
    }
}

class Ex11_12Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.countVowels(new String[]{"Hello", "World"}), 3);
        Check.eq(Ch11CountingSteps.countVowels(new String[]{"AEIOU xyz", ""}), 5);
        Check.eq(Ch11CountingSteps.countVowels(new String[]{}), 0);
    }
}

class Ex11_13Test {
    public static void run() {
        Check.yes(Ch11CountingSteps.isSymmetric(new int[][]{{1, 2}, {2, 1}}));
        Check.no(Ch11CountingSteps.isSymmetric(new int[][]{{1, 2}, {3, 1}}));
        Check.yes(Ch11CountingSteps.isSymmetric(new int[][]{}));
        Check.yes(Ch11CountingSteps.isSymmetric(new int[][]{{7}}));
        Check.yes(Ch11CountingSteps.isSymmetric(new int[][]{{1, 2, 3}, {2, 5, 6}, {3, 6, 9}}));
        Check.no(Ch11CountingSteps.isSymmetric(new int[][]{{1, 2, 3}, {2, 5, 6}, {3, 0, 9}}));
    }
}

class Ex11_14Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.closestGap(new int[]{10, 4, 15, 7}), 3);
        Check.eq(Ch11CountingSteps.closestGap(new int[]{1, 100}), 99);
        Check.eq(Ch11CountingSteps.closestGap(new int[]{5, 5, 9}), 0);
        Check.eq(Ch11CountingSteps.closestGap(new int[]{-3, 8, -1}), 2);
    }
}

class Ex11_15Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.sharedHours(new int[]{9, 10, 13, 15}, new int[]{10, 11, 15}), List.of(10, 15));
        Check.eq(Ch11CountingSteps.sharedHours(new int[]{}, new int[]{1}), List.of());
        Check.eq(Ch11CountingSteps.sharedHours(new int[]{8}, new int[]{}), List.of());
        Check.eq(Ch11CountingSteps.sharedHours(new int[]{7, 8}, new int[]{8, 7}), List.of(7, 8));
    }
}

class Ex11_16Test {
    public static void run() {
        Check.eq(Ch11CountingSteps.switchSettings(2), List.of("00", "01", "10", "11"));
        Check.eq(Ch11CountingSteps.switchSettings(0), List.of(""));
        Check.eq(Ch11CountingSteps.switchSettings(1), List.of("0", "1"));
        List<String> three = Ch11CountingSteps.switchSettings(3);
        Check.eq(three.size(), 8);
        Check.eq(three.get(0), "000");
        Check.eq(three.get(5), "101");
        Check.eq(three.get(7), "111");
    }
}
