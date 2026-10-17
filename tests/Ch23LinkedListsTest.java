import java.util.LinkedList;
import java.util.List;

/** Chapter 23 tests, one class per exercise. */

final class Ch23LinkedListsTest {
    private Ch23LinkedListsTest() {}

    static Ch23LinkedLists.LinkedList of(int... values) {
        return Ch23LinkedLists.LinkedList.of(values);
    }
}

class Ex23_1Test {
    public static void run() {
        Check.eq(Ch23LinkedListsTest.of(1, 2, 3).toList(), List.of(1, 2, 3));
        Check.eq(Ch23LinkedListsTest.of(1, 2, 3).size(), 3);
        Check.eq(Ch23LinkedListsTest.of().size(), 0);
        Ch23LinkedLists.LinkedList one = Ch23LinkedListsTest.of(7);
        Check.eq(one.head.data, 7);
        Check.eq(one.head.next, null);
    }
}

class Ex23_2Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(10, 20, 30);
        Check.eq(l.read(2), 30);
        Check.eq(l.read(0), 10);
        Check.eq(l.read(5), null);
        Check.eq(l.read(-1), null);
    }
}

class Ex23_3Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(10, 20, 30);
        Check.eq(l.indexOf(20), 1);
        Check.eq(l.indexOf(99), -1);
    }
}

class Ex23_4Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(2, 3);
        l.insertAtStart(1);
        Check.eq(l.toList(), List.of(1, 2, 3));
        Ch23LinkedLists.LinkedList e = Ch23LinkedListsTest.of();
        e.insertAtStart(1);
        Check.eq(e.toList(), List.of(1));
    }
}

class Ex23_5Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(1, 2);
        l.insertAtEnd(3);
        Check.eq(l.toList(), List.of(1, 2, 3));
        Ch23LinkedLists.LinkedList e = Ch23LinkedListsTest.of();
        e.insertAtEnd(7);
        Check.eq(e.toList(), List.of(7));
    }
}

class Ex23_6Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(1, 2, 4);
        l.insertAt(2, 3);
        Check.eq(l.toList(), List.of(1, 2, 3, 4));
        l.insertAt(4, 5);
        l.insertAt(0, 0);
        Check.eq(l.toList(), List.of(0, 1, 2, 3, 4, 5));
        Check.throwsEx(IndexOutOfBoundsException.class, () -> l.insertAt(9, 1));
    }
}

class Ex23_7Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(1, 2, 3);
        Check.eq(l.deleteAtStart(), 1);
        Check.eq(l.toList(), List.of(2, 3));
        Check.eq(Ch23LinkedListsTest.of().deleteAtStart(), null);
    }
}

class Ex23_8Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(1, 2, 3);
        Check.eq(l.deleteAtEnd(), 3);
        Check.eq(l.toList(), List.of(1, 2));
        Ch23LinkedLists.LinkedList one = Ch23LinkedListsTest.of(1);
        Check.eq(one.deleteAtEnd(), 1);
        Check.eq(one.toList(), List.of());
    }
}

class Ex23_9Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(1, 2, 9, 3);
        Check.eq(l.deleteAt(2), 9);
        Check.eq(l.toList(), List.of(1, 2, 3));
        Check.throwsEx(IndexOutOfBoundsException.class, () -> l.deleteAt(3));
    }
}

class Ex23_10Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(4, 5, 4);
        Check.yes(l.deleteValue(4));
        Check.eq(l.toList(), List.of(5, 4));
        Check.yes(l.deleteValue(4));
        Check.no(l.deleteValue(4));
        Check.eq(l.toList(), List.of(5));
    }
}

class Ex23_11Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(1, 2, 3, 4, 5);
        Check.eq(l.splitHalf().toList(), List.of(4, 5));
        Check.eq(l.toList(), List.of(1, 2, 3));
        Ch23LinkedLists.LinkedList even = Ch23LinkedListsTest.of(1, 2, 3, 4);
        Check.eq(even.splitHalf().toList(), List.of(3, 4));
        Check.eq(even.toList(), List.of(1, 2));
        Ch23LinkedLists.LinkedList one = Ch23LinkedListsTest.of(7);
        Check.eq(one.splitHalf().toList(), List.of());
        Check.eq(one.toList(), List.of(7));
        Check.eq(Ch23LinkedListsTest.of().splitHalf().toList(), List.of());
    }
}

class Ex23_12Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(1, 2, 3);
        l.reverse();
        Check.eq(l.toList(), List.of(3, 2, 1));
        Ch23LinkedLists.LinkedList e = Ch23LinkedListsTest.of();
        e.reverse();
        Check.eq(e.toList(), List.of());
    }
}

class Ex23_13Test {
    public static void run() {
        Ch23LinkedLists.LinkedList a = Ch23LinkedListsTest.of(1, 4, 7), b = Ch23LinkedListsTest.of(2, 3, 9);
        Ch23LinkedLists.Node firstB = b.head;
        Ch23LinkedLists.LinkedList merged = Ch23LinkedLists.mergeSortedLists(a, b);
        Check.eq(merged.toList(), List.of(1, 2, 3, 4, 7, 9));
        Check.yes(merged.head.next == firstB);
        Check.eq(Ch23LinkedLists.mergeSortedLists(Ch23LinkedListsTest.of(), Ch23LinkedListsTest.of(5)).toList(), List.of(5));
        Check.eq(Ch23LinkedLists.mergeSortedLists(Ch23LinkedListsTest.of(2, 2), Ch23LinkedListsTest.of(2)).toList(), List.of(2, 2, 2));
        Check.eq(Ch23LinkedLists.mergeSortedLists(Ch23LinkedListsTest.of(), Ch23LinkedListsTest.of()).toList(), List.of());
    }
}

class Ex23_14Test {
    public static void run() {
        Ch23LinkedLists.LinkedList l = Ch23LinkedListsTest.of(1, 2, 3, 4);
        Check.no(l.hasCycle());
        l.head.next.next.next.next = l.head.next;
        Check.yes(l.hasCycle());
        Check.no(Ch23LinkedListsTest.of().hasCycle());
    }
}

class Ex23_15Test {
    public static void run() {
        Ch23LinkedLists.DoublyLinkedList dl = new Ch23LinkedLists.DoublyLinkedList();
        dl.insertAtEnd(2);
        dl.insertAtStart(1);
        dl.insertAtEnd(3);
        Check.eq(dl.toList(), List.of(1, 2, 3));
        Check.eq(dl.toListReversed(), List.of(3, 2, 1));
        Check.eq(dl.deleteAtEnd(), 3);
        Check.eq(dl.deleteAtStart(), 1);
        Check.eq(dl.deleteAtStart(), 2);
        Check.eq(dl.deleteAtEnd(), null);
        Check.eq(dl.tail, null);
    }
}

class Ex23_16Test {
    public static void run() {
        Ch23LinkedLists.LinkedQueue lq = new Ch23LinkedLists.LinkedQueue();
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        Check.eq(lq.dequeue(), 1);
        Check.eq(lq.read(), 2);
    }
}
