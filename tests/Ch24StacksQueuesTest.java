import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/** Chapter 24 tests, one class per exercise. */

class Ex24_1Test {
    public static void run() {
        Ch24StacksQueues.Stack<Integer> st = new Ch24StacksQueues.Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        Check.eq(st.read(), 3);
        Check.eq(st.pop(), 3);
        Check.eq(st.read(), 2);
        Check.eq(st.size(), 2);
        Check.eq(new Ch24StacksQueues.Stack<Integer>().pop(), null);
    }
}

class Ex24_2Test {
    public static void run() {
        Ch24StacksQueues.Queue<Integer> q = new Ch24StacksQueues.Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        Check.eq(q.dequeue(), 1);
        Check.eq(q.read(), 2);
        Check.eq(new Ch24StacksQueues.Queue<Integer>().dequeue(), null);
    }
}

class Ex24_3Test {
    public static void run() {
        Check.yes(Ch24StacksQueues.tagsBalanced("<p><b>hi</b></p>"));
        Check.no(Ch24StacksQueues.tagsBalanced("<p><b></p></b>"));
        Check.no(Ch24StacksQueues.tagsBalanced("<p>"));
        Check.no(Ch24StacksQueues.tagsBalanced("</p>"));
        Check.yes(Ch24StacksQueues.tagsBalanced("plain text"));
        Check.yes(Ch24StacksQueues.tagsBalanced("<a><b></b><c>x</c></a>"));
        Check.no(Ch24StacksQueues.tagsBalanced("<a></a></a>"));
    }
}

class Ex24_4Test {
    public static void run() {
        Check.eq(Ch24StacksQueues.simplifyPath("/a/./b/../c/"), "/a/c");
        Check.eq(Ch24StacksQueues.simplifyPath("/../"), "/");
        Check.eq(Ch24StacksQueues.simplifyPath("/home//user/"), "/home/user");
        Check.eq(Ch24StacksQueues.simplifyPath("/a/b/../../.."), "/");
        Check.eq(Ch24StacksQueues.simplifyPath("/x/y/./z"), "/x/y/z");
    }
}

class Ex24_5Test {
    public static void run() {
        Check.eq(Ch24StacksQueues.roundRobin(new String[]{"a", "b", "c"}, new int[]{3, 1, 2}, 1), List.of("b", "c", "a"));
        Check.eq(Ch24StacksQueues.roundRobin(new String[]{"a", "b", "c"}, new int[]{3, 1, 2}, 5), List.of("a", "b", "c"));
        Check.eq(Ch24StacksQueues.roundRobin(new String[]{"x", "y"}, new int[]{4, 4}, 2), List.of("x", "y"));
        Check.eq(Ch24StacksQueues.roundRobin(new String[]{}, new int[]{}, 3), List.of());
    }
}

class Ex24_6Test {
    public static void run() {
        Ch24StacksQueues.StackQueue<Integer> sq = new Ch24StacksQueues.StackQueue<>();
        sq.enqueue(1);
        sq.enqueue(2);
        Check.eq(sq.dequeue(), 1);
        sq.enqueue(3);
        Check.eq(sq.dequeue(), 2);
        Check.eq(sq.dequeue(), 3);
        Check.eq(sq.dequeue(), null);
    }
}

class Ex24_7Test {
    public static void run() {
        Check.eq(Ch24StacksQueues.evalRpn(new String[]{"3", "4", "+", "2", "*"}), 14.0);
        Check.eq(Ch24StacksQueues.evalRpn(new String[]{"8", "2", "-"}), 6.0);
        Check.eq(Ch24StacksQueues.evalRpn(new String[]{"9", "2", "/"}), 4.5);
    }
}

class Ex24_8Test {
    public static void run() {
        Ch24StacksQueues.Editor ed = new Ch24StacksQueues.Editor();
        ed.type("a");
        ed.type("b");
        Check.eq(ed.undo(), "a");
        Check.eq(ed.redo(), "ab");
        ed.undo();
        ed.type("c");
        Check.eq(ed.redo(), "ac");
    }
}

class Ex24_9Test {
    public static void run() {
        Ch24StacksQueues.CircularQueue cq = new Ch24StacksQueues.CircularQueue(3);
        Check.yes(cq.enqueue(1));
        Check.yes(cq.enqueue(2));
        Check.yes(cq.enqueue(3));
        Check.no(cq.enqueue(4));
        Check.eq(cq.dequeue(), 1);
        Check.yes(cq.enqueue(4));
        Check.eq(cq.data[0], 4);
        Check.eq(cq.dequeue(), 2);
        Check.eq(cq.dequeue(), 3);
        Check.eq(cq.dequeue(), 4);
        Check.eq(cq.dequeue(), null);
    }
}

class Ex24_10Test {
    public static void run() {
        Ch24StacksQueues.MinMaxStack s = new Ch24StacksQueues.MinMaxStack();
        s.push(5);
        s.push(2);
        s.push(8);
        Check.eq(new int[] {s.min(), s.max(), s.peek()}, new int[] {2, 8, 8});
        Check.eq(s.pop(), 8);
        Check.eq(new int[] {s.min(), s.max()}, new int[] {2, 5});
        Check.eq(s.pop(), 2);
        Check.eq(new int[] {s.min(), s.max()}, new int[] {5, 5});
        s.push(5);
        s.push(-1);
        Check.eq(new int[] {s.min(), s.max(), s.peek()}, new int[] {-1, 5, -1});
    }
}

class Ex24_11Test {
    public static void run() {
        Check.eq(Ch24StacksQueues.nextGreater(new int[] {2, 7, 3, 5, 4, 6, 8}), new int[] {7, 8, 5, 6, 6, 8, -1});
        Check.eq(Ch24StacksQueues.nextGreater(new int[0]), new int[0]);
        Check.eq(Ch24StacksQueues.nextGreater(new int[] {5, 4, 3}), new int[] {-1, -1, -1});
        Check.eq(Ch24StacksQueues.nextGreater(new int[] {1, 1, 2}), new int[] {2, 2, -1});
    }
}

class Ex24_12Test {
    public static void run() {
        Check.eq(Ch24StacksQueues.sunsetView(new int[] {3, 5, 4, 4, 3, 1, 3, 2}), List.of(1, 3, 6, 7));
        Check.eq(Ch24StacksQueues.sunsetView(new int[0]), List.of());
        Check.eq(Ch24StacksQueues.sunsetView(new int[] {1, 2, 3}), List.of(2));
        Check.eq(Ch24StacksQueues.sunsetView(new int[] {3, 2, 1}), List.of(0, 1, 2));
        Check.eq(Ch24StacksQueues.sunsetView(new int[] {2, 2}), List.of(1));
    }
}

class Ex24_13Test {
    public static void run() {
        Check.eq(Ch24StacksQueues.largestRectangle(new int[] {2, 4, 3, 5, 1, 3}), 9);
        Check.eq(Ch24StacksQueues.largestRectangle(new int[] {2, 1, 2}), 3);
        Check.eq(Ch24StacksQueues.largestRectangle(new int[0]), 0);
        Check.eq(Ch24StacksQueues.largestRectangle(new int[] {5}), 5);
        Check.eq(Ch24StacksQueues.largestRectangle(new int[] {1, 1, 1, 1}), 4);
        Check.eq(Ch24StacksQueues.largestRectangle(new int[] {2, 3, 4, 5}), 9);
    }
}

class Ex24_14Test {
    public static void run() {
        Check.eq(popAll(Ch24StacksQueues.sortStack(pushAll(3, 1, 4, 2))), List.of(4, 3, 2, 1));
        Deque<Integer> stack = pushAll(5, 9);
        Ch24StacksQueues.sortStack(stack);
        Check.yes(stack.isEmpty());
        Check.eq(popAll(Ch24StacksQueues.sortStack(pushAll())), List.of());
        Check.eq(popAll(Ch24StacksQueues.sortStack(pushAll(2, 2, 1))), List.of(2, 2, 1));
    }

    static Deque<Integer> pushAll(int... values) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int v : values) stack.push(v);
        return stack;
    }

    static List<Integer> popAll(Deque<Integer> stack) {
        List<Integer> out = new ArrayList<>();
        while (!stack.isEmpty()) out.add(stack.pop());
        return out;
    }
}

class Ex24_15Test {
    public static void run() {
        Check.eq(Ch24StacksQueues.afterCollisions(new int[] {-3, 4, 9, -6, 2, -2, 7}), List.of(-3, 4, 9, 7));
        Check.eq(Ch24StacksQueues.afterCollisions(new int[] {4, 9, -6, 2, -2, -10}), List.of(-10));
        Check.eq(Ch24StacksQueues.afterCollisions(new int[] {5, -5}), List.of());
        Check.eq(Ch24StacksQueues.afterCollisions(new int[] {-1, 1}), List.of(-1, 1));
        Check.eq(Ch24StacksQueues.afterCollisions(new int[0]), List.of());
    }
}

class Ex24_16Test {
    public static void run() {
        Check.eq(Ch24StacksQueues.windowMax(new int[] {4, 2, 12, 3, 8, 1, 7}, 3), new int[] {12, 12, 12, 8, 8});
        Check.eq(Ch24StacksQueues.windowMax(new int[] {3, 1, 2}, 1), new int[] {3, 1, 2});
        Check.eq(Ch24StacksQueues.windowMax(new int[] {3, 1, 2}, 3), new int[] {3});
        Check.eq(Ch24StacksQueues.windowMax(new int[] {5, 4, 3, 2, 1}, 2), new int[] {5, 4, 3, 2});
        Check.eq(Ch24StacksQueues.windowMax(new int[] {1, 3, 3, 1}, 2), new int[] {3, 3, 3});
    }
}

class Ex24_17Test {
    public static void run() {
        String[] cases = {"(()())())(", "", ")(", "()(()", "(()", "()()", "))()(())"};
        int[] want = {8, 0, 0, 2, 2, 4, 6};
        for (int i = 0; i < cases.length; i++) Check.eq(Ch24StacksQueues.longestBalanced(cases[i]), want[i]);
    }
}

class Ex24_18Test {
    public static void run() {
        Ch24StacksQueues.QueueStack s = new Ch24StacksQueues.QueueStack();
        Check.yes(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        Check.eq(s.pop(), 3);
        Check.eq(s.peek(), 2);
        Check.no(s.isEmpty());
        s.push(4);
        Check.eq(new int[] {s.pop(), s.pop(), s.pop()}, new int[] {4, 2, 1});
        Check.yes(s.isEmpty());
    }
}

class Ex24_19Test {
    public static void run() {
        Deque<Integer> q = new ArrayDeque<>(List.of(1, 2, 3, 4, 5));
        Check.yes(Ch24StacksQueues.reverseFirstK(q, 3) == q);
        Check.eq(new ArrayList<>(q), List.of(3, 2, 1, 4, 5));
        Check.eq(new ArrayList<>(Ch24StacksQueues.reverseFirstK(new ArrayDeque<>(List.of(1, 2, 3)), 0)), List.of(1, 2, 3));
        Check.eq(new ArrayList<>(Ch24StacksQueues.reverseFirstK(new ArrayDeque<>(List.of(1, 2, 3)), 3)), List.of(3, 2, 1));
        Check.eq(new ArrayList<>(Ch24StacksQueues.reverseFirstK(new ArrayDeque<>(), 0)), List.of());
    }
}

class Ex24_20Test {
    public static void run() {
        Check.eq(Ch24StacksQueues.binaryNumbers(5), List.of("1", "10", "11", "100", "101"));
        Check.eq(Ch24StacksQueues.binaryNumbers(0), List.of());
        Check.eq(Ch24StacksQueues.binaryNumbers(1), List.of("1"));
        List<String> sixteen = Ch24StacksQueues.binaryNumbers(16);
        for (int i = 1; i <= 16; i++) Check.eq(sixteen.get(i - 1), Integer.toBinaryString(i));
    }
}
