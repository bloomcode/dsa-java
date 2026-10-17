import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Chapter 12: Dynamic programming: memoize or build up. */
public class Ch12DynamicProgramming {

    // ==== EX 12.1 | Fibonacci three ways | Core
    // PROMPT: Write `static long fibNaive(int n)`, `static long fibMemo(int n, Map<Integer, Long> memo)` and `static long fibBottomUp(int n)`, with fib(0) = 0 and fib(1) = 1.
    // EXAMPLE: All three return `55` for `n = 10`; only the last two finish quickly for `n = 80`
    // BIGO: Naive O(2^N); memoised O(N) time and space; bottom-up O(N) time and O(1) space.
    // NOTE: fib(92) is the largest that fits in a `long`. When the subproblems are small integers, a `long[]` memo beats a `HashMap<Integer, Long>`.
    static long fibNaive(int n) {
        throw new UnsupportedOperationException();
    }

    static long fibMemo(int n, Map<Integer, Long> memo) {
        throw new UnsupportedOperationException();
    }

    static long fibBottomUp(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 12.2 | Fix the double recursive call | Core
    // PROMPT: This version calls itself twice per level: `return arr[i] > maxBad(arr, i + 1) ? arr[i] : maxBad(arr, i + 1);`. Write `static int maxRecursive(int[] arr, int i)` that calls itself once per level.
    // EXAMPLE: `maxRecursive(new int[]{1, 2, 3, 4}, 0)` -> `4`
    // BIGO: From O(2^N) to O(N), just by storing the recursive result in a variable.
    static int maxRecursive(int[] arr, int i) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 12.3 | Staircase with memoization | Core
    // PROMPT: Rewrite 11.8 as `static long staircaseMemo(int n, long[] memo)`, with `memo` filled with -1 by the caller.
    // EXAMPLE: `staircaseMemo(5, ...)` -> `13`; `n = 50` -> `10562230626642` at once
    // BIGO: O(N).
    static long staircaseMemo(int n, long[] memo) {
        throw new UnsupportedOperationException();
    }

    static long staircaseMemo(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 12.4 | Unique paths with memoization | Core
    // PROMPT: Rewrite 11.10 as `static long uniquePathsMemo(int rows, int cols, Map<String, Long> memo)`, keyed by `rows + "," + cols`.
    // EXAMPLE: `uniquePathsMemo(3, 7, ...)` -> `28`; `(18, 18)` -> `2333606220`
    // BIGO: O(rows * cols): each sub-grid is solved once.
    // NOTE: A `long[][]` table indexed by `[rows][cols]` avoids building a String key on every call; try it as a follow-up.
    static long uniquePathsMemo(int rows, int cols, Map<String, Long> memo) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 12.5 | Count the calls | Practice
    // PROMPT: Write `static long[] countFibCalls(int n)` returning `{naiveCalls, memoCalls}`: how many times each Fibonacci version is invoked. Count with a `long[]` counter passed to the helpers.
    // EXAMPLE: `countFibCalls(10)` -> `[177, 19]`
    // BIGO: Shows overlapping subproblems directly: naive calls grow about 1.6x per step of n, memo calls by 2.
    static long[] countFibCalls(int n) {
        throw new UnsupportedOperationException();
    }

    private static long naive(int k, long[] calls) {
        throw new UnsupportedOperationException();
    }

    private static long memo(int k, Map<Integer, Long> cache, long[] calls) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 12.6 | Fewest coins, bottom-up | Stretch
    // PROMPT: Write `static int minCoins(int[] coins, int amount)` filling a table `best[0..amount]` from the bottom up. Return `-1` if the amount cannot be made.
    // EXAMPLE: `{1, 5, 10, 25}`, 63 -> `6`; `{2}`, 3 -> `-1`
    // BIGO: O(amount * number of coins) time, O(amount) space.
    // NOTE: Greedy (largest coin first) fails for coins like `{1, 3, 4}` and amount 6: greedy gives 3 coins, the answer is 2. Use `Integer.MAX_VALUE` as "impossible" only if you check it before adding 1.
    static int minCoins(int[] coins, int amount) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
