import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/** Chapter 24: Stacks and queues. */
public class Ch24StacksQueues {

    // ==== EX 24.1 | Stack | Core
    // PROMPT: Build `static class Stack<T>` on an `ArrayList<T>`, exposing only `push`, `pop`, `read` (peek), `isEmpty` and `size`. `pop` and `read` return `null` when empty.
    // EXAMPLE: push 1, 2, 3 -> `read()` is `3`, `pop()` is `3`, `read()` is `2`
    // BIGO: O(1) for every operation. The end of an ArrayList is the cheap end.
    // NOTE: A stack is an abstract data type: the constraint (last in, first out) matters, not the list underneath.
    static class Stack<T> {
        private final List<T> data = new ArrayList<>();

        void push(T value) { throw new UnsupportedOperationException(); }

        T pop() { throw new UnsupportedOperationException(); }

        T read() { throw new UnsupportedOperationException(); }

        boolean isEmpty() { throw new UnsupportedOperationException(); }

        int size() { throw new UnsupportedOperationException(); }
    }
    // ==== END

    // ==== EX 24.2 | Queue | Core
    // PROMPT: Build `static class Queue<T>` with `enqueue`, `dequeue`, `read` (front), `isEmpty` and `size` on an `ArrayDeque<T>`, then explain why `ArrayList.remove(0)` would be a poor choice.
    // EXAMPLE: enqueue 1, 2, 3 -> `dequeue()` is `1`, `read()` is `2`
    // BIGO: O(1) each with a deque. `remove(0)` on an ArrayList is O(N) because every element shifts left (see 21.11).
    static class Queue<T> {
        private final Deque<T> data = new ArrayDeque<>();

        void enqueue(T value) { throw new UnsupportedOperationException(); }

        T dequeue() { throw new UnsupportedOperationException(); }

        T read() { throw new UnsupportedOperationException(); }

        boolean isEmpty() { throw new UnsupportedOperationException(); }

        int size() { throw new UnsupportedOperationException(); }
    }
    // ==== END

    // ==== EX 24.3 | Do the tags nest? | Core
    // PROMPT: Write `static boolean tagsBalanced(String markup)` using your `Stack`. Tags are `<name>` and `</name>` with letters only and no attributes; text between tags is ignored. Return `true` when every tag closes, in the reverse order it opened.
    // EXAMPLE: `"<p><b>hi</b></p>"` -> `true`; `"<p><b></p></b>"` -> `false`
    // BIGO: O(N) time, O(N) space for the stack.
    static boolean tagsBalanced(String markup) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.4 | Simplify a file path | Core
    // PROMPT: Write `static String simplifyPath(String path)` for an absolute path: drop empty parts and `.`, let `..` remove the folder before it (if any), and return the canonical path. Use your `Stack` for the folders.
    // EXAMPLE: `"/a/./b/../c/"` -> `"/a/c"`; `"/../"` -> `"/"`
    // BIGO: O(N) time and space.
    static String simplifyPath(String path) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.5 | Round-robin turns | Core
    // PROMPT: Write `static List<String> roundRobin(String[] names, int[] times, int slice)` using your `Queue`: job `names[i]` needs `times[i]` units of work. The front job runs for up to `slice` units; if it still has work left it goes to the back. Return the names in the order the jobs finish.
    // EXAMPLE: `{"a", "b", "c"}, {3, 1, 2}, 1` -> `[b, c, a]`
    // BIGO: O(T / s + N) queue operations for total work T, slice s and N jobs; each one is O(1).
    static List<String> roundRobin(String[] names, int[] times, int slice) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.6 | Queue built from two stacks | Practice
    // PROMPT: Build `static class StackQueue<T>` with `enqueue` and `dequeue` using only two `Stack` objects.
    // EXAMPLE: enqueue 1, 2; dequeue -> `1`; enqueue 3; dequeue -> `2`, dequeue -> `3`
    // BIGO: O(1) amortized: each element is moved from the inbox to the outbox at most once.
    static class StackQueue<T> {
        private final Stack<T> inbox = new Stack<>(), outbox = new Stack<>();

        void enqueue(T value) { throw new UnsupportedOperationException(); }

        T dequeue() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 24.7 | Evaluate postfix (RPN) | Practice
    // PROMPT: Write `static double evalRpn(String[] tokens)` for `+ - * /` using a `Stack<Double>`.
    // EXAMPLE: `{"3", "4", "+", "2", "*"}` -> `14.0`
    // BIGO: O(N).
    // NOTE: Pop the right operand first: for `"8 2 -"` the stack gives back 2, then 8.
    static double evalRpn(String[] tokens) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.8 | Undo and redo | Practice
    // PROMPT: Build `static class Editor` with `type(String chars)`, `undo()`, `redo()` and a `text` field. Use one stack of past states and one of undone states; new typing clears redo.
    // EXAMPLE: type "a", type "b", undo -> `"a"`; redo -> `"ab"`
    // BIGO: O(1) per operation (plus the cost of building the new string).
    static class Editor {
        String text = "";
        private final Stack<String> undoStack = new Stack<>();
        private Stack<String> redoStack = new Stack<>();

        void type(String chars) {
            throw new UnsupportedOperationException();
        }

        String undo() {
            throw new UnsupportedOperationException();
        }

        String redo() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 24.9 | Fixed-size circular queue | Stretch
    // PROMPT: Build `static class CircularQueue` on a fixed `int[]` with `head` and `size`, so neither `enqueue` nor `dequeue` shifts anything. `enqueue` returns `false` when full; `dequeue` returns `null` when empty.
    // EXAMPLE: capacity 3: enqueue 1, 2, 3 -> 4th returns `false`; dequeue -> `1`; enqueue 4 succeeds and wraps to slot 0
    // BIGO: O(1) for both, with no shifting, because the index wraps with `% capacity`.
    static class CircularQueue {
        final int[] data;
        int head, size;

        CircularQueue(int capacity) { throw new UnsupportedOperationException(); }

        boolean enqueue(int value) {
            throw new UnsupportedOperationException();
        }

        Integer dequeue() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 24.10 | Min-max stack | Core
    // PROMPT: Build `static class MinMaxStack` with `void push(int value)`, `int pop()`, `int peek()`, `int min()` and `int max()`, every one O(1). Store each value together with the minimum and maximum of the stack at the moment it was pushed. Callers never pop or read an empty stack.
    // EXAMPLE: push 5, 2, 8 -> `min()` is `2`, `max()` is `8`; `pop()` -> `8`; `max()` is `5`
    // BIGO: O(1) per operation, O(N) space: each entry stores the minimum and maximum of itself and everything below it, so popping restores the old ones for free.
    static class MinMaxStack {
        private final Deque<int[]> entries = new ArrayDeque<>();

        void push(int value) {
            throw new UnsupportedOperationException();
        }

        int pop() { throw new UnsupportedOperationException(); }

        int peek() { throw new UnsupportedOperationException(); }

        int min() { throw new UnsupportedOperationException(); }

        int max() { throw new UnsupportedOperationException(); }
    }
    // ==== END

    // ==== EX 24.11 | Next greater value | Core
    // PROMPT: Write `static int[] nextGreater(int[] nums)` that returns, for each index, the first value to its right that is larger, or `-1`. Keep a stack of indices still waiting (an `ArrayDeque<Integer>`); each new value settles every waiting index with a smaller value.
    // EXAMPLE: `[2, 7, 3, 5, 4, 6, 8]` -> `[7, 8, 5, 6, 6, 8, -1]`
    // BIGO: O(N) time and space: each index is pushed and popped at most once, and the stack always holds indices still waiting for a larger value.
    static int[] nextGreater(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.12 | Sunset view | Core
    // PROMPT: `heights` lists buildings from west to east, and the sun sets in the east. Write `static List<Integer> sunsetView(int[] heights)` that returns, in ascending order, the indices of the buildings strictly taller than every building east of them. Scan west to east with a stack, popping every building that is not taller than the new one.
    // EXAMPLE: `[3, 5, 4, 4, 3, 1, 3, 2]` -> `[1, 3, 6, 7]`
    // BIGO: O(N) time and space: a building that is not taller than a later one can never see past it, so it leaves the stack for good.
    static List<Integer> sunsetView(int[] heights) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.13 | Largest rectangle under a bar chart | Stretch
    // PROMPT: `heights` are the bars of a chart, each 1 wide. Write `static int largestRectangle(int[] heights)` that returns the largest rectangle area that fits under the bars. Keep a stack of `{start, height}` with rising heights; a lower bar pops every taller entry, scoring `height * (i - start)`, and inherits the start of the last one popped. A final zero-height bar empties the stack.
    // EXAMPLE: `[2, 4, 3, 5, 1, 3]` -> `9` (height 3 across the bars `4, 3, 5`)
    // BIGO: O(N) time and space: a bar is popped exactly when the first lower bar to its right appears, and the entry below it says how far left it reaches.
    static int largestRectangle(int[] heights) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.14 | Sort a stack with one more stack | Practice
    // PROMPT: Write `static Deque<Integer> sortStack(Deque<Integer> stack)` that empties `stack` (used with `push`, `pop` and `peek`) into a new stack whose largest value is on top and returns it, using only those three operations on the two stacks: pop a value, move every larger value from the new stack back onto the old one, then push it.
    // EXAMPLE: push 3, 1, 4, 2 -> popping the result gives `4, 3, 2, 1`
    // BIGO: O(N^2) time, O(N) space for the second stack: each value may have to move every larger value aside before it settles.
    static Deque<Integer> sortStack(Deque<Integer> stack) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.15 | Collisions on a track | Practice
    // PROMPT: `carts` lists carts on a track from left to right: the size is the absolute value, and the sign is the direction (positive moves right). When two meet, the smaller one is destroyed; equal sizes destroy each other. Write `static List<Integer> afterCollisions(int[] carts)` that returns the carts left, in order. A stack of survivors works: only a left-mover arriving at a right-mover on top collides.
    // EXAMPLE: `[-3, 4, 9, -6, 2, -2, 7]` -> `[-3, 4, 9, 7]`
    // BIGO: O(N) time and space: every cart is pushed once and destroyed at most once.
    static List<Integer> afterCollisions(int[] carts) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.16 | Window maximum with a deque | Practice
    // PROMPT: Write `static int[] windowMax(int[] nums, int k)` that returns the maximum of every window of `k` consecutive values (`1 <= k <= nums.length`), in O(N). Keep an `ArrayDeque<Integer>` of indices whose values fall from front to back: drop smaller values from the back before adding, and drop the front once it leaves the window.
    // EXAMPLE: `[4, 2, 12, 3, 8, 1, 7], 3` -> `[12, 12, 12, 8, 8]`
    // BIGO: O(N) time, O(K) space: the deque keeps indices of falling values, so its front is the window's maximum, and each index enters and leaves once.
    static int[] windowMax(int[] nums, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.17 | Longest balanced bracket run | Practice
    // PROMPT: `s` holds only `(` and `)`. Write `static int longestBalanced(String s)` that returns the length of the longest substring of correctly matched brackets. Keep a stack of indices starting with `-1`: push each `(`; on `)` pop, then either measure from the new top or, if the stack is empty, push this index as the new boundary.
    // EXAMPLE: `"(()())())("` -> `8`
    // BIGO: O(N) time and space: the stack holds open-bracket indices above the index of the last unmatched close, which marks where a balanced run can start.
    static int longestBalanced(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.18 | Stack from a queue | Core
    // PROMPT: Build `static class QueueStack` with `void push(int value)`, `int pop()`, `int peek()` and `boolean isEmpty()` on one `ArrayDeque<Integer>` used only as a queue (`offer`, `poll`, `peek`, `size`). After offering, rotate the older values from the front to the back so the newest is in front. Callers never pop or peek an empty stack.
    // EXAMPLE: push 1, 2, 3; `pop()` -> `3`; `peek()` -> `2`
    // BIGO: O(N) push, O(1) pop and peek: after each push the queue is rotated so the newest value is at the front.
    static class QueueStack {
        private final ArrayDeque<Integer> queue = new ArrayDeque<>();

        void push(int value) {
            throw new UnsupportedOperationException();
        }

        int pop() { throw new UnsupportedOperationException(); }

        int peek() { throw new UnsupportedOperationException(); }

        boolean isEmpty() { throw new UnsupportedOperationException(); }
    }
    // ==== END

    // ==== EX 24.19 | Reverse the first k of a queue | Core
    // PROMPT: Write `static Deque<Integer> reverseFirstK(Deque<Integer> queue, int k)` that reverses the first `k` values in place (`0 <= k <= size`) and returns `queue`, using only queue operations (`offer`, `poll`) on it and a second `ArrayDeque` as a stack (`push`, `pop`): move `k` values onto the stack, offer them back, then rotate the remaining `size - k` values from the front to the back.
    // EXAMPLE: `[1, 2, 3, 4, 5], 3` -> `[3, 2, 1, 4, 5]`
    // BIGO: O(N) time, O(K) space for the stack: k values go through the stack, then the other N - k rotate to the back once.
    static Deque<Integer> reverseFirstK(Deque<Integer> queue, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 24.20 | Binary numbers 1 to n with a queue | Core
    // PROMPT: Write `static List<String> binaryNumbers(int n)` that returns the binary forms of `1` to `n` as strings, in order, without converting numbers: start an `ArrayDeque<String>` with `"1"`, and each time you take a string from the front, record it and add it with `"0"` and `"1"` appended to the back.
    // EXAMPLE: `5` -> `["1", "10", "11", "100", "101"]`
    // BIGO: O(N log N) time and space: N strings of about log N digits each, every one produced by appending a digit to an earlier one.
    static List<String> binaryNumbers(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
