import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Chapter 26: Treaps: balance from random priorities.
 * A treap is a BST by key and a heap by a random priority (here a max-heap: a parent's
 * priority is at least its children's). Methods take a node and return the new subtree root.
 */
public class Ch26Treaps {

    // ==== EX 26.1 | Treap nodes and rotations | Core
    // PROMPT: Create `static class TreapNode` with `int key`, `double priority`, `left` and `right`, and write `static TreapNode rotateRight(TreapNode node)` and `rotateLeft` that return the new subtree root.
    // EXAMPLE: rotating right at a node with left child L makes L the subtree root and the old node L's right child
    // BIGO: O(1).
    static class TreapNode {
        final int key;
        double priority;
        TreapNode left, right;

        TreapNode(int key, double priority) {
            throw new UnsupportedOperationException();
        }
    }

    static TreapNode rotateRight(TreapNode node) {
        throw new UnsupportedOperationException();
    }

    static TreapNode rotateLeft(TreapNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 26.2 | Insert, then rotate up | Core
    // PROMPT: Write `static TreapNode treapInsert(TreapNode node, int key, Random rng)` that gives the new key `rng.nextDouble()` as its priority, inserts it as a BST leaf, and on the way back up rotates it above any parent with a smaller priority.
    // EXAMPLE: `Random rng = new Random(1); TreapNode root = null; for (int k = 0; k < 10; k++) root = treapInsert(root, k, rng);` -> a valid treap whose in-order walk is 0..9
    // BIGO: O(log N) expected, whatever order the keys arrive in.
    static TreapNode treapInsert(TreapNode node, int key, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 26.3 | Search | Core
    // PROMPT: Write `static boolean treapContains(TreapNode node, int key)`. Priorities play no part in search.
    // EXAMPLE: after inserting `5, 2, 8` -> `treapContains(root, 8)` is `true`, `treapContains(root, 3)` is `false`
    // BIGO: O(log N) expected.
    static boolean treapContains(TreapNode node, int key) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 26.4 | Delete by rotating down | Core
    // PROMPT: Write `static TreapNode treapDelete(TreapNode node, int key)`: find the node, then rotate it down (always lifting the child with the larger priority) until it has at most one child, and splice it out.
    // EXAMPLE: insert 0..99, delete the multiples of 3 -> in-order gives the other 66 keys and the treap is still valid
    // BIGO: O(log N) expected.
    static TreapNode treapDelete(TreapNode node, int key) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 26.5 | Validate both orders at once | Core
    // PROMPT: Write `static boolean isValidTreap(TreapNode node, long lo, long hi)` checking BST order on keys and heap order on priorities in one recursive pass, and `static List<Integer> inorder(TreapNode node)`.
    // EXAMPLE: any treap built by 26.2 -> `true`; swap two priorities by hand -> `false`
    // BIGO: O(N).
    static boolean isValidTreap(TreapNode node, long lo, long hi) {
        throw new UnsupportedOperationException();
    }

    static List<Integer> inorder(TreapNode node) {
        throw new UnsupportedOperationException();
    }

    private static void walk(TreapNode node, List<Integer> out) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 26.6 | Random priorities do the balancing | Core
    // PROMPT: Write `static int treapHeight(int[] keys, Random rng)` building a treap from keys inserted in the given order. Insert 1..1000 in sorted order and compare with a plain BST (23.6).
    // EXAMPLE: sorted 1..1000 with `new Random(0)` -> height around 20 to 30, versus 1000 for a plain BST
    // BIGO: Expected height about 3 x log2 N, the same as a BST built from shuffled keys, so roughly 25 to 30 for N = 1000.
    static int treapHeight(int[] keys, Random rng) {
        throw new UnsupportedOperationException();
    }

    private static int height(TreapNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 26.7 | Split and merge | Stretch
    // PROMPT: Write `static TreapNode[] split(TreapNode node, int key)` returning `{left, right}` treaps with keys < key and >= key, and `static TreapNode merge(TreapNode a, TreapNode b)` joining treaps where every key in a is smaller than every key in b. Use them to delete a whole key range.
    // EXAMPLE: split a treap of 0..9 at 4 -> in-orders `[0, 1, 2, 3]` and `[4, 5, 6, 7, 8, 9]`; merging them restores 0..9
    // BIGO: O(log N) expected each. Many contest "implicit treap" tricks are built from these two operations.
    static TreapNode[] split(TreapNode node, int key) {
        throw new UnsupportedOperationException();
    }

    static TreapNode merge(TreapNode a, TreapNode b) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
