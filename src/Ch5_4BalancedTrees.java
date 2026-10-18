import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

/** Chapter 5.4: Self-balancing trees: red-black trees and treaps. */
public class Ch5_4BalancedTrees {

    // ==== EX 5.4.1 | Nodes, the NIL sentinel and rotations | Core
    // PROMPT: Create `static class RBNode` with `int key`, `boolean red`, and `left`, `right`, `parent` links, then `static class RedBlackTree` whose empty children all point at one black `NIL` sentinel, with `rotateLeft(x)` and `rotateRight(x)` that keep parent links and the root correct.
    // EXAMPLE: after a left rotation at x, x's old right child takes x's place and x becomes its left child; in-order order is unchanged
    // BIGO: O(1) per rotation: three links change.
    // NOTE: A rotation never breaks binary-search order. It only changes the shape, which is all balancing needs. Compare nodes with `==`: the sentinel is one shared object.
    static class RBNode {
        int key;
        boolean red;
        RBNode left, right, parent;

        RBNode(int key, boolean red, RBNode nil) {
            throw new UnsupportedOperationException();
        }
    }

    static class RedBlackTree {
        final RBNode NIL = new RBNode(0, false, null);
        RBNode root = NIL;
        int size, rotations;

        RedBlackTree() { throw new UnsupportedOperationException(); }

        void rotateLeft(RBNode x) {
            throw new UnsupportedOperationException();
        }

        void rotateRight(RBNode x) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.4.2 | Insert with recolouring and rotations | Core | class=RedBlackTree
        // PROMPT: Add `boolean insert(int key)`: do a normal BST insert of a red node, then fix up. While the parent is red: if the uncle is red, recolour parent, uncle and grandparent and move up; otherwise rotate (once or twice) and recolour. Finally paint the root black.
        // EXAMPLE: insert 1..7 in sorted order -> root `2`, height `4` (a plain BST would be 7 tall), and `validate()` passes after every insert
        // BIGO: O(log N): the walk down is O(log N), fix-up recolours up the tree and does at most two rotations.
        boolean insert(int key) {
            throw new UnsupportedOperationException();
        }

        private void insertFixup(RBNode z) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.4.3 | Check the red-black rules | Core | class=RedBlackTree
        // PROMPT: Add `int validate()` returning the tree's black height, and throwing `IllegalStateException` if the root is red, a red node has a red child, BST order is broken, or two paths have different black counts.
        // EXAMPLE: after any sequence of inserts and deletes, `validate()` returns a positive number instead of throwing
        // BIGO: O(N). Write this before insert: it is the test that tells you whether your fix-up works.
        int validate() {
            throw new UnsupportedOperationException();
        }

        private int check(RBNode node, long lo, long hi) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.4.4 | Search and in-order walk | Core | class=RedBlackTree
        // PROMPT: Add `boolean contains(int key)` and `List<Integer> inorder()` (iterative, with an explicit stack). Both ignore colour entirely: a red-black tree is still a BST.
        // EXAMPLE: after inserting `5, 2, 8, 1` -> `contains(8)` is `true`; `inorder()` is `[1, 2, 5, 8]`
        // BIGO: Search O(log N) guaranteed; in-order O(N).
        boolean contains(int key) {
            throw new UnsupportedOperationException();
        }

        List<Integer> inorder() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.4.5 | Height stays logarithmic | Core | class=RedBlackTree
        // PROMPT: Add `int height()` and `double heightBound()` = 2 * log2(N + 1), and check the height never exceeds the bound, even after inserting 1..N in sorted order (which makes a plain BST N tall).
        // EXAMPLE: insert 1..1000 in order -> `height()` is at most `19`, while a plain BST would be `1000` tall
        // BIGO: O(N) to measure. The bound follows from the rules: no two reds in a row, and equal black counts on every path.
        int height() { throw new UnsupportedOperationException(); }

        private int h(RBNode node) {
            throw new UnsupportedOperationException();
        }

        double heightBound() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.4.6 | Minimum, maximum and successor | Practice | class=RedBlackTree
        // PROMPT: Add `RBNode minimum(RBNode node)`, `int maximum()` and `Integer successor(int key)` (the smallest key greater than key, or `null`), using parent links for the successor.
        // EXAMPLE: keys `20, 10, 30, 25` -> `minimum(root).key` `10`, `maximum()` `30`, `successor(20)` `25`, `successor(30)` `null`
        // BIGO: O(log N) each.
        RBNode minimum(RBNode node) {
            throw new UnsupportedOperationException();
        }

        int maximum() {
            throw new UnsupportedOperationException();
        }

        RBNode find(int key) {
            throw new UnsupportedOperationException();
        }

        Integer successor(int key) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.4.8 | Deletion | Stretch | class=RedBlackTree
        // PROMPT: Add `boolean delete(int key)`. Splice out the node (or its successor), remember the colour removed, and if a black node was removed run the four-case "double black" fix-up with rotations and recolouring. Return `false` if the key is absent.
        // EXAMPLE: insert 1..100, delete every even key -> `validate()` passes and `inorder()` is the odd keys
        // BIGO: O(log N), with at most three rotations.
        // NOTE: The fix-up may set `NIL.parent` temporarily; that is why the sentinel is a real node rather than `null`.
        private void transplant(RBNode u, RBNode v) {
            throw new UnsupportedOperationException();
        }

        boolean delete(int key) {
            throw new UnsupportedOperationException();
        }

        private void deleteFixup(RBNode x) {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 5.4.7 | Count the rotations | Practice
    // PROMPT: Write `static int rotationsFor(int[] keys)` returning how many rotations a red-black tree performs while inserting keys in order. Compare sorted, reversed and shuffled input.
    // EXAMPLE: `rotationsFor(0..999 in order)` -> fewer than 1000 rotations in total (amortized O(1) per insert)
    // BIGO: At most 2 rotations per insert; amortized fewer.
    static int rotationsFor(int[] keys) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.4.9 | Treap nodes and rotations | Core
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

    // ==== EX 5.4.10 | Insert, then rotate up | Core
    // PROMPT: Write `static TreapNode treapInsert(TreapNode node, int key, Random rng)` that gives the new key `rng.nextDouble()` as its priority, inserts it as a BST leaf, and on the way back up rotates it above any parent with a smaller priority.
    // EXAMPLE: `Random rng = new Random(1); TreapNode root = null; for (int k = 0; k < 10; k++) root = treapInsert(root, k, rng);` -> a valid treap whose in-order walk is 0..9
    // BIGO: O(log N) expected, whatever order the keys arrive in.
    static TreapNode treapInsert(TreapNode node, int key, Random rng) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.4.11 | Search | Core
    // PROMPT: Write `static boolean treapContains(TreapNode node, int key)`. Priorities play no part in search.
    // EXAMPLE: after inserting `5, 2, 8` -> `treapContains(root, 8)` is `true`, `treapContains(root, 3)` is `false`
    // BIGO: O(log N) expected.
    static boolean treapContains(TreapNode node, int key) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.4.12 | Delete by rotating down | Core
    // PROMPT: Write `static TreapNode treapDelete(TreapNode node, int key)`: find the node, then rotate it down (always lifting the child with the larger priority) until it has at most one child, and splice it out.
    // EXAMPLE: insert 0..99, delete the multiples of 3 -> in-order gives the other 66 keys and the treap is still valid
    // BIGO: O(log N) expected.
    static TreapNode treapDelete(TreapNode node, int key) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.4.13 | Validate both orders at once | Core
    // PROMPT: Write `static boolean isValidTreap(TreapNode node, long lo, long hi)` checking BST order on keys and heap order on priorities in one recursive pass, and `static List<Integer> inorder(TreapNode node)`.
    // EXAMPLE: any treap built by 5.4.10 -> `true`; swap two priorities by hand -> `false`
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

    // ==== EX 5.4.14 | Random priorities do the balancing | Core
    // PROMPT: Write `static int treapHeight(int[] keys, Random rng)` building a treap from keys inserted in the given order. Insert 1..1000 in sorted order and compare with a plain BST (7.4.6).
    // EXAMPLE: sorted 1..1000 with `new Random(0)` -> height around 20 to 30, versus 1000 for a plain BST
    // BIGO: Expected height about 3 x log2 N, the same as a BST built from shuffled keys, so roughly 25 to 30 for N = 1000.
    static int treapHeight(int[] keys, Random rng) {
        throw new UnsupportedOperationException();
    }

    private static int height(TreapNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.4.15 | Split and merge | Stretch
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
