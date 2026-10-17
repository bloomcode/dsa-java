import java.util.ArrayList;
import java.util.List;

/** Chapter 11: Thinking recursively. */
public class Ch11WritingRecursive {

    // ==== EX 11.1 | Double every element in place | Core
    // PROMPT: Write `static int[] doubleInPlace(int[] arr, int index)` recursively, modifying the array rather than returning a new one ("repeatedly execute" category).
    // EXAMPLE: `doubleInPlace(new int[]{1, 2, 3}, 0)` -> `[2, 4, 6]`
    // BIGO: O(N).
    static int[] doubleInPlace(int[] arr, int index) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.2 | Reverse a string | Core
    // PROMPT: Write `static String reverse(String s)` top-down: assume `reverse` already works on everything after the first character.
    // EXAMPLE: `"abcde"` -> `"edcba"`
    // BIGO: O(N) calls, but each `substring` copies, so O(N^2) characters are copied in total.
    static String reverse(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.3 | Count a character | Core
    // PROMPT: Write `static int countX(String s, int i)` returning how many times `'x'` appears from index `i` on.
    // EXAMPLE: `countX("axbxcxd", 0)` -> `3`
    // BIGO: O(N). Passing an index avoids the copy that `substring(1)` would make on every call.
    static int countX(String s, int i) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.4 | Total characters across strings | Core
    // PROMPT: Write `static int totalChars(List<String> strings)` returning the sum of all string lengths, recursing on `strings.subList(1, size)`.
    // EXAMPLE: `[ab, c, def, ghij]` -> `10`
    // BIGO: O(N) in the number of strings. `subList` is a view, so unlike a slice it copies nothing.
    static int totalChars(List<String> strings) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.5 | Select the even numbers | Core
    // PROMPT: Write `static List<Integer> selectEvens(List<Integer> nums)` returning a new list of only the even numbers, recursively.
    // EXAMPLE: `[1, 2, 3, 4, 5, 6]` -> `[2, 4, 6]`
    // BIGO: O(N) calls; inserting at the front of the result shifts it, which adds up to O(N^2) in the worst case.
    static List<Integer> selectEvens(List<Integer> nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.6 | Triangular numbers | Core
    // PROMPT: Write `static long triangular(int n)` returning 1 + 2 + ... + n recursively.
    // EXAMPLE: `triangular(7)` -> `28`
    // BIGO: O(N).
    static long triangular(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.7 | Index of the first x | Core
    // PROMPT: Write `static int indexOfX(String s, int i)` returning the first index of `'x'` at or after `i`, or `-1`.
    // EXAMPLE: `indexOfX("abcdefghijklmnopqrstuvwxyz", 0)` -> `23`
    // BIGO: O(N).
    static int indexOfX(String s, int i) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.8 | The staircase problem | Practice
    // PROMPT: Write `static long staircase(int n)`: how many ways to climb n steps taking 1, 2 or 3 at a time. Think top-down: the last move was 1, 2 or 3 steps.
    // EXAMPLE: `staircase(3)` -> `4`; `staircase(5)` -> `13`
    // BIGO: About O(3^N) as written. Chapter 12 (12.3) brings it to O(N).
    static long staircase(int n) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.9 | Anagram generation | Practice
    // PROMPT: Write `static List<String> anagrams(String s)` returning every arrangement of the characters. For each anagram of `s.substring(1)`, insert `s.charAt(0)` at every position.
    // EXAMPLE: `"abc"` -> `[abc, bac, bca, acb, cab, cba]` (any order)
    // BIGO: O(N!). Six letters already give 720 results.
    static List<String> anagrams(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.10 | Unique paths through a grid | Practice
    // PROMPT: Write `static long uniquePaths(int rows, int cols)`: moving only right or down, how many paths lead from the top-left to the bottom-right cell?
    // EXAMPLE: `uniquePaths(3, 7)` -> `28`
    // BIGO: Exponential as written. Memoised in 12.4.
    static long uniquePaths(int rows, int cols) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 11.11 | All subsets | Stretch
    // PROMPT: Write `static List<List<Integer>> subsets(List<Integer> items)` returning every subset (the power set). Each subset of the rest appears once without and once with the first item.
    // EXAMPLE: `[1, 2]` -> `[[], [2], [1], [1, 2]]` (any order)
    // BIGO: O(2^N) subsets.
    static List<List<Integer>> subsets(List<Integer> items) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
