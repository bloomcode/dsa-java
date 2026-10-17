import java.util.List;

/** Chapter 2 tests, one class per exercise. */
final class Ch02OrderedArraysTest {
    private Ch02OrderedArraysTest() {}

    /** An OrderedArray holding `sorted`, filled directly so a test does not depend on insert. */
    static Ch02OrderedArrays.OrderedArray ordered(Integer... sorted) {
        Ch02OrderedArrays.OrderedArray o = new Ch02OrderedArrays.OrderedArray();
        o.items.addAll(List.of(sorted));
        return o;
    }

    static void checkBinarySearch(java.util.function.BiFunction<int[], Integer, Integer> fn) {
        Check.eq(fn.apply(new int[]{3, 17, 75, 80, 202}, 80), 3);
        Check.eq(fn.apply(new int[]{1, 3, 5, 7, 9}, 1), 0);
        Check.eq(fn.apply(new int[]{1, 3, 5, 7, 9}, 9), 4);
        Check.eq(fn.apply(new int[]{1, 3, 5}, 4), -1);
        Check.eq(fn.apply(new int[]{}, 1), -1);
    }
}

class Ex2_1Test {
    public static void run() {
        Ch02OrderedArrays.OrderedArray o = Ch02OrderedArraysTest.ordered(3, 17, 80, 202);
        o.insert(75);
        Check.eq(o.items, List.of(3, 17, 75, 80, 202));
        o.insert(1);
        o.insert(500);
        Check.eq(o.items, List.of(1, 3, 17, 75, 80, 202, 500));
        Check.eq(new Ch02OrderedArrays.OrderedArray(8, 4, 6, 2).items, List.of(2, 4, 6, 8));
    }
}

class Ex2_2Test {
    public static void run() {
        Check.eq(Ch02OrderedArrays.linearSearchOrdered(new int[]{3, 17, 75, 80, 202}, 22), -1);
        Check.eq(Ch02OrderedArrays.linearSearchOrdered(new int[]{3, 17, 75, 80, 202}, 75), 2);
        Check.eq(Ch02OrderedArrays.linearSearchOrdered(new int[]{}, 1), -1);
    }
}

class Ex2_3Test {
    public static void run() {
        Ch02OrderedArraysTest.checkBinarySearch((arr, t) ->
                Ch02OrderedArrays.binarySearch(java.util.Arrays.stream(arr).boxed().toList(), t));
    }
}

class Ex2_4Test {
    public static void run() {
        Ch02OrderedArraysTest.checkBinarySearch(Ch02OrderedArrays::binarySearchRecursive);
    }
}

class Ex2_5Test {
    public static void run() {
        List<Integer> lb = List.of(10, 20, 20, 30);
        Check.eq(Ch02OrderedArrays.lowerBound(lb, 20), 1);
        Check.eq(Ch02OrderedArrays.lowerBound(lb, 25), 3);
        Check.eq(Ch02OrderedArrays.lowerBound(lb, 99), 4);
        Check.eq(Ch02OrderedArrays.lowerBound(lb, 5), 0);
        Check.eq(Ch02OrderedArrays.lowerBound(List.of(), 5), 0);
    }
}

class Ex2_6Test {
    public static void run() {
        Ch02OrderedArrays.OrderedArray o = Ch02OrderedArraysTest.ordered(3, 17, 80, 202);
        o.insertFast(75);
        o.insertFast(1);
        o.insertFast(500);
        Check.eq(o.items, List.of(1, 3, 17, 75, 80, 202, 500));
        Ch02OrderedArrays.OrderedArray f = Ch02OrderedArraysTest.ordered();
        for (int v : new int[]{5, 1, 4, 1, 9}) f.insertFast(v);
        Check.eq(f.items, List.of(1, 1, 4, 5, 9));
    }
}

class Ex2_7Test {
    public static void run() {
        Check.eq(Ch02OrderedArrays.firstAndLast(List.of(1, 2, 2, 2, 5), 2), new int[]{1, 3});
        Check.eq(Ch02OrderedArrays.firstAndLast(List.of(1, 2, 2, 2, 5), 3), new int[]{-1, -1});
        Check.eq(Ch02OrderedArrays.firstAndLast(List.of(7, 7, 7), 7), new int[]{0, 2});
    }
}

class Ex2_8Test {
    public static void run() {
        Ch02OrderedArrays.OrderedArray o = Ch02OrderedArraysTest.ordered(2, 4, 6, 8);
        Check.yes(o.delete(4));
        Check.eq(o.items, List.of(2, 6, 8));
        Check.no(o.delete(5));
        Check.yes(o.delete(8));
        Check.eq(o.items, List.of(2, 6));
    }
}

class Ex2_9Test {
    public static void run() {
        Check.eq(Ch02OrderedArrays.searchSteps(100), new int[]{100, 7});
        Check.eq(Ch02OrderedArrays.searchSteps(10_000), new int[]{10000, 14});
    }
}

class Ex2_10Test {
    public static void run() {
        Check.eq(Ch02OrderedArrays.intSqrt(27), 5L);
        Check.eq(Ch02OrderedArrays.intSqrt(36), 6L);
        Check.eq(Ch02OrderedArrays.intSqrt(0), 0L);
        Check.eq(Ch02OrderedArrays.intSqrt(1), 1L);
        Check.eq(Ch02OrderedArrays.intSqrt(Long.MAX_VALUE), 3037000499L);
    }
}
