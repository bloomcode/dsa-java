import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Chapter 21: Arrays and dynamic arrays. */
public class Ch21Arrays {

    // ==== EX 21.1 | Fixed-capacity Array skeleton | Core
    // PROMPT: Create `static class Array` with an `int[] data` of fixed `capacity`, a `length` counter and a `steps` counter. Add `size()`, `isEmpty()`, `isFull()`, `toArray()` and `resetSteps()`.
    // EXAMPLE: `Array a = new Array(5); a.size()` -> `0`; `a.isFull()` -> `false`
    // BIGO: All O(1) except `toArray()`, which is O(N).
    // NOTE: Capacity is fixed, like a real block of memory. `ArrayList` hides this by over-allocating; this class makes the cost of every shift visible.
    static class Array {
        int[] data;
        int capacity, length, steps;

        Array(int capacity) {
            throw new UnsupportedOperationException();
        }

        int size() { throw new UnsupportedOperationException(); }

        boolean isEmpty() { throw new UnsupportedOperationException(); }

        boolean isFull() { throw new UnsupportedOperationException(); }

        int[] toArray() {
            throw new UnsupportedOperationException();
        }

        void resetSteps() { throw new UnsupportedOperationException(); }
        // ==== END

        // ==== EX 21.2 | Read by index | Core | class=Array
        // PROMPT: Add `int read(int index)` that returns the element at `index` in one step. Throw `IndexOutOfBoundsException` if the index is outside `0 .. length-1`.
        // EXAMPLE: `[10, 20, 30]` -> `read(1)` returns `20`; `read(3)` throws `IndexOutOfBoundsException`
        // BIGO: O(1) time. The computer jumps straight to the memory address.
        // NOTE: Check against `length`, not `capacity`: slots past the length hold no real data.
        int read(int index) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.3 | Read the first and last element | Core | class=Array
        // PROMPT: Add `Integer first()` and `Integer last()`. Both return `null` on an empty array.
        // EXAMPLE: `[4, 8, 15]` -> `first()` is `4`, `last()` is `15`
        // BIGO: O(1) each. Knowing `length` makes the last slot one jump away.
        // NOTE: The edges matter: insertion and deletion at the end are cheap only because the end is found in one step.
        Integer first() { throw new UnsupportedOperationException(); }

        Integer last() { throw new UnsupportedOperationException(); }
        // ==== END

        // ==== EX 21.4 | Update by index | Core | class=Array
        // PROMPT: Add `void update(int index, int value)` that overwrites one slot. Same bounds rule as `read`.
        // EXAMPLE: `[1, 2, 3]` -> `update(0, 9)` -> `[9, 2, 3]`
        // BIGO: O(1) time.
        void update(int index, int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.5 | Linear search | Core | class=Array
        // PROMPT: Add `int search(int value)` that returns the index of the first match, or `-1`. Count one step per element inspected.
        // EXAMPLE: `[5, 3, 7]` -> `search(7)` is `2` after 3 steps; `search(9)` is `-1` after 3 steps
        // BIGO: O(N) worst case, O(1) best case (match in slot 0).
        int search(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.6 | Membership test | Core | class=Array
        // PROMPT: Add `boolean contains(int value)` built on `search`.
        // EXAMPLE: `[5, 3, 7]` -> `contains(3)` is `true`
        // BIGO: O(N). This is what `ArrayList.contains` costs too.
        boolean contains(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.7 | Insert at the end | Core | class=Array
        // PROMPT: Add `void insertAtEnd(int value)`. Throw `IllegalStateException` when full.
        // EXAMPLE: `[1, 2]` -> `insertAtEnd(3)` -> `[1, 2, 3]` in 1 step
        // BIGO: O(1). Nothing has to move.
        void insertAtEnd(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.8 | Insert at the start | Core | class=Array
        // PROMPT: Add `void insertAtStart(int value)`. Shift every element one slot right, starting from the end, then write the new value into slot 0.
        // EXAMPLE: `[2, 3, 4]` -> `insertAtStart(1)` -> `[1, 2, 3, 4]` in 4 steps (3 shifts + 1 write)
        // BIGO: O(N). Worst case for array insertion: N shifts + 1 write = N + 1 steps.
        // NOTE: Shift from the right end backwards. Shifting from the left would overwrite values before they move.
        void insertAtStart(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.9 | Insert at an index | Core | class=Array
        // PROMPT: Add `void insertAt(int index, int value)` for any `index` from `0` to `length` (inserting at `length` means append).
        // EXAMPLE: `[1, 2, 4]` -> `insertAt(2, 3)` -> `[1, 2, 3, 4]` in 2 steps
        // BIGO: O(N - index): N + 1 steps at the start, 1 step at the end.
        void insertAt(int index, int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.10 | Delete at the end | Core | class=Array
        // PROMPT: Add `int deleteAtEnd()` that removes and returns the last element. Throw `IllegalStateException` when empty.
        // EXAMPLE: `[1, 2, 3]` -> returns `3`, leaves `[1, 2]`, 1 step
        // BIGO: O(1).
        int deleteAtEnd() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.11 | Delete at the start | Core | class=Array
        // PROMPT: Add `int deleteAtStart()` that removes and returns element 0, then shifts every remaining element one slot left to close the gap.
        // EXAMPLE: `[1, 2, 3, 4]` -> returns `1`, leaves `[2, 3, 4]` in 4 steps (1 delete + 3 shifts)
        // BIGO: O(N). Worst case for deletion: 1 delete + (N - 1) shifts = N steps.
        int deleteAtStart() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.12 | Delete at an index | Core | class=Array
        // PROMPT: Add `int deleteAt(int index)` that removes and returns the element at `index` and closes the gap.
        // EXAMPLE: `[1, 2, 9, 3]` -> `deleteAt(2)` returns `9`, leaves `[1, 2, 3]`
        // BIGO: O(N - index).
        int deleteAt(int index) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 21.13 | Delete by value | Core | class=Array
        // PROMPT: Add `boolean deleteValue(int value)` that removes the first occurrence and returns `true`, or returns `false` if absent.
        // EXAMPLE: `[4, 5, 4]` -> `deleteValue(4)` -> `[5, 4]`, returns `true`
        // BIGO: O(N) in every case: the search and the shifts together touch every element once.
        // NOTE: If the match is near the front, search is short but shifting is long, and the reverse near the back.
        boolean deleteValue(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 21.14 | Count and locate every match | Core
    // PROMPT: Write `static int countOccurrences(int[] arr, int value)` and `static List<Integer> findAllIndices(int[] arr, int value)`, each with one loop.
    // EXAMPLE: `findAllIndices(new int[]{3, 1, 3, 3}, 3)` -> `[0, 2, 3]`; count is `3`
    // BIGO: O(N) time; O(1) space for the count, O(K) for the K indices returned.
    static int countOccurrences(int[] arr, int value) {
        throw new UnsupportedOperationException();
    }

    static List<Integer> findAllIndices(int[] arr, int value) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.15 | Minimum and maximum in one pass | Core
    // PROMPT: Write `static int[] findMinMax(int[] arr)` returning `{min, max}` in a single loop without `Math.min` over a stream. Return `null` for an empty array.
    // EXAMPLE: `{7, -2, 9, 4}` -> `[-2, 9]`
    // BIGO: O(N) time, O(1) space.
    static int[] findMinMax(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.16 | Reverse in place | Core
    // PROMPT: Write `static int[] reverseInPlace(int[] arr)` that reverses the array using two indices that walk toward each other, and returns the same array.
    // EXAMPLE: `{1, 2, 3, 4, 5}` -> `[5, 4, 3, 2, 1]`
    // BIGO: O(N) time (N/2 swaps), O(1) extra space.
    static int[] reverseInPlace(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.17 | Array-based set | Core
    // PROMPT: Extend `Array` as `static class ArraySet`. Add `boolean add(int value)` and override `insertAtEnd` so a duplicate is refused. Return `true` if added, `false` if already present.
    // EXAMPLE: `s.add(3); s.add(3)` -> second call returns `false`, size stays 1
    // BIGO: O(N): the duplicate check is a full search before every insert. Best-case insert is N + 1 steps, not 1.
    // NOTE: One rule (no duplicates) turns the cheapest operation into a linear one. That is the chapter's central lesson.
    static class ArraySet extends Array {
        ArraySet(int capacity) { super(capacity); throw new UnsupportedOperationException(); }

        boolean add(int value) {
            throw new UnsupportedOperationException();
        }

        @Override
        void insertAtEnd(int value) { throw new UnsupportedOperationException(); }
    }
    // ==== END

    // ==== EX 21.18 | Predict the steps | Practice
    // PROMPT: Write `static Map<String, Integer> stepsTable(int n)` that builds an `Array` of N elements and returns the step counts for: read, search for a missing value, insert at end, insert at start, delete at end, delete at start. Predict the numbers on paper first.
    // EXAMPLE: `stepsTable(5)` -> `{read=1, searchMissing=5, insertEnd=1, insertStart=6, deleteEnd=1, deleteStart=5}`
    // BIGO: Confirms read O(1), search O(N), insert/delete O(1) at the end and O(N) at the start.
    static Map<String, Integer> stepsTable(int n) {
        throw new UnsupportedOperationException();
    }

    private static Array fresh(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.19 | Grow when full (dynamic array) | Stretch
    // PROMPT: Extend `Array` as `static class DynamicArray` whose `insertAtEnd` doubles the capacity (copying every element to a new block) when full, instead of throwing.
    // EXAMPLE: capacity 2, append 1, 2, 3 -> capacity becomes 4, contents `[1, 2, 3]`
    // BIGO: A single append is O(N) when it triggers a copy, but O(1) amortized across many appends.
    // NOTE: This is how `ArrayList.add` stays fast: it grows by half again when full, so copies are rare.
    static class DynamicArray extends Array {
        DynamicArray(int capacity) { super(capacity); throw new UnsupportedOperationException(); }

        private void grow() {
            throw new UnsupportedOperationException();
        }

        @Override
        void insertAtEnd(int value) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 21.20 | Majority value by voting | Practice
    // PROMPT: A value fills more than half of `nums`. Write `static int majority(int[] nums)` in one pass with O(1) extra space: keep a candidate and a count; a matching value adds a vote, a different one removes a vote, and an empty count picks the next value as the candidate.
    // EXAMPLE: `{3, 1, 3, 3, 2, 3}` -> `3`
    // BIGO: O(N) time, O(1) space: each vote cancels against a different value, and the majority outlasts every cancellation.
    static int majority(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.21 | Products of everything but self | Core
    // PROMPT: Write `static long[] productsExceptSelf(int[] nums)` returning, for each index, the product of every other value, without using division (so zeros need no special case).
    // EXAMPLE: `{2, 3, 4, 5}` -> `[60, 40, 30, 24]`
    // BIGO: O(N) time: one pass left to right for the product before each index, one pass right to left for the product after it.
    static long[] productsExceptSelf(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.22 | Longest mountain run | Core
    // PROMPT: A mountain is a run that strictly rises and then strictly falls, with at least one step each way. Write `static int longestMountain(int[] nums)` returning the length of the longest mountain, or 0 if there is none. Find each tip, then walk down both sides.
    // EXAMPLE: `{1, 3, 5, 4, 2, 2, 6, 1}` -> `5`
    // BIGO: O(N): each tip is found once, and the climbs and descents around different tips never overlap by more than one value.
    static int longestMountain(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.23 | Smallest amount the coins cannot make | Practice
    // PROMPT: Each coin in `coins` (positive values, repeats allowed) can be used at most once. Write `static long smallestUnmakeable(int[] coins)` returning the smallest positive amount that no selection of coins adds up to. Sort a copy, then track the largest amount `reach` that every smaller amount can be made up to.
    // EXAMPLE: `{2, 1, 6}` -> `4`; `{1, 1, 3}` -> `6`
    // BIGO: O(N log N) for the sort, then one pass: if every amount up to `reach` can be paid and the next coin is at most reach + 1, every amount up to reach + coin can be paid.
    static long smallestUnmakeable(int[] coins) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.24 | Lowest missing positive, in place | Stretch
    // PROMPT: Write `static int lowestMissingPositive(int[] nums)` returning the smallest positive integer not in `nums`, in O(N) time with no extra array. Rearrange in place so that value `v` (when 1 <= v <= N) sits at index `v - 1`; then the first index whose value is wrong gives the answer.
    // EXAMPLE: `{4, -2, 1, 9, 2}` -> `3`; `{2, 3}` -> `1`
    // BIGO: O(N) time and O(1) extra space: each swap puts one value in its home slot for good, so there are at most N swaps.
    static int lowestMissingPositive(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.25 | Missing numbers in 1..n | Core
    // PROMPT: `nums` holds distinct values from 1 to `n`. Write `static List<Integer> missingFromRange(int[] nums, int n)` returning the values in 1..n that are absent, in increasing order, using an array of `n + 1` marks rather than sorting.
    // EXAMPLE: `{4, 1, 6}, 6` -> `[2, 3, 5]`
    // BIGO: O(N) time and O(N) space: one pass marks what is present, one pass collects what is not.
    static List<Integer> missingFromRange(int[] nums, int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 21.26 | First repeat, using the array as its own table | Practice
    // PROMPT: Every value in `nums` is between 1 and `nums.length`. Write `static int firstRepeatInPlace(int[] nums)` returning the value whose second appearance comes first, or -1, using no extra structure: when you meet `v`, flip `nums[v - 1]` negative; finding it already negative means `v` is a repeat. Restore the signs before returning.
    // EXAMPLE: `{3, 1, 4, 4, 1}` -> `4`; `{1, 2, 3}` -> `-1`
    // BIGO: O(N) time, O(1) extra space: the sign of `nums[v - 1]` records whether `v` has been seen.
    static int firstRepeatInPlace(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
