import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    // ==== EX 72.7 | Best total with no two neighbours | Core
    // PROMPT: Write `static int bestWithoutNeighbours(int[] values)` for non-negative `values`: the largest sum of values you can take with no two taken values next to each other. Walk once, keeping the best total that takes the current value and the best that skips it.
    // EXAMPLE: `[5, 1, 2, 9, 3]` -> `14` (5 + 9)
    // BIGO: O(N) time, O(1) space: the best total up to each value only needs the best totals with and without the value before it.
    static int bestWithoutNeighbours(int[] values) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.8 | Ways to make change | Core
    // PROMPT: Write `static long changeWays(int[] coins, int amount)` that counts the combinations of coins (any number of each distinct value) summing to `amount`; order does not matter and `amount = 0` has one way. Fill `ways[0..amount]` one coin value at a time.
    // EXAMPLE: `[2, 3, 5], 10` -> `4`
    // BIGO: O(C * A) time, O(A) space for C coins and amount A: looping over coins on the outside counts each combination once, in one fixed coin order.
    // NOTE: Swap the two loops and you count orderings instead: 2 + 3 and 3 + 2 become different ways.
    static long changeWays(int[] coins, int amount) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.9 | Ways to decode a digit string | Core
    // PROMPT: Letters are coded `A = 1` to `Z = 26`. Write `static int decodeWays(String digits)` that counts the ways to split `digits` into codes `1` to `26` (no code starts with `0`; the empty string has one way). The ways to read a prefix are the ways without its last digit (if that digit is not `0`) plus the ways without its last two digits (if they form 10 to 26).
    // EXAMPLE: `"1213"` -> `5`
    // BIGO: O(N) time, O(1) space: the count for a prefix depends only on the counts for the two prefixes before it.
    static int decodeWays(String digits) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.10 | Best streak | Core
    // PROMPT: Write `static int bestStreak(int[] nums)` that returns the largest sum of a non-empty run of consecutive values in non-empty `nums`. Keep the best sum of a run ending at the current value: either extend the previous run or start again here.
    // EXAMPLE: `[3, -4, 5, -1, 2, -6, 4]` -> `6` (5, -1, 2)
    // BIGO: O(N) time, O(1) space: the best run ending here either extends the best run ending one step earlier or starts fresh.
    static int bestStreak(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.11 | Grid paths around blocked cells | Core
    // PROMPT: `grid` holds non-empty strings, `.` open and `#` blocked. Write `static long gridPaths(String[] grid)` that counts the paths from the top-left to the bottom-right cell moving only right or down through open cells. Keep one row of counts and update it row by row.
    // EXAMPLE: `["...", ".#.", "..."]` -> `2`
    // BIGO: O(R*C) time, O(C) space: the paths into a cell are the paths into the cell above plus the cell to the left, so one row of counts is enough.
    static long gridPaths(String[] grid) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.12 | Edit distance | Practice
    // PROMPT: Write `static int editDistance(String a, String b)` that returns the fewest single-character insertions, deletions and replacements turning `a` into `b`. Build a table over prefixes, keeping only the previous row: matching last characters cost nothing, otherwise take 1 plus the cheapest of the three neighbours.
    // EXAMPLE: `"garden", "pardon"` -> `2`
    // BIGO: O(N*M) time, O(M) space: the cost for two prefixes comes from three smaller pairs of prefixes, all in the current or previous row.
    static int editDistance(String a, String b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.13 | Longest common subsequence | Practice
    // PROMPT: Write `static int commonSubsequenceLength(String a, String b)` that returns the length of the longest sequence of characters appearing in both strings in the same order (not necessarily next to each other). Fill a table over prefixes, one row at a time.
    // EXAMPLE: `"stone", "longest"` -> `3` (`"one"`)
    // BIGO: O(N*M) time, O(M) space: equal last characters extend the answer for both shorter prefixes; otherwise drop the last character of one side.
    static int commonSubsequenceLength(String a, String b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.14 | Longest increasing subsequence | Practice
    // PROMPT: Write `static int longestIncreasingLength(int[] nums)` that returns the length of the longest strictly increasing subsequence, in O(N log N). Keep `tails`, where `tails[k]` is the smallest last value of any increasing subsequence of length `k + 1`; each value replaces the first tail not below it (binary search), or extends the list.
    // EXAMPLE: `[4, 1, 3, 2, 8, 5, 6]` -> `4` (1, 2, 5, 6)
    // BIGO: O(N log N) time, O(N) space: `tails[k]` is the smallest possible last value of a rising run of length k + 1, so it stays sorted and binary search places each value.
    static int longestIncreasingLength(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.15 | Knapsack, each item once | Practice
    // PROMPT: Write `static int knapsack(int[] weights, int[] values, int capacity)` that returns the largest total value of items whose weights sum to at most `capacity`, using each item at most once. Keep `best[c]` for every capacity `c` and, for each item, update capacities from high to low.
    // EXAMPLE: `[3, 4, 2, 6], [30, 50, 15, 60], 8` -> `80`
    // BIGO: O(N * W) time, O(W) space for capacity W: walking capacities downward makes each item usable at most once.
    static int knapsack(int[] weights, int[] values, int capacity) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.16 | Fewest jumps to the end | Practice
    // PROMPT: From index `i` you may jump forward up to `nums[i]` places. Write `static int fewestJumps(int[] nums)` that returns the fewest jumps from index 0 to the last index, or `-1` if it cannot be reached. Walk once, tracking the end of the range reachable with the current number of jumps and the farthest index reachable with one more.
    // EXAMPLE: `[3, 1, 2, 1, 1, 4]` -> `3`
    // BIGO: O(N) time, O(1) space: treat the indices reachable in k jumps as one level of a breadth-first search, tracked by its far end.
    // NOTE: Compare 73.3, which only asks whether the end can be reached.
    static int fewestJumps(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.17 | Largest square of ones | Practice
    // PROMPT: `grid` holds equal-length strings of `0` and `1`. Write `static int largestSquare(String[] grid)` that returns the area of the largest square made only of `1`s. `side[r][c]`, the side of the largest square whose bottom-right corner is `(r, c)`, is `1 +` the minimum of its three neighbours up, left and up-left; keep one row of it.
    // EXAMPLE: `["0111", "1111", "0111"]` -> `9`
    // BIGO: O(R*C) time, O(C) space: the biggest square ending at a cell is one more than the smallest of the squares ending above, to the left and diagonally.
    static int largestSquare(String[] grid) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.18 | Can the text be split into words? | Practice
    // PROMPT: Write `static boolean canSplit(String text, String[] words)`: `true` when `text` can be cut into pieces that are all in `words` (each word reusable; the empty text can). `ok[i]` says whether the first `i` characters split; it is true when some `ok[j]` is and `text.substring(j, i)` is a word.
    // EXAMPLE: `"sunflowerfield", ["sun", "flower", "field", "sunflow", "er"]` -> `true`
    // BIGO: O(N^2) time for text length N (plus slicing), O(N) space: a prefix splits when some shorter prefix splits and the rest is a word.
    static boolean canSplit(String text, String[] words) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.19 | Fewest cuts into palindromes | Stretch
    // PROMPT: Write `static int minPalindromeCuts(String text)` that returns the fewest cuts splitting `text` into pieces that are all palindromes (`0` for empty text). Let `cuts[i]` be the answer for the first `i` characters, starting at `i - 1`; expand around every centre, and each palindrome `text[lo..hi]` offers `cuts[hi + 1] = cuts[lo] + 1`.
    // EXAMPLE: `"noonabbad"` -> `2` (noon | abba | d)
    // BIGO: O(N^2) time, O(N) space: growing every palindrome outward from its centre finds each one once, and each one offers a cheaper cut for the prefix it ends.
    static int minPalindromeCuts(String text) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 72.20 | Best profit with at most k trades | Stretch
    // PROMPT: `prices[d]` is a stock's price on day `d`. Write `static int maxProfitK(int[] prices, int k)` that returns the best profit from at most `k` trades (buy then sell, one share, no overlapping trades). For each `j` from 1 to `k`, keep `buy[j]`, the best cash after the j-th buy, and `sell[j]`, the best after the j-th sell, and update them every day.
    // EXAMPLE: `[3, 8, 2, 6, 1, 9], 2` -> `13` (3 to 8, then 1 to 9)
    // BIGO: O(N * K) time, O(K) space: for each number of trades j, track the best cash while holding (after the j-th buy) and while not holding (after the j-th sell).
    static int maxProfitK(int[] prices, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
