import java.util.List;

/** Chapter 14 tests, one class per exercise. */
final class Ch14LinkedListsTest {
    private Ch14LinkedListsTest() {}

    static Ch14LinkedLists.LinkedList of(int... values) {
        return Ch14LinkedLists.LinkedList.of(values);
    }
}

class Ex14_1Test {
    public static void run() {
        Check.eq(Ch14LinkedListsTest.of(1, 2, 3).toList(), List.of(1, 2, 3));
        Check.eq(Ch14LinkedListsTest.of(1, 2, 3).size(), 3);
        Check.eq(Ch14LinkedListsTest.of().size(), 0);
        Ch14LinkedLists.LinkedList one = Ch14LinkedListsTest.of(7);
        Check.eq(one.head.data, 7);
        Check.eq(one.head.next, null);
    }
}

class Ex14_2Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(10, 20, 30);
        Check.eq(l.read(2), 30);
        Check.eq(l.read(0), 10);
        Check.eq(l.read(5), null);
        Check.eq(l.read(-1), null);
    }
}

class Ex14_3Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(10, 20, 30);
        Check.eq(l.indexOf(20), 1);
        Check.eq(l.indexOf(99), -1);
    }
}

class Ex14_4Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(2, 3);
        l.insertAtStart(1);
        Check.eq(l.toList(), List.of(1, 2, 3));
        Ch14LinkedLists.LinkedList e = Ch14LinkedListsTest.of();
        e.insertAtStart(1);
        Check.eq(e.toList(), List.of(1));
    }
}

class Ex14_5Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(1, 2);
        l.insertAtEnd(3);
        Check.eq(l.toList(), List.of(1, 2, 3));
        Ch14LinkedLists.LinkedList e = Ch14LinkedListsTest.of();
        e.insertAtEnd(7);
        Check.eq(e.toList(), List.of(7));
    }
}

class Ex14_6Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(1, 2, 4);
        l.insertAt(2, 3);
        Check.eq(l.toList(), List.of(1, 2, 3, 4));
        l.insertAt(4, 5);
        l.insertAt(0, 0);
        Check.eq(l.toList(), List.of(0, 1, 2, 3, 4, 5));
        Check.throwsEx(IndexOutOfBoundsException.class, () -> l.insertAt(9, 1));
    }
}

class Ex14_7Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(1, 2, 3);
        Check.eq(l.deleteAtStart(), 1);
        Check.eq(l.toList(), List.of(2, 3));
        Check.eq(Ch14LinkedListsTest.of().deleteAtStart(), null);
    }
}

class Ex14_8Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(1, 2, 3);
        Check.eq(l.deleteAtEnd(), 3);
        Check.eq(l.toList(), List.of(1, 2));
        Ch14LinkedLists.LinkedList one = Ch14LinkedListsTest.of(1);
        Check.eq(one.deleteAtEnd(), 1);
        Check.eq(one.toList(), List.of());
    }
}

class Ex14_9Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(1, 2, 9, 3);
        Check.eq(l.deleteAt(2), 9);
        Check.eq(l.toList(), List.of(1, 2, 3));
        Check.throwsEx(IndexOutOfBoundsException.class, () -> l.deleteAt(3));
    }
}

class Ex14_10Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(4, 5, 4);
        Check.yes(l.deleteValue(4));
        Check.eq(l.toList(), List.of(5, 4));
        Check.yes(l.deleteValue(4));
        Check.no(l.deleteValue(4));
        Check.eq(l.toList(), List.of(5));
    }
}

class Ex14_11Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(1, 2, 3, 4, 5);
        Check.eq(l.last(), 5);
        Check.eq(l.middle(), 3);
        Check.eq(Ch14LinkedListsTest.of(1, 2, 3, 4).middle(), 3);
    }
}

class Ex14_12Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(1, 2, 3);
        l.reverse();
        Check.eq(l.toList(), List.of(3, 2, 1));
        Ch14LinkedLists.LinkedList e = Ch14LinkedListsTest.of();
        e.reverse();
        Check.eq(e.toList(), List.of());
    }
}

class Ex14_13Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(1, 2, 3, 4);
        Ch14LinkedLists.deleteNode(l.head.next);
        Check.eq(l.toList(), List.of(1, 3, 4));
    }
}

class Ex14_14Test {
    public static void run() {
        Ch14LinkedLists.LinkedList l = Ch14LinkedListsTest.of(1, 2, 3, 4);
        Check.no(l.hasCycle());
        l.head.next.next.next.next = l.head.next;
        Check.yes(l.hasCycle());
        Check.no(Ch14LinkedListsTest.of().hasCycle());
    }
}

class Ex14_15Test {
    public static void run() {
        Ch14LinkedLists.DoublyLinkedList dl = new Ch14LinkedLists.DoublyLinkedList();
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

class Ex14_16Test {
    public static void run() {
        Ch14LinkedLists.LinkedQueue lq = new Ch14LinkedLists.LinkedQueue();
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        Check.eq(lq.dequeue(), 1);
        Check.eq(lq.read(), 2);
    }
}
