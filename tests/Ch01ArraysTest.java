import java.util.List;

/** Chapter 1 tests, one class per exercise. */
final class Ch01ArraysTest {
    private Ch01ArraysTest() {}

    /** An Array holding `values`, filled directly so a test needs only 1.1 and its own exercise. */
    static Ch01Arrays.Array build(int capacity, int... values) {
        Ch01Arrays.Array a = new Ch01Arrays.Array(capacity);
        System.arraycopy(values, 0, a.data, 0, values.length);
        a.length = values.length;
        return a;
    }
}

class Ex1_1Test {
    public static void run() {
        Ch01Arrays.Array a = new Ch01Arrays.Array(5);
        Check.eq(a.size(), 0);
        Check.yes(a.isEmpty());
        Check.no(a.isFull());
        Check.eq(a.toArray(), new int[]{});
        Check.eq(a.capacity, 5);
        Check.eq(a.steps, 0);
        Ch01Arrays.Array full = Ch01ArraysTest.build(2, 1, 2);
        Check.yes(full.isFull());
        Check.eq(full.size(), 2);
        Check.eq(full.toArray(), new int[]{1, 2});
        full.steps = 7;
        full.resetSteps();
        Check.eq(full.steps, 0);
    }
}

class Ex1_2Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 10, 20, 30);
        Check.eq(a.read(1), 20);
        Check.eq(a.steps, 1);
        Check.throwsEx(IndexOutOfBoundsException.class, () -> a.read(3));
        Check.throwsEx(IndexOutOfBoundsException.class, () -> a.read(-1));
    }
}

class Ex1_3Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 4, 8, 15);
        Check.eq(a.first(), 4);
        Check.eq(a.last(), 15);
        Check.eq(new Ch01Arrays.Array(2).first(), null);
        Check.eq(new Ch01Arrays.Array(2).last(), null);
    }
}

class Ex1_4Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 1, 2, 3);
        a.update(0, 9);
        Check.eq(a.toArray(), new int[]{9, 2, 3});
        Check.eq(a.steps, 1);
        Check.throwsEx(IndexOutOfBoundsException.class, () -> a.update(3, 0));
    }
}

class Ex1_5Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 5, 3, 7);
        Check.eq(a.search(7), 2);
        Check.eq(a.steps, 3);
        a.resetSteps();
        Check.eq(a.search(9), -1);
        Check.eq(a.steps, 3);
        a.resetSteps();
        Check.eq(a.search(5), 0);
        Check.eq(a.steps, 1);
    }
}

class Ex1_6Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 5, 3, 7);
        Check.yes(a.contains(3));
        Check.no(a.contains(4));
    }
}

class Ex1_7Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 1, 2);
        a.insertAtEnd(3);
        Check.eq(a.toArray(), new int[]{1, 2, 3});
        Check.eq(a.steps, 1);
        Ch01Arrays.Array full = Ch01ArraysTest.build(1, 1);
        Check.throwsEx(IllegalStateException.class, () -> full.insertAtEnd(2));
    }
}

class Ex1_8Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 2, 3, 4);
        a.insertAtStart(1);
        Check.eq(a.toArray(), new int[]{1, 2, 3, 4});
        Check.eq(a.steps, 4);
    }
}

class Ex1_9Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 1, 2, 4);
        a.insertAt(2, 3);
        Check.eq(a.toArray(), new int[]{1, 2, 3, 4});
        Check.eq(a.steps, 2);
        a.insertAt(4, 5);
        Check.eq(a.toArray(), new int[]{1, 2, 3, 4, 5});
        Check.throwsEx(IllegalStateException.class, () -> a.insertAt(0, 0));
        Check.throwsEx(IndexOutOfBoundsException.class, () -> Ch01ArraysTest.build(3, 1).insertAt(5, 0));
    }
}

class Ex1_10Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 1, 2, 3);
        Check.eq(a.deleteAtEnd(), 3);
        Check.eq(a.toArray(), new int[]{1, 2});
        Check.eq(a.steps, 1);
        Check.throwsEx(IllegalStateException.class, () -> new Ch01Arrays.Array(2).deleteAtEnd());
    }
}

class Ex1_11Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 1, 2, 3, 4);
        Check.eq(a.deleteAtStart(), 1);
        Check.eq(a.toArray(), new int[]{2, 3, 4});
        Check.eq(a.steps, 4);
    }
}

class Ex1_12Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 1, 2, 9, 3);
        Check.eq(a.deleteAt(2), 9);
        Check.eq(a.toArray(), new int[]{1, 2, 3});
        Check.throwsEx(IndexOutOfBoundsException.class, () -> a.deleteAt(3));
    }
}

class Ex1_13Test {
    public static void run() {
        Ch01Arrays.Array a = Ch01ArraysTest.build(5, 4, 5, 4);
        Check.yes(a.deleteValue(4));
        Check.eq(a.toArray(), new int[]{5, 4});
        Check.no(a.deleteValue(7));
        Check.eq(a.toArray(), new int[]{5, 4});
    }
}

class Ex1_14Test {
    public static void run() {
        Check.eq(Ch01Arrays.findAllIndices(new int[]{3, 1, 3, 3}, 3), List.of(0, 2, 3));
        Check.eq(Ch01Arrays.countOccurrences(new int[]{3, 1, 3, 3}, 3), 3);
        Check.eq(Ch01Arrays.countOccurrences(new int[]{}, 1), 0);
        Check.eq(Ch01Arrays.findAllIndices(new int[]{1, 2}, 9), List.of());
    }
}

class Ex1_15Test {
    public static void run() {
        Check.eq(Ch01Arrays.findMinMax(new int[]{7, -2, 9, 4}), new int[]{-2, 9});
        Check.eq(Ch01Arrays.findMinMax(new int[]{5}), new int[]{5, 5});
        Check.eq(Ch01Arrays.findMinMax(new int[]{}), null);
    }
}

class Ex1_16Test {
    public static void run() {
        Check.eq(Ch01Arrays.reverseInPlace(new int[]{1, 2, 3, 4, 5}), new int[]{5, 4, 3, 2, 1});
        Check.eq(Ch01Arrays.reverseInPlace(new int[]{1, 2}), new int[]{2, 1});
        Check.eq(Ch01Arrays.reverseInPlace(new int[]{}), new int[]{});
    }
}

class Ex1_17Test {
    public static void run() {
        Ch01Arrays.ArraySet s = new Ch01Arrays.ArraySet(5);
        Check.yes(s.add(3));
        Check.no(s.add(3));
        Check.eq(s.size(), 1);
        s.resetSteps();
        s.add(4);
        Check.eq(s.steps, 2); // 1 search step + 1 write
        s.insertAtEnd(3);
        Check.eq(s.toArray(), new int[]{3, 4});
    }
}

class Ex1_18Test {
    public static void run() {
        Check.eq(Ch01Arrays.stepsTable(5).toString(),
                "{read=1, searchMissing=5, insertEnd=1, insertStart=6, deleteEnd=1, deleteStart=5}");
    }
}

class Ex1_19Test {
    public static void run() {
        Ch01Arrays.DynamicArray d = new Ch01Arrays.DynamicArray(2);
        d.insertAtEnd(1);
        d.insertAtEnd(2);
        d.insertAtEnd(3);
        Check.eq(d.capacity, 4);
        Check.eq(d.toArray(), new int[]{1, 2, 3});
    }
}
