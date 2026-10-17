import java.util.HashSet;
import java.util.Set;

/** Chapter 4: Bubble sort and quadratic code. */
public class Ch04BubbleSort {

    // ==== EX 4.1 | Bubble sort | Core
    // PROMPT: Write `static int[] bubbleSort(int[] arr)` that sorts in place by repeatedly comparing neighbours and swapping them when out of order. Return the array.
    // EXAMPLE: `{4, 2, 7, 1, 3}` -> `[1, 2, 3, 4, 7]`
    // BIGO: O(N^2) time, O(1) space. About N^2/2 comparisons plus up to N^2/2 swaps.
    static int[] bubbleSort(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.2 | Bubble sort with early exit | Practice
    // PROMPT: Write `static int bubbleSortOptimized(int[] arr)` that sorts in place, shrinks the unsorted range each pass, stops as soon as a pass makes no swaps, and returns the number of passes.
    // EXAMPLE: `{1, 2, 3, 4}` -> `1` pass; `{4, 3, 2, 1}` -> `3` passes
    // BIGO: Worst case still O(N^2); best case (already sorted) O(N).
    // NOTE: The largest unsorted value "bubbles" to its final spot each pass, which is why the range can shrink.
    static int bubbleSortOptimized(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.3 | Duplicate check, quadratic | Core
    // PROMPT: Write `static boolean hasDuplicateQuadratic(int[] arr)` with two nested loops comparing every pair.
    // EXAMPLE: `{1, 5, 3, 9, 1, 4}` -> `true`; `{1, 2, 3}` -> `false`
    // BIGO: O(N^2) time, O(1) space.
    static boolean hasDuplicateQuadratic(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.4 | Duplicate check, linear | Core
    // PROMPT: Write `static boolean hasDuplicateLinear(int[] arr)` using one loop and a `HashSet` of values already seen.
    // EXAMPLE: Same results as 4.3
    // BIGO: O(N) time, O(N) space. Trading memory for speed.
    // NOTE: `Set.add` returns `false` when the value was already present, so one call both checks and records.
    static boolean hasDuplicateLinear(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.5 | Greatest number, two ways | Practice
    // PROMPT: Write `static Integer greatestQuadratic(int[] arr)` (a value is greatest if no other value beats it, checked with nested loops) and `static Integer greatestLinear(int[] arr)` (one pass tracking the best so far). Return `null` for an empty array.
    // EXAMPLE: `{3, 9, 2, 7}` -> `9`
    // BIGO: O(N^2) versus O(N), for the same answer.
    static Integer greatestQuadratic(int[] arr) {
        throw new UnsupportedOperationException();
    }

    static Integer greatestLinear(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 4.6 | Is it sorted? | Core
    // PROMPT: Write `static boolean isSorted(int[] arr)` that checks ascending order in one pass.
    // EXAMPLE: `{1, 2, 2, 5}` -> `true`; `{1, 3, 2}` -> `false`
    // BIGO: O(N) worst case, can stop at the first out-of-order pair.
    static boolean isSorted(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
