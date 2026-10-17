import java.util.Arrays;

/** Chapter 5: Selection sort and constant factors. */
public class Ch05SelectionSort {

    // ==== EX 5.1 | Selection sort | Core
    // PROMPT: Write `static int[] selectionSort(int[] arr)`: on each pass find the index of the smallest unsorted value and swap it into place (one swap per pass at most).
    // EXAMPLE: `{4, 2, 7, 1, 3}` -> `[1, 2, 3, 4, 7]`
    // BIGO: O(N^2) time, O(1) space. About N^2/2 comparisons but at most N - 1 swaps.
    static int[] selectionSort(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.2 | Bubble vs selection: count the work | Practice
    // PROMPT: Write `static long[] bubbleCounts(int[] arr)` and `static long[] selectionCounts(int[] arr)`, each sorting a copy and returning `{comparisons, swaps}`. Compare them on a reversed array of 10.
    // EXAMPLE: reversed 10 elements -> bubble `[45, 45]`, selection `[45, 5]`
    // BIGO: Both O(N^2). Selection does roughly half the total steps; Big O ignores that constant, which is why both share a category.
    static long[] bubbleCounts(int[] arr) {
        throw new UnsupportedOperationException();
    }

    static long[] selectionCounts(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.3 | Every other element | Core
    // PROMPT: Write `static int[] everyOther(int[] arr)` returning elements at indices 0, 2, 4 and so on, using a loop that steps by 2.
    // EXAMPLE: `{10, 11, 12, 13, 14}` -> `[10, 12, 14]`
    // BIGO: N/2 steps, which is still O(N): constants are dropped.
    static int[] everyOther(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.4 | Second largest in one pass | Practice
    // PROMPT: Write `static Integer secondLargest(int[] arr)` returning the second-largest distinct value, or `null`, in a single pass and without sorting.
    // EXAMPLE: `{5, 1, 9, 7, 9}` -> `7`; `{3, 3}` -> `null`
    // BIGO: O(N) time, O(1) space. Sorting first would be O(N log N).
    static Integer secondLargest(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.5 | K smallest by partial selection sort | Stretch
    // PROMPT: Write `static int[] kSmallest(int[] arr, int k)` that runs only the first `k` passes of selection sort on a copy and returns the first `k` values.
    // EXAMPLE: `{8, 3, 5, 1, 9}`, k = 2 -> `[1, 3]`
    // BIGO: O(kN). Better than a full O(N^2) sort when k is small.
    static int[] kSmallest(int[] arr, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
