import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/** Chapter 16: Heaps and priority queues. */
public class Ch16Heaps {

    // ==== EX 16.1 | Array-backed max-heap skeleton | Core
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

        // ==== EX 16.2 | Insert and trickle up | Core | class=MaxHeap
        // PROMPT: Add `void insert(int value)`: append it as the new last node, then swap it with its parent while it is larger than the parent.
        // EXAMPLE: insert 3, 9, 5, 12 -> `root()` is `12`
        // BIGO: O(log N): at most one swap per level of the tree.
        void insert(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 16.3 | Delete the root and trickle down | Core | class=MaxHeap
        // PROMPT: Add `Integer delete()` returning the root: move the last node into the root, then swap it with its larger child while a child is larger.
        // EXAMPLE: After inserting 3, 9, 5, 12 -> `delete()` returns 12, 9, 5, 3 in that order
        // BIGO: O(log N).
        // NOTE: Always swap with the larger child; swapping with the smaller one would put a smaller value above a larger one.
        Integer delete() {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 16.4 | Heap sort with your heap | Practice
    // PROMPT: Write `static int[] heapSort(int[] values)`: insert everything into a `MaxHeap`, then delete repeatedly, filling the result from the back.
    // EXAMPLE: `{5, 1, 9, 3, 7}` -> `[1, 3, 5, 7, 9]`
    // BIGO: O(N log N) time, O(N) space as written.
    static int[] heapSort(int[] values) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 16.5 | Emergency-room priority queue | Core
    // PROMPT: Build `static class TriageQueue` with `admit(String name, int severity)` and `nextPatient()`, serving the highest severity first and, on a tie, whoever arrived first. Use a `PriorityQueue` of records with a comparator on severity (descending), then arrival number.
    // EXAMPLE: admit (Ann, 3), (Bo, 9), (Cy, 9) -> next is Bo, then Cy, then Ann
    // BIGO: O(log N) per admit and per nextPatient. An ordered array would be O(N) to admit.
    // NOTE: `PriorityQueue` is not stable: without the arrival number, two patients with equal severity could come out in either order.
    static class TriageQueue {
        private record Patient(String name, int severity, long arrival) {}

        private final PriorityQueue<Patient> heap = new PriorityQueue<>((a, b) ->
                a.severity() != b.severity() ? Integer.compare(b.severity(), a.severity()) : Long.compare(a.arrival(), b.arrival()));
        private long counter;

        void admit(String name, int severity) {
            throw new UnsupportedOperationException();
        }

        String nextPatient() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 16.6 | Top K largest | Practice
    // PROMPT: Write `static List<Integer> topK(int[] nums, int k)` keeping a min-heap (`PriorityQueue<Integer>`) of size k: offer each number, poll when the heap grows past k. Return the k largest, largest first.
    // EXAMPLE: `{3, 1, 9, 7, 5, 8}`, k = 3 -> `[9, 8, 7]`
    // BIGO: O(N log K) time, O(K) space. Better than sorting when K is much smaller than N.
    static List<Integer> topK(int[] nums, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 16.7 | Is this array a max-heap? | Core
    // PROMPT: Write `static boolean isMaxHeap(int[] arr)` checking that every parent is at least as large as its children, using the index formulas.
    // EXAMPLE: `{100, 88, 25, 87, 16}` -> `true`; `{10, 20}` -> `false`
    // BIGO: O(N).
    static boolean isMaxHeap(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 16.8 | Merge K sorted lists | Stretch
    // PROMPT: Write `static List<Integer> mergeKSorted(int[][] lists)` using a `PriorityQueue<int[]>` holding one `{value, listIndex, elementIndex}` entry per list.
    // EXAMPLE: `{{1, 4, 7}, {2, 5}, {0, 9}}` -> `[0, 1, 2, 4, 5, 7, 9]`
    // BIGO: O(N log K) for N total values across K lists.
    static List<Integer> mergeKSorted(int[][] lists) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
