import java.util.ArrayList;
import java.util.List;

/** Chapter 56 tests, one class per exercise. */

final class Ch56BinaryTreesTest {
    private Ch56BinaryTreesTest() {}

    /** Build a tree from level-order values, null for a missing child (children of a missing node are not listed). */
    static Ch56BinaryTrees.TreeNode tree(Integer... values) {
        if (values.length == 0 || values[0] == null) return null;
        Ch56BinaryTrees.TreeNode root = new Ch56BinaryTrees.TreeNode(values[0]);
        List<Ch56BinaryTrees.TreeNode> queue = new ArrayList<>(List.of(root));
        int i = 1;
        for (int q = 0; q < queue.size() && i < values.length; q++) {
            Ch56BinaryTrees.TreeNode node = queue.get(q);
            if (i < values.length && values[i] != null) queue.add(node.left = new Ch56BinaryTrees.TreeNode(values[i]));
            i++;
            if (i < values.length && values[i] != null) queue.add(node.right = new Ch56BinaryTrees.TreeNode(values[i]));
            i++;
        }
        return root;
    }

    /** 1(2(4, 5(7)), 3(-, 6)), used by most tests. */
    static Ch56BinaryTrees.TreeNode sample() { return tree(1, 2, 3, 4, 5, null, 6, null, null, 7); }

    static List<Integer> inorder(Ch56BinaryTrees.TreeNode node) {
        List<Integer> out = new ArrayList<>();
        if (node != null) {
            out.addAll(inorder(node.left));
            out.add(node.value);
            out.addAll(inorder(node.right));
        }
        return out;
    }

    static List<Integer> preorder(Ch56BinaryTrees.TreeNode node) {
        List<Integer> out = new ArrayList<>();
        if (node != null) {
            out.add(node.value);
            out.addAll(preorder(node.left));
            out.addAll(preorder(node.right));
        }
        return out;
    }
}

class Ex56_1Test {
    public static void run() {
        Ch56BinaryTrees.TreeNode root = Ch56BinaryTreesTest.sample();
        int[] targets = {10, 15, 7, 8, 3};
        boolean[] want = {true, true, true, false, false};
        for (int i = 0; i < targets.length; i++) Check.eq(Ch56BinaryTrees.hasPathSum(root, targets[i]), want[i]);
        Check.no(Ch56BinaryTrees.hasPathSum(null, 0));
        Check.yes(Ch56BinaryTrees.hasPathSum(new Ch56BinaryTrees.TreeNode(5), 5));
    }
}

class Ex56_2Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.totalDepth(Ch56BinaryTreesTest.sample()), 11);
        Check.eq(Ch56BinaryTrees.totalDepth(null), 0);
        Check.eq(Ch56BinaryTrees.totalDepth(new Ch56BinaryTrees.TreeNode(1)), 0);
        Check.eq(Ch56BinaryTrees.totalDepth(Ch56BinaryTreesTest.tree(1, 2, null, 3)), 3);
        Check.eq(Ch56BinaryTrees.totalDepth(Ch56BinaryTreesTest.tree(1, 2, 3, 4, 5, 6, 7)), 10);
    }
}

class Ex56_3Test {
    public static void run() {
        Ch56BinaryTrees.TreeNode root = Ch56BinaryTreesTest.sample();
        Check.yes(Ch56BinaryTrees.mirror(root) == root);
        Check.eq(Ch56BinaryTreesTest.inorder(root), List.of(6, 3, 1, 5, 7, 2, 4));
        Check.eq(root.left.value, 3);
        Check.yes(Ch56BinaryTrees.mirror(null) == null);
    }
}

class Ex56_4Test {
    public static void run() {
        Check.yes(Ch56BinaryTrees.isSymmetric(Ch56BinaryTreesTest.tree(1, 2, 2, 3, 4, 4, 3)));
        Check.no(Ch56BinaryTrees.isSymmetric(Ch56BinaryTreesTest.tree(1, 2, 2, null, 3, null, 3)));
        Check.yes(Ch56BinaryTrees.isSymmetric(null));
        Check.yes(Ch56BinaryTrees.isSymmetric(new Ch56BinaryTrees.TreeNode(1)));
        Check.no(Ch56BinaryTrees.isSymmetric(Ch56BinaryTreesTest.tree(1, 2, 3)));
        Check.no(Ch56BinaryTrees.isSymmetric(Ch56BinaryTreesTest.sample()));
    }
}

class Ex56_5Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.rightView(Ch56BinaryTreesTest.sample()), List.of(1, 3, 6, 7));
        Check.eq(Ch56BinaryTrees.rightView(Ch56BinaryTreesTest.tree(1, 2, 3, 4)), List.of(1, 3, 4));
        Check.eq(Ch56BinaryTrees.rightView(null), List.of());
    }
}

class Ex56_6Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.levelAverages(Ch56BinaryTreesTest.sample()), List.of(1.0, 2.5, 5.0, 7.0));
        Check.eq(Ch56BinaryTrees.levelAverages(null), List.of());
        Check.eq(Ch56BinaryTrees.levelAverages(Ch56BinaryTreesTest.tree(3, -1, 2)), List.of(3.0, 0.5));
    }
}

class Ex56_7Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.leafPaths(Ch56BinaryTreesTest.sample()), List.of(List.of(1, 2, 4), List.of(1, 2, 5, 7), List.of(1, 3, 6)));
        Check.eq(Ch56BinaryTrees.leafPaths(null), List.of());
        Check.eq(Ch56BinaryTrees.leafPaths(new Ch56BinaryTrees.TreeNode(9)), List.of(List.of(9)));
    }
}

class Ex56_8Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.inorderIterative(Ch56BinaryTreesTest.sample()), List.of(4, 2, 7, 5, 1, 3, 6));
        Check.eq(Ch56BinaryTrees.inorderIterative(null), List.of());
        Check.eq(Ch56BinaryTrees.inorderIterative(Ch56BinaryTreesTest.tree(1, 2, null, 3, null, 4)), List.of(4, 3, 2, 1));
    }
}

class Ex56_9Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.evaluate(op("*", op("+", leaf("3"), leaf("4")), op("-", leaf("5"), leaf("2")))), 21);
        Check.eq(Ch56BinaryTrees.evaluate(leaf("7")), 7);
        Check.eq(Ch56BinaryTrees.evaluate(op("-", leaf("2"), leaf("-9"))), 11);
        Check.eq(Ch56BinaryTrees.evaluate(op("-", op("-", leaf("10"), leaf("4")), leaf("3"))), 3);
    }

    static Ch56BinaryTrees.ExprNode leaf(String token) { return new Ch56BinaryTrees.ExprNode(token); }

    static Ch56BinaryTrees.ExprNode op(String token, Ch56BinaryTrees.ExprNode left, Ch56BinaryTrees.ExprNode right) {
        return new Ch56BinaryTrees.ExprNode(token, left, right);
    }
}

class Ex56_10Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.diameter(Ch56BinaryTreesTest.sample()), 5);
        Check.eq(Ch56BinaryTrees.diameter(null), 0);
        Check.eq(Ch56BinaryTrees.diameter(new Ch56BinaryTrees.TreeNode(1)), 0);
        Check.eq(Ch56BinaryTrees.diameter(Ch56BinaryTreesTest.tree(1, 2, 3)), 2);
        Check.eq(Ch56BinaryTrees.diameter(Ch56BinaryTreesTest.tree(1, 2, null, 3, 4, 5, null, null, 6)), 4);
    }
}

class Ex56_11Test {
    public static void run() {
        Check.yes(Ch56BinaryTrees.isBalanced(Ch56BinaryTreesTest.sample()));
        Check.no(Ch56BinaryTrees.isBalanced(Ch56BinaryTreesTest.tree(1, 2, null, 3)));
        Check.yes(Ch56BinaryTrees.isBalanced(null));
        Check.no(Ch56BinaryTrees.isBalanced(Ch56BinaryTreesTest.tree(1, 2, 3, 4, null, null, null, 5)));
        Check.yes(Ch56BinaryTrees.isBalanced(Ch56BinaryTreesTest.tree(1, 2, 3, 4)));
    }
}

class Ex56_12Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.widestLevel(Ch56BinaryTreesTest.sample()), 4);
        Check.eq(Ch56BinaryTrees.widestLevel(Ch56BinaryTreesTest.tree(1, 2, 3, 4, null, null, 5)), 4);
        Check.eq(Ch56BinaryTrees.widestLevel(null), 0);
        Check.eq(Ch56BinaryTrees.widestLevel(Ch56BinaryTreesTest.tree(1, 2, null, 3)), 1);
        Check.eq(Ch56BinaryTrees.widestLevel(Ch56BinaryTreesTest.tree(1, 2, 3)), 2);
    }
}

class Ex56_13Test {
    public static void run() {
        Ch56BinaryTrees.TreeNode root = Ch56BinaryTreesTest.sample();
        int[][] pairs = {{4, 7}, {7, 6}, {5, 7}, {3, 6}, {4, 4}};
        int[] want = {2, 1, 5, 3, 4};
        for (int i = 0; i < pairs.length; i++) Check.eq(Ch56BinaryTrees.lowestCommonAncestor(root, pairs[i][0], pairs[i][1]).value, want[i]);
    }
}

class Ex56_14Test {
    public static void run() {
        String text = "1,2,4,#,#,5,7,#,#,#,3,#,6,#,#";
        Check.eq(Ch56BinaryTrees.serialize(Ch56BinaryTreesTest.sample()), text);
        Check.eq(Ch56BinaryTrees.serialize(Ch56BinaryTrees.parse(text)), text);
        Check.eq(Ch56BinaryTreesTest.inorder(Ch56BinaryTrees.parse(text)), Ch56BinaryTreesTest.inorder(Ch56BinaryTreesTest.sample()));
        Check.eq(Ch56BinaryTrees.serialize(null), "#");
        Check.yes(Ch56BinaryTrees.parse("#") == null);
        Check.eq(Ch56BinaryTrees.serialize(Ch56BinaryTrees.parse(Ch56BinaryTrees.serialize(Ch56BinaryTreesTest.tree(-1, 20)))), "-1,20,#,#,#");
    }
}

class Ex56_15Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.verticalColumns(Ch56BinaryTreesTest.sample()), List.of(List.of(4), List.of(2, 7), List.of(1, 5), List.of(3), List.of(6)));
        Check.eq(Ch56BinaryTrees.verticalColumns(null), List.of());
        Check.eq(Ch56BinaryTrees.verticalColumns(Ch56BinaryTreesTest.tree(1, 2, 3, null, 4, 5)), List.of(List.of(2), List.of(1, 4, 5), List.of(3)));
    }
}

class Ex56_16Test {
    public static void run() {
        Ch56BinaryTrees.TreeNode root = Ch56BinaryTreesTest.sample();
        Check.eq(Ch56BinaryTrees.nodesAtDistance(root, 5, 2), List.of(1, 4));
        Check.eq(Ch56BinaryTrees.nodesAtDistance(root, 5, 0), List.of(5));
        Check.eq(Ch56BinaryTrees.nodesAtDistance(root, 4, 3), List.of(3, 7));
        Check.eq(Ch56BinaryTrees.nodesAtDistance(root, 1, 2), List.of(4, 5, 6));
        Check.eq(Ch56BinaryTrees.nodesAtDistance(root, 7, 5), List.of(6));
        Check.eq(Ch56BinaryTrees.nodesAtDistance(root, 7, 9), List.of());
    }
}

class Ex56_17Test {
    public static void run() {
        Check.eq(Ch56BinaryTrees.maxPathSum(Ch56BinaryTreesTest.tree(2, -1, 3, 4, -6, null, 5)), 13);
        Check.eq(Ch56BinaryTrees.maxPathSum(Ch56BinaryTreesTest.tree(-5, -2, -7)), -2);
        Check.eq(Ch56BinaryTrees.maxPathSum(new Ch56BinaryTrees.TreeNode(7)), 7);
        Check.eq(Ch56BinaryTrees.maxPathSum(Ch56BinaryTreesTest.sample()), 24);
        Check.eq(Ch56BinaryTrees.maxPathSum(Ch56BinaryTreesTest.tree(1, -9, -9)), 1);
    }
}

class Ex56_18Test {
    public static void run() {
        Ch56BinaryTrees.TreeNode root = Ch56BinaryTrees.rebuild(new int[] {1, 2, 4, 5, 7, 3, 6}, new int[] {4, 2, 7, 5, 1, 3, 6});
        Check.eq(root.left.right.left.value, 7);
        Check.eq(root.right.right.value, 6);
        Check.yes(Ch56BinaryTrees.rebuild(new int[0], new int[0]) == null);
        List<Ch56BinaryTrees.TreeNode> trees = List.of(Ch56BinaryTreesTest.sample(), Ch56BinaryTreesTest.tree(1, 2, null, 3),
                Ch56BinaryTreesTest.tree(5, null, 8, 6), new Ch56BinaryTrees.TreeNode(4));
        for (Ch56BinaryTrees.TreeNode t : trees) {
            List<Integer> pre = Ch56BinaryTreesTest.preorder(t), in = Ch56BinaryTreesTest.inorder(t);
            Ch56BinaryTrees.TreeNode again = Ch56BinaryTrees.rebuild(pre.stream().mapToInt(Integer::intValue).toArray(), in.stream().mapToInt(Integer::intValue).toArray());
            Check.eq(Ch56BinaryTreesTest.preorder(again), pre);
            Check.eq(Ch56BinaryTreesTest.inorder(again), in);
        }
    }
}
