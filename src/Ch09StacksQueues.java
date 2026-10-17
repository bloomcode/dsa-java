import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** Chapter 9: Stacks, queues and their constraints. */
public class Ch09StacksQueues {

    // ==== EX 9.1 | Stack | Core
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

    // ==== EX 9.2 | Queue | Core
    // PROMPT: Build `static class Queue<T>` with `enqueue`, `dequeue`, `read` (front), `isEmpty` and `size` on an `ArrayDeque<T>`, then explain why `ArrayList.remove(0)` would be a poor choice.
    // EXAMPLE: enqueue 1, 2, 3 -> `dequeue()` is `1`, `read()` is `2`
    // BIGO: O(1) each with a deque. `remove(0)` on an ArrayList is O(N) because every element shifts left (see 1.11).
    static class Queue<T> {
        private final Deque<T> data = new ArrayDeque<>();

        void enqueue(T value) { throw new UnsupportedOperationException(); }

        T dequeue() { throw new UnsupportedOperationException(); }

        T read() { throw new UnsupportedOperationException(); }

        boolean isEmpty() { throw new UnsupportedOperationException(); }

        int size() { throw new UnsupportedOperationException(); }
    }
    // ==== END

    // ==== EX 9.3 | Bracket linter | Core
    // PROMPT: Write `static String lint(String code)` using your `Stack`. Return `null` if `()`, `[]`, `{}` are balanced, else a message naming the problem character.
    // EXAMPLE: `"(var x = {y: [1, 2, 3]})"` -> `null`; `"(var x = 2;"` -> `"( has no closing brace"`; `"var x = 2)"` -> `") has no opening brace"`
    // BIGO: O(N) time, O(N) space for the stack.
    static String lint(String code) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 9.4 | Reverse a string with a stack | Core
    // PROMPT: Write `static String reverseWithStack(String s)` pushing every character and popping them back out into a `StringBuilder`.
    // EXAMPLE: `"abcde"` -> `"edcba"`
    // BIGO: O(N) time and space.
    static String reverseWithStack(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 9.5 | Print manager | Core
    // PROMPT: Build `static class PrintManager` with `queueJob(String document)` and `run()`, which prints jobs first-come-first-served and returns them in print order.
    // EXAMPLE: queue `"First"`, `"Second"`, `"Third"` -> `run()` returns `[First, Second, Third]`
    // BIGO: O(1) per job queued or printed.
    static class PrintManager {
        private final Queue<String> queue = new Queue<>();

        void queueJob(String document) { throw new UnsupportedOperationException(); }

        List<String> run() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 9.6 | Queue built from two stacks | Practice
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

    // ==== EX 9.7 | Evaluate postfix (RPN) | Practice
    // PROMPT: Write `static double evalRpn(String[] tokens)` for `+ - * /` using a `Stack<Double>`.
    // EXAMPLE: `{"3", "4", "+", "2", "*"}` -> `14.0`
    // BIGO: O(N).
    // NOTE: Pop the right operand first: for `"8 2 -"` the stack gives back 2, then 8.
    static double evalRpn(String[] tokens) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 9.8 | Undo and redo | Practice
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

    // ==== EX 9.9 | Fixed-size circular queue | Stretch
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
}
