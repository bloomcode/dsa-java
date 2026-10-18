import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/** Chapter 5.2: Heaps and priority queues. */
public class Ch5_2Heaps {

    // ==== EX 5.2.1 | Array-backed max-heap skeleton | Core
    // PROMPT: Create `static class MaxHeap` storing nodes in an `ArrayList<Integer> data`. Add `root()`, `last()`, `size()`, and static helpers `leftChild(i)`, `rightChild(i)`, `parent(i)`.
    // EXAMPLE: `leftChild(0)` -> `1`, `rightChild(0)` -> `2`, `parent(4)` -> `1`
    // BIGO: All O(1). Storing the heap in an array solves "find the last node" for free: it is the last element.
    // NOTE: For index i: left child 2i + 1, right child 2i + 2, parent (i - 1) / 2.
    static class MaxHeap {
        final List<Integer> data = new ArrayList<>();

        int size() { throw new UnsupportedOperationException(); }

        Integer root() { throw new UnsupportedOperationException(); }

        Integer last() { throw new UnsupportedOperationException(); }

        static int leftChild(int i) { throw new UnsupportedOperationException(); }

        static int rightChild(int i) { throw new UnsupportedOperationException(); }

        static int parent(int i) { throw new UnsupportedOperationException(); }
        // ==== END

        // ==== EX 5.2.2 | Insert and trickle up | Core | class=MaxHeap
        // PROMPT: Add `void insert(int value)`: append it as the new last node, then swap it with its parent while it is larger than the parent.
        // EXAMPLE: insert 3, 9, 5, 12 -> `root()` is `12`
        // BIGO: O(log N): at most one swap per level of the tree.
        void insert(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.2.3 | Delete the root and trickle down | Core | class=MaxHeap
        // PROMPT: Add `Integer delete()` returning the root: move the last node into the root, then swap it with its larger child while a child is larger.
        // EXAMPLE: After inserting 3, 9, 5, 12 -> `delete()` returns 12, 9, 5, 3 in that order
        // BIGO: O(log N).
        // NOTE: Always swap with the larger child; swapping with the smaller one would put a smaller value above a larger one.
        Integer delete() {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 5.2.4 | Heap sort with your heap | Practice
    // PROMPT: Write `static int[] heapSort(int[] values)`: insert everything into a `MaxHeap`, then delete repeatedly, filling the result from the back.
    // EXAMPLE: `{5, 1, 9, 3, 7}` -> `[1, 3, 5, 7, 9]`
    // BIGO: O(N log N) time, O(N) space as written.
    static int[] heapSort(int[] values) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.2.5 | Jobs by deadline | Core
    // PROMPT: Build `static class DeadlineQueue` with `add(String job, int deadline)` and `nextJob()`, serving the earliest deadline first and, on a tie, whichever job was added first; `nextJob()` returns `null` when empty. Use a `PriorityQueue` of records with a comparator on deadline, then arrival number.
    // EXAMPLE: add (report, 5), (backup, 2), (email, 2) -> next is backup, then email, then report
    // BIGO: O(log N) per add and per next. A sorted list would be O(N) to add.
    // NOTE: `PriorityQueue` is not stable: without the arrival number, two jobs with the same deadline could come out in either order.
    static class DeadlineQueue {
        private record Job(String name, int deadline, long arrival) {}

        private final PriorityQueue<Job> heap = new PriorityQueue<>((a, b) ->
                a.deadline() != b.deadline() ? Integer.compare(a.deadline(), b.deadline()) : Long.compare(a.arrival(), b.arrival()));
        private long counter;

        void add(String job, int deadline) {
            throw new UnsupportedOperationException();
        }

        String nextJob() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 5.2.6 | Top K largest | Practice
    // PROMPT: Write `static List<Integer> topK(int[] nums, int k)` keeping a min-heap (`PriorityQueue<Integer>`) of size k: offer each number, poll when the heap grows past k. Return the k largest, largest first.
    // EXAMPLE: `{3, 1, 9, 7, 5, 8}`, k = 3 -> `[9, 8, 7]`
    // BIGO: O(N log K) time, O(K) space. Better than sorting when K is much smaller than N.
    static List<Integer> topK(int[] nums, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.2.7 | Is this array a max-heap? | Core
    // PROMPT: Write `static boolean isMaxHeap(int[] arr)` checking that every parent is at least as large as its children, using the index formulas.
    // EXAMPLE: `{100, 88, 25, 87, 16}` -> `true`; `{10, 20}` -> `false`
    // BIGO: O(N).
    static boolean isMaxHeap(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.2.8 | Merge K sorted lists | Stretch
    // PROMPT: Write `static List<Integer> mergeKSorted(int[][] lists)` using a `PriorityQueue<int[]>` holding one `{value, listIndex, elementIndex}` entry per list.
    // EXAMPLE: `{{1, 4, 7}, {2, 5}, {0, 9}}` -> `[0, 1, 2, 4, 5, 7, 9]`
    // BIGO: O(N log K) for N total values across K lists.
    static List<Integer> mergeKSorted(int[][] lists) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.2.9 | Running median | Practice
    // PROMPT: Build `static class RunningMedian` with `void add(int x)` and `double median()` (at least one value has been added). Keep the lower half in a max-heap and the upper half in a min-heap (two `PriorityQueue<Integer>`), rebalancing so the lower half has the same size or one more.
    // EXAMPLE: add 5 -> `5.0`; add 15 -> `10.0`; add 1 -> `5.0`; add 3 -> `4.0`
    // BIGO: O(log N) per `add`, O(1) per `median`, O(N) space: a max-heap holds the lower half and a min-heap the upper half, and their tops straddle the median.
    static class RunningMedian {
        private final PriorityQueue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder()), high = new PriorityQueue<>();

        void add(int x) {
            throw new UnsupportedOperationException();
        }

        double median() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 5.2.10 | Sort a nearly sorted array with a heap | Practice
    // PROMPT: Every value in `nums` is at most `k` positions from where it belongs in sorted order. Write `static int[] sortNearlySorted(int[] nums, int k)` that returns a new sorted array in O(N log K): keep a `PriorityQueue` of the next `k + 1` values and repeatedly move its smallest to the output.
    // EXAMPLE: `[3, 1, 2, 6, 4, 5, 9, 7, 8], 2` -> `[1, 2, 3, 4, 5, 6, 7, 8, 9]`
    // BIGO: O(N log K) time, O(K) space: the smallest remaining value is always among the next K + 1, so a heap of that size can hand it out.
    // NOTE: Compare 3.1.16, which handles the same input with insertion sort in O(N * K).
    static int[] sortNearlySorted(int[] nums, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
