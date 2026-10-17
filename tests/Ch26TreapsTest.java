import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/** Chapter 26 tests, one class per exercise. */
final class Ch26TreapsTest {
    private Ch26TreapsTest() {}

    static Ch26Treaps.TreapNode treap(int n, Random rng) {
        Ch26Treaps.TreapNode root = null;
        for (int k = 0; k < n; k++) root = Ch26Treaps.treapInsert(root, k, rng);
        return root;
    }

    /** In-order keys, written here so tests before 26.5 don't depend on its inorder. */
    static List<Integer> keys(Ch26Treaps.TreapNode node) {
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

class Ex26_1Test {
    public static void run() {
        Ch26Treaps.TreapNode top = new Ch26Treaps.TreapNode(5, 0.5), left = new Ch26Treaps.TreapNode(3, 0.9),
                a = new Ch26Treaps.TreapNode(1, 0.1), b = new Ch26Treaps.TreapNode(4, 0.2), c = new Ch26Treaps.TreapNode(7, 0.3);
        top.left = left; top.right = c; left.left = a; left.right = b;
        Ch26Treaps.TreapNode root = Ch26Treaps.rotateRight(top);
        Check.yes(root == left && root.right == top && top.left == b);
        Check.eq(Ch26TreapsTest.keys(root), List.of(1, 3, 4, 5, 7));
        root = Ch26Treaps.rotateLeft(root);
        Check.yes(root == top && top.left == left && left.right == b);
        Check.eq(Ch26TreapsTest.keys(root), List.of(1, 3, 4, 5, 7));
    }
}

class Ex26_2Test {
    public static void run() {
        Ch26Treaps.TreapNode root = Ch26TreapsTest.treap(10, new Random(1));
        Check.eq(Ch26TreapsTest.keys(root), Ch26TreapsTest.range(0, 10));
        List<Ch26Treaps.TreapNode> stack = new ArrayList<>(List.of(root));
        while (!stack.isEmpty()) {
            Ch26Treaps.TreapNode n = stack.remove(stack.size() - 1);
            for (Ch26Treaps.TreapNode child : new Ch26Treaps.TreapNode[]{n.left, n.right}) {
                if (child == null) continue;
                Check.yes(child.priority <= n.priority);
                stack.add(child);
            }
        }
    }
}

class Ex26_3Test {
    public static void run() {
        Random rng = new Random(2);
        Ch26Treaps.TreapNode r = null;
        for (int k : new int[]{5, 2, 8}) r = Ch26Treaps.treapInsert(r, k, rng);
        Check.yes(Ch26Treaps.treapContains(r, 8));
        Check.no(Ch26Treaps.treapContains(r, 3));
        Check.no(Ch26Treaps.treapContains(null, 1));
    }
}

class Ex26_4Test {
    public static void run() {
        Ch26Treaps.TreapNode r = Ch26TreapsTest.treap(100, new Random(3));
        for (int k = 0; k < 100; k += 3) r = Ch26Treaps.treapDelete(r, k);
        List<Integer> rest = new ArrayList<>();
        for (int k = 0; k < 100; k++) if (k % 3 != 0) rest.add(k);
        Check.eq(Ch26TreapsTest.keys(r), rest);
        Check.eq(Ch26TreapsTest.keys(Ch26Treaps.treapDelete(r, 1000)), rest);
    }
}

class Ex26_5Test {
    public static void run() {
        Ch26Treaps.TreapNode root = Ch26TreapsTest.treap(10, new Random(1));
        Check.yes(Ch26Treaps.isValidTreap(root, Long.MIN_VALUE, Long.MAX_VALUE));
        Check.eq(Ch26Treaps.inorder(root), Ch26TreapsTest.range(0, 10));
        Ch26Treaps.TreapNode bad = new Ch26Treaps.TreapNode(5, 0.1);
        bad.left = new Ch26Treaps.TreapNode(3, 0.9);
        Check.no(Ch26Treaps.isValidTreap(bad, Long.MIN_VALUE, Long.MAX_VALUE));
        Ch26Treaps.TreapNode unordered = new Ch26Treaps.TreapNode(5, 0.9);
        unordered.left = new Ch26Treaps.TreapNode(7, 0.1);
        Check.no(Ch26Treaps.isValidTreap(unordered, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}

class Ex26_6Test {
    public static void run() {
        int th = Ch26Treaps.treapHeight(IntStream.rangeClosed(1, 1000).toArray(), new Random(0));
        Check.yes(th >= 12 && th <= 40);
    }
}

class Ex26_7Test {
    public static void run() {
        Ch26Treaps.TreapNode[] parts = Ch26Treaps.split(Ch26TreapsTest.treap(10, new Random(5)), 4);
        Check.eq(Ch26TreapsTest.keys(parts[0]), Ch26TreapsTest.range(0, 4));
        Check.eq(Ch26TreapsTest.keys(parts[1]), Ch26TreapsTest.range(4, 10));
        Check.yes(Ch26Treaps.isValidTreap(parts[0], Long.MIN_VALUE, Long.MAX_VALUE));
        Check.yes(Ch26Treaps.isValidTreap(parts[1], Long.MIN_VALUE, Long.MAX_VALUE));
        Ch26Treaps.TreapNode merged = Ch26Treaps.merge(parts[0], parts[1]);
        Check.eq(Ch26TreapsTest.keys(merged), Ch26TreapsTest.range(0, 10));
        Check.yes(Ch26Treaps.isValidTreap(merged, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
