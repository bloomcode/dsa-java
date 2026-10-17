import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Chapter 31: Simple sorts: bubble, selection and insertion. */
public class Ch31SimpleSorts {

    // ==== EX 31.1 | Bubble sort | Core
    // PROMPT: Write `static int[] bubbleSort(int[] arr)` that sorts in place by repeatedly comparing neighbours and swapping them when out of order. Return the array.
    // EXAMPLE: `{4, 2, 7, 1, 3}` -> `[1, 2, 3, 4, 7]`
    // BIGO: O(N^2) time, O(1) space. About N^2/2 comparisons plus up to N^2/2 swaps.
    static int[] bubbleSort(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.2 | Bubble sort with early exit | Practice
    // PROMPT: Write `static int bubbleSortOptimized(int[] arr)` that sorts in place, shrinks the unsorted range each pass, stops as soon as a pass makes no swaps, and returns the number of passes.
    // EXAMPLE: `{1, 2, 3, 4}` -> `1` pass; `{4, 3, 2, 1}` -> `3` passes
    // BIGO: Worst case still O(N^2); best case (already sorted) O(N).
    // NOTE: The largest unsorted value "bubbles" to its final spot each pass, which is why the range can shrink.
    static int bubbleSortOptimized(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.3 | Count equal pairs, quadratic | Core
    // PROMPT: Write `static int equalPairsQuadratic(int[] nums)` counting the pairs of positions `i < j` with `nums[i] == nums[j]`, using two nested loops.
    // EXAMPLE: `{1, 2, 1, 1, 2}` -> `4`
    // BIGO: O(N^2) time, O(1) space.
    static int equalPairsQuadratic(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.4 | Count equal pairs, linear | Core
    // PROMPT: Write `static long equalPairsLinear(int[] nums)` with one loop and a `HashMap` counting how many times each value has appeared so far: each new value pairs with every earlier copy.
    // EXAMPLE: Same results as 31.3: `{1, 2, 1, 1, 2}` -> `4`
    // BIGO: O(N) time, O(N) space. Trading memory for speed.
    static long equalPairsLinear(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.5 | Largest pair sum, two ways | Practice
    // PROMPT: For at least two numbers, write `static int largestPairSumQuadratic(int[] nums)` (try every pair of positions) and `static int largestPairSumLinear(int[] nums)` (one pass keeping the two largest values seen).
    // EXAMPLE: `{3, 9, 1, 7}` -> `16`
    // BIGO: O(N^2) versus O(N), for the same answer.
    static int largestPairSumQuadratic(int[] nums) {
        throw new UnsupportedOperationException();
    }

    static int largestPairSumLinear(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.6 | Is it sorted? | Core
    // PROMPT: Write `static boolean isSorted(int[] arr)` that checks ascending order in one pass.
    // EXAMPLE: `{1, 2, 2, 5}` -> `true`; `{1, 3, 2}` -> `false`
    // BIGO: O(N) worst case, can stop at the first out-of-order pair.
    static boolean isSorted(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.7 | Selection sort | Core
    // PROMPT: Write `static int[] selectionSort(int[] arr)`: on each pass find the index of the smallest unsorted value and swap it into place (one swap per pass at most).
    // EXAMPLE: `{4, 2, 7, 1, 3}` -> `[1, 2, 3, 4, 7]`
    // BIGO: O(N^2) time, O(1) space. About N^2/2 comparisons but at most N - 1 swaps.
    static int[] selectionSort(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.8 | Bubble vs selection: count the work | Practice
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

    // ==== EX 31.9 | Differences between neighbours | Core
    // PROMPT: Write `static int[] neighbourGaps(int[] nums)` returning `nums[i + 1] - nums[i]` for each pair of neighbours, in order.
    // EXAMPLE: `{3, 7, 4, 10}` -> `[4, -3, 6]`
    // BIGO: N - 1 steps, which is still O(N): Big O drops constants and the minus one.
    static int[] neighbourGaps(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.10 | Second largest in one pass | Practice
    // PROMPT: Write `static Integer secondLargest(int[] arr)` returning the second-largest distinct value, or `null`, in a single pass and without sorting.
    // EXAMPLE: `{5, 1, 9, 7, 9}` -> `7`; `{3, 3}` -> `null`
    // BIGO: O(N) time, O(1) space. Sorting first would be O(N log N).
    static Integer secondLargest(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.11 | K smallest by partial selection sort | Stretch
    // PROMPT: Write `static int[] kSmallest(int[] arr, int k)` that runs only the first `k` passes of selection sort on a copy and returns the first `k` values.
    // EXAMPLE: `{8, 3, 5, 1, 9}`, k = 2 -> `[1, 3]`
    // BIGO: O(kN). Better than a full O(N^2) sort when k is small.
    static int[] kSmallest(int[] arr, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.12 | Insertion sort | Core
    // PROMPT: Write `static int[] insertionSort(int[] arr)`: for each index from 1, lift the value out ("temp"), shift larger values on its left one slot right, and drop the value into the gap.
    // EXAMPLE: `{4, 2, 7, 1, 3}` -> `[1, 2, 3, 4, 7]`
    // BIGO: Worst O(N^2), average about N^2/2, best (already sorted) O(N). O(1) space.
    static int[] insertionSort(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.13 | Best, average, worst case in numbers | Practice
    // PROMPT: Write `static long insertionSortSteps(int[] arr)` that sorts a copy and returns the count of comparisons plus shifts. Run it on a sorted, a random, and a reversed array of 100.
    // EXAMPLE: sorted 100 -> `99`; reversed 100 -> `9900`; random lands in between
    // BIGO: Shows O(N) best case and O(N^2) worst case for the same algorithm.
    // NOTE: When data is usually nearly sorted, insertion sort can beat selection sort, despite sharing O(N^2).
    static long insertionSortSteps(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.14 | Does the list hold every wanted value? | Core
    // PROMPT: Write `static boolean containsAll(int[] values, int[] wanted)` with a linear search for each wanted value that `break`s on a match, returning `false` as soon as one is missing.
    // EXAMPLE: `{4, 8, 15, 16}`, `{8, 16}` -> `true`; `{4, 8}`, `{8, 5}` -> `false`
    // BIGO: O(N * M) worst case. Stopping early only helps the best and average case: a missing first value ends the work after one scan.
    static boolean containsAll(int[] values, int[] wanted) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.15 | Insert one value into a sorted array | Core
    // PROMPT: Write `static List<Integer> insertSorted(List<Integer> arr, int value)` that performs a single insertion-sort step: append, then shift left until the value is in place.
    // EXAMPLE: `[1, 4, 9]`, value `5` -> `[1, 4, 5, 9]`
    // BIGO: O(N) worst case, O(1) if the value belongs at the end.
    static List<Integer> insertSorted(List<Integer> arr, int value) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 31.16 | Sort a nearly sorted list | Practice
    // PROMPT: Every value in `nums` is at most `k` positions away from where it belongs. Write `static int[] sortNearlySorted(int[] nums, int k)` that sorts in place with insertion sort and returns `nums`, and explain why it beats O(N^2) here.
    // EXAMPLE: `{2, 1, 3, 5, 4}, 1` -> `[1, 2, 3, 4, 5]`
    // BIGO: O(N * k): each value shifts at most k places, so for small k insertion sort is close to linear.
    static int[] sortNearlySorted(int[] nums, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
