import java.util.ArrayList;
import java.util.List;

/** Chapter 19 tests, one class per exercise. */
class Ex19_1Test {
    public static void run() {
        List<String> original = List.of("amy", "bob");
        Check.eq(Ch19Space.uppercaseCopy(original), List.of("AMY", "BOB"));
        List<String> words = new ArrayList<>(original);
        Check.yes(Ch19Space.uppercaseInPlace(words) == words);
        Check.eq(words, List.of("AMY", "BOB"));
    }
}

class Ex19_2Test {
    public static void run() {
        Check.yes(Ch19Space.dupNested(new int[]{3, 1, 4, 1}));
        Check.yes(Ch19Space.dupSet(new int[]{3, 1, 4, 1}));
        Check.yes(Ch19Space.dupSortInPlace(new int[]{3, 1, 4, 1}));
        Check.no(Ch19Space.dupNested(new int[]{3, 1, 4}));
        Check.no(Ch19Space.dupSet(new int[]{3, 1, 4}));
        Check.no(Ch19Space.dupSortInPlace(new int[]{3, 1, 4}));
    }
}

class Ex19_3Test {
    public static void run() {
        Check.eq(Ch19Space.sumToIterative(50_000), 1250025000L);
        Check.eq(Ch19Space.sumToRecursive(1_000), 500500L);
        Check.yes(Ch19Space.overflows(1_000_000));
        Check.no(Ch19Space.overflows(1_000));
    }
}

class Ex19_4Test {
    public static void run() {
        int[] original = {1, 2, 3};
        Check.eq(Ch19Space.reverseCopy(original), new int[]{3, 2, 1});
        Check.eq(original, new int[]{1, 2, 3});
    }
}

class Ex19_5Test {
    public static void run() {
        Check.yes(Ch19Space.isPalindromeClean("A man, a plan, a canal: Panama"));
        Check.no(Ch19Space.isPalindromeClean("race a car"));
    }
}
