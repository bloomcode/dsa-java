import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Chapter 71: Recursion. */
public class Ch71Recursion {

    // ==== EX 71.1 | Count the digits | Core
    // PROMPT: Write `static int digitCount(long n)` for `n >= 0` recursively: a number below 10 has one digit; otherwise it has one more digit than `n / 10`.
    // EXAMPLE: `digitCount(12345)` -> `5`; `digitCount(0)` -> `1`
    // BIGO: O(log N) calls: one per digit.
    static int digitCount(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.2 | Factorial | Core
    // PROMPT: Write `static long factorial(int n)` recursively.
    // EXAMPLE: `factorial(5)` -> `120`; `factorial(0)` -> `1`; `factorial(20)` -> `2432902008176640000`
    // BIGO: O(N).
    // NOTE: 20! is the largest factorial that fits in a `long`; 13! already overflows an `int`. Use `BigInteger` beyond that.
    static long factorial(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.3 | Sum an array recursively | Core
    // PROMPT: Write `static long sumRecursive(int[] arr, int index)` that sums from `index` to the end. Pass an index instead of copying the array on every call.
    // EXAMPLE: `sumRecursive(new int[]{1, 2, 3, 4}, 0)` -> `10`
    // BIGO: O(N) time and stack depth. Copying with `Arrays.copyOfRange` on each call would add hidden O(N) work per call.
    static long sumRecursive(int[] arr, int index) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.4 | Depth of nesting | Core
    // PROMPT: Write `static int maxDepth(List<?> nested)` for a list whose items are numbers or further lists: a list with no lists inside has depth 1, and each level of nesting adds one.
    // EXAMPLE: `[1, [2, [3]], 4]` -> `3`; `[]` -> `1`
    // BIGO: O(N) in the total number of items and lists. Recursion fits because the depth is unknown in advance.
    static int maxDepth(List<?> nested) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.5 | Fast power | Practice
    // PROMPT: Write `static long power(long x, int n)` for `n >= 0` by squaring: x^n = (x^(n/2))^2, times x if n is odd.
    // EXAMPLE: `power(2, 10)` -> `1024`; `power(3, 0)` -> `1`
    // BIGO: O(log N): each call halves n.
    static long power(long x, int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.6 | Headcount of an org chart | Core
    // PROMPT: Using `record Person(String name, List<Person> reports)`, write `static int headcount(Person person)` counting that person and everyone below them.
    // EXAMPLE: ana -> [bo, cy -> [di]] -> `4`
    // BIGO: O(N) in the number of people: each person is visited once.
    record Person(String name, List<Person> reports) {}

    static int headcount(Person person) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.7 | Binary digits, recursively | Core
    // PROMPT: Write `static String toBinary(int n)` for `n >= 0` returning its base-2 digits: below 2 it is the digit itself; otherwise it is `toBinary(n / 2)` followed by the last bit.
    // EXAMPLE: `toBinary(5)` -> `"101"`; `toBinary(0)` -> `"0"`
    // BIGO: O(log N) calls: each one halves n.
    static String toBinary(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.8 | Running totals in place | Core
    // PROMPT: Write `static int[] runningTotals(int[] arr, int i)` (call it with `i = 1`) that replaces each element with the sum of itself and everything before it, recursively and in place, and returns `arr`.
    // EXAMPLE: `{1, 2, 3, 4}` -> `[1, 3, 6, 10]`
    // BIGO: O(N) time and call-stack depth.
    static int[] runningTotals(int[] arr, int i) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.9 | Palindrome check by indexes | Core
    // PROMPT: Write `static boolean isPalindromeRec(String s, int lo, int hi)` (call it with `0` and `s.length() - 1`): compare the two ends, then recurse on the part between them by moving the indexes inward.
    // EXAMPLE: `"level"` -> `true`; `"levels"` -> `false`
    // BIGO: O(N): N/2 calls, and no copies because the indexes move instead of the string being sliced.
    static boolean isPalindromeRec(String s, int lo, int hi) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.10 | Sum of the digits | Core
    // PROMPT: Write `static int digitSum(long n)` for `n >= 0` recursively: the last digit plus the digit sum of `n / 10`.
    // EXAMPLE: `digitSum(9045)` -> `18`; `digitSum(0)` -> `0`
    // BIGO: O(log N) calls: one per digit.
    static int digitSum(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.11 | Longest word, recursively | Core
    // PROMPT: Write `static String longestWord(String[] words, int i)` (call it with `i = 0`) returning the longest word from position `i` on (the earliest one on a tie, `""` for none): compare `words[i]` with the longest word of the rest.
    // EXAMPLE: `{"go", "java", "py", "rust"}` -> `"java"`
    // BIGO: O(N) calls, one per word.
    static String longestWord(String[] words, int i) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.12 | Collapse repeated neighbours | Core
    // PROMPT: Write `static List<Integer> collapseRuns(int[] nums, int i)` (call it with `i = 0`) returning `nums` with each run of equal neighbours reduced to one value, recursively: keep `nums[i]` unless the next value equals it.
    // EXAMPLE: `{1, 1, 2, 2, 2, 3, 1}` -> `[1, 2, 3, 1]`
    // BIGO: O(N) calls. Building each result by joining one value onto a new list copies, so O(N^2) values are copied in total.
    static List<Integer> collapseRuns(int[] nums, int i) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.13 | Collatz steps | Core
    // PROMPT: Write `static int collatzSteps(long n)` for `n >= 1`: 0 steps from 1; otherwise one step to `n / 2` (n even) or `3n + 1` (n odd), plus the steps from there.
    // EXAMPLE: `collatzSteps(6)` -> `8`; `collatzSteps(1)` -> `0`
    // BIGO: No known bound in terms of N: each call does O(1) work, so the cost is the number of steps itself.
    static int collatzSteps(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.14 | Greatest common divisor | Core
    // PROMPT: Write `static long gcd(long a, long b)` for `a, b >= 0` (not both 0) recursively: `gcd(a, 0)` is `a`; otherwise it equals `gcd(b, a % b)`.
    // EXAMPLE: `gcd(48, 18)` -> `6`; `gcd(7, 0)` -> `7`
    // BIGO: O(log(min(a, b))) calls: the remainders shrink at least as fast as the Fibonacci numbers grow.
    static long gcd(long a, long b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.15 | Tiling a path with short and long tiles | Practice
    // PROMPT: A path of length `n` is covered with tiles of length 1 and 3, in order. Write `static long tilings(int n)` counting the ways: the first tile is either short (leaving `n - 1`) or long (leaving `n - 3`).
    // EXAMPLE: `tilings(4)` -> `3`; `tilings(10)` -> `28`
    // BIGO: About O(1.47^N) as written: the two calls overlap. Chapter 72 (72.3) brings it to O(N).
    static long tilings(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.16 | Every balanced bracket string | Practice
    // PROMPT: Write `static List<String> parenStrings(int n)` returning every string of `n` `'('` and `n` `')'` that is balanced. Build them one character at a time: add `'('` while fewer than `n` are open, and `')'` while it closes something.
    // EXAMPLE: `parenStrings(2)` -> `[(()), ()()]`
    // BIGO: Exponential: the number of results follows the Catalan numbers (1, 2, 5, 14, 42, ...), roughly 4^N.
    static List<String> parenStrings(int n) {
        throw new UnsupportedOperationException();
    }

    static void buildParens(String prefix, int opened, int closed, int n, List<String> out) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.17 | Ways to roll a total with dice | Practice
    // PROMPT: Write `static long diceWays(int dice, int total)` counting the ordered ways `dice` six-sided dice can add up to `total`: zero dice make 0 one way; otherwise try each face 1 to 6 for the first die and count the ways for the rest.
    // EXAMPLE: `diceWays(2, 7)` -> `6`; `diceWays(1, 7)` -> `0`
    // BIGO: O(6^D) as written for D dice. Memoized in 72.4.
    static long diceWays(int dice, int total) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 71.18 | All subsets | Stretch
    // PROMPT: Write `static List<List<Integer>> subsets(List<Integer> items)` returning every subset (the power set). Each subset of the rest appears once without and once with the first item.
    // EXAMPLE: `[1, 2]` -> `[[], [2], [1], [1, 2]]` (any order)
    // BIGO: O(2^N) subsets.
    static List<List<Integer>> subsets(List<Integer> items) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
