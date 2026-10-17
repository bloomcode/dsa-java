import java.util.List;

/** Chapter 9 tests, one class per exercise. */
class Ex9_1Test {
    public static void run() {
        Ch09StacksQueues.Stack<Integer> st = new Ch09StacksQueues.Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        Check.eq(st.read(), 3);
        Check.eq(st.pop(), 3);
        Check.eq(st.read(), 2);
        Check.eq(st.size(), 2);
        Check.eq(new Ch09StacksQueues.Stack<Integer>().pop(), null);
    }
}

class Ex9_2Test {
    public static void run() {
        Ch09StacksQueues.Queue<Integer> q = new Ch09StacksQueues.Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        Check.eq(q.dequeue(), 1);
        Check.eq(q.read(), 2);
        Check.eq(new Ch09StacksQueues.Queue<Integer>().dequeue(), null);
    }
}

class Ex9_3Test {
    public static void run() {
        Check.eq(Ch09StacksQueues.lint("(var x = {y: [1, 2, 3]})"), null);
        Check.eq(Ch09StacksQueues.lint("(var x = 2;"), "( has no closing brace");
        Check.eq(Ch09StacksQueues.lint("var x = 2)"), ") has no opening brace");
        Check.eq(Ch09StacksQueues.lint("(var x = [1, 2)"), ") has mismatched opening brace");
    }
}

class Ex9_4Test {
    public static void run() {
        Check.eq(Ch09StacksQueues.reverseWithStack("abcde"), "edcba");
        Check.eq(Ch09StacksQueues.reverseWithStack(""), "");
    }
}

class Ex9_5Test {
    public static void run() {
        Ch09StacksQueues.PrintManager pm = new Ch09StacksQueues.PrintManager();
        pm.queueJob("First");
        pm.queueJob("Second");
        pm.queueJob("Third");
        Check.eq(pm.run(), List.of("First", "Second", "Third"));
    }
}

class Ex9_6Test {
    public static void run() {
        Ch09StacksQueues.StackQueue<Integer> sq = new Ch09StacksQueues.StackQueue<>();
        sq.enqueue(1);
        sq.enqueue(2);
        Check.eq(sq.dequeue(), 1);
        sq.enqueue(3);
        Check.eq(sq.dequeue(), 2);
        Check.eq(sq.dequeue(), 3);
        Check.eq(sq.dequeue(), null);
    }
}

class Ex9_7Test {
    public static void run() {
        Check.eq(Ch09StacksQueues.evalRpn(new String[]{"3", "4", "+", "2", "*"}), 14.0);
        Check.eq(Ch09StacksQueues.evalRpn(new String[]{"8", "2", "-"}), 6.0);
        Check.eq(Ch09StacksQueues.evalRpn(new String[]{"9", "2", "/"}), 4.5);
    }
}

class Ex9_8Test {
    public static void run() {
        Ch09StacksQueues.Editor ed = new Ch09StacksQueues.Editor();
        ed.type("a");
        ed.type("b");
        Check.eq(ed.undo(), "a");
        Check.eq(ed.redo(), "ab");
        ed.undo();
        ed.type("c");
        Check.eq(ed.redo(), "ac");
    }
}

class Ex9_9Test {
    public static void run() {
        Ch09StacksQueues.CircularQueue cq = new Ch09StacksQueues.CircularQueue(3);
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
