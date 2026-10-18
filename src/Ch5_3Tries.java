import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/** Chapter 5.3: Tries. */
public class Ch5_3Tries {

    // ==== EX 5.3.1 | Trie node and insertion | Core
    // PROMPT: Create `static class TrieNode` with a `LinkedHashMap<Character, TrieNode> children` and a `boolean end`, and `static class Trie` with a `root`. Write `void insert(String word)` that walks or creates one child per character, then marks the last node as the end of a word.
    // EXAMPLE: insert "pin", "pit" -> root has one child `'p'`, whose `'i'` child has children `'n'` and `'t'`
    // BIGO: O(K) for a K-character word, regardless of how many words are stored.
    // NOTE: The `boolean end` flag marks where a word ends. `LinkedHashMap` keeps children in insertion order so results are predictable.
    static class TrieNode {
        final Map<Character, TrieNode> children = new LinkedHashMap<>();
        boolean end;
        int popularity;
    }

    static class Trie {
        final TrieNode root = new TrieNode();

        void insert(String word) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.3.2 | Search a prefix | Core | class=Trie
        // PROMPT: Add `TrieNode search(String prefix)` returning the node where the prefix ends, or `null` if it is not in the trie.
        // EXAMPLE: After "pin" -> `search("pi")` is a node; `search("po")` is `null`
        // BIGO: O(K).
        TrieNode search(String prefix) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.3.3 | Is it a whole word? | Core | class=Trie
        // PROMPT: Add `boolean containsWord(String word)`: the prefix must exist and its node must be marked as an end.
        // EXAMPLE: After "pin" -> `containsWord("pin")` is `true`, `containsWord("pi")` is `false`
        // BIGO: O(K).
        boolean containsWord(String word) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.3.4 | Collect every word | Core | class=Trie
        // PROMPT: Add `List<String> collectAllWords(TrieNode node)` that recursively gathers every word below `node`, building each word in a `StringBuilder` that you append to and trim back.
        // EXAMPLE: After "pin", "pit", "sun" -> `collectAllWords(root)` is `[pin, pit, sun]`
        // BIGO: O(M) nodes beneath the starting node (plus the length of the words copied out).
        List<String> collectAllWords(TrieNode node) {
            throw new UnsupportedOperationException();
        }

        private void collect(TrieNode node, StringBuilder word, List<String> words) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.3.5 | Autocomplete | Core | class=Trie
        // PROMPT: Add `List<String> autocomplete(String prefix)`: search to the prefix's node, collect the words below it and prepend the prefix.
        // EXAMPLE: Words "pin", "pinch", "pit", "sun" -> `autocomplete("pin")` -> `[pin, pinch]`
        // BIGO: O(K + M): reach the prefix, then visit only the matching subtree.
        List<String> autocomplete(String prefix) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.3.6 | Print every key | Practice | class=Trie
        // PROMPT: Add `List<Character> allKeys()` returning every character stored in the trie, depth first.
        // EXAMPLE: After "pie", "pin" -> `[p, i, e, n]`
        // BIGO: O(M) nodes.
        List<Character> allKeys() {
            throw new UnsupportedOperationException();
        }

        private void keys(TrieNode node, List<Character> keys) {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.3.7 | Longest prefix every word shares | Practice | class=Trie
        // PROMPT: Add `String longestCommonPrefix()`: walk down from the root while the current node has exactly one child and no word ends there, collecting the characters. Return `""` for an empty trie.
        // EXAMPLE: Words "pine", "pint", "pinto" -> `"pin"`; words "pin", "pinch" -> `"pin"`
        // BIGO: O(P) where P is the length of the shared prefix: only one path is ever walked.
        String longestCommonPrefix() {
            throw new UnsupportedOperationException();
        }
        // ==== END

        // ==== EX 5.3.9 | Delete a word | Stretch | class=Trie
        // PROMPT: Add `boolean delete(String word)` that clears the end flag and prunes nodes that no longer lead to any word. Return `true` if the word was present.
        // EXAMPLE: Words "pin", "pinch" -> delete "pinch" -> "pin" still found, the c-h nodes are gone
        // BIGO: O(K).
        boolean delete(String word) {
            throw new UnsupportedOperationException();
        }
        // ==== END
    }

    // ==== EX 5.3.8 | Tries with values: ranked autocomplete | Practice
    // PROMPT: Build `static class RankedTrie extends Trie` whose `insert(String word, int popularity)` stores the popularity on the end node. Add `List<String> autocomplete(String prefix, int limit)` returning the most popular completions first.
    // EXAMPLE: (pinch, 9), (pin, 5), (pinball, 7) -> `autocomplete("pin", 2)` -> `[pinch, pinball]`
    // BIGO: O(K + M + R log R) to collect and sort R matches.
    static class RankedTrie extends Trie {
        void insert(String word, int popularity) {
            throw new UnsupportedOperationException();
        }

        List<String> autocomplete(String prefix, int limit) {
            throw new UnsupportedOperationException();
        }

        private void rank(TrieNode node, StringBuilder word, List<Map.Entry<String, Integer>> out) {
            throw new UnsupportedOperationException();
        }
    }
    // ==== END

    /** Trie node for 5.3.10-5.3.16: `next` maps a letter to a child in letter order, `passes` counts the words through it, `ends` the words ending at it. */
    static class WordNode {
        final TreeMap<Character, WordNode> next = new TreeMap<>();
        int passes, ends;
    }

    /** Build a `WordNode` trie holding `words`, repeats counted. */
    static WordNode wordTrie(String... words) {
        WordNode root = new WordNode();
        for (String word : words) {
            WordNode node = root;
            node.passes++;
            for (char ch : word.toCharArray()) {
                node = node.next.computeIfAbsent(ch, k -> new WordNode());
                node.passes++;
            }
            node.ends++;
        }
        return root;
    }

    // ==== EX 5.3.10 | Count the words under each prefix | Core
    // PROMPT: Write `static int[] prefixCounts(String[] words, String[] prefixes)` that returns, for each prefix, how many of `words` (repeats included) start with it. Use the `wordTrie(words)` helper: each `WordNode` has `next` (a `TreeMap`, letter -> child), `passes` and `ends`. Walk each prefix down from the root and read `passes`.
    // EXAMPLE: `["car", "card", "care", "dog"], ["car", "ca", "d", "x"]` -> `[3, 3, 1, 0]`
    // BIGO: O(total letters) to build, then O(K) per prefix of length K: the node at the end of the prefix already counts every word passing through it.
    static int[] prefixCounts(String[] words, String[] prefixes) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.3.11 | Sort words with a trie | Core
    // PROMPT: Write `static List<String> trieSort(String[] words)` that returns `words` in dictionary order, repeats kept, by walking a trie: emit a node's word `ends` times, then visit its children in letter order. Use the `wordTrie(words)` helper: each `WordNode` has `next` (a `TreeMap`, letter -> child), `passes` and `ends`.
    // EXAMPLE: `["pear", "apple", "pea", "app"]` -> `["app", "apple", "pea", "pear"]`
    // BIGO: O(total letters) plus the sort of each node's children: a pre-order walk that takes children in letter order meets the words in dictionary order.
    static List<String> trieSort(String[] words) {
        throw new UnsupportedOperationException();
    }

    static void walkInOrder(WordNode node, StringBuilder path, List<String> out) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.3.12 | Wildcard search | Practice
    // PROMPT: Write `static List<String> wildcardMatches(String[] words, String pattern)` that returns, in dictionary order and without repeats, the words matching `pattern`, where `.` matches any one letter. Walk the trie: a letter follows one child, a dot tries every child in letter order. Use the `wordTrie(words)` helper: each `WordNode` has `next` (a `TreeMap`, letter -> child), `passes` and `ends`.
    // EXAMPLE: `["bad", "bed", "bid", "bud", "bead"], "b.d"` -> `["bad", "bed", "bid", "bud"]`
    // BIGO: O(26^D * K) worst case for D dots in a pattern of length K, far less in practice: each dot branches only into children that exist.
    static List<String> wildcardMatches(String[] words, String pattern) {
        throw new UnsupportedOperationException();
    }

    static void matchFrom(WordNode node, String pattern, int i, StringBuilder path, List<String> out) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.3.13 | Substring check with a suffix trie | Practice
    // PROMPT: Write `static boolean[] substringChecks(String text, String[] queries)` that returns, for each query, whether it occurs in `text` (the empty string always does). Put every suffix of `text` in a trie, then walk each query from the root. Use the `wordTrie(words)` helper: each `WordNode` has `next` (a `TreeMap`, letter -> child), `passes` and `ends`.
    // EXAMPLE: `"banana", ["nan", "ana", "nab", ""]` -> `[true, true, false, true]`
    // BIGO: O(N^2) time and space to build for a text of length N, then O(M) per query of length M: every substring is a prefix of some suffix.
    // NOTE: Suffix trees and suffix arrays get the build down to O(N) or O(N log N); the query idea is the same.
    static boolean[] substringChecks(String text, String[] queries) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.3.14 | Shortest unique prefixes | Practice
    // PROMPT: `words` are distinct and none is a prefix of another. Write `static List<String> shortestUniquePrefixes(String[] words)` that returns, for each word in order, its shortest non-empty prefix that no other word starts with. Walk each word down until a node is passed by one word only. Use the `wordTrie(words)` helper: each `WordNode` has `next` (a `TreeMap`, letter -> child), `passes` and `ends`.
    // EXAMPLE: `["zebra", "dog", "duck", "dove"]` -> `["z", "dog", "du", "dov"]`
    // BIGO: O(total letters) time and space: the `passes` count on each node says at once whether any other word shares the prefix so far.
    static List<String> shortestUniquePrefixes(String[] words) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.3.15 | Keypad words | Practice
    // PROMPT: On a phone keypad, `2` is `abc`, `3` `def`, `4` `ghi`, `5` `jkl`, `6` `mno`, `7` `pqrs`, `8` `tuv` and `9` `wxyz`. Write `static List<String> keypadWords(String digits, String[] words)` that returns, in dictionary order, the words from `words` whose letters type exactly `digits`. Walk the trie, trying each letter of the current digit. Use the `wordTrie(words)` helper: each `WordNode` has `next` (a `TreeMap`, letter -> child), `passes` and `ends`.
    // EXAMPLE: `"4663", ["good", "home", "gone", "hood", "hoof", "in"]` -> `["gone", "good", "home", "hood", "hoof"]`
    // BIGO: O(4^K) worst case for K digits, usually far less: the trie cuts off every letter sequence that starts no word.
    static List<String> keypadWords(String digits, String[] words) {
        throw new UnsupportedOperationException();
    }

    static void spell(WordNode node, String digits, String[] keys, int i, StringBuilder path, List<String> out) {
        throw new UnsupportedOperationException();
    }
    // ==== END

    // ==== EX 5.3.16 | Words on a letter board | Stretch
    // PROMPT: `board` holds equal-length strings. A word can be traced by starting on any cell and stepping to any of the 8 neighbouring cells, using each cell at most once. Write `static List<String> boardWords(String[] board, String[] words)` that returns, sorted and without repeats, the words from `words` that can be traced. Start a depth-first walk from every cell, following the trie in step with the path. Use the `wordTrie(words)` helper: each `WordNode` has `next` (a `TreeMap`, letter -> child), `passes` and `ends`.
    // EXAMPLE: `["cat", "ore", "bin"]`, `["car", "cat", "core", "tea", "rat", "bin", "rob", "cab", "tin", "ore", "rare"]` -> `["bin", "car", "cat", "core", "ore", "rat", "rob", "tea"]`
    // BIGO: O(R * C * 8^L) worst case for words up to length L, in practice far less: the walk stops as soon as the path so far starts no word.
    static List<String> boardWords(String[] board, String[] words) {
        throw new UnsupportedOperationException();
    }

    static void traceFrom(String[] board, int r, int c, WordNode node, StringBuilder path, boolean[][] used, Set<String> found) {
        throw new UnsupportedOperationException();
    }
    // ==== END
}
