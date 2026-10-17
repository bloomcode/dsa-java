import java.util.Arrays;
import java.util.List;
import java.util.Random;

/** Chapter 52 tests, one class per exercise. */

class Ex52_1Test {
    public static void run() {
        Check.eq(Ch52Heaps.MaxHeap.leftChild(0), 1);
        Check.eq(Ch52Heaps.MaxHeap.rightChild(0), 2);
        Check.eq(Ch52Heaps.MaxHeap.parent(4), 1);
        Ch52Heaps.MaxHeap h = new Ch52Heaps.MaxHeap();
        Check.eq(h.root(), null);
        Check.eq(h.size(), 0);
        h.data.addAll(List.of(9, 5, 3));
        Check.eq(h.root(), 9);
        Check.eq(h.last(), 3);
        Check.eq(h.size(), 3);
    }
}

class Ex52_2Test {
    public static void run() {
        Ch52Heaps.MaxHeap h = new Ch52Heaps.MaxHeap();
        for (int v : new int[]{3, 9, 5, 12}) h.insert(v);
        Check.eq(h.root(), 12);
        Check.eq(h.size(), 4);
        for (int i = 1; i < h.data.size(); i++) Check.yes(h.data.get(Ch52Heaps.MaxHeap.parent(i)) >= h.data.get(i));
    }
}

class Ex52_3Test {
    public static void run() {
        Ch52Heaps.MaxHeap h = new Ch52Heaps.MaxHeap();
        for (int v : new int[]{3, 9, 5, 12}) h.insert(v);
        Check.eq(h.delete(), 12);
        Check.eq(h.delete(), 9);
        Check.eq(h.delete(), 5);
        Check.eq(h.delete(), 3);
        Check.eq(h.delete(), null);
    }
}

class Ex52_4Test {
    public static void run() {
        Check.eq(Ch52Heaps.heapSort(new int[]{5, 1, 9, 3, 7}), new int[]{1, 3, 5, 7, 9});
        Check.eq(Ch52Heaps.heapSort(new int[]{4, 4, 1, 4}), new int[]{1, 4, 4, 4});
        Random rng = new Random(1);
        int[] data = new int[200];
        for (int i = 0; i < data.length; i++) data[i] = rng.nextInt(201) - 100;
        int[] want = data.clone();
        Arrays.sort(want);
        Check.eq(Ch52Heaps.heapSort(data), want);
    }
}

class Ex52_5Test {
    public static void run() {
        Ch52Heaps.DeadlineQueue q = new Ch52Heaps.DeadlineQueue();
        q.add("report", 5);
        q.add("backup", 2);
        q.add("email", 2);
        Check.eq(q.nextJob(), "backup");
        Check.eq(q.nextJob(), "email");
        Check.eq(q.nextJob(), "report");
        Check.eq(q.nextJob(), null);
        q.add("late", 9);
        q.add("soon", 1);
        Check.eq(q.nextJob(), "soon");
    }
}

class Ex52_6Test {
    public static void run() {
        Check.eq(Ch52Heaps.topK(new int[]{3, 1, 9, 7, 5, 8}, 3), List.of(9, 8, 7));
    }
}

class Ex52_7Test {
    public static void run() {
        Check.yes(Ch52Heaps.isMaxHeap(new int[]{100, 88, 25, 87, 16}));
        Check.no(Ch52Heaps.isMaxHeap(new int[]{10, 20}));
        Check.yes(Ch52Heaps.isMaxHeap(new int[]{}));
    }
}

class Ex52_8Test {
    public static void run() {
        Check.eq(Ch52Heaps.mergeKSorted(new int[][]{{1, 4, 7}, {2, 5}, {0, 9}}), List.of(0, 1, 2, 4, 5, 7, 9));
        Check.eq(Ch52Heaps.mergeKSorted(new int[][]{{}, {3}}), List.of(3));
    }
}
