import java.util.*;

/** Tiny assertion helper so the tests need nothing beyond the JDK. */
public final class Check {
    static int passed = 0;

    private Check() {}

    public static void eq(Object actual, Object expected) {
        if (!Objects.deepEquals(actual, expected))
            throw new AssertionError("expected " + show(expected) + " but got " + show(actual));
        passed++;
    }

    public static void yes(boolean cond) {
        if (!cond) throw new AssertionError("expected true");
        passed++;
    }

    public static void no(boolean cond) { yes(!cond); }

    public static void near(double actual, double expected, double eps) {
        if (Math.abs(actual - expected) > eps) throw new AssertionError("expected ~" + expected + " but got " + actual);
        passed++;
    }

    public static void throwsEx(Class<? extends Throwable> type, Runnable r) {
        try {
            r.run();
        } catch (Throwable e) {
            if (type.isInstance(e)) { passed++; return; }
            throw new AssertionError("expected " + type.getSimpleName() + " but got " + e);
        }
        throw new AssertionError("expected " + type.getSimpleName());
    }

    static String show(Object o) {
        if (o instanceof int[] a) return Arrays.toString(a);
        if (o instanceof long[] a) return Arrays.toString(a);
        if (o instanceof char[] a) return Arrays.toString(a);
        if (o instanceof boolean[] a) return Arrays.toString(a);
        if (o instanceof double[] a) return Arrays.toString(a);
        if (o instanceof Object[] a) return Arrays.deepToString(a);
        return String.valueOf(o);
    }
}
