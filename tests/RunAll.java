import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Runs every exercise test class (Ex3_2Test, ...) found in the output directory and reports results.
 * Usage: java -cp out RunAll out [3.2 | 3]   (one exercise, one chapter, or everything; dsa ids look like 2.5.3 and 2.5)
 */
public final class RunAll {
    private static final Pattern NAME = Pattern.compile("Ex((?:\\d+_)*\\d+)_(\\d+)Test");

    public static void main(String[] args) throws Exception {
        File[] files = new File(args.length > 0 ? args[0] : "out").listFiles();
        String only = args.length > 1 ? args[1] : null;
        List<int[]> ids = new ArrayList<>(); // chapter numbers, then the exercise number
        for (File f : files == null ? new File[0] : files) {
            Matcher m = NAME.matcher(f.getName().replace(".class", ""));
            if (!f.getName().endsWith(".class") || !m.matches()) continue;
            String ch = m.group(1).replace('_', '.'), label = ch + "." + m.group(2);
            if (only == null || only.equals(label) || only.equals(ch))
                ids.add(Arrays.stream(label.split("\\.")).mapToInt(Integer::parseInt).toArray());
        }
        ids.sort(Arrays::compare);
        if (ids.isEmpty()) {
            System.out.println("no exercise tests found" + (only == null ? "" : " for " + only));
            System.exit(1);
        }
        int failed = 0;
        for (int[] id : ids) {
            StringJoiner under = new StringJoiner("_"), dot = new StringJoiner(".");
            for (int x : id) {
                under.add(String.valueOf(x));
                dot.add(String.valueOf(x));
            }
            String name = "Ex" + under + "Test", label = dot.toString();
            try {
                Class.forName(name).getMethod("run").invoke(null);
                System.out.println("PASS " + label);
            } catch (java.lang.reflect.InvocationTargetException e) {
                failed++;
                System.out.println("FAIL " + label + ": " + e.getCause());
                StackTraceElement[] st = e.getCause().getStackTrace();
                for (int i = 0; i < Math.min(4, st.length); i++) System.out.println("    at " + st[i]);
            }
        }
        System.out.println(ids.size() - failed + " of " + ids.size() + " exercises passed, " + Check.passed + " checks");
        if (failed > 0) System.exit(1);
    }
}
