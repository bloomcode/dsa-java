import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Runs every exercise test class (Ex3_2Test, ...) found in the output directory and reports results.
 * Usage: java -cp out RunAll out [3.2 | 3]   (one exercise, one chapter, or everything)
 */
public final class RunAll {
    private static final Pattern NAME = Pattern.compile("Ex(\\d+)_(\\d+)Test");

    public static void main(String[] args) throws Exception {
        File[] files = new File(args.length > 0 ? args[0] : "out").listFiles();
        String only = args.length > 1 ? args[1] : null;
        List<int[]> ids = new ArrayList<>();
        for (File f : files == null ? new File[0] : files) {
            Matcher m = NAME.matcher(f.getName().replace(".class", ""));
            if (!f.getName().endsWith(".class") || !m.matches()) continue;
            int ch = Integer.parseInt(m.group(1)), num = Integer.parseInt(m.group(2));
            if (only == null || only.equals(ch + "." + num) || only.equals(String.valueOf(ch))) ids.add(new int[]{ch, num});
        }
        ids.sort(Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        if (ids.isEmpty()) {
            System.out.println("no exercise tests found" + (only == null ? "" : " for " + only));
            System.exit(1);
        }
        int failed = 0;
        for (int[] id : ids) {
            String name = "Ex" + id[0] + "_" + id[1] + "Test", label = id[0] + "." + id[1];
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
