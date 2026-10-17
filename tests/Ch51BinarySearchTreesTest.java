import java.util.List;
import java.util.Random;

/** Chapter 51 tests, one class per exercise. */

final class Ch51BinarySearchTreesTest {
    private Ch51BinarySearchTreesTest() {}

    /** 50 -> (25 -> 10, 33), 75, built by hand so tests don't depend on insert. */
    static Ch51BinarySearchTrees.TreeNode sampleTree() {
        return new Ch51BinarySearchTrees.TreeNode(50,
                new Ch51BinarySearchTrees.TreeNode(25, new Ch51BinarySearchTrees.TreeNode(10), new Ch51BinarySearchTrees.TreeNode(33)),
                new Ch51BinarySearchTrees.TreeNode(75));
    }

    static Ch51BinarySearchTrees.TreeNode grow(int... values) {
        Ch51BinarySearchTrees.TreeNode root = null;
        for (int v : values) root = Ch51BinarySearchTrees.insert(root, v);
        return root;
    }
}

class Ex51_1Test {
    public static void run() {
        Ch51BinarySearchTrees.TreeNode root = Ch51BinarySearchTreesTest.sampleTree();
        Check.eq(Ch51BinarySearchTrees.search(root, 33).value, 33);
        Check.eq(Ch51BinarySearchTrees.search(root, 40), null);
        Check.eq(Ch51BinarySearchTrees.search(null, 1), null);
    }
}

class Ex51_2Test {
    public static void run() {
        Ch51BinarySearchTrees.TreeNode r = Ch51BinarySearchTreesTest.grow(50, 25, 75, 10, 33);
        Check.eq(r.value, 50);
        Check.eq(r.left.value, 25);
        Check.eq(r.right.value, 75);
        Check.eq(r.left.left.value, 10);
        Check.eq(r.left.right.value, 33);
    }
}

class Ex51_3Test {
    public static void run() {
        Ch51BinarySearchTrees.TreeNode r = Ch51BinarySearchTreesTest.grow(50, 25, 75, 61, 89, 52);
        r = Ch51BinarySearchTrees.delete(r, 50);
        Check.eq(r.value, 52);
        Check.eq(Ch51BinarySearchTrees.inorder(r), List.of(25, 52, 61, 75, 89));
        r = Ch51BinarySearchTrees.delete(r, 25);
        r = Ch51BinarySearchTrees.delete(r, 89);
        r = Ch51BinarySearchTrees.delete(r, 1000);
        Check.eq(Ch51BinarySearchTrees.inorder(r), List.of(52, 61, 75));
        Random rng = new Random(1);
        for (int trial = 0; trial < 100; trial++) {
            List<Integer> vals = new java.util.ArrayList<>();
            while (vals.size() < 30) {
                int v = rng.nextInt(200);
                if (!vals.contains(v)) vals.add(v);
            }
            Ch51BinarySearchTrees.TreeNode t = null;
            for (int v : vals) t = Ch51BinarySearchTrees.insert(t, v);
            for (int i = 0; i < 15; i++) {
                Integer v = vals.remove(rng.nextInt(vals.size()));
                t = Ch51BinarySearchTrees.delete(t, v);
            }
            Check.eq(Ch51BinarySearchTrees.inorder(t), vals.stream().sorted().toList());
        }
    }
}

class Ex51_4Test {
    public static void run() {
        Ch51BinarySearchTrees.TreeNode root = Ch51BinarySearchTreesTest.sampleTree();
        Check.eq(Ch51BinarySearchTrees.inorder(root), List.of(10, 25, 33, 50, 75));
        Check.eq(Ch51BinarySearchTrees.preorder(root), List.of(50, 25, 10, 33, 75));
        Check.eq(Ch51BinarySearchTrees.postorder(root), List.of(10, 33, 25, 75, 50));
        Check.eq(Ch51BinarySearchTrees.inorder(null), List.of());
    }
}

class Ex51_5Test {
    public static void run() {
        Ch51BinarySearchTrees.TreeNode root = Ch51BinarySearchTreesTest.sampleTree();
        Check.eq(Ch51BinarySearchTrees.findMin(root), 10);
        Check.eq(Ch51BinarySearchTrees.findMax(root), 75);
        Check.eq(Ch51BinarySearchTrees.findMin(null), null);
    }
}

class Ex51_6Test {
    public static void run() {
        Check.eq(Ch51BinarySearchTrees.height(Ch51BinarySearchTreesTest.grow(50, 25, 75, 10)), 3);
        Check.eq(Ch51BinarySearchTrees.height(Ch51BinarySearchTreesTest.grow(1, 2, 3, 4)), 4);
        Check.eq(Ch51BinarySearchTrees.height(null), 0);
    }
}

class Ex51_7Test {
    public static void run() {
        Ch51BinarySearchTrees.TreeNode root = Ch51BinarySearchTrees.buildBst(50, 25, 75, 10, 33);
        Check.eq(root.value, 50);
        Check.eq(Ch51BinarySearchTrees.inorder(root), List.of(10, 25, 33, 50, 75));
        Check.eq(Ch51BinarySearchTrees.treeSort(5, 3, 8, 1, 4), List.of(1, 3, 4, 5, 8));
    }
}

class Ex51_8Test {
    public static void run() {
        Ch51BinarySearchTrees.TreeNode bad = new Ch51BinarySearchTrees.TreeNode(10,
                new Ch51BinarySearchTrees.TreeNode(5, null, new Ch51BinarySearchTrees.TreeNode(12)), new Ch51BinarySearchTrees.TreeNode(15));
        Check.no(Ch51BinarySearchTrees.isValidBst(bad, Long.MIN_VALUE, Long.MAX_VALUE));
        Check.yes(Ch51BinarySearchTrees.isValidBst(Ch51BinarySearchTreesTest.sampleTree(), Long.MIN_VALUE, Long.MAX_VALUE));
        Ch51BinarySearchTrees.TreeNode extremes = new Ch51BinarySearchTrees.TreeNode(Integer.MIN_VALUE, null,
                new Ch51BinarySearchTrees.TreeNode(Integer.MAX_VALUE));
        Check.yes(Ch51BinarySearchTrees.isValidBst(extremes, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}

class Ex51_9Test {
    public static void run() {
        Check.eq(Ch51BinarySearchTrees.levelOrder(Ch51BinarySearchTreesTest.sampleTree()),
                List.of(List.of(50), List.of(25, 75), List.of(10, 33)));
        Check.eq(Ch51BinarySearchTrees.levelOrder(null), List.of());
    }
}

class Ex51_10Test {
    public static void run() {
        Check.eq(Ch51BinarySearchTrees.countNodes(Ch51BinarySearchTreesTest.sampleTree()), 5);
        Check.eq(Ch51BinarySearchTrees.countNodes(null), 0);
    }
}
