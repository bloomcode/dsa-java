import java.util.Arrays;
import java.util.List;

/** Chapter 22 tests, one class per exercise. */

final class Ch22SortedSearchTest {
    private Ch22SortedSearchTest() {}

    /** An OrderedArray holding `sorted`, filled directly so a test does not depend on insert. */
    static Ch22SortedSearch.OrderedArray ordered(Integer... sorted) {
        Ch22SortedSearch.OrderedArray o = new Ch22SortedSearch.OrderedArray();
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

class Ex22_1Test {
    public static void run() {
        Ch22SortedSearch.OrderedArray o = Ch22SortedSearchTest.ordered(3, 17, 80, 202);
        o.insert(75);
        Check.eq(o.items, List.of(3, 17, 75, 80, 202));
        o.insert(1);
        o.insert(500);
        Check.eq(o.items, List.of(1, 3, 17, 75, 80, 202, 500));
        Check.eq(new Ch22SortedSearch.OrderedArray(8, 4, 6, 2).items, List.of(2, 4, 6, 8));
    }
}

class Ex22_2Test {
    public static void run() {
        Check.eq(Ch22SortedSearch.linearSearchOrdered(new int[]{3, 17, 75, 80, 202}, 22), -1);
        Check.eq(Ch22SortedSearch.linearSearchOrdered(new int[]{3, 17, 75, 80, 202}, 75), 2);
        Check.eq(Ch22SortedSearch.linearSearchOrdered(new int[]{}, 1), -1);
    }
}

class Ex22_3Test {
    public static void run() {
        Ch22SortedSearchTest.checkBinarySearch((arr, t) ->
                Ch22SortedSearch.binarySearch(java.util.Arrays.stream(arr).boxed().toList(), t));
    }
}

class Ex22_4Test {
    public static void run() {
        Ch22SortedSearchTest.checkBinarySearch(Ch22SortedSearch::binarySearchRecursive);
    }
}

class Ex22_5Test {
    public static void run() {
        List<Integer> lb = List.of(10, 20, 20, 30);
        Check.eq(Ch22SortedSearch.lowerBound(lb, 20), 1);
        Check.eq(Ch22SortedSearch.lowerBound(lb, 25), 3);
        Check.eq(Ch22SortedSearch.lowerBound(lb, 99), 4);
        Check.eq(Ch22SortedSearch.lowerBound(lb, 5), 0);
        Check.eq(Ch22SortedSearch.lowerBound(List.of(), 5), 0);
    }
}

class Ex22_6Test {
    public static void run() {
        Ch22SortedSearch.OrderedArray o = Ch22SortedSearchTest.ordered(3, 17, 80, 202);
        o.insertFast(75);
        o.insertFast(1);
        o.insertFast(500);
        Check.eq(o.items, List.of(1, 3, 17, 75, 80, 202, 500));
        Ch22SortedSearch.OrderedArray f = Ch22SortedSearchTest.ordered();
        for (int v : new int[]{5, 1, 4, 1, 9}) f.insertFast(v);
        Check.eq(f.items, List.of(1, 1, 4, 5, 9));
    }
}

class Ex22_7Test {
    public static void run() {
        Check.eq(Ch22SortedSearch.firstAndLast(List.of(1, 2, 2, 2, 5), 2), new int[]{1, 3});
        Check.eq(Ch22SortedSearch.firstAndLast(List.of(1, 2, 2, 2, 5), 3), new int[]{-1, -1});
        Check.eq(Ch22SortedSearch.firstAndLast(List.of(7, 7, 7), 7), new int[]{0, 2});
    }
}

class Ex22_8Test {
    public static void run() {
        Ch22SortedSearch.OrderedArray o = Ch22SortedSearchTest.ordered(2, 4, 6, 8);
        Check.yes(o.delete(4));
        Check.eq(o.items, List.of(2, 6, 8));
        Check.no(o.delete(5));
        Check.yes(o.delete(8));
        Check.eq(o.items, List.of(2, 6));
    }
}

class Ex22_9Test {
    public static void run() {
        Check.eq(Ch22SortedSearch.searchSteps(100), new int[]{100, 7});
        Check.eq(Ch22SortedSearch.searchSteps(10_000), new int[]{10000, 14});
    }
}

class Ex22_10Test {
    public static void run() {
        Check.eq(Ch22SortedSearch.intSqrt(27), 5L);
        Check.eq(Ch22SortedSearch.intSqrt(36), 6L);
        Check.eq(Ch22SortedSearch.intSqrt(0), 0L);
        Check.eq(Ch22SortedSearch.intSqrt(1), 1L);
        Check.eq(Ch22SortedSearch.intSqrt(Long.MAX_VALUE), 3037000499L);
    }
}

class Ex22_11Test {
    public static void run() {
        int[] nums = {15, 18, 22, 3, 7, 9};
        for (int i = 0; i < nums.length; i++) Check.eq(Ch22SortedSearch.searchRotated(nums, nums[i]), i);
        Check.eq(Ch22SortedSearch.searchRotated(nums, 10), -1);
        Check.eq(Ch22SortedSearch.searchRotated(nums, 1), -1);
        Check.eq(Ch22SortedSearch.searchRotated(new int[0], 4), -1);
        Check.eq(Ch22SortedSearch.searchRotated(new int[] {5}, 5), 0);
        Check.eq(Ch22SortedSearch.searchRotated(new int[] {1, 2, 3}, 3), 2);
        Check.eq(Ch22SortedSearch.searchRotated(new int[] {3, 1}, 1), 1);
    }
}

class Ex22_12Test {
    public static void run() {
        Check.eq(Ch22SortedSearch.findPeak(new int[] {1, 3, 2, 5, 4}), 3);
        int[][] cases = {{7}, {1, 2, 3, 4}, {4, 3, 2, 1}, {2, 9, 1, 8, 0, 7, 6}, {5, 1}};
        for (int[] nums : cases) {
            int i = Ch22SortedSearch.findPeak(nums);
            Check.yes((i == 0 || nums[i - 1] < nums[i]) && (i == nums.length - 1 || nums[i + 1] < nums[i]));
        }
    }
}

class Ex22_13Test {
    public static void run() {
        int[] loads = {4, 9, 3, 6, 2, 8};
        Check.eq(Ch22SortedSearch.smallestMaxLoad(loads, 3), 13);
        Check.eq(Ch22SortedSearch.smallestMaxLoad(loads, 1), 32);
        Check.eq(Ch22SortedSearch.smallestMaxLoad(loads, 6), 9);
        Check.eq(Ch22SortedSearch.smallestMaxLoad(new int[] {5, 5, 5, 5}, 2), 10);
        Check.eq(Ch22SortedSearch.smallestMaxLoad(new int[] {7}, 3), 7);
    }
}

class Ex22_14Test {
    public static void run() {
        Check.eq(Ch22SortedSearch.fixedPoint(new int[] {-4, -1, 2, 5, 9}), 2);
        Check.eq(Ch22SortedSearch.fixedPoint(new int[] {1, 2, 3}), -1);
        Check.eq(Ch22SortedSearch.fixedPoint(new int[] {0, 1, 2}), 0);
        Check.eq(Ch22SortedSearch.fixedPoint(new int[] {-3, -1, 1, 3, 4}), 3);
        Check.eq(Ch22SortedSearch.fixedPoint(new int[0]), -1);
        Check.eq(Ch22SortedSearch.fixedPoint(new int[] {-5, 0, 7}), -1);
    }
}

class Ex22_15Test {
    public static void run() {
        Check.eq(Ch22SortedSearch.medianOfTwo(new int[] {1, 4, 9}, new int[] {2, 3}), 3.0);
        Check.eq(Ch22SortedSearch.medianOfTwo(new int[] {1, 4}, new int[] {2, 3}), 2.5);
        Check.eq(Ch22SortedSearch.medianOfTwo(new int[0], new int[] {5}), 5.0);
        Check.eq(Ch22SortedSearch.medianOfTwo(new int[] {1, 2}, new int[] {3, 4, 5, 6}), 3.5);
        Check.eq(Ch22SortedSearch.medianOfTwo(new int[] {7}, new int[] {1, 2, 3}), 2.5);
        Check.eq(Ch22SortedSearch.medianOfTwo(new int[] {10, 20, 30}, new int[0]), 20.0);
        Check.eq(Ch22SortedSearch.medianOfTwo(new int[] {1, 1}, new int[] {1, 1}), 1.0);
    }
}

class Ex22_16Test {
    public static void run() {
        Ch22SortedSearch.WeightedPicker picker = new Ch22SortedSearch.WeightedPicker(new int[] {3, 1, 2});
        Check.eq(picker.total(), 6);
        int[] picks = new int[6];
        for (int r = 0; r < 6; r++) picks[r] = picker.pick(r);
        Check.eq(picks, new int[] {0, 0, 0, 1, 2, 2});
        int[] weights = {5, 1, 4, 2};
        picker = new Ch22SortedSearch.WeightedPicker(weights);
        int[] counts = new int[weights.length];
        for (int r = 0; r < picker.total(); r++) counts[picker.pick(r)]++;
        Check.eq(counts, weights);
        Check.eq(new Ch22SortedSearch.WeightedPicker(new int[] {9}).pick(8), 0);
    }
}
