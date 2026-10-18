import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;

/** Chapter 5.5 tests, one class per exercise. */

final class Ch5_5BTreesTest {
    private Ch5_5BTreesTest() {}

    static Ch5_5BTrees.BTree btree(int t, int lo, int hi) {
        Ch5_5BTrees.BTree b = new Ch5_5BTrees.BTree(t);
        for (int k = lo; k <= hi; k++) b.insert(k);
        return b;
    }
}

class Ex5_5_1Test {
    public static void run() {
        Check.eq(Ch5_5BTrees.scanIos(1000, 64), 16L);
        Check.eq(Ch5_5BTrees.randomReadsIos(1000), 1000L);
    }
}

class Ex5_5_2Test {
    public static void run() {
        Ch5_5BTrees.ExternalArray ext = new Ch5_5BTrees.ExternalArray(IntStream.range(0, 10_000).map(i -> 2 * i).toArray(), 100);
        Check.eq(Ch5_5BTrees.externalBinarySearch(ext, 4242), 2121);
        Check.yes(ext.ios <= 9);
        Check.eq(Ch5_5BTrees.externalBinarySearch(ext, 4243), -1);
        Check.eq(Ch5_5BTrees.externalBinarySearch(ext, 0), 0);
        Check.eq(Ch5_5BTrees.externalBinarySearch(ext, 19998), 9999);
    }
}

class Ex5_5_3Test {
    public static void run() {
        Check.eq(Ch5_5BTrees.bstIos(1_000_000_000), 30);
        Check.eq(Ch5_5BTrees.btreeIos(1_000_000_000, 1000), 3);
    }
}

class Ex5_5_4Test {
    public static void run() {
        Ch5_5BTrees.BTree t = new Ch5_5BTrees.BTree(2);
        Check.no(t.search(1));
        Ch5_5BTrees.BTreeNode left = new Ch5_5BTrees.BTreeNode(true), right = new Ch5_5BTrees.BTreeNode(true);
        left.keys.addAll(List.of(1, 2));
        right.keys.addAll(List.of(4, 5));
        t.root = new Ch5_5BTrees.BTreeNode(false);
        t.root.keys.add(3);
        t.root.children.addAll(List.of(left, right));
        for (int k = 1; k <= 5; k++) Check.yes(t.search(k));
        Check.no(t.search(0));
        Check.no(t.search(6));
    }
}

class Ex5_5_5Test {
    public static void run() {
        Ch5_5BTrees.BTree bt = Ch5_5BTreesTest.btree(3, 1, 100);
        Check.yes(bt.search(42));
        Check.no(bt.search(101));
        Check.no(bt.insert(42));
        Ch5_5BTrees.BTree small = Ch5_5BTreesTest.btree(2, 1, 10);
        for (int k = 1; k <= 10; k++) Check.yes(small.search(k));
        Check.yes(small.root.keys.size() <= 3);
    }
}

class Ex5_5_6Test {
    public static void run() {
        Ch5_5BTrees.BTree b2 = new Ch5_5BTrees.BTree(2);
        for (int k = 1; k <= 10; k++) {
            b2.insert(k);
            b2.validate();
        }
        Check.eq(b2.inorder(), IntStream.rangeClosed(1, 10).boxed().toList());
    }
}

class Ex5_5_7Test {
    public static void run() {
        Check.eq(Ch5_5BTrees.btreeHeightBound(1_000_000, 50), 4);
        Check.eq(Ch5_5BTrees.btreeHeightBound(10_000, 3), 8);
        Check.yes(Ch5_5BTreesTest.btree(3, 1, 10_000).validate() <= 8);
    }
}

class Ex5_5_8Test {
    public static void run() {
        Ch5_5BTrees.BTree bt = Ch5_5BTreesTest.btree(3, 1, 100);
        Check.eq(bt.rangeQuery(40, 45), List.of(40, 41, 42, 43, 44, 45));
        Check.eq(bt.rangeQuery(99, 500), List.of(99, 100));
        Check.eq(bt.rangeQuery(200, 300), List.of());
    }
}

class Ex5_5_9Test {
    public static void run() {
        Ch5_5BTrees.BTree b3 = Ch5_5BTreesTest.btree(3, 1, 200);
        List<Integer> oddKeys = new ArrayList<>();
        for (int k = 1; k <= 200; k += 2) oddKeys.add(k);
        Collections.shuffle(oddKeys, new Random(5));
        for (int k : oddKeys) {
            Check.yes(b3.delete(k));
            b3.validate();
        }
        Check.no(b3.delete(1));
        List<Integer> evens = new ArrayList<>();
        for (int k = 2; k <= 200; k += 2) evens.add(k);
        Check.eq(b3.inorder(), evens);
        Random rb = new Random(23);
        for (int t0 : new int[]{2, 3, 5}) {
            Ch5_5BTrees.BTree bx = new Ch5_5BTrees.BTree(t0);
            TreeSet<Integer> ms = new TreeSet<>();
            for (int i = 0; i < 3000; i++) {
                int k = rb.nextInt(400);
                if (rb.nextInt(5) < 2) Check.eq(bx.delete(k), ms.remove(k));
                else Check.eq(bx.insert(k), ms.add(k));
            }
            bx.validate();
            Check.eq(bx.inorder(), new ArrayList<>(ms));
        }
    }
}
