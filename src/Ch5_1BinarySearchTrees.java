import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/** Chapter 5.1: Binary search trees. */
public class Ch5_1BinarySearchTrees {

    // ==== EX 5.1.1 | Tree node and search | Core
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

    // ==== EX 5.1.2 | Insert | Core
    // PROMPT: Write `static TreeNode insert(TreeNode node, int value)` that returns the (possibly new) root. Walk down as in search; attach a new leaf at the first empty child. Ignore duplicates.
    // EXAMPLE: `root = null; for (int v : new int[]{50, 25, 75}) root = insert(root, v);` -> root 50, left 25, right 75
    // BIGO: O(log N) balanced, O(N) worst case.
    static TreeNode insert(TreeNode node, int value) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.3 | Delete (all three cases) | Core
    // PROMPT: Write `static TreeNode delete(TreeNode node, int value)` returning the new subtree root. Handle: no children (remove it), one child (the child takes its place), two children (replace the value with its successor, the smallest value in the right subtree, then delete the successor from there).
    // EXAMPLE: Deleting 50 from `{50, 25, 75, 61, 89, 52}` makes 52 the new root value
    // BIGO: O(log N) balanced.
    static TreeNode delete(TreeNode node, int value) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.4 | Traversals | Core
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

    // ==== EX 5.1.5 | Minimum and maximum | Core
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

    // ==== EX 5.1.6 | Height | Core
    // PROMPT: Write `static int height(TreeNode node)`: the number of nodes on the longest root-to-leaf path (empty tree = 0).
    // EXAMPLE: Tree from `{50, 25, 75, 10}` -> `3`; from sorted `{1, 2, 3, 4}` -> `4`
    // BIGO: O(N). Compare log2(N) to the height to see how balanced a tree is.
    static int height(TreeNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.7 | Build a tree and tree-sort | Practice
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

    // ==== EX 5.1.8 | Validate a BST | Practice
    // PROMPT: Write `static boolean isValidBst(TreeNode node, long low, long high)`. Checking only each node's direct children is not enough: pass down the allowed range, starting from `Long.MIN_VALUE` and `Long.MAX_VALUE`.
    // EXAMPLE: `new TreeNode(10, new TreeNode(5, null, new TreeNode(12)), new TreeNode(15))` -> `false` (12 sits left of 10)
    // BIGO: O(N).
    // NOTE: Using `long` bounds lets a tree contain `Integer.MIN_VALUE` and `Integer.MAX_VALUE` without a special case.
    static boolean isValidBst(TreeNode node, long low, long high) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.9 | Level-order traversal | Practice
    // PROMPT: Write `static List<List<Integer>> levelOrder(TreeNode node)` returning a list of levels, using an `ArrayDeque` as the queue.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}` -> `[[50], [25, 75], [10, 33]]`
    // BIGO: O(N) time, O(W) space for the widest level.
    static List<List<Integer>> levelOrder(TreeNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.10 | Count the nodes | Core
    // PROMPT: Write `static int countNodes(TreeNode node)` recursively.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}` -> `5`
    // BIGO: O(N).
    static int countNodes(TreeNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.11 | Closest value | Core
    // PROMPT: Write `static int closestValue(TreeNode root, int target)` that returns the value in a non-empty BST nearest to `target` (on a tie, the smaller value), walking one path down as a search would.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}`, `30` -> `33`
    // BIGO: O(H) time for height H, O(1) space: the search path is the only place a closer value can be, because each step away from it moves further from the target.
    static int closestValue(TreeNode root, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.12 | Balanced tree from a sorted array | Practice
    // PROMPT: Write `static TreeNode balancedBst(int[] values)` that builds a BST of minimum height from sorted, distinct `values` and returns its root (`null` when empty): the middle value (index `(lo + hi) / 2`) becomes the root, and each half builds a subtree the same way.
    // EXAMPLE: `[1, 2, 3, 4, 5, 6, 7]` -> root `4` with children `2` and `6`
    // BIGO: O(N) time, O(log N) stack: each value becomes a node once, and taking the middle each time keeps both sides within one node of each other.
    static TreeNode balancedBst(int[] values) { throw new UnsupportedOperationException(); }

    static TreeNode buildBalanced(int[] values, int lo, int hi) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.13 | K-th largest value | Practice
    // PROMPT: Write `static int kthLargest(TreeNode root, int k)` that returns the `k`-th largest value in a BST (`1 <= k <=` number of nodes) without visiting the whole tree: walk right subtree, node, left subtree with an explicit stack, and stop at the `k`-th node visited.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}`, `2` -> `50`
    // BIGO: O(H + K) time, O(H) space: a reverse in-order walk meets values from largest down and stops at the k-th.
    static int kthLargest(TreeNode root, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.14 | Rebuild a BST from its preorder | Practice
    // PROMPT: `values` is the preorder listing of a BST with distinct values. Write `static TreeNode bstFromPreorder(int[] values)` that rebuilds the tree in O(N) and returns its root: read values in order, and let each recursive call accept only values below the bound its parent gives it.
    // EXAMPLE: `[40, 20, 10, 30, 60, 70]` -> root `40`, left `20` (children `10`, `30`), right `60` (right child `70`)
    // BIGO: O(N) time, O(H) stack: each value is read once, and the upper bound passed down says when a subtree has ended.
    static TreeNode bstFromPreorder(int[] values) { throw new UnsupportedOperationException(); }

    static TreeNode buildFromPreorder(int[] values, int[] next, long bound) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.15 | In-order successor | Practice
    // PROMPT: Write `static Integer successor(TreeNode root, int value)` that returns the next larger value after `value` in a BST, or `null` when `value` is the largest. `value` need not be in the tree. Walk down from the root, remembering the last node where you turned left.
    // EXAMPLE: Tree from `{50, 25, 75, 10, 33}`, `33` -> `50`; `75` -> `null`
    // BIGO: O(H) time, O(1) space: every time the search turns left, that node is the best successor so far.
    static Integer successor(TreeNode root, int value) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.1.16 | Repair two swapped values | Stretch
    // PROMPT: Exactly two values of a BST were swapped. Write `static void repairSwapped(TreeNode root)` that swaps them back in place without rebuilding the tree. Walk in order with an explicit stack: the first descent's larger value is one culprit, and the last descent's smaller value is the other.
    // EXAMPLE: `50 -> (75 -> 10, 33), 25` (`25` and `75` swapped) -> `50 -> (25 -> 10, 33), 75`
    // BIGO: O(N) time, O(H) space: in-order, a BST reads ascending, so the swapped pair shows up as one or two descents in that sequence.
    static void repairSwapped(TreeNode root) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
