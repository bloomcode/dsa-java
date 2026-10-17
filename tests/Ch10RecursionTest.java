import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Chapter 10 tests, one class per exercise. */
class Ex10_1Test {
    public static void run() {
        Check.eq(Ch10Recursion.countdown(3), List.of(3, 2, 1, 0));
        Check.eq(Ch10Recursion.countdown(0), List.of(0));
    }
}

class Ex10_2Test {
    public static void run() {
        Check.eq(Ch10Recursion.factorial(5), 120L);
        Check.eq(Ch10Recursion.factorial(0), 1L);
        Check.eq(Ch10Recursion.factorial(20), 2432902008176640000L);
    }
}

class Ex10_3Test {
    public static void run() {
        Check.eq(Ch10Recursion.sumRecursive(new int[]{1, 2, 3, 4}, 0), 10L);
        Check.eq(Ch10Recursion.sumRecursive(new int[]{}, 0), 0L);
    }
}

class Ex10_4Test {
    public static void run() {
        Check.eq(Ch10Recursion.flatten(List.of(1, List.of(2, List.of(3, 4)), 5)), List.of(1, 2, 3, 4, 5));
        Check.eq(Ch10Recursion.flatten(List.of()), List.of());
    }
}

class Ex10_5Test {
    public static void run() {
        Check.eq(Ch10Recursion.power(2, 10), 1024L);
        Check.eq(Ch10Recursion.power(3, 0), 1L);
        Check.eq(Ch10Recursion.power(5, 3), 125L);
    }
}

class Ex10_6Test {
    public static void run() {
        Map<String, Object> docs = new LinkedHashMap<>();
        docs.put("old", new LinkedHashMap<String, Object>());
        docs.put("a.txt", null);
        Map<String, Object> tree = new LinkedHashMap<>();
        tree.put("docs", docs);
        tree.put("src", new LinkedHashMap<String, Object>());
        Check.eq(Ch10Recursion.allDirectories(tree, ""), List.of("/docs", "/docs/old", "/src"));
    }
}

class Ex10_7Test {
    public static void run() {
        Check.eq(Ch10Recursion.numbersBetween(3, 6), List.of(3, 4, 5, 6));
    }
}
