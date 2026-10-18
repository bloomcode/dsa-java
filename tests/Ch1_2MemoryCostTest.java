import java.util.ArrayList;
import java.util.List;

/** Chapter 1.2 tests, one class per exercise. */

class Ex1_2_1Test {
    public static void run() {
        int[] scores = {10, 20};
        Check.eq(Ch1_2MemoryCost.scaledCopy(scores, 3), new int[]{30, 60});
        Check.eq(scores, new int[]{10, 20});
        Check.yes(Ch1_2MemoryCost.scaleInPlace(scores, 3) == scores);
        Check.eq(scores, new int[]{30, 60});
        Check.eq(Ch1_2MemoryCost.scaledCopy(new int[]{}, 5), new int[]{});
    }
}

class Ex1_2_2Test {
    public static void run() {
        for (java.util.function.ToIntFunction<int[]> fn : List.<java.util.function.ToIntFunction<int[]>>of(
                Ch1_2MemoryCost::modeNested, Ch1_2MemoryCost::modeCounts, Ch1_2MemoryCost::modeSorted)) {
            Check.eq(fn.applyAsInt(new int[]{4, 1, 4, 2, 1, 4}), 4);
            Check.eq(fn.applyAsInt(new int[]{2, 1, 2, 1}), 1);
            Check.eq(fn.applyAsInt(new int[]{7}), 7);
            Check.eq(fn.applyAsInt(new int[]{-3, 5, -3}), -3);
        }
    }
}

class Ex1_2_3Test {
    public static void run() {
        int[] big = new int[50_000];
        for (int i = 0; i < big.length; i++) big[i] = i;
        Check.eq(Ch1_2MemoryCost.sumListIterative(big), 1249975000L);
        Check.eq(Ch1_2MemoryCost.sumListRecursive(new int[]{1, 2, 3}, 0), 6L);
        Check.eq(Ch1_2MemoryCost.sumListRecursive(new int[]{}, 0), 0L);
        Check.yes(Ch1_2MemoryCost.overflows(1_000_000));
        Check.no(Ch1_2MemoryCost.overflows(1_000));
    }
}

class Ex1_2_4Test {
    public static void run() {
        int[] orig = {1, 2, 3, 4, 5};
        Check.eq(Ch1_2MemoryCost.rotateCopy(orig, 2), new int[]{4, 5, 1, 2, 3});
        Check.eq(orig, new int[]{1, 2, 3, 4, 5});
        Check.yes(Ch1_2MemoryCost.rotateInPlace(orig, 2) == orig);
        Check.eq(orig, new int[]{4, 5, 1, 2, 3});
        Check.eq(Ch1_2MemoryCost.rotateInPlace(new int[]{1, 2, 3}, 7), new int[]{3, 1, 2});
        Check.eq(Ch1_2MemoryCost.rotateCopy(new int[]{1, 2, 3}, 0), new int[]{1, 2, 3});
        Check.eq(Ch1_2MemoryCost.rotateInPlace(new int[]{}, 3), new int[]{});
    }
}

class Ex1_2_5Test {
    public static void run() {
        Check.yes(Ch1_2MemoryCost.isPalindromeClean("A man, a plan, a canal: Panama"));
        Check.no(Ch1_2MemoryCost.isPalindromeClean("race a car"));
    }
}
