import java.util.List;
import java.util.Random;

/** Chapter 15 tests, one class per exercise. */
final class Ch15BinarySearchTreesTest {
    private Ch15BinarySearchTreesTest() {}

    /** 50 -> (25 -> 10, 33), 75, built by hand so tests don't depend on insert. */
    static Ch15BinarySearchTrees.TreeNode sampleTree() {
        return new Ch15BinarySearchTrees.TreeNode(50,
                new Ch15BinarySearchTrees.TreeNode(25, new Ch15BinarySearchTrees.TreeNode(10), new Ch15BinarySearchTrees.TreeNode(33)),
                new Ch15BinarySearchTrees.TreeNode(75));
    }

    static Ch15BinarySearchTrees.TreeNode grow(int... values) {
        Ch15BinarySearchTrees.TreeNode root = null;
        for (int v : values) root = Ch15BinarySearchTrees.insert(root, v);
        return root;
    }
}

class Ex15_1Test {
    public static void run() {
        Ch15BinarySearchTrees.TreeNode root = Ch15BinarySearchTreesTest.sampleTree();
        Check.eq(Ch15BinarySearchTrees.search(root, 33).value, 33);
        Check.eq(Ch15BinarySearchTrees.search(root, 40), null);
        Check.eq(Ch15BinarySearchTrees.search(null, 1), null);
    }
}

class Ex15_2Test {
    public static void run() {
        Ch15BinarySearchTrees.TreeNode r = Ch15BinarySearchTreesTest.grow(50, 25, 75, 10, 33);
        Check.eq(r.value, 50);
        Check.eq(r.left.value, 25);
        Check.eq(r.right.value, 75);
        Check.eq(r.left.left.value, 10);
        Check.eq(r.left.right.value, 33);
    }
}

class Ex15_3Test {
    public static void run() {
        Ch15BinarySearchTrees.TreeNode r = Ch15BinarySearchTreesTest.grow(50, 25, 75, 61, 89, 52);
        r = Ch15BinarySearchTrees.delete(r, 50);
        Check.eq(r.value, 52);
        Check.eq(Ch15BinarySearchTrees.inorder(r), List.of(25, 52, 61, 75, 89));
        r = Ch15BinarySearchTrees.delete(r, 25);
        r = Ch15BinarySearchTrees.delete(r, 89);
        r = Ch15BinarySearchTrees.delete(r, 1000);
        Check.eq(Ch15BinarySearchTrees.inorder(r), List.of(52, 61, 75));
        Random rng = new Random(1);
        for (int trial = 0; trial < 100; trial++) {
            List<Integer> vals = new java.util.ArrayList<>();
            while (vals.size() < 30) {
                int v = rng.nextInt(200);
                if (!vals.contains(v)) vals.add(v);
            }
            Ch15BinarySearchTrees.TreeNode t = null;
            for (int v : vals) t = Ch15BinarySearchTrees.insert(t, v);
            for (int i = 0; i < 15; i++) {
                Integer v = vals.remove(rng.nextInt(vals.size()));
                t = Ch15BinarySearchTrees.delete(t, v);
            }
            Check.eq(Ch15BinarySearchTrees.inorder(t), vals.stream().sorted().toList());
        }
    }
}

class Ex15_4Test {
    public static void run() {
        Ch15BinarySearchTrees.TreeNode root = Ch15BinarySearchTreesTest.sampleTree();
        Check.eq(Ch15BinarySearchTrees.inorder(root), List.of(10, 25, 33, 50, 75));
        Check.eq(Ch15BinarySearchTrees.preorder(root), List.of(50, 25, 10, 33, 75));
        Check.eq(Ch15BinarySearchTrees.postorder(root), List.of(10, 33, 25, 75, 50));
        Check.eq(Ch15BinarySearchTrees.inorder(null), List.of());
    }
}

class Ex15_5Test {
    public static void run() {
        Ch15BinarySearchTrees.TreeNode root = Ch15BinarySearchTreesTest.sampleTree();
        Check.eq(Ch15BinarySearchTrees.findMin(root), 10);
        Check.eq(Ch15BinarySearchTrees.findMax(root), 75);
        Check.eq(Ch15BinarySearchTrees.findMin(null), null);
    }
}

class Ex15_6Test {
    public static void run() {
        Check.eq(Ch15BinarySearchTrees.height(Ch15BinarySearchTreesTest.grow(50, 25, 75, 10)), 3);
        Check.eq(Ch15BinarySearchTrees.height(Ch15BinarySearchTreesTest.grow(1, 2, 3, 4)), 4);
        Check.eq(Ch15BinarySearchTrees.height(null), 0);
    }
}

class Ex15_7Test {
    public static void run() {
        Ch15BinarySearchTrees.TreeNode root = Ch15BinarySearchTrees.buildBst(50, 25, 75, 10, 33);
        Check.eq(root.value, 50);
        Check.eq(Ch15BinarySearchTrees.inorder(root), List.of(10, 25, 33, 50, 75));
        Check.eq(Ch15BinarySearchTrees.treeSort(5, 3, 8, 1, 4), List.of(1, 3, 4, 5, 8));
    }
}

class Ex15_8Test {
    public static void run() {
        Ch15BinarySearchTrees.TreeNode bad = new Ch15BinarySearchTrees.TreeNode(10,
                new Ch15BinarySearchTrees.TreeNode(5, null, new Ch15BinarySearchTrees.TreeNode(12)), new Ch15BinarySearchTrees.TreeNode(15));
        Check.no(Ch15BinarySearchTrees.isValidBst(bad, Long.MIN_VALUE, Long.MAX_VALUE));
        Check.yes(Ch15BinarySearchTrees.isValidBst(Ch15BinarySearchTreesTest.sampleTree(), Long.MIN_VALUE, Long.MAX_VALUE));
        Ch15BinarySearchTrees.TreeNode extremes = new Ch15BinarySearchTrees.TreeNode(Integer.MIN_VALUE, null,
                new Ch15BinarySearchTrees.TreeNode(Integer.MAX_VALUE));
        Check.yes(Ch15BinarySearchTrees.isValidBst(extremes, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}

class Ex15_9Test {
    public static void run() {
        Check.eq(Ch15BinarySearchTrees.levelOrder(Ch15BinarySearchTreesTest.sampleTree()),
                List.of(List.of(50), List.of(25, 75), List.of(10, 33)));
        Check.eq(Ch15BinarySearchTrees.levelOrder(null), List.of());
    }
}

class Ex15_10Test {
    public static void run() {
        Check.eq(Ch15BinarySearchTrees.countNodes(Ch15BinarySearchTreesTest.sampleTree()), 5);
        Check.eq(Ch15BinarySearchTrees.countNodes(null), 0);
    }
}
