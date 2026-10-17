import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Chapter 10: Recursion: a base case and a smaller problem. */
public class Ch10Recursion {

    // ==== EX 10.1 | Countdown | Core
    // PROMPT: Write `static List<Integer> countdown(int n)` recursively, returning the list from n down to 0. Identify the base case first.
    // EXAMPLE: `countdown(3)` -> `[3, 2, 1, 0]`
    // BIGO: O(N) time, O(N) call-stack depth.
    static List<Integer> countdown(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 10.2 | Factorial | Core
    // PROMPT: Write `static long factorial(int n)` recursively.
    // EXAMPLE: `factorial(5)` -> `120`; `factorial(0)` -> `1`; `factorial(20)` -> `2432902008176640000`
    // BIGO: O(N).
    // NOTE: 20! is the largest factorial that fits in a `long`; 13! already overflows an `int`. Use `BigInteger` beyond that.
    static long factorial(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 10.3 | Sum an array recursively | Core
    // PROMPT: Write `static long sumRecursive(int[] arr, int index)` that sums from `index` to the end. Pass an index instead of copying the array on every call.
    // EXAMPLE: `sumRecursive(new int[]{1, 2, 3, 4}, 0)` -> `10`
    // BIGO: O(N) time and stack depth. Copying with `Arrays.copyOfRange` on each call would add hidden O(N) work per call.
    static long sumRecursive(int[] arr, int index) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 10.4 | Flatten nested lists | Core
    // PROMPT: Write `static List<Integer> flatten(List<?> nested)` returning every number in a list that may contain lists to any depth, in order. Use `instanceof` to tell a number from a sub-list.
    // EXAMPLE: `List.of(1, List.of(2, List.of(3, 4)), 5)` -> `[1, 2, 3, 4, 5]`
    // BIGO: O(N) in the total number of items. Recursion fits because the depth is unknown in advance.
    static List<Integer> flatten(List<?> nested) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 10.5 | Fast power | Practice
    // PROMPT: Write `static long power(long x, int n)` for `n >= 0` by squaring: x^n = (x^(n/2))^2, times x if n is odd.
    // EXAMPLE: `power(2, 10)` -> `1024`; `power(3, 0)` -> `1`
    // BIGO: O(log N): each call halves n.
    static long power(long x, int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 10.6 | Filesystem traversal | Core
    // PROMPT: Model a filesystem as nested maps (`name -> subtree`; files map to `null`). Write `static List<String> allDirectories(Map<String, Object> tree, String path)` returning every directory path, depth first.
    // EXAMPLE: `{docs={old={}, a.txt=null}, src={}}` with path `""` -> `[/docs, /docs/old, /src]`
    // BIGO: O(N) in the number of entries.
    // NOTE: The real version uses `Files.newDirectoryStream(dir)` and `Files.isDirectory(entry)`: same shape, same recursion.
    @SuppressWarnings("unchecked")
    static List<String> allDirectories(Map<String, Object> tree, String path) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 10.7 | Every number from low to high | Core
    // PROMPT: Write `static List<Integer> numbersBetween(int low, int high)` recursively returning `[low, ..., high]`.
    // EXAMPLE: `numbersBetween(3, 6)` -> `[3, 4, 5, 6]`
    // BIGO: O(N) calls. Adding at the front of an ArrayList shifts, so build from the high end: append `high` after the recursive call on `high - 1`.
    static List<Integer> numbersBetween(int low, int high) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
