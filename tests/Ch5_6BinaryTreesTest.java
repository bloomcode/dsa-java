import java.util.ArrayList;
import java.util.List;

/** Chapter 5.6 tests, one class per exercise. */

final class Ch5_6BinaryTreesTest {
    private Ch5_6BinaryTreesTest() {}

    /** Build a tree from level-order values, null for a missing child (children of a missing node are not listed). */
    static Ch5_6BinaryTrees.TreeNode tree(Integer... values) {
        if (values.length == 0 || values[0] == null) return null;
        Ch5_6BinaryTrees.TreeNode root = new Ch5_6BinaryTrees.TreeNode(values[0]);
        List<Ch5_6BinaryTrees.TreeNode> queue = new ArrayList<>(List.of(root));
        int i = 1;
        for (int q = 0; q < queue.size() && i < values.length; q++) {
            Ch5_6BinaryTrees.TreeNode node = queue.get(q);
            if (i < values.length && values[i] != null) queue.add(node.left = new Ch5_6BinaryTrees.TreeNode(values[i]));
            i++;
            if (i < values.length && values[i] != null) queue.add(node.right = new Ch5_6BinaryTrees.TreeNode(values[i]));
            i++;
        }
        return root;
    }

    /** 1(2(4, 5(7)), 3(-, 6)), used by most tests. */
    static Ch5_6BinaryTrees.TreeNode sample() { return tree(1, 2, 3, 4, 5, null, 6, null, null, 7); }

    static List<Integer> inorder(Ch5_6BinaryTrees.TreeNode node) {
        List<Integer> out = new ArrayList<>();
        if (node != null) {
            out.addAll(inorder(node.left));
            out.add(node.value);
            out.addAll(inorder(node.right));
        }
        return out;
    }

    static List<Integer> preorder(Ch5_6BinaryTrees.TreeNode node) {
        List<Integer> out = new ArrayList<>();
        if (node != null) {
            out.add(node.value);
            out.addAll(preorder(node.left));
            out.addAll(preorder(node.right));
        }
        return out;
    }
}

class Ex5_6_1Test {
    public static void run() {
        Ch5_6BinaryTrees.TreeNode root = Ch5_6BinaryTreesTest.sample();
        int[] targets = {10, 15, 7, 8, 3};
        boolean[] want = {true, true, true, false, false};
        for (int i = 0; i < targets.length; i++) Check.eq(Ch5_6BinaryTrees.hasPathSum(root, targets[i]), want[i]);
        Check.no(Ch5_6BinaryTrees.hasPathSum(null, 0));
        Check.yes(Ch5_6BinaryTrees.hasPathSum(new Ch5_6BinaryTrees.TreeNode(5), 5));
    }
}

class Ex5_6_2Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.totalDepth(Ch5_6BinaryTreesTest.sample()), 11);
        Check.eq(Ch5_6BinaryTrees.totalDepth(null), 0);
        Check.eq(Ch5_6BinaryTrees.totalDepth(new Ch5_6BinaryTrees.TreeNode(1)), 0);
        Check.eq(Ch5_6BinaryTrees.totalDepth(Ch5_6BinaryTreesTest.tree(1, 2, null, 3)), 3);
        Check.eq(Ch5_6BinaryTrees.totalDepth(Ch5_6BinaryTreesTest.tree(1, 2, 3, 4, 5, 6, 7)), 10);
    }
}

class Ex5_6_3Test {
    public static void run() {
        Ch5_6BinaryTrees.TreeNode root = Ch5_6BinaryTreesTest.sample();
        Check.yes(Ch5_6BinaryTrees.mirror(root) == root);
        Check.eq(Ch5_6BinaryTreesTest.inorder(root), List.of(6, 3, 1, 5, 7, 2, 4));
        Check.eq(root.left.value, 3);
        Check.yes(Ch5_6BinaryTrees.mirror(null) == null);
    }
}

class Ex5_6_4Test {
    public static void run() {
        Check.yes(Ch5_6BinaryTrees.isSymmetric(Ch5_6BinaryTreesTest.tree(1, 2, 2, 3, 4, 4, 3)));
        Check.no(Ch5_6BinaryTrees.isSymmetric(Ch5_6BinaryTreesTest.tree(1, 2, 2, null, 3, null, 3)));
        Check.yes(Ch5_6BinaryTrees.isSymmetric(null));
        Check.yes(Ch5_6BinaryTrees.isSymmetric(new Ch5_6BinaryTrees.TreeNode(1)));
        Check.no(Ch5_6BinaryTrees.isSymmetric(Ch5_6BinaryTreesTest.tree(1, 2, 3)));
        Check.no(Ch5_6BinaryTrees.isSymmetric(Ch5_6BinaryTreesTest.sample()));
    }
}

class Ex5_6_5Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.rightView(Ch5_6BinaryTreesTest.sample()), List.of(1, 3, 6, 7));
        Check.eq(Ch5_6BinaryTrees.rightView(Ch5_6BinaryTreesTest.tree(1, 2, 3, 4)), List.of(1, 3, 4));
        Check.eq(Ch5_6BinaryTrees.rightView(null), List.of());
    }
}

class Ex5_6_6Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.levelAverages(Ch5_6BinaryTreesTest.sample()), List.of(1.0, 2.5, 5.0, 7.0));
        Check.eq(Ch5_6BinaryTrees.levelAverages(null), List.of());
        Check.eq(Ch5_6BinaryTrees.levelAverages(Ch5_6BinaryTreesTest.tree(3, -1, 2)), List.of(3.0, 0.5));
    }
}

class Ex5_6_7Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.leafPaths(Ch5_6BinaryTreesTest.sample()), List.of(List.of(1, 2, 4), List.of(1, 2, 5, 7), List.of(1, 3, 6)));
        Check.eq(Ch5_6BinaryTrees.leafPaths(null), List.of());
        Check.eq(Ch5_6BinaryTrees.leafPaths(new Ch5_6BinaryTrees.TreeNode(9)), List.of(List.of(9)));
    }
}

class Ex5_6_8Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.inorderIterative(Ch5_6BinaryTreesTest.sample()), List.of(4, 2, 7, 5, 1, 3, 6));
        Check.eq(Ch5_6BinaryTrees.inorderIterative(null), List.of());
        Check.eq(Ch5_6BinaryTrees.inorderIterative(Ch5_6BinaryTreesTest.tree(1, 2, null, 3, null, 4)), List.of(4, 3, 2, 1));
    }
}

class Ex5_6_9Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.evaluate(op("*", op("+", leaf("3"), leaf("4")), op("-", leaf("5"), leaf("2")))), 21);
        Check.eq(Ch5_6BinaryTrees.evaluate(leaf("7")), 7);
        Check.eq(Ch5_6BinaryTrees.evaluate(op("-", leaf("2"), leaf("-9"))), 11);
        Check.eq(Ch5_6BinaryTrees.evaluate(op("-", op("-", leaf("10"), leaf("4")), leaf("3"))), 3);
    }

    static Ch5_6BinaryTrees.ExprNode leaf(String token) { return new Ch5_6BinaryTrees.ExprNode(token); }

    static Ch5_6BinaryTrees.ExprNode op(String token, Ch5_6BinaryTrees.ExprNode left, Ch5_6BinaryTrees.ExprNode right) {
        return new Ch5_6BinaryTrees.ExprNode(token, left, right);
    }
}

class Ex5_6_10Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.diameter(Ch5_6BinaryTreesTest.sample()), 5);
        Check.eq(Ch5_6BinaryTrees.diameter(null), 0);
        Check.eq(Ch5_6BinaryTrees.diameter(new Ch5_6BinaryTrees.TreeNode(1)), 0);
        Check.eq(Ch5_6BinaryTrees.diameter(Ch5_6BinaryTreesTest.tree(1, 2, 3)), 2);
        Check.eq(Ch5_6BinaryTrees.diameter(Ch5_6BinaryTreesTest.tree(1, 2, null, 3, 4, 5, null, null, 6)), 4);
    }
}

class Ex5_6_11Test {
    public static void run() {
        Check.yes(Ch5_6BinaryTrees.isBalanced(Ch5_6BinaryTreesTest.sample()));
        Check.no(Ch5_6BinaryTrees.isBalanced(Ch5_6BinaryTreesTest.tree(1, 2, null, 3)));
        Check.yes(Ch5_6BinaryTrees.isBalanced(null));
        Check.no(Ch5_6BinaryTrees.isBalanced(Ch5_6BinaryTreesTest.tree(1, 2, 3, 4, null, null, null, 5)));
        Check.yes(Ch5_6BinaryTrees.isBalanced(Ch5_6BinaryTreesTest.tree(1, 2, 3, 4)));
    }
}

class Ex5_6_12Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.widestLevel(Ch5_6BinaryTreesTest.sample()), 4);
        Check.eq(Ch5_6BinaryTrees.widestLevel(Ch5_6BinaryTreesTest.tree(1, 2, 3, 4, null, null, 5)), 4);
        Check.eq(Ch5_6BinaryTrees.widestLevel(null), 0);
        Check.eq(Ch5_6BinaryTrees.widestLevel(Ch5_6BinaryTreesTest.tree(1, 2, null, 3)), 1);
        Check.eq(Ch5_6BinaryTrees.widestLevel(Ch5_6BinaryTreesTest.tree(1, 2, 3)), 2);
    }
}

class Ex5_6_13Test {
    public static void run() {
        Ch5_6BinaryTrees.TreeNode root = Ch5_6BinaryTreesTest.sample();
        int[][] pairs = {{4, 7}, {7, 6}, {5, 7}, {3, 6}, {4, 4}};
        int[] want = {2, 1, 5, 3, 4};
        for (int i = 0; i < pairs.length; i++) Check.eq(Ch5_6BinaryTrees.lowestCommonAncestor(root, pairs[i][0], pairs[i][1]).value, want[i]);
    }
}

class Ex5_6_14Test {
    public static void run() {
        String text = "1,2,4,#,#,5,7,#,#,#,3,#,6,#,#";
        Check.eq(Ch5_6BinaryTrees.serialize(Ch5_6BinaryTreesTest.sample()), text);
        Check.eq(Ch5_6BinaryTrees.serialize(Ch5_6BinaryTrees.parse(text)), text);
        Check.eq(Ch5_6BinaryTreesTest.inorder(Ch5_6BinaryTrees.parse(text)), Ch5_6BinaryTreesTest.inorder(Ch5_6BinaryTreesTest.sample()));
        Check.eq(Ch5_6BinaryTrees.serialize(null), "#");
        Check.yes(Ch5_6BinaryTrees.parse("#") == null);
        Check.eq(Ch5_6BinaryTrees.serialize(Ch5_6BinaryTrees.parse(Ch5_6BinaryTrees.serialize(Ch5_6BinaryTreesTest.tree(-1, 20)))), "-1,20,#,#,#");
    }
}

class Ex5_6_15Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.verticalColumns(Ch5_6BinaryTreesTest.sample()), List.of(List.of(4), List.of(2, 7), List.of(1, 5), List.of(3), List.of(6)));
        Check.eq(Ch5_6BinaryTrees.verticalColumns(null), List.of());
        Check.eq(Ch5_6BinaryTrees.verticalColumns(Ch5_6BinaryTreesTest.tree(1, 2, 3, null, 4, 5)), List.of(List.of(2), List.of(1, 4, 5), List.of(3)));
    }
}

class Ex5_6_16Test {
    public static void run() {
        Ch5_6BinaryTrees.TreeNode root = Ch5_6BinaryTreesTest.sample();
        Check.eq(Ch5_6BinaryTrees.nodesAtDistance(root, 5, 2), List.of(1, 4));
        Check.eq(Ch5_6BinaryTrees.nodesAtDistance(root, 5, 0), List.of(5));
        Check.eq(Ch5_6BinaryTrees.nodesAtDistance(root, 4, 3), List.of(3, 7));
        Check.eq(Ch5_6BinaryTrees.nodesAtDistance(root, 1, 2), List.of(4, 5, 6));
        Check.eq(Ch5_6BinaryTrees.nodesAtDistance(root, 7, 5), List.of(6));
        Check.eq(Ch5_6BinaryTrees.nodesAtDistance(root, 7, 9), List.of());
    }
}

class Ex5_6_17Test {
    public static void run() {
        Check.eq(Ch5_6BinaryTrees.maxPathSum(Ch5_6BinaryTreesTest.tree(2, -1, 3, 4, -6, null, 5)), 13);
        Check.eq(Ch5_6BinaryTrees.maxPathSum(Ch5_6BinaryTreesTest.tree(-5, -2, -7)), -2);
        Check.eq(Ch5_6BinaryTrees.maxPathSum(new Ch5_6BinaryTrees.TreeNode(7)), 7);
        Check.eq(Ch5_6BinaryTrees.maxPathSum(Ch5_6BinaryTreesTest.sample()), 24);
        Check.eq(Ch5_6BinaryTrees.maxPathSum(Ch5_6BinaryTreesTest.tree(1, -9, -9)), 1);
    }
}

class Ex5_6_18Test {
    public static void run() {
        Ch5_6BinaryTrees.TreeNode root = Ch5_6BinaryTrees.rebuild(new int[] {1, 2, 4, 5, 7, 3, 6}, new int[] {4, 2, 7, 5, 1, 3, 6});
        Check.eq(root.left.right.left.value, 7);
        Check.eq(root.right.right.value, 6);
        Check.yes(Ch5_6BinaryTrees.rebuild(new int[0], new int[0]) == null);
        List<Ch5_6BinaryTrees.TreeNode> trees = List.of(Ch5_6BinaryTreesTest.sample(), Ch5_6BinaryTreesTest.tree(1, 2, null, 3),
                Ch5_6BinaryTreesTest.tree(5, null, 8, 6), new Ch5_6BinaryTrees.TreeNode(4));
        for (Ch5_6BinaryTrees.TreeNode t : trees) {
            List<Integer> pre = Ch5_6BinaryTreesTest.preorder(t), in = Ch5_6BinaryTreesTest.inorder(t);
            Ch5_6BinaryTrees.TreeNode again = Ch5_6BinaryTrees.rebuild(pre.stream().mapToInt(Integer::intValue).toArray(), in.stream().mapToInt(Integer::intValue).toArray());
            Check.eq(Ch5_6BinaryTreesTest.preorder(again), pre);
            Check.eq(Ch5_6BinaryTreesTest.inorder(again), in);
        }
    }
}
