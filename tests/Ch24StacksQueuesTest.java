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
