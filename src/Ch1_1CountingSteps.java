import java.util.ArrayList;
import java.util.List;

/** Chapter 1.1: Counting steps: how cost grows with input. */
public class Ch1_1CountingSteps {

    // ==== EX 1.1.1 | An O(1) algorithm | Core
    // PROMPT: Write `static boolean isLeapYear(int year)`. Explain why its step count does not depend on the input's size.
    // EXAMPLE: `isLeapYear(2024)` -> `true`; `1900` -> `false`; `2000` -> `true`
    // BIGO: O(1). At most three checks, whatever the year.
    static boolean isLeapYear(int year) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.2 | An O(N) algorithm | Core
    // PROMPT: Write `static long arraySum(int[] arr)` with a loop (no streams), and say how many steps it takes for N elements.
    // EXAMPLE: `{1, 2, 3, 4}` -> `10`, 4 loop steps
    // BIGO: O(N). One step per element. Return `long`: a million ints near 2^31 overflow an `int` total.
    static long arraySum(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.3 | An O(log N) algorithm | Core
    // PROMPT: Write `static int halvingSteps(long n)` returning how many times you can halve `n` (integer division) before it reaches 1.
    // EXAMPLE: `halvingSteps(8)` -> `3`; `halvingSteps(1024)` -> `10`; `halvingSteps(1)` -> `0`
    // BIGO: O(log N). This is the definition of log2 N for powers of two.
    static int halvingSteps(long n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.4 | Doubling: rounds until everyone knows | Practice
    // PROMPT: One person knows a rumour. Each round, everyone who knows tells one person who does not. Write `static int roundsToReach(long people)` returning how many rounds pass before at least `people` know.
    // EXAMPLE: `roundsToReach(1)` -> `0`; `roundsToReach(2)` -> `1`; `roundsToReach(1000)` -> `10`
    // BIGO: O(log N). The number who know doubles each round, the mirror image of halving.
    static int roundsToReach(long people) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.5 | Count nested-loop steps | Practice
    // PROMPT: Write `static long allPairsSteps(int n)` (inner loop runs N times per outer step) and `static long uniquePairsSteps(int n)` (inner loop starts at `i + 1`). Both return the number of inner-loop iterations. Classify both.
    // EXAMPLE: `allPairsSteps(4)` -> `16`; `uniquePairsSteps(4)` -> `6`
    // BIGO: Both O(N^2). Unique pairs is N(N-1)/2, about half, and Big O ignores the 1/2.
    static long allPairsSteps(int n) {
        throw new UnsupportedOperationException();
    }

    static long uniquePairsSteps(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.6 | Running balance with no overdraft | Core
    // PROMPT: Write `static int finalBalance(int[] changes)`: start at 0 and apply each deposit (positive) or withdrawal (negative) in order, skipping any withdrawal that would take the balance below 0.
    // EXAMPLE: `{50, -20, -40, 10}` -> `40`
    // BIGO: O(N). One pass, and each step does a constant amount of work.
    static int finalBalance(int[] changes) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.7 | Every pairing from a list | Core
    // PROMPT: Write `static List<String> pairings(String[] names)` returning `"a-b"` for every pair of positions `i < j`, in that order.
    // EXAMPLE: `{"ana", "bo", "cy"}` -> `[ana-bo, ana-cy, bo-cy]`
    // BIGO: O(N^2): N(N-1)/2 pairings, each built once.
    static List<String> pairings(String[] names) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.8 | Committees of three | Practice
    // PROMPT: Extend the idea to `static List<String> committees(String[] names)`: every choice of three positions `i < j < k`, written `"a,b,c"`, in that order. How does the Big O change?
    // EXAMPLE: `{"a", "b", "c", "d"}` -> `[a,b,c, a,b,d, a,c,d, b,c,d]`
    // BIGO: O(N^3): about N^3/6 committees. Each extra nested loop over the same input adds one to the exponent.
    static List<String> committees(String[] names) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.9 | The newest entries of a log | Core
    // PROMPT: Write `static List<String> newest(List<String> lines, int k)` returning the last `k` lines in their original order (all of them if there are fewer), reading by index rather than walking the whole list.
    // EXAMPLE: `[a, b, c, d], 2` -> `[c, d]`
    // BIGO: O(k), not O(N). Reading by index jumps straight to the end, so the length of the log does not matter.
    static List<String> newest(List<String> lines, int k) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.10 | Busiest hour of the day | Core
    // PROMPT: Write `static int busiestHour(String[] times)` for a non-empty array of `"HH:MM"` strings, returning the hour with the most entries; on a tie, the earliest hour.
    // EXAMPLE: `{"09:15", "10:02", "09:40", "11:00"}` -> `9`
    // BIGO: O(N). One pass counts into 24 slots, then a fixed 24-step scan; a constant amount of extra work does not change the class.
    static int busiestHour(String[] times) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.11 | A week of slots per person | Core
    // PROMPT: Write `static List<String> weeklySlots(String[] names)` returning `"<name> <day>"` for every name and each of `Mon` to `Sun`, name by name.
    // EXAMPLE: `{"ana"}` -> `[ana Mon, ana Tue, ana Wed, ana Thu, ana Fri, ana Sat, ana Sun]`
    // BIGO: O(N). The inner loop always runs 7 times, so it is 7N steps, not N^2.
    static final String[] DAYS = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    static List<String> weeklySlots(String[] names) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.12 | Vowels across a document | Core
    // PROMPT: Write `static int countVowels(String[] lines)` counting the vowels `aeiou`, in either case, across an array of strings.
    // EXAMPLE: `{"Hello", "World"}` -> `3`
    // BIGO: O(C) where C is the total number of characters. The loops are nested, but together they visit each character once.
    static int countVowels(String[] lines) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.13 | Is the grid symmetric? | Core
    // PROMPT: Write `static boolean isSymmetric(int[][] grid)` for a square grid: `true` when `grid[i][j] == grid[j][i]` everywhere. Compare each pair of cells once.
    // EXAMPLE: `{{1, 2}, {2, 1}}` -> `true`; `{{1, 2}, {3, 1}}` -> `false`
    // BIGO: O(N^2) for an N x N grid. Checking only above the diagonal halves the work, and Big O ignores the half.
    static boolean isSymmetric(int[][] grid) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.14 | Closest pair of readings | Core
    // PROMPT: Write `static int closestGap(int[] nums)` for at least two numbers, returning the smallest absolute difference between any two of them, by comparing every pair.
    // EXAMPLE: `{10, 4, 15, 7}` -> `3`
    // BIGO: O(N^2): every pair is compared once.
    // NOTE: Sorting first brings this to O(N log N) (3.2.4).
    static int closestGap(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.15 | Free hours two people share | Practice
    // PROMPT: Write `static List<Integer> sharedHours(int[] a, int[] b)` returning the hours in `a` that also appear in `b`, in `a`'s order, using nested loops.
    // EXAMPLE: `{9, 10, 13, 15}`, `{10, 11, 15}` -> `[10, 15]`
    // BIGO: O(N * M) with nested loops. With two different inputs, name both sizes instead of writing O(N^2).
    // NOTE: Putting one list in a hash set makes it O(N + M) (Chapter 4.1).
    static List<Integer> sharedHours(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 1.1.16 | Every on/off switch setting | Practice
    // PROMPT: Write `static List<String> switchSettings(int n)` returning every setting of `n` on/off switches as a string of `'0'` and `'1'`, in increasing binary order. Build the strings yourself rather than with a formatting helper.
    // EXAMPLE: `switchSettings(2)` -> `[00, 01, 10, 11]`
    // BIGO: O(2^N): each extra switch doubles the number of settings (and each setting takes N characters to write).
    static List<String> switchSettings(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
