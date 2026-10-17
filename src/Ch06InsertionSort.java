import java.util.ArrayList;
import java.util.List;

/** Chapter 6: Insertion sort in the best and worst case. */
public class Ch06InsertionSort {

    // ==== EX 6.1 | Insertion sort | Core
    // PROMPT: Write `static int[] insertionSort(int[] arr)`: for each index from 1, lift the value out ("temp"), shift larger values on its left one slot right, and drop the value into the gap.
    // EXAMPLE: `{4, 2, 7, 1, 3}` -> `[1, 2, 3, 4, 7]`
    // BIGO: Worst O(N^2), average about N^2/2, best (already sorted) O(N). O(1) space.
    static int[] insertionSort(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.2 | Best, average, worst case in numbers | Practice
    // PROMPT: Write `static long insertionSortSteps(int[] arr)` that sorts a copy and returns the count of comparisons plus shifts. Run it on a sorted, a random, and a reversed array of 100.
    // EXAMPLE: sorted 100 -> `99`; reversed 100 -> `9900`; random lands in between
    // BIGO: Shows O(N) best case and O(N^2) worst case for the same algorithm.
    // NOTE: When data is usually nearly sorted, insertion sort can beat selection sort, despite sharing O(N^2).
    static long insertionSortSteps(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.3 | Intersection of two arrays with early break | Core
    // PROMPT: Write `static List<Integer> intersectionNested(int[] a, int[] b)` returning values in both arrays, using nested loops that `break` once a match is found.
    // EXAMPLE: `{3, 1, 4, 2}`, `{4, 5, 3, 6}` -> `[3, 4]`
    // BIGO: O(N * M) worst case. The `break` only improves the average case.
    static List<Integer> intersectionNested(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.4 | Insert one value into a sorted array | Core
    // PROMPT: Write `static List<Integer> insertSorted(List<Integer> arr, int value)` that performs a single insertion-sort step: append, then shift left until the value is in place.
    // EXAMPLE: `[1, 4, 9]`, value `5` -> `[1, 4, 5, 9]`
    // BIGO: O(N) worst case, O(1) if the value belongs at the end.
    static List<Integer> insertSorted(List<Integer> arr, int value) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 6.5 | Merge two sorted arrays | Practice
    // PROMPT: Write `static int[] mergeSorted(int[] a, int[] b)` returning one sorted array using two pointers. No `Arrays.sort`.
    // EXAMPLE: `{1, 4, 7}`, `{2, 3, 9}` -> `[1, 2, 3, 4, 7, 9]`
    // BIGO: O(N + M) time, O(N + M) space.
    static int[] mergeSorted(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
