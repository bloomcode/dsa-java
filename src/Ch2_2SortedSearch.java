import java.util.ArrayList;
import java.util.List;

/** Chapter 2.2: Searching sorted data. */
public class Ch2_2SortedSearch {

    // ==== EX 2.2.1 | Ordered array insert | Core
    // PROMPT: Create `static class OrderedArray` holding an `ArrayList<Integer> items` that is always sorted. Write `void insert(int value)`: scan from the left to find the first element larger than `value`, then shift everything from there one slot right and write the value. Do not use `add(index, x)` or `sort`.
    // EXAMPLE: `[3, 17, 80, 202]` -> `insert(75)` -> `[3, 17, 75, 80, 202]`
    // BIGO: O(N). Comparisons up to the spot plus shifts after it always total about N + 2 steps.
    // NOTE: Insertion is slower than in a plain array (which appends in O(1)), the price paid for O(log N) search.
    static class OrderedArray {
        final List<Integer> items = new ArrayList<>();

        OrderedArray(int... values) {
            throw new UnsupportedOperationException();
        }

        void insert(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 2.2.6 | Insert using binary search for the position | Practice | class=OrderedArray
        // PROMPT: Add `void insertFast(int value)` to `OrderedArray` that finds the position with your `lowerBound` from 2.2.5 instead of a linear scan, then shifts.
        // EXAMPLE: Same result as `insert`, with only about log2(N) comparisons
        // BIGO: Still O(N) overall because the shifts dominate; the comparisons drop to O(log N).
        void insertFast(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 2.2.8 | Delete from an ordered array | Core | class=OrderedArray
        // PROMPT: Add `boolean delete(int value)` to `OrderedArray`: find it with binary search, shift the rest left, return `true`; return `false` if absent.
        // EXAMPLE: `[2, 4, 6, 8]` -> `delete(4)` -> `[2, 6, 8]`
        // BIGO: O(log N) to find + O(N) to shift = O(N).
        boolean delete(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 2.2.2 | Linear search with early exit | Core
    // PROMPT: Write `static int linearSearchOrdered(int[] arr, int target)` for a sorted array. Return the index, or `-1` as soon as you pass a value larger than the target.
    // EXAMPLE: `{3, 17, 75, 80, 202}`, target `22` -> `-1` after inspecting only 3 elements
    // BIGO: O(N) worst case, but it often stops early.
    static int linearSearchOrdered(int[] arr, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.3 | Binary search, iterative | Core
    // PROMPT: Write `static int binarySearch(List<Integer> arr, int target)` on a sorted list using `lower` and `upper` bounds and a midpoint. Return the index or `-1`.
    // EXAMPLE: `[3, 17, 75, 80, 202]`, target `80` -> `3`
    // BIGO: O(log N). Each step halves the range: 100 elements need at most 7 steps, 1,000,000 need 20.
    // NOTE: Write the midpoint as `lower + (upper - lower) / 2`. The textbook `(lower + upper) / 2` overflows int once the indices pass about 1.07 billion.
    static int binarySearch(List<Integer> arr, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.4 | Binary search, recursive | Practice
    // PROMPT: Write `static int binarySearchRecursive(int[] arr, int target)` with the same contract, delegating to a private recursive helper that takes `lower` and `upper`.
    // EXAMPLE: `{1, 3, 5, 7, 9}`, target `1` -> `0`
    // BIGO: O(log N) time, O(log N) call-stack space.
    static int binarySearchRecursive(int[] arr, int target) {
        throw new UnsupportedOperationException();
    }

    private static int search(int[] arr, int target, int lower, int upper) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.5 | Insertion point (lower bound) | Core
    // PROMPT: Write `static int lowerBound(List<Integer> arr, int target)`: the first index whose value is `>= target` (or `arr.size()` if none). You will reuse it in 2.6.
    // EXAMPLE: `[10, 20, 20, 30]`, target `20` -> `1`; target `25` -> `3`; target `99` -> `4`
    // BIGO: O(log N).
    // NOTE: The range is half-open `[lo, hi)`, so `hi` starts at `arr.size()`, not `arr.size() - 1`.
    static int lowerBound(List<Integer> arr, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.7 | First and last occurrence | Practice
    // PROMPT: Write `static int[] firstAndLast(List<Integer> arr, int target)` returning `{firstIndex, lastIndex}` in a sorted list with duplicates, or `{-1, -1}`. Use two binary searches.
    // EXAMPLE: `[1, 2, 2, 2, 5]`, target `2` -> `[1, 3]`
    // BIGO: O(log N). A linear scan outward from one match would degrade to O(N) when everything matches.
    static int[] firstAndLast(List<Integer> arr, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.9 | Count the steps: linear vs binary | Practice
    // PROMPT: Write `static int[] searchSteps(int n)` that searches the array `0 .. n-1` for a missing value (`n`) both ways and returns `{linearSteps, binarySteps}`.
    // EXAMPLE: `searchSteps(100)` -> `[100, 7]`; `searchSteps(10_000)` -> `[10000, 14]`
    // BIGO: Linear grows 1:1 with N; binary grows by one step each time N doubles.
    static int[] searchSteps(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.10 | Integer square root by binary search | Stretch
    // PROMPT: Write `static long intSqrt(long n)` returning the largest `r` with `r * r <= n`, without `Math.sqrt`. Binary-search the answer between 0 and n.
    // EXAMPLE: `intSqrt(27)` -> `5`; `intSqrt(36)` -> `6`; `intSqrt(Long.MAX_VALUE)` -> `3037000499`
    // BIGO: O(log N). Binary search works on any sorted range of candidate answers, not only on arrays.
    // NOTE: Test `mid <= n / mid` rather than `mid * mid <= n`: for large n the square overflows long and turns negative.
    static long intSqrt(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.11 | Search a rotated sorted array | Practice
    // PROMPT: `nums` held distinct values in ascending order and was then rotated (`{15, 18, 22, 3, 7, 9}`). Write `static int searchRotated(int[] nums, int target)` that returns the index of `target` or `-1`, in O(log N): at each step decide which half is sorted, then whether `target` lies inside it.
    // EXAMPLE: `[15, 18, 22, 3, 7, 9], 7` -> `4`; `[15, 18, 22, 3, 7, 9], 10` -> `-1`
    // BIGO: O(log N) time, O(1) space: at every midpoint one half is in order, and a range check on that half decides which way to go.
    static int searchRotated(int[] nums, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.12 | Find a peak | Core
    // PROMPT: `nums` is non-empty and no two neighbours are equal. Write `static int findPeak(int[] nums)` that returns the index of a value larger than both neighbours (past the ends counts as smaller), in O(log N): compare `nums[mid]` with `nums[mid + 1]` and keep the rising side. Any peak is accepted.
    // EXAMPLE: `[1, 3, 2, 5, 4]` -> `3` (`1` would also be accepted)
    // BIGO: O(log N) time, O(1) space: if the next value is larger, a peak must lie to the right, because the values cannot rise forever.
    static int findPeak(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.13 | Binary search on the answer | Practice
    // PROMPT: Write `static int smallestMaxLoad(int[] loads, int k)` that splits the positive `loads`, in order, into at most `k` contiguous groups so the largest group sum is as small as possible, and returns that sum. Binary search the answer between the largest load and the total; to test a limit, fill groups greedily and count them.
    // EXAMPLE: `[4, 9, 3, 6, 2, 8], 3` -> `13` (`[4, 9] [3, 6, 2] [8]`)
    // BIGO: O(N log S) time for loads summing to S, O(1) space: whether a limit works is monotonic, so binary search finds the smallest one, and each check is a greedy pass.
    static int smallestMaxLoad(int[] loads, int k) {
        throw new UnsupportedOperationException();
    }

    static int groupsNeeded(int[] loads, int limit) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.14 | Index equal to value | Core
    // PROMPT: `nums` holds distinct integers in ascending order. Write `static int fixedPoint(int[] nums)` that returns the smallest index `i` with `nums[i] == i`, or `-1`, in O(log N).
    // EXAMPLE: `[-4, -1, 2, 5, 9]` -> `2`; `[1, 2, 3]` -> `-1`
    // BIGO: O(log N) time, O(1) space: with distinct sorted integers, `nums[i] - i` never decreases, so the matches form one block that binary search can find.
    static int fixedPoint(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.15 | Median of two sorted arrays | Stretch
    // PROMPT: `a` and `b` are sorted and not both empty. Write `static double medianOfTwo(int[] a, int[] b)` that returns the median of all their values, in O(log min(M, N)) without merging: binary search how many values of the shorter array go in the lower half, and check the four values around the two cuts.
    // EXAMPLE: `[1, 4, 9], [2, 3]` -> `3.0`; `[1, 4], [2, 3]` -> `2.5`
    // BIGO: O(log min(M, N)) time, O(1) space: binary search the cut in the shorter array; the cut in the other follows, and four border values say which way to move.
    static double medianOfTwo(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 2.2.16 | Weighted random pick | Practice
    // PROMPT: Build `static class WeightedPicker` for positive integer weights with `WeightedPicker(int[] weights)`, `int total()` and `int pick(int r)`: for `r` in `[0, total())`, `pick` returns the index whose range of prefix sums holds `r`, found by binary search. Then `pick(random.nextInt(picker.total()))` returns index `i` with probability `weights[i] / total`.
    // EXAMPLE: `new WeightedPicker(new int[] {3, 1, 2})`: `pick(0)` -> `0`; `pick(3)` -> `1`; `pick(5)` -> `2`
    // BIGO: O(N) to build, O(log N) per pick, O(N) space: the prefix sums split `[0, total)` into one range per index, and binary search finds the range holding `r`.
    static class WeightedPicker {
        private final int[] prefix;

        WeightedPicker(int[] weights) {
            throw new UnsupportedOperationException();
        }

        int total() { throw new UnsupportedOperationException(); }

        int pick(int r) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END
}
