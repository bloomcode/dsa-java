import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

/** Chapter 3.2: Divide and conquer: mergesort, quicksort and quickselect. */
public class Ch3_2DivideConquer {

    // ==== EX 3.2.1 | Partition | Core
    // PROMPT: Write `static int partition(int[] arr, int left, int right)` using the rightmost element as pivot: a left pointer moves right past values smaller than the pivot, a right pointer moves left past values larger, swap, repeat; finally swap the pivot into the left pointer's spot. Return the pivot's final index.
    // EXAMPLE: `{0, 5, 2, 1, 6, 3}` -> pivot 3 ends at index 3, values left of it are all < 3, right of it all > 3
    // BIGO: O(N) for one partition.
    static int partition(int[] arr, int left, int right) {
        throw new UnsupportedOperationException();
    }

    static void swap(int[] arr, int i, int j) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.2 | Quicksort | Core
    // PROMPT: Write `static int[] quicksort(int[] arr, int left, int right)`: partition, then recurse on the sub-arrays left and right of the pivot. Base case: fewer than two elements. Add `quicksort(int[] arr)` that sorts the whole array.
    // EXAMPLE: `{0, 5, 2, 1, 6, 3}` -> `[0, 1, 2, 3, 5, 6]`
    // BIGO: O(N log N) average, O(N^2) worst case (pivot is always the smallest or largest, e.g. sorted input with a rightmost pivot).
    // NOTE: On sorted input of 100,000 elements the O(N) recursion depth can overflow the default stack. Picking a random pivot (swap it to the right end first) makes that practically impossible.
    static int[] quicksort(int[] arr, int left, int right) {
        throw new UnsupportedOperationException();
    }

    static int[] quicksort(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.3 | Quickselect | Core
    // PROMPT: Write `static int quickselect(int[] arr, int k)` returning the k-th smallest value (k = 0 is the minimum) without fully sorting: partition a copy, then continue into only the side that holds index k.
    // EXAMPLE: `{0, 50, 20, 10, 60, 30}`, k = 1 -> `10`
    // BIGO: O(N) average (N + N/2 + N/4 ... = 2N), O(N^2) worst case.
    static int quickselect(int[] arr, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.4 | Closest pair after sorting | Core
    // PROMPT: Write `static int closestGapSorted(int[] nums)` for at least two numbers: sort a copy with your quicksort, then compare only neighbours.
    // EXAMPLE: `{10, 4, 15, 7}` -> `3`
    // BIGO: O(N log N). Once sorted, the closest pair is always adjacent, so N - 1 comparisons replace 1.1.14's every pair.
    static int closestGapSorted(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.5 | Do any meetings overlap? | Practice
    // PROMPT: Write `static boolean anyOverlap(int[][] meetings)` for `{start, end}` pairs (a meeting may start exactly when another ends). Sort by start (`Arrays.sort` with a comparator is fine), then check each meeting against the one before it.
    // EXAMPLE: `{{9, 11}, {13, 15}, {10, 12}}` -> `true`; `{{9, 10}, {10, 11}}` -> `false`
    // BIGO: O(N log N) for the sort, then one O(N) pass.
    static boolean anyOverlap(int[][] meetings) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.6 | Count distinct values by sorting | Core
    // PROMPT: Write `static int countDistinctSorted(int[] nums)`: sort a copy with your quicksort, then count the positions whose value differs from the one before.
    // EXAMPLE: `{5, 9, 3, 5, 9, 9}` -> `3`
    // BIGO: O(N log N) time, with no hash table: after sorting, equal values sit side by side.
    static int countDistinctSorted(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.7 | Median with quickselect | Practice
    // PROMPT: Write `static double median(int[] nums)` using `quickselect`. For an even count, average the two middle values.
    // EXAMPLE: `{7, 1, 3}` -> `3.0`; `{4, 1, 3, 2}` -> `2.5`
    // BIGO: O(N) average.
    static double median(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.8 | Three-way partition for repeated values | Stretch
    // PROMPT: Write `static int[] quicksort3(int[] arr)` that sorts in place and returns `arr`, partitioning each range into values less than, equal to and greater than the pivot (the first value of the range), then recursing only on the outer two parts.
    // EXAMPLE: `{3, 1, 3, 2, 3, 1}` -> `[1, 1, 2, 3, 3, 3]`
    // BIGO: O(N log N) expected. With only D distinct values it drops to about O(N * D), because the block equal to the pivot is never touched again.
    static int[] quicksort3(int[] arr) {
        throw new UnsupportedOperationException();
    }

    static void quicksort3(int[] arr, int lo, int hi) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.9 | Merge two sorted arrays | Core
    // PROMPT: Write `static int[] merge(int[] a, int[] b)` returning one sorted array from two sorted arrays, using two indices that advance through them. No `Arrays.sort`.
    // EXAMPLE: `merge(new int[]{1, 4, 9}, new int[]{2, 3, 10, 11})` -> `[1, 2, 3, 4, 9, 10, 11]`
    // BIGO: O(N + M) time, O(N + M) space.
    // NOTE: Use `<=` when comparing so equal items from `a` come first. That one character is what makes mergesort stable (3.2.15).
    static int[] merge(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.10 | Count the comparisons in a merge | Core
    // PROMPT: Write `static int mergeComparisons(int[] a, int[] b)` returning how many comparisons a merge makes. Find inputs that need the fewest and the most comparisons.
    // EXAMPLE: `mergeComparisons({1, 2, 3}, {4, 5, 6})` -> `3`; `mergeComparisons({1, 3, 5}, {2, 4, 6})` -> `5`
    // BIGO: Between min(N, M) and N + M - 1 comparisons.
    static int mergeComparisons(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.11 | Mergesort, top-down | Core
    // PROMPT: Write `static int[] mergesort(int[] arr)` returning a new sorted array: split in half with `Arrays.copyOfRange`, sort each half recursively, then `merge` them. Base case: length 0 or 1.
    // EXAMPLE: `mergesort(new int[]{38, 27, 43, 3, 9, 82, 10})` -> `[3, 9, 10, 27, 38, 43, 82]`
    // BIGO: O(N log N) in every case: log2 N levels of splitting, O(N) merging per level. O(N) extra space.
    static int[] mergesort(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.12 | Mergesort with one shared buffer | Practice
    // PROMPT: Write `static int[] mergesortInPlace(int[] arr)` that sorts `arr` itself, recursing on index ranges and merging into one auxiliary array allocated once, instead of copying at every level.
    // EXAMPLE: `a = {5, 2, 4, 6, 1, 3}; mergesortInPlace(a)` -> `a` is `[1, 2, 3, 4, 5, 6]`
    // BIGO: O(N log N) time, O(N) extra space total instead of fresh copies per call.
    static int[] mergesortInPlace(int[] arr) {
        throw new UnsupportedOperationException();
    }

    /** Sorts arr[lo, hi). */
    private static void sort(int[] arr, int[] buf, int lo, int hi) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.13 | Mergesort, bottom-up | Core
    // PROMPT: Write `static int[] mergesortBottomUp(int[] arr)` with no recursion: merge runs of width 1 into width 2, then 4, 8, and so on, until one run covers the array. Swap two buffers between passes.
    // EXAMPLE: `mergesortBottomUp(new int[]{5, 1, 4, 2, 8, 0, 2})` -> `[0, 1, 2, 2, 4, 5, 8]`
    // BIGO: O(N log N) time, O(N) space, and no call stack at all.
    static int[] mergesortBottomUp(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.14 | Count inversions while merging | Practice
    // PROMPT: An inversion is a pair i < j with arr[i] > arr[j]. Write `static long countInversions(int[] arr)` by adding, every time an item from the right half is taken first, the number of items still waiting in the left half.
    // EXAMPLE: `countInversions(new int[]{2, 4, 1, 3, 5})` -> `3`; a reversed array of 5 -> `10`
    // BIGO: O(N log N), versus O(N^2) for checking every pair. Return `long`: 200,000 reversed items have about 2 * 10^10 inversions.
    static long countInversions(int[] arr) {
        throw new UnsupportedOperationException();
    }

    private static long inversions(int[] a, int[] buf, int lo, int hi) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.15 | Stability, with records | Core
    // PROMPT: Write `static <T> List<T> mergesortBy(List<T> records, ToIntFunction<T> key)` that sorts by `key` and keeps records with equal keys in their original order. Show that quicksort from Chapter 3.2 does not promise this.
    // EXAMPLE: records `(ann, 3), (bo, 1), (cy, 3), (di, 1)` by the number -> `[(bo, 1), (di, 1), (ann, 3), (cy, 3)]`
    // BIGO: O(N log N).
    // NOTE: Java's own `List.sort` and `Arrays.sort(Object[])` are stable mergesorts (TimSort); `Arrays.sort(int[])` is a quicksort, where stability is meaningless anyway.
    static <T> List<T> mergesortBy(List<T> records, ToIntFunction<T> key) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 3.2.16 | Hybrid: insertion sort for small pieces | Stretch
    // PROMPT: Write `static int[] hybridSort(int[] arr, int cutoff)`: mergesort that switches to insertion sort when a piece has `cutoff` items or fewer. Benchmark it against plain mergesort in Chapter 1.3.
    // EXAMPLE: `hybridSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, 4)` -> `[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]`
    // BIGO: Still O(N log N); insertion sort wins on tiny inputs because its constant factor is small. The JDK's own sorts use the same trick.
    static int[] hybridSort(int[] arr, int cutoff) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
