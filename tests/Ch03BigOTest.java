/** Chapter 3 tests, one class per exercise. */
class Ex3_1Test {
    public static void run() {
        Check.yes(Ch03BigO.isLeapYear(2024));
        Check.no(Ch03BigO.isLeapYear(1900));
        Check.yes(Ch03BigO.isLeapYear(2000));
        Check.no(Ch03BigO.isLeapYear(2023));
    }
}

class Ex3_2Test {
    public static void run() {
        Check.eq(Ch03BigO.arraySum(new int[]{1, 2, 3, 4}), 10L);
        Check.eq(Ch03BigO.arraySum(new int[]{}), 0L);
    }
}

class Ex3_3Test {
    public static void run() {
        Check.eq(Ch03BigO.halvingSteps(8), 3);
        Check.eq(Ch03BigO.halvingSteps(1024), 10);
        Check.eq(Ch03BigO.halvingSteps(1), 0);
    }
}

class Ex3_4Test {
    public static void run() {
        Check.eq(Ch03BigO.squaresNeeded(1), 1);
        Check.eq(Ch03BigO.squaresNeeded(16), 5);
        Check.eq(Ch03BigO.squaresNeeded(17), 6);
    }
}

class Ex3_5Test {
    public static void run() {
        Check.eq(Ch03BigO.allPairsSteps(4), 16L);
        Check.eq(Ch03BigO.uniquePairsSteps(4), 6L);
    }
}
