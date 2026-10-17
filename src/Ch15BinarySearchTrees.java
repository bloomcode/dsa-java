import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Chapter 15: Binary search trees.
 * Functions take a node and return a node, so an empty tree is null.
 */
public class Ch15BinarySearchTrees {

    // ==== EX 15.1 | Tree node and search | Core
    // PROMPT: Create `static class TreeNode` with `int value` and `left`/`right` children. Write `static TreeNode search(TreeNode node, int value)` returning the node holding `value`, or `null`: go left if smaller, right if larger.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}` -> `search(root, 33).value` is `33`; `search(root, 40)` is `null`
    // BIGO: O(log N) in a balanced tree; O(N) in a degenerate one (sorted inserts make a linked list).
    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) { throw new UnsupportedOperationException(); }

        TreeNode(int value, TreeNode left, TreeNode right) {
            throw new UnsupportedOperationException();
        }
    }

    static TreeNode search(TreeNode node, int value) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 15.2 | Insert | Core
    // PROMPT: Write `static TreeNode insert(TreeNode node, int value)` that returns the (possibly new) root. Walk down as in search; attach a new leaf at the first empty child. Ignore duplicates.
    // EXAMPLE: `root = null; for (int v : new int[]{50, 25, 75}) root = insert(root, v);` -> root 50, left 25, right 75
    // BIGO: O(log N) balanced, O(N) worst case.
    static TreeNode insert(TreeNode node, int value) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 15.3 | Delete (all three cases) | Core
    // PROMPT: Write `static TreeNode delete(TreeNode node, int value)` returning the new subtree root. Handle: no children (remove it), one child (the child takes its place), two children (replace the value with its successor, the smallest value in the right subtree, then delete the successor from there).
    // EXAMPLE: Deleting 50 from `{50, 25, 75, 61, 89, 52}` makes 52 the new root value
    // BIGO: O(log N) balanced.
    static TreeNode delete(TreeNode node, int value) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 15.4 | Traversals | Core
    // PROMPT: Write `static List<Integer> inorder(TreeNode node)`, `preorder` and `postorder`, each filling one shared `ArrayList` through a private recursive helper.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}` -> inorder `[10, 25, 33, 50, 75]`, preorder `[50, 25, 10, 33, 75]`, postorder `[10, 33, 25, 75, 50]`
    // BIGO: O(N): every node is visited once. Concatenating new lists at every level, as a one-line version would, adds copying.
    // NOTE: In-order traversal of a BST always yields sorted values.
    static List<Integer> inorder(TreeNode node) {
        throw new UnsupportedOperationException();
    }

    static List<Integer> preorder(TreeNode node) {
        throw new UnsupportedOperationException();
    }

    static List<Integer> postorder(TreeNode node) {
        throw new UnsupportedOperationException();
    }

    /** order: 0 = pre, 1 = in, 2 = post. */
    private static void walk(TreeNode node, List<Integer> out, int order) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 15.5 | Minimum and maximum | Core
    // PROMPT: Write `static Integer findMin(TreeNode node)` and `findMax` by walking only left or only right. Return `null` for an empty tree.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}` -> `10` and `75`
    // BIGO: O(log N) balanced (the height of the tree).
    static Integer findMin(TreeNode node) {
        throw new UnsupportedOperationException();
    }

    static Integer findMax(TreeNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 15.6 | Height | Core
    // PROMPT: Write `static int height(TreeNode node)`: the number of nodes on the longest root-to-leaf path (empty tree = 0).
    // EXAMPLE: Tree from `{50, 25, 75, 10}` -> `3`; from sorted `{1, 2, 3, 4}` -> `4`
    // BIGO: O(N). Compare log2(N) to the height to see how balanced a tree is.
    static int height(TreeNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 15.7 | Build a tree and tree-sort | Practice
    // PROMPT: Write `static TreeNode buildBst(int... values)` returning the root, and `static List<Integer> treeSort(int... values)` = build, then in-order. Try sorted input and look at `height`.
    // EXAMPLE: `treeSort(5, 3, 8, 1, 4)` -> `[1, 3, 4, 5, 8]`
    // BIGO: O(N log N) on random input, O(N^2) on sorted input (the tree degenerates, and deep recursion can overflow the stack).
    static TreeNode buildBst(int... values) {
        throw new UnsupportedOperationException();
    }

    static List<Integer> treeSort(int... values) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 15.8 | Validate a BST | Practice
    // PROMPT: Write `static boolean isValidBst(TreeNode node, long low, long high)`. Checking only each node's direct children is not enough: pass down the allowed range, starting from `Long.MIN_VALUE` and `Long.MAX_VALUE`.
    // EXAMPLE: `new TreeNode(10, new TreeNode(5, null, new TreeNode(12)), new TreeNode(15))` -> `false` (12 sits left of 10)
    // BIGO: O(N).
    // NOTE: Using `long` bounds lets a tree contain `Integer.MIN_VALUE` and `Integer.MAX_VALUE` without a special case.
    static boolean isValidBst(TreeNode node, long low, long high) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 15.9 | Level-order traversal | Practice
    // PROMPT: Write `static List<List<Integer>> levelOrder(TreeNode node)` returning a list of levels, using an `ArrayDeque` as the queue.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}` -> `[[50], [25, 75], [10, 33]]`
    // BIGO: O(N) time, O(W) space for the widest level.
    static List<List<Integer>> levelOrder(TreeNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 15.10 | Count the nodes | Core
    // PROMPT: Write `static int countNodes(TreeNode node)` recursively.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}` -> `5`
    // BIGO: O(N).
    static int countNodes(TreeNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
