import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/** Chapter 5.1 tests, one class per exercise. */

final class Ch5_1BinarySearchTreesTest {
    private Ch5_1BinarySearchTreesTest() {}

    /** 50 -> (25 -> 10, 33), 75, built by hand so tests don't depend on insert. */
    static Ch5_1BinarySearchTrees.TreeNode sampleTree() {
        return new Ch5_1BinarySearchTrees.TreeNode(50,
                new Ch5_1BinarySearchTrees.TreeNode(25, new Ch5_1BinarySearchTrees.TreeNode(10), new Ch5_1BinarySearchTrees.TreeNode(33)),
                new Ch5_1BinarySearchTrees.TreeNode(75));
    }

    static Ch5_1BinarySearchTrees.TreeNode grow(int... values) {
        Ch5_1BinarySearchTrees.TreeNode root = null;
        for (int v : values) root = Ch5_1BinarySearchTrees.insert(root, v);
        return root;
    }
}

class Ex5_1_1Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = Ch5_1BinarySearchTreesTest.sampleTree();
        Check.eq(Ch5_1BinarySearchTrees.search(root, 33).value, 33);
        Check.eq(Ch5_1BinarySearchTrees.search(root, 40), null);
        Check.eq(Ch5_1BinarySearchTrees.search(null, 1), null);
    }
}

class Ex5_1_2Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode r = Ch5_1BinarySearchTreesTest.grow(50, 25, 75, 10, 33);
        Check.eq(r.value, 50);
        Check.eq(r.left.value, 25);
        Check.eq(r.right.value, 75);
        Check.eq(r.left.left.value, 10);
        Check.eq(r.left.right.value, 33);
    }
}

class Ex5_1_3Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode r = Ch5_1BinarySearchTreesTest.grow(50, 25, 75, 61, 89, 52);
        r = Ch5_1BinarySearchTrees.delete(r, 50);
        Check.eq(r.value, 52);
        Check.eq(Ch5_1BinarySearchTrees.inorder(r), List.of(25, 52, 61, 75, 89));
        r = Ch5_1BinarySearchTrees.delete(r, 25);
        r = Ch5_1BinarySearchTrees.delete(r, 89);
        r = Ch5_1BinarySearchTrees.delete(r, 1000);
        Check.eq(Ch5_1BinarySearchTrees.inorder(r), List.of(52, 61, 75));
        Random rng = new Random(1);
        for (int trial = 0; trial < 100; trial++) {
            List<Integer> vals = new java.util.ArrayList<>();
            while (vals.size() < 30) {
                int v = rng.nextInt(200);
                if (!vals.contains(v)) vals.add(v);
            }
            Ch5_1BinarySearchTrees.TreeNode t = null;
            for (int v : vals) t = Ch5_1BinarySearchTrees.insert(t, v);
            for (int i = 0; i < 15; i++) {
                Integer v = vals.remove(rng.nextInt(vals.size()));
                t = Ch5_1BinarySearchTrees.delete(t, v);
            }
            Check.eq(Ch5_1BinarySearchTrees.inorder(t), vals.stream().sorted().toList());
        }
    }
}

class Ex5_1_4Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = Ch5_1BinarySearchTreesTest.sampleTree();
        Check.eq(Ch5_1BinarySearchTrees.inorder(root), List.of(10, 25, 33, 50, 75));
        Check.eq(Ch5_1BinarySearchTrees.preorder(root), List.of(50, 25, 10, 33, 75));
        Check.eq(Ch5_1BinarySearchTrees.postorder(root), List.of(10, 33, 25, 75, 50));
        Check.eq(Ch5_1BinarySearchTrees.inorder(null), List.of());
    }
}

class Ex5_1_5Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = Ch5_1BinarySearchTreesTest.sampleTree();
        Check.eq(Ch5_1BinarySearchTrees.findMin(root), 10);
        Check.eq(Ch5_1BinarySearchTrees.findMax(root), 75);
        Check.eq(Ch5_1BinarySearchTrees.findMin(null), null);
    }
}

class Ex5_1_6Test {
    public static void run() {
        Check.eq(Ch5_1BinarySearchTrees.height(Ch5_1BinarySearchTreesTest.grow(50, 25, 75, 10)), 3);
        Check.eq(Ch5_1BinarySearchTrees.height(Ch5_1BinarySearchTreesTest.grow(1, 2, 3, 4)), 4);
        Check.eq(Ch5_1BinarySearchTrees.height(null), 0);
    }
}

class Ex5_1_7Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = Ch5_1BinarySearchTrees.buildBst(50, 25, 75, 10, 33);
        Check.eq(root.value, 50);
        Check.eq(Ch5_1BinarySearchTrees.inorder(root), List.of(10, 25, 33, 50, 75));
        Check.eq(Ch5_1BinarySearchTrees.treeSort(5, 3, 8, 1, 4), List.of(1, 3, 4, 5, 8));
    }
}

class Ex5_1_8Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode bad = new Ch5_1BinarySearchTrees.TreeNode(10,
                new Ch5_1BinarySearchTrees.TreeNode(5, null, new Ch5_1BinarySearchTrees.TreeNode(12)), new Ch5_1BinarySearchTrees.TreeNode(15));
        Check.no(Ch5_1BinarySearchTrees.isValidBst(bad, Long.MIN_VALUE, Long.MAX_VALUE));
        Check.yes(Ch5_1BinarySearchTrees.isValidBst(Ch5_1BinarySearchTreesTest.sampleTree(), Long.MIN_VALUE, Long.MAX_VALUE));
        Ch5_1BinarySearchTrees.TreeNode extremes = new Ch5_1BinarySearchTrees.TreeNode(Integer.MIN_VALUE, null,
                new Ch5_1BinarySearchTrees.TreeNode(Integer.MAX_VALUE));
        Check.yes(Ch5_1BinarySearchTrees.isValidBst(extremes, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}

class Ex5_1_9Test {
    public static void run() {
        Check.eq(Ch5_1BinarySearchTrees.levelOrder(Ch5_1BinarySearchTreesTest.sampleTree()),
                List.of(List.of(50), List.of(25, 75), List.of(10, 33)));
        Check.eq(Ch5_1BinarySearchTrees.levelOrder(null), List.of());
    }
}

class Ex5_1_10Test {
    public static void run() {
        Check.eq(Ch5_1BinarySearchTrees.countNodes(Ch5_1BinarySearchTreesTest.sampleTree()), 5);
        Check.eq(Ch5_1BinarySearchTrees.countNodes(null), 0);
    }
}

class Ex5_1_11Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = Ch5_1BinarySearchTreesTest.grow(50, 25, 75, 10, 33);
        int[] targets = {30, 60, 29, 100, 0, 50}, want = {33, 50, 25, 75, 10, 50};
        for (int i = 0; i < targets.length; i++) Check.eq(Ch5_1BinarySearchTrees.closestValue(root, targets[i]), want[i]);
    }
}

class Ex5_1_12Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = Ch5_1BinarySearchTrees.balancedBst(new int[] {1, 2, 3, 4, 5, 6, 7});
        Check.eq(new int[] {root.value, root.left.value, root.right.value}, new int[] {4, 2, 6});
        Check.eq(Ch5_1BinarySearchTrees.height(root), 3);
        Ch5_1BinarySearchTrees.TreeNode ten = Ch5_1BinarySearchTrees.balancedBst(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        Check.eq(Ch5_1BinarySearchTrees.inorder(ten), List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Check.eq(Ch5_1BinarySearchTrees.height(ten), 4);
        Check.yes(Ch5_1BinarySearchTrees.balancedBst(new int[0]) == null);
    }
}

class Ex5_1_13Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = Ch5_1BinarySearchTreesTest.grow(50, 25, 75, 10, 33);
        int[] want = {75, 50, 33, 25, 10};
        for (int k = 1; k <= 5; k++) Check.eq(Ch5_1BinarySearchTrees.kthLargest(root, k), want[k - 1]);
        Check.eq(Ch5_1BinarySearchTrees.kthLargest(new Ch5_1BinarySearchTrees.TreeNode(7), 1), 7);
    }
}

class Ex5_1_14Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = Ch5_1BinarySearchTrees.bstFromPreorder(new int[] {40, 20, 10, 30, 60, 70});
        Check.eq(new int[] {root.value, root.left.value, root.left.left.value, root.left.right.value}, new int[] {40, 20, 10, 30});
        Check.eq(root.right.value, 60);
        Check.yes(root.right.left == null);
        Check.eq(root.right.right.value, 70);
        int[][] cases = {{40, 20, 10, 30, 60, 70}, {5, 4, 3, 2, 1}, {1, 2, 3}, {8, 3, 1, 6, 4, 7, 10, 14, 13}};
        for (int[] values : cases) {
            root = Ch5_1BinarySearchTrees.bstFromPreorder(values);
            Check.eq(Ch5_1BinarySearchTrees.preorder(root), Arrays.stream(values).boxed().toList());
            Check.eq(Ch5_1BinarySearchTrees.inorder(root), Arrays.stream(values).sorted().boxed().toList());
        }
        Check.yes(Ch5_1BinarySearchTrees.bstFromPreorder(new int[0]) == null);
    }
}

class Ex5_1_15Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = Ch5_1BinarySearchTreesTest.grow(50, 25, 75, 10, 33);
        Check.eq(Ch5_1BinarySearchTrees.successor(root, 10), 25);
        Check.eq(Ch5_1BinarySearchTrees.successor(root, 25), 33);
        Check.eq(Ch5_1BinarySearchTrees.successor(root, 33), 50);
        Check.eq(Ch5_1BinarySearchTrees.successor(root, 50), 75);
        Check.eq(Ch5_1BinarySearchTrees.successor(root, 75), null);
        Check.eq(Ch5_1BinarySearchTrees.successor(root, 40), 50);
        Check.eq(Ch5_1BinarySearchTrees.successor(root, 0), 10);
        Check.eq(Ch5_1BinarySearchTrees.successor(null, 3), null);
    }
}

class Ex5_1_16Test {
    public static void run() {
        Ch5_1BinarySearchTrees.TreeNode root = new Ch5_1BinarySearchTrees.TreeNode(50,
                new Ch5_1BinarySearchTrees.TreeNode(75, new Ch5_1BinarySearchTrees.TreeNode(10), new Ch5_1BinarySearchTrees.TreeNode(33)),
                new Ch5_1BinarySearchTrees.TreeNode(25));
        Ch5_1BinarySearchTrees.repairSwapped(root);
        Check.eq(new int[] {root.left.value, root.right.value}, new int[] {25, 75});
        int[][] swaps = {{10, 33}, {50, 52}, {10, 89}, {61, 75}};
        for (int[] s : swaps) {
            root = Ch5_1BinarySearchTreesTest.grow(50, 25, 75, 61, 89, 52, 10, 33);
            Ch5_1BinarySearchTrees.TreeNode x = Ch5_1BinarySearchTrees.search(root, s[0]), y = Ch5_1BinarySearchTrees.search(root, s[1]);
            x.value = s[1];
            y.value = s[0];
            Ch5_1BinarySearchTrees.repairSwapped(root);
            Check.eq(Ch5_1BinarySearchTrees.inorder(root), List.of(10, 25, 33, 50, 52, 61, 75, 89));
            Check.yes(Ch5_1BinarySearchTrees.isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE));
        }
    }
}
