import java.util.ArrayList;
import java.util.Arrays;
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

class Ex23_17Test {
    public static void run() {
        Ch23LinkedLists.LinkedList list = Ch23LinkedListsTest.of(1, 2, 3, 4, 5);
        Check.eq(Ch23LinkedLists.removeKthFromEnd(list, 2), 4);
        Check.eq(list.toList(), List.of(1, 2, 3, 5));
        Check.eq(Ch23LinkedLists.removeKthFromEnd(list, 4), 1);
        Check.eq(list.toList(), List.of(2, 3, 5));
        Ch23LinkedLists.LinkedList one = Ch23LinkedListsTest.of(7);
        Check.eq(Ch23LinkedLists.removeKthFromEnd(one, 1), 7);
        Check.eq(one.toList(), List.of());
    }
}

class Ex23_18Test {
    public static void run() {
        Check.eq(Ch23LinkedLists.addDigitLists(Ch23LinkedListsTest.of(9, 4, 1), Ch23LinkedListsTest.of(3, 8)).toList(), List.of(2, 3, 2));
        Check.eq(Ch23LinkedLists.addDigitLists(Ch23LinkedListsTest.of(9, 9), Ch23LinkedListsTest.of(1)).toList(), List.of(0, 0, 1));
        Check.eq(Ch23LinkedLists.addDigitLists(Ch23LinkedListsTest.of(), Ch23LinkedListsTest.of()).toList(), List.of());
        Check.eq(Ch23LinkedLists.addDigitLists(Ch23LinkedListsTest.of(0), Ch23LinkedListsTest.of(0)).toList(), List.of(0));
        Check.eq(Ch23LinkedLists.addDigitLists(Ch23LinkedListsTest.of(5), Ch23LinkedListsTest.of()).toList(), List.of(5));
    }
}

class Ex23_19Test {
    public static void run() {
        Ch23LinkedLists.Node shared = Ch23LinkedListsTest.of(8, 9).head;
        Ch23LinkedLists.LinkedList a = withHead(new Ch23LinkedLists.Node(1, new Ch23LinkedLists.Node(2, shared)));
        Ch23LinkedLists.LinkedList b = withHead(new Ch23LinkedLists.Node(5, shared));
        Check.yes(Ch23LinkedLists.meetingNode(a, b) == shared);
        Check.yes(Ch23LinkedLists.meetingNode(b, a) == shared);
        Check.yes(Ch23LinkedLists.meetingNode(Ch23LinkedListsTest.of(1, 2), Ch23LinkedListsTest.of(3)) == null);
        Check.yes(Ch23LinkedLists.meetingNode(a, a) == a.head);
        Check.yes(Ch23LinkedLists.meetingNode(Ch23LinkedListsTest.of(), b) == null);
    }

    static Ch23LinkedLists.LinkedList withHead(Ch23LinkedLists.Node head) {
        Ch23LinkedLists.LinkedList list = new Ch23LinkedLists.LinkedList();
        list.head = head;
        return list;
    }
}

class Ex23_20Test {
    public static void run() {
        Ch23LinkedLists.LinkedList list = Ch23LinkedListsTest.of(1, 2, 3, 2, 1);
        Check.yes(Ch23LinkedLists.isPalindromeList(list));
        Check.eq(list.toList(), List.of(1, 2, 3, 2, 1));
        list = Ch23LinkedListsTest.of(1, 2, 3, 1);
        Check.no(Ch23LinkedLists.isPalindromeList(list));
        Check.eq(list.toList(), List.of(1, 2, 3, 1));
        Check.yes(Ch23LinkedLists.isPalindromeList(Ch23LinkedListsTest.of(1, 2, 2, 1)));
        Check.no(Ch23LinkedLists.isPalindromeList(Ch23LinkedListsTest.of(1, 2)));
        Check.yes(Ch23LinkedLists.isPalindromeList(Ch23LinkedListsTest.of()));
        Check.yes(Ch23LinkedLists.isPalindromeList(Ch23LinkedListsTest.of(4)));
    }
}

class Ex23_21Test {
    public static void run() {
        int[] ks = {2, 7, 0, 5, 1};
        List<List<Integer>> want = List.of(List.of(4, 5, 1, 2, 3), List.of(4, 5, 1, 2, 3), List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5), List.of(5, 1, 2, 3, 4));
        for (int i = 0; i < ks.length; i++) {
            Ch23LinkedLists.LinkedList list = Ch23LinkedListsTest.of(1, 2, 3, 4, 5);
            Ch23LinkedLists.rotateRight(list, ks[i]);
            Check.eq(list.toList(), want.get(i));
        }
        Ch23LinkedLists.LinkedList empty = Ch23LinkedListsTest.of();
        Ch23LinkedLists.rotateRight(empty, 3);
        Check.eq(empty.toList(), List.of());
    }
}

class Ex23_22Test {
    public static void run() {
        int[][] cases = {{1, 2, 3, 4, 5}, {1, 2, 3, 4}, {1, 2}, {1}, {}};
        List<List<Integer>> want = List.of(List.of(1, 5, 2, 4, 3), List.of(1, 4, 2, 3), List.of(1, 2), List.of(1), List.of());
        for (int i = 0; i < cases.length; i++) {
            Ch23LinkedLists.LinkedList list = Ch23LinkedListsTest.of(cases[i]);
            Ch23LinkedLists.interleaveEnds(list);
            Check.eq(list.toList(), want.get(i));
        }
    }
}

class Ex23_23Test {
    public static void run() {
        Ch23LinkedLists.LinkedList list = Ch23LinkedListsTest.of(1, 2, 3, 4, 5);
        Ch23LinkedLists.Node first = list.head;
        Ch23LinkedLists.swapPairs(list);
        Check.eq(list.toList(), List.of(2, 1, 4, 3, 5));
        Check.yes(list.head.next == first);
        int[][] cases = {{}, {1}, {1, 2}, {1, 2, 3, 4}};
        List<List<Integer>> want = List.of(List.of(), List.of(1), List.of(2, 1), List.of(2, 1, 4, 3));
        for (int i = 0; i < cases.length; i++) {
            list = Ch23LinkedListsTest.of(cases[i]);
            Ch23LinkedLists.swapPairs(list);
            Check.eq(list.toList(), want.get(i));
        }
    }
}

class Ex23_24Test {
    public static void run() {
        Ch23LinkedLists.LinkedList list = Ch23LinkedListsTest.of(3, 1, 2);
        Ch23LinkedLists.Node three = list.head;
        Ch23LinkedLists.sortList(list);
        Check.eq(list.toList(), List.of(1, 2, 3));
        Check.yes(list.head.next.next == three);
        int[][] cases = {{5, 1, 4, 2, 3, 1}, {}, {2, 1}, {7}, {4, 4, 1, 9, 0, 3, 8}};
        for (int[] values : cases) {
            list = Ch23LinkedListsTest.of(values);
            Ch23LinkedLists.sortList(list);
            int[] sorted = values.clone();
            Arrays.sort(sorted);
            Check.eq(list.toList(), Arrays.stream(sorted).boxed().toList());
        }
    }
}

class Ex23_25Test {
    public static void run() {
        int[][] cases = {{1, 1, 2, 3, 3, 3}, {}, {4, 4}, {1, 2}, {0, 0, 0, 5}};
        List<List<Integer>> want = List.of(List.of(1, 2, 3), List.of(), List.of(4), List.of(1, 2), List.of(0, 5));
        for (int i = 0; i < cases.length; i++) {
            Ch23LinkedLists.LinkedList list = Ch23LinkedListsTest.of(cases[i]);
            Ch23LinkedLists.dropSortedDuplicates(list);
            Check.eq(list.toList(), want.get(i));
        }
    }
}

class Ex23_26Test {
    public static void run() {
        int[][] cases = {{4, 1, 6, 2, 5, 2}, {3, 1}, {}, {5, 6, 1}, {9, 2, 8, 1}};
        int[] xs = {4, 0, 5, 9, 5};
        List<List<Integer>> want = List.of(List.of(1, 2, 2, 4, 6, 5), List.of(3, 1), List.of(), List.of(5, 6, 1), List.of(2, 1, 9, 8));
        for (int i = 0; i < cases.length; i++) {
            Ch23LinkedLists.LinkedList list = Ch23LinkedListsTest.of(cases[i]);
            Ch23LinkedLists.partitionList(list, xs[i]);
            Check.eq(list.toList(), want.get(i));
        }
    }
}

class Ex23_27Test {
    public static void run() {
        Ch23LinkedLists.MultiNode[] n = new Ch23LinkedLists.MultiNode[9];
        for (int v = 1; v <= 8; v++) n[v] = new Ch23LinkedLists.MultiNode(v);
        n[1].next = n[2];
        n[2].next = n[3];
        n[3].next = n[4];
        n[5].next = n[6];
        n[2].child = n[5];
        n[5].child = n[7];
        n[4].child = n[8];
        List<Integer> values = new ArrayList<>();
        for (Ch23LinkedLists.MultiNode node = Ch23LinkedLists.flatten(n[1]); node != null; node = node.next) {
            Check.yes(node.child == null);
            values.add(node.data);
        }
        Check.eq(values, List.of(1, 2, 5, 7, 6, 3, 4, 8));
        Check.yes(Ch23LinkedLists.flatten(null) == null);
    }
}

class Ex23_28Test {
    public static void run() {
        Check.eq(Ch23LinkedLists.cycleStartAndLength(x -> (x * x + 1) % 11, 0), new int[] {4, 2});
        Check.eq(Ch23LinkedLists.cycleStartAndLength(x -> (x + 1) % 5, 0), new int[] {0, 5});
        Check.eq(Ch23LinkedLists.cycleStartAndLength(x -> x / 2, 20), new int[] {5, 1});
        Check.eq(Ch23LinkedLists.cycleStartAndLength(Ex23_28Test::digitSquares, 7), new int[] {5, 1});
        Check.eq(Ch23LinkedLists.cycleStartAndLength(Ex23_28Test::digitSquares, 4), new int[] {0, 8});
    }

    static int digitSquares(int x) {
        int sum = 0;
        for (; x > 0; x /= 10) sum += (x % 10) * (x % 10);
        return sum;
    }
}
