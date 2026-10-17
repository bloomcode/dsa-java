import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

/** Chapter 21: Mergesort and stable sorting. */
public class Ch21Mergesort {

    // ==== EX 21.1 | Merge two sorted arrays | Core
    // PROMPT: Write `static int[] merge(int[] a, int[] b)` returning one sorted array from two sorted arrays, using two indices that advance through them. No `Arrays.sort`.
    // EXAMPLE: `merge(new int[]{1, 4, 9}, new int[]{2, 3, 10, 11})` -> `[1, 2, 3, 4, 9, 10, 11]`
    // BIGO: O(N + M) time, O(N + M) space.
    // NOTE: Use `<=` when comparing so equal items from `a` come first. That one character is what makes mergesort stable (21.7).
    static int[] merge(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.2 | Count the comparisons in a merge | Core
    // PROMPT: Write `static int mergeComparisons(int[] a, int[] b)` returning how many comparisons a merge makes. Find inputs that need the fewest and the most comparisons.
    // EXAMPLE: `mergeComparisons({1, 2, 3}, {4, 5, 6})` -> `3`; `mergeComparisons({1, 3, 5}, {2, 4, 6})` -> `5`
    // BIGO: Between min(N, M) and N + M - 1 comparisons.
    static int mergeComparisons(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.3 | Mergesort, top-down | Core
    // PROMPT: Write `static int[] mergesort(int[] arr)` returning a new sorted array: split in half with `Arrays.copyOfRange`, sort each half recursively, then `merge` them. Base case: length 0 or 1.
    // EXAMPLE: `mergesort(new int[]{38, 27, 43, 3, 9, 82, 10})` -> `[3, 9, 10, 27, 38, 43, 82]`
    // BIGO: O(N log N) in every case: log2 N levels of splitting, O(N) merging per level. O(N) extra space.
    static int[] mergesort(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.4 | Mergesort with one shared buffer | Practice
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

    // ==== EX 21.5 | Mergesort, bottom-up | Core
    // PROMPT: Write `static int[] mergesortBottomUp(int[] arr)` with no recursion: merge runs of width 1 into width 2, then 4, 8, and so on, until one run covers the array. Swap two buffers between passes.
    // EXAMPLE: `mergesortBottomUp(new int[]{5, 1, 4, 2, 8, 0, 2})` -> `[0, 1, 2, 2, 4, 5, 8]`
    // BIGO: O(N log N) time, O(N) space, and no call stack at all.
    static int[] mergesortBottomUp(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.6 | Count inversions while merging | Practice
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

    // ==== EX 21.7 | Stability, with records | Core
    // PROMPT: Write `static <T> List<T> mergesortBy(List<T> records, ToIntFunction<T> key)` that sorts by `key` and keeps records with equal keys in their original order. Show that quicksort from Chapter 13 does not promise this.
    // EXAMPLE: records `(ann, 3), (bo, 1), (cy, 3), (di, 1)` by the number -> `[(bo, 1), (di, 1), (ann, 3), (cy, 3)]`
    // BIGO: O(N log N).
    // NOTE: Java's own `List.sort` and `Arrays.sort(Object[])` are stable mergesorts (TimSort); `Arrays.sort(int[])` is a quicksort, where stability is meaningless anyway.
    static <T> List<T> mergesortBy(List<T> records, ToIntFunction<T> key) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.8 | Hybrid: insertion sort for small pieces | Stretch
    // PROMPT: Write `static int[] hybridSort(int[] arr, int cutoff)`: mergesort that switches to insertion sort when a piece has `cutoff` items or fewer. Benchmark it against plain mergesort in Chapter 22.
    // EXAMPLE: `hybridSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, 4)` -> `[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]`
    // BIGO: Still O(N log N); insertion sort wins on tiny inputs because its constant factor is small. The JDK's own sorts use the same trick.
    static int[] hybridSort(int[] arr, int cutoff) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
