import java.util.Arrays;
import java.util.List;
import java.util.Random;

/** Chapter 16 tests, one class per exercise. */
class Ex16_1Test {
    public static void run() {
        Check.eq(Ch16Heaps.MaxHeap.leftChild(0), 1);
        Check.eq(Ch16Heaps.MaxHeap.rightChild(0), 2);
        Check.eq(Ch16Heaps.MaxHeap.parent(4), 1);
        Ch16Heaps.MaxHeap h = new Ch16Heaps.MaxHeap();
        Check.eq(h.root(), null);
        Check.eq(h.size(), 0);
        h.data.addAll(List.of(9, 5, 3));
        Check.eq(h.root(), 9);
        Check.eq(h.last(), 3);
        Check.eq(h.size(), 3);
    }
}

class Ex16_2Test {
    public static void run() {
        Ch16Heaps.MaxHeap h = new Ch16Heaps.MaxHeap();
        for (int v : new int[]{3, 9, 5, 12}) h.insert(v);
        Check.eq(h.root(), 12);
        Check.eq(h.size(), 4);
        for (int i = 1; i < h.data.size(); i++) Check.yes(h.data.get(Ch16Heaps.MaxHeap.parent(i)) >= h.data.get(i));
    }
}

class Ex16_3Test {
    public static void run() {
        Ch16Heaps.MaxHeap h = new Ch16Heaps.MaxHeap();
        for (int v : new int[]{3, 9, 5, 12}) h.insert(v);
        Check.eq(h.delete(), 12);
        Check.eq(h.delete(), 9);
        Check.eq(h.delete(), 5);
        Check.eq(h.delete(), 3);
        Check.eq(h.delete(), null);
    }
}

class Ex16_4Test {
    public static void run() {
        Check.eq(Ch16Heaps.heapSort(new int[]{5, 1, 9, 3, 7}), new int[]{1, 3, 5, 7, 9});
        Check.eq(Ch16Heaps.heapSort(new int[]{4, 4, 1, 4}), new int[]{1, 4, 4, 4});
        Random rng = new Random(1);
        int[] data = new int[200];
        for (int i = 0; i < data.length; i++) data[i] = rng.nextInt(201) - 100;
        int[] want = data.clone();
        Arrays.sort(want);
        Check.eq(Ch16Heaps.heapSort(data), want);
    }
}

class Ex16_5Test {
    public static void run() {
        Ch16Heaps.TriageQueue tq = new Ch16Heaps.TriageQueue();
        tq.admit("Ann", 3);
        tq.admit("Bo", 9);
        tq.admit("Cy", 9);
        Check.eq(tq.nextPatient(), "Bo");
        Check.eq(tq.nextPatient(), "Cy");
        Check.eq(tq.nextPatient(), "Ann");
        Check.eq(tq.nextPatient(), null);
    }
}

class Ex16_6Test {
    public static void run() {
        Check.eq(Ch16Heaps.topK(new int[]{3, 1, 9, 7, 5, 8}, 3), List.of(9, 8, 7));
    }
}

class Ex16_7Test {
    public static void run() {
        Check.yes(Ch16Heaps.isMaxHeap(new int[]{100, 88, 25, 87, 16}));
        Check.no(Ch16Heaps.isMaxHeap(new int[]{10, 20}));
        Check.yes(Ch16Heaps.isMaxHeap(new int[]{}));
    }
}

class Ex16_8Test {
    public static void run() {
        Check.eq(Ch16Heaps.mergeKSorted(new int[][]{{1, 4, 7}, {2, 5}, {0, 9}}), List.of(0, 1, 2, 4, 5, 7, 9));
        Check.eq(Ch16Heaps.mergeKSorted(new int[][]{{}, {3}}), List.of(3));
    }
}
