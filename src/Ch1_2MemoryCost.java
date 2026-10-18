import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Chapter 1.2: Memory as a cost. */
public class Ch1_2MemoryCost {

    // ==== EX 1.2.1 | Scale scores: a copy or in place | Core
    // PROMPT: Write `static int[] scaledCopy(int[] scores, int factor)` returning a new array with every score multiplied by `factor`, and `static int[] scaleInPlace(int[] scores, int factor)` that changes the original array and returns it. State the extra space each one needs.
    // EXAMPLE: `{10, 20}, 3` -> `[30, 60]` either way
    // BIGO: Both O(N) time. The copy needs O(N) extra space; in place needs O(1).
    static int[] scaledCopy(int[] scores, int factor) {
        throw new UnsupportedOperationException();
    }

    static int[] scaleInPlace(int[] scores, int factor) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.2.2 | Most frequent value: three trade-offs | Core
    // PROMPT: Find the most frequent value of a non-empty array three ways, breaking ties toward the smaller value: `static int modeNested(int[] nums)` (count each value with an inner loop), `static int modeCounts(int[] nums)` (a `HashMap` of counts) and `static int modeSorted(int[] nums)` (sort the array in place, then find the longest run).
    // EXAMPLE: All three: `{4, 1, 4, 2, 1, 4}` -> `4`
    // BIGO: Nested loops: O(N^2) time, O(1) space. Counts table: O(N) time, O(N) space. Sort in place: O(N log N) time and no table of your own. Choose by which resource is scarcer.
    static int modeNested(int[] nums) {
        throw new UnsupportedOperationException();
    }

    static int modeCounts(int[] nums) {
        throw new UnsupportedOperationException();
    }

    static int modeSorted(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.2.3 | The call stack is memory too | Core
    // PROMPT: Write `static long sumListRecursive(int[] nums, int i)` (the sum of `nums[i..]`) and `static long sumListIterative(int[] nums)`. Then write `static boolean overflows(int n)` that runs the recursive version over an `n`-element array on a thread with a 512 KB stack and returns `true` if it throws `StackOverflowError`.
    // EXAMPLE: `sumListIterative(0..49,999)` -> `1249975000`; `overflows(1_000_000)` -> `true`; `overflows(1_000)` -> `false`
    // BIGO: Both O(N) time. The recursive version holds one stack frame per element, O(N) space; the loop uses O(1).
    // NOTE: Java has no recursion-limit setting like Python's; the limit is the thread's stack size, set with `-Xss` or the `Thread` constructor.
    static long sumListRecursive(int[] nums, int i) {
        throw new UnsupportedOperationException();
    }

    static long sumListIterative(int[] nums) {
        throw new UnsupportedOperationException();
    }

    static boolean overflows(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.2.4 | Rotate an array without extra space | Core
    // PROMPT: Rotate right by `k`: the last `k` items move to the front. Write `static int[] rotateCopy(int[] arr, int k)` returning a new array, and `static int[] rotateInPlace(int[] arr, int k)` that reverses the whole array, then the first `k` items, then the rest, and returns `arr`. Which would you use for a 1 GB array?
    // EXAMPLE: `{1, 2, 3, 4, 5}, 2` -> `[4, 5, 1, 2, 3]`
    // BIGO: Copy: O(N) time, O(N) space. Three reversals: O(N) time, O(1) space.
    static int[] rotateCopy(int[] arr, int k) {
        throw new UnsupportedOperationException();
    }

    static int[] rotateInPlace(int[] arr, int k) {
        throw new UnsupportedOperationException();
    }

    static void reverse(int[] arr, int lo, int hi) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.2.5 | Palindrome in O(1) space | Practice
    // PROMPT: `new StringBuilder(s).reverse()` builds a full reversed copy. Write `static boolean isPalindromeClean(String s)` that ignores case and anything that is not a letter or digit, using two pointers and no new string.
    // EXAMPLE: `"A man, a plan, a canal: Panama"` -> `true`
    // BIGO: O(N) time, O(1) extra space.
    static boolean isPalindromeClean(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
