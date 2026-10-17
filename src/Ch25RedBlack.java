import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Chapter 25: Red-black trees.
 * A shared black sentinel NIL stands in for every empty child, as in most textbook
 * implementations; it removes many null checks from the fix-up code.
 */
public class Ch25RedBlack {

    // ==== EX 25.1 | Nodes, the NIL sentinel and rotations | Core
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

        // ==== EX 25.2 | Insert with recolouring and rotations | Core | class=RedBlackTree
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

        // ==== EX 25.3 | Check the red-black rules | Core | class=RedBlackTree
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

        // ==== EX 25.4 | Search and in-order walk | Core | class=RedBlackTree
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

        // ==== EX 25.5 | Height stays logarithmic | Core | class=RedBlackTree
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

        // ==== EX 25.6 | Minimum, maximum and successor | Practice | class=RedBlackTree
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

        // ==== EX 25.8 | Deletion | Stretch | class=RedBlackTree
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

    // ==== EX 25.7 | Count the rotations | Practice
    // PROMPT: Write `static int rotationsFor(int[] keys)` returning how many rotations a red-black tree performs while inserting keys in order. Compare sorted, reversed and shuffled input.
    // EXAMPLE: `rotationsFor(0..999 in order)` -> fewer than 1000 rotations in total (amortized O(1) per insert)
    // BIGO: At most 2 rotations per insert; amortized fewer.
    static int rotationsFor(int[] keys) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
