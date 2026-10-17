import java.util.ArrayList;
import java.util.List;

/** Chapter 7: Big O in day-to-day code. */
public class Ch07EverydayBigO {

    // ==== EX 7.1 | Mean of the even numbers | Core
    // PROMPT: Write `static Double meanOfEvens(int[] numbers)`. Return `null` if there are no even numbers.
    // EXAMPLE: `{1, 2, 3, 4, 6}` -> `4.0`
    // BIGO: O(N). The loop runs once per number, whatever happens inside.
    static Double meanOfEvens(int[] numbers) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.2 | Word builder, two characters | Core
    // PROMPT: Write `static List<String> twoLetterWords(char[] chars)` returning every string made of two different positions in `chars`.
    // EXAMPLE: `{'a', 'b', 'c'}` -> `[ab, ac, ba, bc, ca, cb]`
    // BIGO: O(N^2).
    static List<String> twoLetterWords(char[] chars) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.3 | Word builder, three characters | Practice
    // PROMPT: Extend to `static List<String> threeLetterWords(char[] chars)` using three distinct positions. How does the Big O change?
    // EXAMPLE: `{'a', 'b', 'c'}` -> 6 words: `abc, acb, bac, bca, cab, cba`
    // BIGO: O(N^3). Each extra nested loop over the same input adds one to the exponent.
    // NOTE: Start with `"" +` so the chars are concatenated as text. `chars[i] + chars[j]` alone adds their numeric codes and gives an int.
    static List<String> threeLetterWords(char[] chars) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.4 | Array sample | Core
    // PROMPT: Write `static int[] sample(int[] arr)` returning `{first, middle, last}` of a non-empty array.
    // EXAMPLE: `{1, 2, 3, 4, 5}` -> `[1, 3, 5]`
    // BIGO: O(1). Three reads by index, no matter how long the array is.
    static int[] sample(int[] arr) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.5 | Average Celsius reading | Core
    // PROMPT: Write `static double averageCelsius(double[] fahrenheit)` that converts each reading with (F - 32) / 1.8 into a new array, then averages it in a second loop.
    // EXAMPLE: `{32, 212}` -> `50.0`
    // BIGO: O(N). Two loops one after another are 2N steps, still O(N); only nesting multiplies.
    static double averageCelsius(double[] fahrenheit) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.6 | Clothing labels | Core
    // PROMPT: Write `static List<String> clothingLabels(List<String> items)` producing a label for every item in sizes 1 to 5.
    // EXAMPLE: `[Shirt]` -> `[Shirt Size: 1, ..., Shirt Size: 5]`
    // BIGO: O(N). The inner loop is a fixed 5, so it is 5N steps, not N^2.
    static List<String> clothingLabels(List<String> items) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.7 | Count the ones | Core
    // PROMPT: Write `static int countOnes(int[][] rows)` for a jagged array of 0s and 1s.
    // EXAMPLE: `{{0, 1, 1}, {1, 0}, {1, 1, 1, 0}}` -> `6`
    // BIGO: O(N) where N is the total number of values, even though the loops are nested.
    static int countOnes(int[][] rows) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.8 | Palindrome checker | Core
    // PROMPT: Write `static boolean isPalindrome(String s)` comparing characters from both ends inward with `charAt`.
    // EXAMPLE: `"racecar"` -> `true`; `"kayaks"` -> `false`
    // BIGO: O(N) (N/2 comparisons).
    static boolean isPalindrome(String s) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.9 | Products of all pairs | Core
    // PROMPT: Write `static List<Long> pairProducts(int[] nums)` returning the product of every unique pair (each pair once).
    // EXAMPLE: `{1, 2, 3, 4}` -> `[2, 3, 4, 6, 8, 12]`
    // BIGO: O(N^2): N(N-1)/2 pairs.
    static List<Long> pairProducts(int[] nums) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.10 | Products across two arrays | Practice
    // PROMPT: Write `static List<Long> crossProducts(int[] a, int[] b)` returning `x * y` for every x in `a` and y in `b`.
    // EXAMPLE: `{1, 2}`, `{10, 100, 1000}` -> `[10, 100, 1000, 20, 200, 2000]`
    // BIGO: O(N * M). With two different inputs, name both sizes instead of writing O(N^2).
    static List<Long> crossProducts(int[] a, int[] b) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 7.11 | Password cracker | Practice
    // PROMPT: Write `static List<String> allPasswords(int length, String alphabet)` that returns every string of that length, in order, by extending each shorter password with every letter.
    // EXAMPLE: `allPasswords(2, "ab")` -> `[aa, ab, ba, bb]`
    // BIGO: O(26^N) for the full alphabet. Exponential: each extra character multiplies the work by the alphabet size.
    static List<String> allPasswords(int length, String alphabet) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
