import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;

/** Chapter 5.4 tests, one class per exercise. */

final class Ch5_4BalancedTreesTest {
    private Ch5_4BalancedTreesTest() {}

    static Ch5_4BalancedTrees.RedBlackTree tree(int... keys) {
        Ch5_4BalancedTrees.RedBlackTree t = new Ch5_4BalancedTrees.RedBlackTree();
        for (int k : keys) t.insert(k);
        return t;
    }


    static Ch5_4BalancedTrees.TreapNode treap(int n, Random rng) {
        Ch5_4BalancedTrees.TreapNode root = null;
        for (int k = 0; k < n; k++) root = Ch5_4BalancedTrees.treapInsert(root, k, rng);
        return root;
    }

    /** In-order keys, written here so tests before 5.4.13 don't depend on its inorder. */
    static List<Integer> keys(Ch5_4BalancedTrees.TreapNode node) {
        List<Integer> out = new ArrayList<>();
        if (node != null) {
            out.addAll(keys(node.left));
            out.add(node.key);
            out.addAll(keys(node.right));
        }
        return out;
    }

    static List<Integer> range(int lo, int hi) {
        return IntStream.range(lo, hi).boxed().toList();
    }
}

class Ex5_4_1Test {
    public static void run() {
        Ch5_4BalancedTrees.RedBlackTree t = new Ch5_4BalancedTrees.RedBlackTree();
        Check.yes(t.root == t.NIL);
        Check.no(t.NIL.red);
        Ch5_4BalancedTrees.RBNode x = new Ch5_4BalancedTrees.RBNode(2, false, t.NIL), a = new Ch5_4BalancedTrees.RBNode(1, true, t.NIL),
                y = new Ch5_4BalancedTrees.RBNode(4, true, t.NIL), b = new Ch5_4BalancedTrees.RBNode(3, false, t.NIL),
                c = new Ch5_4BalancedTrees.RBNode(5, false, t.NIL);
        x.left = a; x.right = y; a.parent = x; y.parent = x;
        y.left = b; y.right = c; b.parent = y; c.parent = y;
        t.root = x;
        t.rotateLeft(x);
        Check.yes(t.root == y && y.left == x && x.parent == y && y.parent == t.NIL);
        Check.yes(x.left == a && x.right == b && b.parent == x && y.right == c);
        t.rotateRight(y);
        Check.yes(t.root == x && x.right == y && y.parent == x && y.left == b && b.parent == y);
        Check.eq(t.rotations, 2);
    }
}

class Ex5_4_2Test {
    public static void run() {
        Ch5_4BalancedTrees.RedBlackTree t = new Ch5_4BalancedTrees.RedBlackTree();
        for (int k = 1; k <= 7; k++) Check.yes(t.insert(k));
        Check.eq(t.root.key, 2);
        Check.no(t.root.red);
        Check.eq(t.size, 7);
        Check.no(t.insert(3));
        Check.eq(t.size, 7);
    }
}

class Ex5_4_3Test {
    public static void run() {
        Ch5_4BalancedTrees.RedBlackTree t = new Ch5_4BalancedTrees.RedBlackTree();
        for (int k = 1; k <= 7; k++) {
            t.insert(k);
            Check.yes(t.validate() > 0);
        }
        Check.yes(Ch5_4BalancedTreesTest.tree(IntStream.rangeClosed(1, 1000).toArray()).validate() > 0);
    }
}

class Ex5_4_4Test {
    public static void run() {
        Ch5_4BalancedTrees.RedBlackTree t = Ch5_4BalancedTreesTest.tree(5, 2, 8, 1);
        Check.yes(t.contains(8));
        Check.no(t.contains(3));
        Check.eq(t.inorder(), List.of(1, 2, 5, 8));
    }
}

class Ex5_4_5Test {
    public static void run() {
        Check.eq(Ch5_4BalancedTreesTest.tree(1, 2, 3, 4, 5, 6, 7).height(), 4);
        Ch5_4BalancedTrees.RedBlackTree t = Ch5_4BalancedTreesTest.tree(IntStream.rangeClosed(1, 1000).toArray());
        Check.yes(t.height() <= 19);
        Check.yes(t.height() <= t.heightBound());
    }
}

class Ex5_4_6Test {
    public static void run() {
        Ch5_4BalancedTrees.RedBlackTree t = Ch5_4BalancedTreesTest.tree(20, 10, 30, 25);
        Check.eq(t.minimum(t.root).key, 10);
        Check.eq(t.maximum(), 30);
        Check.eq(t.successor(20), 25);
        Check.eq(t.successor(25), 30);
        Check.eq(t.successor(10), 20);
        Check.eq(t.successor(30), null);
        Check.eq(t.successor(99), null);
    }
}

class Ex5_4_7Test {
    public static void run() {
        Check.yes(Ch5_4BalancedTrees.rotationsFor(IntStream.range(0, 1000).toArray()) < 1000);
        Check.yes(Ch5_4BalancedTrees.rotationsFor(IntStream.range(0, 1000).map(i -> 999 - i).toArray()) < 1000);
    }
}

class Ex5_4_8Test {
    public static void run() {
        Ch5_4BalancedTrees.RedBlackTree t = Ch5_4BalancedTreesTest.tree(IntStream.rangeClosed(1, 100).toArray());
        for (int k = 2; k <= 100; k += 2) {
            Check.yes(t.delete(k));
            t.validate();
        }
        Check.no(t.delete(2));
        List<Integer> odds = new ArrayList<>();
        for (int k = 1; k <= 100; k += 2) odds.add(k);
        Check.eq(t.inorder(), odds);
        Check.eq(t.size, 50);
        Random rnd = new Random(17);
        Ch5_4BalancedTrees.RedBlackTree t6 = new Ch5_4BalancedTrees.RedBlackTree();
        TreeSet<Integer> model = new TreeSet<>();
        for (int i = 0; i < 4000; i++) {
            int k = rnd.nextInt(500);
            if (rnd.nextInt(3) == 0) Check.eq(t6.delete(k), model.remove(k));
            else Check.eq(t6.insert(k), model.add(k));
            if (i % 50 == 0) t6.validate();
        }
        t6.validate();
        Check.eq(t6.inorder(), new ArrayList<>(model));
    }
}

class Ex5_4_9Test {
    public static void run() {
        Ch5_4BalancedTrees.TreapNode top = new Ch5_4BalancedTrees.TreapNode(5, 0.5), left = new Ch5_4BalancedTrees.TreapNode(3, 0.9),
                a = new Ch5_4BalancedTrees.TreapNode(1, 0.1), b = new Ch5_4BalancedTrees.TreapNode(4, 0.2), c = new Ch5_4BalancedTrees.TreapNode(7, 0.3);
        top.left = left; top.right = c; left.left = a; left.right = b;
        Ch5_4BalancedTrees.TreapNode root = Ch5_4BalancedTrees.rotateRight(top);
        Check.yes(root == left && root.right == top && top.left == b);
        Check.eq(Ch5_4BalancedTreesTest.keys(root), List.of(1, 3, 4, 5, 7));
        root = Ch5_4BalancedTrees.rotateLeft(root);
        Check.yes(root == top && top.left == left && left.right == b);
        Check.eq(Ch5_4BalancedTreesTest.keys(root), List.of(1, 3, 4, 5, 7));
    }
}

class Ex5_4_10Test {
    public static void run() {
        Ch5_4BalancedTrees.TreapNode root = Ch5_4BalancedTreesTest.treap(10, new Random(1));
        Check.eq(Ch5_4BalancedTreesTest.keys(root), Ch5_4BalancedTreesTest.range(0, 10));
        List<Ch5_4BalancedTrees.TreapNode> stack = new ArrayList<>(List.of(root));
        while (!stack.isEmpty()) {
            Ch5_4BalancedTrees.TreapNode n = stack.remove(stack.size() - 1);
            for (Ch5_4BalancedTrees.TreapNode child : new Ch5_4BalancedTrees.TreapNode[]{n.left, n.right}) {
                if (child == null) continue;
                Check.yes(child.priority <= n.priority);
                stack.add(child);
            }
        }
    }
}

class Ex5_4_11Test {
    public static void run() {
        Random rng = new Random(2);
        Ch5_4BalancedTrees.TreapNode r = null;
        for (int k : new int[]{5, 2, 8}) r = Ch5_4BalancedTrees.treapInsert(r, k, rng);
        Check.yes(Ch5_4BalancedTrees.treapContains(r, 8));
        Check.no(Ch5_4BalancedTrees.treapContains(r, 3));
        Check.no(Ch5_4BalancedTrees.treapContains(null, 1));
    }
}

class Ex5_4_12Test {
    public static void run() {
        Ch5_4BalancedTrees.TreapNode r = Ch5_4BalancedTreesTest.treap(100, new Random(3));
        for (int k = 0; k < 100; k += 3) r = Ch5_4BalancedTrees.treapDelete(r, k);
        List<Integer> rest = new ArrayList<>();
        for (int k = 0; k < 100; k++) if (k % 3 != 0) rest.add(k);
        Check.eq(Ch5_4BalancedTreesTest.keys(r), rest);
        Check.eq(Ch5_4BalancedTreesTest.keys(Ch5_4BalancedTrees.treapDelete(r, 1000)), rest);
    }
}

class Ex5_4_13Test {
    public static void run() {
        Ch5_4BalancedTrees.TreapNode root = Ch5_4BalancedTreesTest.treap(10, new Random(1));
        Check.yes(Ch5_4BalancedTrees.isValidTreap(root, Long.MIN_VALUE, Long.MAX_VALUE));
        Check.eq(Ch5_4BalancedTrees.inorder(root), Ch5_4BalancedTreesTest.range(0, 10));
        Ch5_4BalancedTrees.TreapNode bad = new Ch5_4BalancedTrees.TreapNode(5, 0.1);
        bad.left = new Ch5_4BalancedTrees.TreapNode(3, 0.9);
        Check.no(Ch5_4BalancedTrees.isValidTreap(bad, Long.MIN_VALUE, Long.MAX_VALUE));
        Ch5_4BalancedTrees.TreapNode unordered = new Ch5_4BalancedTrees.TreapNode(5, 0.9);
        unordered.left = new Ch5_4BalancedTrees.TreapNode(7, 0.1);
        Check.no(Ch5_4BalancedTrees.isValidTreap(unordered, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}

class Ex5_4_14Test {
    public static void run() {
        int th = Ch5_4BalancedTrees.treapHeight(IntStream.rangeClosed(1, 1000).toArray(), new Random(0));
        Check.yes(th >= 12 && th <= 40);
    }
}

class Ex5_4_15Test {
    public static void run() {
        Ch5_4BalancedTrees.TreapNode[] parts = Ch5_4BalancedTrees.split(Ch5_4BalancedTreesTest.treap(10, new Random(5)), 4);
        Check.eq(Ch5_4BalancedTreesTest.keys(parts[0]), Ch5_4BalancedTreesTest.range(0, 4));
        Check.eq(Ch5_4BalancedTreesTest.keys(parts[1]), Ch5_4BalancedTreesTest.range(4, 10));
        Check.yes(Ch5_4BalancedTrees.isValidTreap(parts[0], Long.MIN_VALUE, Long.MAX_VALUE));
        Check.yes(Ch5_4BalancedTrees.isValidTreap(parts[1], Long.MIN_VALUE, Long.MAX_VALUE));
        Ch5_4BalancedTrees.TreapNode merged = Ch5_4BalancedTrees.merge(parts[0], parts[1]);
        Check.eq(Ch5_4BalancedTreesTest.keys(merged), Ch5_4BalancedTreesTest.range(0, 10));
        Check.yes(Ch5_4BalancedTrees.isValidTreap(merged, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
