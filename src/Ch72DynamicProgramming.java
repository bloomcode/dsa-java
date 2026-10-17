import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Chapter 72: Dynamic programming. */
public class Ch72DynamicProgramming {

    // ==== EX 72.1 | Fibonacci three ways | Core
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

    // ==== EX 72.2 | One recursive call per level | Core
    // PROMPT: A version that finds the rest's minimum and its maximum with two separate recursive calls doubles the work at every level. Write `static int[] minMax(int[] nums, int i)` (call it with `i = 0`) returning `{smallest, largest}` of `nums[i..]` for a non-empty array, with a single recursive call per level.
    // EXAMPLE: `{4, -2, 9, 0}` -> `[-2, 9]`
    // BIGO: From O(2^N) to O(N), just by keeping the one recursive result and reading both parts from it.
    static int[] minMax(int[] nums, int i) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.3 | Tilings with memoization | Core
    // PROMPT: Rewrite 71.15 as `static long tilingsMemo(int n, Map<Integer, Long> memo)`.
    // EXAMPLE: `tilingsMemo(10, new HashMap<>())` -> `28`; `tilingsMemo(60, ...)` -> `5582216355` at once
    // BIGO: O(N): each length is solved once.
    static long tilingsMemo(int n, Map<Integer, Long> memo) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.4 | Dice totals with memoization | Core
    // PROMPT: Rewrite 71.17 as `static long diceWaysMemo(int dice, int total, Map<String, Long> memo)`, keyed by `dice + "," + total`.
    // EXAMPLE: `diceWaysMemo(2, 7, new HashMap<>())` -> `6`; `(20, 70)` -> `189456975899496`
    // BIGO: O(D * T * 6) for D dice and total T: each (dice, total) pair is solved once, trying six faces.
    static long diceWaysMemo(int dice, int total, Map<String, Long> memo) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.5 | Count the calls | Practice
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

    // ==== EX 72.6 | Fewest coins, bottom-up | Stretch
    // PROMPT: Write `static int minCoins(int[] coins, int amount)` filling a table `best[0..amount]` from the bottom up. Return `-1` if the amount cannot be made.
    // EXAMPLE: `{1, 5, 10, 25}`, 63 -> `6`; `{2}`, 3 -> `-1`
    // BIGO: O(amount * number of coins) time, O(amount) space.
    // NOTE: Greedy (largest coin first) fails for coins like `{1, 3, 4}` and amount 6: greedy gives 3 coins, the answer is 2. Use `Integer.MAX_VALUE` as "impossible" only if you check it before adding 1.
    static int minCoins(int[] coins, int amount) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
