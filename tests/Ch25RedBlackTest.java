import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;

/** Chapter 25 tests, one class per exercise. */
final class Ch25RedBlackTest {
    private Ch25RedBlackTest() {}

    static Ch25RedBlack.RedBlackTree tree(int... keys) {
        Ch25RedBlack.RedBlackTree t = new Ch25RedBlack.RedBlackTree();
        for (int k : keys) t.insert(k);
        return t;
    }
}

class Ex25_1Test {
    public static void run() {
        Ch25RedBlack.RedBlackTree t = new Ch25RedBlack.RedBlackTree();
        Check.yes(t.root == t.NIL);
        Check.no(t.NIL.red);
        Ch25RedBlack.RBNode x = new Ch25RedBlack.RBNode(2, false, t.NIL), a = new Ch25RedBlack.RBNode(1, true, t.NIL),
                y = new Ch25RedBlack.RBNode(4, true, t.NIL), b = new Ch25RedBlack.RBNode(3, false, t.NIL),
                c = new Ch25RedBlack.RBNode(5, false, t.NIL);
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

class Ex25_2Test {
    public static void run() {
        Ch25RedBlack.RedBlackTree t = new Ch25RedBlack.RedBlackTree();
        for (int k = 1; k <= 7; k++) Check.yes(t.insert(k));
        Check.eq(t.root.key, 2);
        Check.no(t.root.red);
        Check.eq(t.size, 7);
        Check.no(t.insert(3));
        Check.eq(t.size, 7);
    }
}

class Ex25_3Test {
    public static void run() {
        Ch25RedBlack.RedBlackTree t = new Ch25RedBlack.RedBlackTree();
        for (int k = 1; k <= 7; k++) {
            t.insert(k);
            Check.yes(t.validate() > 0);
        }
        Check.yes(Ch25RedBlackTest.tree(IntStream.rangeClosed(1, 1000).toArray()).validate() > 0);
    }
}

class Ex25_4Test {
    public static void run() {
        Ch25RedBlack.RedBlackTree t = Ch25RedBlackTest.tree(5, 2, 8, 1);
        Check.yes(t.contains(8));
        Check.no(t.contains(3));
        Check.eq(t.inorder(), List.of(1, 2, 5, 8));
    }
}

class Ex25_5Test {
    public static void run() {
        Check.eq(Ch25RedBlackTest.tree(1, 2, 3, 4, 5, 6, 7).height(), 4);
        Ch25RedBlack.RedBlackTree t = Ch25RedBlackTest.tree(IntStream.rangeClosed(1, 1000).toArray());
        Check.yes(t.height() <= 19);
        Check.yes(t.height() <= t.heightBound());
    }
}

class Ex25_6Test {
    public static void run() {
        Ch25RedBlack.RedBlackTree t = Ch25RedBlackTest.tree(20, 10, 30, 25);
        Check.eq(t.minimum(t.root).key, 10);
        Check.eq(t.maximum(), 30);
        Check.eq(t.successor(20), 25);
        Check.eq(t.successor(25), 30);
        Check.eq(t.successor(10), 20);
        Check.eq(t.successor(30), null);
        Check.eq(t.successor(99), null);
    }
}

class Ex25_7Test {
    public static void run() {
        Check.yes(Ch25RedBlack.rotationsFor(IntStream.range(0, 1000).toArray()) < 1000);
        Check.yes(Ch25RedBlack.rotationsFor(IntStream.range(0, 1000).map(i -> 999 - i).toArray()) < 1000);
    }
}

class Ex25_8Test {
    public static void run() {
        Ch25RedBlack.RedBlackTree t = Ch25RedBlackTest.tree(IntStream.rangeClosed(1, 100).toArray());
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
        Ch25RedBlack.RedBlackTree t6 = new Ch25RedBlack.RedBlackTree();
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
