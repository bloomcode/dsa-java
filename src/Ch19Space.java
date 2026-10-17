import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Chapter 19: Counting memory: space complexity. */
public class Ch19Space {

    // ==== EX 19.1 | Uppercase: new array vs in place | Core
    // PROMPT: Write `static List<String> uppercaseCopy(List<String> words)` returning a new list and `static List<String> uppercaseInPlace(List<String> words)` modifying the original with `set`. State the space complexity of each.
    // EXAMPLE: `[amy, bob]` -> `[AMY, BOB]` either way
    // BIGO: Both O(N) time. Copy is O(N) extra space; in place is O(1) extra space beyond the new strings themselves.
    static List<String> uppercaseCopy(List<String> words) {
        throw new UnsupportedOperationException();
    }

    static List<String> uppercaseInPlace(List<String> words) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 19.2 | Duplicates: three time/space trade-offs | Core
    // PROMPT: Implement three duplicate checks and fill in a time/space table: nested loops (`dupNested`), a `HashSet` (`dupSet`), and sort-in-place (`dupSortInPlace`, which reorders the input).
    // EXAMPLE: All three: `{3, 1, 4, 1}` -> `true`
    // BIGO: Nested: O(N^2) time, O(1) space. Set: O(N) time, O(N) space. Sort in place: O(N log N) time; `Arrays.sort(int[])` needs only O(log N) stack. Choose by which resource is scarcer.
    static boolean dupNested(int[] arr) {
        throw new UnsupportedOperationException();
    }

    static boolean dupSet(int[] arr) {
        throw new UnsupportedOperationException();
    }

    static boolean dupSortInPlace(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 19.3 | The hidden cost of recursion | Core
    // PROMPT: Write `static long sumToRecursive(int n)` and `static long sumToIterative(int n)`. Then write `static boolean overflows(int n)` that runs the recursive version on a thread with a 512 KB stack and returns `true` if it throws `StackOverflowError`.
    // EXAMPLE: `sumToIterative(50_000)` -> `1250025000`; `overflows(1_000_000)` -> `true`; `overflows(1_000)` -> `false`
    // BIGO: Both O(N) time. Recursive uses O(N) stack space; iterative uses O(1).
    // NOTE: Java has no recursion-limit setting like Python's; the limit is the thread's stack size, set with `-Xss` or the `Thread` constructor.
    static long sumToRecursive(int n) {
        throw new UnsupportedOperationException();
    }

    static long sumToIterative(int n) {
        throw new UnsupportedOperationException();
    }

    static boolean overflows(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 19.4 | Reverse an array without extra space | Core
    // PROMPT: Write `static int[] reverseCopy(int[] arr)` (new array) and compare with your 1.16 `reverseInPlace`. Which would you use for a 1 GB array?
    // EXAMPLE: `{1, 2, 3}` -> `[3, 2, 1]`
    // BIGO: Copy: O(N) time, O(N) space. In place: O(N) time, O(1) space.
    static int[] reverseCopy(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 19.5 | Palindrome in O(1) space | Practice
    // PROMPT: `new StringBuilder(s).reverse()` builds a full reversed copy. Write `static boolean isPalindromeClean(String s)` that ignores case and anything that is not a letter or digit, using two pointers and no new string.
    // EXAMPLE: `"A man, a plan, a canal: Panama"` -> `true`
    // BIGO: O(N) time, O(1) extra space.
    static boolean isPalindromeClean(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
