import java.util.ArrayList;
import java.util.List;

/** Chapter 14: Linked lists, singly and doubly. */
public class Ch14LinkedLists {

    // ==== EX 14.1 | Node and LinkedList skeleton | Core
    // PROMPT: Create `static class Node` with `int data` and `Node next`, and `static class LinkedList` with `head`. Add `size()` and `toList()` that walk the chain, plus a static `of(int... values)` factory for tests.
    // EXAMPLE: `LinkedList.of(1, 2, 3).toList()` -> `[1, 2, 3]`
    // BIGO: `size()` and `toList()` are O(N): there is no length stored, so every node must be visited.
    // NOTE: Nodes can live anywhere in memory; each one only knows where the next one is. That is what makes reading slow and insertion at the head fast.
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            throw new UnsupportedOperationException();
        }
    }

    static class LinkedList {
        Node head;

        static LinkedList of(int... values) {
            throw new UnsupportedOperationException();
        }

        int size() {
            throw new UnsupportedOperationException();
        }

        List<Integer> toList() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.2 | Read by index | Core | class=LinkedList
        // PROMPT: Add `Integer read(int index)`: follow `next` links `index` times. Return `null` if the list is too short.
        // EXAMPLE: `[10, 20, 30]` -> `read(2)` is `30`; `read(5)` is `null`
        // BIGO: O(N). An array reads in O(1); this is the linked list's biggest cost.
        Integer read(int index) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.3 | Search for a value | Core | class=LinkedList
        // PROMPT: Add `int indexOf(int value)` returning the position of the first match, or `-1`.
        // EXAMPLE: `[10, 20, 30]` -> `indexOf(20)` is `1`
        // BIGO: O(N), the same as linear search in an array.
        int indexOf(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.4 | Insert at the start | Core | class=LinkedList
        // PROMPT: Add `void insertAtStart(int value)`: the new node points at the old head and becomes the head.
        // EXAMPLE: `[2, 3]` -> `insertAtStart(1)` -> `[1, 2, 3]`
        // BIGO: O(1). The array's worst case is the linked list's best case.
        void insertAtStart(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.5 | Insert at the end | Core | class=LinkedList
        // PROMPT: Add `void insertAtEnd(int value)`: walk to the last node and attach the new one. Handle the empty list.
        // EXAMPLE: `[1, 2]` -> `insertAtEnd(3)` -> `[1, 2, 3]`
        // BIGO: O(N) without a tail pointer (see 14.15 for O(1)).
        void insertAtEnd(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.6 | Insert at an index | Core | class=LinkedList
        // PROMPT: Add `void insertAt(int index, int value)`: walk to the node just before `index`, then rewire two links. Throw `IndexOutOfBoundsException` if `index` is past the end.
        // EXAMPLE: `[1, 2, 4]` -> `insertAt(2, 3)` -> `[1, 2, 3, 4]`
        // BIGO: O(N) to find the spot, then O(1) to insert. No shifting, unlike an array.
        // NOTE: Set the new node's `next` before changing `prev.next`, or the rest of the list is lost.
        void insertAt(int index, int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.7 | Delete at the start | Core | class=LinkedList
        // PROMPT: Add `Integer deleteAtStart()` returning the removed value (or `null` if empty): move `head` to `head.next`.
        // EXAMPLE: `[1, 2, 3]` -> returns `1`, leaves `[2, 3]`
        // BIGO: O(1). Arrays need O(N) here.
        Integer deleteAtStart() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.8 | Delete at the end | Core | class=LinkedList
        // PROMPT: Add `Integer deleteAtEnd()` returning the removed value: find the second-to-last node and cut its link. Handle 0 and 1 nodes.
        // EXAMPLE: `[1, 2, 3]` -> returns `3`, leaves `[1, 2]`
        // BIGO: O(N) in a singly linked list, because you need the node before the last one.
        Integer deleteAtEnd() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.9 | Delete at an index | Core | class=LinkedList
        // PROMPT: Add `int deleteAt(int index)` returning the removed value: point the previous node's `next` past the doomed node. Throw `IndexOutOfBoundsException` if out of range.
        // EXAMPLE: `[1, 2, 9, 3]` -> `deleteAt(2)` returns `9`, leaves `[1, 2, 3]`
        // BIGO: O(N) to reach it, O(1) to unlink.
        int deleteAt(int index) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.10 | Delete by value | Core | class=LinkedList
        // PROMPT: Add `boolean deleteValue(int value)` that removes the first matching node and returns `true`, or `false`.
        // EXAMPLE: `[4, 5, 4]` -> `deleteValue(4)` -> `[5, 4]`
        // BIGO: O(N).
        boolean deleteValue(int value) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.11 | Last value and middle value | Practice | class=LinkedList
        // PROMPT: Add `Integer last()` and `Integer middle()`. For `middle`, move a slow pointer one step and a fast pointer two steps; when fast reaches the end, slow is in the middle (second middle for an even count).
        // EXAMPLE: `[1, 2, 3, 4, 5]` -> `last()` is `5`, `middle()` is `3`; `[1, 2, 3, 4]` -> `middle()` is `3`
        // BIGO: O(N) each, one pass, O(1) space.
        Integer last() {
            throw new UnsupportedOperationException();
        }

        Integer middle() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.12 | Reverse in place | Core | class=LinkedList
        // PROMPT: Add `void reverse()` that flips every `next` link using `previous`, `current` and `following` variables.
        // EXAMPLE: `[1, 2, 3]` -> `[3, 2, 1]`
        // BIGO: O(N) time, O(1) space.
        void reverse() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 14.14 | Detect a cycle | Stretch | class=LinkedList
        // PROMPT: Add `boolean hasCycle()` using Floyd's slow/fast pointers: if they ever meet, the list loops.
        // EXAMPLE: A list whose last node points back to its second node -> `true`
        // BIGO: O(N) time, O(1) space (a set of visited nodes would be O(N) space).
        // NOTE: Compare nodes with `==` (same object), not by `data`: two different nodes may hold equal values.
        boolean hasCycle() {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 14.13 | Delete a node given only that node | Practice
    // PROMPT: Write `static void deleteNode(Node node)` that removes `node` from its list when you have no access to the head. (It is never the last node.)
    // EXAMPLE: In `a -> b -> c -> d`, `deleteNode(b)` leaves `a -> c -> d`
    // BIGO: O(1). Copy the next node's data in, then skip the next node.
    static void deleteNode(Node node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 14.15 | Doubly linked list | Core
    // PROMPT: Build `static class DoublyLinkedList` with `head` and `tail` and nodes holding `prev` and `next`. Implement `insertAtStart`, `insertAtEnd`, `deleteAtStart`, `deleteAtEnd`, `toList()` and `toListReversed()` (walk back from the tail).
    // EXAMPLE: insertAtEnd 2, insertAtStart 1, insertAtEnd 3 -> `[1, 2, 3]`; reversed `[3, 2, 1]`
    // BIGO: O(1) at both ends, because the tail pointer and `prev` links remove the walk.
    static class DNode {
        final int data;
        DNode prev, next;

        DNode(int data) { throw new UnsupportedOperationException(); }
    }

    static class DoublyLinkedList {
        DNode head, tail;

        void insertAtStart(int value) {
            throw new UnsupportedOperationException();
        }

        void insertAtEnd(int value) {
            throw new UnsupportedOperationException();
        }

        Integer deleteAtStart() {
            throw new UnsupportedOperationException();
        }

        Integer deleteAtEnd() {
            throw new UnsupportedOperationException();
        }

        List<Integer> toList() {
            throw new UnsupportedOperationException();
        }

        List<Integer> toListReversed() {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    // ==== EX 14.16 | Queue on a doubly linked list | Core
    // PROMPT: Build `static class LinkedQueue` with `enqueue`, `dequeue` and `read` on top of your `DoublyLinkedList`.
    // EXAMPLE: enqueue 1, 2, 3 -> dequeue `1`, read `2`
    // BIGO: O(1) for every operation: insert at the tail, remove from the head.
    static class LinkedQueue {
        private final DoublyLinkedList items = new DoublyLinkedList();

        void enqueue(int value) { throw new UnsupportedOperationException(); }

        Integer dequeue() { throw new UnsupportedOperationException(); }

        Integer read() { throw new UnsupportedOperationException(); }
    }
    // ==== END
}
