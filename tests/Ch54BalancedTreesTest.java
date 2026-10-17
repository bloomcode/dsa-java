import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;

/** Chapter 54 tests, one class per exercise. */

final class Ch54BalancedTreesTest {
    private Ch54BalancedTreesTest() {}

    static Ch54BalancedTrees.RedBlackTree tree(int... keys) {
        Ch54BalancedTrees.RedBlackTree t = new Ch54BalancedTrees.RedBlackTree();
        for (int k : keys) t.insert(k);
        return t;
    }


    static Ch54BalancedTrees.TreapNode treap(int n, Random rng) {
        Ch54BalancedTrees.TreapNode root = null;
        for (int k = 0; k < n; k++) root = Ch54BalancedTrees.treapInsert(root, k, rng);
        return root;
    }

    /** In-order keys, written here so tests before 54.13 don't depend on its inorder. */
    static List<Integer> keys(Ch54BalancedTrees.TreapNode node) {
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

class Ex54_1Test {
    public static void run() {
        Ch54BalancedTrees.RedBlackTree t = new Ch54BalancedTrees.RedBlackTree();
        Check.yes(t.root == t.NIL);
        Check.no(t.NIL.red);
        Ch54BalancedTrees.RBNode x = new Ch54BalancedTrees.RBNode(2, false, t.NIL), a = new Ch54BalancedTrees.RBNode(1, true, t.NIL),
                y = new Ch54BalancedTrees.RBNode(4, true, t.NIL), b = new Ch54BalancedTrees.RBNode(3, false, t.NIL),
                c = new Ch54BalancedTrees.RBNode(5, false, t.NIL);
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

class Ex54_2Test {
    public static void run() {
        Ch54BalancedTrees.RedBlackTree t = new Ch54BalancedTrees.RedBlackTree();
        for (int k = 1; k <= 7; k++) Check.yes(t.insert(k));
        Check.eq(t.root.key, 2);
        Check.no(t.root.red);
        Check.eq(t.size, 7);
        Check.no(t.insert(3));
        Check.eq(t.size, 7);
    }
}

class Ex54_3Test {
    public static void run() {
        Ch54BalancedTrees.RedBlackTree t = new Ch54BalancedTrees.RedBlackTree();
        for (int k = 1; k <= 7; k++) {
            t.insert(k);
            Check.yes(t.validate() > 0);
        }
        Check.yes(Ch54BalancedTreesTest.tree(IntStream.rangeClosed(1, 1000).toArray()).validate() > 0);
    }
}

class Ex54_4Test {
    public static void run() {
        Ch54BalancedTrees.RedBlackTree t = Ch54BalancedTreesTest.tree(5, 2, 8, 1);
        Check.yes(t.contains(8));
        Check.no(t.contains(3));
        Check.eq(t.inorder(), List.of(1, 2, 5, 8));
    }
}

class Ex54_5Test {
    public static void run() {
        Check.eq(Ch54BalancedTreesTest.tree(1, 2, 3, 4, 5, 6, 7).height(), 4);
        Ch54BalancedTrees.RedBlackTree t = Ch54BalancedTreesTest.tree(IntStream.rangeClosed(1, 1000).toArray());
        Check.yes(t.height() <= 19);
        Check.yes(t.height() <= t.heightBound());
    }
}

class Ex54_6Test {
    public static void run() {
        Ch54BalancedTrees.RedBlackTree t = Ch54BalancedTreesTest.tree(20, 10, 30, 25);
        Check.eq(t.minimum(t.root).key, 10);
        Check.eq(t.maximum(), 30);
        Check.eq(t.successor(20), 25);
        Check.eq(t.successor(25), 30);
        Check.eq(t.successor(10), 20);
        Check.eq(t.successor(30), null);
        Check.eq(t.successor(99), null);
    }
}

class Ex54_7Test {
    public static void run() {
        Check.yes(Ch54BalancedTrees.rotationsFor(IntStream.range(0, 1000).toArray()) < 1000);
        Check.yes(Ch54BalancedTrees.rotationsFor(IntStream.range(0, 1000).map(i -> 999 - i).toArray()) < 1000);
    }
}

class Ex54_8Test {
    public static void run() {
        Ch54BalancedTrees.RedBlackTree t = Ch54BalancedTreesTest.tree(IntStream.rangeClosed(1, 100).toArray());
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
        Ch54BalancedTrees.RedBlackTree t6 = new Ch54BalancedTrees.RedBlackTree();
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

class Ex54_9Test {
    public static void run() {
        Ch54BalancedTrees.TreapNode top = new Ch54BalancedTrees.TreapNode(5, 0.5), left = new Ch54BalancedTrees.TreapNode(3, 0.9),
                a = new Ch54BalancedTrees.TreapNode(1, 0.1), b = new Ch54BalancedTrees.TreapNode(4, 0.2), c = new Ch54BalancedTrees.TreapNode(7, 0.3);
        top.left = left; top.right = c; left.left = a; left.right = b;
        Ch54BalancedTrees.TreapNode root = Ch54BalancedTrees.rotateRight(top);
        Check.yes(root == left && root.right == top && top.left == b);
        Check.eq(Ch54BalancedTreesTest.keys(root), List.of(1, 3, 4, 5, 7));
        root = Ch54BalancedTrees.rotateLeft(root);
        Check.yes(root == top && top.left == left && left.right == b);
        Check.eq(Ch54BalancedTreesTest.keys(root), List.of(1, 3, 4, 5, 7));
    }
}

class Ex54_10Test {
    public static void run() {
        Ch54BalancedTrees.TreapNode root = Ch54BalancedTreesTest.treap(10, new Random(1));
        Check.eq(Ch54BalancedTreesTest.keys(root), Ch54BalancedTreesTest.range(0, 10));
        List<Ch54BalancedTrees.TreapNode> stack = new ArrayList<>(List.of(root));
        while (!stack.isEmpty()) {
            Ch54BalancedTrees.TreapNode n = stack.remove(stack.size() - 1);
            for (Ch54BalancedTrees.TreapNode child : new Ch54BalancedTrees.TreapNode[]{n.left, n.right}) {
                if (child == null) continue;
                Check.yes(child.priority <= n.priority);
                stack.add(child);
            }
        }
    }
}

class Ex54_11Test {
    public static void run() {
        Random rng = new Random(2);
        Ch54BalancedTrees.TreapNode r = null;
        for (int k : new int[]{5, 2, 8}) r = Ch54BalancedTrees.treapInsert(r, k, rng);
        Check.yes(Ch54BalancedTrees.treapContains(r, 8));
        Check.no(Ch54BalancedTrees.treapContains(r, 3));
        Check.no(Ch54BalancedTrees.treapContains(null, 1));
    }
}

class Ex54_12Test {
    public static void run() {
        Ch54BalancedTrees.TreapNode r = Ch54BalancedTreesTest.treap(100, new Random(3));
        for (int k = 0; k < 100; k += 3) r = Ch54BalancedTrees.treapDelete(r, k);
        List<Integer> rest = new ArrayList<>();
        for (int k = 0; k < 100; k++) if (k % 3 != 0) rest.add(k);
        Check.eq(Ch54BalancedTreesTest.keys(r), rest);
        Check.eq(Ch54BalancedTreesTest.keys(Ch54BalancedTrees.treapDelete(r, 1000)), rest);
    }
}

class Ex54_13Test {
    public static void run() {
        Ch54BalancedTrees.TreapNode root = Ch54BalancedTreesTest.treap(10, new Random(1));
        Check.yes(Ch54BalancedTrees.isValidTreap(root, Long.MIN_VALUE, Long.MAX_VALUE));
        Check.eq(Ch54BalancedTrees.inorder(root), Ch54BalancedTreesTest.range(0, 10));
        Ch54BalancedTrees.TreapNode bad = new Ch54BalancedTrees.TreapNode(5, 0.1);
        bad.left = new Ch54BalancedTrees.TreapNode(3, 0.9);
        Check.no(Ch54BalancedTrees.isValidTreap(bad, Long.MIN_VALUE, Long.MAX_VALUE));
        Ch54BalancedTrees.TreapNode unordered = new Ch54BalancedTrees.TreapNode(5, 0.9);
        unordered.left = new Ch54BalancedTrees.TreapNode(7, 0.1);
        Check.no(Ch54BalancedTrees.isValidTreap(unordered, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}

class Ex54_14Test {
    public static void run() {
        int th = Ch54BalancedTrees.treapHeight(IntStream.rangeClosed(1, 1000).toArray(), new Random(0));
        Check.yes(th >= 12 && th <= 40);
    }
}

class Ex54_15Test {
    public static void run() {
        Ch54BalancedTrees.TreapNode[] parts = Ch54BalancedTrees.split(Ch54BalancedTreesTest.treap(10, new Random(5)), 4);
        Check.eq(Ch54BalancedTreesTest.keys(parts[0]), Ch54BalancedTreesTest.range(0, 4));
        Check.eq(Ch54BalancedTreesTest.keys(parts[1]), Ch54BalancedTreesTest.range(4, 10));
        Check.yes(Ch54BalancedTrees.isValidTreap(parts[0], Long.MIN_VALUE, Long.MAX_VALUE));
        Check.yes(Ch54BalancedTrees.isValidTreap(parts[1], Long.MIN_VALUE, Long.MAX_VALUE));
        Ch54BalancedTrees.TreapNode merged = Ch54BalancedTrees.merge(parts[0], parts[1]);
        Check.eq(Ch54BalancedTreesTest.keys(merged), Ch54BalancedTreesTest.range(0, 10));
        Check.yes(Ch54BalancedTrees.isValidTreap(merged, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
