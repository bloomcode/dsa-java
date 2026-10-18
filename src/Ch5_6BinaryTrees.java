import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;

/** Chapter 5.6: Binary trees. */
public class Ch5_6BinaryTrees {
    /** A binary tree node; unlike a BST (Chapter 5.1), the values follow no order. */
    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) { this.value = value; }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // ==== EX 5.6.1 | Is there a path with this sum? | Core
    // PROMPT: Write `static boolean hasPathSum(TreeNode root, int target)`: `true` when some root-to-leaf path has values summing to `target`. Recurse with `target - root.value`; only a leaf can complete a path (an empty tree has none).
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))`, `10` -> `true` (1 + 3 + 6); `8` -> `false`
    // BIGO: O(N) time, O(H) stack: each call passes down what is left of the target, and only a leaf can finish a path.
    // NOTE: Examples write a tree as `value(left, right)`, with `-` for a missing child: `5(7)` is a 5 whose left child is 7.
    static boolean hasPathSum(TreeNode root, int target) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.2 | Total depth | Core
    // PROMPT: Write `static int totalDepth(TreeNode root)` that returns the sum of every node's depth (the root has depth 0). Pass the depth down as you recurse.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `11`
    // BIGO: O(N) time, O(H) stack: each node adds the depth it is called with.
    static int totalDepth(TreeNode root) { throw new UnsupportedOperationException(); }

    static int depthSum(TreeNode node, int depth) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.3 | Mirror a tree | Core
    // PROMPT: Write `static TreeNode mirror(TreeNode root)` that swaps the left and right children of every node, in place, and returns `root`.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `1(3(6, -), 2(5(-, 7), 4))`
    // BIGO: O(N) time, O(H) stack: every node swaps its two children once.
    static TreeNode mirror(TreeNode root) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.4 | Is the tree symmetric? | Core
    // PROMPT: Write `static boolean isSymmetric(TreeNode root)`: `true` when the tree is its own mirror image (an empty tree is). Compare two subtrees at once: their values must match, and the left of one must mirror the right of the other.
    // EXAMPLE: `1(2(3, 4), 2(4, 3))` -> `true`; `1(2(-, 3), 2(-, 3))` -> `false`
    // BIGO: O(N) time, O(H) stack: compare the two halves in step, each outer child against the opposite outer child.
    static boolean isSymmetric(TreeNode root) { throw new UnsupportedOperationException(); }

    static boolean mirrored(TreeNode a, TreeNode b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.5 | The view from the right | Core
    // PROMPT: Write `static List<Integer> rightView(TreeNode root)` that returns the values seen looking at the tree from the right: the last node of each level, top to bottom. Walk level by level, building the next level from the children of the current one.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `[1, 3, 6, 7]`
    // BIGO: O(N) time, O(W) space for the widest level W: a level-by-level walk, keeping the last node of each level.
    static List<Integer> rightView(TreeNode root) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.6 | Average of each level | Core
    // PROMPT: Write `static List<Double> levelAverages(TreeNode root)` that returns the average value of each level, top to bottom, walking the tree level by level.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `[1.0, 2.5, 5.0, 7.0]`
    // BIGO: O(N) time, O(W) space for the widest level W: one level-by-level walk.
    static List<Double> levelAverages(TreeNode root) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.7 | Every root-to-leaf path | Core
    // PROMPT: Write `static List<List<Integer>> leafPaths(TreeNode root)` that returns every root-to-leaf path as a list of values, leftmost path first. Keep one path list: append on the way down, record a copy at a leaf, and remove the last value on the way back up.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `[[1, 2, 4], [1, 2, 5, 7], [1, 3, 6]]`
    // BIGO: O(N * H) time and space for the copies, O(H) for the path being built: one path list grows and shrinks as the walk goes down and back up.
    static List<List<Integer>> leafPaths(TreeNode root) {
        throw new UnsupportedOperationException();
    }

    static void collectPaths(TreeNode node, List<Integer> path, List<List<Integer>> out) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.8 | In-order walk without recursion | Core
    // PROMPT: Write `static List<Integer> inorderIterative(TreeNode root)` that returns the in-order values (left, node, right) using an explicit stack (`ArrayDeque`) instead of recursion: push the whole left spine, pop and visit a node, then continue from its right child.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `[4, 2, 7, 5, 1, 3, 6]`
    // BIGO: O(N) time, O(H) space: the stack holds the left spine still waiting to be visited, which is what the call stack held in the recursive version.
    static List<Integer> inorderIterative(TreeNode root) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.9 | Evaluate an expression tree | Core
    // PROMPT: Create `static class ExprNode` with `String token`, `ExprNode left, right` and constructors `ExprNode(String token)` and `ExprNode(String token, ExprNode left, ExprNode right)`: a leaf holds an integer as text (`"-9"`), any other node holds `"+"`, `"-"` or `"*"` and has two children. Write `static int evaluate(ExprNode node)` that returns the value of the expression.
    // EXAMPLE: `*(+(3, 4), -(5, 2))` -> `21`
    // BIGO: O(N) time, O(H) stack: a post-order walk, because an operator needs both operands first.
    static class ExprNode {
        String token;
        ExprNode left, right;

        ExprNode(String token) { throw new UnsupportedOperationException(); }

        ExprNode(String token, ExprNode left, ExprNode right) {
            throw new UnsupportedOperationException();
        }
    }

    static int evaluate(ExprNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.10 | Diameter | Practice
    // PROMPT: Write `static int diameter(TreeNode root)` that returns the number of edges on the longest path between any two nodes. In one walk, return each subtree's height and update the best `left height + right height` seen at any node.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `5` (7 to 6)
    // BIGO: O(N) time, O(H) stack: one post-order walk returns each subtree's height and, on the side, tries the path that bends at that node.
    static int diameter(TreeNode root) {
        throw new UnsupportedOperationException();
    }

    static int heightTracking(TreeNode node, int[] best) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.11 | Is the tree height-balanced? | Practice
    // PROMPT: Write `static boolean isBalanced(TreeNode root)`: `true` when at every node the heights of the two subtrees differ by at most one. Do it in O(N): a helper returns a subtree's height, or `-1` once any part of it is unbalanced.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `true`; `1(2(3), -)` -> `false`
    // BIGO: O(N) time, O(H) stack: each call returns its height, or -1 as soon as any subtree is out of balance, so no height is computed twice.
    static boolean isBalanced(TreeNode root) { throw new UnsupportedOperationException(); }

    static int balancedHeight(TreeNode node) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.12 | Widest level | Practice
    // PROMPT: The width of a level is the distance from its leftmost to its rightmost node, counting the missing places between them. Write `static int widestLevel(TreeNode root)` that returns the largest width (`0` for an empty tree). Walk level by level with heap-style positions, renumbering each level from 0 so the numbers stay small.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `4` (the level `4, 5, -, 6`)
    // BIGO: O(N) time, O(W) space: number positions like a heap (children of `p` at `2p` and `2p + 1`), and a level's width is its last position minus its first, plus one.
    static int widestLevel(TreeNode root) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.13 | Lowest common ancestor | Practice
    // PROMPT: Values are distinct, and `a` and `b` are both in the tree. Write `static TreeNode lowestCommonAncestor(TreeNode root, int a, int b)` that returns the deepest node having both values in its subtree (a node counts as its own descendant). Return the node holding `a` or `b` when you reach it; a node that gets non-null answers from both sides is the ancestor.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))`, `4, 7` -> the node `2`; `7, 6` -> the node `1`
    // BIGO: O(N) time, O(H) stack: a node whose two subtrees each report a match is the answer, and it is the only one that sees both.
    static TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.14 | Turn a tree into text and back | Practice
    // PROMPT: Write `static String serialize(TreeNode root)`, which lists the values in pre-order separated by commas, with `#` for each missing child, and `static TreeNode parse(String text)`, which rebuilds the tree from that text. Parse by reading tokens in order: `#` is an empty subtree; anything else is a node whose left and then right subtrees follow.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `"1,2,4,#,#,5,7,#,#,#,3,#,6,#,#"`
    // BIGO: O(N) time and space both ways: pre-order with a marker for every missing child records the shape exactly, so parsing never has to guess.
    static String serialize(TreeNode root) {
        throw new UnsupportedOperationException();
    }

    static void writeTree(TreeNode node, StringJoiner out) {
        throw new UnsupportedOperationException();
    }

    static TreeNode parse(String text) { throw new UnsupportedOperationException(); }

    static TreeNode readTree(Iterator<String> tokens) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.15 | Vertical columns | Practice
    // PROMPT: Give the root column 0, a left child its parent's column minus 1 and a right child plus 1. Write `static List<List<Integer>> verticalColumns(TreeNode root)` that returns the values column by column from left to right, each column top to bottom, and left to right within a level. Walk breadth-first, carrying each node's column.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))` -> `[[4], [2, 7], [1, 5], [3], [6]]`
    // BIGO: O(N log N) time for sorting the column numbers (O(N) with a running minimum), O(N) space: a breadth-first walk lists each column top to bottom.
    static List<List<Integer>> verticalColumns(TreeNode root) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.16 | Nodes at distance k | Stretch
    // PROMPT: Values are distinct and `target` is in the tree. Write `static List<Integer> nodesAtDistance(TreeNode root, int target, int k)` that returns, in ascending order, the values of every node exactly `k` edges from the node holding `target`, whether up, down or across. Map each node to its parent, then walk outward breadth-first from the target, `k` rounds, never revisiting a node.
    // EXAMPLE: `1(2(4, 5(7)), 3(-, 6))`, `5, 2` -> `[1, 4]`
    // BIGO: O(N) time and space: record every node's parent, and the tree becomes an undirected graph that a breadth-first search can walk k steps out.
    static List<Integer> nodesAtDistance(TreeNode root, int target, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.17 | Largest path sum | Stretch
    // PROMPT: Values may be negative. A path is any chain of connected nodes, at least one, each used once. Write `static int maxPathSum(TreeNode root)` that returns the largest path sum in a non-empty tree. A helper returns the best sum of a path going down from a node (dropping a negative branch), and records `node + left + right` as a candidate.
    // EXAMPLE: `2(-1(4, -6), 3(-, 5))` -> `13` (4, -1, 2, 3, 5)
    // BIGO: O(N) time, O(H) stack: each call returns the best downward path from its node, and the best bent path through it is tried on the side.
    static int maxPathSum(TreeNode root) {
        throw new UnsupportedOperationException();
    }

    static int downGain(TreeNode node, int[] best) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.6.18 | Rebuild from pre-order and in-order | Stretch
    // PROMPT: Write `static TreeNode rebuild(int[] preorder, int[] inorder)` that returns the tree with these two traversals (distinct values; `null` when empty). Take roots from `preorder` in order; each root's position in `inorder`, found through a `HashMap`, splits the remaining range into its left and right subtrees.
    // EXAMPLE: `[1, 2, 4, 5, 7, 3, 6]`, `[4, 2, 7, 5, 1, 3, 6]` -> `1(2(4, 5(7)), 3(-, 6))`
    // BIGO: O(N) time and space: the next pre-order value is the root of the current range, and a map from value to in-order index splits the range at once.
    static TreeNode rebuild(int[] preorder, int[] inorder) {
        throw new UnsupportedOperationException();
    }

    static TreeNode rebuildRange(int[] preorder, Map<Integer, Integer> where, int[] next, int lo, int hi) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
